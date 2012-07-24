package br.com.esub.users.poc.google.oauth;

import org.jboss.resteasy.client.ClientRequest;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.esub.users.poc.oauth.OAuthUserTokens;

@Resource
@Path("oauth/google")
public class GoogleOAuth{

	/*
	 GOOGLE OAUTH:
	 
	APÓS CLICAR EM NOSSO LINK DE AUTENTICACAO:
	 => CONFIGURAR CONSUMER_KEY, CONSUMER_SECRET
	 => RECUPERAR REQUEST_TOKEN
	 => ARMAZENAR REQUEST_TOKEN
	 => RECUPERAR URL DE AUTORIZACAO QUE O USUARIO SERA REDIRECIONADO
	 => REDIRECIONAR USUARIO
	
	APÓS AUTORIZACAO DO USUÁRIO:
	 => RECUPERAR O CÓDIGO VERIFIER QUE VEIO NA REQUISICAO
	 => RECUPERAR ACCESS_TOKEN COM O VERIFIER E O REQUEST_TOKEN
	 */
	
	private final Result result;
	private final OAuthUserTokens tokens;
	
	public GoogleOAuth(Result result, OAuthUserTokens tokens) {
		super();
		this.result = result;
		this.tokens = tokens;
	}
	
	private final String URL_LOGIN_GOOGLE   = "https://accounts.google.com/o/oauth2/auth?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile&state=%2Fprofile&redirect_uri=http://localhost:8080/oauth/google/callback&response_type=code&client_id=298758427991-76iaupg0c9upsma5dgil3d6k1h6akjmf.apps.googleusercontent.com"; 
	
	@Path("login")
	public void process() {
		this.result.redirectTo(URL_LOGIN_GOOGLE);
	}

	@Path("callback")
	public void callbackProcess(String state, String code) {
		System.out.println("state: " + state);
		System.out.println("code: " + code);
		AccessToken token = getGoogleAccessToken(new AccessRequest(code, state));
		token.setName("google");
		tokens.addToken(token);
		this.result.redirectTo("/oauth/google");
	}
	
	
	public AccessToken getGoogleAccessToken(AccessRequest accessRequest) {
		try {
			ClientRequest request = new ClientRequest("https://accounts.google.com/o/oauth2/token");			
			request.accept("application/x-www-form-urlencoded");
			String data = "code="+ accessRequest.getCode()
					+ "&client_id=298758427991-76iaupg0c9upsma5dgil3d6k1h6akjmf.apps.googleusercontent.com&client_secret=PTT_cgqmIW6pU2hGWqsJiwXy&redirect_uri=http://localhost:8080/oauth/google/callback&grant_type=authorization_code";
			request.body("application/x-www-form-urlencoded", data);
			AccessToken load = (AccessToken) request.post().getEntity(AccessToken.class);
			System.out.println(load);
			return load;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



}
