package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ConexionDB;

/**
 * Servlet implementation class Controlador_registro
 */
@WebServlet("/Controlador_registro")
public class Controlador_registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador_registro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConexionDB bd = new ConexionDB();
		response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Pragma", "no-cache");
	    
	    int codigo = Integer.parseInt(request.getParameter("codigo"));
	    String nombre = request.getParameter("nombre") +"";
	    String apellido = request.getParameter("apellido")+"";
	    int telefono = Integer.parseInt(request.getParameter("telefono"));
	    String direccion = request.getParameter("direccion")+"";
	    String email = request.getParameter("email")+"";
	    String password = request.getParameter("password")+"";
	    //List<City> cities = findCities(cityType);
	    bd.conectar();
	    if (request.getParameter("telefono").equals("")){
	    	bd.nuevoUsuario(codigo, nombre, apellido, 0, direccion, email, password);
	    }
	    else bd.nuevoUsuario(codigo, nombre, apellido, telefono, direccion, email, password);
	    response.sendRedirect("http://localhost:8080/SistemaBiblioteca/login.jsp");
	    bd.cerrarConexion();
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
