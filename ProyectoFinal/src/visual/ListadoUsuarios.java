package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Administrador;
import logico.Altice;
import logico.Comercial;
import logico.Trabajador;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton rdbAdmin;
	private JTable table;
	private JButton btnAtras;
	private JButton btnDetalles;
	private JButton btnEliminar;
	private JRadioButton rdbComercial;
	private static DefaultTableModel model;
	private static Object row[];
	private Trabajador selected = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoUsuarios dialog = new ListadoUsuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoUsuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadoUsuarios.class.getResource("/imagenes/logo altice pf.PNG")));
		setTitle("Altice");
		setBounds(100, 100, 652, 528);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 636, 76);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("  Listado de usuarios");
		lblNewLabel.setIcon(new ImageIcon(ListadoUsuarios.class.getResource("/imagenes/listado icono.png")));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(32, 11, 458, 54);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Seleccione uno", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panel_1.setBackground(SystemColor.controlLtHighlight);
		panel_1.setBounds(10, 87, 616, 76);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		rdbAdmin = new JRadioButton("Administradores");
		rdbAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbAdmin.isSelected()) {
					rdbComercial.setSelected(false);
				}
				loadTable();
			}
		});
		rdbAdmin.setBackground(SystemColor.controlLtHighlight);
		rdbAdmin.setFont(new Font("Arial", Font.BOLD, 15));
		rdbAdmin.setBounds(68, 24, 205, 34);
		panel_1.add(rdbAdmin);

		rdbComercial = new JRadioButton("Comerciales");
		rdbComercial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbComercial.isSelected()) {
					rdbAdmin.setSelected(false);
				}
				loadTable();
			}
		});
		rdbComercial.setBackground(SystemColor.controlLtHighlight);
		rdbComercial.setFont(new Font("Arial", Font.BOLD, 15));
		rdbComercial.setBounds(341, 24, 205, 34);
		panel_1.add(rdbComercial);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Listado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panel_2.setBackground(SystemColor.window);
		panel_2.setBounds(10, 171, 616, 270);
		contentPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		String headers [] = {"Cedula","Nombre","Info. de contacto"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headers);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if (index >=0) {
					String ced = table.getValueAt(index, 0).toString();
					selected = Altice.getInstance().buscarTrabajadorByCedula(ced);
					btnDetalles.setEnabled(true);
					btnEliminar.setEnabled(true);
				}
			}
		});
		table.setModel(model);
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.window);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int option = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar a : "+selected.getNombre() + selected.getApellidos() +" con cedula: "+selected.getCedula()+ " de la lista de usuarios?");
					if (JOptionPane.YES_OPTION == option) {
						Altice.getInstance().eliminarUsuario(selected);
						loadTable();
						btnDetalles.setEnabled(false);
						btnEliminar.setEnabled(false);
					}
				}
			});
			btnEliminar.setEnabled(false);
			btnEliminar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnEliminar.setBackground(Color.red);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnEliminar.setBackground(UIManager.getColor("control"));
				}
			});
			btnEliminar.setFont(new Font("Arial", Font.PLAIN, 15));
			btnEliminar.setIcon(new ImageIcon(ListadoUsuarios.class.getResource("/imagenes/eliminar icono.png")));
			buttonPane.add(btnEliminar);
			{
				btnDetalles = new JButton("Ver detalles");
				btnDetalles.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnDetalles.setBackground(Color.blue);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnDetalles.setBackground(UIManager.getColor("control"));
					}
				});
				btnDetalles.setIcon(new ImageIcon(ListadoUsuarios.class.getResource("/imagenes/masDetalles icono.png")));
				btnDetalles.setFont(new Font("Arial", Font.PLAIN, 15));
				btnDetalles.setEnabled(false);
				btnDetalles.setActionCommand("OK");
				buttonPane.add(btnDetalles);
				getRootPane().setDefaultButton(btnDetalles);
			}
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
				btnAtras.setIcon(new ImageIcon(ListadoUsuarios.class.getResource("/imagenes/logo siguiente.png")));
				btnAtras.setFont(new Font("Arial", Font.PLAIN, 15));
				btnAtras.setActionCommand("Cancel");
				buttonPane.add(btnAtras);
			}
		}
		loadTable();
	}
	private void loadTable() {
		
		
		ArrayList<Trabajador> auxiliar = new ArrayList<>();
		int cantTrab = Altice.getInstance().getMisTrabajadores().size();

		if (rdbAdmin.isSelected() | rdbComercial.isSelected()) {
			for (int i = 0; i< cantTrab; i++) {
				Trabajador aux = Altice.getInstance().getMisTrabajadores().get(i);
				if (rdbAdmin.isSelected() && aux instanceof Administrador ) {
					auxiliar.add(aux);
				}
				if (rdbComercial.isSelected() && aux instanceof Comercial) {
					auxiliar.add(aux);
				}	

			}

		}
		else {
			auxiliar = Altice.getInstance().getMisTrabajadores();
		}
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i < auxiliar.size(); i++) {
			row[0] = auxiliar.get(i).getCedula();
			row[1] = auxiliar.get(i).getNombre();
			row[2] = auxiliar.get(i).getEmail();

			model.addRow(row);
		}
	}
}

