package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiDodajPice extends JFrame {

	private JPanel contentPane;
	private JLabel lblProizvod;
	private JTextField jtfProzivod;
	private JLabel lblCena;
	private JTextField jtfCena;
	private JButton btnDodaj;
	private JButton btnIzadji;
	
	/**
	 * Create the frame.
	 */
	public GuiDodajPice() {
		setResizable(false);
		setTitle("Dodaj pice");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 462, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblProizvod());
		contentPane.add(getJtfProzivod());
		contentPane.add(getLblCena());
		contentPane.add(getJtfCena());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnIzadji());
	}
	private JLabel getLblProizvod() {
		if (lblProizvod == null) {
			lblProizvod = new JLabel("Proizvod");
			lblProizvod.setHorizontalAlignment(SwingConstants.CENTER);
			lblProizvod.setBounds(10, 11, 209, 42);
		}
		return lblProizvod;
	}
	private JTextField getJtfProzivod() {
		if (jtfProzivod == null) {
			jtfProzivod = new JTextField();
			jtfProzivod.setHorizontalAlignment(SwingConstants.CENTER);
			jtfProzivod.setBounds(10, 55, 209, 42);
			jtfProzivod.setColumns(10);
		}
		return jtfProzivod;
	}
	private JLabel getLblCena() {
		if (lblCena == null) {
			lblCena = new JLabel("Cena");
			lblCena.setHorizontalAlignment(SwingConstants.CENTER);
			lblCena.setBounds(10, 108, 209, 42);
		}
		return lblCena;
	}
	private JTextField getJtfCena() {
		if (jtfCena == null) {
			jtfCena = new JTextField();
			jtfCena.setHorizontalAlignment(SwingConstants.CENTER);
			jtfCena.setColumns(10);
			jtfCena.setBounds(10, 152, 209, 42);
		}
		return jtfCena;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnDodaj.setBounds(294, 152, 140, 42);
		}
		return btnDodaj;
	}
	private JButton getBtnIzadji() {
		if (btnIzadji == null) {
			btnIzadji = new JButton("Izadji");
			btnIzadji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnIzadji.setBounds(294, 218, 140, 42);
		}
		return btnIzadji;
	}
}
