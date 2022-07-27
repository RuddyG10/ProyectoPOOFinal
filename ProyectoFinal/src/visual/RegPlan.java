package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_3;
	private JTextField txtCodigo;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegPlan dialog = new RegPlan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegPlan() {
		setResizable(false);
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegPlan.class.getResource("/imagenes/logo altice pf.PNG")));
		setTitle("Altice");
		setBounds(100, 100, 707, 576);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 708, 67);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Registrar plan");
		lblNewLabel.setIcon(new ImageIcon(RegPlan.class.getResource("/imagenes/wifi icon.png")));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(44, 11, 497, 42);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Descripci\u00F3n: ");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_4.setBounds(24, 427, 168, 14);
		contentPanel.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(122, 412, 548, 61);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccion de servicios incluidos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.controlLtHighlight);
		panel_1.setBounds(17, 170, 657, 231);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Servicios disponibles");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(89, 22, 193, 23);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Servicios incluidos");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(371, 22, 193, 23);
		panel_1.add(lblNewLabel_6);
		
		JButton btnAgregar = new JButton("");
		btnAgregar.setIcon(new ImageIcon(RegPlan.class.getResource("/imagenes/add_shopping_cart_FILL0_wght400_GRAD0_opsz24.png")));
		btnAgregar.setBounds(312, 92, 41, 36);
		panel_1.add(btnAgregar);
		
		JButton btnRemove = new JButton("");
		btnRemove.setIcon(new ImageIcon(RegPlan.class.getResource("/imagenes/remove_shopping_cart_FILL0_wght400_GRAD0_opsz24.png")));
		btnRemove.setBounds(312, 153, 41, 36);
		panel_1.add(btnRemove);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Informacion del plan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.controlLtHighlight);
		panel_2.setBounds(17, 78, 657, 81);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 22, 116, 31);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(315, 22, 116, 31);
		panel_2.add(lblNewLabel_2);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(108, 22, 197, 31);
		panel_2.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(433, 22, 197, 31);
		panel_2.add(txtNombre);
		txtNombre.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlLtHighlight);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnRegistrar.setBackground(new Color (2,21,58));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnRegistrar.setBackground (new Color (7,85,228));
					}
					
				});
				btnRegistrar.setIcon(new ImageIcon(RegPlan.class.getResource("/imagenes/icono check.png")));
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnCancelar.setBackground(new Color (2,21,58));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnCancelar.setBackground(new Color (7,85,228));
					}
				});
				btnCancelar.setIcon(new ImageIcon(RegPlan.class.getResource("/imagenes/icono cancelar.png")));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
