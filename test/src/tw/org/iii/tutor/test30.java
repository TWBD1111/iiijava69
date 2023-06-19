package tw.org.iii.tutor;

import tw.org.iii.classes.TWID;

public class test30 {

	public static void main(String[] args) {
		TWID id1 = new TWID();
		TWID id2 = new TWID(false);
		TWID id3 = new TWID(5);//F
		TWID id4 = new TWID(true,2);//B
		System.out.println(id1.getID());
		System.out.println(id2.getID());
		System.out.println(id3.getID());
		System.out.println(id4.getID());
	}

}
