package packageMain;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class StudyMath {

	public static CreateQuestions questions = new CreateQuestions();
	public static MainInterface maininterface = new MainInterface();
	public static StudyQuestion objStudy = new StudyQuestion();
	public static StudyMath objMath = new StudyMath();
	private ConectionDB db = new ConectionDB();

	static JFrame mainFrame = new JFrame();
	static JPanel mainPanel = new JPanel();
	ImageIcon image = new ImageIcon(getClass().getResource("icons8-cor-48.png"));
	JLabel imageIcon = new JLabel(image);
	JButton continueQuestions = new JButton("Next");
	JButton returnMain = new JButton("Return to Menu");
	JTextArea question = new JTextArea();
	JButton answer1 = new JButton();
	JButton answer2 = new JButton();
	JButton answer3 = new JButton();
	JButton answer4 = new JButton();
	JTextField textReceive = new JTextField();
	Font font1 = new Font("TimesRoman", Font.BOLD, 14);
	private int c = 0;
	Random rand = new Random();
	public String[] vetor = new String[4];
	PreparedStatement stmt;
	ResultSet rs;
	ResultSet lenght;

	// EXPLANATION QUESTION
	static JPanel mainPanelExplanation = new JPanel();
	JTextArea explanationArea = new JTextArea();
	JButton returnQuestion = new JButton("Return");

	
	public int finalValue, i = 2, az = 2;
	String SQL, count;

	public int getFinalValue() {
		return finalValue;
	}

	public void setFinalValue(int finalValue) {
		this.finalValue = finalValue;
	}

	public void questionsUser() {
		if (c == 0) {
			settingInterfaceStudy();
			methodReceiver();
			Acoes();
			c++;
		} else {

			mainFrame.setVisible(true);

		}
	}

	public void settingInterfaceStudy() {
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setBounds(700, 200, 500, 700);
		mainPanel.setBounds(700, 200, 500, 700);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(null);
		mainFrame.setTitle("Math Questions");
		mainFrame.add(mainPanel);
		mainPanel.add(continueQuestions);
		mainPanel.setBackground(new Color(107, 35, 142));
		mainPanel.add(imageIcon);
		imageIcon.setBounds(92, 400, 300, 450);

		mainPanel.add(question);
		mainPanel.add(answer1);
		mainPanel.add(answer2);
		mainPanel.add(answer3);
		mainPanel.add(answer4);
		mainPanel.add(returnMain);

		question.setBounds(0, 0, 500, 250);
		question.setBackground(Color.BLACK);
		question.setLineWrap(true);
		question.setEnabled(false);
		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png")));

		answer1.setBounds(25, 290, 440, 50);
		answer1.setForeground(Color.BLACK);
		answer1.setForeground(Color.BLACK);

		answer2.setBounds(25, 370, 440, 50);
		answer2.setForeground(Color.BLACK);
		answer2.setForeground(Color.BLACK);

		answer3.setBounds(25, 450, 440, 50);
		answer3.setForeground(Color.BLACK);
		answer3.setForeground(Color.BLACK);

		answer4.setBounds(25, 530, 440, 50);
		answer4.setForeground(Color.BLACK);
		answer4.setForeground(Color.BLACK);

		returnMain.setBounds(35, 630, 150, 35);
		continueQuestions.setBounds(300, 630, 150, 35);

		returnMain.setBackground(Color.BLACK);
		continueQuestions.setBackground(Color.BLACK);
		continueQuestions.setForeground(Color.WHITE);
		returnMain.setForeground(Color.WHITE);
		returnMain.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		continueQuestions.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));

		returnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
				maininterface.mainMethod();
			}
		});
	}

	public void methodReceiver() {
		if (db.getConnection()) {
			try {

				if (i == az) {

					continueQuestions.setEnabled(false);
					continueQuestions.setBackground(Color.gray);
					continueQuestions.setForeground(Color.black);
					SQL = "SELECT question, answer0, answer1, answer2, answer3, explanation FROM mathExercises WHERE codQuestion="
							+ i + ";";
					count = "SELECT COUNT(question) AS quantidade FROM mathExercises;";

					stmt = db.con.prepareStatement(count);
					lenght = stmt.executeQuery();

					while (lenght.next()) {
						if (i > lenght.getInt("quantidade")) {
							break;
						}
					}

					stmt = db.con.prepareStatement(SQL);
					rs = stmt.executeQuery();

					while (rs.next()) {

						vetor[0] = rs.getString("answer0");
						vetor[1] = rs.getString("answer1");
						vetor[2] = rs.getString("answer2");
						vetor[3] = rs.getString("answer3");
						int aleatorio = 10;
						int[] aux = new int[4];

						aleatorio = rand.nextInt(4);
						answer1.setText(String.valueOf(vetor[aleatorio]));
						aux[0] = aleatorio;

						while (aux[0] == aleatorio)
							aleatorio = rand.nextInt(4);
						answer2.setText(String.valueOf(vetor[aleatorio]));
						aux[1] = aleatorio;

						while (aux[0] == aleatorio || aux[1] == aleatorio)
							aleatorio = rand.nextInt(4);
						answer3.setText(String.valueOf(vetor[aleatorio]));
						aux[2] = aleatorio;

						while (aux[0] == aleatorio || aux[1] == aleatorio || aux[2] == aleatorio)
							aleatorio = rand.nextInt(4);
						answer4.setText(String.valueOf(vetor[aleatorio]));

						question.setText("Question " + i + " - " + String.valueOf(rs.getString("question")));

						question.setFont(font1);
						az++;
					}

				} else {
					i--;
					// System.out.println("Merda!!!!!!!");
				}

			} catch (Exception error) {
				System.err.println("Error:" + error.getMessage());
			}

		}
	}

	public void Acoes() {
		answer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					i++;
					if (answer1.getText().equals(vetor[0])) {
						JOptionPane.showMessageDialog(null, "You hit the correct answer!");
					} else {
						JOptionPane.showMessageDialog(null, "You don't hit the correct answer!");
						//objMath.explanationQuestion(i);
						}

					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);
					answer4.setEnabled(false);
					continueQuestions.setBackground(Color.black);
					continueQuestions.setForeground(Color.white);
					continueQuestions.setEnabled(true);
				} catch (Exception e1) {
					e1.getMessage();
				}
			}
		});

		answer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					i++;
					if (answer2.getText().equals(vetor[0])) {
						JOptionPane.showMessageDialog(null, "You hit the correct answer!");
					} else {
						JOptionPane.showMessageDialog(null, "You don't hit the correct answer!");
						//objMath.explanationQuestion(i);
						}

					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);
					answer4.setEnabled(false);
					continueQuestions.setEnabled(true);
					continueQuestions.setBackground(Color.black);
					continueQuestions.setForeground(Color.white);
				} catch (Exception e1) {
					e1.getMessage();
				}
			}
		});

		answer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					i++;
					if (answer3.getText().equals(vetor[0])) {
						JOptionPane.showMessageDialog(null, "You hit the correct answer!");
					} else {
						JOptionPane.showMessageDialog(null, "You don't hit the correct answer!");
						//objMath.explanationQuestion(i);
						}
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);
					answer4.setEnabled(false);
					continueQuestions.setEnabled(true);
					continueQuestions.setBackground(Color.black);
					continueQuestions.setForeground(Color.white);
				} catch (Exception e1) {
					e1.getMessage();
				}
			}
		});

		answer4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					i++;
					if (answer4.getText().equals(vetor[0])) {
						JOptionPane.showMessageDialog(null, "You hit the correct answer!");
					} else {
						JOptionPane.showMessageDialog(null, "You don't hit the correct answer!");
						//objMath.explanationQuestion(i);
						}
					answer1.setEnabled(false);
					answer2.setEnabled(false);
					answer3.setEnabled(false);
					answer4.setEnabled(false);
					continueQuestions.setEnabled(true);
					continueQuestions.setBackground(Color.black);
					continueQuestions.setForeground(Color.white);
				} catch (Exception e1) {
					e1.getMessage();
				}
			}
		});

		continueQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer1.setEnabled(true);
				answer2.setEnabled(true);
				answer3.setEnabled(true);
				answer4.setEnabled(true);
				continueQuestions.setEnabled(false);

				methodReceiver();
				// az++;

			}
		});

		returnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maininterface.settingInterface();
				StudyQuestion.mainFrame.dispose();

			}
		});
	}

	/*public void explanationQuestion(int i) {
		mainPanelExplanation.setBounds(700, 200, 500, 700);
		mainPanelExplanation.setLayout(null);
		mainPanel.setVisible(false);
		mainFrame.add(mainPanelExplanation);
		mainPanelExplanation.add(returnQuestion);
		mainPanelExplanation.add(explanationArea);
		mainPanelExplanation.setBackground(new Color(107, 35, 142));
		returnQuestion.setBounds(300, 630, 150, 35);
		explanationArea.setFont(font1);
		returnQuestion.setBounds(35, 630, 150, 35);
		returnQuestion.setBackground(Color.BLACK);
		returnQuestion.setForeground(Color.WHITE);
		returnQuestion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));

		explanationArea.setBounds(0, 0, 500, 250);
		explanationArea.setBackground(Color.BLACK);
		explanationArea.setLineWrap(true);
		explanationArea.setEnabled(false);

		if (db.getConnection()) {
			try {
				SQL = "SELECT explanation FROM mathExercises WHERE codQuestion=" + i + ";";
				stmt = db.con.prepareStatement(SQL);
				rs = stmt.executeQuery();
				while(rs.next()) {
					explanationArea.setText(String.valueOf(rs.getString("explanation")));
				}
				
				db.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		returnQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanelExplanation.setVisible(false);
				mainPanel.setVisible(true);
			}
		});
	}*/
}
