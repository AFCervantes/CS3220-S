<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Counter</title>
</head>
<body>

<%-- Scripting Element: Declaration --%>
<%! static int count = 0; %>

<h1>
	<%-- Scripting Element: Expression --%>
	This page has been viewed <%= count %> time(s);	
</h1>

<%-- Scripting Element: Scriptlet --%>
<% count++; %>

</body>
</html>