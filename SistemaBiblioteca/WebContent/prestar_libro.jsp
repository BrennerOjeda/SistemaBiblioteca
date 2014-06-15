<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="css/estilos.css">
 <script src="./js/ajax-utils.js"
        type="text/javascript"></script>
<script src="./js/ajax-data.js"
        type="text/javascript"></script>
        
 
<title>Insert title here</title>
</head>
<body>
 		<jsp:include page="header.jsp" flush="true" />
        
        <div id="contenedor">    
			<section>
				<article>
					<hgroup>
						<h3>Prestamo de libro</h3>
					</hgroup>
					<p>
						<form method="GET" action="Controlador_Busqueda_libro">
							<table>
								<tr>
									<td><label>Codigo libro</label></td><td><input type="text" name="codigoLibro" value=""></td>
									<td><label>Titulo</label></td><td><input type="text" name="titulo" value=""></td>
									<td><input type="submit" name="buscarLibrp" value="Buscar"></td>
								</tr>
								<tr>
									<td><label>Edicion</label></td><td><input type="text" name="edicion" value=""></td>
									<td><label>Autor</label></td><td><input type="text" name="Autor" value=""></td>
								</tr>
							</table>							
						</form>
					</p>   
				</article>    
			</section>
        </div>
        
        <div id="contenedor1">    
			<section>
				<article>
					<p>
						<form method="GET" action="Controlador">
							<table>
								<tr>
									<td><label>Codigo Usuario</label></td><td><input type="text" name="codigoUsuario" value=""></td>
									<td><label>Nombre y Apellido</label></td><td><input type="text" name="nombreApellido" value=""></td>
									<td><input type="submit" name="buscarUsuario" value="Buscar"></td>
								</tr>
								<tr>
									<td><label>Email</label></td><td><input type="text" name="email" value=""></td>
									
								</tr>
							</table>							
						</form>
					</p>   
				</article>    
			</section>
        </div>
        
        <footer>
            <label>Fecha actual</label><input type="text" name="fechahoy" value=""> 
			<label>dias</label><input type="number" name="dias" id="dias" min="0" max="7" step="1" value="0">
			<input type="submit" name="GuardarPrestamo" value="Guardar"></td>
        </footer>
</body>
</html>