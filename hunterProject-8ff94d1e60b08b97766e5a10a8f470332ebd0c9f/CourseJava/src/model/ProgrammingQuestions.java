package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProgrammingQuestions {
	private String SQL;

	public String question, answer1, answer2, answer3, answer4, explanationQuestion;

	public static ArrayList<String> questionsProgramming = new ArrayList<String>();

	public static ArrayList<String> anwser0 = new ArrayList<String>();
	public static ArrayList<String> answer2Programming = new ArrayList<String>();
	public static ArrayList<String> answer3Programming = new ArrayList<String>();
	public static ArrayList<String> answer4Programming = new ArrayList<String>();
	public static ArrayList<String> explanation = new ArrayList<String>();

	public void addQuestions(String question, String correctAnswer, String answerReceived2, String answerReceived3,
			String answerReceived4, String explanationQuestion) {
		questionsProgramming.add(question);
		anwser0.add(correctAnswer);
		answer2Programming.add(answerReceived2);
		answer3Programming.add(answerReceived3);
		answer4Programming.add(answerReceived4);
		explanation.add(explanationQuestion);
		
		ConectionDB db = new ConectionDB();
		if(db.getConnection()) {
			try {
				SQL = "INSERT INTO programmingExercises (question, answer0, answer1, answer2, answer3, explanation)Values('" +
						questionsProgramming.get(questionsProgramming.size()-1) + "', '" + anwser0.get(anwser0.size()-1) + "' , '" 
						+ answer2Programming.get(answer2Programming.size()-1) + "', '" + answer3Programming.get(answer3Programming.size()-1) + "', '" 
						+ answer4Programming.get(answer2Programming.size()-1)  + "', '" + explanation.get(answer2Programming.size()-1) + "');";

				PreparedStatement stmt = db.con.prepareStatement(SQL);
				stmt.execute();

				db.close();
			}
			catch(SQLException error) {
				System.out.println("erro" + error.getMessage());
			}

		}
	}
}
