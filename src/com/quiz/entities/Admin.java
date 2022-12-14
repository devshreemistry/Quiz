package com.quiz.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.quiz.dao.questionDao;


public class Admin {

	
//admin login  authentication	
	public static void adminLogin(String email,String password) throws IOException {
		String adminEmail="devashree@gmail.com";
		String adminPassword="dd";
		if((email.equals(adminEmail)) &&(password.equals(adminPassword)) ){
			
			System.out.println("you have login successfully");
			
			
			addQuestion();
			
		}else {
			System.out.println("something went wrong");
		}
		
	}
	
	
	//admin can insert 10 questions in the question table
	
	public static void addQuestion() throws IOException {
		//BufferedReader scan=new BufferedReader(new InputStreamReader (System. in)) ;
		 Scanner scan = new Scanner(System.in);
		while(true) {
			
		System.out.println("********************************************");	
		
		System.out.println("press 1 to Add  Question");
		System.out.println("press 2 to exit");
		
		System.out.println("********************************************");	
		
		int input=Integer.parseInt(scan.nextLine());
		
		
		if(input==1) {
			List listOfQuestion = questionDao.getquestions();
			
			if(listOfQuestion.size()<=10)                             //admin can add only 10  question 
			{
			//System.out.println(listOfQuestion.size());	
			System.out.println("Insert question:");
			String question=scan.nextLine();
			System.out.println("Insert option_1:");
			String option_1=scan.nextLine();
			System.out.println("Insert option_2:");
			String option_2=scan.nextLine();
			System.out.println("Insert option_3:");
			String option_3=scan.nextLine();
			System.out.println("Insert option_4:");
			String option_4=scan.nextLine();
			System.out.println("Insert answer:");
			String answer=scan.nextLine();
			
	   	Question questionObj= new Question(question,option_1,option_2,option_3,option_4,answer);
			
	    questionDao.insertQuestion(questionObj);   //save in the question table
		 
		   
			}else {
				
				System.out.println(" You have added 10 question in quiz ");
			}
			}
	
		
		if(input==2) {
			break;
			
		}
		}
	
	}
	
	
	
	
	
	
	
}
