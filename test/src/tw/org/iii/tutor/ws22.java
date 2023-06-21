package tw.org.iii.tutor;

import tw.org.iii.classes.Scooter;

public class ws22 {

	public static void main(String[] args) {
		Scooter s1 = new Scooter();
		s1.upGear();
		s1.upSpeed();
		System.out.println(s1.getSpeed());
		while (s1.getSpeed()<10) {
			s1.upSpeed();
		}
		System.out.println(s1.getSpeed());
		
	}

}
