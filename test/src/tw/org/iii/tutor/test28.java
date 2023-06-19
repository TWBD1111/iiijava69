package tw.org.iii.tutor;

import tw.org.iii.classes.TWID;

public class test28 {

	public static void main(String[] args) {
		System.out.println(Math.random());
		System.out.println(TWID.isRightID("abc"));
		String id = "A123456789";
		if(id.matches("[A-Z][12][0-9]{8}")) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		System.out.println("---------");
		if(TWID.isRightID("A123456789")) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}

}
