package br.com.esub.users.poc.google.oauth;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.esub.users.poc.oauth.OAuthToken;

/**
{
  "access_token" : "ya29.AHES6ZTwsKsBoexcdglEtAsN1HO9E1CclLNSoEKusuUkgYtr6npRxg",
  "token_type" : "Bearer",
  "expires_in" : 3600,
  "id_token" : "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXVkIjoiMjk4NzU4NDI3OTkxLTc2aWF1cGcwYzl1cHNtYTVkZ2lsM2Q2azFoNmFram1mLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiY2lkIjoiMjk4NzU4NDI3OTkxLTc2aWF1cGcwYzl1cHNtYTVkZ2lsM2Q2azFoNmFram1mLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiaWQiOiIxMTQ3MjMyODk2MDA3NjQ3ODU4MTgiLCJlbWFpbCI6ImVzdXNjcmliZXJzQGdtYWlsLmNvbSIsInZlcmlmaWVkX2VtYWlsIjoidHJ1ZSIsInRva2VuX2hhc2giOiI4RFlyTkVjSGduMVhBaDFoYVdYanFBIiwiaWF0IjoxMzQzMTI5NzEwLCJleHAiOjEzNDMxMzM2MTB9.ANvQv9lepmogqBizLXgmjeMWtoWCNWy5zxpa4763jk6fEybgnc1uIK5MwDforCIpMPrJn5df23S0FajWwkesU7CU5zUsHrmFQgoJyJ16tjh3gPWcUQd9g94CqOejfhW3pW9Wv8kdcVe2gf6AbmJg4HWykyBOrchC1mLVPhJ-CgI"
}
 */

@XmlRootElement
public class AccessToken implements OAuthToken{
	
	
	private String access_token;
	private String token_type;
	private String expires_in;
	private String id_token;
	private String name;
	private String error;
	
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	public String getId_token() {
		return id_token;
	}
	public void setId_token(String id_token) {
		this.id_token = id_token;
	}
	
	public String getToken() {
		return this.access_token;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "AccessToken [access_token=" + access_token + ", token_type="
				+ token_type + ", expires_in=" + expires_in + ", id_token="
				+ id_token + ", name=" + name + ", error=" + error + "]";
	}
}
