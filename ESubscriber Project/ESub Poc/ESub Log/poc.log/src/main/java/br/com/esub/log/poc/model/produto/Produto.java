package br.com.esub.log.poc.model.produto;

public class Produto {
	
	private String id;
	private String nome;
	
	public Produto(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Produto() {
		super();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}