package tw.org.iii.tutor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class test56 {

	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(123);
		set.add(12.3);
		set.add(true);
		set.add("WS1");
		set.add("WS1");
		set.add(123);
		System.out.println(set.size());
		System.out.println(set);
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
	}

}
