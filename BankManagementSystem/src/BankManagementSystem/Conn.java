package BankManagementSystem;

import java.sql.*;

public class Conn {
   /* 5 STEPS IN JDBC connection
    * -- Register the driver
    * -- Create Connection
    * -- Create Statement
    * -- Execute Query
    * -- Close Connection
    */
	Connection c;
	Statement s;
	public Conn() {
		//for runtime error, since mysql is external enity
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","Anuveshika1");
			s = c.createStatement();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
