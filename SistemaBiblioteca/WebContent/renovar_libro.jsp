<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/estilos.css"> 
</head>
<body>
		<jsp:include page="header.jsp" flush="true" />
    <div id="contenedor">      
		<section>
				<article>
					<hgroup>
						<h3>Reovacion de libro</h3>
					</hgroup>
					<p>
						<form method="GET" action="Controlador">
							<table>
								<tr>
									<td><label>Codigo libro</label></td><td><input type="text" name="codigoLibro" value=""></td>
									<td><label>Titulo</label></td><td><input type="text" name="titulo" value=""></td>
									<td><input type="submit" name="buscarLibrp" value="Buscar"></td>
								</tr>
								 <div id="formulario-renovar"></div>
							</table>							
						</form>
					</p>   
				</article>    
			</section>
		</div>
</body>
</html>