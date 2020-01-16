import java.util.Scanner;

public class BeregnBMI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Programmet beregner din BMI");
		Scanner input = new Scanner(System.in);
		System.out.print("Oppgi din vekt i kilogram: ");
		double vekt = input.nextDouble();
		System.out.print("Oppgi din høyde i meter: ");
		double hoeyde = input.nextDouble();
		double bmi = vekt / Math.pow(hoeyde, 2);
		System.out.printf("Din BMI er: %.3f kg/m^2", bmi);
	}

}
