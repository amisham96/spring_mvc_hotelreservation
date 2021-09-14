<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Set"%>

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

<title>Insert title here</title>
<style type="text/css">
button {
	opacity: 1;
	transition: 0.3s;
	margin-left: 36%;
	margin-top: 4%;
	height: 40px;
	width: 200px;
	background-color: white;
	font-weight: bold;
}

button:hover {
	opacity: 0.6;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top"
		style="background-color: indigo;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/homepage"> Resto Line Portal</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><span
						class="glyphicon glyphicon-menu-hamburger"></span> Menu</a>
					<ul class="dropdown-menu">
						<li><a href="/restaurants">Show Restaurant</a></li>
						<li><a href="/reservationhistory">Reservation History</a></li>

					</ul></li>

				<li><a href="/"><span class="glyphicon glyphicon-log-out"></span>
						Logout</a></li>

			</ul>
		</div>
	</nav>
	<br />

	<div
		style="background-color:silver; width: 700px; height: 400px; margin: 10% auto; box-shadow: 0 10px 15px 0 rgba(0, 0, 0, 0.5), 0 10px 25px 0 rgba(0, 0, 0, 0.25);">


		<div style="margin-top: 20%; padding-top: 25px; margin-left: 40%">
			<h2 style="font-weight: bold;">Book Seat</h2>
		</div>
		<hr style="width: 30%; border-color: white;">

		<form action="${restaurant.restaurantId}/reserved" method="post">

			<div class="col-xs-4" style="margin-left: 34%;">
				<label>Enter The No. of Seat :</label>

				<input type="number"  name=“noofseat” class="form-control" id="book"
					placeholder="Enter No.Of Seat" autocomplete="off" />
				<h6 id="bookcheck" ></h6>
			</div>
			<br>


			<button type="submit" style="" id="submitbtn">Submit</button>

		</form>




	</div>

	<!-- <script type="text/javascript">
		$(document).ready(function() {

			$('#bookcheck').hide();

			var book_err = true;

			$('#book').keyup(function() {
				book_check();
			});

			function book_check() {

				var bookdata = $('#book').val();
				
				if (bookdata == null) {
					$('#bookcheck').show();
					$('#bookcheck').html(
							"**Please Fill the Field");
					$('#bookcheck').focus();
					$('#bookcheck').css("color", "red");
					book_err = false;
					return false;

				} else {
					$('#bookcheck').hide();
				}


				if ((bookdata > 6)) {
					$('#bookcheck').show();
					$('#bookcheck').html("**No. Of seat must be less than 6");
					
					$('#bookcheck').focus();
					$('#bookcheck').css("color", "red");
					$('#book').css("background-color","yellow");
					book_err = false;
					return false;

				} else {
					$('#bookcheck').hide();
					$('#book').css("background-color","none");
				}
			}

			$('#submitbtn').click(function() {

				book_err = true;

				book_check();

				if ((book_err == true)) {
					return true;
				} else {
					return false;
				}

			});

		});
	</script>
 -->
</body>
</html>