package QuanLy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnect {
	private final String className="com.mysql.jdbc.Driver";
	private final String url="jdbc:mysql://localhost:3306/quanlysv";
	private final String user="root";
	private final String pass="";
	private final String table17hcb="17hcb";
	
	private Connection connection;
	
	private void connect() throws SQLException {
		try {
			Class.forName(className);
			connection=DriverManager.getConnection(url,user,pass);
			System.out.println("Connect success.");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.getException();
		}
	}
	private void ShowClass17HCB(ResultSet rs) {
		try {
			while(rs.next()) {
				System.out.printf("%-1d %-10s %-20s %-5s %-15s \n", rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	private ResultSet getData() {
		ResultSet rs=null;
		String sqlCMD = "select * from "+table17hcb;
		Statement st;
		try {
			st= connection.createStatement();
			rs=st.executeQuery(sqlCMD);
		} catch ( SQLException e) {
			// TODO: handle exception
			System.out.println("Select error \n"+e.toString());
		}
		return rs;
	}
	public static void main(String[] agrs) throws SQLException {
		MyConnect myconnect=new MyConnect();
		myconnect.connect();
		myconnect.ShowClass17HCB(myconnect.getData());
	}
}
