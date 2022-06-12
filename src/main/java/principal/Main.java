package principal;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;

import clases.Usuario;
import clases.Anime;
import interfaces.Ventana;

public class Main {
	public static void main(String[] args) {
		
		String nombreUsuario = ""; // Nombre Usuario
        String contraseniaUsuario = ""; // Contraseña

        for (byte i = 0; i < args.length; i++) {
            if (args[i].equals("-nU")) {
            	nombreUsuario = (args[i + 1]);
            }
            if (args[i].equals("-cU")) {
            	contraseniaUsuario = args[i + 1];
            }
        }
        
		Ventana ventana=new Ventana();
		

	}
}
