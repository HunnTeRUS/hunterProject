package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnglishQuestions {

	public String question, answer1, answer2, answer3, answer4, explanationQuestion;
	private String SQL;
	
	public static ArrayList<String> questionsEnglish = new ArrayList<String>();
	public static ArrayList<String> anwser0 = new ArrayList<String>();
	public static ArrayList<String> answer2English = new ArrayList<String>();
	public static ArrayList<String> answer3English = new ArrayList<String>();
	public static ArrayList<String> answer4English = new ArrayList<String>();
	public static ArrayList<String> explanation = new ArrayList<String>();

	public void addQuestions(String question, String  correctAnwser, String answerReceived2, String answerReceived3,
			String answerReceived4, String explanationQuestion) {
		questionsEnglish.add(question);
		anwser0.add(correctAnwser);
		answer2English.add(answerReceived2);
		answer3English.add(answerReceived3);
		answer4English.add(answerReceived4);
		explanation.add(explanationQuestion);
		
		ConectionDB db = new ConectionDB();
		if(db.getConnection()) {
			try {
				SQL = "INSERT INTO englishExercises (question, answer0, answer1, answer2, answer3, explanation)Values('" +
						questionsEnglish.get(questionsEnglish.size()-1) + "', '" + anwser0.get(anwser0.size()-1) + "' , '" 
						+ answer2English.get(answer2English.size()-1) + "', '" + answer3English.get(answer3English.size()-1) + "', '" 
						+ answer4English.get(answer2English.size()-1)  + "', '" + explanation.get(answer2English.size()-1) + "');";

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
