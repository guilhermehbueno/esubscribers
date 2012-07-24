package br.com.esub.users.poc.facebook.oauth;

import br.com.esub.users.poc.oauth.OAuthToken;

public class FacebookOAuthUserToken implements OAuthToken{
	
	private final String token;
	
	public FacebookOAuthUserToken(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}

	public String getName() {
		return "facebook";
	}
}
