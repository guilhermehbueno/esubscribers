package br.com.esub.users.poc.twitter.oauth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.esub.users.poc.oauth.OAuthUserTokens;

@Resource
@Path("oauth/twitter")
public class TwitterOAuth{
	
	/*
	 TWITTER OAUTH:
	 
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
	private final HttpServletRequest request;
	private final HttpSession session;
	
	public TwitterOAuth(Result result, OAuthUserTokens tokens,
			HttpServletRequest request) {
		super();
		this.result = result;
		this.tokens = tokens;
		this.request = request;
		this.session = this.request.getSession();
	}

	@Path("login")
	public void process() throws Exception {
		System.out.println("Processando twitter");
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer("cKkKXl66vjmGzSfRm6YAYg", "GXdzt0ScXml6F0HZV4Zi5nlU5IJSNXlBwcT4QR8Uc");
		this.request.getSession().setAttribute("twitter", twitter);
		RequestToken requestToken = twitter.getOAuthRequestToken();
		this.request.getSession().setAttribute("requestToken", requestToken);
		this.result.redirectTo(requestToken.getAuthenticationURL());
	}
	
	@Path("callback")
	public void callbackProcess() {
		try{
			Twitter twitter = (Twitter) this.request.getSession().getAttribute("twitter");
			RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
			String verifier = request.getParameter("oauth_verifier");
			
			if (verifier == null || twitter == null) {
				request.getSession().setAttribute("twitter", null);
				result.redirectTo("/oauth/twitter/login");
			}
			
			twitter.getOAuthAccessToken(requestToken, verifier);
			request.getSession().removeAttribute("requestToken");
			this.result.redirectTo("/oauth/twitter");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
