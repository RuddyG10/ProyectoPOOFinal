package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Altice;
import logico.Plan;
import logico.Venta;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RevPlanes extends JDialog {
	private JButton btnDetalles;
	private JButton btnSalir;
	private JTextField txtNombre2;
	private JTextField txtCodigo2;
	private JTextField txtNombre1;
	private JTextField txtCodigo1;
	private JTable table;
	private static DefaultTableModel model;
	private static Object row[];
	private Plan selected = null;
	private String cantVentas;
	private String TotalVentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RevPlanes dialog = new RevPlanes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RevPlanes() {
		setResizable(false);
		getContentPane().setBackground(SystemColor.window);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RevPlanes.class.getResource("/imagenes/logo altice pf.PNG")));
		setTitle("Altice");
		setBounds(100, 100, 714, 593);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setBackground(SystemColor.window);
			buttonPane.setBounds(10, 503, 680, 51);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				btnDetalles = new JButton("Ver detalles");
				btnDetalles.setEnabled(false);
				btnDetalles.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DetallesRevisionPlan aux = new DetallesRevisionPlan();
						aux.cargarInfo(selected, cantVentas, TotalVentas);
						aux.setModal(true);
						aux.setVisible(true);
					}
				});
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
				btnDetalles.setIcon(new ImageIcon(RevPlanes.class.getResource("/imagenes/masDetalles icono.png")));
				btnDetalles.setActionCommand("OK");
				buttonPane.add(btnDetalles);
				getRootPane().setDefaultButton(btnDetalles);
			}
			{
				btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
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
				btnSalir.setIcon(new ImageIcon(RevPlanes.class.getResource("/imagenes/logo siguiente.png")));
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setBounds(0, 0, 708, 76);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("  Revision de planes");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
				lblNewLabel.setBounds(36, 11, 460, 54);
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Plan mas vendido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
			panel.setBackground(SystemColor.controlLtHighlight);
			panel.setBounds(10, 87, 680, 66);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(52, 17, 97, 27);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Codigo:");
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_2.setBounds(311, 17, 97, 27);
				panel.add(lblNewLabel_2);
			}
			{
				txtNombre1 = new JTextField();
				txtNombre1.setEditable(false);
				txtNombre1.setBounds(169, 21, 142, 27);
				panel.add(txtNombre1);
				txtNombre1.setColumns(10);
			}
			{
				txtCodigo1 = new JTextField();
				txtCodigo1.setEditable(false);
				txtCodigo1.setBounds(418, 21, 142, 27);
				panel.add(txtCodigo1);
				txtCodigo1.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Plan menos vendido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
			panel.setBackground(SystemColor.controlLtHighlight);
			panel.setBounds(10, 164, 680, 66);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_3 = new JLabel("Nombre:");
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_3.setBounds(52, 20, 97, 27);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Codigo:");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_4.setBounds(311, 20, 97, 27);
				panel.add(lblNewLabel_4);
			}
			{
				txtNombre2 = new JTextField();
				txtNombre2.setEditable(false);
				txtNombre2.setBounds(169, 21, 142, 27);
				panel.add(txtNombre2);
				txtNombre2.setColumns(10);
			}
			{
				txtCodigo2 = new JTextField();
				txtCodigo2.setEditable(false);
				txtCodigo2.setBounds(418, 21, 142, 27);
				panel.add(txtCodigo2);
				txtCodigo2.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 240, 680, 252);
			getContentPane().add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane, BorderLayout.CENTER);
			String headers[] = {"Codigo", "Nombre","Precio","Cantidad ventas","Total"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = table.getSelectedRow();
					if(index >=0) {
						String codPlan = table.getValueAt(index, 0).toString();
						cantVentas= table.getValueAt(index, 3).toString();
						TotalVentas = table.getValueAt(index, 4).toString();
						selected = Altice.getInstance().buscarPlanByCode(codPlan);
						btnDetalles.setEnabled(true);
					}
				}
			});
			table.setModel(model);
			scrollPane.setViewportView(table);
		}
		loadInfo();
	}

	private void loadInfo() {
		
		Plan masVendido = Altice.getInstance().planMasVendido();
		Plan menosVendido = Altice.getInstance().planMenosVendido();
		if (masVendido != null) {
			txtNombre1.setText(masVendido.getNombrePlan());
			txtCodigo1.setText(masVendido.getCodigo());
		}
		if (menosVendido != null) {
			txtNombre2.setText(menosVendido.getNombrePlan());
			txtCodigo2.setText(menosVendido.getCodigo());
		}
		ArrayList<Plan> auxiliar = Altice.getInstance().getmisPlanes();
		int cantidad= 0;
		float total = 0f;
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i < auxiliar.size(); i++) {
			
			row[0] = auxiliar.get(i).getCodigo();
			row[1] = auxiliar.get(i).getNombrePlan();
			row[2] = auxiliar.get(i).getTotalPrecio();
			for(Venta vent: Altice.getInstance().getVentas()) {
				ArrayList <Plan> planesVendidos = vent.getPlanes();
				cantidad += Altice.getInstance().cantidadPlanVendido(planesVendidos, auxiliar.get(i));
			}
			total = auxiliar.get(i).getTotalPrecio()*cantidad;
			row[3]= cantidad;
			row[4]= total;
			model.addRow(row);
			}
	}
}
