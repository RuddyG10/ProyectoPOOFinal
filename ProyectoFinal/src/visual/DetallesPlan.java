package visual;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DetallesPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtTotal;
	private JTable table;

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
		setBounds(100, 100, 678, 609);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlLtHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.activeCaptionText);
			panel.setBounds(0, 0, 662, 75);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("  Detalles del plan");
				lblNewLabel.setIcon(new ImageIcon(DetallesPlan.class.getResource("/imagenes/detalles icono.png")));
				lblNewLabel.setForeground(SystemColor.text);
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
				lblNewLabel.setBounds(26, 11, 352, 53);
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlLtHighlight);
			panel.setBorder(new TitledBorder(null, "Informacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 91, 642, 131);
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
				JLabel lblNewLabel_3 = new JLabel("Descripcion:");
				lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setBounds(4, 79, 112, 25);
				panel.add(lblNewLabel_3);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setBounds(115, 28, 199, 25);
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setEditable(false);
				txtNombre.setBounds(433, 28, 199, 25);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtDescripcion = new JTextField();
				txtDescripcion.setEditable(false);
				txtDescripcion.setBounds(115, 72, 517, 48);
				panel.add(txtDescripcion);
				txtDescripcion.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlLtHighlight);
			panel.setBorder(new TitledBorder(null, "Servicios incluidos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 230, 642, 219);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			table.setBackground(SystemColor.info);
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Servicios", "Cantidad", "Subtotal"
				}
			));
			scrollPane.setViewportView(table);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlLtHighlight);
			panel.setBounds(10, 457, 642, 60);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				txtTotal = new JTextField();
				txtTotal.setEditable(false);
				txtTotal.setBounds(366, 14, 276, 27);
				panel.add(txtTotal);
				txtTotal.setColumns(10);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("RD$");
				lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 16));
				lblNewLabel_5.setBounds(302, 12, 54, 30);
				panel.add(lblNewLabel_5);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Precio total:");
				lblNewLabel_4.setBounds(205, 8, 171, 38);
				panel.add(lblNewLabel_4);
				lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
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
				btnSalir.setIcon(new ImageIcon(DetallesPlan.class.getResource("/imagenes/icono cancelar.png")));
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
	}
}
