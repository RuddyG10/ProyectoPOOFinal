package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class home extends JFrame {

	private JPanel contentPane;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setTitle("Altice - Menu Principal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1456, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1380, 100);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(197, 197, 280, 80);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(197, 308, 280, 80);
		contentPane.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(197, 432, 280, 80);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(519, 432, 280, 80);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(519, 308, 280, 80);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(519, 197, 280, 80);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(889, 432, 280, 80);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(889, 308, 280, 80);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(889, 197, 280, 80);
		contentPane.add(button_7);
		
		JLabel lblNewLabel = new JLabel("Bienvenido! Seleccione la opcion deseada");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 122, 440, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.setBounds(1127, 599, 177, 49);
		contentPane.add(btnNewButton_1);
		
		this.setExtendedState(MAXIMIZED_BOTH);
	}
}
