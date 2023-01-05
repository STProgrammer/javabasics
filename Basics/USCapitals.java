import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class USCapitals {
	
	static Scanner input;
	public static HashMap<String, String> capitals;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		capitals = new HashMap<>();
		
		File file;
		
		/** read data from file and put in the HashMap */
		try {
			file = new File("USCapitals.txt");
			if (!file.exists()) {
				System.out.println("File not found!");
			}
			/** Put all data intoe HashMap */
			input = new Scanner(file);
			while (input.hasNextLine()) {
				String state = input.useDelimiter(", |\n").next();
				String capital = input.useDelimiter(", |\n").next();
				capitals.put(state, capital);
			}
			input.close();
			
		} catch (FileNotFoundException e) {
			System.out.close();
		}
		
		
		/**Let the user find state capital */
		input = new Scanner(System.in);	
		while (true) {
			System.out.println("Write an US state: ");
			String state = input.nextLine();
			if (capitals.containsKey(state)) {
				System.out.printf("The capital of %s is %s \n", state,
						capitals.get(state));
			} else {
				System.out.println("No such state in USA!");
			}
		}
	}

}
