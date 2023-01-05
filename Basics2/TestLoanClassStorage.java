import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TestLoanClassStorage {
	
	

	public static void main(String[] args) 
			throws ClassNotFoundException, IOException {
	    // Get a Scanner and ArrayList
	    Scanner input = new Scanner(System.in);
	    ArrayList<Loan> loans = new ArrayList<Loan>();
	    String fileName = new String();
	    
	    /** Ask user to make a file*/
	  	System.out.println("Load loans from a file?");
	  	System.out.println("type '1' to answer yes, '0' to no");
	  	int answer = input.nextInt();
	    
	  	if (answer == 1) {
	  		System.out.println("Type in name of the file");
	  		fileName = input.next();
		    /** Check if file exists and read from file 
		     * if file exists */
		    
		    File file = new File(fileName);
		    if (file.exists()) {
			    try (FileInputStream fis = 
			    		new FileInputStream(fileName);
			    	ObjectInputStream oin =
			    	      new ObjectInputStream(fis);
			    	    ) {
//		    	boolean cont = true;
			    while(fis.available() != 0) {
		    		loans.add((Loan)oin.readObject());
		    	 	}  // end while loop 
			     } catch (FileNotFoundException e) {
			    	 System.out.println("File not found!");
			     } catch (ClassNotFoundException | ClassCastException ex) {
			    	 System.out.println("Class not found or not a Loan class");
			     } catch (Exception e) {
			    	 System.out.println("Something went wrong");
			     }
			    
	    	    for (Loan d: loans) {
	    	    	System.out.println(d);
	    	     }
		    }
	  	}

	    /** A loop to read loans from user and put them to 
	     * ArrayList */
	  	
	  	System.out.println("Want to add new loan?");
	  	System.out.println("type '1' to answer yes, '0' to no");
	  	answer = input.nextInt();
	  	
	  	while (answer == 1) {
		    // Enter yearly interest rate
		    System.out.print(
		      "Enter yearly interest rate, for example, 8.25: ");
		    double annualInterestRate = input.nextDouble();

		    // Enter number of years
		    System.out.print("Enter number of years as an integer: ");
		    int numberOfYears = input.nextInt();

		    // Enter loan amount
		    System.out.print("Enter loan amount, for example, "
		    		+ "120000.95: ");
		    double loanAmount =  input.nextDouble();

		    // Construct Loan object
		    loans.add(new Loan(annualInterestRate, numberOfYears,
		    		loanAmount));
		    // Display loan date, monthly payment, and total payment
		    System.out.println(loans.get(loans.size() - 1).toString());
		    
		  	System.out.println("Want to add new loan? ");
		  	System.out.println("type '1' to answer yes, '0' to no, "
		  			+ "and press enter: ");
		  	answer = input.nextInt();
		    
		}
	  	
	  	/** Write the ArrayList to a file */
	  	
	  	System.out.println("Want to save new loans on file? ");
	  	System.out.println("type '1' to answer yes, '0' to no ");
	  	answer = input.nextInt();
	  	
	  	if (answer == 1) {
	  		System.out.println("Type in name of the file: ");
	  		fileName = input.next();
		  	System.out.println("Want to save all loans "
		  			+ "or some selected on file? ");
		  	System.out.println("type '1' if you want to "
		  			+ "\nsave all, type '0' to save just some selected "
		  			+ "\nand press enter: ");
		  	answer = input.nextInt();
		  	if (answer == 1) {
			    try ( ObjectOutputStream output = new 
			    		ObjectOutputStream(new 
			    				FileOutputStream(fileName));
		    	    ) {
		    	      // Write arrays to the object output stream
			      	for(Loan l : loans) {
			      		output.writeObject(l);
				    }	
		    	      System.out.println("Loans saved on " + fileName);
		    	    } catch (FileNotFoundException e) {
		    	    	System.out.println("File not found");
		    	    }
		  	} // end if you want to save all on file
		  	else {
		  		// variables used here
		  		int index = 0;
		  		ArrayList<Loan> loans2 = new ArrayList<Loan>();
		  		int answer2 = 0;
		  		// loop to select loans */
		  		while (answer == 0) {
		  			System.out.println("Type in index");
			    	index = input.nextInt();
			    	if (index > loans.size()) {
			    		System.out.println("The index is out "
			    				+ "of of range");
			    		continue;
			    	}
			    	else {
			    		System.out.println(loans.get(index));
			    		System.out.println("Do you want to add it "
			    				+ "on file?");
					  	System.out.println("type '1' to "
					  			+ "answer yes, '0' to no, "
					  			+ "and press enter: ");
			    		answer2 = input.nextInt();
			    		if (answer2 == 1) {
			    			loans2.add(loans.get(index));
			    		}

			    		}
		    		System.out.println("Do you want to add "
		    				+ "one more to the list? ");
				  	System.out.println("type '1' to "
				  			+ "answer yes, '0' to no, "
				  			+ "and press enter: ");
		    		answer = input.nextInt() - 1;
		  		}
		  		
			    try ( ObjectOutputStream output = new 
			    		ObjectOutputStream(new 
			    				FileOutputStream(fileName));
		    	    ) {
		    	      // Write arrays to the object output stream
			      	for(Loan l : loans2) {
			      		output.writeObject(l);
				    }
		    	      System.out.println("Loans saved on " + fileName);
		    	      for (Loan l: loans2) {
		    	    	  System.out.println(l);
		    	      }
		    	    } 	
		  	} // end if you want to save on selected loans
		  		
		  } // end if you want to save on file
	  		
	  	input.close();
	  	System.out.println("Program terminated");
	}

}

