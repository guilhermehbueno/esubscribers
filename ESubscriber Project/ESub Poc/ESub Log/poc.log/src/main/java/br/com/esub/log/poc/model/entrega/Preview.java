package br.com.esub.log.poc.model.entrega;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.esub.log.poc.model.endereco.Endereco;
import br.com.esub.log.poc.model.maps.Distance;
import br.com.esub.log.poc.model.maps.DistanceMatrixResponse;
import br.com.esub.log.poc.model.maps.Duration;
import br.com.esub.log.poc.model.maps.Element;
import br.com.esub.log.poc.model.produto.Produto;
import br.com.esub.log.poc.util.maps.DistanceMatrixUtil;

@XmlRootElement(name="preview")
public class Preview implements Serializable{
	
	private Endereco endereco;
	private Distance distance;
	private Duration duration;
	
	private Produto produto;
	private Double preco;
	
	public Preview() {
		super();
	}

	private Preview(Endereco endereco, Distance distance, Duration duration) {
		super();
		this.endereco = endereco;
		this.distance = distance;
		this.duration = duration;
	}
	
	public static Preview build(DistanceMatrixResponse matrixResponse){
		Element element = DistanceMatrixUtil.getBetterElement(matrixResponse);
		return new Preview(new Endereco(matrixResponse.getOrigin_address().get(0)), element.getDistance(), element.getDuration());
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Distance getDistance() {
		return distance;
	}

	public void setDistance(Distance distance) {
		this.distance = distance;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Preview [endereco=" + endereco + ", distance=" + distance
				+ ", duration=" + duration + ", produto=" + produto
				+ ", preco=" + preco + "]";
	}
}
