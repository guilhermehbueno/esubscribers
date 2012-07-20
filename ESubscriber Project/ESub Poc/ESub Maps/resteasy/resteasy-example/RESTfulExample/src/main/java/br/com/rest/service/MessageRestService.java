package br.com.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import com.thoughtworks.xstream.XStream;

import br.com.rest.service.model.DistanceMatrixResponse;
 
/**
 * Chamada de exemplo: http://localhost:8080/rest/message/rua Roberto Simonsen, campinas, São Paulo/para/Francisco Glicério, Campinas - São Paulo
 * @author tr_gbueno
 *
 */
@Path("/message")
public class MessageRestService {
	static {
		 RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
	}
	
	private static final String DEFAULT_MODE="driving";
	private static final String DEFAULT_LANGUAGE="pt-BR";
	private static final String DEFAULT_SENSOR="false";
 
	@GET
	@Path("/{origem}/para/{destino}")
	public Response printMessage(@PathParam("origem") String origem, @PathParam("destino") String destino) {
		String result = "Restful example : " + origem + " - "+ destino;
		DistanceMatrixResponse resultado = getDistancia(origem, destino);
		return Response.status(200).entity(resultado).build();
	}
	
	private DistanceMatrixResponse getDistancia(List<String> origens, List<String> destinos){
		String origem = StringUtils.join(origens.iterator(), "|");
		String destino = StringUtils.join(destinos.iterator(), "|");
		DistanceMatrixResponse resultado = getDistancia(origem, destino);
		return resultado;
	}
	
	private DistanceMatrixResponse getDistancia(String origem, String destino){
		DistanceMatrixResponse resultado = new DistanceMatrixResponse();
		try {
			ClientRequest request = new ClientRequest("http://maps.googleapis.com/maps/api/distancematrix/xml?origins="+origem+"&destinations="+destino+"&mode="+DEFAULT_MODE+"&language="+DEFAULT_LANGUAGE+"&sensor="+DEFAULT_SENSOR);
			System.out.println(request.get().getEntity(String.class));
			ClientResponse<DistanceMatrixResponse> response = request.get(DistanceMatrixResponse.class);
			System.out.println(resultado = response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
 
}