package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import logico.Administrador;
import logico.Trabajador;

import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

public class DetallesUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnAtras;
	private JPanel panel;
	private JLabel lblTitulo;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JTextField txtNombreCompleto;
	private JLabel lblNewLabel_1;
	private JTextField txtCedula;
	private JLabel lblNewLabel_2;
	private JTextField txtPuesto;
	private JPanel panel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtTelefono;
	private JLabel lblNewLabel_4;
	private JTextField txtCorreo;
	private JPanel panel_3;
	private JLabel lblNewLabel_5;
	private JTextField txtUserName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DetallesUsuarios dialog = new DetallesUsuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DetallesUsuarios() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DetallesUsuarios.class.getResource("/imagenes/logo altice pf.PNG")));
		setTitle("Altice - Detalles");
		setBounds(100, 100, 568, 483);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setBounds(0, 0, 718, 72);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				lblTitulo = new JLabel(" Detalles ");
				lblTitulo.setIcon(new ImageIcon(DetallesUsuarios.class.getResource("/imagenes/detalles icono.png")));
				lblTitulo.setForeground(Color.WHITE);
				lblTitulo.setFont(new Font("Arial", Font.BOLD, 25));
				lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
				lblTitulo.setBounds(10, 11, 501, 50);
				panel.add(lblTitulo);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Informacion personal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
			panel_1.setBackground(SystemColor.window);
			panel_1.setBounds(10, 83, 542, 132);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{
				lblNewLabel = new JLabel("Nombre completo:");
				lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(10, 13, 155, 26);
				panel_1.add(lblNewLabel);
			}
			{
				txtNombreCompleto = new JTextField();
				txtNombreCompleto.setEditable(false);
				txtNombreCompleto.setBounds(192, 13, 224, 26);
				panel_1.add(txtNombreCompleto);
				txtNombreCompleto.setColumns(10);
			}
			{
				lblNewLabel_1 = new JLabel("Cedula:");
				lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(10, 52, 155, 26);
				panel_1.add(lblNewLabel_1);
			}
			{
				txtCedula = new JTextField();
				txtCedula.setEditable(false);
				txtCedula.setBounds(192, 52, 224, 26);
				panel_1.add(txtCedula);
				txtCedula.setColumns(10);
			}
			{
				lblNewLabel_2 = new JLabel("Puesto:");
				lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2.setBounds(10, 91, 155, 26);
				panel_1.add(lblNewLabel_2);
			}
			{
				txtPuesto = new JTextField();
				txtPuesto.setEditable(false);
				txtPuesto.setBounds(192, 91, 224, 26);
				panel_1.add(txtPuesto);
				txtPuesto.setColumns(10);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setBackground(SystemColor.window);
			panel_2.setBorder(new TitledBorder(null, "Informacion de contacto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
			panel_2.setBounds(10, 220, 542, 85);
			contentPanel.add(panel_2);
			panel_2.setLayout(null);
			{
				lblNewLabel_3 = new JLabel("Telefono:");
				lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setBounds(-15, 26, 155, 26);
				panel_2.add(lblNewLabel_3);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setEditable(false);
				txtTelefono.setBounds(113, 27, 155, 26);
				panel_2.add(txtTelefono);
				txtTelefono.setColumns(10);
			}
			{
				lblNewLabel_4 = new JLabel("Correo:");
				lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setBounds(246, 26, 155, 26);
				panel_2.add(lblNewLabel_4);
			}
			{
				txtCorreo = new JTextField();
				txtCorreo.setEditable(false);
				txtCorreo.setBounds(358, 27, 155, 26);
				panel_2.add(txtCorreo);
				txtCorreo.setColumns(10);
			}
		}
		{
			panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Informacion de usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
			panel_3.setBackground(SystemColor.window);
			panel_3.setBounds(10, 316, 542, 85);
			contentPanel.add(panel_3);
			panel_3.setLayout(null);
			{
				lblNewLabel_5 = new JLabel("UserName:");
				lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 15));
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setBounds(-15, 39, 155, 26);
				panel_3.add(lblNewLabel_5);
			}
			{
				txtUserName = new JTextField();
				txtUserName.setEditable(false);
				txtUserName.setBounds(113, 39, 155, 26);
				panel_3.add(txtUserName);
				txtUserName.setColumns(10);
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
				btnAtras.setIcon(new ImageIcon(DetallesUsuarios.class.getResource("/imagenes/logo siguiente.png")));
				btnAtras.setFont(new Font("Arial", Font.PLAIN, 15));
				btnAtras.setActionCommand("Cancel");
				buttonPane.add(btnAtras);
			}
		}
	}

	public void cargarInfo(Trabajador selected) {
		lblTitulo.setText(" Detalles sobre: " + selected.getNombre() +" "+ selected.getApellidos());
		txtNombreCompleto.setText(selected.getNombre() +" "+ selected.getApellidos());
		txtCedula.setText(selected.getCedula());
		if (selected instanceof Administrador) {
			txtPuesto.setText("Administrador");
		}else {
			txtPuesto.setText("Comercial");
		}
		txtTelefono.setText(selected.getTelefono());
		txtCorreo.setText(selected.getEmail());
		txtUserName.setText(selected.getUserName());
		
	}

}
