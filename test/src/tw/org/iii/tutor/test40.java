package tw.org.iii.tutor;

public class test40 {

	public static void main(String[] args) {
		Bird b1 = new Bird();
		try {
			b1.setleg(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Bird {
	int leg;

	void setleg(int n)throws Exception {
		if (n >= 0 && n <= 2) {
			leg = n;

		} else {
			throw new Exception();
		}
	}
}
