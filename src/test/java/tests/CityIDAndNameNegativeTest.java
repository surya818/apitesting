

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

public class CityIDAndNameNegativeTest {
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
	public String query_by_NonNumericID;
	public String query_by_negativeID; 
	public String query_by_BlankID;
	public String query_by_NonExistentID;
	public String query_by_id_valid;
	public String error_400_message;
	public String error_400_NonNumericCityID_message;
	public String error_400_NegativeID;
	public String error_400_NonExistentID;
	public String error_401_InvalidAppID;
	public String query_by_NonExistentCity;
	public String query_by_NonExistentCountry;
	public String query_by_BlankCityName;
	public String query_by_BlankCountryName;
	public String query_by_BlankCityAndCountryName;
	public String error_404_Invalid_CityQuery;
	public String query_by_BigNumber;
	public String error_400_VeryBigNumber_ID_message;


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
		query_by_BlankID = getProperty("query_by_BlankID");
		query_by_NonNumericID = getProperty("query_by_NonNumericID");
		query_by_negativeID = getProperty("query_by_negativeID");
		query_by_NonExistentID = getProperty("query_by_NonExistentID");
		query_by_id_valid = getProperty("query_by_id_valid");
		error_400_message = getProperty("error_400_message");
		error_400_NonNumericCityID_message = getProperty("error_400_NonNumericCityID_message");
		error_400_NegativeID = getProperty("error_400_NegativeID");
		error_400_NonExistentID = getProperty("error_400_NonExistentID");
		error_401_InvalidAppID = getProperty("error_401_InvalidAppID");
		query_by_NonExistentCity = getProperty("query_by_NonExistentCity");
		query_by_NonExistentCountry = getProperty("query_by_NonExistentCountry");
		query_by_BlankCityName = getProperty("query_by_BlankCityName");
		query_by_BlankCountryName = getProperty("query_by_BlankCountryName");
		query_by_BlankCityAndCountryName = getProperty("query_by_BlankCityAndCountryName");
		error_404_Invalid_CityQuery = getProperty("error_404_Invalid_CityQuery");
		query_by_BigNumber = getProperty("query_by_BigNumber");
		error_400_VeryBigNumber_ID_message = getProperty("error_400_VeryBigNumber_ID_message");

	}

	@AfterClass
	public void afterClass() {
	}

	@Test
	public void test_201_NegativeTest_SearchByEmptyID_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_201_NegativeTest_SearchByEmptyID_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_BlankID, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		int status_code = responseObject.getStatus();
		log("Status Code for Search By Empty ID URL: "+status_code );
		assertEquals(status_code, 400);
		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error message from API, for empty ID: "+errorMessageFromAPIResponse);
		assertEquals(errorMessageFromAPIResponse, error_400_message);
		newLine();
	}


	@Test
	public void test_202_NegativeTest_SearchByNonNumericID_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_202_NegativeTest_SearchByNonNumericID_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_NonNumericID, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		int status_code = responseObject.getStatus();
		log("Status Code for URL with Non Numeric ID : "+status_code );
		assertEquals(status_code, 400);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error message from API, for non numeric city ID: "+errorMessageFromAPIResponse);
		log("Error Message for Non numeric City ID from test Data: "+error_400_NonNumericCityID_message);
		assertTrue(errorMessageFromAPIResponse.contains(error_400_NonNumericCityID_message));
		newLine();
	}

	@Test
	public void test_203_NegativeTest_SearchByNegativeID_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_203_NegativeTest_SearchByNegativeID_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_negativeID, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		int status_code = responseObject.getStatus();
		log("Status Code for URL with Negative ID : "+status_code );
		assertEquals(status_code, 400);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Negative City ID from test Data: "+error_400_NegativeID);
		log("Error message from API, for Negative City ID: "+errorMessageFromAPIResponse);
		assertTrue(errorMessageFromAPIResponse.equals(error_400_NegativeID));
		newLine();
	}

	@Test(enabled=false)
	public void test_204_NegativeTest_SearchByNonExistentID_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_204_NegativeTest_SearchByNonExistentID_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_NonExistentID, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		log("Response Object for Non Existent ID:"+responseObject);
		int status_code = responseObject.getStatus();
		log("Status Code for URL with Non existent ID : "+status_code );
		//assertEquals(status_code, 404);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		log("JSON manifestation of response: "+responseJSONObject.toJSONString());
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Non Existent City ID from test Data: "+error_400_NonExistentID);
		log("Error message from API, for Non Existent City ID: "+errorMessageFromAPIResponse);
		assertTrue(errorMessageFromAPIResponse.contains(error_400_NonExistentID));
		newLine();
	}

	@Test
	public void test_205_NegativeTest_BlankAPPID_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_205_NegativeTest_BlankAPPID_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_id_valid, "");
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		log("Response Object for Blank App ID:"+responseObject);
		int status_code = responseObject.getStatus();
		log("Status Code for Blank App ID: "+status_code );
		assertEquals(status_code, 401);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		log("JSON manifestation of response: "+responseJSONObject.toJSONString());
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Blank APP ID from test Data: "+error_401_InvalidAppID);
		log("Error message from API, for Blank App ID: "+errorMessageFromAPIResponse);
		assertTrue(errorMessageFromAPIResponse.contains(error_401_InvalidAppID));
		newLine();
	}

	@Test
	public void test_206_NegativeTest_InvalidAPPID_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_206_NegativeTest_InvalidAPPID_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_id_valid, app_id+"invalid");
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		log("Response Object for Blank App ID:"+responseObject);
		int status_code = responseObject.getStatus();
		log("Status Code for Blank App ID: "+status_code );
		assertEquals(status_code, 401);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		log("JSON manifestation of response: "+responseJSONObject.toJSONString());
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Blank APP ID from test Data: "+error_401_InvalidAppID);
		log("Error message from API, for Blank App ID: "+errorMessageFromAPIResponse);
		assertTrue(errorMessageFromAPIResponse.contains(error_401_InvalidAppID));
		newLine();
	}

	@Test
	public void test_207_NegativeTest_InvalidCityName_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_207_NegativeTest_InvalidCityName_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_NonExistentCity, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		log("Response Object for Invalid City Name:"+responseObject);
		int status_code = responseObject.getStatus();
		log("Status Code for Non existent City name : "+status_code );
		assertEquals(status_code, 404);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		log("JSON manifestation of response: "+responseJSONObject.toJSONString());
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Non existent City name from test Data: "+error_404_Invalid_CityQuery);
		log("Error message from API, for Non existent City name : "+errorMessageFromAPIResponse);
		assertTrue(errorMessageFromAPIResponse.contains(error_404_Invalid_CityQuery));
		newLine();
	}

	@Test
	public void test_208_NegativeTest_InvalidCountryName_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_208_NegativeTest_InvalidCountryName_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_NonExistentCountry, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		log("Response Object for Invalid Country Name:"+responseObject);
		int status_code = responseObject.getStatus();
		log("Status Code for Non existent Country name : "+status_code );
		assertEquals(status_code, 404);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		log("JSON manifestation of response: "+responseJSONObject.toJSONString());
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Non existent Country name from test Data: "+error_404_Invalid_CityQuery);
		log("Error message from API, for Non existent Country name : "+errorMessageFromAPIResponse);
		assertTrue(errorMessageFromAPIResponse.contains(error_404_Invalid_CityQuery));
		newLine();
	}

	@Test
	public void test_209_NegativeTest_BlankCityName_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_209_NegativeTest_BlankCityName_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_BlankCityName, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		log("Response Object for Blank City Name:"+responseObject);
		int status_code = responseObject.getStatus();
		log("Status Code for Non existent Country name : "+status_code );
		assertEquals(status_code, 404);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		log("JSON manifestation of response: "+responseJSONObject.toJSONString());
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Blank City name from test Data: "+error_404_Invalid_CityQuery);
		log("Error message from API, for Blank City name : "+errorMessageFromAPIResponse);
		assertTrue(errorMessageFromAPIResponse.contains(error_404_Invalid_CityQuery));
		newLine();
	}

	@Test
	public void test_210_NegativeTest_BlankCountryName_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_210_NegativeTest_BlankCountryName_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_BlankCountryName, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		log("Response Object for Blank Country Name:"+responseObject);
		int status_code = responseObject.getStatus();
		log("Status Code for Non existent Country name : "+status_code );
		assertEquals(status_code, 404);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		log("JSON manifestation of response: "+responseJSONObject.toJSONString());
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Blank Country name from test Data: "+error_404_Invalid_CityQuery);
		log("Error message from API, for Blank Country name : "+errorMessageFromAPIResponse);
		assertTrue(errorMessageFromAPIResponse.contains(error_404_Invalid_CityQuery));
		newLine();
	}

	@Test
	public void test_211_NegativeTest_BlankCityAndCountryName_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_211_NegativeTest_BlankCityAndCountryName_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_BlankCityAndCountryName, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		log("Response Object for Blank City and Country Name:"+responseObject);
		int status_code = responseObject.getStatus();
		log("Status Code for Blank City and Country Name : "+status_code );
		assertEquals(status_code, 400);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		log("JSON manifestation of response: "+responseJSONObject.toJSONString());
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Blank City and Country Name from test Data: "+error_400_message);
		log("Error message from API, for Blank City and Country Name : "+errorMessageFromAPIResponse);
		assertTrue(errorMessageFromAPIResponse.contains(error_400_message));
		newLine();
	}

	@Test
	public void test_212_NegativeTest_BlankCityAndCountryName_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_211_NegativeTest_BlankCityAndCountryName_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_BlankCityAndCountryName, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		log("Response Object for Blank City and Country Name:"+responseObject);
		int status_code = responseObject.getStatus();
		log("Status Code for Blank City and Country Name : "+status_code );
		assertEquals(status_code, 400);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		log("JSON manifestation of response: "+responseJSONObject.toJSONString());
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Blank City and Country Name from test Data: "+error_400_message);
		log("Error message from API, for Blank City and Country Name : "+errorMessageFromAPIResponse);
		assertTrue(errorMessageFromAPIResponse.contains(error_400_message));
		newLine();
	}

	@Test
	public void test_212_NegativeTest_VeryBigNumber_ID_StatusCodeAndResponseBodyCheck(){
		newLine();
		log("Executing test ==> test_211_NegativeTest_BlankCityAndCountryName_StatusCodeAndResponseBodyCheck");
		String url = utils.createWeatherAPIURL(base_url, query_by_BigNumber, app_id);
		log("URL under test: "+url);
		responseObject = getmethod.getResponseObject(url);
		log("Response Object for Very Big number as ID:"+responseObject);
		int status_code = responseObject.getStatus();
		log("Status Code for Blank City and Country Name : "+status_code );
		assertEquals(status_code, 400);

		JSONObject responseJSONObject = data.transformClientResponseToJSONObject(responseObject);
		log("JSON manifestation of response: "+responseJSONObject.toJSONString());
		String errorMessageFromAPIResponse = responseJSONObject.get("message").toString();
		log("Error Message for Very Big number as ID from test Data: "+error_400_message);
		log("Error message from API, for Very Big number as ID : "+error_400_VeryBigNumber_ID_message);
		assertTrue(errorMessageFromAPIResponse.contains(error_400_VeryBigNumber_ID_message));
		newLine();
	}

	

}
