package kafic.sistemskeoperacije;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

import kafic.Pice;

public class SODodajPice {

	public static void izvrsi(LinkedList<Pice> lista, Pice pice) {
		lista.add(pice);

		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("lib/pice.txt")))) {
			writer.println(pice.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
