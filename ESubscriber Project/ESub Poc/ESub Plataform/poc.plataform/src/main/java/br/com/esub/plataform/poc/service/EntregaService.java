package br.com.esub.plataform.poc.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

@Path("/entrega")
public class EntregaService {

	@GET
	@Path("/preview")
	public Response preview(String produto, String token) {
		System.out.println("Executando plataform/preview");
		try {
			ClientRequest request = new ClientRequest("http://localhost:8080/log/entrega/preview?produto="+produto+"&token=" + token);
			System.out.println(request.get().getEntity(String.class));
			ClientResponse<String> response = request.get(String.class);
			System.out.println(response.getEntity());
			return Response.status(200).entity(response.getEntity()).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
