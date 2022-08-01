package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Altice;
import logico.Cliente;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JButton btnLista;
	private JButton btnBuscar;
	private Cliente cliente = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscarCliente dialog = new BuscarCliente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscarCliente(Cliente aux) {
		cliente = aux;
		setModal(true);
		setResizable(false);
		setTitle("Buscar Cliente");
		setBounds(100, 100, 535, 387);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 529, 77);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar Cliente");
		lblNewLabel.setIcon(new ImageIcon(BuscarCliente.class.getResource("/imagenes/icons8-find-66.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 0, 241, 77);
		panel.add(lblNewLabel);
		
		JTextPane txtpnEscribaLaCedula = new JTextPane();
		txtpnEscribaLaCedula.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnEscribaLaCedula.setBackground(SystemColor.control);
		txtpnEscribaLaCedula.setText("Escriba la cedula del cliente o presione el boton buscar e la lista de clientes.\r\n");
		txtpnEscribaLaCedula.setBounds(10, 88, 509, 44);
		contentPanel.add(txtpnEscribaLaCedula);
		
		JLabel lblNewLabel_1 = new JLabel("Cedula:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(69, 192, 68, 14);
		contentPanel.add(lblNewLabel_1);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(147, 191, 183, 20);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);
		
		btnLista = new JButton("Buscar en lista");
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarCliente lista = new ListarCliente();
				lista.setVisible(true);
			}
		});
		btnLista.setBounds(340, 190, 138, 23);
		contentPanel.add(btnLista);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(!txtCedula.getText().isEmpty()) {
						Cliente auxCliente = Altice.getInstance().buscarClientePorCedula(txtCedula.getText());
						if(auxCliente != null) {
							//TODO cuando raymer termine.
						}
						else {
							JOptionPane.showMessageDialog(null, "Este cliente no esta registrado.", "Error.", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "No hay cedula escrita.", "Error.", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			buttonPane.add(btnBuscar);
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		setCedula();
	}

	private void setCedula() {
		if(cliente != null) {
			txtCedula.setText(cliente.getCedula());
		}
		
	}
}
