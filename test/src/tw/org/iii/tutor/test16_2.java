package tw.org.iii.tutor;

public class test16_2 {

	public static void main(String[] args) {
		int[] a = new int[7];
		for (int i = 1; i <= 10000; i++) {
			int point = (int) (Math.random() * 9) + 1;
			if (point >= 1 && point <= 9) {
				a[point >= 7 ? point - 3 : point]++;
			} else {
				a[0]++;
			}
		}
		if (a[0] == 0) {
			for (int i = 1; i <= 6; i++) {
				System.out.printf("%d點出現%d次\n", i, a[i]);
			}
		} else {
			System.out.println("XX");
		}
	}

}
