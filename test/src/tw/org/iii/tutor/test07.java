package tw.org.iii.tutor;

public class test07 {

	public static void main(String[] args) {
		double temp = Math.random();
		int score = (int) (temp * 101);
		System.out.println(score);
		if (score < 60) {
			System.out.println("E");
		} else if (score < 70) {
			System.out.println("D");
		} else if (score < 80) {
			System.out.println("C");
		} else if (score < 90) {
			System.out.println("B");
		} else {
			System.out.println("A");
		}
		System.out.println("Down");
		System.out.println("Game Over");
	}

}
