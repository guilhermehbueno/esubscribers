<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<h2>Meus amigos:</h2>
	
	<h3>${mensagem}</h3>
	<ul>
		<c:forEach items="${amigos}" var="amigo">
			<li><c:out value="${amigo.id}" />  - <c:out value="${amigo.name}" /> </li>
		</c:forEach>
	</ul>
</body>
</html>