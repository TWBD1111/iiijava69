package tw.org.iii.tutor;

public class test16_1 {

	public static void main(String[] args) {
		int a0, a1, a2, a3, a4, a5, a6;
		a0 = a1 = a2 = a3 = a4 = a5 = a6 = 0;
		for (int i = 1; i <= 100; i++) {
			int point = (int) (Math.random() * 6) + 1;
			switch (point) {

			case 1:
				a1++;
				break;
			case 2:
				a2++;
				break;
			case 3:
				a3++;
				break;
			case 4:
				a4++;
				break;
			case 5:
				a5++;
				break;
			case 6:
				a6++;
				break;
			default:
				a0++;
			}

		}
		if (a0 == 0) {
			System.out.printf("1點出現%d次\n", a1);
			System.out.printf("2點出現%d次\n", a2);
			System.out.printf("3點出現%d次\n", a3);
			System.out.printf("4點出現%d次\n", a4);
			System.out.printf("5點出現%d次\n", a5);
			System.out.printf("6點出現%d次\n", a6);
		}else {
			System.out.println("XX");
		}
	}

}
