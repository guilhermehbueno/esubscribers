package br.com.esub.users.poc.facebook.oauth;

import org.jboss.resteasy.client.ClientRequest;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.esub.users.poc.oauth.OAuthUserTokens;

@Resource
@Path("oauth/facebook")
public class FacebookOAuth{
	
	private final static String URL_LOGIN_FACEBOOK="https://www.facebook.com/dialog/oauth?client_id=178743972258394&redirect_uri=http://localhost:8080/oauth/facebook/callback?&response_type=code";
	private static final String TOKEN_URL = "https://graph.facebook.com/oauth/access_token?";
	private static final String APP_ID = "client_id=178743972258394&";
	private static final String YOUR_REDIRECT_URI = "redirect_uri=http://localhost:8080/oauth/facebook/callback&";
	private static final String YOUR_APP_SECRET = "client_secret=c17c70d144a1354df1525e5d32212447&";
	
	private final Result result;
	private final OAuthUserTokens tokens;
	
	public FacebookOAuth(Result result, OAuthUserTokens tokens) {
		super();
		this.result = result;
		this.tokens = tokens;
	}
	
	@Path("login")
	public void login(){
		this.result.redirectTo(URL_LOGIN_FACEBOOK);
	}

	@Path("callback")
	public void callbackProcess(String code) {
		try {
			System.out.println("Code recebido: " + code);
			String chamada = TOKEN_URL + APP_ID + YOUR_REDIRECT_URI+ YOUR_APP_SECRET + "code=" + code;
			
			ClientRequest request = new ClientRequest(chamada);
			String acessToken = (String) request.post().getEntity(String.class);
			
			System.out.println("Access Token recebido: " + acessToken);
			this.tokens.addToken(new FacebookOAuthUserToken(acessToken));
			this.result.redirectTo("/oauth/facebook");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
