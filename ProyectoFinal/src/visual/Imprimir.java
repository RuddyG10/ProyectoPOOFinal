package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Administrador;
import logico.Altice;
import logico.Cliente;
import logico.Comercial;
import logico.Plan;
import logico.Trabajador;
import logico.Venta;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Imprimir extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cbxInfo;
	private JButton btnImprimir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Imprimir dialog = new Imprimir();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Imprimir() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Imprimir.class.getResource("/imagenes/logo altice pf.PNG")));
		setModal(true);
		setResizable(false);
		setTitle("Altice - Imprimir");
		setBounds(100, 100, 447, 346);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 441, 88);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Imprimir Informacion");
		lblNewLabel.setIcon(new ImageIcon(Imprimir.class.getResource("/imagenes/icons8-send-to-printer-60.png")));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 421, 66);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Elija lo que desea imprimir", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_1.setBounds(10, 99, 421, 169);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnImprimir.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) {
			btnImprimir.setBackground(UIManager.getColor("control"));
			}
			
		});
		btnImprimir.setIcon(new ImageIcon(Imprimir.class.getResource("/imagenes/icono imprimir.png")));
		btnImprimir.setFont(new Font("Arial", Font.PLAIN, 15));
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				if(cbxInfo.getSelectedIndex() != 0) {
					
					ArrayList<Plan> planesReg = Altice.getInstance().getmisPlanes();
					ArrayList<Venta> ventas = Altice.getInstance().getVentas();
					ArrayList<Cliente> clientes = Altice.getInstance().getMisClientes();
					ArrayList<Date> fechas = Altice.getInstance().getFechasGanancias();
					ArrayList<Trabajador> trabajadores = Altice.getInstance().getMisTrabajadores();
					File infoFile = null;
					PrintWriter facWrite= null;
					if(cbxInfo.getSelectedIndex() == 1) {
						infoFile = new File("Info-Planes-File-#"+Altice.genCodeFile+".txt");
						try {
							facWrite = new PrintWriter(infoFile);
							facWrite.println("===================================================");
							facWrite.println("Fecha de impresion: "+format.format(new Date()));
							facWrite.println("===================================================");
							facWrite.println("Planes registrados:");
							
							if(planesReg != null) {
								for (Plan plan : planesReg) {
									facWrite.println();
									facWrite.println("Codigo: "+plan.getCodigo());
									facWrite.println("Nombre: "+plan.getNombrePlan());
									facWrite.println("Precio: "+plan.getTotalPrecio());
									
									int cantVent = 0;
									if(ventas!= null) {
										for (Venta venta : ventas) {
											cantVent+= Altice.getInstance().cantidadPlanVendido(venta.getPlanes(), plan);
										}
									}
									facWrite.println("Cant. Ventas: "+cantVent);
									facWrite.println("Total generado: "+ cantVent*plan.getTotalPrecio());
								}
								facWrite.println("===================================================");
								facWrite.println("Plan mas vendido:");
								facWrite.println();
								Plan planMasVendido = Altice.getInstance().planMasVendido();
								if(planMasVendido != null) {
									
									facWrite.println("Codigo: "+planMasVendido.getCodigo());
									facWrite.println("Nombre: "+planMasVendido.getNombrePlan());
									facWrite.println("Precio: "+planMasVendido.getTotalPrecio());
									int cantVent = 0;
									for (Venta venta : ventas) {
										
										cantVent+= Altice.getInstance().cantidadPlanVendido(venta.getPlanes(), planMasVendido);
									}
									facWrite.println("Cant. Ventas: "+cantVent);
									facWrite.println("Total generado: "+ cantVent*planMasVendido.getTotalPrecio());
								}
								else {
									facWrite.println("No hay planes vendidos.");
								}
								facWrite.println();
							}
							else {
								facWrite.println("No hay planes registrados.");
							}
							facWrite.println("===================================================");
							facWrite.close();
							Altice.getInstance().genCodeFile++;
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(cbxInfo.getSelectedIndex() == 2) {
						infoFile = new File("Info-Clientes-File-#"+Altice.genCodeFile+".txt");
						try {
							facWrite = new PrintWriter(infoFile);
							facWrite.println("Informacion sobre CLientes");
							facWrite.println("===================================================");
							facWrite.println("Fecha: "+format.format(new Date()));
							facWrite.println("===================================================");
							facWrite.println("Clientes:");
							
							if(clientes != null) {
								int cantDeud = 0;
								for (Cliente cliente : clientes) {
									facWrite.println();
									facWrite.println("Cedula: "+cliente.getCedula());
									facWrite.println("Nombre: "+cliente.getNombre());
									facWrite.println("Telefono: "+cliente.getTelefono());
									facWrite.println("Direccion: "+ cliente.getDireccion());
									facWrite.println("Cantidad de planes comprados: "+cliente.getPlanes().size());
									if(Altice.getInstance().planesHabilitados(cliente)) {
										facWrite.println("Estado del cliente: Sin deudas.");
									}
									else {
										facWrite.println("Estado del cliente: Con deudas");
										cantDeud++;
									}
								}
								facWrite.println("===================================================");
								facWrite.println("Cantidad de clientes endeudados: "+ cantDeud);
							}
							else {
								facWrite.println("No hay clientes registrados");
							}
							facWrite.println("===================================================");
							facWrite.close();
							Altice.genCodeFile++;
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(cbxInfo.getSelectedIndex() == 3) {
						infoFile = new File("Info-Ingresos-File-#"+Altice.genCodeFile+".txt");
						try {
							facWrite = new PrintWriter(infoFile);
							facWrite.println("Informacion de ingresos generados.");
							facWrite.println("===================================================");
							facWrite.println("Fecha: "+format.format(new Date()));
							facWrite.println("===================================================");
							facWrite.println("Ingresos: ");
							if(fechas!= null) {
								for (int i = 0; i < fechas.size(); i++) {
									facWrite.println();
									facWrite.println("Fecha: "+format.format(fechas.get(i)));
									facWrite.println("Ingresos estimados: "+Altice.getInstance().getIngresoE().get(i));
									facWrite.println("Ingresos Reales: "+Altice.getInstance().getIngresoR().get(i));
								}
							}
							else {
								facWrite.println("No se han registrado ingresos.");	
							}
							facWrite.println("===================================================");
							facWrite.close();
							Altice.genCodeFile++;
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					if(cbxInfo.getSelectedIndex() == 4) {
						infoFile = new File("Info-Trabajadores-File-#"+Altice.genCodeFile+".txt");
						try {
							facWrite = new PrintWriter(infoFile);
							facWrite.println("Informacion de los Trabajadores.");
							facWrite.println("===================================================");
							facWrite.println("Fecha: "+format.format(new Date()));
							facWrite.println("===================================================");
							facWrite.println("Administradores:");
							for (Trabajador trabajador : trabajadores) {
								if(!trabajador.getNombre().equalsIgnoreCase("admin")) {
									if(trabajador instanceof Administrador) {
										facWrite.println();
										facWrite.println("Nombre: "+trabajador.getNombre());
										facWrite.println("Apellidos: "+trabajador.getApellidos());
									}
								}
								
							}
							facWrite.println("===================================================");
							facWrite.println("Comerciales:");
							for (Trabajador trabajador : trabajadores) {
								if(!trabajador.getNombre().equalsIgnoreCase("admin")) {
									if(trabajador instanceof Comercial) {
										facWrite.println();
										facWrite.println("Nombre: "+trabajador.getNombre());
										facWrite.println("Apellidos: "+trabajador.getApellidos());
										facWrite.println("Cantidad de ventas: "+((Comercial) trabajador).getMisVentas().size());
									}
								}
							}
							facWrite.println("===================================================");
							facWrite.println("Mejor comercial:");
							Trabajador mejorCom = Altice.getInstance().mejorComercial();
							if(mejorCom != null) {
								facWrite.println();
								facWrite.println("Nombre: "+mejorCom.getNombre());
								facWrite.println("Apellido: "+mejorCom.getApellidos());
								facWrite.print("Cantidad de ventas: "+((Comercial) mejorCom).getMisVentas().size());
								facWrite.println();
							}
							else {
								facWrite.println("No hay mejor comercial.");
							}
							facWrite.println("===================================================");
							facWrite.close();
							Altice.genCodeFile++;
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					JOptionPane.showMessageDialog(null, "Se ha impreso los datos: "+infoFile+" Refresque para verlo.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un campo.", "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		btnImprimir.setBounds(275, 73, 115, 27);
		panel_1.add(btnImprimir);
		
		cbxInfo = new JComboBox();
		cbxInfo.setForeground(SystemColor.textInactiveText);
		cbxInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		cbxInfo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Revision de planes", "Revision de Clientes", "Revision de Ingresos", "Trabajadores "}));
		cbxInfo.setBounds(29, 76, 217, 20);
		panel_1.add(cbxInfo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.window);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnCancelar.setBackground(Color.red);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnCancelar.setBackground(UIManager.getColor("control"));
					}
				});
				btnCancelar.setSize(119, 23);
				btnCancelar.setFont(new Font("Arial", Font.PLAIN, 15));
				btnCancelar.setIcon(new ImageIcon(Imprimir.class.getResource("/imagenes/icono cancelar.png")));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
