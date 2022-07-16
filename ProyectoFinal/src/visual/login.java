package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame {
	
	private Component confirmacion;
	private String usuario, password;

	private JPanel contentPane;
	private JTextField txtUser;
	private final JPanel panel = new JPanel();
	private JTextField txtPassword;

	
	//metodos
	
			/**
			 * @param usuario
			 * @param password
			 */
	//Metodo para vincular con clase empleado
	public void datos (String usuario, String password) {
	usuario="Admin";
	password="prueba";
	}
			
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Raymer (Trabajos)\\Desktop\\imagenes proyecto poo\\Altice_logo_(new).png"));
		setTitle("Altice - Iniciar Sesion ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 356);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Iniciar Sesi\u00F3n");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(369, 88, 189, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(337, 125, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(337, 189, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUser.setForeground(Color.LIGHT_GRAY);
		txtUser.setText("Ingrese su nombre de usuario");
		txtUser.setBounds(337, 147, 221, 26);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtUser = new javax.swing.JTextField();
	    txtPassword = new javax.swing.JPasswordField();
		
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(new Color(0, 102, 255));
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 btnIngresar.setBackground(new Color(2, 21, 58));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresar.setBackground(new Color(7, 85, 228));
			}
		});
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				datos(usuario, password);
			    if(usuario.equals(txtUser.getText()) && password.equals(txtPassword.getText())){
			    	//Manda al menu de inicio
			         home st = new home();
			         st.setVisible(true);
			         
			    }else if(txtUser.getText().equals("") && txtPassword.getText().equals("")){
			        JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña estan vacios\\nIngrese los datos por favor.");
			        txtUser.setFocusable(true);
			    }else if(txtUser.getText().equals("")){
			        JOptionPane.showMessageDialog(null, "Usuario está vacio\nIngrese lo por favor.");
			        txtUser.setFocusable(true);
			    }else if(txtPassword.getText().equals("")){
			        JOptionPane.showMessageDialog(null, "Contraseña está vacio\nIngrese lo por favor.");
			        txtPassword.setFocusable(true);
			    }
			    else if(txtUser.getText().compareTo(usuario)!=0 && txtPassword.getText().compareTo(password)!=0){
			        JOptionPane.showMessageDialog(null,"Usuario y/o Contraseña no válidos\nIngrese nuevamente.");
			         txtUser.setFocusable(true);
			    }
			    else if(txtUser.getText().compareTo(usuario)!=0){
			        JOptionPane.showMessageDialog(null,"Usuario no válido\nIngrese nuevamente.");
			        txtUser.setFocusable(true);
			    }else if(txtPassword.getText().compareTo(password)!=0){
			        JOptionPane.showMessageDialog(null,"Contraseña no válida\nIngrese nuevamente.");
			        txtPassword.setFocusable(true);
			    }
			}
		});
		btnIngresar.setFont(new Font("Arial", Font.BOLD, 14));
		btnIngresar.setBounds(449, 244, 109, 23);
		contentPane.add(btnIngresar);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 584, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 11, 259, 66);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Raymer (Trabajos)\\Desktop\\imagenes proyecto poo\\altice-logo-peq.png"));
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 70, 302, 247);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Raymer (Trabajos)\\Desktop\\imagenes proyecto poo\\6133d52651d25 (1).jpg"));
		
		JLabel lblNewLabel_5 = new JLabel("\u00BFInconvenientes para acceder? \r\n");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setBounds(372, 278, 163, 14);
		contentPane.add(lblNewLabel_5);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPassword.setText("*********\r\n");
		txtPassword.setForeground(Color.LIGHT_GRAY);
		txtPassword.setColumns(10);
		txtPassword.setBounds(337, 207, 221, 26);
		contentPane.add(txtPassword);
		
		JLabel lblContacteASu = new JLabel("Contacte al Admin. del Sistema al 1-800-2000\r\n");
		lblContacteASu.setForeground(Color.BLUE);
		lblContacteASu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContacteASu.setBounds(337, 290, 238, 14);
		contentPane.add(lblContacteASu);
		
		
	}
}
