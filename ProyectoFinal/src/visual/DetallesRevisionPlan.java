package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;import javax.management.StringValueExp;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import logico.Plan;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DetallesRevisionPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblTitulo;
	private JTextField txtCodigo;
	private JTextField txtCantVentas;
	private JTextField txtNombre;
	private JTextField txtIngresos;
	private JTextField txtPrecio;
	private JButton btnAtras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DetallesRevisionPlan dialog = new DetallesRevisionPlan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DetallesRevisionPlan() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DetallesRevisionPlan.class.getResource("/imagenes/logo altice pf.PNG")));
		setTitle("Altice");
		setBounds(100, 100, 593, 386);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setBounds(0, 0, 577, 74);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				lblTitulo = new JLabel("");
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setFont(new Font("Arial", Font.BOLD, 25));
				lblTitulo.setBounds(10, 11, 557, 52);
				panel.add(lblTitulo);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlLtHighlight);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
			panel.setBounds(10, 85, 557, 90);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Codigo:");
				lblNewLabel.setBounds(-4, 26, 145, 21);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(278, 26, 145, 21);
				panel.add(lblNewLabel_1);
				lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Precio:");
				lblNewLabel_2.setBounds(-4, 58, 145, 21);
				panel.add(lblNewLabel_2);
				lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setBounds(107, 26, 145, 21);
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setEditable(false);
				txtNombre.setBounds(389, 26, 145, 21);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtPrecio = new JTextField();
				txtPrecio.setEditable(false);
				txtPrecio.setBounds(107, 58, 145, 21);
				panel.add(txtPrecio);
				txtPrecio.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlLtHighlight);
			panel.setBorder(new TitledBorder(null, "Ingresos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
			panel.setBounds(10, 186, 557, 90);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_3 = new JLabel("Cantidad de ventas:");
				lblNewLabel_3.setBounds(-4, 38, 145, 21);
				panel.add(lblNewLabel_3);
				lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Total ingresos:");
				lblNewLabel_4.setBounds(278, 38, 145, 21);
				panel.add(lblNewLabel_4);
				lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				txtCantVentas = new JTextField();
				txtCantVentas.setEditable(false);
				txtCantVentas.setBounds(137, 38, 145, 21);
				panel.add(txtCantVentas);
				txtCantVentas.setColumns(10);
			}
			{
				txtIngresos = new JTextField();
				txtIngresos.setEditable(false);
				txtIngresos.setBounds(402, 38, 145, 21);
				panel.add(txtIngresos);
				txtIngresos.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.window);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
				btnAtras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnAtras.setIcon(new ImageIcon(DetallesRevisionPlan.class.getResource("/imagenes/logo siguiente.png")));
				btnAtras.setFont(new Font("Arial", Font.PLAIN, 15));
				btnAtras.setActionCommand("Cancel");
				buttonPane.add(btnAtras);
			}
		}
	}
	public void cargarInfo (Plan selected, String cantVentas, String TotalVentas) {
		lblTitulo.setText("  Detalles sobre: "+selected.getNombrePlan());
		txtNombre.setText(selected.getNombrePlan());
		txtCodigo.setText(selected.getCodigo());
		txtPrecio.setText(""+selected.getTotalPrecio());
		txtCantVentas.setText(cantVentas);
		txtIngresos.setText(TotalVentas);
	}

}
