package tw.org.iii.tutor;

import java.io.File;

public class test44 {

	public static void main(String[] args) {
		File here = new File(".");
		System.out.println(here.getAbsolutePath());
		File dir1 = new File("./dir3/dir4/dir5/dir6");
		if(dir1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
			dir1.mkdirs();//mkdir"s"有s若無父目錄會自動新增
			
		}
	}

}
