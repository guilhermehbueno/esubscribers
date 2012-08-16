package br.com.esub.plataform.poc.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.esub.plataform.poc.model.PreviewRequest;
import br.com.esub.plataform.poc.model.SingleCall;

public class MySplitterStrategy implements SplitterStrategy<SingleCall, PreviewRequest>{

	@Override
	public List<SingleCall> split(PreviewRequest request) {
		SingleCall sc1 = new SingleCall();
		SingleCall sc2 = new SingleCall();
		
		sc1.setRequest(request.getToken());
		sc2.setRequest(request.getIdProduto());
		
		List<SingleCall> calls = new ArrayList<SingleCall>();
		calls.add(sc1);
		calls.add(sc2);
		
		return calls;
	}
}
