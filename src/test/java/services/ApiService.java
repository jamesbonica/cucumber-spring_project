package services;

import org.apache.http.HttpEntity;
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

import java.io.IOException;

import org.springframework.stereotype.Service;

import config.CrossScenarioCache;
import config.PropertiesLoader;
import pageObject.LoginPage;

@Service
public class ApiService {

	@Autowired
	LoginPage loginPage;

	@Autowired
	PropertiesLoader propertiesLoader;
	
	@Autowired
	CrossScenarioCache crossScenarioCache;

	public void getApiKey(String username) {
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
		
		// set the API Key in the crossScenarioCache
		crossScenarioCache.setRootApiKey(value);
	}

}
