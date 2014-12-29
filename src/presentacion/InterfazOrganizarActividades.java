package presentación;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import dominio.GestorActividades;

public class InterfazOrganizarActividades {
	
	public static void mostrarContenido(){
	try {
		ImageIcon imagen = new ImageIcon("gofit.png"); 
		String[] listActividades = GestorActividades.obtenerListaActividades();
		String choosen=(String) JOptionPane.showInputDialog(null,"Elige una actividad para eliminar\n Codigo | Entrenador | Miembro | Hora", "Eliminar actividad",JOptionPane.QUESTION_MESSAGE, imagen, listActividades,listActividades[0]); 

		/*obtenemos cada palabra de la actividad seleccionada*/
		String actividad [] =choosen.split(" ");			
		if(1 == GestorActividades.eliminarActividad(actividad[0])){ //le pasamos el codigo de la actividad que queremos eliminar
			JOptionPane.showMessageDialog(null, "La actividad seleccionada fue eliminada con exito","GoFit - Correcto", JOptionPane.INFORMATION_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null, "Error al eliminar la actividad","GoFit - Error", JOptionPane.ERROR_MESSAGE);

	} catch (Exception e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos","GoFit - Error", JOptionPane.ERROR_MESSAGE);
	}
}
}
