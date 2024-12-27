package com.studentapp;

public class Student {
	private int sid ;
	private String sname ;
	private double marks ;
	private String phone ;
	private String email ;
	private String gender ;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Student() {}
	public Student(int sid, String sname, double marks, String phone, String email, String gender) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.marks = marks;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "sid=" + sid + ", sname=" + sname + ", marks=" + marks + ", phone=" + phone + ", email="
				+ email + ", gender=" + gender ;
	}
	
}