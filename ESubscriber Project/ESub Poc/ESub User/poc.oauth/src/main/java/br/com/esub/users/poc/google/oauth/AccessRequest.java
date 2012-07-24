package br.com.esub.users.poc.google.oauth;

public class AccessRequest {
	
	private final String code;
	private final String state;
	
	public AccessRequest(String code, String state) {
		super();
		this.code = code;
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public String getState() {
		return state;
	}
}
