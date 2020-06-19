package QuanLy;
// Generated Jun 19, 2020, 1:40:23 PM by Hibernate Tools 3.5.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 17hcbCtt012 generated by hbm2java
 */
@Entity
@Table(name="17hcb_ctt012"
    ,catalog="quanlyhs"
)
public class lop17hcbCtt012  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int stt;
     private String mssv;
     private String hoTen;
     private String gioiTinh;
     private String cmnd;

    public lop17hcbCtt012() {
    }

    public lop17hcbCtt012(int stt, String mssv, String hoTen, String gioiTinh, String cmnd) {
       this.stt = stt;
       this.mssv = mssv;
       this.hoTen = hoTen;
       this.gioiTinh = gioiTinh;
       this.cmnd = cmnd;
    }
   
     @Id 

    
    @Column(name="STT", unique=true, nullable=false)
    public int getStt() {
        return this.stt;
    }
    
    public void setStt(int stt) {
        this.stt = stt;
    }

    
    @Column(name="MSSV", nullable=false, length=100)
    public String getMssv() {
        return this.mssv;
    }
    
    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    
    @Column(name="HoTen", nullable=false)
    public String getHoTen() {
        return this.hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    
    @Column(name="GioiTinh", nullable=false, length=100)
    public String getGioiTinh() {
        return this.gioiTinh;
    }
    
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    
    @Column(name="CMND", nullable=false, length=100)
    public String getCmnd() {
        return this.cmnd;
    }
    
    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }




}
