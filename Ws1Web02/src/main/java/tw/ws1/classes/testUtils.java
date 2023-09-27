package tw.ws1.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class testUtils {

	public static String loadView(String view) throws Exception {
		String viewFile = String.format("C:\\Users\\User\\eclipse-workspace\\Ws1Web02\\src\\main\\webapp\\%s.html",
				view);
		File file = new File(viewFile);
//		byte[] buf = new byte[(int)file.length()];
//		FileInputStream fin =new FileInputStream(file);
//		fin.read(buf);
//		fin.close();
//			
//		return new String(buf);

		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();

	}

	public static String sayYa() {
		return "Ya";
	}

	public static String sayYa(String name) {

		return String.format("Ya! %s", name);
	}

	public static String calc(String x, String y, String op) {
		try {

			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			int r, mod;
			r = mod = 0;
			String ret = "";
			switch (op) {
			case "1":
				r = intX + intY;
				ret += r;
				break;
			case "2":
				r = intX - intY;
				ret += r;
				break;
			case "3":
				r = intX * intY;
				ret += r;
				break;
			case "4":
				r = intX / intY;
				mod = intX % intY;
				ret += r + "...." + mod;
				break;

			}
			return ret;

		} catch (Exception e) {
			return "";

		}
	}

	public static Member createMember() {
		return new Member(123, "iii", "III", "1988-08-07");
	}

	public static String createScore() {
		int socre = (int) (Math.random() * 100) + 1;
		return socre + "";
	}

	public static int prevPage(String page) {
		int p = Integer.parseInt(page);
		if (p > 1)
			p--;
		return p;
	}

	public static int nextPage(String page, String pages) {
		int ps = (int) Double.parseDouble(pages);
		int p = Integer.parseInt(page);
		if (p < ps)
			p++;

		return p;
	}

}
