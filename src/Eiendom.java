
public class Eiendom {
	private String adresse;
	private int antallRom;
	private int antallKvm;
	private double[]bud = new double[20];
	private static int antEiendom = 0;
	private int antBud = 0;
	
	public Eiendom(String adresse, int antallRom, int antallKvm) {
		this.adresse = adresse;
		this.antallRom = antallRom;
		this.antallKvm = antallKvm;
		antEiendom++;
	}
	
	void nyttBud(double budBelop) {
		if (antBud <= 0) {
			bud[0] = budBelop;
			antBud++;
			return;
		}
		if (budBelop > bud[antBud-1]) {
			bud[antBud] = budBelop; antBud++;
		} else { 
			System.out.printf("Bud er ikke hoey nok. Hoeyeste"
					+ " bud er %,.0f kroner %n", bud[antBud-1]);
			return;
		}
		if(antBud >= bud.length) {
			double[]temp = new double[2*bud.length];
			for(int i = 0; i < antBud; i++) {
				temp[i] = bud[i];
			}
			bud = temp;
		}
		
	}
	public void skrivEiendom() {
		System.out.printf("Adresse : %s%n"
				+ "Antall rom : %d%n"
				+ "Antall kvm : %d%n"
				+ "Følgende bud gitt: %n", adresse,
				antallRom, antallKvm);
		for(int i = 0; i < antBud; i++) {
			System.out.printf("%,.0f kroner %n", bud[i]);
		}
	}
	public static int getAntallEiendommer() { return antEiendom;}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Eiendom e1 = new Eiendom("Abd gata", 4, 200);
		Eiendom e2 = new Eiendom("Konge gata", 40, 8000);
		e1.nyttBud(4000000);
		e2.nyttBud(35000000);
		e1.nyttBud(3500000);
		e2.nyttBud(65000000);
		e1.skrivEiendom();
		e2.skrivEiendom();
		System.out.println(getAntallEiendommer());

	}

}
