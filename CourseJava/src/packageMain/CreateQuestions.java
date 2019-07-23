package packageMain;

import java.util.ArrayList;    
import java.util.List;

import javax.swing.*;

public class CreateQuestions {
	static JFrame mainFrame = new JFrame();
	static JPanel mainPanel = new JPanel();
	ImageIcon image = new ImageIcon(getClass().getResource("icons8-cor-48.png"));
	JLabel imageIcon = new JLabel(image);

	MainInterface classeMain = new MainInterface();

	
	JLabel labelQuestion = new JLabel("Write a question:");
	JLabel labelAnswer = new JLabel("Write a correct answer:");
	JLabel labelIncorrectAnswer = new JLabel("Write a incorrect answer:");
	JButton submit = new JButton("Submit");
	
	/*
	JTextArea insertQuestion   = new JTextArea("");
	JTextArea insertCorrect    = new JTextArea();
	JTextArea insertIncorrect  = new JTextArea();

	String questionn = insertQuestion.getText();
	String correctt = insertQuestion.getText();
	String incorrectts = insertQuestion.getText();
	*/
	
	public static List<String> queueQuestions = new ArrayList<String>();
	public static List<String> correctAnswer = new ArrayList<String>();
	public static List<String> incorrectAnswer = new ArrayList<String>();	
	public int lenght;

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public List<String> getQueueQuestions() {
		return queueQuestions;
	}

	public List<String> getCorrectAnswer() {
		return correctAnswer;
	}

	public List<String> getIncorrectAnswer() {
		return incorrectAnswer;
	}
	
	public void insert() {
		queueQuestions.add(JOptionPane.showInputDialog("Digit the question:"));
		correctAnswer.add(JOptionPane.showInputDialog("Digit the correct answer:"));
		incorrectAnswer.add(JOptionPane.showInputDialog("Digit the incorrect answer:"));
		
		JOptionPane.showMessageDialog(null, "Question sucessfully inserted!", "=)", 1);
		
		setLenght(getLenght() + 1);
		}
}

