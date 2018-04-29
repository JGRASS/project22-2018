package kafic;

public class Pice {

	private String proizvod;
	private double cena;

	public String getProizvod() {
		return proizvod;
	}

	public void setProizvod(String proizvod) {
		if (proizvod == null || proizvod.equals(""))
			throw new RuntimeException("Prozivod ne sme biti null!");
		this.proizvod = proizvod;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		if (cena <= 0)
			throw new RuntimeException("Cena ne sme biti manja ili jednaka nuli!");
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "Pice [proizvod=" + proizvod + ", cena=" + cena + "]";
	}
	
	
}
