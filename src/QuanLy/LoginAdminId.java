package QuanLy;
// Generated Jun 19, 2020, 2:16:51 AM by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LoginAdminId generated by hbm2java
 */
@Embeddable
public class LoginAdminId implements java.io.Serializable {

	private String username;
	private String pass;

	public LoginAdminId() {
	}

	public LoginAdminId(String username, String pass) {
		this.username = username;
		this.pass = pass;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "pass", nullable = false)
	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LoginAdminId))
			return false;
		LoginAdminId castOther = (LoginAdminId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this.getUsername() != null
				&& castOther.getUsername() != null && this.getUsername().equals(castOther.getUsername())))
				&& ((this.getPass() == castOther.getPass()) || (this.getPass() != null && castOther.getPass() != null
						&& this.getPass().equals(castOther.getPass())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getPass() == null ? 0 : this.getPass().hashCode());
		return result;
	}

}