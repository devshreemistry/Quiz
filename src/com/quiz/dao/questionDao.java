package com.quiz.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.quiz.entities.Question;
import com.quiz.entities.Student;

public class questionDao {

	public static int correctAnswers;

// save questions in the question table

	public static void insertQuestion(Question question) {

		try {

			// idbc code...
			Connection con = DbConnection.createC();

			String q = "insert into questions(question,option_1,option_2,option_3,option_4,answer) values(?,?,?,?,?,?)";
			// PreparedStatement

			PreparedStatement preparedStatement = con.prepareStatement(q);
			preparedStatement.setString(1, question.getQuestion());
			preparedStatement.setString(2, question.getOption_1());
			preparedStatement.setString(3, question.getOption_2());
			preparedStatement.setString(4, question.getOption_3());
			preparedStatement.setString(5, question.getOption_4());
			preparedStatement.setString(6, question.getAnswer());
			preparedStatement.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

//fetch all question from db and save it in list
	public static List getquestions() {

		ArrayList qlist = new ArrayList();

		try {

			// jdbc code...
			Connection con = DbConnection.createC(); // get object of Connection

			String q = "select * from questions;";

			Statement stmt = con.createStatement();

			ResultSet set = stmt.executeQuery(q);

			while (set.next()) {

				int questionId = set.getInt(1);
				String question = set.getString(2);
				String option1 = set.getString(3);
				String option2 = set.getString(4);
				String option3 = set.getString(5);
				String option4 = set.getString(6);
				String answer = set.getString(7);
				// String score=set.getString()5;

				Question addquestion = new Question(questionId, question, option1, option2, option3, option4, answer);
				qlist.add(addquestion);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return qlist;

	}

//display questions to student 
	public static void DisplayQuestions() throws Exception {
		
		List<Question> qlist = getquestions();
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		String givenAnswer;
		Collections.shuffle(qlist);                                   // shuffle all the quetions from the list
		System.out.println("--------------------------------------------------------------------------------");

		Iterator it = qlist.iterator(); // read data from list one by one
		while (it.hasNext()) {

			Question question = (Question) it.next();

			System.out.println(question.getQuestion() + "?");

			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("1)" + " " + question.getOption_1());
			System.out.println("2)" + " " + question.getOption_2());
			System.out.println("3)" + " " + question.getOption_3());
			System.out.println("4)" + " " + question.getOption_4());
			System.out.println("Enter the correctAnswer :");

			givenAnswer = scan.readLine();
			question.setGivenAnswer(givenAnswer);

		}

		result(qlist); // to display quiz result to the student

	}

	// to evaluate the quiz result
	public static void result(List<Question> listOfQuestions) {

		for (Question q : listOfQuestions) {

			if (q.getAnswer().equals(q.getGivenAnswer())) {

				correctAnswers++;

			}

		}

		if (correctAnswers < 5) {
			System.out.println("************************************************************");
			System.out.println("YOUR MARKS:" + correctAnswers + " " + "out of 10");
			System.out.println("RESULT: FAIL");
			System.out.println("************************************************************");

		} else if (correctAnswers >= 8 && correctAnswers <= 10) {

			System.out.println("************************************************************");
			System.out.println("CONGRATULATIONS!!!!!!!");
			System.out.println("YOUR MARKS:" + correctAnswers + " " + "out of 10");
			System.out.println("RESULT: CLASS A");
			System.out.println("************************************************************");

		} else if (correctAnswers >= 6 && correctAnswers <= 8) {

			System.out.println("************************************************************");
			System.out.println("CONGRATULATIONS!!!!!!!");
			System.out.println("YOUR MARKS:" + correctAnswers + " " + "out of 10");
			System.out.println("RESULT: CLASS B");
			System.out.println("************************************************************");

		} else if (correctAnswers == 5) {

			System.out.println("************************************************************");
			System.out.println("CONGRATULATIONS!!!!!!!");
			System.out.println("YOUR MARKS:" + correctAnswers + " " + "out of 10");
			System.out.println("RESULT: CLASS C");
			System.out.println("************************************************************");
		}

	}

}