package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

import db.ConexionDB;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConexionDB bd = new ConexionDB();
		String sDNI = request.getParameter("login");
		String password = request.getParameter("password");
		int DNI = Integer.parseInt(sDNI);
		
		PrintWriter m = response.getWriter();
		bd.conectar();
		int flag = bd.verificarUsuario(DNI, password);
		bd.cerrarConexion();
		if (flag != -1){
			response.sendRedirect("http://localhost:8080/SistemaBiblioteca/prestar_libro.jsp");
		}
		else{
			response.sendRedirect("http://localhost:8080/SistemaBiblioteca/login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
