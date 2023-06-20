package tw.org.iii.tutor;

public class test34 {

	public static void main(String[] args) {
		test341 obj1;// = new test341();抽象類別無法"直接"建立物件
		obj1 = new test342();
		
	}
}

abstract class test341 { // abstract抽象類別
	void m1() {
		System.out.println("test341:m1()");
	}

	void m2() {
		System.out.println("test341:m2()");
	}

	abstract void m3();// 抽象方法
}

class test342 extends test341 {
	void m3() {
		System.out.println("test342:m3()");
	}
}