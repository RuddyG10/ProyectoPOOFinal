package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Altice;
import logico.Factura;
import logico.Plan;
import logico.Venta;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ListVent extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private String[] headers = {"Codigo","Cant. Planes","Total","Fecha"};
	private DefaultTableModel model;
	private Object[] row;
	private JButton btnAtras;
	private Venta selected = null;
	private JButton btnVer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListVent dialog = new ListVent();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListVent() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListVent.class.getResource("/imagenes/logo altice pf.PNG")));
		setResizable(false);
		setModal(true);
		setTitle("Altice - Lista de ventas");
		setBounds(100, 100, 519, 364);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 513, 48);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Lista de ventas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(ListVent.class.getResource("/imagenes/icons8-money-30.png")));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 493, 26);
		panel.add(lblNewLabel);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTabla.setBounds(10, 59, 493, 211);
		contentPanel.add(panelTabla);
		panelTabla.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTabla.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				String codigo = table.getValueAt(index, 0).toString();
				selected = Altice.getInstance().buscarFacturaByVenta(codigo);
				btnVer.setEnabled(true);
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.window);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnVer = new JButton("Ver venta");
				btnVer.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
					btnVer.setBackground(Color.blue);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnVer.setBackground(UIManager.getColor("control"));
					}
				});
				btnVer.setFont(new Font("Arial", Font.PLAIN, 15));
				btnVer.setIcon(new ImageIcon(ListVent.class.getResource("/imagenes/ver icono.png")));
				btnVer.setEnabled(false);
				btnVer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(selected != null) {
							VerFactura ver = new VerFactura(selected);
							ver.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Factura no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
							
						}
						btnVer.setEnabled(false);
					}
				});
				btnVer.setActionCommand("OK");
				buttonPane.add(btnVer);
				getRootPane().setDefaultButton(btnVer);
			}
			{
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
				btnAtras.setFont(new Font("Arial", Font.PLAIN, 15));
				btnAtras.setIcon(new ImageIcon(ListVent.class.getResource("/imagenes/logo siguiente.png")));
				btnAtras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnAtras.setActionCommand("Cancel");
				buttonPane.add(btnAtras);
			}
		}
		load();
	}

	public void load() {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		ArrayList<Venta> ventas = Altice.getInstance().getVentas();
		ArrayList<Plan> planes = null;
		
		for (Venta vent : ventas) {
			float precioTotal = 0;
			row[0] = vent.getNumIdent();
			row[1] = vent.getPlanes().size();
			planes = vent.getPlanes();
			for (Plan plan : planes) {
				precioTotal += plan.getTotalPrecio();
			}
			row[2] = precioTotal;
			row[3] = formater.format(vent.getFecha());
			model.addRow(row);
		}
		
	}
}
