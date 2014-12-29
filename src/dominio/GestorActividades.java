package dominio;

import java.util.Vector;

import persistencia.AgenteBaseDatosActividades;

public class GestorActividades {

	@SuppressWarnings("unchecked")
	public static String[] obtenerListaActividades() throws Exception {
		String [] resultado = null;
		String entrada;
		String SQL = "SELECT * FROM Actividades";

		AgenteBaseDatosActividades agente;
		agente = AgenteBaseDatosActividades.getAgente();

		Vector<Object> big_vector = agente.select(SQL); //devuelve un vector de vectores con todas las actividades
		Vector<Object> tmp_vector;

		resultado = new String[big_vector.size()];

		for (int i=0; i<big_vector.size(); i++){ //transformamos el vector de vectores a un array de strings
			tmp_vector = (Vector<Object>) big_vector.elementAt(i);
			String id = (String) tmp_vector.elementAt(0);
			String entrenador = (String) tmp_vector.elementAt(1);
			String usuario = (String) tmp_vector.elementAt(2);
			String maquina = (String) tmp_vector.elementAt(3);
			String hora = (String) tmp_vector.elementAt(4); 
			entrada = id+" "+entrenador+" "+usuario+" "+maquina+" "+hora;
			//entrada = (String) (tmp_vector.elementAt(0)+" "+tmp_vector.elementAt(1)+" "+tmp_vector.elementAt(2)+" "+tmp_vector.elementAt(3)+" "+tmp_vectpr.elementAt(4);			

			resultado[i] = entrada;
		}
		return resultado;
	}
	
	public int crearActividad() {
		throw new UnsupportedOperationException();
	}

	public int cancelarActividad() {
		throw new UnsupportedOperationException();
	}
	
	public static int eliminarActividad(String codigo){
		
		try {
			String SQL= "DELETE FROM Actividades WHERE codigo='"+codigo+"'";
			AgenteBaseDatosActividades a = AgenteBaseDatosActividades.getAgente();
			a.delete(SQL);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
				
		return 1;
	}
}
