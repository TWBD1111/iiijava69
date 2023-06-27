package tw.org.iii.tutor;

import java.util.LinkedList;

public class test58 {

	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<>();
		names.add(0,"Ws1");
		names.add(0,"Ws2");
		names.add(0,"Ws3");
		names.add(0,"Ws4");
		names.add(0,"Ws1");
		System.out.println(names.size());
		for (String name : names) {
			System.out.println(name);
		}
	}

}
