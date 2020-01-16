public class Clock {
	private int hours = 0;
	private int minutes = 0;
	private int seconds = 0;
	public void setTime(int h, int m, int s) {
		hours = h;
		minutes = m;
		seconds = s;
	}
	public int incrementSeconds() {
		seconds++;
		if (seconds == 60) {
			seconds = 0;
			minutes++;
		}
		if (minutes == 60) {
			minutes = 0;
			hours++;
		}
		if (hours == 24)
			hours = minutes = seconds = 0;
		return (hours * 60 * 60) + (minutes * 60) + seconds;
	}
	public int incrementMinutes() {
		minutes++;
		if (minutes == 60) {
			minutes = 0;
			hours++;
		}
		if (hours == 24)
			hours = minutes = seconds = 0;
		return (hours * 60 * 60) + (minutes * 60) + seconds;
	}
	public int incrementHours() {
		hours++;
		if (hours == 24)
			hours = minutes = seconds = 0;
		return (hours * 60 * 60) + (minutes * 60) + seconds;
	}
	public String getTimeAsString() {
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
}