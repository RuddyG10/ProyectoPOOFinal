package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import logico.Altice;
import logico.Plan;
import logico.Servicio;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class ListadoPlanes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object row[];
	private JButton btnDetalles;
	private Plan selected = null;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JButton btnEliminar;
	private JRadioButton rdbTelefono;
	private JRadioButton rdbCable;
	private JRadioButton rdbInternet;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoPlanes dialog = new ListadoPlanes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoPlanes() {
		setResizable(false);
		setBackground(SystemColor.controlLtHighlight);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadoPlanes.class.getResource("/imagenes/logo altice pf.PNG")));
		setTitle("Altice - Listado de Planes");
		setBounds(100, 100, 688, 629);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 686, 74);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.BLACK);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Listado de planes");
		lblNewLabel.setIcon(new ImageIcon(ListadoPlanes.class.getResource("/imagenes/listado icono.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 420, 52);
		panel.add(lblNewLabel);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 266, 653, 272);
			panel_1.setBackground(SystemColor.controlLtHighlight);
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Planes con los servicios seleccionados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
			contentPanel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane = new JScrollPane();
			panel_1.add(scrollPane, BorderLayout.CENTER);

			String headers [] = {"Codigo","Nombre","Precio"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);
			table = new JTable();
			table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			table.setSelectionBackground(new Color(0, 120, 215));
			table.setSelectionForeground(new Color(0, 0, 153));

			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = table.getSelectedRow();
					if (index >= 0) {
						String codPlan = table.getValueAt(index, 0).toString();
						selected = Altice.getInstance().buscarPlanByCode(codPlan);
						btnDetalles.setEnabled(true);
						btnEliminar.setEnabled(true);
					}
				}
			});

			table.setModel(model);
			scrollPane.setViewportView(table);
		}

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Plan mejor vendido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panel_1.setBackground(SystemColor.controlLtHighlight);
		panel_1.setBounds(10, 79, 653, 98);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Codigo:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(34, 35, 86, 24);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(346, 35, 86, 24);
		panel_1.add(lblNewLabel_3);

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(125, 35, 189, 24);
		panel_1.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setEditable(false);
		txtNombre.setBounds(439, 35, 184, 24);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 0, 51));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panel_2.setBackground(SystemColor.controlLtHighlight);
		panel_2.setBounds(10, 181, 653, 74);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		rdbTelefono = new JRadioButton("Con telefono");
		rdbTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable();
			}
		});

		rdbTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		rdbTelefono.setBackground(SystemColor.controlLtHighlight);
		rdbTelefono.setFont(new Font("Arial", Font.BOLD, 15));
		rdbTelefono.setBounds(27, 29, 173, 23);
		panel_2.add(rdbTelefono);

		rdbCable = new JRadioButton("Con cable");
		rdbCable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable();
			}
		});

		rdbCable.setHorizontalAlignment(SwingConstants.CENTER);
		rdbCable.setBackground(SystemColor.controlLtHighlight);
		rdbCable.setFont(new Font("Arial", Font.BOLD, 15));
		rdbCable.setBounds(240, 29, 173, 23);
		panel_2.add(rdbCable);

		rdbInternet = new JRadioButton("Con internet");
		rdbInternet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable();
			}
		});

		rdbInternet.setHorizontalAlignment(SwingConstants.CENTER);
		rdbInternet.setBackground(SystemColor.controlLtHighlight);
		rdbInternet.setFont(new Font("Arial", Font.BOLD, 15));
		rdbInternet.setBounds(451, 29, 173, 23);
		panel_2.add(rdbInternet);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlLtHighlight);
			buttonPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			btnDetalles = new JButton("Ver detalles");
			btnDetalles.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnDetalles.setBackground(Color.blue);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnDetalles.setBackground(UIManager.getColor("control"));
				}
			});
			btnDetalles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DetallesPlan detalles = new DetallesPlan();
					detalles.cargarInfo(selected);
					detalles.setModal(true);
					detalles.setVisible(true);

				}
			});

			btnEliminar = new JButton("Eliminar plan");
			btnEliminar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnEliminar.setBackground(Color.red);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnEliminar.setBackground(UIManager.getColor("control"));
				}
			});
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int option = JOptionPane.showConfirmDialog(null, "Seguro de que desea eliminar el plan: "+selected.getCodigo() + " | "+selected.getNombrePlan(), "Confirmacion", JOptionPane.WARNING_MESSAGE);
					if (JOptionPane.YES_OPTION == option) {
						Altice.getInstance().eliminarPlan(selected);
						loadTable();
						btnDetalles.setEnabled(false);
						btnEliminar.setEnabled(false);
					}
				}
			});
			btnEliminar.setIcon(new ImageIcon(ListadoPlanes.class.getResource("/imagenes/eliminar icono.png")));
			btnEliminar.setEnabled(false);
			btnEliminar.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonPane.add(btnEliminar);
			btnDetalles.setEnabled(false);
			btnDetalles.setFont(new Font("Arial", Font.PLAIN, 15));
			btnDetalles.setIcon(new ImageIcon(ListadoPlanes.class.getResource("/imagenes/masDetalles icono.png")));
			buttonPane.add(btnDetalles);
			{
				JButton btnSalir = new JButton("Atras");
				btnSalir.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnSalir.setBackground(Color.red);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnSalir.setBackground(UIManager.getColor("control"));
					}
				});
				btnSalir.setFont(new Font("Arial", Font.PLAIN, 15));
				btnSalir.setIcon(new ImageIcon(ListadoPlanes.class.getResource("/imagenes/logo siguiente.png")));
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose ();
					}

				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
		loadTable();
	}
	private void loadTable() {
		
		if(Altice.getInstance().planMasVendido() != null) {
			txtCodigo.setText(Altice.getInstance().planMasVendido().getCodigo());
			txtNombre.setText(Altice.getInstance().planMasVendido().getNombrePlan());

		}

		
		ArrayList<Plan> auxiliar = new ArrayList<>();
		int cantPlanes = Altice.getInstance().getmisPlanes().size();

		if (rdbTelefono.isSelected() | rdbCable.isSelected() | rdbInternet.isSelected()) {
			for (int i = 0; i < cantPlanes; i++) {
				Plan aux = Altice.getInstance().getmisPlanes().get(i);
				if(rdbTelefono.isSelected()&&!rdbCable.isSelected() && !rdbInternet.isSelected() &&Altice.getInstance().planTieneServicio(aux, "Telefono")) {
					auxiliar.add(aux);
				}
				if(!rdbTelefono.isSelected()&&rdbCable.isSelected() && !rdbInternet.isSelected() && Altice.getInstance().planTieneServicio(aux, "Cable")) {
					auxiliar.add(aux);
			}
				if(!rdbTelefono.isSelected()&&!rdbCable.isSelected() && rdbInternet.isSelected() && Altice.getInstance().planTieneServicio(aux, "Internet")) {
					auxiliar.add(aux);
				}
				//dose selected
				if(rdbCable.isSelected()&&rdbInternet.isSelected() && !rdbTelefono.isSelected() &&Altice.getInstance().planTieneServicio(aux, "Cable") && Altice.getInstance().planTieneServicio(aux, "Internet")) {
					auxiliar.add(aux);
				}
				if(rdbCable.isSelected()&&!rdbInternet.isSelected() && rdbTelefono.isSelected() && Altice.getInstance().planTieneServicio(aux, "Cable") && Altice.getInstance().planTieneServicio(aux, "Telefono")) {
					auxiliar.add(aux);
				}
				if(!rdbCable.isSelected()&&rdbInternet.isSelected() && rdbTelefono.isSelected() && Altice.getInstance().planTieneServicio(aux, "Telefono") && Altice.getInstance().planTieneServicio(aux, "Internet")) {
					auxiliar.add(aux);
				}
				//tres selected
				if(rdbCable.isSelected()&&rdbInternet.isSelected() && rdbTelefono.isSelected() && Altice.getInstance().planTieneServicio(aux, "Telefono") && Altice.getInstance().planTieneServicio(aux, "Internet") && Altice.getInstance().planTieneServicio(aux, "Cable")) {
					auxiliar.add(aux);
				}
			}
		}
		else {
			auxiliar = Altice.getInstance().getmisPlanes();
		}	
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i < auxiliar.size(); i++) {
			
			row[0] = auxiliar.get(i).getCodigo();
			row[1] = auxiliar.get(i).getNombrePlan();
			row[2] = auxiliar.get(i).getTotalPrecio();
			
			model.addRow(row);

		}
	}
}
