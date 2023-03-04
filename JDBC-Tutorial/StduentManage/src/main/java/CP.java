import java.sql.Connection;
import java.sql.DriverManager;
public class CP {
	static Connection con;
	public static Connection createC() {
		
		try {
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//create the connection
			String user = "root";
			String password = "Admin123";
			String url = "jdbc:mysql://localhost:3306/sms";
			
			con = DriverManager.getConnection(url, user, password);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}

}
