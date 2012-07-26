package br.com.esub.plataform.poc.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

@Path("/entrega")
public class EntregaService {

	@GET
	@Path("/preview")
	public Response preview(@QueryParam(value = "produto") String produto, @QueryParam(value = "token") String token) {
		System.out.println("Executando plataform/preview: produto="+produto+ ", token="+token);
		if(StringUtils.isEmpty(token) || StringUtils.isEmpty(produto)){
			throw new IllegalArgumentException("Token e produto são obrigatórios na chamada.");
		}
		
		try {
			ClientRequest request = new ClientRequest("http://localhost:8080/log/rest/entrega/preview?produto="+produto+"&token=" + token);
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
