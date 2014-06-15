<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="GET" action="Controlador">
		<label>Documento Identidad</label>
		<input type="text" name="docIdeUsu" value=""><br><br>
		<label>Nombre</label>
		<input type="text" name="nomUsu" value=""><br><br>
		<label>Apellido</label>
		<input type="text" name="apeUsu" value=""><br><br>
		<label>Telefono</label>
		<input type = "number" maxlength = "10"  name="telUsu" value=""><br><br>
		<label>Direccion</label>
		<input type="text" name="dirUsu" value=""><br><br>
		<label>Email</label>
		<input type="text" name="emaUsu" value=""><br><br>
		<label>Password</label>
		<input type="Password" name="passUsu" value=""><br><br>
		
		<input type="submit" name="Aceptar">
	</form>

</body>
</html>