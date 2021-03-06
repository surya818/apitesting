package framework;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * This class holds the functionality of programatically accessing an API
 * @author Surya Rekha
 *
 */
public class GetMethodRequest implements RESTGET{
	
	/**
	 * 
	 */
	public ClientResponse getResponseObject(String url) {
		Client cli = Client.create();
		WebResource wr = cli.resource(url);
		ClientResponse resp = wr.get(ClientResponse.class);
		return resp; 
	}
	
	/**
	 * This method accesses the specified REST URL and returns the response as a String
	 * @param url
	 * @return String representation of json response
	 */
	public String getResponseObjectInString(String url) {
		
		Client cli = Client.create();
		WebResource wr = cli.resource(url);
		String resp = wr.get(String.class);
		return resp; 
	}
	
	/**
	 * This method builds a REST API request with specified URL and headers
	 * @param url
	 * @param HeaderName
	 * @param HeaderValue
	 * @return ClientResponse object
	 */
	public ClientResponse getResponseObject(String url,String HeaderName,String HeaderValue) {
		Client cli = Client.create();
		WebResource wr = cli.resource(url);
		ClientResponse resp = wr.header(HeaderName, HeaderValue).get(ClientResponse.class);
		return resp;
	}
	
	/**
	 * This method accesses the REST API through specified url and returns the response status code 
	 * @param url
	 * @return int Status code of the response
	 */
	public int getResponseCode(String url) {
		ClientResponse resp = getResponseObject(url);
		int status_code = resp.getStatus();
		return status_code;
	}



	
	
}
