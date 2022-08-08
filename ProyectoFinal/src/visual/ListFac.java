package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Altice;
import logico.Cliente;
import logico.Factura;
import logico.Plan;
import logico.Venta;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class ListFac extends JDialog {
	private JTable table;
	private Factura selected = null;
	private String[] headers = {"Codigo","Plan","Total","Fecha corte","Estado Plan"};
	private JButton btnVerFac;
	private DefaultTableModel model;
	private Object[] row;
	private Cliente client = null;
	private JButton btnCerrar;
	private JButton btnPagar;
	private boolean pagar = false;
	private JLabel lblListaFactura;
	private SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListFac dialog = new ListFac(null,false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListFac(Cliente aux,boolean auxpagar) {
		getContentPane().setBackground(SystemColor.window);
		setTitle("Altice - Lista Factura");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListFac.class.getResource("/imagenes/logo altice pf.PNG")));
		client = aux;
		pagar =auxpagar;
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 572, 417);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.window);
			buttonPane.setBounds(10, 339, 533, 38);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				btnVerFac = new JButton("Ver Factura");
				btnVerFac.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						VerFacClient verFac = new VerFacClient(selected);
						verFac.setVisible(true);
						btnPagar.setEnabled(false);
						btnVerFac.setEnabled(false);
					}
				});
				{
					btnPagar = new JButton("Pagar Factura");
					btnPagar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int option = JOptionPane.showConfirmDialog(null, "Seguro que desea pagar la factura "+selected.getCodigo()+"?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
							if(option==0) {
								if(!selected.isPagada()) {
									selected.setPagada(true);
									Cliente auxClient = selected.getMiCliente();
									Altice.getInstance().revisarFacturasClient(auxClient);
									JOptionPane.showMessageDialog(null, "Plan pagado con exito.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
									load();
								}else {
									JOptionPane.showMessageDialog(null, "Esta factura esta al dia.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								}
								
							}
							btnPagar.setEnabled(false);
							btnVerFac.setEnabled(false);
						}
					});
					btnPagar.setVisible(false);
					btnPagar.setEnabled(false);
					buttonPane.add(btnPagar);
				}
				btnVerFac.setEnabled(false);
				btnVerFac.setActionCommand("OK");
				buttonPane.add(btnVerFac);
				getRootPane().setDefaultButton(btnVerFac);
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
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setBounds(0, 0, 566, 64);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				lblListaFactura = new JLabel("Lista Factura");
				lblListaFactura.setIcon(new ImageIcon(ListFac.class.getResource("/imagenes/detalles icono.png")));
				lblListaFactura.setBounds(10, 11, 497, 45);
				lblListaFactura.setForeground(Color.WHITE);
				lblListaFactura.setFont(new Font("Arial", Font.BOLD, 30));
				panel.add(lblListaFactura);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 67, 533, 261);
			getContentPane().add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						

						@Override
						public void mouseClicked(MouseEvent arg0) {
							int index = table.getSelectedRow();
							String codigo = table.getValueAt(index, 0).toString();
							selected = Altice.getInstance().buscarFacturaClientByCode(codigo);
							btnVerFac.setEnabled(true);
							if(btnPagar.isVisible()) {
								btnPagar.setEnabled(true);
							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
		}
		load();
	}
	public void load() {
		if(pagar) {
			btnPagar.setVisible(true);
		}
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		
		
		if(client != null) {
			ArrayList<Factura> facturas = client.getMisFacturas();
			for (Factura fac : facturas) {
				row[0] = fac.getCodigo();
				row[1] = fac.getPlan().getNombrePlan();
				row[2] = fac.getTotal();
				row[3] = formater.format(fac.getFecha());
				if(!fac.isPagada()) {
					row[4] = "Sin Pagar";
				}
				else {
					row[4] = "Pagada";
				}
				model.addRow(row);
			}
		}
		
	}
}
