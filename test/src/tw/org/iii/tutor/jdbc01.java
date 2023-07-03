package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc01 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii?user=root&password=root");
			Statement stmt = conn.createStatement();
			int n = stmt.executeUpdate("insert into cust(cname,tel,birthday) values('peter','123','1999-02-01')");
			System.err.println(n);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
