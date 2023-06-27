package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class test55 {

	public static void main(String[] args) {
		test553 obj = new test553();
		ObjectOutputStream oout;
		try {
			oout = new ObjectOutputStream(new FileOutputStream("dir1/test"));
			oout.writeObject(obj);
			oout.flush();
			oout.close();
			System.out.println("------------");
			ObjectInputStream ooin = new ObjectInputStream(new FileInputStream("dir1/test"));
			Object obj1 = ooin.readObject();
			ooin.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

class test551 implements Serializable{
	test551() {
		System.out.println("test551");
	}
}

class test552 extends test551 {
	test552() {
		System.out.println("test552");
	}
}

class test553 extends test552 {
	test553() {
		System.out.println("test553");
	}
}