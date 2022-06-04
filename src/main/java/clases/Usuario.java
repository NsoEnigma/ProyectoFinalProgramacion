package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.AñoInvalidoException;
import exceptions.ContraseñaIncorrectaException;
import exceptions.ContraseñaVaciaException;
import exceptions.EmailValidoException;
import exceptions.UsuarioNoExisteException;
import utils.UtilsBD;

/**
 * DAO de usuario que hace que todas las operaciones CRUD dentro de sus
 * funciones
 * 
 * @author Marcos
 *
 */
public class Usuario implements Comparable{
	private String nombre;
	private String email;
	private String contraseña;
	private short añoNacimiento;
	private LocalDate fechaNacimiento;
	private LocalDateTime momentoRegistro;
	private LocalTime horaAcostarse;

	public Usuario(String nombre, String email, String contraseña, short añoNacimiento, LocalDate fN, LocalDateTime mR,
			LocalTime hA) throws SQLException, ContraseñaVaciaException, EmailValidoException, AñoInvalidoException,
			DateTimeException {
		super();
		if (contraseña.isBlank()) {
			throw new ContraseñaVaciaException("La contraseña no puede estar vacia.");
		}

		if (!this.emailVallido(email)) {
			throw new EmailValidoException("El email tiene que tener @.");
		}

		if (!this.añoValido(añoNacimiento)) {
			throw new AñoInvalidoException("El año de nacimiento tiene que ser inferior al año actual");
		}
		Statement query = UtilsBD.conectarBD();
		// Insertar

		if (query.executeUpdate("insert into usuario values('" + nombre + "','" + email + "','" + contraseña + "',"
				+ añoNacimiento + ",'" + fN + "','" + mR + "','" + hA + "')") > 0) {
			this.nombre = nombre;
			this.setEmail(email);
			this.setContraseña(contraseña);
			this.añoNacimiento = añoNacimiento;
			this.fechaNacimiento = fN;
			this.momentoRegistro = mR;
			this.horaAcostarse = hA;

		} else {
			throw new SQLException("No se ha podido insertar el usuario.");
		}
		UtilsBD.desconectarBD();
	}

	/**
	 * Constructor que a partir de la clave primaria (nombre) Consulta en base de
	 * datos el usuario que ya tenga ese nombre. Si no existe, lanza un
	 * SQLException. Si existe, rellena el resto de variables internas a partir de
	 * los valores que le da el cursor de la consulta
	 * 
	 * @param nombre el nombre que debería existir ya en la BD
	 * @throws SQLException excepción lanzada si no se encuentra el nombre
	 * 
	 */
	public Usuario(String nombre, String contraseña)
			throws SQLException, ContraseñaIncorrectaException, UsuarioNoExisteException {
		Scanner sc = new Scanner(System.in);
		Statement smt = UtilsBD.conectarBD();
		ResultSet cursor = smt.executeQuery("select * from usuario where nombre='" + nombre + "'");

		if (cursor.next()) {
			this.contraseña = cursor.getString("contrasena");

			if (!this.contraseña.equals(contraseña)) {
				UtilsBD.desconectarBD();
				throw new ContraseñaIncorrectaException("La contraseña no es correcta.");
			}

			this.nombre = cursor.getString("nombre");
			this.email = cursor.getString("email");
			this.añoNacimiento = cursor.getShort("anioNacimiento");
			this.fechaNacimiento = cursor.getDate("fechaNacimiento").toLocalDate();
			this.momentoRegistro = cursor.getTimestamp("momentoRegistro").toLocalDateTime();
			this.horaAcostarse = cursor.getTime("horaAcostarse").toLocalTime();
		} else {
			UtilsBD.desconectarBD();
			throw new UsuarioNoExisteException("No existe el usuario en la BD.");
		}
		UtilsBD.desconectarBD();
	}

