package br.com.esub.plataform.poc.strategy;

import java.util.List;

public interface SplitterStrategy<T, K>{
	
	
	public List<T> split(K object);

}
