package br.com.esub.log.poc.model.produto;

public class Produto {
	
	private String id;
	private String nome;
	private String preco;
	
	private Fornecedor fornecedor;
	
	public Produto(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Produto() {
		super();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}
}
