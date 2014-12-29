package dominio;

import java.util.Vector;

import persistencia.AgenteBaseDatosUsuarios;

public class Miembro {
	
	private String nombre;
	private String contraseña;
	private int n_accesos;
	private HuellaDigital huella;
	
	//Constructor para la creacin de un objeto Usuario vacio
	public Miembro(){
		this.nombre = null;
		this.contraseña = null;
		this.n_accesos = 0;
		huella= new HuellaDigital();
	}
	
	//Constructor para la creacin de un Usuario
	public Miembro(String login, String password){
		this.nombre = login;
		this.contraseña = password;
	}
	
	//Selecciona un usuario de la base de datos a partir del login y el password
	public static Miembro read(String login, String password) throws Exception{
		String l,g;
		Miembro u = null;
		Vector<Object> aux = null;
		String SQL_Consulta = "SELECT login, password FROM Usuario WHERE login = '"+login+"' AND password = '"+password+"';";
		
		AgenteBaseDatosUsuarios a = AgenteBaseDatosUsuarios.getAgente();
		Vector<Object> res = a.select(SQL_Consulta);
		
		if (res.size() == 1){ //si solo ha devuelto un resultado
			aux = (Vector<Object>) res.elementAt(0);
			u = new Miembro((String) aux.elementAt(0), (String) aux.elementAt(1)); //crea el usuario
		}
		return u;
	}
	
	//Insercin de un nuevo usuario en la base de datos
	public int insert() throws Exception{
		/*Debe implementarse la lgica para insertar el contenido de un objeto usuario en la base de datos
		 *Los objetos de la capa de dominio se comunican con el agente para enviarle sus peticiones
		 *AYUDA1: la consulta para realizar la insercin es la siguiente
		 * "INSERT INTO Usuario VALUES('"+this.mLogin+"','"+this.mPassword+"');"
		 *AYUDA2: Del mismo modo que para consultar la informacin, el agente provee de un mtodo "select",
		 *para hacer una insercion el agente provee de un metodo "insert"
		 */
		String SQL_Consulta= "INSERT INTO Usuario VALUES('"+nombre+"','"+contraseña+"');"; //definimos la sentencia a ejecutar
		AgenteBaseDatosUsuarios a = AgenteBaseDatosUsuarios.getAgente();
		
		if(read(nombre, contraseña) == null){ //si devuelve null es que no existe, así que lo crea
			a.insert(SQL_Consulta); //lo crea
			return 1;
		}
		else
			return 0;			
	}

	private void increase_number_access() {
		this.n_accesos++;
		
	}
}
