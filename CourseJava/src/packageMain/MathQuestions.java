package packageMain;

import java.util.ArrayList;

public class MathQuestions {
	
	public String question, answer1, answer2, answer3, answer4; 
	
	public ArrayList<String> questionsMath = new ArrayList<String>();
	
	public ArrayList<String> answer1Math = new ArrayList<String>();
	public ArrayList<String> answer2Math = new ArrayList<String>();
	public ArrayList<String> answer3Math = new ArrayList<String>();
	public ArrayList<String> answer4Math = new ArrayList<String>();
	
	public void addQuestions(String question, String answerReceived1, String answerReceived2, String answerReceived3, String answerReceived4) {
		questionsMath.add(question);
		answer1Math.add(answerReceived1);
		answer2Math.add(answerReceived2);
		answer3Math.add(answerReceived3);
		answer4Math.add(answerReceived4);
	}
}
