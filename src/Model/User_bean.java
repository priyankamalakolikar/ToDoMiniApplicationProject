package Model;

import java.time.LocalDate;

public class User_bean {

	protected int id;
	protected String fname;
	protected String lname;
	protected String gender;
	protected String email;
	protected String psw;
	protected String confirm_psw;
	protected String active;
	// protected String deactive;
	private LocalDate targetDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getConfirm_psw() {
		return confirm_psw;
	}

	public void setConfirm_psw(String confirm_psw) {
		this.confirm_psw = confirm_psw;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

}
