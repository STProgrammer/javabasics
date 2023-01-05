
public interface Driveable {
	double MAX_SPEED_CAR = 250;
	double MAX_SPEED_BIKE = 100;
	
	
	/**it shows "int" on UML diagram, but "double" on the 
	 * exercise text. I use double because I think it makes more
	 * sense to use double than int.*/

	void accelerate(double factor);
	void breaks(double factor);
	void stop();
	
	

}
