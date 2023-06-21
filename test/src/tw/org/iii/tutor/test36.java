package tw.org.iii.tutor;

public class test36 {

	public static void main(String[] args) {
		test362 obj1 = new test362();
		test361 obj2 = new test362();
		test363 obj3 = new test362();
		
	}

}

interface test361 {// interface未標示永遠都是public
	void m1();// 介面裡的方法皆為抽象類別 所以可以不用寫

	int m2(String a);
}

class test362 implements test361, test363 {
	public void m1() {// 未加public 等於降低可見層級所以會報錯

	};

	public int m2(String a) {
		return 1;
	}

	public void m3() {
	};

	public int m4(String a) {
		return 1;
	}
}

interface test363 {
	void m3();

	int m4(String a);
}
interface test634 extends test361,test363{
	//interface在extends可以多個 class只能一個
	void m5();
}