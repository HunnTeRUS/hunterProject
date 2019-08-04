package packageMain;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class StudyQuestion {

	// BUTTONS, VISUALS AND THE NECESSARY VARIABLES
	static JFrame mainFrame = new JFrame();
	static JPanel mainPanel = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	ImageIcon image = new ImageIcon(getClass().getResource("icons8-cor-48.png"));
	JLabel imageIcon = new JLabel(image);
	JLabel mathLabel = new JLabel("I wanna answer a math questions");
	JLabel englishLabel = new JLabel("I wanna answer a english questions");
	JLabel programmingLabel = new JLabel("I wanna answer a programming questions");
	JButton mathButton = new JButton("Answer Questions");
	JButton englishButton = new JButton("Answer Questions");
	JButton programmingButton = new JButton("Answer Questions");
	JButton returnButton = new JButton("Return to Menu");

	// THE NECESSARY OBJECTS
	MainInterface classeMain = new MainInterface();
	StudyMath quizzMath = new StudyMath();
	StudyProgramming quizzProgramming = new StudyProgramming();
	StudyEnglish quizzEnglish = new StudyEnglish();
	MathQuestions mathobj = new MathQuestions();
	ProgrammingQuestions programmingobj = new ProgrammingQuestions();
	EnglishQuestions englishobj = new EnglishQuestions();
	static CreateQuestions createobj = new CreateQuestions();

	/*
	 * JTextArea insertQuestion = new JTextArea(""); JTextArea insertCorrect = new
	 * JTextArea(); JTextArea insertIncorrect = new JTextArea();
	 * 
	 * String questionn = insertQuestion.getText(); String correctt =
	 * insertQuestion.getText(); String incorrectts = insertQuestion.getText();
	 */

	public void visual() {
		mainFrame.setBounds(700, 200, 500, 600);
		mainPanel.setBounds(700, 200, 500, 700);
		mainFrame.setVisible(true);

		mainPanel.setLayout(null);
		mainFrame.add(mainPanel);
		mainPanel.add(mathButton);
		mainPanel.add(englishButton);
		mainPanel.add(returnButton);
		mainPanel.add(programmingButton);

		mainPanel.add(programmingLabel);
		mainPanel.add(mathLabel);
		mainPanel.add(englishLabel);
		mainPanel.setBackground(new Color(107, 35, 142));

		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png")));
		programmingButton.setForeground(Color.black);
		programmingButton.setBackground(Color.WHITE);
		mathButton.setForeground(Color.black);
		mathButton.setBackground(Color.WHITE);
		englishButton.setForeground(Color.black);
		englishButton.setBackground(Color.WHITE);
		englishLabel.setForeground(Color.WHITE);
		programmingLabel.setForeground(Color.WHITE);
		mathLabel.setForeground(Color.WHITE);
		returnButton.setForeground(Color.WHITE);
		returnButton.setBackground(Color.BLACK);

		returnButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		englishButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		mathButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		programmingButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));

		mathButton.setBounds(40, 180, 400, 30);
		englishButton.setBounds(40, 260, 400, 30);
		programmingButton.setBounds(40, 340, 400, 30);
		returnButton.setBounds(135, 500, 200, 30);

		englishLabel.setBounds(130, 230, 400, 30);
		mathLabel.setBounds(130, 150, 400, 30);
		programmingLabel.setBounds(100, 310, 400, 30);

	}

	/*
	 * public void insert() {
	 * queueQuestions.add(JOptionPane.showInputDialog("Digit the question:"));
	 * correctAnswer.add(JOptionPane.showInputDialog("Digit the correct answer:"));
	 * incorrectAnswer.add(JOptionPane.showInputDialog("Digit the incorrect answer:"
	 * ));
	 * 
	 * JOptionPane.showMessageDialog(null, "Question sucessfully inserted!", "=)",
	 * 1);
	 * 
	 * setLenght(getLenght() + 1); }
	 */

	public void actions() {
		mathButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if (MathQuestions.questionsMath.size() != 0) {
					mainFrame.dispose();
					quizzMath.questionsUser();
				//} else {
				//	JOptionPane.showMessageDialog(null, "We don't have any questions to show");
				//}
			}
		});

		programmingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ProgrammingQuestions.questionsProgramming.size() != 0) {
					quizzProgramming.questionsUser();
					mainFrame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "We don't have any questions to show");
				}
			}
		});

		englishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (EnglishQuestions.questionsEnglish.size() != 0) {
					quizzEnglish.questionsUser();
					mainFrame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "We don't have any questions to show");
				}
			}
		});

		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classeMain.mainMethod();
				mainFrame.dispose();
			}
		});
	}

	public void allMethods() {
		actions();
		visual();
	}
}
