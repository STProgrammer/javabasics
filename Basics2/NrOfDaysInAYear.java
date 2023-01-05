
public class NrOfDaysInAYear {

	public static void main(String[] args) {
		for (int year = 2000; year <= 2020; year++) {
			System.out.printf("Year %d has %d days. %n", year, numberOfDaysInAYear(year));
		} // end of for loop
		
	} // end of main
	
	public static int numberOfDaysInAYear(int num) {
		if (num % 4 == 0 && (num % 100 != 0 || num % 400 == 0)) {
			return 366;
		}
		else return 365;
	} // end of method
}
