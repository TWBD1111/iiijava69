package tw.org.iii.tutor;

public class test33 {

	public static void main(String[] args) {
		Car car1 = new Car();
		car1.m1();
		car1.m2();
		Car car2 = new FCar();
		car2.m1();
		car2.m2();
		FCar car3 = (FCar) car2;
		car3.m1();
		car3.m3();
		MCar car4 = new MCar();
		Car car5 = car4;
		System.out.println("-------");
		doJob(car1);
		doJob(car2);
		doJob(car4);
		System.out.println("-------");
		if (car2 instanceof Car) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}

	}
	static void doJob(Car car) {
		car.m1();
	}
}

class Car {
	void m1() {
		System.out.println("Carm1()");
	}

	void m2() {
		System.out.println("Carm2()");
	}
}

class FCar extends Car {
	void m1() {
		System.out.println("FCarm1()");
	}

	void m3() {
		System.out.println("FCarm3()");
	}
}

class MCar extends Car {
	void m1() {
		System.out.println("MCarm1()");
	}

	void m3() {
		System.out.println("MCarm3()");
	}
}