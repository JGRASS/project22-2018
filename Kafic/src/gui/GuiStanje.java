package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gui.kontroler.GuiKontroler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiStanje extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnDodaj;
	private JButton btnObrisi;
	private JButton btnIzadji;
	public static JTextField textFieldSuma;
	public static JTable tableTabela;

	

	/**
	 * Create the frame.
	 */
	public GuiStanje() {
		setTitle("Stanje stola");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.EAST);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTableTabela());
		}
		return scrollPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(15)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(getBtnObrisi(), GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
									.addComponent(getBtnDodaj(), GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
							.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(getBtnIzadji(), GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
						.addContainerGap())
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(5)
						.addComponent(getBtnDodaj())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getBtnObrisi())
						.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
						.addComponent(getBtnIzadji())
						.addContainerGap())
			);
			panel.setLayout(gl_panel);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
						.addContainerGap(224, Short.MAX_VALUE)
						.addComponent(getTextFieldSuma(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(114))
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(getTextFieldSuma(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			);
			panel_1.setLayout(gl_panel_1);
		}
		return panel_1;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GuiKontroler.guiDodaj();
				}
			});
		}
		return btnDodaj;
	}
	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi");
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					for(int i=0; i<tableTabela.getRowCount(); i++)
						for(int j=0; j<tableTabela.getColumnCount(); j++)
							tableTabela.setValueAt(null, i, j);
							
					textFieldSuma.setText("0");	
				}
			});
		}
		return btnObrisi;
	}
	private JButton getBtnIzadji() {
		if (btnIzadji == null) {
			btnIzadji = new JButton("Izadji");
			btnIzadji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					hide();
				}
			});
		}
		return btnIzadji;
	}
	private JTextField getTextFieldSuma() {
		if (textFieldSuma == null) {
			textFieldSuma = new JTextField();
			textFieldSuma.setText("0");
			textFieldSuma.setEditable(false);
			textFieldSuma.setColumns(10);
		}
		return textFieldSuma;
	}
	private JTable getTableTabela() {
		if (tableTabela == null) {
			tableTabela = new JTable();
			tableTabela.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					"Proizvod", "Cena", "Kolicina"
				}
			) {
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, Integer.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			tableTabela.getColumnModel().getColumn(0).setPreferredWidth(123);
		}
		return tableTabela;
	}
}
