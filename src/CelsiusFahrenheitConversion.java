
public class CelsiusFahrenheitConversion {

	public static void main(String[] args) {
		System.out.printf("%-15s %-15s | %-15s %-15s %n", "celsius", "fahrenheit", 
				"fahrenheit", "celsius");
		System.out.printf("-------------------------------------------------------------%n");
		double cel1 = 40;
		double fah1 = 120;
		for (int i = 1; i <= 10; cel1 -= 1, fah1 -= 10, i++) {
			System.out.printf("%-15.1f %-15.1f | %-15.1f %-15.2f %n", cel1, 
					celsiusToFahrenheit(cel1), fah1, fahrenheitToCelsius(fah1));
		} // end for-loop
		
	} // end main
	
	public static double celsiusToFahrenheit(double celsius) {
		return (9.0/5) * celsius + 32;
	}
	
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (5.0/9) * (fahrenheit - 32);
	}

}
