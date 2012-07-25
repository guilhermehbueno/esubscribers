package br.com.esub.log.poc.clients;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import br.com.esub.log.poc.model.maps.DistanceMatrixResponse;


public class GoogleMapsClient {
	
	private static final String DEFAULT_MODE="driving";
	private static final String DEFAULT_LANGUAGE="pt-BR";
	private static final String DEFAULT_SENSOR="false";
	
	public static DistanceMatrixResponse getDistancia(String origem, String destino){
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