	/**
	 * Constructor que a partir de la clave primaria (nombre) Consulta en base de
	 * datos el usuario que ya tenga ese nombre. Si no existe, lanza un
	 * SQLException. Si existe, rellena el resto de variables internas a partir de
	 * los valores que le da el cursor de la consulta
	 * 
	 * @param nombre el nombre que deber�a existir ya en la BD
	 * @throws SQLException excepci�n lanzada si no se encuentra el nombre
	 * 
	 */
	protected Usuario(String nombre) throws SQLException {
		Statement query = UtilsBD.conectarBD();
		ResultSet devuelveDatos = query.executeQuery("select * from usuario where nombre='" + nombre + "'");
		if (devuelveDatos.next()) {
			this.nombre = devuelveDatos.getString("nombre");
			email = devuelveDatos.getString("email");
			contraseña = devuelveDatos.getString("contrasena");
			añoNacimiento = devuelveDatos.getShort("anioNacimiento");
			this.fechaNacimiento = devuelveDatos.getDate("fechaNacimiento").toLocalDate();
			this.momentoRegistro = devuelveDatos.getTimestamp("momentoRegistro").toLocalDateTime();
			this.horaAcostarse = devuelveDatos.getTime("horaAcostarse").toLocalTime();
		} else {
			UtilsBD.desconectarBD();
			throw new SQLException("No se ha podido insertar el usuario");
		}
		UtilsBD.desconectarBD();
	}

	public Usuario() {

	}

	/**
	 * Comprobamos si una contraseña es valida o no.
	 * 
	 * @param pass
	 * @return
	 */
	private boolean contraseñaValida(String pass) {
		return !pass.isBlank();
	}

	private boolean emailVallido(String email) {
		return email.contains("@");
	}

