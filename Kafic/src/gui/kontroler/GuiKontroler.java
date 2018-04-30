package gui.kontroler;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JTable;

import gui.GlavniProzorGUI;
import gui.GuiDodaj;
import gui.GuiDodajPice;
import gui.GuiStanje;

public class GuiKontroler {
	
	public static GlavniProzorGUI gp;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiKontroler.gp = new GlavniProzorGUI();
					GuiKontroler.gp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void unesiUTabelu(JTable table) {
		try (BufferedReader reader = new BufferedReader(new FileReader("lib/pice.txt"))) {

			boolean kraj = false;

			while (!kraj) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void prikaziDodajPice() {
		GuiDodajPice dodajPice = new GuiDodajPice();
		dodajPice.setLocationRelativeTo(gp);
		dodajPice.setVisible(true);
	}
	
	public static void guiDodaj() {
		
		GuiDodaj guiDodaj = new GuiDodaj();
		guiDodaj.setLocationRelativeTo(gp);
		guiDodaj.setVisible(true);
	}
	
	public static void guiStanje() {
		
		GuiStanje guiStanje =new GuiStanje();
		guiStanje.setLocationRelativeTo(gp);
		guiStanje.setVisible(true);
	}
	
	
	
}
