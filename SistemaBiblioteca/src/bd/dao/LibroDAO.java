package bd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bd.conexion.UtilidadBD;

public class LibroDAO {
	private ResultSet rs = null;
	private Statement statement = null;
	
	public LibroDAO(){};
	
	public List<List<String>> listarLibros(){		
	 	List<List<String>> lista_Libros = new ArrayList<List<String>>();
		int cod= 0 ;
		String tit = "";
		String auts = "";
		String edic = "";
		String dispo ="";
		
		String query = "SELECT tb1.ideRec as cod, tb1.titRec as tit, GROUP_CONCAT(tb1.at1 SEPARATOR ' , ') as autores,tb1.at2 as edicion , tb1.disPresRec as disponible "
					 + " FROM (SELECT r.ideRec, titRec, CONCAT(nomAut,' ', apeAut) as at1, CONCAT(editRec,' ', anioEdicRec) as at2 , disPresRec "
				 		+ " FROM recurso as r,autor_recurso as ar, autor as a "
				 		+ " WHERE r.ideRec=ar.ideRec && ar.codAut= a.codAut) as tb1 "
				 + " GROUP BY tb1.ideRec";
		rs = AdministradorBD.select(query,statement);
		try{
			
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
		
		}catch (SQLException e) {	
			e.printStackTrace();
			 System.out.println("no se puedo acceder a la consulta");
			 return null;
		 }finally{
			 UtilidadBD.close(rs);
	         UtilidadBD.close(statement);
		 }
		return lista_Libros;
	}
	
	public String[] prestamoLibro(int codLib){
		 int cod = 0;
		 String tit = "";
		 String auts = "";
		 String edic = "";
		 String datos_libro [] = new String[3];
		 String query = "SELECT tb1.ideRec, tb1.titRec, GROUP_CONCAT(tb1.at1 SEPARATOR ' , ') as autores,tb1.at2 as edicion "
					+ " FROM (SELECT r.ideRec, titRec, CONCAT(nomAut,' ', apeAut) as at1, CONCAT(editRec,' ', anioEdicRec) as at2 "
					+ " FROM recurso as r,autor_recurso as ar, autor as a "
					+ " WHERE r.ideRec=ar.ideRec && ar.codAut= a.codAut && r.ideRec="+codLib+" && disPresRec='Si') as tb1 ";
		 rs = AdministradorBD.select(query,statement);
		 try {
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
			
		 }catch (SQLException e) {	
			 System.out.println("no se puedo acceder a la consulta");
		 }catch (Exception a){
			 System.out.println(a.getMessage());
		 }finally{
			 UtilidadBD.close(rs);
	         UtilidadBD.close(statement);
		 }
		 return datos_libro;
	 }
}
