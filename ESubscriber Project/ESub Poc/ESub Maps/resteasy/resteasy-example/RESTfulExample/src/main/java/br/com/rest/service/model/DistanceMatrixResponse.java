package br.com.rest.service.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DistanceMatrixResponse")
public class DistanceMatrixResponse implements Serializable{
	
	private String status;
	private List<String> origin_address;
	private List<String> destination_address;
	private List<Row> row;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getOrigin_address() {
		return origin_address;
	}

	public void setOrigin_address(List<String> origin_address) {
		this.origin_address = origin_address;
	}

	public List<String> getDestination_address() {
		return destination_address;
	}

	public void setDestination_address(List<String> destination_address) {
		this.destination_address = destination_address;
	}

	public List<Row> getRow() {
		return row;
	}

	public void setRow(List<Row> row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "DistanceMatrixResponse [status=" + status + ", origin_address="
				+ origin_address + ", destination_address="
				+ destination_address + ", row=" + row + "]";
	}
}
