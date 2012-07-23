package br.com.esub.users.poc.oauth;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.jboss.resteasy.client.ClientRequest;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.esub.users.poc.oauth.facebook.Data;
import br.com.esub.users.poc.oauth.facebook.Friends;

@Resource()
@Path("oauth")
public class OAuthController {
	
	private static final String TOKEN_URL = "https://graph.facebook.com/oauth/access_token?";
	private static final String APP_ID="client_id=178743972258394&";
	private static final String YOUR_REDIRECT_URI="redirect_uri=http://localhost:8080/oauth/facebook&";
	private static final String YOUR_APP_SECRET= "client_secret=c17c70d144a1354df1525e5d32212447&";
	private static final String FRIENDS = "https://graph.facebook.com/me/friends?";

	private final HttpServletRequest request;
	private final Result result;

	public OAuthController(HttpServletRequest request, Result result) {
		super();
		this.request = request;
		this.result = result;
	}

	public void facebook(String code) {
		try {
			System.out.println("Code recebido: "+code);
			String chamada = TOKEN_URL+APP_ID+YOUR_REDIRECT_URI+YOUR_APP_SECRET+"code="+code;
			String acessToken = sendRequestPost(null, chamada);
			System.out.println("Access Token recebido: "+acessToken);
			Friends friends = getFriends(acessToken);
			List<Data> amigos = friends.getData();
			for (Data data : amigos) {
				System.out.println("Amigo: "+data.getId()+ " - "+ data.getName());
			}
			this.result.include("amigos", amigos);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void twitter() throws Exception {
		HttpSession session = this.request.getSession();
		if(session.getAttribute("twitter")==null){
			Twitter twitter = new TwitterFactory().getInstance();
	        twitter.setOAuthConsumer("cKkKXl66vjmGzSfRm6YAYg", "GXdzt0ScXml6F0HZV4Zi5nlU5IJSNXlBwcT4QR8Uc");
	        System.out.println("Instanciando twitter com : "+twitter);
			
	        System.out.println("Solicitando request token...");
			RequestToken requestToken = twitter.getOAuthRequestToken();
			System.out.println("requestToken recebido: "+requestToken);
			
			request.getSession().setAttribute("requestToken", requestToken);
			request.getSession().setAttribute("twitter", twitter);
			System.out.println("requestToken.getAuthenticationURL(): "+ requestToken.getAuthenticationURL());
			result.redirectTo(requestToken.getAuthenticationURL());
		}else{
			Twitter twitter = (Twitter) session.getAttribute("twitter");
			RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
			
			if(requestToken==null){
				request.getSession().setAttribute("twitter", null);
				result.redirectTo("/oauth/twitter");
			}
			System.out.println("RequestToken: "+requestToken);
	        String verifier = request.getParameter("oauth_verifier");
	        
	        if(verifier==null){
	        	request.getSession().setAttribute("twitter", null);
				result.redirectTo("/oauth/twitter");
	        }
	        
	        System.out.println("verifier: "+verifier);
	        twitter.getOAuthAccessToken(requestToken, verifier);
	        request.getSession().removeAttribute("requestToken");
			
			List<Status> statuses = twitter.getHomeTimeline();
			System.out.println("Showing friends timeline.");
			for (Status status : statuses) {
			     System.out.println(status.getUser().getName() + ":" +status.getText());
			}
			this.result.include("amigos", statuses);
		}
	}

	public void google() {

	}
	
	
	private String sendRequestPost(String request, String uri) throws IOException, HttpException {
		System.out.println("Enviando um Post: "+uri);
		PostMethod method = new PostMethod(uri);
		try {
			new HttpClient().executeMethod(method);
			return new String(method.getResponseBody(),"UTF-8");
		} finally {
		method.releaseConnection();
		}
	}
	
	private Friends getFriends(String accessToken){
		System.out.println("Access Token: "+accessToken);
		Friends resultado = new Friends();
		try {
			ClientRequest request = new ClientRequest(FRIENDS+accessToken);
			String load =  (String) request.get().getEntity(String.class);
			System.out.println(load);
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.alias("data", Data.class);
			xstream.alias("name", String.class);
			xstream.alias("id", String.class);
			xstream.addImplicitCollection(Data.class, "data");
			Data data = (Data) xstream.fromXML(load);
			System.out.println(data);
			resultado.setData(data.getData());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
}
