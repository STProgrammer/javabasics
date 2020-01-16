public class Boks {
	private int hoyde;
	private int lengde;
	private int bredde;
	
	public Boks() {
		hoyde = lengde = bredde = 1;
	}
	public Boks(int hoyde, int lengde, int bredde) {
		setDimensions(hoyde, lengde, bredde);
	}
	public void setDimensions(int hoyde, int lengde, int bredde) {
		this.hoyde = returnCorrectDimension(hoyde);
		this.lengde = returnCorrectDimension(lengde);
		this.bredde = returnCorrectDimension(bredde);
	}
	int returnCorrectDimension(int value) {
		if (value <= 0) {value = 1;}
		else if (value > 20) {value = 20;}
		return value;
	}
	
	public int getArea() {
		int area = (hoyde*bredde + hoyde*lengde + lengde*bredde)*2;
		return area;
	}
	public int getVolume() {
		int volume = lengde*bredde*hoyde;
		return volume;
	}
	public static void main(String args[]) {
		Boks b1 = new Boks(4,-1, 25);
		System.out.println(b1.getArea());
		System.out.println(b1.getVolume());
	}
	

}
