public class TilnaermetPhi {

	public static void main(String[] args) {
		double phi = 0;
		
		for (int i = 1; i <= 100000; i++) {
			phi = phi + 4 * (Math.pow(-1, (i+1))/(2*i - 1));
			
			if (i % 10000 == 0) {
				System.out.printf("For  %,d ledd i rekken er verdien av pi: %.16f %n", i, phi);
			}
		}

	}

}
