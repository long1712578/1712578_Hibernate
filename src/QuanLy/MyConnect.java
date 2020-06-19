package QuanLy;

//import java.io.FileWriter;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.PreparedStatement;

public class MyConnect {
	private final static String className="com.mysql.jdbc.Driver";
	private final static String url="jdbc:mysql://localhost:3306/quanlyhs";
	private final static String user="root";
	private final static String pass="";
	//private final static String tableName;
	private static Connection connection;
	
	public void connect() {
		try {
			Class.forName(className);
			connection=DriverManager.getConnection(url, user, pass);
			//System.out.println("Success connect");
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
			
			String sql = "insert into "+table+"(STT,MSSV,HoTen,GioiTinh,CMND,MaLop) values(?,?,?,?,?,?)";
			statement= (PreparedStatement) connection.prepareCall(sql);
			statement.setInt(1,st.getSTT());
			statement.setString(2, st.getMSSV());
			statement.setString(3, st.getTen());
			statement.setString(4, st.getGioiTinh());
			statement.setString(5, st.getCMND());
			statement.setString(6, st.getMaMon());
			
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
public static void insertSubject(Student st,String table) throws ClassNotFoundException {
		
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName(className);
			connection=DriverManager.getConnection(url, user, pass);
			
			String sql = "insert into "+table+"(STT,MSSV,HoTen,GioiTinh,CMND) values(?,?,?,?,?)";
			statement= (PreparedStatement) connection.prepareCall(sql);
			statement.setInt(1,st.getSTT());
			statement.setString(2, st.getMSSV());
			statement.setString(3, st.getTen());
			statement.setString(4, st.getGioiTinh());
			statement.setString(5, st.getCMND());
			
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
	//insert import
public static void insertImportPoint(String sTT,String MSSV,String Ten,String diemGK,String diemCK,String diemKhac,String diemTong,String maMon, String table) throws ClassNotFoundException {
		
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName(className);
			connection=DriverManager.getConnection(url, user, pass);
			int stt=Integer.valueOf(sTT);
			Float diemgk=Float.valueOf(diemGK);
			Float diemkhac=Float.valueOf(diemKhac);
			Float diemck=Float.valueOf(diemCK);
			Float diemtong=Float.valueOf(diemTong);
			String sql = "insert into "+table+"(STT,MSSV,HoTen,DiemGK,DiemCK,DiemKhac,DiemTong,MaMon) values(?,?,?,?,?,?,?,?)";
			statement= (PreparedStatement) connection.prepareCall(sql);
			statement.setInt(1, stt);
			statement.setString(2,MSSV);
			statement.setString(3,Ten);
			statement.setFloat(4, diemgk);
			statement.setFloat(5, diemck);
			statement.setFloat(6, diemkhac);
			statement.setFloat(7, diemtong);
			statement.setString(8, maMon);
			
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
public static void insertTKB(String maMon,String tenMon,String phongHoc, String maLop,String table) throws ClassNotFoundException {
	Connection connection=null;
	PreparedStatement statement=null;
	
	try {
		Class.forName(className);
		connection=DriverManager.getConnection(url, user, pass);
		String sql = "insert into "+table+"(STT,MaMon,TenMon,PhongHoc,MaLop) values(null,?,?,?,?)";
		statement= (PreparedStatement) connection.prepareCall(sql);
		statement.setString(1, maMon);
		statement.setString(2,tenMon);
		statement.setString(3,phongHoc);
		statement.setString(4, maLop);
		
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
	//insert date_phuc khao
public static void insertDate(String MaLop,Date NgayBD,Date NgayKT) throws ClassNotFoundException {
		
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName(className);
			connection=DriverManager.getConnection(url, user, pass);
			String ngay1=NgayBD.getNgay()+"-"+NgayBD.getThang()+"-"+NgayBD.getNam();
			String ngay2=NgayKT.getNgay()+"-"+NgayKT.getThang()+"-"+NgayKT.getNam();
			String sql = "insert into ngay_phuckhao(MaMon,NgayBD,NgayKT) values(?,?,?)";
			statement= (PreparedStatement) connection.prepareCall(sql);
			statement.setString(1, MaLop);
			statement.setString(2, ngay1);
			statement.setString(3, ngay2);
			
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

//insert thong tin phuc khao cua sinh vien
public static void insertInformation(String mssv,String ten,String maMon,String cotDiem,Float diem,String liDo) throws ClassNotFoundException {
	
	Connection connection=null;
	PreparedStatement statement=null;
	
	try {
		Class.forName(className);
		connection=DriverManager.getConnection(url, user, pass);
		
		String sql = "insert into thongtin_phuckhao(MSSV,HoTen,MaMon,CotDiem,DiemMuon,LiDo,TrangThai) values(?,?,?,?,?,?,0)";
		statement= (PreparedStatement) connection.prepareCall(sql);
		statement.setString(1, mssv);
		statement.setString(2, ten);
		statement.setString(3, maMon);
		statement.setString(4, cotDiem);
		statement.setFloat(5, diem);
		statement.setString(6, liDo);
		
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

public static void Update(float gk,float ck, float khac,float tong,String mssv,String table) throws ClassNotFoundException {
	
	Connection connection=null;
	PreparedStatement statement=null;
	
	try {
		Class.forName(className);
		connection=DriverManager.getConnection(url, user, pass);
		
		String sql = "update "+table+ " set DiemGK=?,DiemCK=?,DiemKhac=?,DiemTong=? where MSSV=?";
		statement= (PreparedStatement) connection.prepareCall(sql);
		statement.setFloat(1, gk);
		statement.setFloat(2, ck);
		statement.setFloat(3, khac);
		statement.setFloat(4, tong);
		statement.setString(5, mssv);
		statement.execute();
	}catch (SQLException e) {
		// TODO: handle exception
		System.out.println("ERRoR SqL");
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
	public static void updataPass(String tk,String newPass) throws ClassNotFoundException {
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName(className);
			connection=DriverManager.getConnection(url, user, pass);
			
			String sql = "update login_student set pass=?  where username=?";
			statement= (PreparedStatement) connection.prepareCall(sql);
			statement.setString(1, newPass);
			statement.setString(2, tk);
			statement.execute();
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("ERRoR SqL");
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
	public static void updataPassAdmin(String newPass) throws ClassNotFoundException {
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName(className);
			connection=DriverManager.getConnection(url, user, pass);
			
			String sql = "update login_admin set pass=?  where username='giaovu'";
			statement= (PreparedStatement) connection.prepareCall(sql);
			statement.setString(1, newPass);
			statement.execute();
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("ERRoR SqL");
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
	public static void updataStatus1(String mssv,String maMon,String cotDiem) throws ClassNotFoundException {
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName(className);
			connection=DriverManager.getConnection(url, user, pass);
			
			String sql = "update thongtin_phuckhao set TrangThai=1 where MSSV=? and MaMon=? and CotDiem=?";
			statement= (PreparedStatement) connection.prepareCall(sql);
			statement.setString(1, mssv);
			statement.setString(2, maMon);
			statement.setString(3, cotDiem);
			statement.execute();
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("ERRoR SqL");
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
	
	public static void updataStatus2(String mssv,String maMon,String cotDiem) throws ClassNotFoundException {
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName(className);
			connection=DriverManager.getConnection(url, user, pass);
			
			String sql = "update thongtin_phuckhao set TrangThai=2 where MSSV=? and MaMon=? and CotDiem=?";
			statement= (PreparedStatement) connection.prepareCall(sql);
			statement.setString(1, mssv);
			statement.setString(2, maMon);
			statement.setString(3, cotDiem);
			statement.execute();
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("ERRoR SqL");
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
	public static void updataPoint(String mssv,String maMon,String cotDiem,String diem) throws ClassNotFoundException {
		Connection connection=null;
		PreparedStatement statement=null;
		Float diemMuon=Float.parseFloat(diem);
		try {
			Class.forName(className);
			connection=DriverManager.getConnection(url, user, pass);
			//Bang diem_18hcb_ctt001
			if(maMon.equals("CTT001")) {
				String sql = "update diem_18hcb_ctt001 set "+ cotDiem +" =? where MSSV=?";
				statement= (PreparedStatement) connection.prepareCall(sql);
				statement.setFloat(1, diemMuon);
				statement.setString(2, mssv);
				statement.execute();
			}else if(maMon.equals("CTT002")) {
				String sql = "update diem_18hcb_ctt002 set "+ cotDiem +" =? where MSSV=?";
				statement= (PreparedStatement) connection.prepareCall(sql);
				statement.setFloat(1, diemMuon);
				statement.setString(2, mssv);
				statement.execute();
			}else if(maMon.equals("CTT011")) {
				String sql = "update diem_17hcb_ctt011 set "+ cotDiem +" =? where MSSV=?";
				statement= (PreparedStatement) connection.prepareCall(sql);
				statement.setFloat(1, diemMuon);
				statement.setString(2, mssv);
				statement.execute();
			}else {
				String sql = "update diem_17hcb_ctt012 set "+ cotDiem +" =? where MSSV=?";
				statement= (PreparedStatement) connection.prepareCall(sql);
				statement.setFloat(1, diemMuon);
				statement.setString(2, mssv);
				statement.execute();
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("ERRoR SqL");
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
