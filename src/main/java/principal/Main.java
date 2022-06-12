package principal;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;

import clases.Usuario;
import clases.Anime;
import interfaces.Ventana;
import utils.UtilsBD;

public class Main {
	public static void main(String[] args) {
		
		String nombreUsuario = ""; // Nombre Usuario
        String contraseniaUsuario = ""; // Contraseña

        for (byte i = 0; i < args.length; i++) {
            if (args[i].equals("-nombreUsuario")) {
            	nombreUsuario = (args[i + 1]);
            }
            if (args[i].equals("-contraseniaUsuario")) {
            	contraseniaUsuario = args[i + 1];
            }
        }
        
        try {
			File registros = new File("./usuariosRegistro.txt");
			if (registros.exists()) {
				Statement query = UtilsBD.conectarBD();
				ResultSet cursor = query.executeQuery("SELECT nombre FROM usuario");
				
				if(!cursor.next()) {
					registros.delete();
					registros.createNewFile();
				}
			}else {
				registros.createNewFile();
			}
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		Ventana ventana=new Ventana(nombreUsuario,contraseniaUsuario);
		

	}
}
