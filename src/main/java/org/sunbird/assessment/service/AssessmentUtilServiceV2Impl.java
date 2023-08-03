package org.sunbird.assessment.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.sunbird.cassandra.utils.CassandraOperation;
import org.sunbird.common.service.OutboundRequestHandlerServiceImpl;
import org.sunbird.common.util.CbExtServerProperties;
import org.sunbird.common.util.Constants;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AssessmentUtilServiceV2Impl implements AssessmentUtilServiceV2 {

	@Autowired
	CbExtServerProperties serverProperties;

	@Autowired
	OutboundRequestHandlerServiceImpl outboundRequestHandlerService;

	@Autowired
	ObjectMapper mapper;

	@Autowired
	CassandraOperation cassandraOperation;

	private Logger logger = LoggerFactory.getLogger(AssessmentUtilServiceV2Impl.class);

	public Map<String, Object> validateQumlAssessment(List<String> originalQuestionList,
			List<Map<String, Object>> userQuestionList) {
		try {
			Integer correct = 0;
			Integer blank = 0;
			Integer inCorrect = 0;
			Double result;
			Integer total = 0;
			Map<String, Object> resultMap = new HashMap<>();
			Map<String, Object> answers = getQumlAnswers(originalQuestionList);
			for (Map<String, Object> question : userQuestionList) {
				List<String> marked = new ArrayList<>();
				if (question.containsKey(Constants.QUESTION_TYPE)) {
					String questionType = ((String) question.get(Constants.QUESTION_TYPE)).toLowerCase();
					Map<String, Object> editorStateObj = (Map<String, Object>) question.get(Constants.EDITOR_STATE);
					List<Map<String, Object>> options = (List<Map<String, Object>>) editorStateObj
							.get(Constants.OPTIONS);
					switch (questionType) {
						case Constants.MTF:
							for (Map<String, Object> option : options) {
								marked.add(option.get(Constants.INDEX).toString() + "-"
										+ option.get(Constants.SELECTED_ANSWER).toString().toLowerCase());
							}
							break;
						case Constants.FTB:
							for (Map<String, Object> option : options) {
								marked.add((String) option.get(Constants.SELECTED_ANSWER));
							}
							break;
						case Constants.MCQ_SCA:
						case Constants.MCQ_MCA:
							for (Map<String, Object> option : options) {
								if ((boolean) option.get(Constants.SELECTED_ANSWER)) {
									marked.add((String) option.get(Constants.INDEX));
								}
							}
							break;
						default:
							break;
					}
				}
				if (CollectionUtils.isEmpty(marked))
					blank++;
				else {
					List<String> answer = (List<String>) answers.get(question.get(Constants.IDENTIFIER));
					if (answer.size() > 1)
						Collections.sort(answer);
					if (marked.size() > 1)
						Collections.sort(marked);
					if (answer.equals(marked))
						correct++;
					else
						inCorrect++;
				}
			}
			// Increment the blank counter for skipped question objects
			if (answers.size() > userQuestionList.size()) {
				blank += answers.size() - userQuestionList.size();
			}
			total = correct + blank + inCorrect;
			resultMap.put(Constants.RESULT, ((correct * 100d) / total));
			resultMap.put(Constants.INCORRECT, inCorrect);
			resultMap.put(Constants.BLANK, blank);
			resultMap.put(Constants.CORRECT, correct);
			resultMap.put(Constants.TOTAL, total);
			return resultMap;

		} catch (Exception ex) {
			logger.error("Error when verifying assessment. Error : ", ex);
		}
		return new HashMap<>();
	}

	private Map<String, Object> getQumlAnswers(List<String> questions) throws Exception {
		Map<String, Object> ret = new HashMap<>();

		Map<String, Map<String, Object>> questionMap = new HashMap<String, Map<String, Object>>();

		for (String questionId : questions) {
			List<String> correctOption = new ArrayList<>();
			questionMap = fetchQuestionMapDetails(questionId);
			Map<String, Object> question = questionMap.get(questionId);
			if (question.containsKey(Constants.QUESTION_TYPE)) {
				String questionType = ((String) question.get(Constants.QUESTION_TYPE)).toLowerCase();
				Map<String, Object> editorStateObj = (Map<String, Object>) question.get(Constants.EDITOR_STATE);
				List<Map<String, Object>> options = (List<Map<String, Object>>) editorStateObj.get(Constants.OPTIONS);
				switch (questionType) {
					case Constants.MTF:
						for (Map<String, Object> option : options) {
							Map<String, Object> valueObj = (Map<String, Object>) option.get(Constants.VALUE);
							correctOption.add(valueObj.get(Constants.VALUE).toString() + "-"
									+ option.get(Constants.ANSWER).toString().toLowerCase());
						}
						break;
					case Constants.FTB:
						for (Map<String, Object> option : options) {
							if ((boolean) option.get(Constants.ANSWER)) {
								Map<String, Object> valueObj = (Map<String, Object>) option.get(Constants.VALUE);
								correctOption.add(valueObj.get(Constants.BODY).toString());
							}
						}
						break;
					case Constants.MCQ_SCA:
					case Constants.MCQ_MCA:
						for (Map<String, Object> option : options) {
							if ((boolean) option.get(Constants.ANSWER)) {
								Map<String, Object> valueObj = (Map<String, Object>) option.get(Constants.VALUE);
								correctOption.add(valueObj.get(Constants.VALUE).toString());
							}
						}
						break;
					default:
						break;
				}
			} else {
				for (Map<String, Object> options : (List<Map<String, Object>>) question.get(Constants.OPTIONS)) {
					if ((boolean) options.get(Constants.IS_CORRECT))
						correctOption.add(options.get(Constants.OPTION_ID).toString());
				}
			}
			ret.put(question.get(Constants.IDENTIFIER).toString(), correctOption);
		}

		return ret;
	}

	private Map<String, Map<String, Object>> fetchQuestionMapDetails(String questionId) {
		// Taking the list which was formed with the not found values in Redis, we are
		// making an internal POST call to Question List API to fetch the details
		Map<String, Map<String, Object>> questionsMap = new HashMap<>();
		List<Map<String, Object>> questionMapList = readQuestionDetails(Collections.singletonList(questionId));
		for (Map<String, Object> questionMapResponse : questionMapList) {
			if (!ObjectUtils.isEmpty(questionMapResponse)
					&& Constants.OK.equalsIgnoreCase((String) questionMapResponse.get(Constants.RESPONSE_CODE))) {
				List<Map<String, Object>> questionMap = ((List<Map<String, Object>>) ((Map<String, Object>) questionMapResponse
						.get(Constants.RESULT)).get(Constants.QUESTIONS));
				for (Map<String, Object> question : questionMap) {
					if (!ObjectUtils.isEmpty(questionMap)) {
						questionsMap.put((String) question.get(Constants.IDENTIFIER), question);
					}
				}
			}
		}
		return questionsMap;
	}

	@Override
	public String fetchQuestionIdentifierValue(List<String> identifierList, List<Object> questionList,
			String primaryCategory)
			throws Exception {
		List<String> newIdentifierList = new ArrayList<>();
		newIdentifierList.addAll(identifierList);
		String errMsg = "";

		// Taking the list which was formed with the not found values in Redis, we are
		// making an internal POST call to Question List API to fetch the details
		if (!newIdentifierList.isEmpty()) {
			List<Map<String, Object>> questionMapList = readQuestionDetails(newIdentifierList);
			for (Map<String, Object> questionMapResponse : questionMapList) {
				if (!ObjectUtils.isEmpty(questionMapResponse)
						&& Constants.OK.equalsIgnoreCase((String) questionMapResponse.get(Constants.RESPONSE_CODE))) {
					List<Map<String, Object>> questionMap = ((List<Map<String, Object>>) ((Map<String, Object>) questionMapResponse
							.get(Constants.RESULT)).get(Constants.QUESTIONS));
					for (Map<String, Object> question : questionMap) {
						if (!ObjectUtils.isEmpty(questionMap)) {
							questionList.add(filterQuestionMapDetail(question, primaryCategory));
						} else {
							errMsg = String.format("Failed to get Question Details for Id: %s",
									question.get(Constants.IDENTIFIER).toString());
							logger.error(errMsg);
							return errMsg;
						}
					}
				} else {
					errMsg = String.format("Failed to get Question Details from the Question List API for the IDs: %s",
									newIdentifierList.toString());
					logger.error(errMsg);
					return errMsg;
				}
			}
		}
		return "";
	}

	@Override
	public Map<String, Object> filterQuestionMapDetail(Map<String, Object> questionMapResponse,
			String primaryCategory) {
		List<String> questionParams = serverProperties.getAssessmentQuestionParams();
		Map<String, Object> updatedQuestionMap = new HashMap<>();
		for (String questionParam : questionParams) {
			if (questionMapResponse.containsKey(questionParam)) {
				updatedQuestionMap.put(questionParam, questionMapResponse.get(questionParam));
			}
		}
		if (questionMapResponse.containsKey(Constants.EDITOR_STATE)
				&& primaryCategory.equalsIgnoreCase(Constants.PRACTICE_QUESTION_SET)) {
			Map<String, Object> editorState = (Map<String, Object>) questionMapResponse.get(Constants.EDITOR_STATE);
			updatedQuestionMap.put(Constants.EDITOR_STATE, editorState);
		}
		if (questionMapResponse.containsKey(Constants.CHOICES)
				&& updatedQuestionMap.containsKey(Constants.PRIMARY_CATEGORY) && !updatedQuestionMap
						.get(Constants.PRIMARY_CATEGORY).toString().equalsIgnoreCase(Constants.FTB_QUESTION)) {
			Map<String, Object> choicesObj = (Map<String, Object>) questionMapResponse.get(Constants.CHOICES);
			Map<String, Object> updatedChoicesMap = new HashMap<>();
			if (choicesObj.containsKey(Constants.OPTIONS)) {
				List<Map<String, Object>> optionsMapList = (List<Map<String, Object>>) choicesObj
						.get(Constants.OPTIONS);
				updatedChoicesMap.put(Constants.OPTIONS, optionsMapList);
			}
			updatedQuestionMap.put(Constants.CHOICES, updatedChoicesMap);
		}
		if (questionMapResponse.containsKey(Constants.RHS_CHOICES)
				&& updatedQuestionMap.containsKey(Constants.PRIMARY_CATEGORY) && updatedQuestionMap
						.get(Constants.PRIMARY_CATEGORY).toString().equalsIgnoreCase(Constants.MTF_QUESTION)) {
			List<Object> rhsChoicesObj = (List<Object>) questionMapResponse.get(Constants.RHS_CHOICES);
			Collections.shuffle(rhsChoicesObj);
			updatedQuestionMap.put(Constants.RHS_CHOICES, rhsChoicesObj);
		}

		return updatedQuestionMap;
	}

	@Override
	public List<Map<String, Object>> readQuestionDetails(List<String> identifiers) {
		try {
			StringBuilder sbUrl = new StringBuilder(serverProperties.getAssessmentHost());
			sbUrl.append(serverProperties.getAssessmentQuestionListPath());
			Map<String, String> headers = new HashMap<>();
			headers.put(Constants.AUTHORIZATION, serverProperties.getSbApiKey());
			Map<String, Object> requestBody = new HashMap<>();
			Map<String, Object> requestData = new HashMap<>();
			Map<String, Object> searchData = new HashMap<>();
			requestData.put(Constants.SEARCH, searchData);
			requestBody.put(Constants.REQUEST, requestData);
			List<Map<String, Object>> questionDataList = new ArrayList<>();
			int chunkSize = 15;
			for (int i = 0; i < identifiers.size(); i += chunkSize) {
				List<String> identifierList;
				if ((i + chunkSize) >= identifiers.size()) {
					identifierList = identifiers.subList(i, identifiers.size());
				} else {
					identifierList = identifiers.subList(i, i + chunkSize);
				}
				searchData.put(Constants.IDENTIFIER, identifierList);
				Map<String, Object> data = outboundRequestHandlerService.fetchResultUsingPost(sbUrl.toString(),
						requestBody, headers);
				if (!ObjectUtils.isEmpty(data)) {
					questionDataList.add(data);
				}
			}
			return questionDataList;
		} catch (Exception e) {
			logger.info(String.format("Failed to process the readQuestionDetails. %s", e.getMessage()));
		}
		return new ArrayList<>();
	}

	@Override
	public Map<String, Object> getReadHierarchyApiResponse(String assessmentIdentifier, String token) {
		try {
			StringBuilder sbUrl = new StringBuilder(serverProperties.getAssessmentHost());
			sbUrl.append(serverProperties.getAssessmentHierarchyReadPath());
			String serviceURL = sbUrl.toString().replace(Constants.IDENTIFIER_REPLACER, assessmentIdentifier);
			Map<String, String> headers = new HashMap<>();
			headers.put(Constants.X_AUTH_TOKEN, token);
			headers.put(Constants.AUTHORIZATION, serverProperties.getSbApiKey());
			Object o = outboundRequestHandlerService.fetchUsingGetWithHeaders(serviceURL, headers);
			Map<String, Object> data = new ObjectMapper().convertValue(o, Map.class);
			return data;
		} catch (Exception e) {
			logger.error("error in getReadHierarchyApiResponse  " + e.getMessage(), e);
		}
		return new HashMap<>();
	}

	public Map<String, Object> readAssessmentHierarchyFromDB(String assessmentIdentifier) {
		Map<String, Object> propertyMap = new HashMap<String, Object>();
		propertyMap.put(Constants.IDENTIFIER, assessmentIdentifier);
		List<Map<String, Object>> hierarchyList = cassandraOperation.getRecordsByPropertiesWithoutFiltering(
				serverProperties.getAssessmentHierarchyNameSpace(),
				serverProperties.getAssessmentHierarchyTable(), propertyMap, null);
		if (!CollectionUtils.isEmpty(hierarchyList)) {
			Map<String, Object> assessmentEntry = hierarchyList.get(0);
			String hierarchyStr = (String) assessmentEntry.get(Constants.HIERARCHY);
			if (StringUtils.isNotBlank(hierarchyStr)) {
				try {
					return mapper.readValue(hierarchyStr, new TypeReference<Map<String, Object>>() {
					});
				} catch (Exception e) {
					logger.error("Failed to read hierarchy data. Exception: ", e);
				}
			}
		}
		return MapUtils.EMPTY_MAP;
	}

	public List<Map<String, Object>> readUserSubmittedAssessmentRecords(String userId, String assessmentId) {
		Map<String, Object> propertyMap = new HashMap<String, Object>();
		propertyMap.put(Constants.USER_ID, userId);
		propertyMap.put(Constants.ASSESSMENT_ID_KEY, assessmentId);
		return cassandraOperation.getRecordsByPropertiesWithoutFiltering(
				Constants.SUNBIRD_KEY_SPACE_NAME, serverProperties.getAssessmentUserSubmitDataTable(),
				propertyMap, null);
	}
}