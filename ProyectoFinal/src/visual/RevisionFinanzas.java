package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Altice;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

import javax.swing.ImageIcon;

public class RevisionFinanzas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnCancelar;
	private String[] headers = {"Fecha","Ingreso estimado","Ingreso real"};
	private DefaultTableModel model;
	private Object[] rows;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RevisionFinanzas dialog = new RevisionFinanzas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RevisionFinanzas() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(RevisionFinanzas.class.getResource("/imagenes/logo altice pf.PNG")));
		setTitle("Altice - Revision Finanzas");
		setBounds(100, 100, 621, 419);

		setTitle("Revision de ganancias");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 621, 376);
		setLocationRelativeTo(null);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 615, 61);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Revision Finanzas");
		lblNewLabel.setIcon(new ImageIcon(RevisionFinanzas.class.getResource("/imagenes/icons8-documento-42.png")));
		lblNewLabel.setBounds(10, 0, 466, 58);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));

		
		/*JPanel panel2 = new JPanel();
		panel2.setBackground(Color.BLACK);
		panel2.setBounds(0, 0, 615, 61);
		contentPanel.add(panel);
		panel.setLayout(null);*/
		
		/*JLabel lblNewLabel2 = new JLabel("Revision de Ganancias Por Dia");
		lblNewLabel.setIcon(new ImageIcon(RevisionFinanzas.class.getResource("/imagenes/icons8-money-30.png")));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 11, 559, 39);
		panel.add(lblNewLabel);*/
		
		JPanel panelRevision = new JPanel();
		panelRevision.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRevision.setBounds(10, 72, 595, 231);
		contentPanel.add(panelRevision);
		panelRevision.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelRevision.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		scrollPane.setViewportView(table);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCancelar = new JButton("Cerrar");
				btnCancelar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						btnCancelar.setBackground(Color.red);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnCancelar.setBackground(UIManager.getColor("control"));
					}
				});
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadTable();
	}


	public void loadTable() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		ArrayList<Date> fechas = Altice.getInstance().getFechasGanancias();
		if(fechas != null) {
			for (int i = 0; i < fechas.size(); i++) {
				rows[0] = fechas.get(i);
				rows[1] = Altice.getInstance().getIngresoE().get(i);
				rows[2] = Altice.getInstance().getIngresoR().get(i);
				model.addRow(rows);
			}
		}
		
		
	}

}
