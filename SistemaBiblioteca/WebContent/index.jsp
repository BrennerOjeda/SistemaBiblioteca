<html>
 <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
 <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
 <f:view>
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
				 <h:form>
		 				Nombre:<h:inputText value="#{usuarioPojo.DNI}"/>
						Password: <h:inputSecret value="#{usuarioPojo.password}"/>
		 				<h:commandButton value="Login" action="#{usuarioPojo.verificarUsuario}"/> 
		 				<h:commandButton value="Registro" action="registro"/>
		 				<p class="remember_me">
				          <label>
				            <input type="checkbox" name="remember_me" id="remember_me">
				            Recordar en esta computadora
				          </label>
				        </p>
		 		</h:form>
		 </div>
  	</section>
 </body>
 </f:view>
</html>
