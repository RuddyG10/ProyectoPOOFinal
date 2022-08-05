package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Administrador;
import logico.Altice;
import logico.Comercial;
import logico.Trabajador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class RegistroUsuario2 extends JDialog {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton btnAtras;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JPasswordField password;
	private JPasswordField confiPassword;
	private JRadioButton rdbtnAdmin;
	private JRadioButton rdbtnComercial;
	private JSpinner spnExp;

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
		btnGuardar.setBounds(545, 408, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(revision()) {
					String nombre = txtNombre.getText();
					String apellido = txtApellido.getText();
					String cedula = txtCedula.getText();
					String correo = txtCorreo.getText();
					String telefono = txtTelefono.getText();
					String user = txtUsuario.getText();
					String pw = String.valueOf(password.getPassword());
					String cfPw = String.valueOf(confiPassword.getPassword());
					int exp = Integer.parseInt(spnExp.getValue().toString());
					
					if(Altice.getInstance().buscarTrabajadorByCedula(cedula) == null) {
							if(pw.length() > 6) {
								if(pw.equalsIgnoreCase(cfPw)) {
									if(rdbtnAdmin.isSelected()) {
										if(exp>=0) {
											Trabajador admin = new Administrador(nombre, apellido, cedula, telefono, correo, user, pw, exp);
											
										    int option = JOptionPane.showConfirmDialog(null, "Desea guardar la informacion?", "Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
										    if(option == 0) {
										    	Altice.getInstance().insertarTrabajador(admin);
										    	JOptionPane.showMessageDialog(null, "Registro exitoso.", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
										    	clear();
										    }
										}
										
									}
									else if(rdbtnComercial.isSelected()) {
		
										Trabajador admin = new Comercial(nombre, apellido, cedula, telefono, correo, user, pw);
										
									    int option = JOptionPane.showConfirmDialog(null, "Desea guardar la informacion?", "Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
									    if(option == 0) {
									    	Altice.getInstance().insertarTrabajador(admin);
									    	JOptionPane.showMessageDialog(null, "Registro exitoso.", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
									    	clear();
									    }
									}
									else {
										JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de ususario.", "Error", JOptionPane.ERROR_MESSAGE);
									    
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "Contraseña no es igual a la confirmacion de la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Contraseña debe tener por lo menos 6 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
							}
					}
					else {
						JOptionPane.showMessageDialog(null, "La cedula escrita ya esta registrada.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
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
		btnAtras.setBounds(10, 408, 89, 23);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
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
		
		txtApellido = new JTextField();
		txtApellido.setBounds(414, 36, 180, 20);
		panel_1.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(414, 67, 180, 20);
		panel_1.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(104, 36, 185, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(104, 67, 185, 20);
		panel_1.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(104, 98, 185, 20);
		panel_1.add(txtTelefono);
		txtTelefono.setColumns(10);
		
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
		lblNewLabel_7.setBounds(299, 70, 73, 14);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5 = new JLabel("Apellido:");
		lblNewLabel_5.setBounds(299, 39, 73, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblAosDeExperiencia = new JLabel("Experiencia (a\u00F1os):\r\n");
		lblAosDeExperiencia.setBounds(299, 101, 116, 14);
		panel_1.add(lblAosDeExperiencia);
		
		spnExp = new JSpinner();
		spnExp.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnExp.setBounds(414, 98, 180, 20);
		panel_1.add(spnExp);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Informacion del usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 235, 624, 95);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(99, 26, 180, 20);
		panel_2.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(25, 29, 64, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(25, 70, 86, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblConfirmContr = new JLabel("Confirm. Contr.:\r\n");
		lblConfirmContr.setBounds(289, 70, 101, 14);
		panel_2.add(lblConfirmContr);
		
		password = new JPasswordField();
		password.setBounds(99, 67, 180, 20);
		panel_2.add(password);
		
		confiPassword = new JPasswordField();
		confiPassword.setBounds(400, 67, 180, 20);
		panel_2.add(confiPassword);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Tipo de usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 335, 624, 62);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		rdbtnComercial = new JRadioButton("Comercial");
		rdbtnComercial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnComercial.isSelected()) {
					rdbtnAdmin.setSelected(false);
				}
			}
		});
		rdbtnComercial.setBounds(373, 19, 109, 23);
		panel_3.add(rdbtnComercial);
		
		rdbtnAdmin = new JRadioButton("Administrador");
		rdbtnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnAdmin.isSelected()) {
					rdbtnComercial.setSelected(false);
				}
			}
		});
		rdbtnAdmin.setBounds(95, 19, 109, 23);
		panel_3.add(rdbtnAdmin);
	}
	public void clear() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtCedula.setText("");
		txtCorreo.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		txtUsuario.setText("");
		spnExp.setValue(0);
		rdbtnAdmin.setSelected(false);
		rdbtnComercial.setSelected(false);
		password.setText("");
		confiPassword.setText("");
	}
	public boolean revision() {
		boolean reg = false;
		if(!txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtCedula.getText().isEmpty() &&
				!txtCorreo.getText().isEmpty() && !txtTelefono.getText().isEmpty() && !txtUsuario.getText().isEmpty()) {
			if(password.getPassword().length>0 && confiPassword.getPassword().length>0) {
				if(rdbtnAdmin.isSelected() || rdbtnComercial.isSelected()) {
					reg = true;
				}
			}
			
		}
		return reg;
	}
}
