package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConexionDB {
	private Connection conexion = null; 
	 
	public void conectar(){	
		String db = "sistemabiblioteca";
		String driver = "org.gjt.mm.mysql.Driver";
		String host = "localhost:3306";
		String user = "sistBiblioteca";
		String pass = "bregre";
		String url = "jdbc:mysql://"+host+"/"+db;
		try{
			Class.forName(driver);
			conexion = DriverManager.getConnection(url,user,pass);
			
			if (conexion!=null){
	               System.out.println("OK base de datos "+db+" listo");
	            }
	     }catch(SQLException e){
	        System.out.println(e);
	     }catch(ClassNotFoundException e){
	        System.out.println(e);
	       }
	}
	
	 public void cerrarConexion() {
		 try{
			conexion.close();
		 }catch (Exception e) {
			System.out.println("Error al cerrar la conexion.");
		}
	 }
	 
	 public static void print(Object o){
		 System.out.print(o +" ");
	 }
	 
	 public static void println(Object o){
		 System.out.println(o);
	 }
	 
	 public int verificarUsuario(int user, String pass){
		 String nomUsuReg = "";
		 String apeUsuReg = "";
		 int ideTipUsuReg = -1;
		 
		 try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT nomUsu,apeUsu,ideTipUsu "
										+ " FROM usuario"
										+ " WHERE docIdeUsu="+user+" and passUsu='"+pass+"'");
			//SELECT * FROM `usuario` WHERE `docIdeUsu` = 63387425 and `passUsu` = "2134"
			while (rs.next()){
				nomUsuReg = rs.getString("nomUsu");
				apeUsuReg = rs.getString("apeUsu");
				ideTipUsuReg = Integer.parseInt(rs.getString("ideTipUsu"));
			}
			
				System.out.println("Bienvenido usuario: "+ideTipUsuReg+" "+nomUsuReg + " " + apeUsuReg);
			rs.close();
			st.close();			
			
		}catch (SQLException e) {	
			System.out.println("Usuario no Registrado!");
			//System.out.println(e);
		}
		 
		 return ideTipUsuReg;
	 }
	 
	 public List<List<String>> listarLibros(){		
		 	List<List<String>> lista_Libros = new ArrayList<List<String>>();
			int cod= 0 ;
			String tit = "";
			String auts = "";
			String edic = "";
			String dispo ="";
			try{
				Statement st = conexion.createStatement();
				 ResultSet rs = st.executeQuery("SELECT tb1.ideRec as cod, tb1.titRec as tit, GROUP_CONCAT(tb1.at1 SEPARATOR ' , ') as autores,tb1.at2 as edicion , tb1.disPresRec as disponible "
				 		 					 + " FROM (SELECT r.ideRec, titRec, CONCAT(nomAut,' ', apeAut) as at1, CONCAT(editRec,' ', anioEdicRec) as at2 , disPresRec "
				 		 					 		+ " FROM recurso as r,autor_recurso as ar, autor as a "
				 		 					 		+ " WHERE r.ideRec=ar.ideRec && ar.codAut= a.codAut) as tb1 "
				 		 					 + " GROUP BY tb1.ideRec"); 
				
				 while (rs.next()){
					 List<String> datos_libro = new ArrayList<String>();
					 cod = Integer.parseInt(rs.getString("cod"));
					 tit = rs.getString("tit");
					 auts = rs.getString("autores");
					 edic = rs.getString("edicion");
					 dispo = rs.getString("disponible");
					 //System.out.println("datos obtenidos1 "+ cod + " , "+ tit + " , "+ auts+ " , " + edic + " , "+dispo);
					 datos_libro.add(cod+"");
					 datos_libro.add(tit+"");
					 datos_libro.add(auts+"");
					 datos_libro.add(edic+"");
					 datos_libro.add(dispo+"");
					 lista_Libros.add(datos_libro);
				 }
				st.close();
				return lista_Libros;
			}catch (SQLException e) {	
				e.printStackTrace();
				 System.out.println("no se puedo acceder a la consulta");
				 return null;
			 }
			
		}
		
		public List<List<String>> listarUsuarios(){		
			List<List<String>> lista_usuarios = new ArrayList<List<String>>();
			int cod= 0 ;
			String nom = "";
			String tel = "";
			String ema = "";
			String est ="";
			try{
				 Statement st = conexion.createStatement();
				 ResultSet rs = st.executeQuery("SELECT docIdeUsu, CONCAT(nomUsu,' ', apeUsu) as at1, telUsu, emaUsu, estUsu "
				 							 + " FROM usuario"); 
				
				 while (rs.next()){
					 List<String> datos_usuario = new ArrayList<String>();
					 cod = Integer.parseInt(rs.getString("docIdeUsu"));
					 nom = rs.getString("at1");
					 tel = rs.getString("telUsu");
					 ema = rs.getString("emaUsu");
					 est = rs.getString("estUsu");
					 //System.out.println("datos obtenidos1 "+ cod + " , "+ nom + " , "+ tel+ " , " + ema + " , "+est);
					 datos_usuario.add(cod+"");
					 datos_usuario.add(nom+"");
					 datos_usuario.add(tel+"");
					 datos_usuario.add(ema+"");
					 datos_usuario.add(est+"");
					 lista_usuarios.add(datos_usuario);
				 }
				
				st.close();
				return lista_usuarios;
			}catch (SQLException e) {	
				 e.printStackTrace();
				 System.out.println("no se puedo acceder a la consulta");
				 return null;
			 }
			
		}
		
		public void nuevoUsuario(int docIdeUsu, String nomUsu, String apeUsu,int telUsu, String dirUsu, String emaUsu, String passUsu ){
	    	
			try{
		    	Statement s = conexion.createStatement();
				s.executeUpdate("INSERT INTO usuario VALUES ("+docIdeUsu+",'"+nomUsu+"','"+apeUsu+"',"+telUsu+",'"+dirUsu+"',3,'"+emaUsu+"','"+passUsu+"','solicitar')");
				s.close();
	    	
		    }
			catch(SQLException e){//error en sql
				e.printStackTrace();
			}		
	    }
		
		public String[] prestamoLibro(int codLib){
			 int cod = 0;
			 String tit = "";
			 String auts = "";
			 String edic = "";
			 String datos_libro [] = new String[3];
			 try {
					Statement st = conexion.createStatement();
					ResultSet rs = st.executeQuery("SELECT tb1.ideRec, tb1.titRec, GROUP_CONCAT(tb1.at1 SEPARATOR ' , ') as autores,tb1.at2 as edicion "
													+ " FROM (SELECT r.ideRec, titRec, CONCAT(nomAut,' ', apeAut) as at1, CONCAT(editRec,' ', anioEdicRec) as at2 "
															+ " FROM recurso as r,autor_recurso as ar, autor as a "
															+ " WHERE r.ideRec=ar.ideRec && ar.codAut= a.codAut && r.ideRec="+codLib+" && disPresRec='Si') as tb1 ");
					while (rs.next()){
						cod = Integer.parseInt(rs.getString("tb1.ideRec"));
						tit = rs.getString("tb1.titRec");
						auts = rs.getString("autores");
						edic = rs.getString("edicion");					
					}
					datos_libro[0] = tit;
					datos_libro[1] = auts;
					datos_libro[2] = edic;
					
					//System.out.println("datos: "+cod+" , "+tit + " , " +auts + " , "+edic);
					rs.close();
					st.close();	
					return datos_libro;
			 }catch (SQLException e) {	
				 System.out.println("no se puedo acceder a la consulta");
			 }catch (Exception a){
				 System.out.println(a.getMessage());
			 }
			 return datos_libro;
		 }
		
	 public static void main(String[] args) {
			ConexionDB conn = new ConexionDB();
			conn.conectar();
			//conn.verificarUsuario(345654, "ffffdd");
			//conn.verificarUsuario(63387425,"2134");
			//conn.cerrarConexion();
			/*
			List<List<String>> array = conn.listarLibros();
			for(int i = 0; i< array.size(); i++){
				for(int j = 0; j< array.get(i).size(); j++)
					print(array.get(i).get(j));
				println("");
			}
			System.out.println("USUARIOSSSSS");
			List<List<String>> arrayU = conn.listarUsuarios();
			for(int i = 0; i< arrayU.size(); i++){
				for(int j = 0; j< arrayU.get(i).size(); j++)
					print(arrayU.get(i).get(j));
				println("");
			}
			*/
			//conn.nuevoUsuario(123213,"nomUsu","apeUsu",1234, "dirUsu", "email", "1234");
			String [] v = conn.prestamoLibro(2);
			for(String s: v)
				println(s);
			conn.cerrarConexion();
		}
						
	
	

}
