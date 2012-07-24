package br.com.esub.users.poc.oauth;

import java.util.*;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Resource
@SessionScoped
public class OAuthUserTokens {
	
	private Set<OAuthToken> tokens = new HashSet<OAuthToken>();
	
	public OAuthToken getTokenByName(String name){
		System.out.println("Procurando token: "+name);
		for (OAuthToken token : this.tokens) {
			if(token.getName().equalsIgnoreCase(name)){
				return token;
			}
		}
		
		return null;
	}
	
	public void addToken(OAuthToken token){
		System.out.println("Adiciona token: "+token);
		this.tokens.add(token);
	}
}
