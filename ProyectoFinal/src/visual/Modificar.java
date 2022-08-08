package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import logico.Altice;
import logico.Cliente;
import logico.Plan;

import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Modificar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel_Plan;
	private JTextField txtCodigoPlan;
	private JTextField txtEstadoPlan;
	private JTextField txtNombrePlan;
	private JTextField txtDescripcionPlan;
	private JTextField txtPrecioPlan;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JTextField txtCedulaCliente;
	private JTextField txtNombreCliente;
	private JTextField txtApellidosCliente;
	private JTextField txtDireccionCliente;
	private JTextField txtTelefonoCliente;
	private JPanel panel_Cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Modificar dialog = new Modificar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Modificar() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modificar.class.getResource("/imagenes/logo altice pf.PNG")));
		setTitle("Altice  - Modificaciones");
		setBounds(100, 100, 634, 445);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setBounds(0, 0, 628, 76);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Modificaciones");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
				lblNewLabel.setBounds(36, 11, 381, 54);
				panel.add(lblNewLabel);
			}
		}
		{
			panel_Cliente = new JPanel();
			panel_Cliente.setBackground(SystemColor.window);
			panel_Cliente.setVisible(false);
			panel_Cliente.setBorder(new TitledBorder(null, "Modificacion de cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
			panel_Cliente.setBounds(0, 77, 618, 286);
			contentPanel.add(panel_Cliente);
			panel_Cliente.setLayout(null);
			{
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(null, "Informacion personal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
				panel.setBackground(SystemColor.window);
				panel.setBounds(10, 21, 598, 94);
				panel_Cliente.add(panel);
				panel.setLayout(null);
				{
					JLabel lblNewLabel_7 = new JLabel("Cedula:");
					lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 15));
					lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_7.setBounds(28, 24, 97, 25);
					panel.add(lblNewLabel_7);
				}
				{
					JLabel lblNewLabel_8 = new JLabel("Nombre:");
					lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 15));
					lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_8.setBounds(28, 53, 97, 25);
					panel.add(lblNewLabel_8);
				}
				{
					JLabel lblNewLabel_9 = new JLabel("Apellidos:");
					lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 15));
					lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_9.setBounds(312, 24, 97, 25);
					panel.add(lblNewLabel_9);
				}
				{
					txtCedulaCliente = new JTextField();
					txtCedulaCliente.setEditable(false);
					txtCedulaCliente.setBounds(124, 24, 160, 25);
					panel.add(txtCedulaCliente);
					txtCedulaCliente.setColumns(10);
				}
				{
					txtNombreCliente = new JTextField();
					txtNombreCliente.setBounds(124, 56, 160, 25);
					panel.add(txtNombreCliente);
					txtNombreCliente.setColumns(10);
				}
				{
					txtApellidosCliente = new JTextField();
					txtApellidosCliente.setBounds(419, 24, 149, 25);
					panel.add(txtApellidosCliente);
					txtApellidosCliente.setColumns(10);
				}
			}
			{
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(null, "Informacion de contacto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
				panel.setBackground(SystemColor.window);
				panel.setBounds(10, 126, 598, 132);
				panel_Cliente.add(panel);
				panel.setLayout(null);
				{
					JLabel lblNewLabel_10 = new JLabel("Direccion:");
					lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 15));
					lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_10.setBounds(28, 34, 97, 25);
					panel.add(lblNewLabel_10);
				}
				{
					JLabel lblNewLabel_11 = new JLabel("Telefono:");
					lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 15));
					lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_11.setBounds(28, 81, 97, 25);
					panel.add(lblNewLabel_11);
				}
				{
					txtDireccionCliente = new JTextField();
					txtDireccionCliente.setBounds(128, 37, 295, 25);
					panel.add(txtDireccionCliente);
					txtDireccionCliente.setColumns(10);
				}
				{
					txtTelefonoCliente = new JTextField();
					txtTelefonoCliente.setBounds(128, 81, 295, 25);
					panel.add(txtTelefonoCliente);
					txtTelefonoCliente.setColumns(10);
				}
			}
		}
		{
			panel_Plan = new JPanel();
			panel_Plan.setBounds(0, 77, 618, 286);
			contentPanel.add(panel_Plan);
			panel_Plan.setVisible(false);
			panel_Plan.setBorder(new TitledBorder(null, "Modificacion de plan", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
			panel_Plan.setBackground(SystemColor.window);
			panel_Plan.setLayout(null);
			{
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
				panel.setBackground(SystemColor.window);
				panel.setBounds(10, 21, 598, 97);
				panel_Plan.add(panel);
				panel.setLayout(null);
				{
					JLabel lblNewLabel_1 = new JLabel("Codigo:");
					lblNewLabel_1.setBounds(12, 11, 97, 25);
					panel.add(lblNewLabel_1);
					lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				}
				{
					JLabel lblNewLabel_3 = new JLabel("Estado:");
					lblNewLabel_3.setBounds(12, 61, 97, 25);
					panel.add(lblNewLabel_3);
					lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
					lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Nombre:");
					lblNewLabel_2.setBounds(304, 11, 97, 25);
					panel.add(lblNewLabel_2);
					lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
					lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				}
				{
					txtCodigoPlan = new JTextField();
					txtCodigoPlan.setEditable(false);
					txtCodigoPlan.setBounds(121, 11, 171, 25);
					panel.add(txtCodigoPlan);
					txtCodigoPlan.setColumns(10);
				}
				{
					txtEstadoPlan = new JTextField();
					txtEstadoPlan.setEditable(false);
					txtEstadoPlan.setBounds(121, 64, 171, 25);
					panel.add(txtEstadoPlan);
					txtEstadoPlan.setColumns(10);
				}
				{
					txtNombrePlan = new JTextField();
					txtNombrePlan.setBounds(413, 11, 171, 25);
					panel.add(txtNombrePlan);
					txtNombrePlan.setColumns(10);
				}
			}
			{
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
				panel.setBackground(SystemColor.window);
				panel.setBounds(10, 129, 598, 120);
				panel_Plan.add(panel);
				panel.setLayout(null);
				{
					JLabel lblNewLabel_4 = new JLabel("Descripcion:");
					lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
					lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_4.setBounds(12, 21, 97, 25);
					panel.add(lblNewLabel_4);
				}
				{
					txtDescripcionPlan = new JTextField();
					txtDescripcionPlan.setBounds(123, 21, 436, 43);
					panel.add(txtDescripcionPlan);
					txtDescripcionPlan.setColumns(10);
				}
				{
					JLabel lblNewLabel_5 = new JLabel("Precio total:");
					lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 15));
					lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_5.setBounds(12, 84, 97, 25);
					panel.add(lblNewLabel_5);
				}
				{
					txtPrecioPlan = new JTextField();
					txtPrecioPlan.setEditable(false);
					txtPrecioPlan.setBounds(179, 84, 142, 25);
					panel.add(txtPrecioPlan);
					txtPrecioPlan.setColumns(10);
				}
				{
					JLabel lblNewLabel_6 = new JLabel("RD $");
					lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 15));
					lblNewLabel_6.setBounds(123, 84, 46, 25);
					panel.add(lblNewLabel_6);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setBackground(SystemColor.window);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Finalizar modificacion");
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
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (panel_Plan.isVisible()== true) {
							Plan aux = new Plan(txtCodigoPlan.getText(), txtNombrePlan.getText(), txtDescripcionPlan.getText(), Altice.getInstance().buscarPlanByCode(txtCodigoPlan.getText()).getServicios(), Float.parseFloat(txtPrecioPlan.getText()));
							Altice.getInstance().editarPlan(txtCodigoPlan.getText(),aux);
							JOptionPane.showMessageDialog(null, "Registro actualizado.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						if (panel_Cliente.isVisible() == true) {
							Cliente aux = new Cliente(txtCedulaCliente.getText(), txtNombreCliente.getText(), txtApellidosCliente.getText(), txtTelefonoCliente.getText(), txtDireccionCliente.getText());
							Altice.getInstance().editarInfoClient(txtCedulaCliente.getText(), aux);
							JOptionPane.showMessageDialog(null, "Registro actualizado.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
					}
					
				});
				btnModificar.setFont(new Font("Arial", Font.PLAIN, 15));
				btnModificar.setIcon(new ImageIcon(Modificar.class.getResource("/imagenes/icono check.png")));
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				btnCancelar = new JButton("Cancelar");
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
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setFont(new Font("Arial", Font.PLAIN, 15));
				btnCancelar.setIcon(new ImageIcon(Modificar.class.getResource("/imagenes/icono cancelar.png")));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}

	public void cargarInfo(Plan plan, Cliente client) {
		if (plan != null && client == null) {
			panel_Plan.setVisible(true);
			panel_Cliente.setVisible(false);
			txtCodigoPlan.setText(plan.getCodigo());
			txtNombrePlan.setText(plan.getNombrePlan());
			txtEstadoPlan.setText(plan.getEstado());
			txtDescripcionPlan.setText(plan.getDescripcion());
			txtPrecioPlan.setText(""+ plan.getTotalPrecio());
		}if (plan == null && client != null) {
			panel_Cliente.setVisible(true);
			panel_Plan.setVisible(false);
			txtCedulaCliente.setText(client.getCedula());
			txtNombreCliente.setText(client.getNombre());
			txtApellidosCliente.setText(client.getApellido());
			txtDireccionCliente.setText(client.getDireccion());
			txtTelefonoCliente.setText(client.getTelefono());
		}
	}

}
