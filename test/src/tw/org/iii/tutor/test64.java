package tw.org.iii.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class test64 {

	public static void main(String[] args) {
		byte[] buf=new byte[1024];
		try {
			DatagramSocket socket = new DatagramSocket(8888);
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			socket.close();
			InetAddress urip = packet.getAddress();
			int len = packet.getLength();
			byte[] data=packet.getData();
			String mesg = new String(data,0,len);
			System.out.println(urip.getHostAddress()+":"+mesg);
//			if(mesg equals("quit")) {
//				
//			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
