package org.sunbird.common.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constants {
	public static final String UUID = "wid";
	public static final String KID = "kid";
	public static final String SOURCE_ID = "source_id";
	public static final String FIRST_NAME = "first_name";
	public static final String LAST_NAME = "last_name";
	public static final String MIDDLE_NAME = "middle_name";
	public static final String FIRSTNAME = "firstName";
	public static final String SURNAME = "surname";
	public static final String LASTNAME = "lastName";
	public static final String CONTACT_PHONE_NUMBER_OFFICE = "contact_phone_number_office";
	public static final String CONTACT_PHONE_NUMBER_HOME = "contact_phone_number_home";
	public static final String CONTACT_PHONE_NUMBER_PERSONAL = "contact_phone_number_personal";
	public static final String KNOWN_AS = "known_as";
	public static final String GENDER = "gender";
	public static final String DOB = "dob";
	public static final String SALUTATION = "salutation";
	public static final String EMAIL = "email";
	public static final String PROFILE_DETAILS_KEY = "profiledetails";
	public static final String SOURCE_PROFILE_PICTURE = "source_profile_picture";
	public static final String ROOT_ORG = "root_org";
	public static final String ORG = "org";
	public static final String EMPLOYEMENT_STATUS = "employement_status";
	public static final String CONTRACT_TYPE = "contract_type";
	public static final String JOB_TITLE = "job_title";
	public static final String JOB_ROLE = "job_role";
	public static final String DEPARTMENT_NAME = "department_name";
	public static final String UNIT_NAME = "unit_name";
	public static final String LANGUAGES_KNOWN = "languages_known";
	public static final String ORGANIZATION_LOCATION_COUNTRY = "organization_location_country";
	public static final String ORGANIZATION_LOCATION_STATE = "organization_location_state";
	public static final String ORGANIZATION_LOCATION_CITY = "organization_location_city";
	public static final String RESIDENCE_COUNTRY = "residence_country";
	public static final String RESIDENCE_STATE = "residence_state";
	public static final String RESIDENCE_CITY = "residence_city";
	public static final String TIME_INSERTED = "time_inserted";
	public static final String TIME_UPDATED = "time_updated";
	public static final String JSON_UNMAPPED_FIELDS = "json_unmapped_fields";
	public static final String IS_ACTIVE = "is_active";
	public static final String ACCOUNT_EXPIRY_DATE = "account_expiry_date";
	public static final String SOURCE_DATA = "source_data";
	public static final String USER_ID = "userId";
	public static final String FILTERS = "filters";
	public static final String CONTENT_ID = "content_id";
	public static final String BATCH_ID = "batchId";
	public static final String COURSE_ID = "courseId";
	public static final String ENROLMENT_TYPE = "enrollmenttype";
	public static final String IDENTIFIER = "identifier";
	public static final String START_DATE = "startDate";
	public static final String END_DATE = "endDate";
	public static final String ACTIVE = "active";
	public static final String COMPLETION_PERCENTAGE = "completionPercentage";
	public static final String PROGRESS = "progress";
	public static final String PROFILEDETAILS = "profiledetails";
	public static final String EMPLOYMENTDETAILS = "employmentDetails";
	public static final String DEPARTMENTNAME = "departmentName";
	public static final String ISSUED_CERTIFICATES = "issued_certificates";
	public static final String IS_MDO = "isMdo";
	public static final String IS_CBP = "isCbp";
	public static final String PROFILE_DETAILS_DESIGNATION = "profileDetails.professionalDetails.designation";
	public static final String PROFILE_DETAILS_DESIGNATION_OTHER = "profileDetails.professionalDetails.designationOther";
	public static final String PROFILE_DETAILS_PRIMARY_EMAIL = "profileDetails.personalDetails.primaryEmail";
	public static final String DEPARTMENT = "department";
	public static final String DESIGNATION = "designation";
	public static final String PRIMARY_EMAIL = "primaryEmail";
	public static final String FIRST_LOGIN_TIME = "firstLoginTime";
	public static final String RESPONSE_CODE = "responseCode";
	public static final String AUTH_TOKEN = "Authorization";
	public static final String X_AUTH_TOKEN = "x-authenticated-user-token";
	public static final String SUCCESSFUL = "Successful";
	public static final String FAILED = "Failed";
	public static final String MESSAGE = "message";
	public static final String DATA = "data";
	public static final String STATUS = "status";
	public static final String RESULT = "result";
	public static final String OK = "OK";
	public static final String ADD = "add";
	public static final String UPDATE = "update";
	public static final String CREATE = "create";
	public static final String ROOT_ORG_CONSTANT = "rootOrg";
	public static final String ORG_CONSTANT = "org";
	public static final String USER_ID_CONSTANT = "userId";
	public static final String FIELD_PASSED_CONSTANT = "fieldsPassed";
	public static final String FETCH_ONE_LEVEL_CONSTANT = "fetchOneLevel";
	public static final String SKIP_ACCESS_CHECK_CONSTANT = "skipAccessCheck";
	public static final String FIELDS_CONSTANT = "fields";
	public static final boolean FIELDS_PASSED = true;
	public static final boolean FETCH_ON_LEVEL = false;
	public static final boolean SKIP_ACCESS_CHECK = true;
	public static final List<String> MINIMUL_FIELDS = Collections
			.unmodifiableList(Arrays.asList("identifier", "duration", "downloadUrl", "description", "mimeType",
					"artifactUrl", "name", STATUS, "resourceType", "categoryType", "category"));
	public static final String FETCH_RESULT_CONSTANT = ".fetchResult:";
	public static final String URI_CONSTANT = "URI: ";
	public static final String REQUEST_CONSTANT = "Request: ";
	public static final String RESPONSE_CONSTANT = "Response: ";
	public static final String SERVICE_ERROR_CONSTANT = "Http Client threw an Exception:";
	public static final String EXTERNAL_SERVICE_ERROR_CODE = "Exception while querying the external service:";
	public static final String CONTENT_ID_REPLACER = "{contentId}";
	// User assessment pass mark
	public static final Float ASSESSMENT_PASS_SCORE = 60.0f;
	public static final String DATE_FORMAT = "yyyy-mm-dd hh:mm:ss";
	public static final String RESPONSE = "response";
	public static final String STAFF = "staff";
	public static final String API_STAFF_POSITION_ADD = "api.staff.position.add";
	public static final String API_STAFF_POSITION_UPDATE = "api.staff.position.update";
	public static final String API_STAFF_POSITION_READ = "api.staff.position.read";
	public static final String API_STAFF_POSITION_DELETE = "api.staff.position.delete";
	public static final String API_STAFF_POSITION_HISTORY_READ = "api.staff.position.history.read";
	public static final String API_BUDGET_SCHEME_ADD = "api.budget.schme.add";
	public static final String API_BUDGET_SCHEME_DOC_ADD = "api.budget.schme.doc.add";
	public static final String API_BUDGET_SCHEME_UPDATE = "api.budget.schme.update";
	public static final String API_BUDGET_SCHEME_READ = "api.budget.scheme.read";
	public static final String API_BUDGET_SCHEME_DELETE = "api.budget.scheme.delete";
	public static final String API_BUDGET_SCHEME_HISTORY_READ = "api.budget.scheme.history.read";
	public static final String API_FILE_UPLOAD = "api.file.upload";
	public static final String API_FILE_DELETE = "api.file.delete";
	public static final String API_PROFILE_UPDATE = "api.profile.update";
	public static final String API_GET_EXPLORE_COURSE_DETAIL = "api.explore.course";
	public static final String API_REFRESH_EXPLORE_COURSE_DETAIL = "api.refresh.explore.course.list";

	public static final String ORG_PROFILE_UPDATE = "org.profile.update";
	public static final String ID = "id";
	public static final String ORG_ID = "orgId";
	public static final String POSITION = "position";
	public static final String TOTAL_POSITION_FILLED = "totalPositionsFilled";
	public static final String TOTAL_POSITION_VACANT = "totalPositionsVacant";
	public static final String NAME = "name";
	public static final String URL = "url";
	public static final String DELETED = "deleted";
	public static final String SCHEME_ID = "schemeId";
	public static final String BUDGET = "budget";
	public static final String BUDGET_YEAR = "budgetYear";
	public static final String SCHEME_NAME = "schemeName";
	public static final String SALARY_BUDGET_ALLOCATED = "salaryBudgetAllocated";
	public static final String TRAINING_BUDGET_ALLOCATED = "trainingBudgetAllocated";
	public static final String TRAINING_BUDGET_UTILIZATION = "trainingBudgetUtilization";

	// ratings and review
	public static final String API_RATINGS_ADD = "api.ratings.add";
	public static final String API_RATINGS_READ = "api.ratings.read";
	public static final String API_RATINGS_UPDATE = "api.ratings.update";
	public static final String API_RATINGS_SUMMARY = "api.ratings.summary";
	public static final String API_RATINGS_LOOKUP = "api.ratings.lookup";
	public static final String DATABASE = "sunbird";
	public static final String LOGIN_TABLE = "user_first_login_details";
	public static final String ACTIVITY_ID = "activityId";
	public static final String ACTIVITY_TYPE = "activityType";
	public static final String RATINGS_USER_ID = "userId";
	public static final String USER_FIRST_NAME = "firstName";
	public static final String USER_LAST_NAME = "lastName";
	public static final String USERID = "id";
	public static final String COMMENT = "comment";
	public static final String COMMENT_BY = "commentBy";
	public static final String COMMENT_UPDATED_ON = "commentupdatedon";
	public static final String CREATED_ON = "createdon";
	public static final String RATING = "rating";
	public static final String REVIEW = "review";
	public static final String UPDATED_ON = "updatedon";
	public static final String LATEST50REVIEWS = "latest50reviews";
	public static final String SUMMARY_ACTIVITY_ID = "activityid";
	public static final String SUMMARY_ACTIVITY_TYPE = "activitytype";
	public static final String TOTALCOUNT1STARS = "totalcount1stars";
	public static final String TOTALCOUNT2STARS = "totalcount2stars";
	public static final String TOTALCOUNT3STARS = "totalcount3stars";
	public static final String TOTALCOUNT4STARS = "totalcount4stars";
	public static final String TOTALCOUNT5STARS = "totalcount5stars";
	public static final String TOTALNUMBEROFRATINGS = "total_number_of_ratings";
	public static final String SUMOFTOTALRATINGS = "sum_of_total_ratings";
	public static final String NO_RATING_EXCEPTION_MESSAGE = "No ratings found for : ";
	public static final String NO_REVIEW_EXCEPTION_MESSAGE = "No reviews found for : ";
	public static final String RATING_GENERIC_EXCEPTION_MESSAGE = "Exception occurred while adding the course review : ";
	public static final String KAFKA_RATING_EXCEPTION_MESSAGE = "Exception occurred while connecting to kafka topic : ";
	public static final String RATING_UPSERT_OPERATION = "upsert";
	public static final String RATING_LOOKUP_RATING_OPERATION = "lookup";
	public static final String RATING_GET_OPERATION = "getRating";
	public static final String RATING_SUMMARY_OPERATION = "getSummary";
	// assessment
	public static final String QUESTION_SET = "questionSet";
	public static final String ASSESSMENT_QNS_ANS_SET = "assessmentQnsAnsSet_";
	public static final String ASSESSMENT_QNS_SET = "assessmentQnsSet_";
	// Cassandra Constants
	public static final String INSERT_INTO = "INSERT INTO ";
	public static final String DOT = ".";
	public static final String OPEN_BRACE = "(";
	public static final String VALUES_WITH_BRACE = ") VALUES (";
	public static final String QUE_MARK = "?";
	public static final String COMMA = ",";
	public static final String CLOSING_BRACE = ");";
	public static final String SUCCESS = "success";
	public static final String UNKNOWN_IDENTIFIER = "Unknown identifier ";
	public static final String UNDEFINED_IDENTIFIER = "Undefined column name ";
	public static final String EXCEPTION_MSG_FETCH = "Exception occurred while fetching record from ";
	public static final String EXCEPTION_MSG_DELETE = "Exception occurred while deleting record from ";
	public static final String AUDIT_TYPE = "auditType";
	public static final String CREATED_DATE = "createdDate";
	public static final String CREATED_BY = "createdBy";
	public static final String UPDATED_DATE = "updatedDate";
	public static final String UPDATED_BY = "updatedBy";
	public static final String TRANSACTION_DETAILS = "transactionDetails";
	public static final String PROOF_DOCS = "proofDocs";
	public static final String WORK_ORDER_ID = "workOrderId";
	public static final String WORK_ALLOCATION_ID = "workAllocationId";
	public static final String BEGIN_BATCH = "BEGIN BATCH ";
	public static final String APPLY_BATCH = " APPLY BATCH;";
	// Database and Tables
	public static final String KEYSPACE_SUNBIRD = "sunbird";
	public static final String KEYSPACE_SUNBIRD_COURSES = "sunbird_courses";
	public static final String TABLE_ORG_BUDGET_SCHEME = "org_budget_scheme";
	public static final String TABLE_USER_ASSESSMENT_TIME = "user_assessment_time";
	public static final String SHA_256_WITH_RSA = "SHA256withRSA";
	public static final String SUB = "sub";
	public static final String _UNAUTHORIZED = "Unauthorized";
	public static final String DOT_SEPARATOR = ".";
	public static final String ACCESS_TOKEN_PUBLICKEY_BASEPATH = "accesstoken.publickey.basepath";
	public static final String TABLE_ORG_AUDIT = "org_audit";
	public static final String TABLE_ORG_STAFF_POSITION = "org_staff_position";
	public static final String TABLE_WORK_ORDER = "work_order";
	public static final String TABLE_WORK_ALLOCATION = "work_allocation";
	public static final String TABLE_USER_WORK_ALLOCATION_MAPPING = "user_work_allocation_mapping";
	public static final String TABLE_MANDATORY_USER_CONTENT = "mandatory_user_content";
	public static final String TABLE_ORGANIZATION = "organisation";
	public static final String TABLE_USER_ENROLMENT = "user_enrolments";
	public static final String TABLE_USER = "user";
	public static final String TABLE_COURSE_BATCH = "course_batch";
	public static final String TABLE_RATINGS = "ratings";
	public static final String TABLE_RATINGS_LOOKUP = "ratings_lookup";
	public static final String TABLE_RATINGS_SUMMARY = "ratings_summary";
	public static final String TABLE_EXPLORE_COURSE_LIST = "explore_course_list";
	public static final String VALUE = "value";
	public static final String DEPT_NAME = "deptName";
	public static final String PROFILE_DETAILS = "profileDetails";
	public static final String PROFESSIONAL_DETAILS = "professionalDetails";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String APPLICATION_JSON = "application/json";
	public static final String OSID = "osid";
	public static final String INITIATE = "INITIATE";
	public static final String FIELD_KEY = "fieldKey";
	public static final String TO_VALUE = "toValue";
	public static final String FROM_VALUE = "fromValue";
	public static final String STATE = "state";
	public static final String ACTION = "action";
	public static final String APPLICATION_ID = "applicationId";
	public static final String ACTOR_USER_ID = "actorUserId";
	public static final String SERVICE_NAME = "serviceName";
	public static final String PROFILE = "profile";
	public static final String WFID = "wfId";
	public static final String UPDATE_FIELD_VALUES = "updateFieldValues";
	public static final String PROFILE_UPDATE_FIELDS = "profileUpdateFields_";
	public static final String IGOT = "igot";
	public static final String DOPT = "dopt";
	public static final String PERSONAL_DETAILS = "personalDetails";
	public static final String TRANSITION_DETAILS = "transitionDetails";
	public static final String UNAUTHORIZED = "unauthorized";
	// Redis
	public static final String API_REDIS_DELETE = "api.redis.delete";
	public static final String API_REDIS_GET_KEYS = "api.redis.get.keys";
	public static final String API_REDIS_GET_KEYS_VALUE_SET = "api.redis.get.keys&values";
	public static final String REDIS_COMMON_KEY = "CB_EXT_";
	public static final String COMPETENCY_CACHE_NAME = "competency";
	public static final String COMPETENCY_CACHE_NAME_BY_AREA = "competencyByArea";
	public static final String COMPETENCY_CACHE_NAME_BY_TYPE = "competencyByType";
	public static final String PROVIDER_CACHE_NAME = "provider";
	public static final String POSITIONS_CACHE_NAME = "positions";
	public static final String COMPETENCY_FACET_NAME = "competencies_v3.name";
	public static final String IS_TENANT = "isTenant";
	public static final String CHANNEL = "channel";
	public static final String USER_TOKEN = "x-authenticated-user-token";
	public static final String AUTHORIZATION = "authorization";
	public static final String FACETS = "facets";
	public static final String PRIMARY_CATEGORY = "primaryCategory";
	public static final String LIMIT = "limit";
	public static final String REQUEST = "request";
	public static final String FIELDS = "fields";
	public static final String OFFSET = "offset";
	public static final String BUDGET_DOC_UPLOADED_BY = "uploadedBy";
	public static final String BUDGET_DOC_UPLOADED_DATE = "uploadedDate";
	public static final String BUDGET_DOC_FILE_NAME = "fileName";
	public static final String BUDGET_DOC_FILE_TYPE = "fileType";
	public static final String BUDGET_DOC_FILE_SIZE = "fileSize";
	public static final String BUDGET_DOC_FILE_URL = "fileUrl";
	// telemetry audit constants
	public static final String ORG_LIST = "ORGANISATION_LIST";
	public static final String VERSION = "3.0.2";
	public static final String EID = "AUDIT";
	public static final String PDATA_ID = "dev.sunbird.cb.ext.service";
	public static final String PDATA_PID = "sunbird-cb-ext-service";
	public static final String CURRENT_STATE = "FirstLogin";
	public static final String LOGIN_TIME = "login_time";
	public static final List<String> PROPS = Collections.unmodifiableList(Arrays.asList("WAT"));
	public static final String USER_CONST = "User";
	public static final String ASSESSMENT_LEVEL_SCORE_CUTOFF = "assessmentlevel";
	public static final String SECTION_LEVEL_SCORE_CUTOFF = "sectionlevel";
	public static final String IDENTIFIER_REPLACER = "{identifier}";
	public static final String CHILDREN = "children";
	public static final String PARAMS = "params";
	public static final String MAX_QUESTIONS = "maxQuestions";
	public static final String CHILD_NODES = "childNodes";
	public static final String SEARCH = "search";
	public static final String SEARCHES = "searches";
	public static final String QUESTION_ID = "qs_id_";
	public static final String ASSESSMENT_ID = "assess_id_";
	public static final String EDITOR_STATE = "editorState";
	public static final String CHOICES = "choices";
	public static final String ANSWER = "answer";
	public static final String QUESTION = "question";
	public static final String OPTIONS = "options";
	public static final String USER_ASSESS_REQ = "user_assess_req_";
	public static final String HIERARCHY = "hierarchy";
	public static final String DEV_HIERARCHY_STORE = "dev_hierarchy_store";
	public static final String CONTENT_HIERARCHY = "content_hierarchy";
	public static final String BATCH_ID_ = "batchid";
	public static final String COURSE_ID_ = "courseid";
	public static final String COMPLETION_PERCENTAGE_ = "completionpercentage";
	public static final String LAST_ACCESS_TIME = "last_access_time";
	public static final String SUNBIRD_KEY_SPACE_NAME = "sunbird";
	public static final String SUNBIRD_COURSES_KEY_SPACE_NAME = "sunbird_courses";
	public static final String LAST_ACCESS_TIME_GAP = "last.access.time.gap.millis";

	public static final String SEARCH_FIELDS = "search.fields";
	public static final String USER_CONTENT_CONSUMPTION = "user_content_consumption";
	public static final String NOTIFICATION_UTIL = "notificationUtil";
	public static final String NOTIFICATIONS = "notifications";
	public static final String CORE_CONNECTIONS_PER_HOST_FOR_LOCAL = "coreConnectionsPerHostForLocal";
	public static final String CORE_CONNECTIONS_PER_HOST_FOR_REMOTE = "coreConnectionsPerHostForRemote";
	public static final String MAX_CONNECTIONS_PER_HOST_FOR_LOCAl = "maxConnectionsPerHostForLocal";
	public static final String MAX_CONNECTIONS_PER_HOST_FOR_REMOTE = "maxConnectionsPerHostForRemote";
	public static final String MAX_REQUEST_PER_CONNECTION = "maxRequestsPerConnection";
	public static final String HEARTBEAT_INTERVAL = "heartbeatIntervalSeconds";
	public static final String POOL_TIMEOUT = "poolTimeoutMillis";
	public static final String CONTACT_POINT = "contactPoint";
	public static final String PORT = "port";
	public static final String QUERY_LOGGER_THRESHOLD = "queryLoggerConstantThreshold";
	public static final String SUNBIRD_CASSANDRA_CONSISTENCY_LEVEL = "sunbird_cassandra_consistency_level";
	public static final String INCOMPLETE_COURSES_MAIL_SUBJECT = "Complete the courses you started";
	public static final String NEW_COURSES_MAIL_SUBJECT = "Check out exciting new courses that launched this week!";
	public static final String COURSE = "Course";
	public static final String COURSE_KEYWORD = "course";
	public static final String _URL = "_url";
	public static final String THUMBNAIL = "_thumbnail";
	public static final String _NAME = "_name";
	public static final String _DURATION = "_duration";
	public static final String SEND_NOTIFICATION_PROPERTIES = "send-notification";
	public static final String NOTIFICATION_HOST = "notification.service.host";
	public static final String NOTIFICATION_ENDPOINT = "notification.event.endpoint";
	public static final String SUBJECT = "subject";
	public static final String INCOMPLETE_COURSES_SCHEDULER_TIME_GAP = "incomplete-courses-scheduler-time-gap";
	public static final String INCOMPLETE_COURSES_SCHEDULER_RUN_DAY = "incomplete-courses-scheduler-run-day";
	public static final String INCOMPLETE_COURSES_SCHEDULER_RUN_TIME = "incomplete-courses-scheduler-run-time";
	public static final String NEW_COURSES_SCHEDULER_TIME_GAP = "new-courses-scheduler-time-gap";
	public static final String NEW_COURSES_SCHEDULER_RUN_DAY = "new-courses-scheduler-run-day";
	public static final String NEW_COURSES_SCHEDULER_RUN_TIME = "new-courses-scheduler-run-time";
	public static final String IS_DELETED = "isDeleted";
	public static final String EXCLUDE_USER_EMAILS = "exclude_user_emails";
	public static final String INCOMPLETE_COURSES = "incompletecourses";
	public static final String NEW_COURSES = "newcourses";
	public static final String POSTER_IMAGE = "posterImage";

	public static final String COURSE_URL = "course.url";
	public static final String OVERVIEW_BATCH_ID = "overview.batch";
	public static final String SENDER_MAIL = "sender.mail";
	public static final String CASSANDRA_CONFIG_HOST = "cassandra.config.host";
	public static final String OBJECT_TYPE = "objectType";
	public static final String QUESTIONS = "questions";
	public static final String RHS_CHOICES = "rhsChoices";
	public static final String MTF_QUESTION = "MTF Question";
	public static final String FTB_QUESTION = "FTB Question";
	public static final String API_QUESTIONSET_HIERARCHY_GET = "api.questionset.hierarchy.get";
	public static final String VER = "3.0";
	public static final String API_QUESTIONS_LIST = "api.questions.list";
	public static final String MINIMUM_PASS_PERCENTAGE = "minimumPassPercentage";
	public static final String SCORE_CUTOFF_TYPE = "scoreCutoffType";
	public static final String PASS_PERCENTAGE = "passPercentage";
	public static final String TOTAL = "total";
	public static final String BLANK = "blank";
	public static final String CORRECT = "correct";
	public static final String INCORRECT = "incorrect";
	public static final String PASS = "pass";
	public static final String OVERALL_RESULT = "overallResult";
	public static final String DO = "do_";
	public static final String SSO_CLIENT_ID = "sso.client.id";
	public static final String SSO_CLIENT_SECRET = "sso.client.secret";
	public static final String SSO_PASSWORD = "sso.password";
	public static final String SSO_POOL_SIZE = "sso.connection.pool.size";
	public static final String SSO_PUBLIC_KEY = "sunbird_sso_publickey";
	public static final String SSO_REALM = "sso.realm";
	public static final String SSO_URL = "sso.url";
	public static final String SSO_USERNAME = "sso.username";
	public static final String SUNBIRD_SSO_CLIENT_ID = "sunbird_sso_client_id";
	public static final String SUNBIRD_SSO_CLIENT_SECRET = "sunbird_sso_client_secret";
	public static final String SUNBIRD_SSO_PASSWORD = "sunbird_sso_password";
	public static final String SUNBIRD_SSO_RELAM = "sunbird_sso_realm";
	public static final String SUNBIRD_SSO_URL = "sunbird_sso_url";
	public static final String SUNBIRD_SSO_USERNAME = "sunbird_sso_username";
	public static final String DURATION = "duration";
	public static final String USER_REGISTRATION_REGISTER_API = "api.user.registration.register";
	public static final String USER_REGISTRATION_UPDATE_API = "api.user.registration.update";
	public static final String USER_REGISTRATION_RETRIEVE_API = "api.user.registration.retrieve";
	public static final String ORG_ONBOARDING_PROFILE_RETRIEVE_API = "api.org.onboarding.retrieve";
	public static final String USER_REGISTRATION_DEPT_INFO_API = "api.user.registration.dept.info";
	public static final String API_ORG_LIST = "api.org.list";
	public static final String API_ORG_EXT_CREATE = "api.org.extended.create";
	public static final String API_ORG_EXT_SEARCH = "api.org.extended.search";
	public static final String COUNT = "count";

	// email params
	public static final String TITLE = "title";
	public static final String DESCRIPTION = "description";
	public static final String TEMPLATE = "template";
	public static final String USER_REGISTERATION_TEMPLATE = "user-registration";
	public static final String STATUS_PARAM = "{status}";
	public static final String REG_CODE_PARAM = "{regCode}";
	public static final String BUTTON_URL = "btn-url";
	public static final String BUTTON_NAME = "btn-name";

	// notification reuest params
	public static final String DELIVERY_TYPE = "deliveryType";
	public static final String CONFIG = "config";
	public static final String IDS = "ids";

	// wf status
	public static final String INITIATED = "initiated";
	public static final String APPROVED = "approved";
	public static final String DENIED = "denied";

	public static final String EMAIL_EXIST_ERROR = "Email id already registered";
	public static final String EMAIL_VERIFIED = "emailVerified";
	public static final String USER_NAME = "userName";
	public static final String USER_FULL_NAME = "fullName";

	public static final String MANDATORY_FIELDS_EXISTS = "mandatoryFieldsExists";
	public static final String KEY = "key";
	public static final String TYPE = "type";
	public static final String LINK = "link";
	public static final String ALLOWED_LOGGING = "allowedLoging";

	public static final String API_VERSION_1 = "1.0";
	public static final String BODY = "body";
	public static final String EMAIL_TEMPLATE_TYPE = "emailTemplateType";
	public static final String MODE = "mode";
	public static final String ORG_NAME = "orgName";
	public static final String RECIPIENT_EMAILS = "recipientEmails";
	public static final String RECIPIENT_NEW_COURSE_EMAILS = "recipient.new.course.email";
	public static final String SET_PASSWORD_LINK = "setPasswordLink";
	public static final String WELCOME_MESSAGE = "welcomeMessage";
	public static final String HELLO = "Hello";
	public static final String WELCOME_EMAIL_TEMPLATE_TYPE = "iGotWelcome";
	public static final String WELCOME_EMAIL_MESSAGE = "Welcome Email";
	public static final String ORGANIZATION_ID = "organisationId";
	public static final String ROLES = "roles";
	public static final String PUBLIC = "PUBLIC";
	public static final String ASC_ORDER = "asc";
	public static final String SORT_BY = "sort_by";
	public static final String FIELD = "field";
	public static final String KEYWORD = "keyword";
	public static final String VERIFIED = "VERIFIED";
	public static final String COMPETENCY_AREA = "competencyArea";
	public static final String COMPETENCY_TYPE = "competencyType";
	public static final String SOURCE = "source";
	public static final String ADDITIONAL_PROPERTIES = "additionalProperties";
	public static final String CONTENT = "content";
	public static final String COMPETENCY = "competency";
	public static final String CHILD_COUNT = "childCount";
	public static final String RESPONSE_DATA = "responseData";
	public static final String DEPARTMENT_LIST_CACHE_NAME = "deptCacheList";
	public static final String POSITIONS = "positions";
	public static final String BEARER = "bearer ";
	public static final String IMG_URL = "imgurl";
	public static final String VALUES = "values";
	public static final String PROGRAM = "Program";
	public static final String LIVE = "Live";
	public static final String GOVERNMENT = "Government";
	public static final String ORGANIZATION_TYPE = "organisationType";
	public static final String ORGANIZATION_SUB_TYPE = "organisationSubType";
	public static final String FIRST_NAME_LOWER_CASE = "firstname";
	public static final String SPV = "SPV";
	public static final String TABLE_ORG_HIERARCHY = "org_hierarchy";
	public static final String PARENT_MAP_ID = "parentMapId";
	public static final String MINISTRY = "ministry";
	public static final String SB_ORG_TYPE = "sbOrgType";
	public static final String SB_ORG_ID = "sbOrgId";
	public static final String MAP_ID = "mapId";
	public static final String SB_ROOT_ORG_ID = "sbRootOrgId";
	public static final String ERROR_MESSAGE = "errmsg";

	public static final String API_USER_BASIC_INFO = "api.user.basic.info";
	public static final String API_USER_BASIC_PROFILE_UPDATE = "api.user.basic.profile.update";
	public static final String TABLE_SYSTEM_SETTINGS = "system_settings";
	public static final String CUSTODIAN_ORG_ID = "custodianOrgId";
	public static final String CUSTODIAN_ORG_CHANNEL = "custodianOrgChannel";
	public static final String ROOT_ORG_ID = "rootOrgId";
	public static final String IS_UPDATE_REQUIRED = "isUpdateRequired";
	public static final String USER_ROLES = "userRoles";
	public static final String X_AUTH_USER_ID = "x-authenticated-userid";
	public static final String SOFT_DELETE_OLD_ORG = "softDeleteOldOrg";
	public static final String NOTIFY_MIGRATION = "notifyMigration";	
	public static final String FORCE_MIGRATION = "forceMigration";
	public static final String PROFILE_DETAILS_LOWER = "profiledetails";
	public static final String EMPLOYMENT_DETAILS = "employmentDetails";
	public static final String DEPARTMENT_ID = "departmentId";
	public static final String ROOT_ORG_ID_LOWER = "rootorgid";
	public static final String OPERATION_TYPE = "operationType";
	public static final String SYNC = "sync";
	public static final String OBJECT_IDS = "objectIds";
	public static final String USER = "user";	
	public static final String PUBLIC_COURSE_LIST = "exploreOpenCourseList";
	public static final String LAST_UPDATED_ON = "lastUpdatedOn";
	public static final String DESCENDING_ORDER = "desc";
	public static final String ASSESSMENT_HOST = "assessment.host";
	public static final String CONTENT_SEARCH = "content.search";
	public static final String SB_API_KEY = "sb.api.key";
    public static final String NEW_COURSES_EMAIL_LIMIT = "new-courses-email-limit";
	public static final String EMAIL_RECORD_TABLE = "email_record";
	public static final String EMAIL_TYPE = "emailtype";
	public static final String LAST_SENT_DATE = "lastsentdate";

	public static final String NEW_COURSES_EMAIL = "New Courses Email";
	public static final String KM_BASE_HOST = "km.base.host";

	public static final String NO_OF_COURSES = "noOfCourses";


	private Constants() {
		throw new IllegalStateException("Utility class");
	}

}
