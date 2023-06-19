package tw.org.iii.tutor;

public class test17_1 {

	public static void main(String[] args) {
		int[][] a = new int[3][];
		a[0] = new int[4];
		a[1] = new int[2];
		a[2] = new int[3];
		a[0][0] = 123;
		a[0][1] = 45;
		a[0][2] = 76;
		a[0][3] = 53;
		a[1][0] = 21;
		a[1][1] = 112;
		a[2][0] = 75;
		a[2][1] = 87;
		a[2][2] = 64;

		for (int[] v : a) {
			for (int b : v) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
		System.out.println("-----");
	}

}