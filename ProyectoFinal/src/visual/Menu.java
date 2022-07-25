package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JToggleButton;

public class Menu extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private JPanel panel;
	private JButton btnMenu;
	private JPanel panelMenu;

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
		panelMenu.setVisible(false);
		panelMenu.setBackground(new Color(128, 128, 128));
		panelMenu.setForeground(new Color(0, 0, 0));
		panelMenu.setBounds(0, 109, 696, 1002);
		contentPane.add(panelMenu);
	}
}
