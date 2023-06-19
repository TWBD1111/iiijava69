package tw.org.iii.tutor;

public class test10 {

	public static void main(String[] args) {
		int a = 100; 
		final int b = 10; //final只能給值一次
		switch (a) {
		case 1:
			System.out.println("A");
			break;
		case b:
			System.out.println("B");
			break;
		case 100:
			System.out.println("C");
			break;
		default:
			System.out.println("X");
			break;
		}
		System.out.println("Game Over");
	}

}
