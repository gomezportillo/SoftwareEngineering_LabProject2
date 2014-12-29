package dominio;

public class GestorMiembros {
	
	public static boolean autenticar(String login, String password) throws Exception{
		boolean autenticado = false;
		
		if(Miembro.read(login, password) != null) //si devuelve el vector es que ese usuario ya existía
			autenticado = true;
		return autenticado;
	}
	
	public static boolean nuevoUsuario(String login, String password) throws Exception{
		boolean insertado = false;
		
		Miembro u = new Miembro(login, password); //creamos el usuario
		if(u.insert() == 1) //si no existe se crea
			insertado = true;
		return insertado;		
	}

}
