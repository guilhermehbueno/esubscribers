package br.com.esub.log.poc.util.maps;

import java.util.List;

import br.com.esub.log.poc.model.maps.DistanceMatrixResponse;
import br.com.esub.log.poc.model.maps.Element;
import br.com.esub.log.poc.model.maps.Row;

public class DistanceMatrixUtil {
	
	//TODO: logica nao implementada
	public static Element getBetterElement(DistanceMatrixResponse matrixResponse){
		int indice = 0;
		List<Row> rows = matrixResponse.getRow();
		for (Row row : rows) {
			List<Element> elements = row.getElement();
			for (Element element : elements) {
				return element;
			}
			indice++;
		}
		return null;
	}

}
