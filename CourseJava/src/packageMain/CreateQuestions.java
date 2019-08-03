package packageMain;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CreateQuestions {

	// BUTTONS, VISUALS AND THE NECESSARY VARIABLES
	static JFrame mainFrame = new JFrame();
	static JPanel mainPanel = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	ImageIcon image = new ImageIcon(getClass().getResource("icons8-cor-48.png"));
	JLabel imageIcon = new JLabel(image);
	JLabel mathLabel = new JLabel("I wanna insert a math question");
	JLabel englishLabel = new JLabel("I wanna insert a english question");
	JLabel programmingLabel = new JLabel("I wanna insert a programming question");
	JButton mathButton = new JButton("Add a Math question");
	JButton englishButton = new JButton("Add a english question");
	JButton programmingButton = new JButton("Add a Programming question");

	private String question, anwser1, anwser2, anwser3, anwser4, explanation, correctAnwser;
	public boolean mathQuizz, englishQuizz, programmingQuizz;

	// THE NECESSARY OBJECTS
	MainInterface classeMain = new MainInterface();
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

	public int lenght;

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
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
		mainPanel.setBackground(new Color(107, 35, 142));

		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png")));
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

	public void switchCorrectAnwser() {
		JPanel panel2 = new JPanel();
		JLabel labelSwitch = new JLabel("What the correct awnser?");
		JButton button1 = new JButton(anwser1);
		JButton button2 = new JButton(anwser2);
		JButton button3 = new JButton(anwser3);
		JButton button4 = new JButton(anwser4);

		mainPanel.setVisible(false);
		panel2.setBounds(700, 200, 500, 700);
		panel2.setBackground(new Color(107, 35, 142));
		mainFrame.add(panel2);
		panel2.add(labelSwitch);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.setLayout(null);

		labelSwitch.setForeground(Color.white);
		labelSwitch.setBounds(160, 100, 400, 30);

		button1.setBounds(40, 180, 400, 30);
		button2.setBounds(40, 260, 400, 30);
		button3.setBounds(40, 340, 400, 30);
		button4.setBounds(40, 420, 400, 30);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				correctAnwser = anwser1;
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setEnabled(false);
				button4.setEnabled(false);
				panel2.setVisible(false);
				explanationQuestion();
			}
		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				correctAnwser = anwser2;
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setEnabled(false);
				button4.setEnabled(false);
				panel2.setVisible(false);
				explanationQuestion();
			}
		});

		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				correctAnwser = anwser3;
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setEnabled(false);
				button4.setEnabled(false);
				panel2.setVisible(false);
				explanationQuestion();
			}
		});

		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				correctAnwser = anwser4;
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setEnabled(false);
				button4.setEnabled(false);
				panel2.setVisible(false);
				explanationQuestion();
			}
		});

	}

	public void explanationQuestion() {
		JLabel labelSwitch = new JLabel("What the explanation of this question?");
		JButton buttonExplanation = new JButton("Insert the explanation");

		panel3.setBounds(700, 200, 500, 700);
		panel3.setBackground(new Color(107, 35, 142));
		mainFrame.add(panel3);
		panel3.setVisible(true);
		panel3.add(labelSwitch);
		panel3.add(buttonExplanation);
		panel3.setLayout(null);

		labelSwitch.setForeground(Color.white);
		labelSwitch.setBounds(120, 100, 400, 30);

		buttonExplanation.setBounds(40, 180, 400, 30);

		buttonExplanation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				explanation = JOptionPane.showInputDialog("Insert the message");

				if (mathQuizz == true) {
					if ((correctAnwser != anwser2) && (correctAnwser != anwser3) && (correctAnwser != anwser4)) {
						mathobj.addQuestions(question, correctAnwser, anwser2, anwser3, anwser4, explanation);
						JOptionPane.showMessageDialog(null, "The questions was inserted sucessfully");
					}

					if ((correctAnwser != anwser1) && (correctAnwser != anwser3) && (correctAnwser != anwser4)) {
						mathobj.addQuestions(question, correctAnwser, anwser1, anwser3, anwser4, explanation);
						JOptionPane.showMessageDialog(null, "The questions was inserted sucessfully");
					}

					if ((correctAnwser != anwser2) && (correctAnwser != anwser1) && (correctAnwser != anwser4)) {
						mathobj.addQuestions(question, correctAnwser, anwser2, anwser1, anwser4, explanation);
						JOptionPane.showMessageDialog(null, "The questions was inserted sucessfully");
					}

					if ((correctAnwser != anwser3) && (correctAnwser != anwser1) && (correctAnwser != anwser2)) {
						mathobj.addQuestions(question, correctAnwser, anwser2, anwser3, anwser1, explanation);
						JOptionPane.showMessageDialog(null, "The questions was inserted sucessfully");
					}
				}

				if (englishQuizz == true) {
					if ((correctAnwser != anwser2) && (correctAnwser != anwser3) && (correctAnwser != anwser4)) {
						englishobj.addQuestions(question, correctAnwser, anwser2, anwser3, anwser4, explanation);
						JOptionPane.showMessageDialog(null, "The questions was inserted sucessfully");
					}

					if ((correctAnwser != anwser1) && (correctAnwser != anwser3) && (correctAnwser != anwser4)) {
						englishobj.addQuestions(question, correctAnwser, anwser1, anwser3, anwser4, explanation);
						JOptionPane.showMessageDialog(null, "The questions was inserted sucessfully");
					}

					if ((correctAnwser != anwser2) && (correctAnwser != anwser1) && (correctAnwser != anwser4)) {
						englishobj.addQuestions(question, correctAnwser, anwser2, anwser1, anwser4, explanation);
						JOptionPane.showMessageDialog(null, "The questions was inserted sucessfully");
					}

					if ((correctAnwser != anwser3) && (correctAnwser != anwser1) && (correctAnwser != anwser2)) {
						englishobj.addQuestions(question, correctAnwser, anwser2, anwser3, anwser1, explanation);
						JOptionPane.showMessageDialog(null, "The questions was inserted sucessfully");
					}
				}

				if (programmingQuizz == true) {
					if ((correctAnwser != anwser2) && (correctAnwser != anwser3) && (correctAnwser != anwser4)) {
						programmingobj.addQuestions(question, correctAnwser, anwser2, anwser3, anwser4, explanation);
						JOptionPane.showMessageDialog(null, "The questions was inserted sucessfully");
					}

					if ((correctAnwser != anwser1) && (correctAnwser != anwser3) && (correctAnwser != anwser4)) {
						programmingobj.addQuestions(question, correctAnwser, anwser1, anwser3, anwser4, explanation);
						JOptionPane.showMessageDialog(null, "The questions was inserted sucessfully");
					}

					if ((correctAnwser != anwser2) && (correctAnwser != anwser1) && (correctAnwser != anwser4)) {
						programmingobj.addQuestions(question, correctAnwser, anwser2, anwser1, anwser4, explanation);
						JOptionPane.showMessageDialog(null, "The questions was inserted sucessfully");
					}

					if ((correctAnwser != anwser3) && (correctAnwser != anwser1) && (correctAnwser != anwser2)) {
						programmingobj.addQuestions(question, correctAnwser, anwser2, anwser3, anwser1, explanation);
						JOptionPane.showMessageDialog(null, "The questions was inserted sucessfully");
					}
				}
			}
		});
	}

	public void actions() {
		mathButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				question = JOptionPane.showInputDialog(null, "Insert the question!", "Example: What is 2 + 2?");
				anwser1 = JOptionPane.showInputDialog(null, "Insert the first anwser!", "Example: The anwser is 4");
				anwser2 = JOptionPane.showInputDialog(null, "Insert the second anwser!", "Example: The anwser is 4");
				anwser3 = JOptionPane.showInputDialog(null, "Insert the third anwser!", "Example: The anwser is 4");
				anwser4 = JOptionPane.showInputDialog(null, "Insert the fourth anwser!", "Example: The anwser is 4");

				mathQuizz = true;
				switchCorrectAnwser();
			}
		});

		programmingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				question = JOptionPane.showInputDialog(null, "Insert the question!", "Example: What is 2 + 2?");
				anwser1 = JOptionPane.showInputDialog(null, "Insert the first anwser!", "Example: The anwser is 4");
				anwser2 = JOptionPane.showInputDialog(null, "Insert the second anwser!", "Example: The anwser is 4");
				anwser3 = JOptionPane.showInputDialog(null, "Insert the third anwser!", "Example: The anwser is 4");
				anwser4 = JOptionPane.showInputDialog(null, "Insert the fourth anwser!", "Example: The anwser is 4");

				programmingQuizz = true;
				switchCorrectAnwser();
			}
		});

		englishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				question = JOptionPane.showInputDialog(null, "Insert the question!", "Example: What is 2 + 2?");
				anwser1 = JOptionPane.showInputDialog(null, "Insert the first anwser!", "Example: The anwser is 4");
				anwser2 = JOptionPane.showInputDialog(null, "Insert the second anwser!", "Example: The anwser is 4");
				anwser3 = JOptionPane.showInputDialog(null, "Insert the third anwser!", "Example: The anwser is 4");
				anwser4 = JOptionPane.showInputDialog(null, "Insert the fourth anwser!", "Example: The anwser is 4");

				englishQuizz = true;
				switchCorrectAnwser();
			}
		});
	}

	public void allMethods() {
		actions();
		visual();
	}
}
