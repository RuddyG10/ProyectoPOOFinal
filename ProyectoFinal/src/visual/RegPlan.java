package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Altice;
import logico.Cable;
import logico.Internet;
import logico.Plan;
import logico.Servicio;
import logico.Telefono;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class RegPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDescripcion;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JRadioButton rdbCable;
	private JRadioButton rdbInternet;
	private JRadioButton rdbTelefono;
	private JPanel panel_Telefono;
	private JPanel panel_Cable;
	private JPanel panel_Internet;
	private JSpinner spnMBajada;
	private JSpinner spnMSubida;
	private JSpinner spnCanales;
	private JSpinner spnMinutos;

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
		setBounds(100, 100, 707, 568);
		setLocationRelativeTo(null);
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
		lblNewLabel_4.setBounds(24, 435, 168, 14);
		contentPanel.add(lblNewLabel_4);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(122, 412, 548, 61);
		contentPanel.add(txtDescripcion);
		txtDescripcion.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Informacion del plan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.controlLtHighlight);
		panel_2.setBounds(10, 88, 657, 81);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 24, 116, 31);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(325, 24, 116, 31);
		panel_2.add(lblNewLabel_2);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(113, 24, 197, 31);
		panel_2.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(438, 24, 197, 31);
		panel_2.add(txtNombre);
		txtNombre.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlLtHighlight);
		panel_1.setBorder(new TitledBorder(null, "Seleccione los servicios incluidos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 174, 657, 81);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		rdbTelefono = new JRadioButton("Telefono");
		rdbTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbTelefono.isSelected()) {
					panel_Telefono.setVisible(true);
				}
				else {
					panel_Telefono.setVisible(false);
				}			
			}
		});
		rdbTelefono.setBackground(SystemColor.text);
		rdbTelefono.setFont(new Font("Arial", Font.BOLD, 15));
		rdbTelefono.setBounds(44, 30, 109, 23);
		panel_1.add(rdbTelefono);

		rdbInternet = new JRadioButton("Internet");
		rdbInternet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbInternet.isSelected()) {
					panel_Internet.setVisible(true);
				}
				else {
					panel_Internet.setVisible(false);
				}		
			}
		});
		rdbInternet.setBackground(SystemColor.text);
		rdbInternet.setFont(new Font("Arial", Font.BOLD, 15));
		rdbInternet.setBounds(510, 30, 109, 23);
		panel_1.add(rdbInternet);

		rdbCable = new JRadioButton("Cable");
		rdbCable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbCable.isSelected()) {
					panel_Cable.setVisible(true);
				}
				else {
					panel_Cable.setVisible(false);
				}		
			}
		});
		rdbCable.setBackground(SystemColor.text);
		rdbCable.setFont(new Font("Arial", Font.BOLD, 15));
		rdbCable.setBounds(274, 30, 109, 23);
		panel_1.add(rdbCable);

		panel_Telefono = new JPanel();
		panel_Telefono.setVisible(false);
		panel_Telefono.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalles del telefono", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Telefono.setBounds(10, 261, 196, 140);
		contentPanel.add(panel_Telefono);
		panel_Telefono.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Cantidad de minutos:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(29, 35, 132, 20);
		panel_Telefono.add(lblNewLabel_3);

		spnMinutos = new JSpinner();
		spnMinutos.setModel(new SpinnerNumberModel(new Integer(10), new Integer(10), null, new Integer(1)));
		spnMinutos.setBounds(58, 84, 75, 20);
		panel_Telefono.add(spnMinutos);

		panel_Cable = new JPanel();
		panel_Cable.setVisible(false);
		panel_Cable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalles del cable", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Cable.setBounds(240, 261, 196, 140);
		contentPanel.add(panel_Cable);
		panel_Cable.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Cantidad de canales:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(39, 35, 132, 20);
		panel_Cable.add(lblNewLabel_5);

		spnCanales = new JSpinner();
		spnCanales.setModel(new SpinnerNumberModel(65, 65, 290, 1));
		spnCanales.setBounds(68, 84, 75, 20);
		panel_Cable.add(spnCanales);

		panel_Internet = new JPanel();
		panel_Internet.setVisible(false);
		panel_Internet.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalles del internet", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Internet.setBounds(476, 261, 196, 140);
		contentPanel.add(panel_Internet);
		panel_Internet.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Megas de subida:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(-3, 35, 132, 20);
		panel_Internet.add(lblNewLabel_6);

		spnMSubida = new JSpinner();
		spnMSubida.setBounds(126, 35, 60, 20);
		panel_Internet.add(spnMSubida);

		JLabel lblNewLabel_7 = new JLabel("Megas de bajada:");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(-3, 84, 132, 20);
		panel_Internet.add(lblNewLabel_7);

		spnMBajada = new JSpinner();
		spnMBajada.setBounds(126, 84, 60, 20);
		panel_Internet.add(spnMBajada);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlLtHighlight);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {						
						if (verificarCampos()) {
							ArrayList<Servicio> aux = new ArrayList<>();
							if (rdbTelefono.isSelected()) {
								float cantMinutos = Float.parseFloat(spnMinutos.getValue().toString());
								Servicio tel = new Telefono("tel-"+Altice.genCodeServ, "Telefono", Altice.getInstace().calcularPrecioServicio(cantMinutos), cantMinutos);
								Altice.getInstace().insertarServicio(tel);
								aux.add(tel);
							}
							if (rdbCable.isSelected()) {
								int cantCanales = Integer.parseInt(spnCanales.getValue().toString());
								Servicio cab = new Cable("cab-"+Altice.genCodeServ, "Cable", Altice.getInstace().calcularPrecioServicio(cantCanales), cantCanales);
								Altice.getInstace().insertarServicio(cab);
								aux.add(cab);
							}
							if (rdbInternet.isSelected()) {
								float subida = Float.parseFloat(spnMSubida.getValue().toString());
								float bajada = Float.parseFloat(spnMBajada.getValue().toString());
								Servicio net= new Internet("net-"+Altice.genCodeServ, "Internet", Altice.getInstace().calcularPrecioServicio(subida+bajada), subida, bajada);
								aux.add(net);
							}
							Plan auxiliar = new Plan("P-"+Altice.genCodePlan, txtNombre.getText(), txtDescripcion.getText(), aux, Altice.getInstace().calcularPrecioPlan(aux));
							Altice.getInstace().insertarPlan(auxiliar);
							JOptionPane.showMessageDialog(null, "Operacion exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}else {
							JOptionPane.showMessageDialog(null, "Faltan datos para completar el registro", "Error", JOptionPane.WARNING_MESSAGE);
						}
					}
				});
	
				btnRegistrar.setIcon(new ImageIcon(RegPlan.class.getResource("/imagenes/icono check.png")));
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setIcon(new ImageIcon(RegPlan.class.getResource("/imagenes/icono cancelar.png")));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		verificarCampos();
		updateCodigo();
	}
	private void updateCodigo() {
		String pre = "Altice-";
		txtCodigo.setText(pre+Altice.genCodePlan);
	}
	
	private boolean verificarCampos() {
		boolean registrar = false;
		if (!txtNombre.getText().isEmpty() && !txtDescripcion.getText().isEmpty()) {
			if (rdbTelefono.isSelected() || rdbCable.isSelected() || rdbInternet.isSelected()) {
				registrar = true;
			}
		}
			
		return registrar;
	}
	private void clean () {
		txtNombre.setText("");
		txtDescripcion.setText("");
		rdbTelefono.setSelected(false);
		rdbCable.setSelected(false);
		rdbInternet.setSelected(false);
		panel_Telefono.setVisible(false);
		panel_Cable.setVisible(false);
		panel_Internet.setVisible(false);
		updateCodigo();
		spnMBajada.setValue(0);
		spnMSubida.setValue (0);
		spnMinutos.setValue(10);
		spnCanales.setValue(65);
	}
}
