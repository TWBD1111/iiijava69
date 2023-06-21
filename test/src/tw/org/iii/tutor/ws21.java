package tw.org.iii.tutor;
import tw.org.iii.classes.Bike;
public class ws21 {

	public static void main(String[] args) {
		Bike b1 = new Bike("WS1");
		b1.upSpeed();
		b1.upSpeed();
		System.out.println(b1.getSpeed());
		System.out.println(b1.owner);

		while (b1.getSpeed()<10) {
			b1.upSpeed();
		}
		System.out.println(b1.getSpeed());
	}

}
