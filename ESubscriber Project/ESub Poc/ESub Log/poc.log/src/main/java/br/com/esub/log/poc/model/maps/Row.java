package br.com.esub.log.poc.model.maps;

import java.util.List;

public class Row {
	private List<Element> element;

	public List<Element> getElement() {
		return element;
	}

	public void setElement(List<Element> element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return "Row [element=" + element + "]";
	}
	
}
