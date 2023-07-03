package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class jdbc03 {

	public static void main(String[] args) {
		try {
			Properties prop=new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			//Class.forName("com.mysql.cj.jdbc.Driver");可不寫
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii",prop);
			Statement stmt = conn.createStatement();
			int n = stmt.executeUpdate("insert into cust(cname,tel,birthday) values('amy','123','1999-02-01')");
			System.err.println(n);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
