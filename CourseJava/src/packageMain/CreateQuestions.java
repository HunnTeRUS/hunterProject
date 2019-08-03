package packageMain;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CreateQuestions {
	static JFrame mainFrame = new JFrame();
	static JPanel mainPanel = new JPanel();
	ImageIcon image = new ImageIcon(getClass().getResource("icons8-cor-48.png"));
	JLabel imageIcon = new JLabel(image);

	MainInterface classeMain = new MainInterface();
	MathQuestions mathobj = new MathQuestions();

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
		mainPanel.setBackground(new Color(107,35,142));

		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png")));
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
	public void actions() {
		mathButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String question = JOptionPane.showInputDialog("Insert the question!", 3);
				String anwser1 = JOptionPane.showInputDialog("Insert the first anwser!", 3);
				String anwser2 = JOptionPane.showInputDialog("Insert the second anwser!", 3);
				String anwser3 = JOptionPane.showInputDialog("Insert the third anwser!", 3);
				String anwser4 = JOptionPane.showInputDialog("Insert the fourth anwser!", 3);
				
				String correct = JOptionPane.showInputDialog("What the correct anwser?", 3);
				
				
				
				mathobj.addQuestions(question, anwser1, anwser2, anwser3, anwser4);
			}
		});
	}
}

