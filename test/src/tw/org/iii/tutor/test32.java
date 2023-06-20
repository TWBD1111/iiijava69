package tw.org.iii.tutor;

import tw.org.iii.classes.TWID;

public class test32 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("abcdefg").append("OK").insert(2, "XX");
		System.out.println(sb);
		System.out.println("-------------");
		TWID id = TWID.newTWID("A123456789");
		if (id == null) {
			System.out.println("XX");
		} else {
			System.out.println("OK");
		}
		String s22 = new String("Brad iSpan III");
		String s23 = new String("adb");
		if(s22.contains(s23)) {
			System.out.println("OK");
		}else
			System.out.println("XX");
		
	}

}
