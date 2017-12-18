package data;
 
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.jersey.api.client.ClientResponse;

/**
 * This class has functionality that transforms 
 * JSON Response Object to Java objects 
 * like Maps(for Response objects) and also as POJOs
 * 
 */
public class JSONData {
	
	/**
	 * This method transforms a JSON String Response to a POJO of specified type in the parameters
	 * @param response of type ClientResponse
	 * @param t For transforming the response to a POJO
	 * @return Returns the object of specified type t
	 */
	public <T> T transformJSONResponseIntoPOJO(String response,Class<T> t){
		
		ObjectMapper mapper = new ObjectMapper();
		T responsePojo = null;
		try {
			responsePojo = (T) mapper.readValue(response, t);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responsePojo;
	}
	
	/**
	 * This method transforms a ClientResponse object to a Map
	 * @param response
	 * @return Map A response object transformed as Java Map object
	 */
	public Map<String,?> transfromJSONAsMap(ClientResponse response){
		
		InputStream stream = response.getEntityInputStream();
		ContainerFactory cf = new ContainerFactory() {
			
			public Map createObjectContainer() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public List creatArrayContainer() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		JSONParser parser = new JSONParser();
		HashMap<String,?> outMap = null;
		try {
			outMap = (HashMap<String,?>) parser.parse(new InputStreamReader(stream), cf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outMap;
	}
	
	/**
	 * This method checks if the specified parameter exists as an attribute in the response Map object
	 * @param jsonObject
	 * @param attributeName
	 * @return boolean of attribute exists or not
	 */
	public boolean attributeExists(HashMap<String, ?> jsonObject,String attributeName){
		boolean atttributeexists = jsonObject.containsKey(attributeName);
		return atttributeexists;
		
	}
	
	/**
	 * Returns the attribute(value) of specified key from the Map param
	 * @param jsonObject
	 * @param attributeName
	 * @return Object i.e, the value of the specified key
	 */
	public Object getAttributeValue(HashMap<String, ?> jsonObject,String attributeName){
		
		Object o =  jsonObject.get(attributeName);
		return o;
		
	}
	
	/**
	 * This method takes an Object of type ClientResponse and
	 * transforms that into an object of type JSONObject
	 * @param response
	 * @return JSONObject transformed from object of type ClientResponse 
	 */
	public JSONObject transformClientResponseToJSONObject(ClientResponse response){
		InputStream stream = response.getEntityInputStream();
		InputStreamReader reader = new InputStreamReader(stream);
		JSONParser parser = new JSONParser();
		JSONObject responseJSONObject = null;
		try {
			responseJSONObject = (JSONObject)parser.parse(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseJSONObject;
	}
				
		
	}


