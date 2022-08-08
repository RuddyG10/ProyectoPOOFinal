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
import sun.security.util.Length;

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
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroUsuario2.class.getResource("/imagenes/logo altice pf.PNG")));
		setTitle("Altice - Registro Usuario");
		setResizable(false);
		setBounds(100, 100, 670, 508);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(RegistroUsuario2.class.getResource("/imagenes/icono check.png")));
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGuardar.setBackground(SystemColor.control);
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnGuardar.setBackground(new Color(0, 164, 5));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGuardar.setBackground(UIManager.getColor("control"));
			}
		});
		btnGuardar.setBounds(512, 421, 120, 34);
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
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAtras.setIcon(new ImageIcon(RegistroUsuario2.class.getResource("/imagenes/icono atras.png")));
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(UIManager.getColor("control"));
				
			}
		});
		btnAtras.setBackground(SystemColor.control);
		btnAtras.setBounds(10, 421, 139, 34);
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
		
		JLabel lblNewLabel_3 = new JLabel("Registro Usuario");
		lblNewLabel_3.setIcon(new ImageIcon(RegistroUsuario2.class.getResource("/imagenes/Cliente gris.png")));
		lblNewLabel_3.setBounds(10, 23, 523, 50);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion personal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panel_1.setBounds(10, 84, 624, 143);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean mayusculas = key >= 65 && key <= 90;
			    boolean minusculas = key >= 97 && key <= 122;
			    boolean espacio = key == 32;
			            
			     if (!(minusculas || mayusculas || espacio))
			    {
			    	 JOptionPane.showMessageDialog(null, "Solo se deben ingresar caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
			    	 txtApellido.setText("");
			    	 e.consume();
			    }
                	
			}
		});
		txtApellido.setBounds(414, 36, 180, 20);
		panel_1.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			
			}
		});
		txtCorreo.setBounds(414, 67, 180, 20);
		panel_1.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				int key = arg0.getKeyChar();

			    boolean mayusculas = key >= 65 && key <= 90;
			    boolean minusculas = key >= 97 && key <= 122;
			    boolean espacio = key == 32;
			            
			     if (!(minusculas || mayusculas || espacio))
			    {
			    	 JOptionPane.showMessageDialog(null, "Solo se deben ingresar caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
			    	 txtNombre.setText("");
			    	 arg0.consume();
			    }
                	
                   
			}     
			
		});
		txtNombre.setBounds(104, 36, 185, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			        
			    if (!numeros)
			    {
			    	JOptionPane.showMessageDialog(null, "Solo se deben ingresar numeros.", "Error", JOptionPane.ERROR_MESSAGE);
			        e.consume();
			    }

			    if (txtCedula.getText().trim().length() == 10) {
			    	txtCedula.setText("");
			        e.consume();
			    }
			}
		});
		txtCedula.setBounds(104, 67, 185, 20);
		panel_1.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			        
			    if (!numeros)
			    {
			    	JOptionPane.showMessageDialog(null, "Solo se deben ingresar numeros.", "Error", JOptionPane.ERROR_MESSAGE);
			        e.consume();
			    }

			    if (txtTelefono.getText().trim().length() == 10) {
			    	txtTelefono.setText("");
			        e.consume();
			    }
			}
		});
		txtTelefono.setBounds(104, 98, 185, 20);
		panel_1.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Telefono:");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(27, 101, 67, 14);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_6 = new JLabel("Cedula:");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(27, 70, 67, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(27, 39, 67, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("Correo:");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(299, 70, 73, 14);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5 = new JLabel("Apellido:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(299, 39, 73, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblAosDeExperiencia = new JLabel("Experiencia (a\u00F1os):\r\n");
		lblAosDeExperiencia.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAosDeExperiencia.setBounds(299, 101, 116, 14);
		panel_1.add(lblAosDeExperiencia);
		
		spnExp = new JSpinner();
		spnExp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 
				if(Integer.parseInt(spnExp.getValue().toString()) <= 100)
			    {
			        e.consume();
			    }
			}
		});
		spnExp.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnExp.setBounds(414, 98, 180, 20);
		panel_1.add(spnExp);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion del usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panel_2.setBounds(10, 235, 624, 95);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(92, 29, 180, 20);
		panel_2.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(30, 31, 64, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(313, 29, 86, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblConfirmContr = new JLabel("Confirm. Contr.:\r\n");
		lblConfirmContr.setFont(new Font("Arial", Font.PLAIN, 15));
		lblConfirmContr.setBounds(282, 60, 117, 14);
		panel_2.add(lblConfirmContr);
		
		password = new JPasswordField();
		password.setBounds(397, 27, 180, 20);
		panel_2.add(password);
		
		confiPassword = new JPasswordField();
		confiPassword.setBounds(397, 58, 180, 20);
		panel_2.add(confiPassword);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.window);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panel_3.setBounds(10, 335, 624, 62);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		rdbtnComercial = new JRadioButton("Comercial");
		rdbtnComercial.setFont(new Font("Arial", Font.BOLD, 15));
		rdbtnComercial.setBackground(SystemColor.window);
		rdbtnComercial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnComercial.isSelected()) {
					rdbtnAdmin.setSelected(false);
				}
			}
		});
		rdbtnComercial.setBounds(373, 19, 154, 23);
		panel_3.add(rdbtnComercial);
		
		rdbtnAdmin = new JRadioButton("Administrador");
		rdbtnAdmin.setFont(new Font("Arial", Font.BOLD, 15));
		rdbtnAdmin.setBackground(SystemColor.window);
		rdbtnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnAdmin.isSelected()) {
					rdbtnComercial.setSelected(false);
				}
				revision();
			}
		});
		rdbtnAdmin.setBounds(95, 19, 432, 23);
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
	
	/*private boolean verificarCampos() {
		boolean registrar = false;
		if (!txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtCedula.getText().isEmpty()
				&& !txtCorreo.getText().isEmpty() && !txtUsuario.getText().isEmpty()){
			if (rdbtnAdmin.isSelected() || rdbtnComercial.isSelected() ) {
				registrar = true;
			}
		}
	}*/
}
