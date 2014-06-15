<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
  <link rel="stylesheet" href="css/style.css" tipe = "text/css"></link>
</head>
<body>
  <section class="container">
    <div class="login">
      <h1>Nuevo usuario</h1>
      <form method="GET" action="Controlador_registro">
        <p><input type="text" name="codigo" value="" placeholder="DNI"></p>
        <p><input type="text" name="nombre" value="" placeholder="Nombre"></p>
        <p><input type="text" name="apellido" value="" placeholder="Apellido"></p>
        <p><input type="text" name="telefono" value="" placeholder="Telefono"></p>
        <p><input type="text" name="direccion" value="" placeholder="Direccion"></p>
        <p><input type="text" name="email" value="" placeholder="Email"></p>
        <p><input type="password" name="password" value="" placeholder="Password"></p>
        <table>
			<tr>
			  <td>
        		<p class="submit"><input type="submit" name="commit" value="Registrar"></p>
        	 </td>
      </form>
      
      <form method="GET" action="login.jsp">
      		 <td>
      		<p class="submit"><input type="submit" name="commit" value="Cancelar"></p>
      		 </td>
      		</tr>
      </table>
   	   </form>
    </div>
  </section>

</body>
</html>
