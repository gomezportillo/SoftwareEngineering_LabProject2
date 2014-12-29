package dominio;

import persistencia.AgenteBaseDatosActividades;

public class Actividad {
	private String entrenador, usuario, maquina, hora;

	public Actividad(String entrenador, String usuario, String maquina, String hora) {
		this.entrenador = entrenador;
		this.usuario = usuario;
		this.maquina = maquina;
		this.hora = hora;
	}
	
	
}
