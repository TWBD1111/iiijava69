package tw.org.iii.tutor;

public class test閏年 {
	public static void main(String[] args) {
//		double year = Math.random();
//		int score = (int) (year * 2000);
		int score = 1900; 
		System.out.println(score);
		if (score % 4 != 0) {
			System.out.println("平年365天");
		} else if (score % 100 != 0) {
			System.out.println("閏年366天");
		} else if (score % 400 != 0) {
			System.out.println("平年365天");
		} else {
			System.out.println("閏年366天");
		}

	}

}
