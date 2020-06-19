package QuanLy;

public class Student {
	int STT;
	String MSSV;
	String Ten;
	String GioiTinh;
	String CMND;
	String MaMon;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String mSSV, String ten, String gioiTinh, String cMND,String maMon) {
		super();
		MSSV = mSSV;
		Ten = ten;
		GioiTinh = gioiTinh;
		CMND = cMND;
		MaMon=maMon;
	}
	public Student(int stt,String mSSV, String ten, String gioiTinh, String cMND,String maMon) {
		super();
		STT=stt;
		MSSV = mSSV;
		Ten = ten;
		GioiTinh = gioiTinh;
		CMND = cMND;
		MaMon=maMon;
	}
	public int getSTT() {
		return STT;
	}
	public void setSTT(int sTT) {
		STT = sTT;
	}
	public String getMSSV() {
		return MSSV;
	}
	public String getMaMon() {
		return MaMon;
	}
	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public void setMaMon(String maMon) {
		MaMon=maMon;
	}
	
	public void output() {
		System.out.println("STT: "+STT +" Ten: "+ Ten);
	}
}
