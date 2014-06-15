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
 * Servlet implementation class Controlador_usuarios
 */
@WebServlet("/Controlador_usuarios")
public class Controlador_usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador_usuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Muestrar todos los usuaro, permitir busqueda de un usuario en funcion de su codigo
		ConexionDB bd = new ConexionDB();
		response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Pragma", "no-cache");

	    bd.conectar();
	    List<List<String>> lista_usuarios =bd.listarUsuarios();
	    System.out.println(lista_usuarios.size());
		for(int i = 0; i< lista_usuarios.size(); i++){
			for(int j = 0; j< lista_usuarios.get(i).size(); j++)
				System.out.print(lista_usuarios.get(i).get(j)+" ");
			System.out.println("");
		}
	    bd.cerrarConexion();
	    request.setAttribute("lista_usuarios", lista_usuarios);
	    String format = request.getParameter("format");
	    String outputPage;
	    System.out.println(format);
	    if ("xml".equals(format)) {
		      response.setContentType("text/xml");
		      outputPage = "/WEB-INF/results/usuarios-xml.jsp";
		} else if ("json".equals(format)) {
		      response.setContentType("text/javascript");
		      outputPage = "/WEB-INF/results/libros-json.jsp";
		} else {
		      response.setContentType("text/plain");
		      outputPage = "/WEB-INF/results/libros-string.jsp";
		}
	    RequestDispatcher dispatcher =
			      request.getRequestDispatcher(outputPage);
			    dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
