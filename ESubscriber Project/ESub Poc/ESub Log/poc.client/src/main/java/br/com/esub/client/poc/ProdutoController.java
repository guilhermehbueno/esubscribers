package br.com.esub.client.poc;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.esub.client.poc.model.Preview;
import br.com.esub.client.poc.model.Produto;

@Resource
@SessionScoped
@Path("produto")
public class ProdutoController {
	
	private final Result result;
	private static Map<String,Produto> produtos = new HashMap<String,Produto>();
	
	public ProdutoController(Result result) {
		super();
		this.result = result;
		
		Produto produto1 = new Produto();
		produto1.setId(UUID.randomUUID().toString());
		produto1.setNome("Produto 1");
		produto1.setPreco(10.0);
		
		Produto produto2 = new Produto();
		produto2.setId(UUID.randomUUID().toString());
		produto2.setNome("Produto 2");
		produto2.setPreco(10.0);
		
		Produto produto3 = new Produto();
		produto3.setId(UUID.randomUUID().toString());
		produto3.setNome("Produto 3");
		produto3.setPreco(10.0);
		
		produtos.put(produto1.getId(),produto1);
		produtos.put(produto2.getId(), produto2);
		produtos.put(produto3.getId(),produto3);
	}

	public void list(){
		System.out.println("produto/list");
		this.result.include("produtos", produtos.values());
	}
	
	@Path("view/{idProduto}")
	public void view(String idProduto){
		System.out.println("produto/view/"+idProduto);
		Produto produto = produtos.get(idProduto);
		this.result.include("produto", produto);
	}
	
	@Path("preview/{idProduto}")
	public void preview(String idProduto){
		System.out.println("produto/preview/"+idProduto);
		try {
			ClientRequest request = new ClientRequest("http://localhost:8080/plataform/rest/entrega/preview?token="+UUID.randomUUID().toString()+"&produto="+idProduto);
			System.out.println(request.get().getEntity(String.class));
			ClientResponse<Preview> response = request.get(Preview.class);
			System.out.println(response.getEntity());
			this.result.include("preview", response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
