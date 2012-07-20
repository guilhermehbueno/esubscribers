package br.com.esub.users.poc.oauth.facebook;

import java.io.IOException;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

@Resource
public class TesteController {
	
	private static final String TOKEN_URL = "https://graph.facebook.com/oauth/access_token?";
	private static final String APP_ID="client_id=181926225207193&";
	private static final String YOUR_REDIRECT_URI="redirect_uri=http://localhost:8080/teste/token&";
	private static final String YOUR_APP_SECRET= "client_secret=a8d0dc676bce758bf2bec94ca96434f2&";
	private static final String FRIENDS = "https://graph.facebook.com/me/friends?";
	private final Result result;
	
	public TesteController(Result result) {
		super();
		this.result = result;
	}

	public void token(String code){
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
			this.result.include("mensagem", "Deu certo?");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Friends getFriends(String accessToken){
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
	
	private String sendRequestGet(String request, String uri) throws IOException, HttpException {
		System.out.println("Enviando um Get: "+uri);
		GetMethod method = new GetMethod(uri);
		try {
			new HttpClient().executeMethod(method);
			return new String(method.getResponseBody(),"UTF-8");
		} finally {
		method.releaseConnection();
		}
	}
}
