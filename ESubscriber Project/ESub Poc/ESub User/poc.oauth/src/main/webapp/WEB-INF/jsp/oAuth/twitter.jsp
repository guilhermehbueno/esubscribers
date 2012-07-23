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
<h2>Meus amigos do Twitter:</h2>

<h3>${mensagem}</h3>
	<ul>
		<c:forEach items="${amigos}" var="amigo">
			<li><c:out value="${amigo.user.name}" />  - <c:out value="${amigo.text}" /> </li>
		</c:forEach>
	</ul>

</body>
</html>