package tw.org.iii.tutor;

public class leapyear {

	public static void main(String[] args) {
		int year = 2400;
		if ((year % 4 == 0 && year % 100 != 0)||year % 400 == 0) {
			System.out.println("潤");

		} else
			System.out.println("平");
	}
}
