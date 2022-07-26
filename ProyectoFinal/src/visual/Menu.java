package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Trabajador;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

public class Menu extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private JPanel panel;
	private JButton btnMenu;
	private JPanel panelMenu;
	private JButton btnClient;
	private JButton btnPlanes;
	private JButton btnFacturacion;
	private JButton btnPersonal;
	private JButton btnConsultas;
	private JButton btnRevision;
	private JButton btnCerrarSesion;
	private JPanel panelClient;
	private JPanel panelPersonal;
	private JPanel panelFactura;
	private JPanel panelPlanes;
	private JPanel panelConsultas;
	private JButton btnListClient;
	private JButton btnRegPlan;
	private JButton btnListPlan;
	private JButton btnRegServ;
	private JButton btnListServ;
	private JButton btnVenta;
	private JButton btnListFac;
	private JButton btnRegPer;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize();
		setSize(dim.width,dim.height-50);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1904, 110);
		contentPane.add(panel);
		
		btnMenu = new JButton("Menu");
		btnMenu.setPressedIcon(new ImageIcon(Menu.class.getResource("/imagenes/icons8-menu-120 (Gray).png")));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revision(true);
				if(!panelMenu.isVisible()) {
					
					panelMenu.setVisible(true);
					btnMenu.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/icons8-menu-120 (Gray).png")));
					
				}
				else {
					panelMenu.setVisible(false);
					btnMenu.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/icons8-menu-120 (WHITE).png")));
					
				}
				
			}
		});
		btnMenu.setRolloverIcon(new ImageIcon(Menu.class.getResource("/imagenes/icons8-menu-120 (Gray).png")));
		btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMenu.setForeground(new Color(255, 255, 255));
		btnMenu.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/icons8-menu-120 (WHITE).png")));
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnMenu.setContentAreaFilled(false);
		btnMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnMenu.setBounds(0, 0, 251, 110);
		panel.add(btnMenu);
		
		panelMenu = new JPanel();
		panelMenu.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
		panelMenu.setVisible(false);
		panelMenu.setBackground(Color.LIGHT_GRAY);
		panelMenu.setForeground(new Color(0, 0, 0));
		panelMenu.setBounds(0, 109, 696, 1002);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		btnClient = new JButton("Administrar Clientes");
		btnClient.setRolloverIcon(new ImageIcon(Menu.class.getResource("/imagenes/Cliente dark.png")));
		btnClient.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Cliente gris.png")));
		btnClient.setForeground(Color.LIGHT_GRAY);
		btnClient.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnClient.setBackground(new Color(52,52,52));
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revision(true);
				if(!panelClient.isVisible()) {
					btnClient.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Cliente dark.png")));
					panelClient.setVisible(true);
					revision(false);
				}
				else {
					panelClient.setVisible(false);
					btnClient.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Cliente gris.png")));
					revision(false);
				}
			}

			
		});
		btnClient.setBounds(0, 5, 696, 137);
		panelMenu.add(btnClient);
		
		btnPlanes = new JButton("Administrar Planes y Servicios\r\n");
		btnPlanes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revision(true);
				if(!panelPlanes.isVisible()) {
					panelPlanes.setVisible(true);
					btnPlanes.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/WifiDark.png")));
					revision(false);
				}
				else {
					panelPlanes.setVisible(false);
					btnPlanes.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/WifiGris.png")));
					revision(false);
				}
			}
		});
		btnPlanes.setRolloverIcon(new ImageIcon(Menu.class.getResource("/imagenes/WifiDark.png")));
		btnPlanes.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/WifiGris.png")));
		btnPlanes.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnPlanes.setForeground(Color.LIGHT_GRAY);
		btnPlanes.setBackground(new Color(52,52,52));
		btnPlanes.setBounds(0, 147, 696, 137);
		panelMenu.add(btnPlanes);
		
		btnFacturacion = new JButton("Facturacion");
		btnFacturacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revision(true);
				if(!panelFactura.isVisible()) {
					panelFactura.setVisible(true);
					btnFacturacion.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/FacturaDark.png")));
					revision(false);
				}
				else {
					panelFactura.setVisible(false);
					btnPlanes.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/FacturaGris.png")));
					revision(false);
				}
			}
		});
		btnFacturacion.setRolloverIcon(new ImageIcon(Menu.class.getResource("/imagenes/FacturaDark.png")));
		btnFacturacion.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/FacturaGris.png")));
		btnFacturacion.setForeground(Color.LIGHT_GRAY);
		btnFacturacion.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnFacturacion.setBackground(new Color(52,52,52));
		btnFacturacion.setBounds(0, 289, 696, 137);
		panelMenu.add(btnFacturacion);
		
		btnPersonal = new JButton("Administrar Personal");
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revision(true);
				if(!panelPersonal.isVisible()) {
					panelPersonal.setVisible(true);
					btnPersonal.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/PersonalDark.png")));
					revision(false);
				}
				else {
					panelPersonal.setVisible(false);
					btnPlanes.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/personal.png")));
					revision(false);
				}
			}
		});
		btnPersonal.setRolloverIcon(new ImageIcon(Menu.class.getResource("/imagenes/PersonalDark.png")));
		btnPersonal.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/personal.png")));
		btnPersonal.setForeground(Color.LIGHT_GRAY);
		btnPersonal.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnPersonal.setBackground(new Color(52,52,52));
		btnPersonal.setBounds(0, 431, 696, 137);
		panelMenu.add(btnPersonal);
		
		btnConsultas = new JButton("Consultas");
		btnConsultas.setForeground(Color.LIGHT_GRAY);
		btnConsultas.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnConsultas.setBackground(new Color(52,52,52));
		btnConsultas.setBounds(0, 573, 696, 137);
		panelMenu.add(btnConsultas);
		
		btnRevision = new JButton("Revision");
		btnRevision.setForeground(Color.LIGHT_GRAY);
		btnRevision.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnRevision.setBackground(new Color(52,52,52));
		btnRevision.setBounds(0, 715, 696, 137);
		panelMenu.add(btnRevision);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revision(true);
				int option = JOptionPane.showConfirmDialog(null, "Desea cerrar la sesion?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(option == 0) {
					dispose();
				}
			}
		});
		btnCerrarSesion.setRolloverIcon(new ImageIcon(Menu.class.getResource("/imagenes/SesuinDark.png")));
		btnCerrarSesion.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/SesionGris.png")));
		btnCerrarSesion.setForeground(Color.LIGHT_GRAY);
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnCerrarSesion.setBackground(new Color(52,52,52));
		btnCerrarSesion.setBounds(0, 857, 696, 137);
		panelMenu.add(btnCerrarSesion);
		
		panelClient = new JPanel();
		panelClient.setBackground(Color.DARK_GRAY);
		panelClient.setVisible(false);
		panelClient.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelClient.setBounds(694, 109, 696, 1002);
		contentPane.add(panelClient);
		panelClient.setLayout(null);
		
		btnListClient = new JButton("Listar Clientes");
		btnListClient.setForeground(Color.DARK_GRAY);
		btnListClient.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnListClient.setBackground(Color.LIGHT_GRAY);
		btnListClient.setBounds(10, 11, 676, 131);
		panelClient.add(btnListClient);
		
		panelPlanes = new JPanel();
		panelPlanes.setBackground(Color.DARK_GRAY);
		panelPlanes.setVisible(false);
		panelPlanes.setBounds(694, 109, 696, 1002);
		contentPane.add(panelPlanes);
		panelPlanes.setLayout(null);
		
		btnRegPlan = new JButton("RegistrarPlan");
		btnRegPlan.setForeground(Color.DARK_GRAY);
		btnRegPlan.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnRegPlan.setBackground(Color.LIGHT_GRAY);
		btnRegPlan.setBounds(10, 11, 676, 131);
		panelPlanes.add(btnRegPlan);
		
		btnListPlan = new JButton("Lista de Planes");
		btnListPlan.setForeground(Color.DARK_GRAY);
		btnListPlan.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnListPlan.setBackground(Color.LIGHT_GRAY);
		btnListPlan.setBounds(10, 153, 676, 131);
		panelPlanes.add(btnListPlan);
		
		btnRegServ = new JButton("Registrar Servicio");
		btnRegServ.setForeground(Color.DARK_GRAY);
		btnRegServ.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnRegServ.setBackground(Color.LIGHT_GRAY);
		btnRegServ.setBounds(10, 295, 676, 131);
		panelPlanes.add(btnRegServ);
		
		btnListServ = new JButton("Lista de Servicios");
		btnListServ.setForeground(Color.DARK_GRAY);
		btnListServ.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnListServ.setBackground(Color.LIGHT_GRAY);
		btnListServ.setBounds(10, 437, 676, 131);
		panelPlanes.add(btnListServ);
		
		panelFactura = new JPanel();
		panelFactura.setBackground(Color.DARK_GRAY);
		panelFactura.setVisible(false);
		panelFactura.setBounds(694, 109, 696, 1002);
		contentPane.add(panelFactura);
		panelFactura.setLayout(null);
		
		btnVenta = new JButton("Realizar Venta");
		btnVenta.setForeground(Color.DARK_GRAY);
		btnVenta.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnVenta.setBackground(Color.LIGHT_GRAY);
		btnVenta.setBounds(10, 11, 676, 131);
		panelFactura.add(btnVenta);
		
		btnListFac = new JButton("Lista de Facturas");
		btnListFac.setForeground(Color.DARK_GRAY);
		btnListFac.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnListFac.setBackground(Color.LIGHT_GRAY);
		btnListFac.setBounds(10, 153, 676, 131);
		panelFactura.add(btnListFac);
		
		panelPersonal = new JPanel();
		panelPersonal.setBackground(Color.DARK_GRAY);
		panelPersonal.setVisible(false);
		panelPersonal.setBounds(694, 109, 696, 1002);
		contentPane.add(panelPersonal);
		panelPersonal.setLayout(null);
		
		btnRegPer = new JButton("Registrar Personal");
		btnRegPer.setForeground(Color.DARK_GRAY);
		btnRegPer.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnRegPer.setBackground(Color.LIGHT_GRAY);
		btnRegPer.setBounds(10, 11, 676, 131);
		panelPersonal.add(btnRegPer);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnNewButton.setBounds(10, 153, 676, 131);
		panelPersonal.add(btnNewButton);
		
		panelConsultas = new JPanel();
		panelConsultas.setBackground(Color.DARK_GRAY);
		panelConsultas.setVisible(false);
		panelConsultas.setBounds(694, 109, 696, 1002);
		contentPane.add(panelConsultas);
		
		JLabel lblLogo = new JLabel("Sistema de Administracion.");
		lblLogo.setBounds(483, 871, 1241, 201);
		contentPane.add(lblLogo);
		lblLogo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 74));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/alticeLogo.png")));
		lblNewLabel.setBounds(679, 204, 946, 641);
		contentPane.add(lblNewLabel);
	}
	public void revision(boolean cerrarTodas) {
		if(panelClient.isVisible()){
			panelPlanes.setVisible(false);
			panelFactura.setVisible(false);
			panelConsultas.setVisible(false);
			panelPersonal.setVisible(false);
		}
		else if(panelPlanes.isVisible()){
			panelClient.setVisible(false);
			panelFactura.setVisible(false);
			panelConsultas.setVisible(false);
			panelPersonal.setVisible(false);
		}
		else if(panelFactura.isVisible()){
			panelPlanes.setVisible(false);
			panelClient.setVisible(false);
			panelConsultas.setVisible(false);
			panelPersonal.setVisible(false);
		}
		else if(panelConsultas.isVisible()){
			panelPlanes.setVisible(false);
			panelFactura.setVisible(false);
			panelClient.setVisible(false);
			panelPersonal.setVisible(false);
		}
		else if(panelPersonal.isVisible()){
			panelPlanes.setVisible(false);
			panelFactura.setVisible(false);
			panelConsultas.setVisible(false);
			panelClient.setVisible(false);
		}
		else {
			panelPlanes.setVisible(false);
			panelFactura.setVisible(false);
			panelConsultas.setVisible(false);
			panelClient.setVisible(false);
			panelPersonal.setVisible(false);
		}
		if(cerrarTodas) {
			btnClient.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Cliente gris.png")));
			btnPlanes.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/WifiGris.png")));
			btnFacturacion.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/FacturaGris.png")));
			btnPersonal.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/personal.png")));
			panelPlanes.setVisible(false);
			panelFactura.setVisible(false);
			panelConsultas.setVisible(false);
			panelClient.setVisible(false);
			panelPersonal.setVisible(false);
		}
	}
}