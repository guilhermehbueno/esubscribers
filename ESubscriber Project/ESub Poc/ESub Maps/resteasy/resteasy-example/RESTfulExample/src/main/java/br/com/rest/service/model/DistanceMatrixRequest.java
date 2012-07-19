package br.com.rest.service.model;

public class DistanceMatrixRequest {
	
	/*http://maps.googleapis.com/maps/api/distancematrix/xml?origins=Seattle&destinations=Vancouver+BC&mode=bicycling&language=fr-FR&sensor=false*/
	private String origins;
	private String destinations;
	private String mode;
	private String language;
	private String sensor;

}
