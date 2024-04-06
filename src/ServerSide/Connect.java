package ServerSide;

import java.sql.Connection;
import java.sql.DriverManager;
 
 
import java.sql.SQLException;
import java.sql.Statement;
 
public class Connect {
	Connection con = null;
	Statement stat = null;
	 public Statement connect() {
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			    con = DriverManager.getConnection("jdbc:mysql://localhost/vinoproject","root","");
			    stat = con.createStatement();
		 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return stat;
	 }
	
	 
}