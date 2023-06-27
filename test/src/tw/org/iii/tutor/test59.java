package tw.org.iii.tutor;

import java.util.HashMap;
import java.util.Set;

public class test59 {

	public static void main(String[] args) {
		HashMap<String, Object> person = new HashMap<>();
		person.put("name", "WS1");
		person.put("gender", true);
		person.put("age", 18);
		person.put("weight", 80.123);
		System.out.println(person.get("age"));
		Set<String> keySet = person.keySet();
		for (String key : keySet) {
		    System.out.println(key+":"+person.get(key));
		}
		
	}

}
