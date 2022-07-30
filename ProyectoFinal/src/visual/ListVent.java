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

public class ListVent extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private String[] headers = {"Codigo","Cant. Planes","Total","Fecha"};
	private DefaultTableModel model;
	private Object[] row;
	private JButton btnCerrar;
	private Factura selected;
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
		setResizable(false);
		setModal(true);
		setTitle("Lista De Ventas");
		setBounds(100, 100, 519, 348);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 513, 48);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Ventas");
		lblNewLabel.setIcon(new ImageIcon(ListVent.class.getResource("/imagenes/icons8-money-30.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 201, 26);
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
				selected = Altice.getInstance().buscarFacturaByCode(codigo);
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
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnVer = new JButton("Ver venta");
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
				btnCerrar = new JButton("Cerrar");
				btnCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
		load();
	}

	public void load() {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		ArrayList<Factura> facturas = Altice.getInstance().getFacturas();
		for (Factura factura : facturas) {
			row[0] = factura.getCodigo();
			row[1] = factura.getVenta().getPlanes().size();
			row[2] = factura.getTotal();
			row[3] = formater.format(factura.getFecha());
			
		}
		
	}
}
