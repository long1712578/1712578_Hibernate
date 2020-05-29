package QuanLy;

public class Student {
	int STT;
	String MSSV;
	String Ten;
	String GioiTinh;
	String CMND;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String mSSV, String ten, String gioiTinh, String cMND) {
		super();
		MSSV = mSSV;
		Ten = ten;
		GioiTinh = gioiTinh;
		CMND = cMND;
	}
	public Student(int stt,String mSSV, String ten, String gioiTinh, String cMND) {
		super();
		STT=stt;
		MSSV = mSSV;
		Ten = ten;
		GioiTinh = gioiTinh;
		CMND = cMND;
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
	
	public void output() {
		System.out.println("STT: "+STT +" Ten: "+ Ten);
	}
}
