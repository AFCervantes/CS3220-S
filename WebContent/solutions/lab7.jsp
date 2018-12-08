<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%-- set data source --%>
<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu/cs3220stu120"
	user="cs3220stu120"
	password=																																						"z7CyfCdc"/>

<c:catch var="exception">
	<%-- query --%>
	<c:if test="${not empty param.query}">
		<sql:query var="results" sql="${param.sql}" />
	</c:if>
	
	<%-- update --%>
	<c:if test="${not empty param.update and not fn:containsIgnoreCase(param.sql, 'drop') and not fn:containsIgnoreCase(param.sql, 'delete')}">
	  <sql:update var="rowsAffected" sql="${param.sql}" />
	</c:if>
</c:catch>
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lab 7 - SQL</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<style type="text/css">
		body{
			padding-top: 3em;
		}
	</style>
</head>
<body>
<div class="container">

	<nav class="navbar fixed-top navbar-dark bg-primary">
	  <span class="navbar-brand mb-0 h1">SQL Query</span>
	</nav>
	
	<div class="row mt-3">
		<div class="col">
		
			<form class="mb-4">
			  	<div class="form-group">
			  		<label for="sqlTextArea">Enter your SQL below:</label>
					<textarea class="form-control" id="sqlTextArea" name="sql">${param.sql}</textarea>
				</div>
				
				<input class="btn btn-primary" type="submit" name="query" value="Execute Query">
				<input class="btn btn-warning" type="submit" name="update" value="Submit Update">
			</form>
			
			<c:if test="${not empty param.query or not empty param.update}">
				<hr>
				
				<c:if test="${fn:containsIgnoreCase(param.sql, 'drop') or fn:containsIgnoreCase(param.sql, 'delete')}">
					<p>
						<code>DROP</code> and <code>DELETE</code> are not allowed in this demo. However, they should execute in your demo without issue.
					</p>
				</c:if>
				
			</c:if>
		
			<c:if test="${not empty exception}">
				<div class="card">
					<div class="card-header text-white bg-danger">
				  		An error has occurred.
					</div>
					<div class="card-body">
						<code>${exception.message}</code>
					</div>
				</div>				
			</c:if>
		
			<%-- Update Results --%>
			<c:if test="${not empty rowsAffected}">
				<p>
					${rowsAffected} row(s) affected after executing <code>${param.sql}</code>.
				</p>
			</c:if>
		
			<%-- Query Results --%>
			<c:if test="${not empty results}">
				<p>
					Displaying <strong>${results.rowCount} result(s)</strong> from query: <code>${param.sql}</code>.
				</p>
				<table class="table table-bordered table-striped table-hover">
					<!-- Header Row -->
					<tr>
						<c:forEach items="${results.columnNames}" var="name">
							<th>${name}</th>
						</c:forEach>		
					</tr>
					<c:forEach items="${results.rowsByIndex}" var="row">
						<tr>
							<c:forEach items="${row}" var="col">
								<td>${col}</td>
							</c:forEach>
						</tr>
					</c:forEach>
					
				</table>
			</c:if>
		</div>
	</div> <!-- End div.row -->
</div>
</body>
</html>