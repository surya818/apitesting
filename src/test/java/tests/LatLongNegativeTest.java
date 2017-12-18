

package tests;

import org.testng.annotations.Test;

import com.sun.jersey.api.client.ClientResponse;

import data.JSONData;
import framework.BaseTestCase;
import framework.GetMethodRequest;
import framework.utils.PropertyUtils;
import framework.utils.WeatherUtils;
import pojos.Weather;

import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import static framework.utils.LoggerUtils.*;
import static framework.utils.PropertyUtils.*;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;

public class LatLongNegativeTest {
	public GetMethodRequest getmethod;
	public JSONData data;
	public ObjectMapper mapper;
	public WeatherUtils utils;
	public Weather weather; 
	public PropertyUtils properties;
	public static ClientResponse responseObject;
	public static HashMap<String,?> responseAsMap;
	public String base_url;
	public String app_id;
	public String query_by_NegativeBoundary_latAndLong;
	public String query_by_PositiveBoundary_latAndLong;
	public String query_by_NegativeBoundaryOutOfBounds_lat;
	public String query_by_NegativeBoundaryOutOfBounds_longitude;
	public String query_by_PositiveBoundaryOutOfBounds_lat;
	public String query_by_PositiveBoundaryOutOfBounds_longitude;
	public String error_400_latLongOutOfBoundary_message;


	@BeforeClass
	public void beforeClass() {
		PropertyUtils.setPropertyFilename("src/main/resources/weather.properties");
		BaseTestCase.init();
		utils = WeatherUtils.getWeatherUtilsInstance();
		getmethod = new GetMethodRequest();
		data = new JSONData();
		mapper = new ObjectMapper();
		base_url = getProperty("base_url");
		app_id = getProperty("app_id");
		query_by_NegativeBoundary_latAndLong = getProperty("query_by_NegativeBoundary_latAndLong");
		query_by_PositiveBoundary_latAndLong = getProperty("query_by_PositiveBoundary_latAndLong");
		query_by_NegativeBoundaryOutOfBounds_lat = getProperty("query_by_NegativeBoundaryOutOfBounds_lat");
		query_by_NegativeBoundaryOutOfBounds_longitude = getProperty("query_by_NegativeBoundaryOutOfBounds_longitude");
		query_by_PositiveBoundaryOutOfBounds_lat = getProperty("query_by_PositiveBoundaryOutOfBounds_lat");
		query_by_PositiveBoundaryOutOfBounds_longitude = getProperty("query_by_PositiveBoundaryOutOfBounds_longitude");
		error_400_latLongOutOfBoundary_message = getProperty("error_400_latLongOutOfBoundary_message");

	}

	@AfterClass
	public void afterClass() {
	}

	@Test
	public void test_301_NegativeTest_LatLongPositiveBoundary_StatusCodeCheck(){
		newLine();
		log("Executing test ==> test_301_NegativeTest_LatLongPositiveBoundary_StatusCodeCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_PositiveBoundary_latAndLong, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		int status_code = responseObject.getStatus();
		log("Status Code for Lat Long Postive Boundary URL: "+status_code );
		assertEquals(status_code, 200);
		newLine();
	}

	@Test
	public void test_302_NegativeTest_LatLongNegativeBoundary_StatusCodeCheck(){
		newLine();
		log("Executing test ==> test_302_NegativeTest_LatLongNegativeBoundary_StatusCodeCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_NegativeBoundary_latAndLong, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		int status_code = responseObject.getStatus();
		log("Status Code for Lat Long Negative Boundary URL: "+status_code );
		assertEquals(status_code, 200);
		newLine();
	}

	@Test
	public void test_303_NegativeTest_LatitudePositiveBoundary_OutOfBounds_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_303_NegativeTest_LatitudePositiveBoundary_OutOfBounds_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_PositiveBoundaryOutOfBounds_lat, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		int status_code = responseObject.getStatus();
		log("Status Code for Latitude Positive Boundary - OutOfBounds URL: "+status_code );
		assertEquals(status_code, 400);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		log("Server response for Latitude Positive Out of bounds request: "+responseJSONObject.toJSONString());
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Latitude Positive Boundary -OutOfBounds from test Data: "+error_400_latLongOutOfBoundary_message);
		log("Error message from API, for Latitude Positive Boundary - OutOfBounds: "+errorMessageFromAPIResponse);
		assertTrue(errorMessageFromAPIResponse.contains(error_400_latLongOutOfBoundary_message));
		newLine();
	}

	@Test
	public void test_304_NegativeTest_LongitudePositiveBoundary_OutOfBounds_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_304_NegativeTest_LongitudePositiveBoundary_OutOfBounds_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_PositiveBoundaryOutOfBounds_longitude, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		int status_code = responseObject.getStatus();
		log("Status Code for Longitude Positive Boundary - OutOfBounds URL: "+status_code );
		assertEquals(status_code, 400);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		log("Server response for Longitude Positive Out of bounds request: "+responseJSONObject.toJSONString());
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Longitude Positive Boundary - OutOfBounds from test Data: "+error_400_latLongOutOfBoundary_message);
		log("Error message from API, for Longitude Positive Boundary - OutOfBounds: "+errorMessageFromAPIResponse);
		assertTrue(errorMessageFromAPIResponse.contains(error_400_latLongOutOfBoundary_message));
		newLine();
	}

	@Test
	public void test_305_NegativeTest_LatitudeNegativeBoundary_OutOfBounds_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_305_NegativeTest_LatitudeNegativeBoundary_OutOfBounds_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_NegativeBoundaryOutOfBounds_lat, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		int status_code = responseObject.getStatus();
		log("Status Code for Latitude Negative Boundary - OutOfBounds URL: "+status_code );
		assertEquals(status_code, 400);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		log("Server response for Latitude Negative Out of bounds request: "+responseJSONObject.toJSONString());
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Latitude Negative Boundary -OutOfBounds from test Data: "+error_400_latLongOutOfBoundary_message);
		log("Error message from API, for Latitude Negative Boundary - OutOfBounds: "+errorMessageFromAPIResponse);
		assertTrue(errorMessageFromAPIResponse.contains(error_400_latLongOutOfBoundary_message));
		newLine();
	}

	@Test
	public void test_306_NegativeTest_LongitudeNegativeBoundary_OutOfBounds_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_306_NegativeTest_LongitudeNegativeBoundary_OutOfBounds_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_NegativeBoundaryOutOfBounds_longitude, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		int status_code = responseObject.getStatus();
		log("Status Code for Longitude Negative Boundary - OutOfBounds URL: "+status_code );
		assertEquals(status_code, 400);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		log("Server response for Longitude Negative Out of bounds request: "+responseJSONObject.toJSONString());
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Longitude Negative Boundary -OutOfBounds from test Data: "+error_400_latLongOutOfBoundary_message);
		log("Error message from API, for Longitude Negative Boundary - OutOfBounds: "+errorMessageFromAPIResponse);
		assertTrue(errorMessageFromAPIResponse.contains(error_400_latLongOutOfBoundary_message));
		newLine();
	}

}
