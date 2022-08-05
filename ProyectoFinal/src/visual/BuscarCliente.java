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
	private JButton btnBuscar;
	private JPanel panelBuscar;
	private JTextField txtCedula;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscarCliente dialog = new BuscarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscarCliente() {
		setModal(true);
		setResizable(false);
		setTitle("Buscar Cliente");
		setBounds(100, 100, 433, 343);
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
		
		panelBuscar = new JPanel();
		panelBuscar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBuscar.setBounds(10, 88, 407, 177);
		contentPanel.add(panelBuscar);
		panelBuscar.setLayout(null);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(150, 76, 183, 20);
		panelBuscar.add(txtCedula);
		
		JLabel label = new JLabel("Cedula:");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(41, 76, 99, 14);
		panelBuscar.add(label);
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
							ListFac auxList = new ListFac(auxCliente,true);
							auxList.setVisible(true);
							dispose();
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
	}
}
