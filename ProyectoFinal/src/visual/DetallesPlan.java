package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import logico.Cable;
import logico.Internet;
import logico.Plan;
import logico.Servicio;
import logico.Telefono;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DetallesPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtEstado;
	private JTable table;
	private JTextField txtDescripcion;
	private JTextField txtPrecioTotal;
	private DefaultTableModel model;
	private Object [] row;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DetallesPlan dialog = new DetallesPlan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DetallesPlan() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DetallesPlan.class.getResource("/imagenes/logo altice pf.PNG")));
		setTitle("Altice");
		setBounds(100, 100, 678, 620);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlLtHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.activeCaptionText);
			panel.setBounds(0, 7, 672, 75);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("  Detalles del plan");
				lblNewLabel.setIcon(new ImageIcon(DetallesPlan.class.getResource("/imagenes/detalles icono.png")));
				lblNewLabel.setForeground(SystemColor.text);
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
				lblNewLabel.setBounds(27, 11, 352, 53);
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlLtHighlight);
			panel.setBorder(new TitledBorder(null, "Informacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 89, 642, 114);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("Codigo:");
				lblNewLabel_1.setBackground(SystemColor.controlLtHighlight);
				lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(4, 27, 112, 25);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Nombre:");
				lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2.setBounds(323, 27, 112, 25);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Estado:");
				lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setBounds(4, 79, 112, 25);
				panel.add(lblNewLabel_3);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setBounds(115, 27, 199, 25);
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setEditable(false);
				txtNombre.setBounds(433, 27, 199, 25);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtEstado = new JTextField();
				txtEstado.setEditable(false);
				txtEstado.setBounds(115, 80, 199, 25);
				panel.add(txtEstado);
				txtEstado.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlLtHighlight);
			panel.setBorder(new TitledBorder(null, "Servicios incluidos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 210, 642, 219);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setLocation(16, 16);
			panel.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			model = new DefaultTableModel();
			String [] headers = {"Servicios","Cantidad","Subtotal"};
			model.setColumnIdentifiers(headers);
			table.setModel(model);
			scrollPane.setViewportView(table);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBackground(SystemColor.controlLtHighlight);
			panel.setBounds(10, 436, 642, 96);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_4 = new JLabel("Descripcion:");
				lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setBounds(10, 19, 112, 25);
				panel.add(lblNewLabel_4);
			}
			{
				txtDescripcion = new JTextField();
				txtDescripcion.setEditable(false);
				txtDescripcion.setBounds(118, 12, 514, 38);
				panel.add(txtDescripcion);
				txtDescripcion.setColumns(10);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Precio total:");
				lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setBounds(10, 60, 112, 25);
				panel.add(lblNewLabel_5);
			}
			{
				txtPrecioTotal = new JTextField();
				txtPrecioTotal.setEditable(false);
				txtPrecioTotal.setBounds(118, 62, 514, 20);
				panel.add(txtPrecioTotal);
				txtPrecioTotal.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlLtHighlight);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSalir = new JButton("Salir");
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
	
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					btnModificar = new JButton("Modificar");
					btnModificar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							btnModificar.setBackground(Color.blue);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							btnModificar.setBackground(UIManager.getColor("control"));
						}
					});
					btnModificar.setFont(new Font("Arial", Font.PLAIN, 15));
					btnModificar.setIcon(new ImageIcon(DetallesPlan.class.getResource("/imagenes/icono editar.png")));
					buttonPane.add(btnModificar);
				}
				btnSalir.setIcon(new ImageIcon(DetallesPlan.class.getResource("/imagenes/icono cancelar.png")));
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
	}

	public void cargarInfo(Plan selected) {
		txtCodigo.setText(selected.getCodigo());
		txtNombre.setText(selected.getNombrePlan());
		txtEstado.setText(selected.getEstado());
		txtDescripcion.setText(selected.getDescripcion());
		txtPrecioTotal.setText(""+selected.getTotalPrecio());
		
		model.setRowCount(0);
		row= new Object[model.getColumnCount()];
		for (int i = 0; i < selected.getServicios().size(); i++) {
			Servicio aux = selected.getServicios().get(i);
			row[0]= aux.getNombre();
			if (aux instanceof Telefono) {
				row[1]= ((Telefono) aux).getCantMinutos();
			}
			if (aux instanceof Cable) {
				row[1]= ((Cable) aux).getCantCanales();
			}
			if(aux instanceof Internet) {
				row[1]= "Subida: "+((Internet) aux).getCantMegasSubida()+" Bajada: "+ ((Internet) aux).getCantMegasBajada() ;
			}
			row[2]= aux.getPrecio();
			model.addRow(row);
		}
		
		
	}
}
