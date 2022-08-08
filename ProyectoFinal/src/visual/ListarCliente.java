package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.table.DefaultTableModel;

import logico.Altice;
import logico.Cliente;
import logico.Factura;
import logico.Plan;
import logico.Trabajador;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class ListarCliente extends JDialog {

	private JPanel contentPane;

	private JTable table;
	private DefaultTableModel model;
	private String[] headers = {"Cedula","Nombre","Apellido","Telefono","Cant. planes"};
	private Object[] row;
	private Cliente selected;
	private JButton btnVerFac;
	private JButton btnMod;
	private JButton btnFac;
	private boolean facturar = false;
	private JButton btnAtras;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarCliente frame = new ListarCliente(false);
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
	public ListarCliente(boolean pagar) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarCliente.class.getResource("/imagenes/logo altice pf.PNG")));
		facturar = pagar;
		setResizable(false);
		setTitle("Altice - Listado de clientes");
		setBounds(100, 100, 769, 486);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 382, 729, 64);
		contentPane.add(panel);
		panel.setLayout(null);

		btnMod = new JButton("Modificar");
		btnMod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMod.setBackground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMod.setBackground(UIManager.getColor("control"));
			}
		});
		btnMod.setIcon(new ImageIcon(ListarCliente.class.getResource("/imagenes/icono editar.png")));
		btnMod.setFont(new Font("Arial", Font.PLAIN, 15));
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificar aux = new Modificar();
				aux.cargarInfo(null, selected);
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		btnMod.setEnabled(false);
		btnMod.setBounds(380, 11, 161, 30);
		panel.add(btnMod);
		
		btnAtras = new JButton("Atras");
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
		btnAtras.setIcon(new ImageIcon(ListarCliente.class.getResource("/imagenes/icono cancelar.png")));
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAtras.setBounds(558, 11, 161, 30);
		panel.add(btnAtras);
		
		btnVerFac = new JButton("Ver Facturas");
		btnVerFac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVerFac.setBackground(Color.orange);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnVerFac.setBackground(UIManager.getColor("control"));
			}
		});
		btnVerFac.setIcon(new ImageIcon(ListarCliente.class.getResource("/imagenes/masDetalles icono.png")));
		btnVerFac.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVerFac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListFac facturas = new ListFac(selected,false);
				facturas.setVisible(true);
				btnMod.setEnabled(false);
				btnVerFac.setEnabled(false);
				obtenerClientes();
			}
		});
		btnVerFac.setEnabled(false);
		btnVerFac.setBounds(202, 11, 161, 30);
		panel.add(btnVerFac);
		
		btnFac = new JButton("Facturar");
		btnFac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFac.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFac.setBackground(UIManager.getColor("control"));
			}
		});
		btnFac.setIcon(new ImageIcon(ListarCliente.class.getResource("/imagenes/icono check.png")));
		btnFac.setFont(new Font("Arial", Font.PLAIN, 15));
		btnFac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Cliente> clientes = Altice.getInstance().getMisClientes();
				if(clientes != null) {
					for (Cliente cliente : clientes) {
						ArrayList<Plan> planes = cliente.getPlanes();
						System.out.println(cliente.getCedula()+planes.size());
							for (Plan plan : planes) {
								Factura fac = Altice.getInstance().buscarFacPorClientPlan(plan,cliente);
								if(fac!=null) {
									
									Factura auxFac = new Factura("F-"+Altice.genCodeFac, cliente, plan, fac.getVendedor(), Altice.getInstance().calcularFechaCorte(new Date()), fac.getTotal());
									cliente.getMisFacturas().add(auxFac);
									Altice.getInstance().insertarFactura(auxFac);
									}
								else {
									System.out.println(plan.getCodigo());
								}
							}
							Altice.getInstance().revisarFacturasClient(cliente);
							
					}
					JOptionPane.showMessageDialog(null, "Facturas ralizadas.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					obtenerClientes();
					
				}else {
					JOptionPane.showMessageDialog(null, "Error: No hay clientes registrados.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnFac.setVisible(false);
		btnFac.setBounds(24, 11, 161, 30);
		panel.add(btnFac);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBounds(10, 164, 729, 207);
		contentPane.add(panelTabla);
		panelTabla.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTabla.add(scrollPane, BorderLayout.CENTER);
		
		table = new ColorCell();
		table.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				selected = Altice.getInstance().buscarClientePorCedula(table.getValueAt(index, 0).toString());
				if(selected != null) {
					btnMod.setEnabled(true);
					btnVerFac.setEnabled(true);
					
				}
				else {
					btnMod.setEnabled(false);
					btnVerFac.setEnabled(false);
				}
			}
		});
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 749, 72);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel(" Listado de  clientes");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(ListarCliente.class.getResource("/imagenes/detalles icono.png")));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_2.setBounds(10, 11, 729, 50);
		panel_1.add(lblNewLabel_2);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(SystemColor.window);
		panelInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Leyenda de colores sobre los clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panelInfo.setName("");
		panelInfo.setBounds(10, 83, 729, 70);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pagos al dia");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setIcon(new ImageIcon(ListarCliente.class.getResource("/imagenes/icons8-green-circle-48.png")));
		lblNewLabel.setBounds(27, 17, 151, 40);
		panelInfo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Debe 1 o mas facturas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setIcon(new ImageIcon(ListarCliente.class.getResource("/imagenes/icons8-yellow-circle-48.png")));
		lblNewLabel_1.setBounds(205, 17, 227, 40);
		panelInfo.add(lblNewLabel_1);
		
		JLabel lblEndeudado = new JLabel("Debe 3 o mas facturas");
		lblEndeudado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndeudado.setIcon(new ImageIcon(ListarCliente.class.getResource("/imagenes/icons8-red-circle-48.png")));
		lblEndeudado.setFont(new Font("Arial", Font.BOLD, 15));
		lblEndeudado.setBounds(459, 17, 243, 40);
		panelInfo.add(lblEndeudado);
		obtenerClientes();
	}

	public void obtenerClientes() {
		if(facturar) {
			btnFac.setVisible(true);
		}
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		if(Altice.getInstance().getMisClientes() != null) {
			ArrayList<Cliente> clientes = Altice.getInstance().getMisClientes();
			for (Cliente client : clientes) {
				row[0] = client.getCedula();
				row[1] = client.getNombre();
				row[2] = client.getApellido();
				row[3] = client.getTelefono();
				row[4] = client.getPlanes().size();
				model.addRow(row);
				
			}
		}
	}
}
