package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import logico.Cliente;
import logico.Factura;
import logico.Plan;
import logico.Trabajador;
import java.awt.Toolkit;

public class VerFacClient extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Factura factura = null;
	private JTextField txtCeduClient;
	private JTextField txtDirClient;
	private JTextField txtNomEm;
	private JTextComponent txtFecha;
	private JTextField txtNomClient;
	private JTable table;
	private DefaultTableModel model;
	private String[] headers = {"Codigo","Nombre","Fecha Emitida","Precio"};
	private JTextField txtPago;
	private Object[] row;
	private SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerFacClient dialog = new VerFacClient(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerFacClient(Factura aux) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerFacClient.class.getResource("/imagenes/logo altice pf.PNG")));
		setResizable(false);
		setModal(true);
		setTitle("Altice - Factura Cliente");
		factura = aux;
		setBounds(100, 100, 682, 463);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panelAltice = new JPanel();
		panelAltice.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAltice.setBounds(10, 11, 112, 364);
		contentPanel.add(panelAltice);
		panelAltice.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VerFactura.class.getResource("/imagenes/alticeLogo40.png")));
		lblNewLabel.setBounds(23, 11, 46, 51);
		panelAltice.add(lblNewLabel);
		
		JEditorPane dtrpnInformaciones = new JEditorPane();
		dtrpnInformaciones.setText("Informaciones");
		dtrpnInformaciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		dtrpnInformaciones.setForeground(Color.WHITE);
		dtrpnInformaciones.setBackground(Color.BLACK);
		dtrpnInformaciones.setEditable(false);
		dtrpnInformaciones.setBounds(0, 73, 112, 20);
		panelAltice.add(dtrpnInformaciones);
		
		JEditorPane dtrpnParaMasInformaciones = new JEditorPane();
		dtrpnParaMasInformaciones.setText("Para mas informaciones sobre la factura\r\ncomuniquese al: \r\n809-859-6999\r\n\r\nwww.altice.com.do\r\n\r\nSiguenos en \r\nFacebook y \r\nTwitter (altice_do)\r\nInstagram (alticedo)\r\n");
		dtrpnParaMasInformaciones.setEditable(false);
		dtrpnParaMasInformaciones.setBounds(0, 92, 112, 230);
		panelAltice.add(dtrpnParaMasInformaciones);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCliente.setBounds(132, 11, 524, 92);
		contentPanel.add(panelCliente);
		panelCliente.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Cliente:");
		lblNewLabel_1.setBounds(10, 12, 96, 14);
		panelCliente.add(lblNewLabel_1);
		
		txtNomClient = new JTextField();
		txtNomClient.setEditable(false);
		txtNomClient.setBounds(116, 9, 133, 20);
		panelCliente.add(txtNomClient);
		txtNomClient.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cedula Cliente:");
		lblNewLabel_2.setBounds(10, 38, 96, 14);
		panelCliente.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Direccion Cliente:");
		lblNewLabel_3.setBounds(10, 64, 109, 14);
		panelCliente.add(lblNewLabel_3);
		
		txtCeduClient = new JTextField();
		txtCeduClient.setEditable(false);
		txtCeduClient.setColumns(10);
		txtCeduClient.setBounds(116, 35, 133, 20);
		panelCliente.add(txtCeduClient);
		
		txtDirClient = new JTextField();
		txtDirClient.setEditable(false);
		txtDirClient.setColumns(10);
		txtDirClient.setBounds(116, 61, 133, 20);
		panelCliente.add(txtDirClient);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre Emisor:");
		lblNewLabel_4.setBounds(259, 12, 116, 14);
		panelCliente.add(lblNewLabel_4);
		
		txtNomEm = new JTextField();
		txtNomEm.setEditable(false);
		txtNomEm.setColumns(10);
		txtNomEm.setBounds(381, 9, 133, 20);
		panelCliente.add(txtNomEm);
		
		JPanel panelFechas = new JPanel();
		panelFechas.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFechas.setBounds(132, 114, 524, 43);
		contentPanel.add(panelFechas);
		panelFechas.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha de emision:");
		lblNewLabel_7.setBounds(10, 11, 109, 14);
		panelFechas.add(lblNewLabel_7);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(116, 8, 131, 20);
		panelFechas.add(txtFecha);
		
		JPanel panelCompra = new JPanel();
		panelCompra.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCompra.setBounds(132, 168, 524, 154);
		contentPanel.add(panelCompra);
		panelCompra.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelCompra.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(132, 333, 524, 42);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Pago Total:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(10, 11, 81, 14);
		panel.add(lblNewLabel_8);
		
		txtPago = new JTextField();
		txtPago.setEditable(false);
		txtPago.setBounds(101, 8, 165, 20);
		panel.add(txtPago);
		txtPago.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cerrar");
				btnCancelar.setIcon(new ImageIcon(VerFacClient.class.getResource("/imagenes/icono cancelar.png")));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		load();
	}

	public void load() {
		if(factura != null) {
			Plan plan = factura.getPlan();
			Cliente client = factura.getMiCliente();
			Trabajador vendedor = factura.getVendedor();
			model.setRowCount(0);
			row = new Object[model.getColumnCount()];
			row[0] = plan.getCodigo();
			row[1] = plan.getNombrePlan();
			row[2] = plan.getFechaPago();
			row[3] = formater.format(plan.getFechaPago());
			model.addRow(row);
			txtNomClient.setText(client.getNombre()+" "+client.getApellido());
			txtCeduClient.setText(client.getCedula());
			txtDirClient.setText(client.getDireccion());
			txtNomEm.setText(vendedor.getNombre()+" "+vendedor.getApellidos());
			txtFecha.setText(formater .format(factura.getFecha()));
			txtPago.setText(String.valueOf(factura.getTotal()));
			
		}
		
	}
}
