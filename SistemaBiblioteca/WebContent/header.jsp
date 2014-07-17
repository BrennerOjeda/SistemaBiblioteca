<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<header>
            <h1>Give me a Book!</h1>
            <h3>Maestría en informática 2014 - UNSA</h3>
        </header>
   <nav>
            <ul>
                <li><a href="#">Inicio</a></li>
				<li><a href="#">Actividad</a>
					<ul>
                        <li><a href="http://localhost:8080/SistemaBiblioteca/prestar_libro.jsp">Prestar</a></li>
                        <li><a href="http://localhost:8080/SistemaBiblioteca/renovar_libro.jsp">Renovar</a></li>
                        <li><a href="http://localhost:8080/SistemaBiblioteca/devolver_libro.jsp">Pedir</a></li>
                    </ul>
				</li>
                <li><a href="#">Libros</a>
                    <ul>
                        <li><a href="http://localhost:8080/SistemaBiblioteca/pagina_libros.jsp">Todos Libros</a></li>
                        <!-- <li><a href="#">Categorias</a></li> -->
                        <!-- <li><a href="#">Recientes</a></li> -->
                    </ul>
                </li>
                <li><a href="#">Usuarios</a>
					<ul>
                        <li><a href="http://localhost:8080/SistemaBiblioteca/pagina_usuarios.jsp">Todos Los usuarios</a></li>
                        <!-- <li><a href="#">Pendite devolucion</a></li> -->
                    </ul>
				</li>
                <!-- <li><a href="#">Circulación</a></li>  -->
                <li><a href="#">Ayuda en Linea</a>
              	  <ul>
                        <li><a href="http://localhost:8080/SistemaBiblioteca/pagina_chat.jsp">Contactanos en linea</a></li>
                        <!-- <li><a href="#">Pendite devolucion</a></li> -->
                    </ul>
                </li>
                
            </ul>
        </nav>
        
</body>
</html>