package digital_atm_systems;
import java.sql.*;

public class Connect {
	Connection con=null;
	public Statement st=null;
	public Connect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem?useSSL=false","root","root");
			st=con.createStatement();
			
			
			
			
		}catch (SQLException | ClassNotFoundException | NullPointerException e) {
			System.out.println(e);
		}
	}

}

