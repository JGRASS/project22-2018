package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.border.LineBorder;

import gui.kontroler.GuiKontroler;

import java.awt.SystemColor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Desktop.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GlavniProzorGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	public static JPanel panel_2;
	private JButton btnMeni;
	private JButton btnRacuni;
	private JButton btnDodajArtikal;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajSto;
	private JButton btnIzadji;
	private JMenuItem mntmObrisiSto;
	public static int brojStola = 1;
	

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
			panel.add(getBtnMeni(), BorderLayout.CENTER);
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
							.addComponent(getBtnIzadji(), GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
							.addComponent(getBtnRacuni(), GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
							.addComponent(getBtnDodajArtikal(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(getBtnRacuni(), GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(getBtnDodajArtikal(), GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
						.addComponent(getBtnIzadji(), GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
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
	private JButton getBtnMeni() {
		if (btnMeni == null) {
			btnMeni = new JButton("Meni");
		}
		return btnMeni;
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
					GuiKontroler.prikaziDodajPice();
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
			popupMenu.add(getMntmObrisiSto());
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
			        b1.setText("Sto br. "+brojStola);
			        brojStola++;
			        GuiKontroler.stolovi.add(b1);
			        b1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							GuiKontroler.guiStanje();
						}
			        });

			      
			        
			        
			        
			        panel_2.add(b1);
			        
			        
				}
			});
		}
		return mntmDodajSto;
	}
	private JButton getBtnIzadji() {
		if (btnIzadji == null) {
			btnIzadji = new JButton("Izlaz");
			btnIzadji.setBackground(Color.RED);
			btnIzadji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					izlaz();
				}
			});
		}
		return btnIzadji;
	}
	
	private void izlaz() {
		int opcija = JOptionPane.showConfirmDialog(null, "Da li zelite da izadjete?", "Izlaz", JOptionPane.YES_NO_OPTION);
		if(opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	private JMenuItem getMntmObrisiSto() {
		if (mntmObrisiSto == null) {
			mntmObrisiSto = new JMenuItem("Obrisi sto");
			mntmObrisiSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					GuiKontroler.obrisiSto();
					
					
					
					
				}
			});
		}
		return mntmObrisiSto;
	}
}
