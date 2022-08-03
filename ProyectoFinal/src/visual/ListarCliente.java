package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Altice;
import logico.Trabajador;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListarCliente extends JFrame {

	private JPanel contentPane;
	private JTable tabla;
	private JScrollPane sp;
	DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarCliente frame = new ListarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListarCliente() {
		setResizable(false);
		setTitle("Altice - Lista Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(20, 22, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.setBounds(218, 22, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.setBounds(119, 22, 89, 23);
		contentPane.add(btnNewButton_2);
		
		sp = new JScrollPane();
		sp.setBounds(20, 60, 625, 318);
		contentPane.add(sp);
		
		tabla = new JTable();
		sp.setColumnHeaderView(tabla);
		obtenerClientes();
		sp.setViewportView(tabla); 
		
	}

	private void obtenerClientes() {
		modelo = new DefaultTableModel();
		
		List<Object> nombreColumna = new ArrayList<Object>();
		
		nombreColumna.add("Cedula");
		nombreColumna.add("Nombre");
		nombreColumna.add("Apellido");
		nombreColumna.add("Telefono");
		nombreColumna.add("Direccion");
		
		for(Object columna : nombreColumna) {
			modelo.addColumn(columna);
		}
		
//		List<Trabajador> usuarios = Altice.getInstance().obtenerTrabajador();

//		Object[] row = new Object[7];
//		for(Trabajador t : usuarios) {
//			System.out.print(t.getNombre());
//
//			row[0]=t.getNombre();
//			row[1]=t.getApellidos();
//			row[2]=t.getCedula();
//			row[3]=t.getEmail();
//			row[4]=t.getTelefono();
//			row[5]=t.getUserName();
//			row[6]=t.getPassword();
//			modelo.addRow(row);
//		}
		
		
		tabla.setModel(modelo);		
	}

}
