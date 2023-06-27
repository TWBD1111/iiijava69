package tw.org.iii.tutor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import tw.org.iii.classes.Student;

public class test53 {

	public static void main(String[] args) {
		Student s1 = new Student(42, 32, 56,"Ws1");
		try (FileOutputStream fout = new FileOutputStream("dir1/student.s1");
				ObjectOutputStream oout = new ObjectOutputStream(fout);) {
			oout.writeObject(s1);
			oout.flush();
			System.out.println(s1.sum());
			System.out.println(s1.avg());
			System.out.println(s1.getName());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
