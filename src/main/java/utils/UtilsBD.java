package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class UtilsBD {

	private static final String cadenaConexion = "jdbc:mysql://127.0.0.1:3306/AnimeFlvBBD";
	private static final String usuarioBD = "root";
	private static final String contraseñaBD = "Alejandro300403";
	private static Connection conexion;
	
	public static Statement conectarBD() {
		
	try {
		if(conexion==null) {
			conexion=DriverManager.getConnection(cadenaConexion,usuarioBD,contraseñaBD);
			
		}
		return conexion.createStatement();
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("No se ha podido conectar intentelo luego");
			return null;
		}
	}
	
	public static void desconectarBD() {
		if(conexion!=null) {
			try {
				conexion.close();
				conexion = null;
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("No se pudo desconectar");
			}
		}
	}
}