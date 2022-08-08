package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Altice;
import logico.Cliente;
import logico.Factura;
import logico.Internet;
import logico.Plan;
import logico.Servicio;
import logico.Trabajador;
import logico.Venta;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.peer.PanelPeer;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Facturacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JRadioButton rdbtnInternet;
	private JRadioButton rdbtnCable;
	private JRadioButton rdbtnTelefono;
	private JTextField txtSubtotal;
	private Dimension dim;
	private JButton btnVenta;
	private JButton btnCancelar;
	private JButton btnAddCarrito;
	private JButton btnRemove;
	private JList listPlan;
	private JList listCarrito;
	private DefaultListModel modelVenta;
	private DefaultListModel modelCarrito;
	private JScrollPane scrollVenta;
	private JScrollPane scrollCarrito;
	private Trabajador comercial;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturacion dialog = new Facturacion(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturacion(Trabajador aux) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Facturacion.class.getResource("/imagenes/logo altice pf.PNG")));
		comercial = aux;
		setResizable(false);
		setTitle("Altice - Facturacion");
		setModal(true);
		setBounds(100, 100, 710, 670);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 695, 62);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Realizar Venta");
		lblNewLabel.setIcon(new ImageIcon(Facturacion.class.getResource("/imagenes/FacturaGris.png")));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 292, 40);
		panel.add(lblNewLabel);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBackground(SystemColor.window);
		panelCliente.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCliente.setBounds(10, 73, 675, 183);
		contentPanel.add(panelCliente);
		panelCliente.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Escriba datos del cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 0, 317, 14);
		panelCliente.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cedula:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 33, 58, 14);
		panelCliente.add(lblNewLabel_2);
		
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
			        txtCedula.setText("");
			    }

			    if (txtCedula.getText().trim().length() == 10) {
			        e.consume();
			    }
			}
		});
		txtCedula.setBounds(88, 30, 154, 20);
		panelCliente.add(txtCedula);
		txtCedula.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtCedula.getText().isEmpty()) {
					Cliente client = Altice.getInstance().buscarClientePorCedula(txtCedula.getText());
					if(client != null) {
						txtNombre.setText(client.getNombre());
						txtApellidos.setText(client.getApellido());
						txtDireccion.setText(client.getDireccion());
						txtTelefono.setText(client.getTelefono());
					}
					else {
						JOptionPane.showMessageDialog(null, "No se ha encontrado dicho cliente.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Debe escribir la cedula del cliente que quiere buscar.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon(Facturacion.class.getResource("/imagenes/buscar1.png")));
		btnBuscar.setBounds(252, 25, 125, 29);
		panelCliente.add(btnBuscar);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(20, 83, 58, 14);
		panelCliente.add(lblNewLabel_3);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 int key = e.getKeyChar();

				    boolean mayusculas = key >= 65 && key <= 90;
				    boolean minusculas = key >= 97 && key <= 122;
				    boolean espacio = key == 32;
				            
				     if (!(minusculas || mayusculas || espacio))
				    {
				    	 JOptionPane.showMessageDialog(null, "Solo se deben ingresar caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
				    	 txtNombre.setText("");
				    	 e.consume();
				    }
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 80, 154, 20);
		panelCliente.add(txtNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellidos.setBounds(302, 83, 58, 14);
		panelCliente.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 int key = e.getKeyChar();

				    boolean mayusculas = key >= 65 && key <= 90;
				    boolean minusculas = key >= 97 && key <= 122;
				    boolean espacio = key == 32;
				            
				     if (!(minusculas || mayusculas || espacio))
				    {
				    	 JOptionPane.showMessageDialog(null, "Solo se deben ingresar caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
				    	 txtApellidos.setText("");
				    	 e.consume();
				    }
			}
		});
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(376, 80, 154, 20);
		panelCliente.add(txtApellidos);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(20, 133, 58, 14);
		panelCliente.add(lblNewLabel_4);
		
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
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(88, 130, 154, 20);
		panelCliente.add(txtTelefono);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDireccion.setBounds(302, 133, 64, 14);
		panelCliente.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(376, 130, 154, 20);
		panelCliente.add(txtDireccion);
		
		JPanel panelSeleccion = new JPanel();
		panelSeleccion.setBackground(SystemColor.window);
		panelSeleccion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSeleccion.setBounds(10, 267, 675, 81);
		contentPanel.add(panelSeleccion);
		panelSeleccion.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Seleccione tipo de plan:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 0, 317, 14);
		panelSeleccion.add(lblNewLabel_5);
		
		rdbtnInternet = new JRadioButton("Con Internet");
		rdbtnInternet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llenarList();
			}
		});
		rdbtnInternet.setBackground(SystemColor.window);
		rdbtnInternet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnInternet.setBounds(54, 38, 152, 23);
		panelSeleccion.add(rdbtnInternet);
		
		rdbtnCable = new JRadioButton("Con Television");
		rdbtnCable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarList();
				
			}
		});
		rdbtnCable.setBackground(SystemColor.window);
		rdbtnCable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnCable.setBounds(260, 39, 152, 23);
		panelSeleccion.add(rdbtnCable);
		
		rdbtnTelefono = new JRadioButton("Con Telefono");
		rdbtnTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					llenarList();
			}
		});
		rdbtnTelefono.setBackground(SystemColor.window);
		rdbtnTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnTelefono.setBounds(466, 39, 152, 23);
		panelSeleccion.add(rdbtnTelefono);
		
		JPanel panelCarrito = new JPanel();
		panelCarrito.setBackground(SystemColor.window);
		panelCarrito.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCarrito.setBounds(10, 359, 675, 210);
		contentPanel.add(panelCarrito);
		panelCarrito.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Seleccione los planes a comprar:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 0, 317, 14);
		panelCarrito.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Lista de Planes:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(70, 25, 113, 14);
		panelCarrito.add(lblNewLabel_7);
		
		listPlan = new JList();
		modelVenta = new DefaultListModel();
		listPlan.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		listCarrito = new JList();
		modelCarrito = new DefaultListModel();
		listCarrito.setBorder(new LineBorder(new Color(0, 0, 0)));
		listCarrito.setModel(modelCarrito);
		
		scrollVenta = new JScrollPane();
		scrollVenta.setViewportView(listPlan);
		listPlan.setLayoutOrientation(JList.VERTICAL);
		
		scrollCarrito = new JScrollPane();
		scrollCarrito.setViewportView(listCarrito);
		listCarrito.setLayoutOrientation(JList.VERTICAL);
		scrollVenta.setBounds(10, 50, 213, 149);
		scrollCarrito.setBounds(452, 51, 213, 148);
		panelCarrito.add(scrollVenta);
		panelCarrito.add(scrollCarrito);
		
		JLabel lblNewLabel_8 = new JLabel("Carrito de compras:\r\n");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(452, 25, 123, 14);
		panelCarrito.add(lblNewLabel_8);
		
		btnAddCarrito = new JButton("");
		btnAddCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listPlan.getSelectedValuesList().stream().forEach((data) -> {
					modelCarrito.addElement(data);
					modelVenta.removeElement(data);
				});
				totalPrecio();
			}
		});
		btnAddCarrito.setIcon(new ImageIcon(Facturacion.class.getResource("/imagenes/add_shopping_cart_FILL0_wght400_GRAD0_opsz24.png")));
		btnAddCarrito.setBounds(293, 50, 89, 45);
		panelCarrito.add(btnAddCarrito);
		
		btnRemove = new JButton("");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listCarrito.getSelectedValuesList().stream().forEach((data) -> {
					modelVenta.addElement(data);
					modelCarrito.removeElement(data);
				});
				totalPrecio();
			}
		});
		btnRemove.setIcon(new ImageIcon(Facturacion.class.getResource("/imagenes/remove_shopping_cart_FILL0_wght400_GRAD0_opsz24.png")));
		btnRemove.setBounds(293, 154, 89, 45);
		panelCarrito.add(btnRemove);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 580, 377, 40);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Sub. Total de Venta: RD$");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(10, 11, 197, 14);
		panel_1.add(lblNewLabel_9);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setEditable(false);
		txtSubtotal.setBounds(217, 10, 143, 20);
		panel_1.add(txtSubtotal);
		txtSubtotal.setColumns(10);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(SystemColor.window);
		buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buttonPane.setBounds(397, 581, 288, 39);
		contentPanel.add(buttonPane);
		
		btnVenta = new JButton("Realizar Venta");
		btnVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(activarRegistro()) {
					Cliente auxClient = Altice.getInstance().buscarClientePorCedula(txtCedula.getText());
					ArrayList<Plan> planes = getPlanesCarrito();
					System.out.println(planes.size());
					ArrayList<Plan> planesCopia = new ArrayList<Plan>();
					if(auxClient == null) {
						
						if(planes!= null) {
							auxClient = new Cliente(txtCedula.getText(), txtNombre.getText(), txtApellidos.getText(), txtTelefono.getText(), txtDireccion.getText());
							System.out.println(auxClient.getCedula());
							Altice.getInstance().insertarCliente(auxClient);
							realizarVenta(auxClient,planes);
						}
						else {
							JOptionPane.showMessageDialog(null, "No hay planes seleccionados.", "Error", JOptionPane.ERROR_MESSAGE);	
						}
					}
					else {
						if(Altice.getInstance().planesHabilitados(auxClient)) {
							for (Plan plan : planes) {
								if(auxClient.getPlanes().contains(plan)) {
									Plan cpyPlan = new Plan(plan.getCodigo()+"-"+Altice.genCodePlan, plan.getNombrePlan(), plan.getDescripcion(), plan.getServicios(), plan.getTotalPrecio());
									planesCopia.add(cpyPlan);
								}
								else {
									planesCopia.add(plan);
								}
							}
							realizarVenta(auxClient,planesCopia);
						}
						else {
							JOptionPane.showMessageDialog(null, "Al parecer el cliente tiene planes inhabilitados.", "Error", JOptionPane.ERROR_MESSAGE);
							
						}
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Faltan datos para completar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		btnVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnVenta.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnVenta.setBackground(UIManager.getColor("control"));
			}
		});
		buttonPane.add(btnVenta);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
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
		buttonPane.add(btnCancelar);
		llenarList();
		activarRegistro();
		totalPrecio();
	}

	public void totalPrecio() {
		float subTotal = 0;
		String[] codes;
		ArrayList<Plan> planes = new ArrayList<Plan>();
		for (int i = 0; i < modelCarrito.getSize(); i++) {
			codes = modelCarrito.get(i).toString().split(" ");
			planes.add(Altice.getInstance().buscarPlanByCode(codes[0]));
		}
		for (Plan plan : planes) {
			subTotal += plan.getTotalPrecio();
		}
		txtSubtotal.setText(String.valueOf(subTotal));
		
	}

	public boolean activarRegistro() {
		boolean activate = false;
		if(!txtCedula.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtApellidos.getText().isEmpty() &&
			!txtDireccion.getText().isEmpty() && !txtTelefono.getText().isEmpty() && listCarrito.getModel().getSize() > 0) {
			activate = true;
			
		}
		return activate;
	}

	public void llenarList() {
		ArrayList<Plan> planes = Altice.getInstance().getmisPlanes();
		
		modelVenta = new DefaultListModel();
		for (Plan plan : planes) {
			//ninguno selected
			if(!rdbtnCable.isSelected()&&!rdbtnInternet.isSelected() && !rdbtnTelefono.isSelected()) {
				modelVenta.addElement(plan.getCodigo() + " "+ plan.getNombrePlan()+" - $"+plan.getTotalPrecio());
			}
			//solo uno selected
			if(rdbtnCable.isSelected()&&!rdbtnInternet.isSelected() && !rdbtnTelefono.isSelected() &&Altice.getInstance().planTieneServicio(plan, "Cable")) {
				modelVenta.addElement(plan.getCodigo() + " "+ plan.getNombrePlan()+" - $"+plan.getTotalPrecio());
			}
			if(!rdbtnCable.isSelected()&&rdbtnInternet.isSelected() && !rdbtnTelefono.isSelected() && Altice.getInstance().planTieneServicio(plan, "Internet")) {
				modelVenta.addElement(plan.getCodigo() + " "+ plan.getNombrePlan()+" - $"+plan.getTotalPrecio());
			}
			if(!rdbtnCable.isSelected()&&!rdbtnInternet.isSelected() && rdbtnTelefono.isSelected() && Altice.getInstance().planTieneServicio(plan, "Telefono")) {
				modelVenta.addElement(plan.getCodigo() + " "+ plan.getNombrePlan()+" - $"+plan.getTotalPrecio());
			}
			//dose selected
			if(rdbtnCable.isSelected()&&rdbtnInternet.isSelected() && !rdbtnTelefono.isSelected() &&Altice.getInstance().planTieneServicio(plan, "Cable") && Altice.getInstance().planTieneServicio(plan, "Internet")) {
				modelVenta.addElement(plan.getCodigo() + " "+ plan.getNombrePlan()+" - $"+plan.getTotalPrecio());
			}
			if(rdbtnCable.isSelected()&&!rdbtnInternet.isSelected() && rdbtnTelefono.isSelected() && Altice.getInstance().planTieneServicio(plan, "Cable") && Altice.getInstance().planTieneServicio(plan, "Telefono")) {
				modelVenta.addElement(plan.getCodigo() + " "+ plan.getNombrePlan()+" - $"+plan.getTotalPrecio());
			}
			if(!rdbtnCable.isSelected()&&rdbtnInternet.isSelected() && rdbtnTelefono.isSelected() && Altice.getInstance().planTieneServicio(plan, "Telefono") && Altice.getInstance().planTieneServicio(plan, "Internet")) {
				modelVenta.addElement(plan.getCodigo() + " "+ plan.getNombrePlan()+" - $"+plan.getTotalPrecio());
			}
			//tres selected
			if(rdbtnCable.isSelected()&&rdbtnInternet.isSelected() && rdbtnTelefono.isSelected() && Altice.getInstance().planTieneServicio(plan, "Telefono") && Altice.getInstance().planTieneServicio(plan, "Internet") && Altice.getInstance().planTieneServicio(plan, "Cable")) {
				modelVenta.addElement(plan.getCodigo() + " "+ plan.getNombrePlan()+" - $"+plan.getTotalPrecio());
			}
			
		}
		listPlan.setModel(modelVenta);
	}
	public ArrayList<Plan> getPlanesCarrito() {
		ArrayList<Plan> aux = null;
		String[] codes;
		if(modelCarrito.getSize() > 0) {
			aux = new ArrayList<Plan>();
			for (int i = 0; i < modelCarrito.getSize(); i++) {
				codes = modelCarrito.get(i).toString().split(" ");
				aux.add(Altice.getInstance().buscarPlanByCode(codes[0]));
			}
		}
		return aux;
	}
	public void realizarVenta(Cliente auxClient,ArrayList<Plan> planes) {
		if(comercial != null) {
			Venta vent = Altice.getInstance().realizarVenta(auxClient.getCedula(), comercial.getCedula(), planes);
			if(vent!= null) {
				
				int option = JOptionPane.showConfirmDialog(null, "Venta realizada con Exito, desea ver su factura?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(option == 0) {
					auxClient.insertPlanes(planes);
					VerFactura ver = new VerFactura(vent);
					ver.setVisible(true);
				}
				clean();
				
			}
			else {
				JOptionPane.showConfirmDialog(null, "Algo salio mal con la factura.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No hay registro de comercial.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public void clean() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDireccion.setText("");
		txtSubtotal.setText("0.0");
		txtTelefono.setText("");
		rdbtnCable.setSelected(false);
		rdbtnInternet.setSelected(false);
		rdbtnTelefono.setSelected(false);
		modelCarrito.clear();
		
	}

}
