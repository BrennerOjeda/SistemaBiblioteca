package bd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bd.conexion.UtilidadBD;


public class UsuarioDAO {
	private ResultSet rs = null;
	private Statement statement = null;
	
	public UsuarioDAO(){};
	
	 public String verificarUsuario(int user, String pass){
		 String nomUsuReg = "";
		 String apeUsuReg = "";
		 int ideTipUsuReg = -1;
		 
		 String query = "SELECT nomUsu,apeUsu,ideTipUsu "
					+ " FROM usuario"
					+ " WHERE docIdeUsu="+user+" and passUsu='"+pass+"'";
		 
		 rs =  AdministradorBD.select(query,statement);
		 
		 try {
			
			while (rs.next()){
				nomUsuReg = rs.getString("nomUsu");
				apeUsuReg = rs.getString("apeUsu");
				ideTipUsuReg = Integer.parseInt(rs.getString("ideTipUsu"));
			}	
			
		}catch (SQLException e) {	
			System.out.println("Este Usuario no esta Registrado!");

		}finally{

			UtilidadBD.close(rs);
        	UtilidadBD.close(statement);
		}
		 
		 //return ideTipUsuReg == -1 ? "fracaso": "exito";}
		 return "fracaso";
	 }
	 
	 public List<List<String>> listarUsuarios(){		
			List<List<String>> lista_usuarios = new ArrayList<List<String>>();
			int cod= 0 ;
			String nom = "";
			String tel = "";
			String ema = "";
			String est ="";
			
			String query = "SELECT docIdeUsu, CONCAT(nomUsu,' ', apeUsu) as at1, telUsu, emaUsu, estUsu "
					 + " FROM usuario";
			rs = AdministradorBD.select(query,statement);
			
			try{
				
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
		
			}catch (SQLException e) {	
				 e.printStackTrace();
				 System.out.println("no se puedo acceder a la consulta");
				 return null;
			} finally{
				UtilidadBD.close(rs);
	        	UtilidadBD.close(statement);
			}
			
			return lista_usuarios;
		}
	 
	 public void nuevoUsuario(int docIdeUsu, String nomUsu, String apeUsu,int telUsu, String dirUsu, String emaUsu, String passUsu ){
	    	String query =  "INSERT INTO usuario VALUES ("+docIdeUsu+",'"+nomUsu+"','"+apeUsu+"',"+telUsu+",'"+dirUsu+"',3,'"+emaUsu+"','"+passUsu+"','solicitar')";
	    	AdministradorBD.ejecutarQuery(query);
			return;		
	 }
}
