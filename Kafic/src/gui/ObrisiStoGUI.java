package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.kontroler.GuiKontroler;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ObrisiStoGUI extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxRedniBroj;
	private JLabel lblRedniBrojStola;
	private JButton btnObrisi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObrisiStoGUI frame = new ObrisiStoGUI();
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
	public ObrisiStoGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(getComboBoxRedniBroj(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(91)
							.addComponent(getBtnObrisi(), GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(getLblRedniBrojStola()))
					.addContainerGap(173, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(getLblRedniBrojStola())
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(getComboBoxRedniBroj(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(getBtnObrisi()))
					.addContainerGap(195, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private JComboBox getComboBoxRedniBroj() {
		if (comboBoxRedniBroj == null) {
			comboBoxRedniBroj = new JComboBox();
			for(int i=0; i<GuiKontroler.stolovi.size();i++)
				comboBoxRedniBroj.addItem(i+1);
		}
		return comboBoxRedniBroj;
	}
	private JLabel getLblRedniBrojStola() {
		if (lblRedniBrojStola == null) {
			lblRedniBrojStola = new JLabel("Redni broj stola");
		}
		return lblRedniBrojStola;
	}
	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi");
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int broj=comboBoxRedniBroj.getSelectedIndex();
					int opcija = JOptionPane.showConfirmDialog(null, "Da li zelite da obrisete sto br. "+(broj+1)+"?", "Brisanje", JOptionPane.YES_NO_OPTION);
					if(opcija == JOptionPane.YES_OPTION) {
					
					JButton b= new JButton();
					
					b=GuiKontroler.stolovi.get(broj);
					
					GlavniProzorGUI.panel_2.remove(b);
					GuiKontroler.stolovi.remove(broj);
					GlavniProzorGUI.brojStola--;
					for(int i=0; i<GuiKontroler.stolovi.size();i++)
						GuiKontroler.stolovi.get(i).setText("Sto br. " + (i+1));
					dispose();
					}
				}
			});
		}
		return btnObrisi;
	}
}
