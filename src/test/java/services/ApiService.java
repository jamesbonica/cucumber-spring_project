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
import static constants.Constants.STANDARD_PASSWORD;
import static constants.Constants.GET_API_KEY;
import static constants.Constants.CREATE_USER;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;

import config.CrossScenarioCache;
import config.PropertiesLoader;
import pageObject.LoginPage;

/**
 * 
 * @author Jim Bonica
 *
 * Oct 22, 2018
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
	UserService userService;

	public String getApiKey(String username) {
		String content = null;

		String payload = "{\"username\":\"" + username + "\",\"" + STANDARD_PASSWORD + "\": \"password\"}";

		StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(propertiesLoader.getOcUrl() + GET_API_KEY);
		request.setEntity(entity);

		HttpResponse response = null;
		try {
			response = httpClient.execute(request);
		} catch (IOException e) {

		}
		// convert response to String then to JSON Object for parsing
		HttpEntity resultsEntity = response.getEntity();
		try {
			content = EntityUtils.toString(resultsEntity);
		} catch (ParseException | IOException e1) {
		}

		JSONObject myObject = new JSONObject(content);

		String value = myObject.getString("apiKey");
		System.out.println("========================= " + value);

		return value;
	}

	public String createUser(String user) {
		String apiKey = getApiKey(user);

		String payload = "{" +
				"\"username\": \"testingUser2\"," + 
				"\"fName\": \"Jimmy\",\"lName\": \"Sander\"," + 
				"\"institution\": \"OC\"," + 
				"\"email\": \"abcde@yahoo.com\"," + 
				"\"study_name\": \"Default Study\"," + 
				"\"role_name\": \"Data Manager\"," +
				"\"user_type\": \"user\"," + 
				"\"authorize_soap\":\"false\"" + 
				"}";

		HttpPost request = new HttpPost(propertiesLoader.getOcUrl() + CREATE_USER);
		String authHeader = "Basic " + Base64.getEncoder().encodeToString((apiKey + ":").getBytes());

		StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);

		HttpClient httpClient = HttpClientBuilder.create().build();
			
		request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
		request.setHeader("Accept", "application/json");
		request.setHeader("Content-type", "application/json");
		request.setHeader("api_key", apiKey);

	//	 System.out.println("]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]] " +	 Base64.getEncoder().encodeToString(apiKey.getBytes()));

		request.setEntity(entity);

		HttpResponse response = null;
		try {
			response = httpClient.execute(request);
		} catch (IOException e) {

		}

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + response.getStatusLine().getStatusCode());

		return null;
	}

}
