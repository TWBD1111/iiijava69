package tw.org.iii.tutor;

public class tset39 {

	public static void main(String[] args) {
		int a = 10, b = 10;
		int[] c = new int[4];
		
		try {
			System.out.println(a / b);
			System.out.println("OK");
			System.out.println(c[100]);
		} catch (ArithmeticException e) {
			System.out.println("捕捉到錯誤ArithmeticException");//多重捕捉
		} catch (RuntimeException e) {
			System.out.println("捕捉到ArrayIndexOutOfBoundsException");
		}

	}

}
