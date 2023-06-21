package tw.org.iii.tutor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.InterruptedByTimeoutException;
import java.nio.file.FileAlreadyExistsException;

public class test41 {

	public static void main(String[] args) {
		test411 obj = new test411();
		
	}

}
class test411{
	void m1() throws Exception{
		m2();
	}
	void m2() throws InterruptedException{
		try {
		m3(3);
		}catch(IOException e) {
			
		}
	}
	void m3(int a)throws IOException,InterruptedException {
		if(a==1) {
			throw new IOException();
		}else if (a==2) {
			throw new InterruptedException();
		}else if (a==3) {
			throw new FileNotFoundException();
		}
	}
}
