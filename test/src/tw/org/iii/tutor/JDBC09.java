package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC09 {

	public static void main(String[] args) {
		String sql = "SELECT * FROM foods";
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", prop);
			PreparedStatement pstmtDup = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmtDup.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s:%S\n", id, name);
			}
			if (rs.first()) {
				System.out.println("OK");
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s:%S\n", id, name);
				rs.absolute(4);
//				rs.updateString("name", "昨也小屋田大審");
//				rs.updateString("tel", "04-23334567");
//				rs.updateRow();
				//rs.deleteRow();
				rs.moveToInsertRow();
				rs.updateString("name", "不來的大餐館");
				rs.updateString("tel", "04-23335479");
				rs.insertRow();
			} else {
				System.out.println("XX");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
