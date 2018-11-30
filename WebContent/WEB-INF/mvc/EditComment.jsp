<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Edit Comment</title>
</head>
<body>

	<form action="EditComment" method="post">
	
		<c:if test="${not empty nameError}">
			<p style="color: red;"> ${nameError} </p>
		</c:if>
	
		Name: <input type="text" name="name" value="${entry.name}" /> <br />
		
		<c:if test="${not empty messageError}">
			<p style="color: red;"> ${messageError} </p>
		</c:if>
		
		Message: <input type="text" name="message" value="${entry.message}" /> <br />
		
		<input type="hidden" name="id" value="${entry.id}">
	
		<input type="submit" name="save" value="Save" />
	</form>
</body>
</html>