package br.com.esub.users.poc.oauth.google;

public class GoogleConstants {
	
	private static final String URL_ACCESS_TOKEN = "https://accounts.google.com/o/oauth2/token";
	private static final String URL_CLIENT_ID="client_id=298758427991-76iaupg0c9upsma5dgil3d6k1h6akjmf.apps.googleusercontent.com";
	private static final String URL_CLIENT_SECRET="client_secret=PTT_cgqmIW6pU2hGWqsJiwXy";
	private static final String URL_REDIRECT_URI="redirect_uri=http://localhost:8080/oauth/google";
	
	public static String montarUrlParaAccessToken(String code){
		StringBuilder sb = new StringBuilder();
		sb.append(URL_ACCESS_TOKEN)
			.append("?")
			.append("code="+code)
			.append("&")
			.append(URL_CLIENT_ID)
			.append("&")
			.append(URL_CLIENT_SECRET)
			//.append("&")
			//.append(URL_REDIRECT_URI)
			.append("&")
			.append("grant_type=authorization_code");
		
		System.out.println("URL: "+ sb.toString());
		return sb.toString();
	}

}
