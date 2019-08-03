package packageMain;

import java.util.ArrayList;

public class MathQuestions {

	public String question, correctAnwser, answer2, answer3, answer4, explanationQuestion;

	public static ArrayList<String> questionsMath = new ArrayList<String>();
	public static ArrayList<String> correctAnswerMath = new ArrayList<String>();
	public static ArrayList<String> answer2Math = new ArrayList<String>();
	public static ArrayList<String> answer3Math = new ArrayList<String>();
	public static ArrayList<String> answer4Math = new ArrayList<String>();
	public static ArrayList<String> explanation = new ArrayList<String>();

	public void addQuestions(String question, String correctAnwser, String answerReceived2, String answerReceived3,
			String answerReceived4, String explanationQuestion) {

		questionsMath.add(question);
		correctAnswerMath.add(correctAnwser);
		answer2Math.add(answerReceived2);
		answer3Math.add(answerReceived3);
		answer4Math.add(answerReceived4);
		explanation.add(explanationQuestion);
	}
}
