package br.com.esub.log.poc.model.entrega;

import br.com.esub.log.poc.model.produto.Produto;
import br.com.esub.log.poc.model.user.Usuario;

public class PreviewRequest {
	
	/*
	<PreviewRequest>
		<token></token>
		<produtoId></produtoId>
	</PreviewRequest>
	*/
	private String token;
	private String produtoId;
	private Produto produto;
	private Usuario usuario;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(String produtoId) {
		this.produtoId = produtoId;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
