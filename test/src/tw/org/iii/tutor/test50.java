package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class test50 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileOutputStream fout = new FileOutputStream("dir2/4k2.jpg");
			FileInputStream fin = new FileInputStream("dir1/4k.jpg");
			int len;
			byte[] buf = new byte[4*1024];
			while ((len = fin.read(buf)) != -1) {
				fout.write(buf,0,len);
			}
			fin.close();
			fout.flush();
			fout.close();
			System.out.println("finish:" + (System.currentTimeMillis() - start));
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}