package br.com.rest.service.model;

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
