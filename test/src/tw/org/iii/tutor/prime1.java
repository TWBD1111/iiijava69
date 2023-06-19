package tw.org.iii.tutor;

import java.util.Scanner;

public class prime1 {

	public static void main(String[] args) {
		int num = new Scanner(System.in).nextInt();
		int i;
		if (num == 1) {
			System.out.println("不是質數");
		}
		for (i = 2; i < num; i++) {
			if (num % i == 0) {
				System.out.println("不是質數");
				break;
			}
		}

		if (num == i) {
			System.out.println("質數");
		}

	}
}
