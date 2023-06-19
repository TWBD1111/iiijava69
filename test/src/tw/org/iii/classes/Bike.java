package tw.org.iii.classes;

public class Bike {
	protected double speed;
	public String owner;
	//建構式/子/方法
	public Bike() {
		System.out.println("Bike(123)");
		
	}
	public Bike(String name) {
		System.out.println("Bike()");
		owner = name;
	}
	public void upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.2;
	}

	public void downSpeed() {
		speed = speed < 1 ? 0 : speed * 0.5;
	}
	public double getSpeed() {
		return speed;
	}
	@Override
	public String toString() {
		
		return "My speed is " + speed;
	}
}
