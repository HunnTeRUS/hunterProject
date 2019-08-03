package packageMain;

import java.util.ArrayList;

public class EnglishQuestions {
	
	public String question, answer1, answer2, answer3, answer4; 
	
	public ArrayList<String> questionsEnglish = new ArrayList<String>();
	
	public ArrayList<String> answer1English = new ArrayList<String>();
	public ArrayList<String> answer2English = new ArrayList<String>();
	public ArrayList<String> answer3English = new ArrayList<String>();
	public ArrayList<String> answer4English = new ArrayList<String>();
	
	public void addQuestions(String question, String answerReceived1, String answerReceived2, String answerReceived3, String answerReceived4) {
		questionsEnglish.add(question);
		answer1English.add(answerReceived1);
		answer2English.add(answerReceived2);
		answer3English.add(answerReceived3);
		answer4English.add(answerReceived4);
	}
}
