package tw.org.iii.tutor;

import java.util.Scanner;

public class test18 {

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		int a = 1;
		int sum = 0;
		while (a <= n) {
			sum += a++;

		}
		System.out.printf("1+2+3...+%d=%d",n,sum);
	}

}
