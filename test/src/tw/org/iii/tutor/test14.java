package tw.org.iii.tutor;

public class test14 {

	public static void main(String[] args) {
		final int start = 2;
		final int rows = 2;
		final int cols = 4;
		for (int k = 0; k < rows; k++) {
			for (int i = 1; i <= 9; i++) {
				for (int j = start; j <= (start+cols-1); j++) {
					int newj = j + k * cols;
					int r = i * newj;
					System.out.printf("%d * %d = %d\t", newj, i, r);
				}
				System.out.println();

			}
			System.out.println("---------");
		}
	}
}
