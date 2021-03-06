package QuanLy;
// Generated Jun 19, 2020, 2:16:51 AM by Hibernate Tools 3.5.0.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Lop18hcb generated by hbm2java
 */
@Entity
@Table(name = "lop18hcb", catalog = "quanlyhs")
public class Lop18hcb implements java.io.Serializable {

	private Lop18hcbId id;

	public Lop18hcb() {
	}

	public Lop18hcb(Lop18hcbId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "stt", column = @Column(name = "STT", nullable = false)),
			@AttributeOverride(name = "mssv", column = @Column(name = "MSSV", nullable = false, length = 100)),
			@AttributeOverride(name = "hoTen", column = @Column(name = "HoTen", nullable = false)),
			@AttributeOverride(name = "gioiTinh", column = @Column(name = "GioiTinh", nullable = false, length = 100)),
			@AttributeOverride(name = "cmnd", column = @Column(name = "CMND", nullable = false, length = 100)),
			@AttributeOverride(name = "maLop", column = @Column(name = "MaLop", nullable = false, length = 100)) })
	public Lop18hcbId getId() {
		return this.id;
	}

	public void setId(Lop18hcbId id) {
		this.id = id;
	}

}
