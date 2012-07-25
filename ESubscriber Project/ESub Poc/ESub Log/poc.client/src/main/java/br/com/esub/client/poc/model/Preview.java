package br.com.esub.client.poc.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="preview")
public class Preview implements Serializable{
	
	private Endereco endereco;
	private Distance distance;
	private Duration duration;
	private Produto produto;
	private Double preco;
	
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
}
