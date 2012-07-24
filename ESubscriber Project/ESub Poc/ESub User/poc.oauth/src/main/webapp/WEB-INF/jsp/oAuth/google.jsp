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
		<a target="_top" href="/">
	  		Home
		</a><br/>

	<h2>User Info:</h2>
	
	<ul>
		<li>ID: <c:out value="${userInfo.id}" /></li>
		<li>EMAIL: <c:out value="${userInfo.email}" /></li>
		<li>VERIFIED EMAIL: <c:out value="${userInfo.verified_email}" /></li>
		<li>NAME: <c:out value="${userInfo.name}" /></li>
		<li>GIVEN NAME: <c:out value="${userInfo.given_name}" /></li>
		<li>FAMILY NAME: <c:out value="${userInfo.family_name}" /></li>
		<li>LINK: <c:out value="${userInfo.link}" /></li>
		<li>GENDER: <c:out value="${userInfo.gender}" /></li>
		<li>BIRTHDAY: <c:out value="${userInfo.birthday}" /></li>
		<li>LOCALE: <c:out value="${userInfo.locale}" /></li>
	</ul>
</body>
</html>