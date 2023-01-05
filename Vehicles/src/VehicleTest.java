/**
 * TestVehicles oppretter Bicycle og Car objekter, legger disse i et ArrayList
 * Lar bruker manipulere data i arrayet på forskjellige måter
 */

import java.util.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class VehicleTest {
  public static void main(String[] args) {
	  VehicleTest vtest = new VehicleTest();
    try {
      vtest.menuLoop();
    } catch(IOException e) {
      System.out.println("IO Exception!");
      System.exit(1);
    } catch(CloneNotSupportedException e) {
      System.out.println("CloneNotSupportedException");
      System.exit(1);
    }
  }

  private void menuLoop() throws IOException, CloneNotSupportedException {
    Scanner scan = new Scanner(System.in);
    ArrayList<Vehicle> arr=new ArrayList<Vehicle>();
    Vehicle vehicle;

/** Deleted the hard coded adds so it doesn't add same types of cars
 *  everytime
 */
        
    java.io.File file = new java.io.File("Vehicles.txt");
    try (Scanner in = new Scanner(file).useLocale(Locale.US)) {
        in.useDelimiter(",");
        while (in.hasNext()) {
            try {
                String vehClass = in.next();                
                Class veh1 = Class.forName(vehClass);
                Vehicle veh = (Vehicle)veh1.
                        getDeclaredConstructor().newInstance();
                arr.add(veh);
                veh.readData(in);
            } catch (Exception e) { 
                System.out.print("Exception");
                System.exit(0);
            }
        }
    }
    
    while(true) {
      System.out.println("1...................................New car");
      System.out.println("2...............................New bicycle");
      System.out.println("3......................Find vehicle by name");
      System.out.println("4..............Show data about all vehicles");
      System.out.println("5.......Change direction of a given vehicle");
      System.out.println("6.........................Test clone method");
      System.out.println("7..................Test driveable interface");
      System.out.println("8..............................Exit program");
      System.out.println("...............................Your choice?");
      int choice = scan.nextInt();
      String name;

      switch (choice) {
      case 1:
    	  vehicle = new Car();
        try {
            vehicle.setAllFields();
          } catch(Exception e) {
            System.out.println("Wrong input!");
            System.exit(1);
          }
        arr.add(vehicle);
        break;
      case 2:
    	vehicle = new Bicycle();
        try {
            vehicle.setAllFields();
          } catch(Exception e) {
            System.out.println("Wrong input!");
            System.exit(1);
          }
        arr.add(vehicle);
        break;
      case 3:
    	System.out.println("Name of vehicle: ");
    	name = scan.next();
    	for(Vehicle v : arr) {
    		if(v.getName() != null && 
    				(v.getName().compareToIgnoreCase(name) == 0)) {
    	        		System.out.println(v);
    		}
    	}
        break;
      case 4:
      	for(Vehicle v : arr) {
    	        System.out.println(v);
    	    }
        break;
      case 5:
      	System.out.println("Name of vehicle: ");
      	name = scan.next();
      	char dir;
      	int degree;
      	for(Vehicle v : arr) {
      		if(v.getName() != null && 
      				(v.getName().compareToIgnoreCase(name) == 0)) {
      			System.out.print("\nDirection [R/L]: ");
      			dir = scan.next().charAt(0);
      			System.out.print("\nDegrees [0-360]: ");
      			degree = scan.nextInt();
      			if (dir == 'L') { v.turnLeft(degree); }
      			if (dir == 'R') {v.turnRight(degree); }
      		}
      	}
        break;
      case 6:
    	  Car car1 = new Car("A bad car","red",100000,1999,"A111",350,0);
    	  Car car2 = (Car)car1.clone();
    	  car2.getBuyingDate().set(2003, 1, 2);
    	  car2.getProductionDate().set(2003, 5, 5);
    	  System.out.println("Date objects are separate, deep copy");
    	  System.out.printf("%n %tF", car1.getBuyingDate());
    	  System.out.printf("%n %tF %n", car2.getBuyingDate());
    	  System.out.printf("Production date car2 edited: "
    	  		+ "%n %tF %n", car2.getProductionDate());
    	  break;
      case 7:
    	  Car carTest = new Car("Test car","red",100000,1999,
    			  "A111",350,0);
    	  Bicycle bicycleTest = 
    			  new Bicycle("Test bicycle","red",100000,
    					  1999,"A111",15,0);
    	  carTest.accelerate(3);
    	  carTest.accelerate(250);
    	  bicycleTest.accelerate(5);
    	  bicycleTest.accelerate(200);
    	  carTest.breaks(100);
    	  bicycleTest.breaks(50);
    	  carTest.stop();
    	  bicycleTest.stop();
    	  break;
      case 8:
		java.io.PrintWriter output = new java.io.PrintWriter(file);
      	for(Vehicle v : arr) {
	        v.writeData(output);
	    }		
		scan.close();
		output.close();
		System.exit(0);
      default:
        System.out.println("Wrong input!");
      }
    }
  }
}

