package packageMain;

import java.util.ArrayList;

public class ProgrammingQuestions {
	
	public String question, answer1, answer2, answer3, answer4; 
	
	public ArrayList<String> questionsProgramming = new ArrayList<String>();
	
	public ArrayList<String> answer1Programming = new ArrayList<String>();
	public ArrayList<String> answer2Programming = new ArrayList<String>();
	public ArrayList<String> answer3Programming = new ArrayList<String>();
	public ArrayList<String> answer4Programming = new ArrayList<String>();
	
	public void addQuestions(String question, String answerReceived1, String answerReceived2, String answerReceived3, String answerReceived4) {
		questionsProgramming.add(question);
		answer1Programming.add(answerReceived1);
		answer2Programming.add(answerReceived2);
		answer3Programming.add(answerReceived3);
		answer4Programming.add(answerReceived4);
	}
}
