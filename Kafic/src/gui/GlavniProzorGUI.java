package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class GlavniProzorGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_3;
	private JButton btnDodajSto;
	private JButton btnRacuni;
	private JButton btnDodajArtikal;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajSto;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzorGUI frame = new GlavniProzorGUI();
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
	public GlavniProzorGUI() {
		setMinimumSize(new Dimension(0, 0));
		setTitle("Kafic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.EAST);
		contentPane.add(getPanel_2(), BorderLayout.CENTER);
		
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getBtnNewButton(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel_1.setBackground(Color.DARK_GRAY);
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(getBtnRacuni(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
							.addComponent(getBtnDodajSto(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
							.addComponent(getBtnDodajArtikal(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(getBtnNewButton_3(), GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(getBtnDodajSto(), GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGap(3)
						.addComponent(getBtnNewButton_3(), GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getBtnRacuni(), GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getBtnDodajArtikal(), GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(74, Short.MAX_VALUE))
			);
			panel_1.setLayout(gl_panel_1);
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel_2.setBackground(new Color(139, 69, 19));
			addPopup(panel_2, getPopupMenu());
			GroupLayout gl_panel_2 = new GroupLayout(panel_2);
			gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGap(0, 303, Short.MAX_VALUE)
			);
			gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGap(0, 224, Short.MAX_VALUE)
			);
			panel_2.setLayout(gl_panel_2);
		}
		return panel_2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Skladiste");
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("Obrisi sto");
			btnNewButton_3.setBackground(SystemColor.textHighlight);
		}
		return btnNewButton_3;
	}
	private JButton getBtnDodajSto() {
		if (btnDodajSto == null) {
			btnDodajSto = new JButton("Dodaj sto");
			btnDodajSto.addContainerListener(new ContainerAdapter() {
				
			});
			btnDodajSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
			        JButton b1 = new JButton();
			        
			        
			        b1.setSize(40,40);
			        b1.setVisible(true);
			        b1.setLocation(getMousePosition());
			        panel_2.add(b1);
			        
					
				}
			});
			btnDodajSto.setBackground(SystemColor.textHighlight);
		}
		return btnDodajSto;
	}
	private JButton getBtnRacuni() {
		if (btnRacuni == null) {
			btnRacuni = new JButton("Racuni");
			btnRacuni.setBackground(SystemColor.textHighlight);
		}
		return btnRacuni;
	}
	private JButton getBtnDodajArtikal() {
		if (btnDodajArtikal == null) {
			btnDodajArtikal = new JButton("Dodaj artikal");
			btnDodajArtikal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnDodajArtikal.setBackground(SystemColor.textHighlight);
		}
		return btnDodajArtikal;
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajSto());
		}
		return popupMenu;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JMenuItem getMntmDodajSto() {
		if (mntmDodajSto == null) {
			mntmDodajSto = new JMenuItem("Dodaj sto");
			mntmDodajSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JButton b1 = new JButton();
					b1.setSize(90,90);
			        b1.setVisible(true);
			        b1.setLocation(getMousePosition());
			        
			        panel_2.add(b1);
				}
			});
		}
		return mntmDodajSto;
	}
}
