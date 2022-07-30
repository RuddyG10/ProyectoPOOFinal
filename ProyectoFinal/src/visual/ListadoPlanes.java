package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import logico.Altice;
import logico.Plan;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoPlanes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object row[];
	private JButton btnDetalles;
	private Plan selected = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoPlanes dialog = new ListadoPlanes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoPlanes() {
		setResizable(false);
		setBackground(SystemColor.controlLtHighlight);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadoPlanes.class.getResource("/imagenes/logo altice pf.PNG")));
		setTitle("Altice");
		setBounds(100, 100, 679, 620);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 671, 74);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Listado de planes");
		lblNewLabel.setIcon(new ImageIcon(ListadoPlanes.class.getResource("/imagenes/listado icono.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(10, 11, 420, 52);
		panel.add(lblNewLabel);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(SystemColor.controlLtHighlight);
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(0, 73, 671, 471);
			contentPanel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			String headers [] = {"Codigo","Nombre","Precio"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);
			table = new JTable();
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = table.getSelectedRow();
					if (index >= 0) {
						String codPlan = table.getValueAt(index, 0).toString();
						selected = Altice.getInstance().buscarPlanByCode(codPlan);
						btnDetalles.setEnabled(true);
					}
				}
			});
			
			table.setModel(model);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlLtHighlight);
			buttonPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
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
			btnDetalles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DetallesPlan detalles = new DetallesPlan();
					detalles.cargarInfo(selected);
					detalles.setModal(true);
					detalles.setVisible(true);
					
					
				}
			});
			btnDetalles.setEnabled(false);
			btnDetalles.setFont(new Font("Arial", Font.PLAIN, 15));
			btnDetalles.setIcon(new ImageIcon(ListadoPlanes.class.getResource("/imagenes/masDetalles icono.png")));
			buttonPane.add(btnDetalles);
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnSalir.setBackground(Color.red);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnSalir.setBackground(UIManager.getColor("control"));
					}
				});
				btnSalir.setFont(new Font("Arial", Font.PLAIN, 15));
				btnSalir.setIcon(new ImageIcon(ListadoPlanes.class.getResource("/imagenes/icono cancelar.png")));
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose ();
					}
					
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
		loadTable();
	}
	private void loadTable() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		
		for(int i = 0; i < Altice.getInstance().getmisPlanes().size(); i++) {
			row[0] = Altice.getInstance().getmisPlanes().get(i).getCodigo();
			row[1] = Altice.getInstance().getmisPlanes().get(i).getNombrePlan();
			row[2] = Altice.getInstance().getmisPlanes().get(i).getTotalPrecio();

			model.addRow(row);

		}
	}
}
