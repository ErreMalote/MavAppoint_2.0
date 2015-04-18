package uta.mav.appoint.beans;

public class RegisterBean {
	private String email;
	private String password;
	private String role;
	private int student_Id;
	private int degree_type;
	private String phone_num;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public int getStudent_Id() {
		return student_Id;
	}
	
	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}
	
	public int getDegree_type() {
		return degree_type;
	}
	
	public void setDegree_type(int degree_type) {
		this.degree_type = degree_type;
	}
	
	public String getPhone_num() {
		return phone_num;
	}
	
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
}
