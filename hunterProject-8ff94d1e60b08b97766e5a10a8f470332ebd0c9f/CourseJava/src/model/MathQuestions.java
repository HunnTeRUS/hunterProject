package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MathQuestions {

	public String question, correctAnwser, answer2, answer3, answer4, explanationQuestion;

	private String SQL;

	public static ArrayList<String> questionsMath = new ArrayList<String>();
	public static ArrayList<String> anwser0 = new ArrayList<String>();
	public static ArrayList<String> answer2Math = new ArrayList<String>();
	public static ArrayList<String> answer3Math = new ArrayList<String>();
	public static ArrayList<String> answer4Math = new ArrayList<String>();
	public static ArrayList<String> explanation = new ArrayList<String>();

	ConectionDB db = new ConectionDB();

	public void addQuestions(String question, String correctAnwser, String answerReceived2, String answerReceived3,
			String answerReceived4, String explanationQuestion) {

		questionsMath.add(question);
		anwser0.add(correctAnwser);
		answer2Math.add(answerReceived2);
		answer3Math.add(answerReceived3);
		answer4Math.add(answerReceived4);
		explanation.add(explanationQuestion);


		if(db.getConnection()) {
			try {
				SQL = "INSERT INTO mathExercises (question, answer0, answer1, answer2, answer3, explanation)Values('" +
						questionsMath.get(questionsMath.size()-1) + "', '" + anwser0.get(anwser0.size()-1) + "' , '" 
						+ answer2Math.get(answer2Math.size()-1) + "', '" + answer3Math.get(answer3Math.size()-1) + "', '" 
						+ answer4Math.get(answer2Math.size()-1)  + "', '" + explanation.get(answer2Math.size()-1) + "');";

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
