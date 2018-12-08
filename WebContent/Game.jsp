<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tic Tac Toe</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<style type="text/css">
body{
	background-color: black;
	color: white;
}
table.table-board tr td {
	height: 6rem;
	width: 6rem;
	font-size: 6rem;
	text-align: center;
}

table.table-board tr td a {
	text-decoration: none;
}
</style>
</head>
<body>
<div class="container">

<h1 class="display-1 text-center">Tic-Tac-Toe</h1>

<c:if test="${not game.gameOver}">
	<h3 class="text-center">Player ${game.currentPlayer}'s Turn.</h3>
</c:if>

<h3 class="text-center">
	<c:out value="${game.message}" />
</h3>

<div class="row">
	<div class="col-sm-6 offset-sm-3">
		<table class="table table-bordered table-board">
			<tr>
				<td>
					<a href="PlayController?location=0">${game.board[0]}</a>
				</td>
				<td>
					<a href="PlayController?location=1">${game.board[1]}</a>
				</td>
				<td>
					<a href="PlayController?location=2">${game.board[2]}</a>
				</td>
			</tr>
			
			<tr>
				<td>
					<a href="PlayController?location=3">${game.board[3]}</a>
				</td>
				<td>
					<a href="PlayController?location=4">${game.board[4]}</a>
				</td>
				<td>
					<a href="PlayController?location=5">${game.board[5]}</a>
				</td>
			</tr>
			
			<tr>
				<td>
					<a href="PlayController?location=6">${game.board[6]}</a>
				</td>
				<td>
					<a href="PlayController?location=7">${game.board[7]}</a>
				</td>
				<td>
					<a href="PlayController?location=8">${game.board[8]}</a>
				</td>
			</tr>
		</table>
	</div>
		
</div>

	<c:if test="${game.gameOver}">
		<div class="text-center">
			<a href="NewGameController" class="btn btn-primary">Play Again?</a>
		</div>
	</c:if>

</div>
</body>
</html>