package bd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bd.conexion.ConnectionFactory;
import bd.conexion.UtilidadBD;


public class AdministradorBD {
	private static Connection connection = null;
	private static Statement statement;

	public static Statement getStatement() {
		return statement;
	}

	public static void setStatement(Statement statement) {
		AdministradorBD.statement = statement;
	}

	public static void ejecutarQuery(String query) {
		connection = ConnectionFactory.getConnection();
		try {
			try {
				statement = connection.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				statement.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			UtilidadBD.close(connection);
			UtilidadBD.close(statement);
		}
		return;
	}

	public static ResultSet select(String query, Statement statement) {
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			try {
				statement = connection.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				rs = statement.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			UtilidadBD.close(connection);
		}
		return rs;
	}
}
