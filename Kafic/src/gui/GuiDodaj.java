package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gui.kontroler.GuiKontroler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractListModel;

public class GuiDodaj extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton btnIzadji;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiDodaj frame = new GuiDodaj();
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
	public GuiDodaj() {
		setResizable(false);
		setTitle("Dodaj");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.EAST);		
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(100, 10));
			panel.setLayout(null);
			panel.add(getBtnIzadji());
		}
		return panel;
	}
	private JButton getBtnIzadji() {
		if (btnIzadji == null) {
			btnIzadji = new JButton("Izadji");
			btnIzadji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnIzadji.setBounds(10, 217, 80, 23);
		}
		return btnIzadji;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"kola 150", "pepsi 120"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			list.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount()==2) {
						String artikal = list.getSelectedValue()+"";
						String[] niz = artikal.split(" ");
						int cena = Integer.parseInt(niz[1]);
						int suma=Integer.parseInt(GuiStanje.textFieldSuma.getText());
						
						for(int i=0; i<GuiStanje.tableTabela.getRowCount();i++)
							if((GuiStanje.tableTabela.getValueAt(i, 0)+"").equals(niz[0])) {
								int kolicina = Integer.parseInt(""+GuiStanje.tableTabela.getValueAt(i, 2));
								
								GuiStanje.tableTabela.setValueAt((kolicina+1), i, 2);
								
								GuiStanje.textFieldSuma.setText(cena+suma+"");
								
								break;
							}
							else {
								if(GuiStanje.tableTabela.getValueAt(i, 0)==null) {
									GuiStanje.tableTabela.setValueAt(niz[0], i, 0);
									GuiStanje.tableTabela.setValueAt(niz[1], i, 1);
									GuiStanje.tableTabela.setValueAt(1, i, 2);
									GuiStanje.textFieldSuma.setText(cena+suma+"");
									break;
								}
									
								
							}


								
						
						
						
					}
				}
			});
		}
		return list;
	}
}
