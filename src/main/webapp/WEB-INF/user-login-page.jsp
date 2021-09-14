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
<style type="text/css">
#display {
	display: none;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top"
		style="background-color: indigo;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/"> Resto Line Portal</a>
			</div>
			<ul class="nav navbar-nav navbar-right">

				<li><a href="/register"><span
						class="glyphicon glyphicon-user"></span> Register</a></li>
				<li><a href="/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>

			</ul>
		</div>
	</nav>

	<div id="display" style="width: 500px; height: 450px; margin: 10% auto;">
		<div style="margin-top: 20%; padding-top: 25px; margin-left: 40%">
			<h2 style="font-weight: bold;">Login</h2>
		</div>
		<hr style="width: 30%; border-color: white;">
		<br>
		<div class="col-lg-8 m-auto d-block " style="margin-left: 17%;">
			<form:form method="post" modelAttribute="users" action="userlogin">


				<div class="form-group">
					<lable for="user"> Email: </lable>
					<form:input path="email" name="email" id="email"
						class="form-control" placeholder="Enter Email" autocomplete="off" />
					<h5 id="usercheck"></h5>

				</div>
				<div class="form-group">
					<lable for="user"> Password: </lable>
					<form:password path="password" name="password" id="password"
						class="form-control" placeholder="Enter new Password"
						autocomplete="off" />
					<h5 id="passcheck"></h5>

				</div>

				<button type="submit" id="submitbtn"
					style="margin-top: 6%; height: 50px; width: 300px; font-weight: bold;">Login</button>
			</form:form>
		</div>

	</div>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$("#display").animate({
								height : 'toggle'
							}, 3000, function() {
								$(this).animate({

								});
							});

							$('#usercheck').hide();
							$('#passcheck').hide();

							var email_err = true;
							var pass_err = true;

							$('#email').keyup(function() {
								email_check();
							});

							function email_check() {
								var email_val = $('#email').val();
								var regax = /^[\w]{1,}[\w.+-]{0,}@[\w-]{2,}([.][a-zA-Z]{2,}|[.][\w-]{2,}[.][a-zA-Z]{2,})$/;

								if (email_val.length == '') {
									$('#usercheck').show();
									$('#usercheck').html(
											"**Please Fill the Email");
									$('#usercheck').focus();
									$('#usercheck').css("color", "red");
									email_err = false;
									return false;

								} else {
									$('#usercheck').hide();
								}

								if (!(email_val.match(regax))) {
									$('#usercheck').show();
									$('#usercheck')
											.html(
													"**Required email pattern is not matching");
									$('#usercheck').focus();
									$('#usercheck').css("color", "red");
									email_err = false;
									return false;

								} else {
									$('#usercheck').hide();
								}
							}

							$('#password').keyup(function() {
								password_check();
							});

							function password_check() {

								var passwrdstr = $('#password').val();

								if (passwrdstr.length == '') {
									$('#passcheck').show();
									$('#passcheck').html(
											"**Please Fill the password");
									$('#passcheck').focus();
									$('#passcheck').css("color", "red");
									pass_err = false;
									return false;

								} else {
									$('#passcheck').hide();
								}

								if ((passwrdstr.length < 8)
										|| (passwrdstr.length > 15)) {
									$('#passcheck').show();
									$('#passcheck')
											.html(
													"**password length must be between 8 and 15");
									$('#passcheck').focus();
									$('#passcheck').css("color", "red");
									pass_err = false;
									return false;

								} else {
									$('#passcheck').hide();
								}
							}

							$('#submitbtn').click(function() {

								email_err = true;
								pass_err = true;

								email_check();
								password_check();

								if ((email_err == true) && (pass_err == true)) {
									return true;
								} else {
									return false;
								}

							});

						});
	</script>


</body>
</html>