package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Altice;
import logico.Plan;
import logico.Venta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione la opcion deseada:");
		lblNewLabel.setBounds(181, 125, 315, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cantidad de Ventas por plan:");
		lblNewLabel_1_1.setBounds(127, 187, 247, 22);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Cantidad de fondos generados:");
		lblNewLabel_1_2.setBounds(116, 254, 262, 22);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Cantidad de fondos por plan:");
		lblNewLabel_1_2_1.setBounds(127, 328, 247, 22);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1_2_1);
		
		JButton btnNewButton = new JButton("Imprimir");
		btnNewButton.setBounds(401, 188, 109, 23);
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Altice.getInstance().getVentas();
				List<Venta> misVentas = Altice.getInstance().getVentas();
				System.out.println("misVentas"+ misVentas.size());
				
				List<Plan> listaPlanes= new ArrayList<Plan>();
				
				for(Venta venta : misVentas) {
					
					List<Plan> planesVenta = venta.getPlanes();
					
					for(Plan plan : planesVenta) {

						if(listaPlanes.isEmpty()) {
							plan.setCantidad(1);
							listaPlanes.add(plan);
						}
						else {
							List<Plan> listPlanAux = new ArrayList<Plan>();
							for(Plan planDB : listaPlanes) {
								
								boolean existe = false;
								
								if(plan.getCodigo().equals(planDB.getCodigo())) {
									existe =true;
									planDB.setCantidad(plan.getCantidad()+1);
								}
								
								if(!existe) {
									plan.setCantidad(1);
									listPlanAux.add(plan);
								}

								
								
							}
							for(Plan plan2 : listPlanAux) {
								listaPlanes.add(plan2);
							}
							
						}
						
						
					}
					
					
				}
				
				String planes ="";
				for(Plan plan : listaPlanes) {
					planes += "Plan : " + plan.getNombrePlan() + ", Cantidad: "+ plan.getCantidad() + "\n";
				}
				
				JOptionPane.showMessageDialog(null, planes );
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Imprimir");
		btnNewButton_2.setBounds(401, 255, 109, 23);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Imprimir");
		btnNewButton_3.setBounds(401, 329, 109, 23);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 658, 88);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Revision");
		lblNewLabel_1.setBounds(10, 24, 175, 53);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 30));
	}
}
