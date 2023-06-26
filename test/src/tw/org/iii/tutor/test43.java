package tw.org.iii.tutor;

import java.io.File;

public class test43 {

	public static void main(String[] args) {
		File dir1 = new File("D:\\ws1\\dir");
		if(dir1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		File dir2 = new File("D:/ws1/dir");
		if(dir2.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}

}
