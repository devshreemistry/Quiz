package com.quiz.entities;

public class Student {
	
	private int studentId;
	private String studentName;
	private String email;
	private String password;
	private int score;
	
	
	
	
	public Student( String studentName, String email, String password) {
		super();
		//this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
		this.password = password;
		//this.score = score;
	}
	
	
	
	public Student() {
		super();
	}
	
	
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", email=" + email + ", password="
				+ password + ", score=" + score + "]";
	}
	
	
	
	
	

}
