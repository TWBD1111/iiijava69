package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.org.iii.classes.Student;

public class test54 {

	public static void main(String[] args) {
		try {//物件解序列化

			ObjectInputStream oin = new ObjectInputStream(
					new FileInputStream("dir1/student.s1"));
			Object obj = oin.readObject();
			if (obj instanceof Student) {
				System.out.println("OK");
			}
			Student s1=(Student)obj;
			System.out.println(s1.sum());
			System.out.println(s1.avg());
			System.out.println(s1.getName());
			oin.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
