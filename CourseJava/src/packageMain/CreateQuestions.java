package packageMain;

import java.awt.Color;
import java.util.ArrayList;    
import java.util.List;

import javax.swing.*;

public class CreateQuestions {
	static JFrame mainFrame = new JFrame();
	static JPanel mainPanel = new JPanel();
	ImageIcon image = new ImageIcon(getClass().getResource("icons8-cor-48.png"));
	JLabel imageIcon = new JLabel(image);

	MainInterface classeMain = new MainInterface();

	JLabel mathLabel = new JLabel("I wanna insert a math question");
	JLabel englishLabel = new JLabel("I wanna insert a english question");
	JLabel programmingLabel = new JLabel("I wanna insert a programming question");
	
	JButton mathButton = new JButton("Add a Math question");
	JButton englishButton = new JButton("Add a english question");
	JButton programmingButton = new JButton("Add a Programming question");
	
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
	
	public void visual() {
		mainFrame.setBounds(700, 200, 500, 600);
		mainPanel.setBounds(700, 200, 500, 700);
		mainFrame.setVisible(true);
		
		mainPanel.setLayout(null);
		mainFrame.add(mainPanel);
		mainPanel.add(mathButton);
		mainPanel.add(englishButton);
		mainPanel.add(programmingButton);
		
		mainPanel.add(programmingLabel);
		mainPanel.add(mathLabel);
		mainPanel.add(englishLabel);
		mainPanel.setBackground(new Color(107,35,142));

		programmingButton.setForeground(Color.WHITE);
		programmingButton.setBackground(Color.BLACK);
		mathButton.setForeground(Color.WHITE);
		mathButton.setBackground(Color.BLACK);
		englishButton.setForeground(Color.WHITE);
		englishButton.setBackground(Color.BLACK);
		englishLabel.setForeground(Color.WHITE);
		programmingLabel.setForeground(Color.WHITE);
		mathLabel.setForeground(Color.WHITE);

		englishButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		mathButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		programmingButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		
		mathButton.setBounds(40, 180, 400, 30);
		englishButton.setBounds(40, 260, 400, 30);
		programmingButton.setBounds(40, 340, 400, 30);
		
		englishLabel.setBounds(120, 230, 400, 30);
		mathLabel.setBounds(120, 150, 400, 30);
		programmingLabel.setBounds(100, 310, 400, 30);

			
	}
	
	/*public void insert() {
		queueQuestions.add(JOptionPane.showInputDialog("Digit the question:"));
		correctAnswer.add(JOptionPane.showInputDialog("Digit the correct answer:"));
		incorrectAnswer.add(JOptionPane.showInputDialog("Digit the incorrect answer:"));
		
		JOptionPane.showMessageDialog(null, "Question sucessfully inserted!", "=)", 1);
		
		setLenght(getLenght() + 1);
		}*/
}

