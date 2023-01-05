import java.util.Calendar;

public class Car extends Vehicle {
	private int power;
	java.util.Calendar productionDate;
	
	public Car() {};
	
	public Car(String name, String colour, int price,
			int model, String serialNumber,
			 int power, int direction) {
		setColour(colour);
		setName(name);
		setSerialNr(serialNumber);
		setModel(model);
		setPrice(price);
		setDirection(direction);
		setPower(power);
		setProductionDate(new java.util.GregorianCalendar());
		setBuyingDate(new java.util.GregorianCalendar());
		setSpeed(0);
	}
	
	@Override
	public void setAllFields() {
		input = new java.util.Scanner(System.in);
		System.out.println("Input car data: ");
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
		System.out.print("\nPower: ");
		setPower(input.nextInt());
		setProductionDate(new java.util.GregorianCalendar());
		setBuyingDate(new java.util.GregorianCalendar());
		setDirection(0);
		setSpeed(0);
	}
	
	/** turn left and right */
	
	@Override
	public void turnRight(int degrees) {
		if (degrees <= 0 || degrees >= 360) {
			return;
		}
		int direction = getDirection();
		direction += degrees;
		if (direction > 360) { direction -= 360; }
		if (direction < 0) { direction += 360; }
		setDirection(direction);
	}
	
	
	@Override
	public void turnLeft(int degrees) {
		if (degrees <= 0 || degrees >= 360) {
			return;
		}
		int direction = getDirection();
		direction -= degrees;
		if (direction > 360) { direction -= 360; }
		if (direction < 0) { direction += 360; }
		setDirection(direction);
	}
	
	/** end turn left and right*/
	
	@Override /** read Data */
	public void readData(java.util.Scanner in) {
		in.useDelimiter(",");
		setName(in.next());
		setSerialNr(in.next());
		setColour(in.next());
		setModel(in.nextInt());
		setPrice(in.nextInt());
		setDirection(in.nextInt());
		setSpeed(in.nextDouble());
		setPower(in.nextInt());
		setBuyingDate(new java.util.GregorianCalendar(in.nextInt(),
				in.nextInt(), in.nextInt()));
		setProductionDate(new java.util.GregorianCalendar(in.nextInt(),
				in.nextInt(), in.nextInt()));
	    System.out.println("\nVehicle read from file: ");
	    System.out.println(this);
	}
	
	
	@Override /** Writa Data*/
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
		out.print(getPower() + ",");
		out.print((getBuyingDate()).get(Calendar.YEAR) + ",");
		out.print((getBuyingDate()).get(Calendar.MONTH) + ",");
		out.print((getBuyingDate()).get(Calendar.DAY_OF_MONTH) + ",");
		out.print(productionDate.get(Calendar.YEAR) + ",");
		out.print(productionDate.get(Calendar.MONTH) + ",");
		out.print(productionDate.get(Calendar.DAY_OF_MONTH) + ",");
	    }
	    catch (Exception e) {System.exit(0);}
	    
	    System.out.println("\nVehicle written to file: ");
	    System.out.println(this);
	}
	
	@Override  /** accelerate */
	public void accelerate(double factor) {
		if (this.getSpeed() == 0) {
			if ((0.5 * factor) > Driveable.MAX_SPEED_CAR) {
				this.setSpeed(Driveable.MAX_SPEED_CAR);
			}
			else this.setSpeed((0.5 * factor));
		}
		else if ((this.getSpeed() * factor) > Driveable.MAX_SPEED_CAR) {
			this.setSpeed(Driveable.MAX_SPEED_CAR);
		}
		else {
			this.setSpeed((this.getSpeed() * factor));
		}
		System.out.printf("Car accelerated to: %.2f km/h ",
				this.getSpeed());
		System.out.println();
		return;
	}
	
	/** Breaks */
	@Override
	public void breaks(double factor) {
		this.setSpeed((this.getSpeed() / factor));
		System.out.printf("Car slowed down to: %.2f km/h ",
				this.getSpeed());
		System.out.println();
		return;
	}

	/** getters and setters */
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public java.util.Calendar getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(java.util.Calendar productionDate) {
		this.productionDate = productionDate;
	} 
	
	/** end getters and setters */
	
	@Override
	public Object clone() {
        Car cloned = (Car)super.clone();
        cloned.productionDate = 
        		(java.util.Calendar)productionDate.clone();
        return cloned;
	}
	
	@Override
	public String toString() {
		return String.format("%nName: %s %nSerialNumber: %s "
				+ "%nColour: %s %nModel: %d %nPrice: %,d "
				+ "%nDirection: %d %nSpeed: %.2f"
				+ "%nPower: %d %nProduction Date: %tF"
				+ "%nBuying Date: %tF", getName(), 
				getSerialNr(), getColour(), getModel(),
				getPrice(), getDirection(), getSpeed(), getPower(),
				getProductionDate(), getBuyingDate());
	}
	
}

