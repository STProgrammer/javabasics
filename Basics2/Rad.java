public class Rad {
	
	private char[] seats;
	private int nrOfSeats;
	
	//Constructor 1
	public Rad() {
		this(4);
	}
	
	//Constructor with custom nr of seats
	public Rad(int nrOfSeats) {
		if (nrOfSeats > 10) {nrOfSeats = 10;}
		if (nrOfSeats < 0)  {nrOfSeats = 1;}
		this.nrOfSeats = nrOfSeats;
		seats = new char[nrOfSeats];
		char ch = 'A'; int i = 0;
		while (i < nrOfSeats) {
			seats[i++] = ch++;
		}
	} //end constructions
	
	//Check if seat is legal
	public boolean isLegalSeat(char seat) {
		seat = Character.toUpperCase(seat);
		return !('A' > seat || ('A' + nrOfSeats-1 < seat));
	} //end isLegalSeat()
	
	//Assign seat
	public boolean assignSeat(char seat) {
		seat = Character.toUpperCase(seat);
		int index = seat-'A';
		if (this.seats[index] != 'X') {
			this.seats[index] = 'X';
			return true;
		}
		else return false;
	}

	//Get number of seats in a row
	public int getNoSeatsInRow() {
		return nrOfSeats;
	} //end getNoSeatsInRow()
	
	//Print the object
	public void toString1() {
		for (char ch : seats) {
			System.out.print(ch + " ");
		}
	} //end toString()
}
