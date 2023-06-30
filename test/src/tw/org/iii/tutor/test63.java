package tw.org.iii.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class test63 {

	public static void main(String[] args) {
		String mesg="Hellp,world";
		byte[] data=mesg.getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(data, data.length,InetAddress.getByName("10.0.101.123"),1111);
			socket.send(packet);
			socket.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
