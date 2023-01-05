import java.util.Calendar;

public abstract class Vehicle implements Comparable<Vehicle>,
Cloneable, Driveable, Fileable {
	private String colour;
	private String name;
	private String serialNr;
	private int model;
	private int price;
	private int direction;
	private double speed;
	private java.util.Calendar buyingDate;
	protected java.util.Scanner input;
	
	public Vehicle() {}
	
	public Vehicle(String name, String colour, int price,
			int model, String serialNumber, int direction) {
		setColour(colour);
		setName(name);
		setSerialNr(serialNumber);
		setModel(model);
		setPrice(price);
		setDirection(direction);
		setBuyingDate(new java.util.GregorianCalendar());
		this.speed = 0;
	}
	
	public void setAllFields() {
		input = new java.util.Scanner(System.in);
		System.out.println("Input vehicle data: ");
		System.out.print("Name: ");
		setName(input.next());
		System.out.print("\nColour: ");
		setColour(input.next());
		System.out.print("\nPrice: ");
		setPrice(input.nextInt());
		System.out.print("\nModel: ");
		setModel(input.nextInt());
		System.out.print("\nSerial #: ");
		setSerialNr(input.next());
		setBuyingDate(new java.util.GregorianCalendar());
		setDirection(0);
		setSpeed(0);
	}
	
	/** abstract methods */
	public abstract void turnLeft(int degrees);
	public abstract void turnRight(int degrees);
	
	public void stop() {
		setSpeed(0);
		System.out.println("The vehicle has stopped!");
	}
	
	/** read Data */
	public void readData(java.util.Scanner in) {
		in.useDelimiter(",");
		setName(in.next());
		setSerialNr(in.next());
		setColour(in.next());
		setModel(in.nextInt());
		setPrice(in.nextInt());
		setDirection(in.nextInt());
		setSpeed(in.nextDouble());
		setBuyingDate(new java.util.GregorianCalendar(in.nextInt(),
				in.nextInt(), in.nextInt()));
	    System.out.println("\nVehicle read from file: ");
	    System.out.println(this);
	}
	
	/** Write data */
	public void writeData(java.io.PrintWriter out) {
	    try {
	    // Write formatted output to the file
	    out.print(this.getClass().getName() + ",");
	    out.print(getName() + ",");
	    out.print(getSerialNr() + ",");
	    out.print(getColour() + ",");
		out.print(getModel() + ",");
		out.print(getPrice() + ",");
		out.print(getDirection() + ",");
		out.print(getSpeed() + ",");
		out.print((getBuyingDate()).get(Calendar.DAY_OF_MONTH) + ",");
		out.print((getBuyingDate()).get(Calendar.MONTH) + ",");
		out.print((getBuyingDate()).get(Calendar.YEAR) + ",");	
	    }
	    catch (Exception e) {System.exit(0);}
	    
	    System.out.println("\nVehicle written to file: ");
	    System.out.println(this);
	}
	
	
	/** get and set methods */
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNr() {
		return serialNr;
	}

	public void setSerialNr(String serialNumber) {
		this.serialNr = serialNumber;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public java.util.Calendar getBuyingDate() {
		return buyingDate;
	}

	public void setBuyingDate(java.util.Calendar buyingDate) {
		this.buyingDate = buyingDate;
	}
	
	/** end get and set methods */
	
	@Override
	public int compareTo(Vehicle other) {
		  if (this.getPrice() < other.getPrice()) {
			  return -1;
		  }
		  if (this.getPrice() == other.getPrice()) {
			  return 0;
		  }
		  else return 1;
	}
	
	@Override
	public Object clone() {
	    try {
	        Vehicle cloned = (Vehicle)super.clone();
	        cloned.buyingDate = (java.util.Calendar)buyingDate.clone();
	        return cloned;
	      }
	      catch (CloneNotSupportedException ex) {
	        return null;
	      }
	}
	
	/** toString method */
	public String toString() {
		return String.format("%nName: %s %nSerialNumber: %s "
				+ "%nColour: %s %nModel: %d %nPrice: %,d "
				+ "%nDirection: %d %nSpeed: %.2f", getName(), 
				getSerialNr(), getColour(), getModel(),
				getPrice(), getDirection(), getSpeed());
	}



}
