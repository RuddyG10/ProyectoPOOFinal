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
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroUsuario2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JButton btnAtras;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroUsuario2 frame = new RegistroUsuario2();
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
	public RegistroUsuario2() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBackground(Color.GREEN);
		btnGuardar.setForeground(Color.DARK_GRAY);
		btnGuardar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnGuardar.setBackground(new Color(0, 164, 5));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGuardar.setBackground(new Color(27, 243, 34));
			}
		});
		btnGuardar.setBounds(545, 388, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*String usuario = txtUsuario.getText();
				String contrasena = txtContraseña.getText();
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
				}*/
			}
		});
		contentPane.add(btnGuardar);
		
		btnAtras = new JButton("Regresar");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(243, 193, 27));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(new Color(228, 178, 14));
			}
		});
		btnAtras.setBackground(new Color(255, 153, 0));
		btnAtras.setBounds(10, 388, 89, 23);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*login prueba = new login();
				prueba.setVisible(true);
				dispose();*/
			}
		});
		contentPane.add(btnAtras);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -11, 686, 84);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Registrarse");
		lblNewLabel_3.setBounds(10, 41, 249, 32);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 27));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Informacion personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 84, 624, 143);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(422, 36, 180, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(422, 67, 180, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 36, 185, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(133, 67, 185, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(133, 98, 185, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Telefono:");
		lblNewLabel_8.setBounds(27, 101, 67, 14);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_6 = new JLabel("Cedula:");
		lblNewLabel_6.setBounds(27, 70, 67, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre:");
		lblNewLabel_4.setBounds(27, 39, 67, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("Correo:");
		lblNewLabel_7.setBounds(339, 73, 73, 14);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5 = new JLabel("Apellido:");
		lblNewLabel_5.setBounds(339, 42, 73, 14);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Informacion del usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 235, 624, 62);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(99, 26, 185, 20);
		panel_2.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(25, 29, 64, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(313, 29, 86, 14);
		panel_2.add(lblNewLabel_1);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(409, 26, 180, 20);
		panel_2.add(txtContraseña);
		txtContraseña.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Informacion del usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 303, 624, 62);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Comercial");
		rdbtnNewRadioButton_1.setBounds(373, 19, 109, 23);
		panel_3.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Administrador");
		rdbtnNewRadioButton.setBounds(95, 19, 109, 23);
		panel_3.add(rdbtnNewRadioButton);
	}
}
