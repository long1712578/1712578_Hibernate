package QuanLy;

//import java.io.FileWriter;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.PreparedStatement;

public class MyConnect {
	private final static String className="com.mysql.jdbc.Driver";
	private final static String url="jdbc:mysql://localhost:3306/quanlysv";
	private final static String user="root";
	private final static String pass="";
	//private final static String tableName;
	private static Connection connection;
	
	public void connect() {
		try {
			Class.forName(className);
			connection=DriverManager.getConnection(url, user, pass);
			System.out.println("Success connect");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Class not found");
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error connect");
		}
	}
	
	public ResultSet getData(String table) {
		ResultSet rs=null;
		String sql="select * from "+table;
		Statement st;
		try {
			st=connection.createStatement();
			rs=st.executeQuery(sql);
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Select Error \n"+e.toString());
		}
		return rs;
	}
	
	
	//insert
	public static void insert(Student st,String table) throws ClassNotFoundException {
		
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName(className);
			connection=DriverManager.getConnection(url, user, pass);
			
			String sql = "insert into "+table+"(MSSV,HoTen,GioiTinh,CMND) values(?,?,?,?)";
			statement= (PreparedStatement) connection.prepareCall(sql);
			statement.setString(1, st.getMSSV());
			statement.setString(2, st.getTen());
			statement.setString(3, st.getGioiTinh());
			statement.setString(4, st.getCMND());
			
			statement.execute();
		}catch (SQLException e) {
			// TODO: handle exception
			Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, e);
			}finally {
				if(statement!=null) {
					try {
						statement.close();
					}catch (SQLException e) {
						// TODO: handle exception
						Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, e);
					}
				}
				if(connection!=null) {
					try {
						connection.close();
					}catch(SQLException e) {
						Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			}
	}
	

public static void delete(String MSSV,String table) throws ClassNotFoundException {
	
	Connection connection=null;
	PreparedStatement statement=null;
	
	try {
		Class.forName(className);
		connection=DriverManager.getConnection(url, user, pass);
		
		String sql = "delete from "+table+ " where MSSV=?";
		statement= (PreparedStatement) connection.prepareCall(sql);
		statement.setString(1, MSSV);
		
		statement.execute();
	}catch (SQLException e) {
		// TODO: handle exception
		Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, e);
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				}catch (SQLException e) {
					// TODO: handle exception
					Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, e);
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				}catch(SQLException e) {
					Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		}
}
}
