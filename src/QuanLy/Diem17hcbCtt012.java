package QuanLy;
// Generated Jun 19, 2020, 2:16:51 AM by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Diem17hcbCtt012 generated by hbm2java
 */
@Entity
@Table(name = "diem_17hcb_ctt012", catalog = "quanlyhs")
public class Diem17hcbCtt012 implements java.io.Serializable {

	private int stt;
	private String mssv;
	private String hoTen;
	private float diemGk;
	private float diemCk;
	private float diemKhac;
	private float diemTong;
	private String maMon;

	public Diem17hcbCtt012() {
	}

	public Diem17hcbCtt012(int stt, String mssv, String hoTen, float diemGk, float diemCk, float diemKhac,
			float diemTong, String maMon) {
		this.stt = stt;
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.diemGk = diemGk;
		this.diemCk = diemCk;
		this.diemKhac = diemKhac;
		this.diemTong = diemTong;
		this.maMon = maMon;
	}

	@Id

	@Column(name = "STT", unique = true, nullable = false)
	public int getStt() {
		return this.stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	@Column(name = "MSSV", nullable = false, length = 100)
	public String getMssv() {
		return this.mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	@Column(name = "HoTen", nullable = false)
	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	@Column(name = "DiemGK", nullable = false, precision = 12, scale = 0)
	public float getDiemGk() {
		return this.diemGk;
	}

	public void setDiemGk(float diemGk) {
		this.diemGk = diemGk;
	}

	@Column(name = "DiemCK", nullable = false, precision = 12, scale = 0)
	public float getDiemCk() {
		return this.diemCk;
	}

	public void setDiemCk(float diemCk) {
		this.diemCk = diemCk;
	}

	@Column(name = "DiemKhac", nullable = false, precision = 12, scale = 0)
	public float getDiemKhac() {
		return this.diemKhac;
	}

	public void setDiemKhac(float diemKhac) {
		this.diemKhac = diemKhac;
	}

	@Column(name = "DiemTong", nullable = false, precision = 12, scale = 0)
	public float getDiemTong() {
		return this.diemTong;
	}

	public void setDiemTong(float diemTong) {
		this.diemTong = diemTong;
	}

	@Column(name = "MaMon", nullable = false, length = 100)
	public String getMaMon() {
		return this.maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

}
