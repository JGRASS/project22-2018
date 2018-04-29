package gui.kontroler;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JTable;

public class GuiKontroler {

	public static void unesiUTabelu(JTable table) {
		try (BufferedReader reader = new BufferedReader(new FileReader("lib/pice.txt"))) {

			boolean kraj = false;

			while (!kraj) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
