<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Login Error</title>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top "
		style="background-color: indigo;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/homepage"> Resto Line Portal</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				
				<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-menu-hamburger"></span> Menu</a>
                            <ul class="dropdown-menu">
                            <li><a href="/restaurants">Show Restaurant</a></li>
							<li><a href="/reservationhistory">Reservation History</a></li>
						
                            </ul></li>

				<li><a href="/"><span class="glyphicon glyphicon-log-out"></span>
						Logout</a></li>

			</ul>
		</div>
	</nav>
	<div align="center"
		style="margin-top: 5%; width: 70%; height: 200px; margin: 10% auto; text-align: center; padding: 3%;">
		<h3>
			<b>Your booking more seat then the Available </b>
		</h3>
		<a href=/restaurants><button type="submit">
				<b>Go Back</b>
			</button></a>
	</div>
</body>
</html>