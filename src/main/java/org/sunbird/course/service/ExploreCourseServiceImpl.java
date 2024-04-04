package org.sunbird.course.service;

import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.MapUtils;
import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.sunbird.cache.RedisCacheMgr;
import org.sunbird.cassandra.utils.CassandraOperation;
import org.sunbird.common.model.SBApiResponse;
import org.sunbird.common.service.OutboundRequestHandlerServiceImpl;
import org.sunbird.common.util.CbExtServerProperties;
import org.sunbird.common.util.Constants;
import org.sunbird.common.util.ProjectUtil;
import org.sunbird.core.exception.ApplicationLogicError;

/**
 * Implementation of ExploreCourseService
 * {@link org.sunbird.course.service.ExploreCourseService}
 * 
 * @author karthik
 *
 */
@Service
@SuppressWarnings("unchecked")
public class ExploreCourseServiceImpl implements ExploreCourseService {

	private Logger logger = LoggerFactory.getLogger(ExploreCourseServiceImpl.class);

	@Autowired
	CassandraOperation cassandraOperation;

	@Autowired
	RedisCacheMgr redisCacheMgr;

	@Autowired
	CbExtServerProperties serverProperties;

	@Autowired
	OutboundRequestHandlerServiceImpl outboundRequestHandlerService;

