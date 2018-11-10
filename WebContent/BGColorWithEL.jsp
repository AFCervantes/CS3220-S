<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean class="models.BGBean" id="bg" scope="application"/>
<jsp:setProperty name="bg" property="*" />
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BG Bean</title>
<style type="text/css">
body{
	background-color: rgb( ${bg.r}, ${bg.g}, ${bg.b} );
}
</style>

</head>
<body>

<h1>
	The background color is: rgb( ${bg.r}, ${bg.g}, ${bg.b} )
	
</h1>

</body>
</html>