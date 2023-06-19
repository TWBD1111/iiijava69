package tw.org.iii.tutor;

import java.time.Year;

public class leapyear2 {

	public static void main(String[] args) {
		int year = 1700;
		if (Year.of(year).isLeap()) {
			System.out.println("潤");

		} else {
			System.out.println("平");
		}

	}

}
