package tw.org.iii.tutor;

import java.io.InputStream;
import java.util.Scanner;

public class test03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("x= ");
		int x = scanner.nextInt();
		System.out.print("y= ");
		int y = scanner.nextInt();
		int r = x + y ;
		int a = x - y ;
		int b = x * y ;
		int c = x / y ;
		int d = x % y ;
		System.out.println(x + "+" + y +"=" + r);
		System.out.printf("%d + %d = %d\n",x,y,r);
		System.out.printf("%d - %d = %d\n",x,y,a);
		System.out.printf("%d * %d = %d\n",x,y,b);
		System.out.printf("%d / %d = %d...%d\n",x,y,c,d);
	}

}
