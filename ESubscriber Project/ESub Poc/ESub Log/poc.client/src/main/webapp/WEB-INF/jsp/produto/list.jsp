<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>


<a target="_top" href="/">
	  		Home
		</a><br/>

<h3>Produtos</h3>
	<ul>
		<c:forEach items="${produtos}" var="produto">
			<li><c:out value="${produto.nome}" />  - <a href="/client/produto/view/<c:out value="${produto.id}" />" >View</a> - <a href="/client/produto/preview/<c:out value="${produto.id}" />" >Preview</a> </li>
		</c:forEach>
	</ul>

</body>
</html>