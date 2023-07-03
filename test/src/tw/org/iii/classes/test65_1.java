package tw.org.iii.classes;


import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


import javax.swing.JPanel;

public class test65_1 extends JPanel{

	public static void main(String[] args) {
		
		//String mesg= "Test By TCP";
		File imageFile = new File("dir1/4k.jpg");
		byte[] imageData = new byte[(int) imageFile.length()];
		try {
			Socket socket = new Socket(InetAddress.getByName("10.0.101.123"),9999);
			
			//OutputStream out = socket.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(imageFile));
            bis.read(imageData, 0, imageData.length);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeInt(imageData.length);
            dos.write(imageData, 0, imageData.length);
            dos.flush();
//			out.write(mesg.getBytes());
//			out.flush();
//			out.close();
			
			socket.close();
            bis.close();
            dos.close();
			System.out.println("Client OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
