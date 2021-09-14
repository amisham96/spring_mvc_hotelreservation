<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<title>Insert title here</title>
<style type="text/css">
.index-body {
	background-image: url("/resources/images/img3.jpeg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}

.parallax1 {
	margin-top: 2%;
	/* The image used */
	 background-image: url("/resources/images/img1.jpg"); */
	border: 10px solid gray;
	/* Full height */
	height: 528px;
	/* Create the parallax scrolling effect */
	background-attachment: fixed;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	text-align: center;
	color: white;
}

.centered {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}


</style>


</head>

<body class="index-body" style="background-color: white;">

	<nav class="navbar navbar-inverse navbar-fixed-top"
		style="background-color: indigo;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">Restaurent booking Portal</a>
			</div>
			<ul class="nav navbar-nav navbar-right">

				<li><a href="/register"><span
						class="glyphicon glyphicon-user"></span> Register</a></li>
				<li><a href="/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>

			</ul>
		</div>
	</nav>
</script>
	<div class="parallax1">
		<div class="centered" style="font-weight: bold;font-size: 50px">Welcome <br>To<br> Restaurent booking Portal</div>
	</div>


	<div style="height: 340px; background-color: lightgray;">
		<br> <br>

		<div
			style="background-color: white; width: 50%; height: 250px; margin-left: 5%;">
				<h2 style="font-weight: bold;">About Us</h2>
		
				Welcome to <b>"Restaurent booking Portal"</b>, In this website you can book
				your Book Seat in restaurant.You can also check your Reservation
				Histroy in this site. Book hotles according to your need and enjoy
			</div>
		
	</div>


</body>
</html>