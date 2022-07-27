package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Facturacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturacion dialog = new Facturacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturacion() {
		setTitle("Facturacion");
		setModal(true);
		setBounds(100, 100, 711, 748);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(new Color(253,245,230));
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 695, 62);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Realizar Venta");
		lblNewLabel.setIcon(new ImageIcon(Facturacion.class.getResource("/imagenes/FacturaGris.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(10, 11, 292, 40);
		panel.add(lblNewLabel);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBackground(new Color(253, 245, 230));
		panelCliente.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCliente.setBounds(10, 73, 675, 183);
		contentPanel.add(panelCliente);
		panelCliente.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Escriba datos del cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 0, 185, 14);
		panelCliente.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cedula:");
		lblNewLabel_2.setBounds(20, 33, 58, 14);
		panelCliente.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(88, 30, 154, 20);
		panelCliente.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setIcon(new ImageIcon(Facturacion.class.getResource("/imagenes/buscar1.png")));
		btnNewButton.setBounds(252, 25, 125, 29);
		panelCliente.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		lblNewLabel_3.setBounds(20, 83, 58, 14);
		panelCliente.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(88, 80, 154, 20);
		panelCliente.add(textField_1);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(302, 83, 58, 14);
		panelCliente.add(lblApellidos);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(376, 80, 154, 20);
		panelCliente.add(textField_2);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono:");
		lblNewLabel_4.setBounds(20, 133, 58, 14);
		panelCliente.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(88, 130, 154, 20);
		panelCliente.add(textField_3);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(302, 133, 64, 14);
		panelCliente.add(lblDireccion);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(376, 130, 154, 20);
		panelCliente.add(textField_4);
		
		JPanel panelSeleccion = new JPanel();
		panelSeleccion.setBounds(10, 267, 675, 95);
		contentPanel.add(panelSeleccion);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(253, 245, 230));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
