<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
		<a target="_top" href="/client">
	  		Home
		</a><br/>

	<h2>Preview de entrega:</h2>
	
	<ul>
		<li>Endereco:
			<ul>
				<li>Id:  - <c:out value="${preview.endereco.id}" /> </li>
				<li>Endereco:  - <c:out value="${preview.endereco.endereco}" /> </li>
			</ul>
		</li>
		<li>Distância:
			<ul>
				<li>Value:  - <c:out value="${preview.distance.value}" /> </li>
				<li>Text:  - <c:out value="${preview.distance.text}" /> </li>
			</ul>
		</li>
		<li>Duração:
			<ul>
				<li>Value:  - <c:out value="${preview.duration.value}" /> </li>
				<li>Text:  - <c:out value="${preview.duration.text}" /> </li>
			</ul>
		</li>
		<li>Preco: <c:out value="${preview.preco}" />
		</li>
	</ul>
</body>
</html>