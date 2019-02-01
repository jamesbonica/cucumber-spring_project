package services;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import static constants.Constants.GET_API_KEY;
import static constants.Constants.CREATE_USER;
import static constants.Constants.ENDPOINT_GET_BOOK_BY_ISBN;
import static constants.Constants.CREATE_A_STUDY;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.oc.pageObject.LoginPage;

import config.CrossScenarioCache;
import config.PropertiesLoader;
import config.ScenarioSession;
import domain.Study;
import dto.UserDTO;

/**
 * 
 * @author Jim Bonica
 *
 *         Oct 22, 2018
 */

@Service
public class ApiService {

	@Autowired
	LoginPage loginPage;

	@Autowired
	PropertiesLoader propertiesLoader;

	@Autowired
	CrossScenarioCache crossScenarioCache;

	@Autowired
	LoginService loginService;

	@Autowired
	HelperService helperService;

	@Autowired
	ScenarioSession scenarioSession;

	//////////////// API Helper methods to prevent duplicate code
	//////////////// /////////////////////////////

	public JSONObject getJSONObjectFromResponse(HttpResponse response) {
		String content = null;
		// convert response to String then to JSON Object for parsing
		HttpEntity resultsEntity = response.getEntity();
		try {
			content = EntityUtils.toString(resultsEntity);
		} catch (ParseException | IOException e1) {
		}

		JSONObject myObject = new JSONObject(content);
		return myObject;
	}

	public HttpPost setHeaderInRequest(String api, String apiKey, String payload) {
		HttpPost request = new HttpPost(propertiesLoader.getTestUrl() + api);
		String authHeader = "Basic " + Base64.getEncoder().encodeToString((apiKey + ":").getBytes());

		request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
		request.setHeader("Accept", "application/json");
		request.setHeader("Content-type", "application/json");

		return request;
	}

	///////////////// actual API Methods /////////////////////////////////////////

	public HashMap<String, Object> getUserAccountApi(String username, String password) {
		HashMap<String, Object> userAccountApiResultsMap = new HashMap<String, Object>();
		String apiKey = null;
		Integer httpResponse = null;

		String payload = "{\"username\":\"" + username + "\",\"" + password + "\": \"password\"}";

		StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);

		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost request = new HttpPost(propertiesLoader.getTestUrl() + GET_API_KEY);
		request.setEntity(entity);

		HttpResponse response = null;
		try {
			response = httpClient.execute(request);
		} catch (IOException e) {

		}

		JSONObject myObject = getJSONObjectFromResponse(response);

		// Get values from response
		httpResponse = response.getStatusLine().getStatusCode();
		if (httpResponse == 200) {
			apiKey = myObject.getString("apiKey");
		}

		// Add values to HashMap
		userAccountApiResultsMap.put("httpResponse", httpResponse);
		userAccountApiResultsMap.put("apiKey", apiKey);

		return userAccountApiResultsMap;
	}

	public HashMap<String, Object> createUser(String user, String password, UserDTO userDTO) {
		HashMap<String, Object> createUserApiResultsMap = new HashMap<String, Object>();
		Integer httpResponse = null;
		String tempPassword = null;

		HashMap<String, Object> userAccountApiResultsMap = getUserAccountApi(user, password);

		String apiKey = (String) userAccountApiResultsMap.get("apiKey");

		// if apiKey is null, throw an exception now
		if (apiKey == null) {
			try {
				throw new Exception("API Key is null. Get User Account API failed. Incorrect user or bad password?");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String payload = "{" + "\"username\": \"" + userDTO.getUsername() + "\"," + "\"fName\": \"" + userDTO.getFName()
				+ "\",\"lName\": \"" + userDTO.getLName() + "\"," + "\"institution\": \"" + userDTO.getInstitution()
				+ "\"," + "\"email\": \"" + userDTO.getEmail() + "\"," + "\"study_name\": \"" + userDTO.getStudy_name()
				+ "\"," + "\"role_name\": \"" + userDTO.getRole_name() + "\"," + "\"user_type\": \""
				+ userDTO.getUser_type() + "\"," + "\"authorize_soap\":\"" + userDTO.getAuthorize_soap() + "\"" + "}";

		HttpPost request = setHeaderInRequest(CREATE_USER, apiKey, payload);

		StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);

		HttpClient httpClient = HttpClientBuilder.create().build();

		request.setEntity(entity);

		HttpResponse response = null;
		try {
			response = httpClient.execute(request);
		} catch (IOException e) {

		}

		JSONObject myObject = getJSONObjectFromResponse(response);

		// Get server code from response
		httpResponse = response.getStatusLine().getStatusCode();
		// Add values to HashMap
		createUserApiResultsMap.put("httpResponse", httpResponse);

		if (httpResponse == 200) {
			tempPassword = myObject.getString("password");
			// Add it to HashMap
			createUserApiResultsMap.put("tempPassword", tempPassword);
		}

		return createUserApiResultsMap;
	}

	public HashMap<String, Object> createStudy(String user, String password, Study study) throws Exception {
		HashMap<String, Object> createStudyApiResultsMap = new HashMap<String, Object>();
		String message = null;
		Integer httpResponse = null;

		HashMap<String, Object> userAccountApiResultsMap = getUserAccountApi(user, password);

		String apiKey = (String) userAccountApiResultsMap.get("apiKey");

		// if apiKey is null, throw an exception now
		if (apiKey == null) {
			throw new Exception("API Key is null. Get User Account API failed. Incorrect user or bad password?");
		}

		String payload = "{" + "\"briefTitle\": \"" + study.getStudyName() + "\"," + "\"principalInvestigator\": \""
				+ study.getPrincipalInvestigator() + "\"," + "\"expectedTotalEnrollment\": \"" + study.getEnrollment()
				+ "\"," + "\"sponsor\": \"" + study.getSponsor() + "\"," + "\"protocolType\": \""
				+ study.getProtocolType() + "\"," + "\"status\": \"" + study.getStatus() + "\","
				+ "\"assignUserRoles\": [" + study.assignUserRolesString() + "]," + "\"uniqueProtocolID\": \""
				+ study.getStudyId() + "\"," + "\"briefSummary\": \"" + study.getBriefSummary() + "\","
				+ "\"startDate\": \"" + helperService.getStudyDate(study.getStartDate()) + "\"" + "}";

		HttpPost request = setHeaderInRequest(CREATE_A_STUDY, apiKey, payload);

		StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);

		HttpClient httpClient = HttpClientBuilder.create().build();

		request.setEntity(entity);

		HttpResponse response = null;
		try {
			response = httpClient.execute(request);
		} catch (IOException e) {

		}

		// Get server code from response
		httpResponse = response.getStatusLine().getStatusCode();

		JSONObject myObject = getJSONObjectFromResponse(response);

		// Get values from response
		message = myObject.getString("message");

		// Add values to HashMap
		createStudyApiResultsMap.put("httpResponse", httpResponse);
		createStudyApiResultsMap.put("message", message);

		System.out.println("Create Study Response:");
		createStudyApiResultsMap.forEach((k, v) -> {
			System.out.println(k + " [" + v + "]");
		});

		return createStudyApiResultsMap;
	}

	public RequestSpecification prepareOpenGoogleApi(String isbn) {
		RequestSpecification request = given().param("q", "isbn:" + isbn);
		return request;
	}

	public Response executeOpenGoogleApi(RequestSpecification request) {
		Response response = request.get(ENDPOINT_GET_BOOK_BY_ISBN);
		return response;
	}

}