	private boolean añoValido(short añoNacimiento) {
		return añoNacimiento < LocalDate.now().getYear();
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter de nombre persiste el nombre en la BD.
	 * 
	 * @param nombre
	 * @throws SQLException
	 */
	public void setNombre(String nombre) throws SQLException {

		// Primero intentamos el update, si no funciona en BD no se hace en java.
		Statement smt = UtilsBD.conectarBD();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.

		if (smt.executeUpdate("update usuario set nombre='" + nombre + "' where nombre='" + this.nombre + "'") > 0) {
			this.nombre = nombre;
		}
		UtilsBD.desconectarBD();

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws SQLException, EmailValidoException {
		if (!this.emailVallido(email)) {
			throw new EmailValidoException("El email tiene que tener @.");
		}

		Statement smt = UtilsBD.conectarBD();

		if (smt.executeUpdate("update usuario set email='" + email + "' where nombre='" + this.nombre + "'") > 0) {
			this.email = email;
		}
		UtilsBD.desconectarBD();

	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) throws SQLException, ContraseñaVaciaException {
		if (contraseña.isBlank()) {
			throw new ContraseñaVaciaException("La contraseña no puede estar vacia.");
		}
		Statement smt = UtilsBD.conectarBD();

		if (smt.executeUpdate(
				"update usuario set contrasena='" + contraseña + "' where nombre='" + this.nombre + "'") > 0) {
			this.contraseña = contraseña;
		}
		UtilsBD.desconectarBD();

	}

	public short getAñoNacimiento() {
		return añoNacimiento;
	}

	public void setAñoNacimiento(short añoNacimiento) throws SQLException, AñoInvalidoException {
		if (!this.añoValido(añoNacimiento)) {
			throw new AñoInvalidoException("El año no puede ser superior al año actual");
		}
		Statement an = UtilsBD.conectarBD();
		if (an.executeUpdate("update usuario set anioNacimiento = '" + añoNacimiento + "' where nombre = '"
				+ this.nombre + "'") > 0) {
			this.añoNacimiento = añoNacimiento;
		}
		UtilsBD.desconectarBD();
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) throws SQLException {

		Statement smt = UtilsBD.conectarBD();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.
		if (smt.executeUpdate(
				"update usuario set nombre='" + fechaNacimiento + "' where nombre='" + this.nombre + "'") > 0) {
			this.fechaNacimiento = fechaNacimiento;
		}
		UtilsBD.desconectarBD();

	}

	public LocalDateTime getMomentoRegistro() {
		return momentoRegistro;
	}

	public void setMomentoRegistro(LocalDateTime momentoRegistro) throws SQLException {
		Statement smt = UtilsBD.conectarBD();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.

		if (smt.executeUpdate(
				"update usuario set nombre='" + momentoRegistro + "' where nombre='" + this.nombre + "'") > 0) {
			this.momentoRegistro = momentoRegistro;
		}

		UtilsBD.desconectarBD();

	}

	public LocalTime getHoraAcostarse() {
		return horaAcostarse;
	}

	public void setHoraAcostarse(LocalTime horaAcostarse) throws SQLException {
		Statement smt = UtilsBD.conectarBD();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.

		if (smt.executeUpdate(
				"update usuario set nombre='" + horaAcostarse + "' where nombre='" + this.nombre + "'") > 0) {
			this.horaAcostarse = horaAcostarse;

		}

		UtilsBD.desconectarBD();
	}

	/**
	 * elimina el usuario de la base de datos y lo pone a null en Java para que no
	 * haya desfase objeto-relacional. En caso de que no se pueda borrar de base de
	 * datos, el objeto java se queda como estaba.
	 * 
	 * @param u el usuario a eliminar.
	 * @return true si se ha eliminado, false si no se ha podido
	 */

	public boolean eliminar() {
		// El borrado lo hacemos con la PK para no equivocarnos y borrar lo que no es.

		Statement smt = UtilsBD.conectarBD();
		boolean ret;
		try {
			// Primero lo eliminamos de la base de datos.
			ret = smt.executeUpdate("delete from usuario where nombre='" + this.nombre + "'") > 0;
			// Luego lo eliminamos de Java.
			this.nombre = null;
			this.añoNacimiento = 0;
			this.contraseña = null;
			this.email = null;
			this.fechaNacimiento = null;
			this.momentoRegistro = null;
			this.horaAcostarse = null;
		} catch (SQLException e) {
			UtilsBD.desconectarBD();
			return false;
		}
		UtilsBD.desconectarBD();
		return ret;
	}

	public static ArrayList<Usuario> getTodos() {
		Statement smt = UtilsBD.conectarBD();
		// Inicializamos un ArrayList para devolver.
		ArrayList<Usuario> ret = new ArrayList<Usuario>();

		try {
			ResultSet cursor = smt.executeQuery("select * from usuario");
			while (cursor.next()) {
				Usuario actual = new Usuario();

				actual.nombre = cursor.getString("nombre");
				actual.contraseña = cursor.getString("contrasena");
				actual.email = cursor.getString("email");
				actual.añoNacimiento = cursor.getShort("anioNacimiento");
				actual.fechaNacimiento = cursor.getDate("fechaNacimiento").toLocalDate();
				actual.momentoRegistro = cursor.getTimestamp("momentoRegistro").toLocalDateTime();
				actual.horaAcostarse = cursor.getTime("horaAcostarse").toLocalTime();

				ret.add(actual);
			}
		} catch (SQLException e) {
			// Si la conuslta falla no hay nada que devolver.
			e.printStackTrace();
			return null;
		}
		// Si no hay usuarios en la tabla, va a devolver un arraylist vacio.
		// Si la consulta fue erronea se devuelve un arraylist null, que son cosas
		// distintas.
		UtilsBD.desconectarBD();
		return ret;
	}


	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + ", añoNacimiento=" + añoNacimiento
				+ ", fechaNacimiento=" + fechaNacimiento + ", momentoRegistro=" + momentoRegistro + ", horaAcostarse="
				+ horaAcostarse + "]";
	}

	@Override
	public int compareTo(Object o) {
		Usuario otro=(Usuario)o;
		if(otro.fechaNacimiento.compareTo(this.fechaNacimiento)==0) {
			return otro.nombre.compareTo(this.nombre);
		}else {
			return otro.fechaNacimiento.compareTo(this.fechaNacimiento);
		}
	}

	@Override
	public boolean equals(Object obj) {
		Usuario otro=(Usuario)obj;
		return this.nombre.equals(otro.nombre);
	}
	
	

}
