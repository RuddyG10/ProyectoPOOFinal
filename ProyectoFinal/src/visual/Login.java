package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import com.sun.javafx.event.EventQueue;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class Login extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUser;
	private JPasswordField password;
	private JButton btnIniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream altice;
				FileOutputStream altice2;
				ObjectInputStream reader;
				ObjectOutputStream alticeWrite;
				try {
					altice = new FileInputStream("altice.dat");
					reader = new ObjectInputStream(altice);
					int genCodeFac = reader.readInt();
					int genCodePlan = reader.readInt();
					int genCodeServ = reader.readInt();
					int genCodeVent = reader.readInt();
					int genCodeFile = reader.readInt();
					Altice temp = (Altice)reader.readObject();
					Altice.setAltice(temp);
					temp.genCodeFac = genCodeFac;
					temp.genCodePlan = genCodePlan;
					temp.genCodeServ = genCodeServ;
					temp.genCodeVent = genCodeVent;
					temp.genCodeFile = genCodeFile;
					altice.close();
					reader.close();
					
				} catch (FileNotFoundException e) {
					try {
						altice2 = new FileOutputStream("altice.dat");
						alticeWrite = new ObjectOutputStream(altice2);
						Trabajador admin = new Administrador("admin", "admin", "000", "0000", "administrador", "admin", "admin", 0);
						Altice.getInstance().insertarTrabajador(admin);
						alticeWrite.writeInt(Altice.getInstance().genCodeFac);
						alticeWrite.writeInt(Altice.getInstance().genCodePlan);
						alticeWrite.writeInt(Altice.getInstance().genCodeServ);
						alticeWrite.writeInt(Altice.getInstance().genCodeVent);
						alticeWrite.writeInt(Altice.getInstance().genCodeFile);
						alticeWrite.writeObject(Altice.getInstance());
						
						altice2.close();
						alticeWrite.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagenes/logo altice pf.PNG")));
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				FileOutputStream altice2;
				ObjectOutputStream alticeWrite;
				try {
					altice2 = new FileOutputStream("altice.dat");
					alticeWrite = new ObjectOutputStream(altice2);
					alticeWrite.writeInt(Altice.getInstance().genCodeFac);
					alticeWrite.writeInt(Altice.getInstance().genCodePlan);
					alticeWrite.writeInt(Altice.getInstance().genCodeServ);
					alticeWrite.writeInt(Altice.getInstance().genCodeVent);
					alticeWrite.writeInt(Altice.getInstance().genCodeFile);
					alticeWrite.writeObject(Altice.getInstance());
				} catch (FileNotFoundException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Login log = new Login();
				log.setVisible(true);
			}
		});
		setTitle("Altice - Iniciar Sesi\u00F3n");
		setBounds(100, 100, 525, 333);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(304, 0, 205, 315);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-45, 80, 275, 142);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/image.png")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/imagenes/icons8-male-user-100.png")));
		lblNewLabel_1.setBounds(85, 10, 107, 100);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Iniciar Sesi\u00F3n");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(73, 120, 155, 16);
		contentPanel.add(lblNewLabel_2);
		
		txtUser = new JTextField();
		txtUser.setBounds(134, 162, 141, 20);
		contentPanel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario o Email:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 164, 114, 14);
		contentPanel.add(lblNewLabel_3);
		
		password = new JPasswordField();
		password.setBounds(134, 205, 141, 20);
		contentPanel.add(password);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 13));
		lblContrasea.setBounds(10, 207, 114, 14);
		contentPanel.add(lblContrasea);
		
		btnIniciar = new JButton("Ingresar");
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
					if(Altice.getInstance().login(txtUser.getText(), pass) != null) {
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
		btnIniciar.setBounds(186, 245, 89, 23);
		contentPanel.add(btnIniciar);
	}
}
