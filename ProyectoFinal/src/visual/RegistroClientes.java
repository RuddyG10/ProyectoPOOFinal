package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

public class RegistroClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroClientes frame = new RegistroClientes();
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
	public RegistroClientes() {
		setResizable(false);
		setTitle("Altice - Registrar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 658, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar Cliente");
		lblNewLabel.setBounds(10, 52, 241, 35);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 153, 638, 202);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cedula:");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:\r\n");
		lblNewLabel_2.setBounds(10, 85, 65, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido:");
		lblNewLabel_3.setBounds(280, 85, 73, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono:");
		lblNewLabel_4.setBounds(10, 145, 65, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Direccion:");
		lblNewLabel_5.setBounds(280, 145, 105, 14);
		panel_1.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(66, 33, 132, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 82, 204, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(363, 85, 229, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(69, 142, 201, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(362, 142, 230, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("Guardar");
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(Color.GREEN);
		button.setBounds(544, 400, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Regresar");
		button_1.setBackground(Color.ORANGE);
		button_1.setBounds(28, 400, 89, 23);
		contentPane.add(button_1);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha:");
		lblNewLabel_6.setBounds(486, 124, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(542, 121, 106, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}
