<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
  <link rel="stylesheet" href="css/style.css" tipe = "text/css"></link>
  <script type = "text/javascript" src="./js/control_logeo.js"></script> 
</head>
<body>
	
  <section class="container">
    <div class="login">
    	
      <h1>Login de Gestion de bliblioteca</h1>
      <form method="GET" action="Controlador">
        <p><input id="dni" type="text" name="login" value="" placeholder="Email o DNI"></p>
        <p><input id="password" type="password" name="password" value="" placeholder="Contraseña"></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            Recordar en esta computadora
          </label>
        </p>
        
        <p class="submit">
        <table>
			<tr>
			  <td><p class="submit"> <input type="submit" name="commit" value="Login"></p></td>
      </form>
      <form method="GET" action="registro_usuario.jsp">
	      <td></td>
				  <td><p class="submit"> <input type="submit" name="registro" value="Registro"></p></td>
				</tr>
		</table>
	  </form>
    </div>

    <div class="login-help">
      <p>Olvido su password? <a href="index.html">Click aqui para resetear</a>.</p>
    </div>
  </section>

</body>
</html>
