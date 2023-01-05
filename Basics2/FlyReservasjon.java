import java.lang.reflect.Array;
import java.util.Scanner;

public class FlyReservasjon {
	
	private Rad[] rows;
	private int nrOfRows;
	
	//Constructor 1
	public FlyReservasjon() {
		this(10);
	} // end construction1()
	
	//Constructor with custom number of rows
	public FlyReservasjon(int nrOfRows) {
		if (nrOfRows > 100) {nrOfRows = 100;}
		if (nrOfRows < 1) {nrOfRows = 1;}
		rows = new Rad[nrOfRows];
		for (int i = 0; i < nrOfRows; i++) {
			rows[i] = new Rad();
		}
		this.nrOfRows = nrOfRows;
	} //end constuction2()
	
	//Check if rad is ok
	public boolean radOk(int valgtRad) {
		return (valgtRad <= rows.length  &&
				valgtRad > 0);
	} //end radOk()
	
	//Show the cabinet plan
	public void show() {
		for (int i = 0; i < rows.length; i++) {
			System.out.print((i+1) + " ");
			rows[i].toString1();
			System.out.println();
		}
	} //end show()
	
	//Get row
	public Rad getRad(int row) {
		return rows[row];
	} //end getRad()
	
	//Reserve seat
	public boolean reserveSeat(int rad, char seat) {
		if(radOk(rad)) {
			rad--;
			if(rows[rad].isLegalSeat(seat)) {
				if (rows[rad].assignSeat(seat)) {
					return true;
				} else {
					System.out.println("Seten er full"); return false;
					}
				} else {
					System.out.println("Valgt sete er ugyldig");
					return false;
				}
		} else {return false;}
	} //end reserveSeat()

	//MAIN STARTS HERE
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rad = 0; char seat = 'A';
		FlyReservasjon f1 = new FlyReservasjon();
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("Hvilken rad vil du sitte på?");
			rad = input.nextInt();
			if (rad == -1) {
				System.out.println("Takk for du brukte programmet!");
				System.exit(0);
			}
			if (!f1.radOk(rad)) {
				System.out.println("Valgt rad er ugyldig!");
				continue;
			}
			System.out.println("Hvilken sete vil du sitte paa?");
			String str = input.next();
			seat = str.charAt(0);
			System.out.println(seat);
			boolean b =  f1.reserveSeat(rad, seat);
			if(b) {f1.show();}
		} // end while loop

	} //end main
}

