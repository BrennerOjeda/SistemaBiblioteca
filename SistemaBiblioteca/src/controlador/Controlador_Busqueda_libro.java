package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ConexionDB;

/**
 * Servlet implementation class Controlador_Busqueda_libro
 */
@WebServlet("/Controlador_Busqueda_libro")
public class Controlador_Busqueda_libro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador_Busqueda_libro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConexionDB bd = new ConexionDB();
		String codigoLibro = request.getParameter("codigoLibro");
		System.out.println(codigoLibro);
		
		bd.conectar();
		String [] datos_libro = bd.prestamoLibro(Integer.parseInt(codigoLibro));
		bd.cerrarConexion();
		
		request.setAttribute("datos_libro", datos_libro);
		for(String s: datos_libro)
			System.out.println(s);
		RequestDispatcher dispatcher =
			  request.getRequestDispatcher("info_libro_xml.jsp");
			  dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
