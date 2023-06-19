package tw.org.iii.tutor;

import java.util.Scanner;

public class test123 {

	public static void main(String[] args) {
		 System.out.println("輸入兩數：");
		 Scanner scanner = new Scanner(System.in);
		 int x = scanner.nextInt();
		 int y = scanner.nextInt();
		 int tmp = 0;
//		 while(x % y != 0){
//		 tmp = y;
//		 y = x % y;
//		 x = tmp;
//		 }
		 
//		 for (;x % y != 0;) {
//			 tmp = y;
//			 y = x % y;
//			 x = tmp;
//		 }
		 //System.out.println(y);
	     for (int i = x; i >= 1; i--) {
	         if (x % i == 0 && y % i == 0) {
	        	 System.out.print(i);
	             break;
	         }
	     }
	}

}
