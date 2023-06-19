package tw.org.iii.tutor;

public class test10_1 {

	public static void main(String[] args) {
		int x = (int) (Math.random() * 12) + 1;
		int y;
		switch (x) {
		case 1, 3, 5, 7, 8, 10, 12:
			y = 31;
			break;
		case 2:
			y = 28;
			break;
		case 4, 6, 9, 11:
			y = 30;
			break;
		default:
			y = 0;

		}
		System.out.printf("%d月有%d天", x, y);

	}

}
