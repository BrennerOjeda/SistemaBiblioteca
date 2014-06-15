package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ConexionDB;

/**
 * Servlet implementation class Controlador_libros
 */
@WebServlet("/Controlador_libros")
public class Controlador_libros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador_libros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
			ConexionDB bd = new ConexionDB();
			//cabecera de la rpta que el servidor da
			response.setHeader("Cache-Control", "no-cache");
		    response.setHeader("Pragma", "no-cache");
		    //String cityType = request.getParameter("cityType");
		    //List<City> cities = findCities(cityType);
		    bd.conectar();
		    List<List<String>> lista_libros = bd.listarLibros();
		    bd.cerrarConexion();
		    //request.setAttribute("cities", cities);
		    request.setAttribute("lista_libros", lista_libros);
		    //seleccionamos el archivo de la tabla a ser insertada en la vista
		    String format = request.getParameter("format");
		    System.out.println(format);
		    String outputPage;
		    System.out.println(format+"---"+"xml");
		    if ("xml".equals(format)) {
		      response.setContentType("text/xml");
		      outputPage = "/WEB-INF/results/libros-xml.jsp";
		    } else if ("json".equals(format)) {
		      response.setContentType("text/javascript");
		      outputPage = "/WEB-INF/results/libros-json.jsp";
		    } else {
		      response.setContentType("text/plain");
		      outputPage = "/WEB-INF/results/libros-string.jsp";
		    }
		    //dispatcher: get obtines jsp en formato xml
		    RequestDispatcher dispatcher =
		      request.getRequestDispatcher(outputPage);
		    dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
