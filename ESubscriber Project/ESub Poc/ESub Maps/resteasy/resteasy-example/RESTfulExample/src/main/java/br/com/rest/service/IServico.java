package br.com.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.rest.service.model.DistanceMatrixResponse;

public interface IServico {
	
	@GET @Path("http://maps.googleapis.com/maps/api/distancematrix/xml")
	@Produces("text/xml")
	public DistanceMatrixResponse getDistancia();

}
