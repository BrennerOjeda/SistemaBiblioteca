<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login Form</title>
	<link rel="stylesheet" href="css/style.css" tipe = "text/css"></link>
	<script type = "text/javascript" src="./js/control_logeo.js"></script> 
</head>
<body>
	<section class="container">
		<div class="login">
			Contraseña:
			<form action = "echoNumberAction"> 
				<input type="password" name="numberMessage"/>
				<input type="submit" value="Enviar"/>
			</form>
		</div>
	</section>
</body>
</html>