package com.quiz.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.quiz.entities.Student;
import com.quiz.dao.DbConnection;

public class StudentDao {

	public static int studentId;
	public static int studentScore;
	
	// At the time of signup insert student information into student table 
	public static int insertStudentToDb(Student student) {
		int i=0;
		//boolean flag = false;
		try {

			// idbc code...
			Connection con = DbConnection.createC();

			String q = "insert into student(studentName,email,password) values(?,?,?)";
			// PreparedStatement 

			PreparedStatement preparedStatement = con.prepareStatement(q);
			preparedStatement.setString(1, student.getStudentName());
			preparedStatement.setString(2, student.getEmail());
			preparedStatement.setString(3, student.getPassword());

		i=preparedStatement.executeUpdate();
		//System.out.println(i);	

		} catch (Exception e) {

			e.printStackTrace();

		}

		return i;
	}
	

   //userLogin to see if user with entered userEmail and password is present in the db or not
	public static boolean userLogin(String email, String password) throws Exception {

		boolean flag = false;
		Connection con = DbConnection.createC();
		String query = "select * from student where email=? and password=?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet r = preparedStatement.executeQuery();

		if (r.next()) {
			System.out.println("Login successfully");

			flag = true;

		} else {
			System.out.println("Enter valid emailId and password");

		}

		studentId = r.getInt(1);
		studentScore=r.getInt(5);
		

		return flag;

	}

	//to display all the student records
	public static void showAllStudent() {

		try {

			// jdbc code...
			Connection con = DbConnection.createC();

			String q = "select * from student;";

			Statement stmt = con.createStatement();

			ResultSet set = stmt.executeQuery(q);

			while (set.next()) {

				int id = set.getInt(1);
				String name = set.getString(2);
				String email = set.getString(3);
				String score = set.getString(5);

				System.out.println("Student ID : " + id);
				System.out.println("Student Name : " + name);
				// System.out.println("Student Email : " + email);
				System.out.println("Student score : " + score);
				System.out.println("*******************************");

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	//save score of the student in the student table
	public static void saveScore(int studentId, int score) throws SQLException {

		Connection con = DbConnection.createC();
		String query = "update student set score = ? where studentId = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setLong(1, score);
		preparedStatement.setLong(2, studentId);
		preparedStatement.executeUpdate();

	}

	//student can see their result by entering their id
	public void getStudentById(int studentId) throws SQLException {

		Connection con = DbConnection.createC();
		String query = " SELECT * FROM student WHERE studentId = ?  ";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setLong(1, studentId);
		ResultSet r = preparedStatement.executeQuery();

		while (r.next()) { 
			
		    /* looping through the resultset */

			int id = r.getInt(1);
			String name = r.getString(2);
			String email = r.getString(3);
			String score = r.getString(5);

			System.out.println("Student ID : " + id);
			System.out.println("Student Name : " + name);
			System.out.println("Student Email : " + email);
			System.out.println("Student score : " + score);
			System.out.println("*******************************");
		}

	}
}
