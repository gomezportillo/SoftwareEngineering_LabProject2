package presentación;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InterfazElegirAccion extends JFrame{

	private JPanel contentPane;

	public InterfazElegirAccion() {
		
		setTitle("GoFit - Elegir acción");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton organizarActividades = new JButton("Eliminar actividad");
		organizarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazOrganizarActividades.mostrarContenido();
			}
		});
		organizarActividades.setBounds(100, 50, 200, 30);
		contentPane.add(organizarActividades);

		JButton nuevoUsuario = new JButton("Registrar nuevo usuario");
		nuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazRegistrarMiembro frame = new InterfazRegistrarMiembro();
				frame.setVisible(true);
			}
		});
		nuevoUsuario.setBounds(100, 150, 200, 30); 
		contentPane.add(nuevoUsuario);

	}
}
