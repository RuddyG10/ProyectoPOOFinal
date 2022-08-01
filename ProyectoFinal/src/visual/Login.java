package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import logico.Administrador;
import logico.Altice;
import logico.Trabajador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUser;
	private JPasswordField password;
	private JButton btnIniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setTitle("Iniciar Sesion");
		setBounds(100, 100, 525, 354);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(253, 245, 230));
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(304, 0, 205, 315);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/image.png")));
		lblNewLabel.setBounds(-45, 80, 275, 142);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/imagenes/icons8-male-user-100.png")));
		lblNewLabel_1.setBounds(86, 0, 107, 100);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Iniciar Sesion");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(70, 111, 155, 16);
		contentPanel.add(lblNewLabel_2);
		
		txtUser = new JTextField();
		txtUser.setBounds(134, 152, 141, 20);
		contentPanel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario o Email:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 154, 114, 14);
		contentPanel.add(lblNewLabel_3);
		
		password = new JPasswordField();
		password.setBounds(134, 199, 141, 20);
		contentPanel.add(password);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContrasea.setBounds(10, 201, 114, 14);
		contentPanel.add(lblContrasea);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnIniciar.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnIniciar.setBackground(UIManager.getColor("control"));
			}
		});
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!txtUser.getText().isEmpty() && password.getPassword().length>0) {
					String pass = String.valueOf(password.getPassword());
					if(txtUser.getText().equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) {
						Menu menu = new Menu(null);
						menu.setVisible(true);
						dispose();
					}
					else if(Altice.getInstance().login(txtUser.getText(), pass) != null) {
						Trabajador admin = Altice.getInstance().login(txtUser.getText(), pass);
						Menu menu = new Menu(admin);
						menu.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Debe completar la informacion.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnIniciar.setBounds(86, 230, 89, 23);
		contentPanel.add(btnIniciar);
	}
}
