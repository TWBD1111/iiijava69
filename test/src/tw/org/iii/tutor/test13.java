package tw.org.iii.tutor;

public class test13 {

	public static void main(String[] args) {
		int i = 0;
		for (printtest(); i < 10; printline()) {
			System.out.println(i++);
		}
		System.out.println("Over");
	}

	static void printtest() {
		System.out.println("test1");
	}

	static void printline() {
		System.out.println("-------");
	}
}
