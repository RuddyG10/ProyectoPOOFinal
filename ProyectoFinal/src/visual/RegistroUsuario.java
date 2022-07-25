package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.ListaUsuario;
import logico.Trabajador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JTextField txtRango;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroUsuario frame = new RegistroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(26, 29, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(10, 66, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(82, 26, 124, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasena = new JTextField();
		txtContrasena.setBounds(82, 63, 124, 20);
		contentPane.add(txtContrasena);
		txtContrasena.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = txtUsuario.getText();
				String contrasena = txtContrasena.getText();
				String rango = txtRango.getText();
				Trabajador obj = new Trabajador();
				if(Trabajador.verificarUserNuevo(usuario)==-1) {
					
				
				
				obj.setUserName(usuario);
				obj.setPassword(contrasena);
				//agregar rango luego
				ListaUsuario.agregar(obj);
				JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente!", "Error", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Este nombre de usuario ya esta siendo usado", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(121, 105, 89, 23);
		contentPane.add(btnNewButton);
		
		txtRango = new JTextField();
		txtRango.setBounds(323, 26, 86, 20);
		contentPane.add(txtRango);
		txtRango.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Rango:");
		lblNewLabel_2.setBounds(270, 29, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("Prueba");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login prueba = new login();
				prueba.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(121, 139, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
