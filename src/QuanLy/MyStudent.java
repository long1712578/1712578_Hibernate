package QuanLy;

public class MyStudent {
	String MaMon;
	String TenMon;
	String Phong;
	Float DiemGK;
	Float DiemCK;
	Float DiemKhac;
	Float DiemTong;
	
	
	public MyStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MyStudent(String maMon, String tenMon, String phong, Float diemGK, Float diemCK, Float diemKhac,
			Float diemTong) {
		super();
		MaMon = maMon;
		TenMon = tenMon;
		Phong = phong;
		DiemGK = diemGK;
		DiemCK = diemCK;
		DiemKhac = diemKhac;
		DiemTong = diemTong;
	}
	
	public String getMaMon() {
		return MaMon;
	}
	public void setMaMon(String maMon) {
		MaMon = maMon;
	}
	public String getTenMon() {
		return TenMon;
	}
	public void setTenMon(String tenMon) {
		TenMon = tenMon;
	}
	public String getPhong() {
		return Phong;
	}
	public void setPhong(String phong) {
		Phong = phong;
	}
	public Float getDiemGK() {
		return DiemGK;
	}
	public void setDiemGK(Float diemGK) {
		DiemGK = diemGK;
	}
	public Float getDiemCK() {
		return DiemCK;
	}
	public void setDiemCK(Float diemCK) {
		DiemCK = diemCK;
	}
	public Float getDiemKhac() {
		return DiemKhac;
	}
	public void setDiemKhac(Float diemKhac) {
		DiemKhac = diemKhac;
	}
	public Float getDiemTong() {
		return DiemTong;
	}
	public void setDiemTong(Float diemTong) {
		DiemTong = diemTong;
	}
	
	

}
