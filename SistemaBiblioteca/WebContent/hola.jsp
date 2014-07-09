<html>
 <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
 <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
 <f:view>
 <head> 
 <title>Bienvenida de Greis</title>
 </head>
 <body>
 <h:form>
 	<h3>
 		Bienvenido a JavaServer Faces, el Usuario con DNI:
		<h:outputText value="#{usuarioPojo.DNI}"/> no existe!
 	</h3>
 </h:form>
 </body> 
 </f:view>
</html>
