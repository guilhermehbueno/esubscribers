package br.com.esub.users.poc.oauth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jboss.resteasy.client.ClientRequest;

import twitter4j.Status;
import twitter4j.Twitter;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.esub.users.poc.facebook.model.Data;
import br.com.esub.users.poc.facebook.model.Friends;
import br.com.esub.users.poc.google.model.UserInfo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

@Resource()
@Path("oauth")
public class OAuthController {

	private final OAuthUserTokens tokens;
	private static final String FRIENDS = "https://graph.facebook.com/me/friends?";
	private static final String URL_GOOGLE_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";

	private final HttpServletRequest request;
	private final Result result;

	public OAuthController(HttpServletRequest request, Result result, OAuthUserTokens tokens) {
		super();
		this.request = request;
		this.result = result;
		this.tokens = tokens;
	}

	public void facebook() {
		try {
			OAuthToken token= this.tokens.getTokenByName("facebook");
			System.out.println("Access Token recebido: " + token.getToken());
			Friends friends = getFriends(token.getToken());
			List<Data> amigos = friends.getData();
			for (Data data : amigos) {
				System.out.println("Amigo: " + data.getId() + " - "+ data.getName());
			}
			this.result.include("amigos", amigos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void twitter() throws Exception {
		Twitter twitter = (Twitter) this.request.getSession().getAttribute("twitter");
		List<Status> statuses = twitter.getHomeTimeline();
		System.out.println("Showing friends timeline.");
		for (Status status : statuses) {
			System.out.println(status.getUser().getName() + ":"+ status.getText());
		}
		this.result.include("amigos", statuses);
	}

	public void google() {
		UserInfo userInfo = getGoogleUserInfo(this.tokens.getTokenByName("google"));
		this.result.include("userInfo", userInfo);
	}

	private Friends getFriends(String accessToken) {
		System.out.println("Access Token: " + accessToken);
		Friends resultado = new Friends();
		try {
			ClientRequest request = new ClientRequest(FRIENDS + accessToken);
			String load = (String) request.get().getEntity(String.class);
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

	public UserInfo getGoogleUserInfo(OAuthToken token) {
		System.out.println("Access Token: " + token.getToken());
		try {
			ClientRequest request = new ClientRequest(URL_GOOGLE_INFO+token.getToken());
			request.accept("application/x-www-form-urlencoded");
			UserInfo load = (UserInfo) request.get().getEntity(UserInfo.class);
			System.out.println(load);
			return load;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
