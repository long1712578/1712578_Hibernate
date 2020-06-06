package QuanLy;

public class Date {
	String ngay;
	String thang;
	String nam;
	public Date() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date(String ngay, String thang, String nam) {
		super();
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}
	public String getNgay() {
		return ngay;
	}
	public void setNgay(String ngay) {
		this.ngay = ngay;
	}
	public String getThang() {
		return thang;
	}
	public void setThang(String thang) {
		this.thang = thang;
	}
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	public void output() {
		System.out.println("Ngay: "+ngay+" Thang: "+thang+" nam: "+nam );
	}
	
	

}
