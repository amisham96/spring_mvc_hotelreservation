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

<title>Insert title here</title>
<style type="text/css">
.home-body1 {
	background-image: url("/resources/images/img1.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>
<style type="text/css">
@keyframes slidy {
0% { left: 0%; }
20% { left: 0%; }
25% { left: -100%; }
45% { left: -100%; }
50% { left: -200%; }
70% { left: -200%; }
75% { left: -300%; }
95% { left: -300%; }
100% { left: -400%; }
}

body { margin: 0;  } 
div#slider { overflow: hidden; margin-top: 4%;}
div#slider figure img { width: 20%; height:528px;border: 10px solid white; float: left; }
div#slider figure { 
  position: relative;
  width: 500%;
  
  margin: 0;
  left: 0;
  text-align: left;
  font-size: 0;
  animation: 15s slidy infinite; 
}

.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

</style>
</head>
<body class="home-body"">
	<nav class="navbar navbar-inverse navbar-fixed-top "
		style="background-color: indigo;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/homepage"> Resto Line Portal</a>
			</div>
						<ul class="nav navbar-nav">
				<li class="active"><a href="#" style="font-size: large;">Welcome,
						${user.userName}</a></li>


			</ul>
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
<div id="slider">
		<figure>
			<img src="/resources/images/img2.jpg" alt>
			
			<img src="/resources/images/img3.jpg" alt>
			<img src="/resources/images/img1.jpg" alt>
			<img src="/resources/images/img2.jpg" alt>
			<img src="/resources/images/img1.jpg" alt>
		</figure>
	</div>

	
</body>
</html>