	@Override
	public SBApiResponse getExploreCourseList() {
		SBApiResponse response = ProjectUtil.createDefaultResponse(Constants.API_GET_EXPLORE_COURSE_DETAIL);
		String errMsg = "";
		try {
			List<Map<String, Object>> courseList = cassandraOperation.getRecordsByProperties(
					Constants.SUNBIRD_KEY_SPACE_NAME, Constants.TABLE_EXPLORE_COURSE_LIST, MapUtils.EMPTY_MAP,
					ListUtils.EMPTY_LIST);

			if (CollectionUtils.isNotEmpty(courseList)) {
				Comparator<Map<String, Object>> customComparator = Comparator.comparing(entry -> {
					Integer seqNo = (Integer) entry.get(Constants.SEQ_NO);
					return (seqNo != null) ? seqNo : Integer.MAX_VALUE;
				});
				courseList = courseList.stream().sorted(customComparator).collect(Collectors.toList());
			}
			List<String> identifierList = new ArrayList<>();
			for (Map<String, Object> course : courseList) {
				identifierList.add((String) course.get(Constants.IDENTIFIER));
			}
			Map<String, Object> searchResponse = searchContent(identifierList);
			if (!Constants.OK.equalsIgnoreCase((String) searchResponse.get(Constants.RESPONSE_CODE))) {
				errMsg = "Failed to get contant details for Identifier List from DB.";
			} else {
				Map<String, Object> responseCourseList = (Map<String, Object>) searchResponse.get(Constants.RESULT);
				List<Map<String, Object>> contentList = (List<Map<String, Object>>) responseCourseList.get(Constants.CONTENT);
				if (CollectionUtils.isNotEmpty(contentList)) {
					List<Map<String, Object>> sortedContentList = identifierList.stream().map(identifier -> contentList.stream()
							.filter(content -> identifier.equals(content.get(Constants.IDENTIFIER)))
							.findFirst().orElse(null)).filter(Objects::nonNull).collect(Collectors.toList());
					responseCourseList.put(Constants.CONTENT, sortedContentList);
				}
				response.setResult(responseCourseList);
			}
		} catch (Exception e) {
			errMsg = "Failed to retrieve explore course list. Exception: " + e.getMessage();
			logger.error(errMsg, e);
		}
		if (StringUtils.isNotEmpty(errMsg)) {
			logger.error("Failed to initialize the Open Course Details to Cache. ErrMsg: {}" , errMsg);
			response.getParams().setErrmsg(errMsg);
			response.getParams().setStatus(Constants.FAILED);
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	public SBApiResponse refreshCache() {
		redisCacheMgr.deleteKeyByName(Constants.PUBLIC_COURSE_LIST);
		SBApiResponse response = getExploreCourseList();
		response.setId(Constants.API_REFRESH_EXPLORE_COURSE_DETAIL);
		return response;
	}

	private Map<String, Object> searchContent(List<String> identifierList) {
		try {
			StringBuilder sbUrl = new StringBuilder(serverProperties.getKmBaseHost());
			sbUrl.append(serverProperties.getKmBaseContentSearch());
			Map<String, String> headers = new HashMap<>();
			headers.put(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON);
			return outboundRequestHandlerService.fetchResultUsingPost(sbUrl.toString(),
					getContentSearchRequest(identifierList), headers);
		} catch (Exception e) {
			logger.error("Failed to call Content Search for given identifiers.", e);
			throw new ApplicationLogicError(e.getMessage());
		}
	}

	private Map<String, Object> getContentSearchRequest(List<String> identifierList) {
		Map<String, Object> request = new HashMap<>();
		Map<String, Object> requestBody = new HashMap<>();
		Map<String, Object> filters = new HashMap<>();
		filters.put(Constants.IDENTIFIER, identifierList);
		filters.put(Constants.STATUS, Constants.LIVE);
		requestBody.put(Constants.FILTERS, filters);
		Map<String, Object> sortBy = new HashMap<>();
		sortBy.put(Constants.LAST_UPDATED_ON, Constants.DESCENDING_ORDER);
		requestBody.put(Constants.SORT_BY, sortBy);
		requestBody.put(Constants.FIELDS, serverProperties.getKmCompositeSearchFields());
		request.put(Constants.REQUEST, requestBody);
		return request;
	}

	@Override
	public SBApiResponse getExploreCourseListV2() {
		SBApiResponse response = ProjectUtil.createDefaultResponse(Constants.API_GET_EXPLORE_COURSE_DETAIL);
		String errMsg = "";
		try {
			List<Map<String, Object>> courseList = cassandraOperation.getRecordsByPropertiesWithoutFiltering(
					Constants.SUNBIRD_KEY_SPACE_NAME, Constants.TABLE_EXPLORE_COURSE_LIST_V2, MapUtils.EMPTY_MAP,
					ListUtils.EMPTY_LIST);
			if (CollectionUtils.isNotEmpty(courseList)) {
				Comparator<Map<String, Object>> customComparator = Comparator.comparing(entry -> {
					Integer seqNo = (Integer) entry.get(Constants.SEQ_NO);
					return (seqNo != null) ? seqNo : Integer.MAX_VALUE;
				});
				courseList = courseList.stream().sorted(customComparator).collect(Collectors.toList());
			}
			List<String> identifierList = new ArrayList<>();
			for (Map<String, Object> course : courseList) {
				identifierList.add((String) course.get(Constants.IDENTIFIER));
			}
			if(identifierList.isEmpty()) {
				errMsg = "Contents are not configured in Database.";
			} else {
				Map<String, Object> searchResponse = searchContent(identifierList);
				if (!Constants.OK.equalsIgnoreCase((String) searchResponse.get(Constants.RESPONSE_CODE))) {
					errMsg = "Failed to get contant details for Identifier List from DB.";
				} else {
					Map<String, Object> responseCourseList = (Map<String, Object>) searchResponse.get(Constants.RESULT);
					List<Map<String, Object>> contentList = (List<Map<String, Object>>) responseCourseList.get(Constants.CONTENT);
					if (CollectionUtils.isNotEmpty(contentList)) {
						List<Map<String, Object>> sortedContentList = identifierList.stream()
								.map(identifier -> contentList.stream()
										.filter(content -> identifier.equals(content.get(Constants.IDENTIFIER)))
										.findFirst().orElse(null))
								.filter(Objects::nonNull)
								.sorted(Comparator.comparing(content -> (String) content.get(Constants.PRIMARY_CATEGORY)))
								.collect(Collectors.toList());
						responseCourseList.put(Constants.CONTENT, sortedContentList);
					}
					response.setResult(responseCourseList);
				}
			}
		} catch (Exception e) {
			errMsg = "Failed to retrieve explore course list. Exception: " + e.getMessage();
			logger.error(errMsg, e);
		}
		if (StringUtils.isNotEmpty(errMsg)) {
			logger.error("Failed to initialize the Open Course Details to Cache. ErrMsg: " + errMsg);
			response.getParams().setErrmsg(errMsg);
			response.getParams().setStatus(Constants.FAILED);
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
