import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import com.quiz.dao.StudentDao;
import com.quiz.dao.questionDao;
import com.quiz.entities.Admin;
import com.quiz.entities.Student;

import java.io.BufferedReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws Exception {

		//BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
  
	    Scanner scan =new Scanner(System.in);

		boolean ch = true;
		while (ch) {

			System.out.println("*******************************************");

			System.out.println("PRESS 1 to signUp");
			System.out.println("PRESS 2 to UserLogin");
			System.out.println("Press 3 to adminLogin");
			System.out.println("Press 4 to display list of students");
			System.out.println("Press 5 to get studentResult ");
			System.out.println("Press 6 to exit app");

			System.out.println("*******************************************");
		
			int input = Integer.parseInt(scan.nextLine());

			switch (input) {

			case 1:
               
				System.out.println("Enter name");
				String name = scan.nextLine();

				System.out.println("Enter email");
				String email = scan.nextLine();

				System.out.println("Enter password");
				String password = scan.nextLine();

				// create student object to store student

				Student student = new Student(name, email, password);
				int i = StudentDao.insertStudentToDb(student);

				if (i==1) {
					System.out.println("You have registered successfully");
				} else {

					System.out.println("something went wrong");

				}

				//System.out.println(student);

				break;

				
			case 2:
				System.out.println("Enter your email");
				String userEmail = scan.nextLine();

				System.out.println("Enter your password");
				String userPassword = scan.nextLine();

				boolean flag = StudentDao.userLogin(userEmail, userPassword);

				if (flag) {
					System.out.println("Do you want to take a test? YES/NO");
					String y = scan.nextLine();
					
					System.out.println(StudentDao.studentScore);
					if (y.equalsIgnoreCase("yes") && (StudentDao.studentScore)==0) {
						

						questionDao.DisplayQuestions(); //display questions randomly to the console and display the result at the end  of the quiz
						
						
						int studentId = StudentDao.studentId;
						int score = questionDao.correctAnswers;
						//System.out.println(score);
						//System.out.println(studentId);
						StudentDao.saveScore(studentId, score);  //save the score in the student table
																
						
					}else {
						
						System.out.println("Sorry, you can take the exam 1 time");
					}

				}

				break;

				
			case 3:
			
				
				System.out.println("Enter your email");
				String adminEmail = scan.nextLine();

				System.out.println("Enter your password");
				String adminPassword = scan.nextLine();

				Admin.adminLogin(adminEmail, adminPassword);      //admin authentication

				break;

				
			case 4:

				StudentDao.showAllStudent();       //display student records

				break;

				
			case 5:
				System.out.println("Enter the student Id: ");
				int studentId = Integer.parseInt(scan.nextLine());
				StudentDao studentDao = new StudentDao();
				studentDao.getStudentById(studentId);       //display record of particular student
				break;
				
				
			case 6:

				ch = false;
				break;

			default:
				System.out.println("Please insert valid option");

			}

		}

	}

}
