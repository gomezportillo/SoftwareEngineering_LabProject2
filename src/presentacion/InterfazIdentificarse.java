package presentación;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import dominio.GestorMiembros;

public class InterfazIdentificarse extends JFrame{

	private JPanel contentPane;
	private JTextField textFieldLog;
	private JTextField textFieldPass;
	private JTextPane textPaneEstado;

	public InterfazIdentificarse() {

		setTitle("GoFit - Acceso a GoFit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIntroduzcaElLogin = new JLabel("Introduzca su nombre y contraseña");
		lblIntroduzcaElLogin.setBounds(6, 19, 386, 43);
		contentPane.add(lblIntroduzcaElLogin);

		textFieldLog = new JTextField();
		textFieldLog.setBounds(86, 68, 134, 28);
		contentPane.add(textFieldLog);
		textFieldLog.setColumns(10);

		JLabel label = new JLabel("Nombre:");
		label.setBounds(6, 74, 61, 16);
		contentPane.add(label);

		JLabel lblLogin = new JLabel("Contraseña:");
		lblLogin.setBounds(6, 122, 73, 16);
		contentPane.add(lblLogin);

		textFieldPass = new JTextField();
		textFieldPass.setColumns(10);
		textFieldPass.setBounds(86, 116, 134, 28);
		contentPane.add(textFieldPass);

		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(GestorMiembros.autenticar(textFieldLog.getText() , textFieldPass.getText())){
						textPaneEstado.setText("Usuario correcto");
						InterfazElegirAccion frame = new InterfazElegirAccion();
						frame.setVisible(true);

					}else
						textPaneEstado.setText("Usuario no encontrado en la base de datos");
				} catch (Exception e) {
					textPaneEstado.setText("Error al cargar base de datos");
					e.printStackTrace();
				}
			}
		});

		buttonAceptar.setBounds(264, 69, 117, 29);
		contentPane.add(buttonAceptar);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.RED);
		lblEstado.setBounds(6, 171, 61, 16);
		contentPane.add(lblEstado);

		textPaneEstado = new JTextPane();
		textPaneEstado.setToolTipText("Panel para mostrar el restultado de la comprobacion de login o las excepciones lanzadas");
		textPaneEstado.setEditable(false);
		textPaneEstado.setBounds(6, 199, 407, 102);
		contentPane.add(textPaneEstado);

		JButton quickAccess = new JButton("Quick access");
		quickAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldPass.setText("palotes"); //para acceder mas rapido
				textFieldLog.setText("perico");
			}
		});
		quickAccess.setBounds(264, 117, 117, 29);
		contentPane.add(quickAccess);

	}
}
