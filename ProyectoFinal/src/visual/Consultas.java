package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Consultas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultas frame = new Consultas();
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
	public Consultas() {
		setEnabled(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione la opcion deseada:");
		lblNewLabel.setBounds(189, 105, 315, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad de planes vendidos por tipo:");
		lblNewLabel_1.setBounds(77, 226, 315, 22);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cantidad de Ventas por plan:");
		lblNewLabel_1_1.setBounds(145, 162, 247, 22);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Cantidad de fondos generados:");
		lblNewLabel_1_2.setBounds(130, 271, 262, 22);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Cantidad de fondos por plan:");
		lblNewLabel_1_2_1.setBounds(145, 324, 247, 22);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1_2_1);
		
		JButton btnNewButton = new JButton("Imprimir");
		btnNewButton.setBounds(413, 161, 109, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Imprimir");
		btnNewButton_1.setBounds(413, 225, 109, 23);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Imprimir");
		btnNewButton_2.setBounds(413, 270, 109, 23);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Imprimir");
		btnNewButton_3.setBounds(413, 323, 109, 23);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 668, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Revision");
		lblNewLabel_2.setBounds(10, 26, 280, 47);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 34));
	}
}
