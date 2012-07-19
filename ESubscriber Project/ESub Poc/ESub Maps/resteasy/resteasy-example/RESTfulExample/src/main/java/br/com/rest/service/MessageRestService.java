package br.com.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import br.com.rest.service.model.DistanceMatrixResponse;
 
@Path("/message")
public class MessageRestService {
	
	static {
		// precisa ser chamo uma única vez para registrar providers RESTEasy, scanear classes, etc
		 RegisterBuiltin.register(ResteasyProviderFactory.getInstance()); // precisa ser chamado uma única vez para
	}
 
	@GET
	@Path("/{origem}/para/{destino}")
	/*
	 * http://localhost:8080/rest/message/Guilherme/para/bueno
	*/
	public Response printMessage(@PathParam("origem") String origem, @PathParam("destino") String destino) {
		String result = "Restful example : " + origem + " - "+ destino;
		
		try {
			ClientRequest request = new ClientRequest("http://maps.googleapis.com/maps/api/distancematrix/xml?origins="+origem+"&destinations="+destino+"&mode=bicycling&language=fr-FR&sensor=false");
			request.accept("application/xml");
			ClientResponse<DistanceMatrixResponse> response = request.get(DistanceMatrixResponse.class);
			System.out.println(" TESTE: "+response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return Response.status(200).entity(result).build();
	}
 
}