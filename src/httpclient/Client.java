package httpclient;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

public class Client {
	
	public static void formPost() {
		
		HttpClient client = new HttpClient();
		
		
		
		
		
	}

	
	public static void main(String[] args) throws HttpException, IOException {
		
		
		HttpClient client = new HttpClient();
		
		HttpMethod method = new GetMethod("http://www.baidu.com");
		
		client.executeMethod(method);
		
		System.out.println(method.getStatusCode());
		System.out.println(method.getResponseBodyAsString());
		
		method.releaseConnection();

	}

}
