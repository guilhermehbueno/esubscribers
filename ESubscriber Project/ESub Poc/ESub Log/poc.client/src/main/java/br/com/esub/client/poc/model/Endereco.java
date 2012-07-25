package br.com.esub.client.poc.model;

public class Endereco {
	
	private String id;
	private String endereco;
	
	public Endereco() {
		super();
	}

	public Endereco(String endereco) {
		super();
		this.endereco = endereco;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
