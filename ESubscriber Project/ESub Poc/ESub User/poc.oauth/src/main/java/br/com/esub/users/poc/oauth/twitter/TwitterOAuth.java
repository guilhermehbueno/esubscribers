package br.com.esub.users.poc.oauth.twitter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

public class TwitterOAuth {
	
	private final static String URL_REQUEST_TOKEN = "https://api.twitter.com/oauth/request_token?oauth_callback=http://127.0.0.1:8080/oauth/twitter";
	private final static String URL_AUTHENTICATE = "https://api.twitter.com/oauth/authenticate?";
	
	/**
	 * @throws Exception
	 */
	public void getRequestToken() throws Exception{
		System.out.println("Enviando Post para: "+URL_REQUEST_TOKEN);
		ClientRequest request = new ClientRequest(URL_REQUEST_TOKEN);
		ClientResponse<String> response = request.post(String.class);
		System.out.println("Status retornado: "+ response.getStatus());
		System.out.println("Resposta: "+response);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(response.getEntity().getBytes())));
	 
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		
		
	}
	
	public void redirecionaUsuario(){
		
	}
	
	public void getAccessToken(){
		
	}
	
	public static void main(String[] args) throws Exception {
		new TwitterOAuth().getRequestToken();
	}
}
