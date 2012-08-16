package br.com.esub.log.poc.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;

import br.com.esub.log.poc.clients.GoogleMapsClient;
import br.com.esub.log.poc.model.entrega.Preview;
import br.com.esub.log.poc.model.entrega.PreviewRequest;
import br.com.esub.log.poc.model.maps.DistanceMatrixResponse;
import br.com.esub.log.poc.model.produto.Produto;

@Path("/entrega")
public class EntregaService {
	
	
	@GET
	@Path("preview")
	public Response preview(@QueryParam("token") String token, @QueryParam("produto") String idProduto){
		if(StringUtils.isEmpty(token) || StringUtils.isEmpty(idProduto)){
			throw new IllegalArgumentException("Token e produto são obrigatórios na chamada.");
		}
		
		String origem = "Rua Roberto Simonsen, Campinas - São Paulo";
		String destino = "Francisco Glicério, Campinas - São Paulo";
		
		//TODO: ESTE METODO DEVERA RECUPERAR TODOS OS ENDERECOS DO USUARIO PARA EXIBIR NO PREVIEW
		PreviewRequest previewRequest = getInformacoesAdicionais(token, idProduto);
		
		DistanceMatrixResponse distanceMatrixResponse = GoogleMapsClient.getDistancia(previewRequest.getProduto().getFornecedor().getEndereco(), previewRequest.getUsuario().getEndereco());
		Preview preview = Preview.build(distanceMatrixResponse);
		preview.setProduto(previewRequest.getProduto());
		preview.setPreco(10.0);
		
		System.out.println("Retornando o preview: "+preview);
		return Response.status(200).entity(preview).build();
	}
	
	@GET
	@Path("previews")
	public Response previews(@QueryParam("token") String token, @QueryParam("produto") String idProduto){
		return preview(token, idProduto);
	}
	
	private PreviewRequest getInformacoesAdicionais(String token, String idProduto){
		//TODO: IMPLEMENTAR REGRA DE RECUPERAR PRODUTO E USUARIO ASSINCRONAMENTE
		PreviewRequest previewRequest = new PreviewRequest();
		previewRequest.setToken(token);
		previewRequest.setProdutoId(idProduto);
		
		//TODO: ESTE PRODUTO DEVERA SER RECUPERADO ATRAVES DE SEU ID
		Produto produtoSelecionado = new Produto(idProduto, "Produto Selecionado");
		return previewRequest;
	}

}
