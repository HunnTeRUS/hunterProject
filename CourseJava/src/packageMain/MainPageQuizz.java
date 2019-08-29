package packageMain;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

import javax.swing.JTextArea;

public class MainPageQuizz extends JFrame {
	Random rand = new Random();
	public String[] vetor = new String[4];
	PreparedStatement stmt;
	ResultSet rs;
	ResultSet lenght;
	int az;
	String SQL, count;
	int lenghtMath, lenghtEnglish, lenghtProgramming;
	String explanation = null;
	private ConectionDB db = new ConectionDB();
	private JPanel contentPane;
	ProfileAdm studentAdm = new ProfileAdm();
	Font font1 = new Font("TimesRoman", Font.BOLD, 14);

	JLabel labelSwitch = new JLabel("Switch the quizz ");
	JButton mathButton = new JButton("Math");
	JButton programmingButton = new JButton("Programming");
	JButton englishButton = new JButton("English");
	JButton btnExit = new JButton("");
	JLabel chosenQuizz = new JLabel("Test");
	JButton continueQuestionsMath = new JButton("Next");
	JTextArea questionMath = new JTextArea();
	JButton answer1Math = new JButton("");
	JButton answer2Math = new JButton("");
	JButton answer3Math = new JButton("");
	JButton answer4Math = new JButton("");
	JButton continueQuestionsEnglish = new JButton("Next");
	JTextArea questionEnglish = new JTextArea();
	JButton answer1English = new JButton("");
	JButton answer2English = new JButton("");
	JButton answer3English = new JButton("");
	JButton answer4English = new JButton("");
	JButton continueQuestionsProgramming = new JButton("Next");
	JTextArea questionProgramming = new JTextArea();
	JButton answer1Programming = new JButton("");
	JButton answer2Programming = new JButton("");
	JButton answer3Programming = new JButton("");
	JButton answer4Programming = new JButton("");

	JPanel panel3 = new JPanel();
	JPanel panelEnglish = new JPanel();
	JPanel panelProgramming = new JPanel();
	JPanel panelMath = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel1 = new JPanel();

	//public MainPageQuizz() {
	public void mainMethodQuizz() {
		questionsUser();
		MainQuizz();
	}

	public void questionsUser() {
		try {
			if (db.getConnection()) {
				String rsLenght = "SELECT MIN(codQuestion) AS firstRow FROM mathExercises;";
				stmt = db.con.prepareStatement(rsLenght);
				ResultSet lenght2 = stmt.executeQuery();

				while (lenght2.next()) {
					lenghtMath = lenght2.getInt("firstRow");
				}

				rsLenght = "SELECT MIN(codQuestion) AS firstRow FROM englishExercises;";
				stmt = db.con.prepareStatement(rsLenght);
				lenght2 = stmt.executeQuery();

				while (lenght2.next()) {
					lenghtEnglish = lenght2.getInt("firstRow");
				}

				rsLenght = "SELECT MIN(codQuestion) AS firstRow FROM programmingExercises;";
				stmt = db.con.prepareStatement(rsLenght);
				lenght2 = stmt.executeQuery();

				while (lenght2.next()) {
					lenghtProgramming = lenght2.getInt("firstRow");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void MainQuizz() {
// public MainPageQuizz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1137, 656);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel1.setBackground(new Color(54, 33, 89));
		panel1.setBounds(0, 0, 360, 627);
		contentPane.add(panel1);
		panel1.setLayout(null);

		labelSwitch.setForeground(Color.WHITE);
		labelSwitch.setBackground(Color.WHITE);
		labelSwitch.setFont(new Font("Monospaced", Font.PLAIN, 16));
		labelSwitch.setHorizontalAlignment(SwingConstants.CENTER);
		labelSwitch.setBounds(29, 77, 293, 56);
		panel1.add(labelSwitch);

		mathButton.setBackground(SystemColor.scrollbar);
		mathButton.setIcon(new ImageIcon(MainPageQuizz.class.getResource("/packageMain/icons8_math_25px.png")));
		mathButton.setFont(UIManager.getFont("TextArea.font"));
		mathButton.setBounds(10, 156, 339, 51);
		panel1.add(mathButton);

		programmingButton.setBackground(SystemColor.scrollbar);
		programmingButton.setIcon(new ImageIcon(MainPageQuizz.class.getResource("/packageMain/icons8_code_25px.png")));
		programmingButton
				.setSelectedIcon(new ImageIcon(MainPageQuizz.class.getResource("/packageMain/icons8_code_25px.png")));
		programmingButton.setFont(UIManager.getFont("TextArea.font"));
		programmingButton.setBounds(10, 218, 339, 50);
		panel1.add(programmingButton);

		englishButton.setBackground(SystemColor.scrollbar);
		englishButton.setIcon(
				new ImageIcon(MainPageQuizz.class.getResource("/packageMain/icons8_language_filled_25px.png")));
		englishButton.setFont(UIManager.getFont("TextArea.font"));
		englishButton.setBounds(10, 279, 339, 51);
		panel1.add(englishButton);

		btnExit.setIcon(new ImageIcon(MainPageQuizz.class.getResource("/packageMain/icons8_exit_sign_25px.png")));
		btnExit.setBackground(SystemColor.scrollbar);
		btnExit.setBounds(70, 567, 215, 37);
		panel1.add(btnExit);
		btnExit.setFont(UIManager.getFont("TextArea.font"));

		panel2.setBackground(new Color(176, 196, 222));
		panel2.setBounds(359, 0, 772, 627);
		contentPane.add(panel2);
		panel2.setLayout(null);

		panel3.setBounds(-13, 0, 796, 70);
		panel3.setBackground(new Color(54, 33, 89));
		panel2.add(panel3);
		panel3.setLayout(null);

		chosenQuizz.setHorizontalAlignment(SwingConstants.CENTER);
		chosenQuizz.setForeground(Color.WHITE);
		chosenQuizz.setFont(new Font("Monospaced", Font.PLAIN, 16));
		chosenQuizz.setBackground(Color.WHITE);
		chosenQuizz.setBounds(247, 11, 293, 56);
		panel3.add(chosenQuizz);

		panelMath.setBounds(-3, 70, 786, 557);
		panelMath.setBackground(new Color(176, 196, 222));
		panel2.add(panelMath);
		panelMath.setLayout(null);

		continueQuestionsMath.setIcon(
				new ImageIcon(MainPageQuizz.class.getResource("/packageMain/icons8_chevron_right_filled_25px.png")));
		continueQuestionsMath.setFont(UIManager.getFont("TextArea.font"));
		continueQuestionsMath.setBackground(SystemColor.scrollbar);
		continueQuestionsMath.setBounds(286, 509, 215, 37);
		panelMath.add(continueQuestionsMath);
		questionMath.setText("");
		questionMath.setBackground(UIManager.getColor("Button.darkShadow"));
		questionProgramming.setBackground(UIManager.getColor("Button.darkShadow"));
		questionEnglish.setBackground(UIManager.getColor("Button.darkShadow"));
//questionMath.setBackground(new Color(54, 33, 89));
		questionMath.setRows(20);
		questionMath.setLineWrap(true);
		questionMath.setEnabled(false);
		questionMath.setBounds(10, 11, 755, 266);
		questionMath.setFont(font1);
		panelMath.add(questionMath);

		answer1Math.setFont(UIManager.getFont("TextArea.font"));
		answer1Math.setBackground(SystemColor.scrollbar);
		answer1Math.setBounds(10, 296, 339, 51);
		panelMath.add(answer1Math);

		answer2Math.setFont(UIManager.getFont("TextArea.font"));
		answer2Math.setBackground(SystemColor.scrollbar);
		answer2Math.setBounds(10, 368, 339, 51);
		panelMath.add(answer2Math);

		answer3Math.setFont(UIManager.getFont("TextArea.font"));
		answer3Math.setBackground(SystemColor.scrollbar);
		answer3Math.setBounds(426, 296, 339, 51);
		panelMath.add(answer3Math);

		answer4Math.setFont(UIManager.getFont("TextArea.font"));
		answer4Math.setBackground(SystemColor.scrollbar);
		answer4Math.setBounds(426, 368, 339, 51);
		panelMath.add(answer4Math);

		panelEnglish.setLayout(null);
		panelEnglish.setBackground(new Color(176, 196, 222));
		panelEnglish.setBounds(0, 0, 775, 557);
		panel2.add(panelEnglish);

		continueQuestionsEnglish.setFont(UIManager.getFont("TextArea.font"));
		continueQuestionsEnglish.setBackground(SystemColor.scrollbar);
		continueQuestionsEnglish.setBounds(286, 509, 215, 37);
		panelEnglish.add(continueQuestionsEnglish);

		questionEnglish.setRows(20);
		questionEnglish.setLineWrap(true);
		questionEnglish.setForeground(Color.BLACK);
		questionEnglish.setEnabled(false);
		questionEnglish.setBounds(10, 11, 755, 266);
		questionEnglish.setFont(font1);
		panelEnglish.add(questionEnglish);

		answer1English.setFont(UIManager.getFont("TextArea.font"));
		answer1English.setBackground(SystemColor.scrollbar);
		answer1English.setBounds(10, 296, 339, 51);
		panelEnglish.add(answer1English);

		answer2English.setFont(UIManager.getFont("TextArea.font"));
		answer2English.setBackground(SystemColor.scrollbar);
		answer2English.setBounds(10, 368, 339, 51);
		panelEnglish.add(answer2English);

		answer3English.setFont(UIManager.getFont("TextArea.font"));
		answer3English.setBackground(SystemColor.scrollbar);
		answer3English.setBounds(426, 296, 339, 51);
		panelEnglish.add(answer3English);

		answer4English.setFont(UIManager.getFont("TextArea.font"));
		answer4English.setBackground(SystemColor.scrollbar);
		answer4English.setBounds(426, 368, 339, 51);
		panelEnglish.add(answer4English);

		panelProgramming.setLayout(null);
		panelProgramming.setBackground(new Color(176, 196, 222));
		panelProgramming.setBounds(-3, 70, 786, 557);

		panel2.add(panelProgramming);

		continueQuestionsProgramming.setFont(UIManager.getFont("TextArea.font"));
		continueQuestionsProgramming.setBackground(SystemColor.scrollbar);
		continueQuestionsProgramming.setBounds(286, 509, 215, 37);
		panelProgramming.add(continueQuestionsProgramming);

		questionProgramming.setRows(20);
		questionProgramming.setLineWrap(true);
		questionProgramming.setForeground(Color.BLACK);
		questionProgramming.setEnabled(false);
		questionProgramming.setBounds(10, 11, 755, 266);
		questionProgramming.setFont(font1);
		panelProgramming.add(questionProgramming);

		answer1Programming.setFont(UIManager.getFont("TextArea.font"));
		answer1Programming.setBackground(SystemColor.scrollbar);
		answer1Programming.setBounds(10, 296, 339, 51);
		panelProgramming.add(answer1Programming);

		answer2Programming.setFont(UIManager.getFont("TextArea.font"));
		answer2Programming.setBackground(SystemColor.scrollbar);
		answer2Programming.setBounds(10, 368, 339, 51);
		panelProgramming.add(answer2Programming);

		answer3Programming.setFont(UIManager.getFont("TextArea.font"));
		answer3Programming.setBackground(SystemColor.scrollbar);
		answer3Programming.setBounds(426, 296, 339, 51);
		panelProgramming.add(answer3Programming);

		answer4Programming.setFont(UIManager.getFont("TextArea.font"));
		answer4Programming.setBackground(SystemColor.scrollbar);
		answer4Programming.setBounds(426, 368, 339, 51);
		panelProgramming.add(answer4Programming);

		mathButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEnglish.setVisible(false);
				panelMath.setVisible(true);
				panelProgramming.setVisible(false);
				chosenQuizz.setText("Math Quizz");
				methodReceiverMath();
				actionsMath();
			}
		});

		englishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMath.setVisible(false);
				panelEnglish.setVisible(true);
				panelProgramming.setVisible(false);
				chosenQuizz.setText("English Quizz");
				methodReceiverEnglish();
				actionsEnglish();
			}
		});

		programmingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEnglish.setVisible(false);
				panelMath.setVisible(false);
				panelProgramming.setVisible(true);
				chosenQuizz.setText("Programming Quizz");
				methodReceiverProgramming();
				actionsProgramming();
			}
		});
	}

	public void methodReceiverMath() {
		if (db.getConnection()) {
			try {
				SQL = "SELECT question, answer0, answer1, answer2, answer3, explanation FROM mathExercises WHERE codQuestion="
						+ lenghtMath + ";";
				count = "SELECT COUNT(question) AS quantidade FROM mathExercises;";

				stmt = db.con.prepareStatement(count);
				lenght = stmt.executeQuery();

				while (lenght.next()) {
					if (lenghtMath > lenght.getInt("quantidade")) {
						JOptionPane.showMessageDialog(null,
								"You have finished all questions, please, try another course!");
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
					answer1Math.setText(String.valueOf(vetor[aleatorio]));
					aux[0] = aleatorio;

					while (aux[0] == aleatorio)
						aleatorio = rand.nextInt(4);
					answer2Math.setText(String.valueOf(vetor[aleatorio]));
					aux[1] = aleatorio;

					while (aux[0] == aleatorio || aux[1] == aleatorio)
						aleatorio = rand.nextInt(4);
					answer3Math.setText(String.valueOf(vetor[aleatorio]));
					aux[2] = aleatorio;

					while (aux[0] == aleatorio || aux[1] == aleatorio || aux[2] == aleatorio)
						aleatorio = rand.nextInt(4);
					answer4Math.setText(String.valueOf(vetor[aleatorio]));

					questionMath.setText("Question " + lenghtMath + " - " + String.valueOf(rs.getString("question")));

					az++;

				}
			} catch (Exception error) {
				System.err.println("Error:" + error.getMessage());
				System.err.println("Error:" + error.toString());

			}

		}
	}

	public void actionsMath() {
		try {
			SQL = "SELECT question, answer0, answer1, answer2, answer3, explanation FROM mathExercises WHERE codQuestion="
					+ lenghtMath + ";";

			stmt = db.con.prepareStatement(SQL);
			lenght = stmt.executeQuery();
			while (lenght.next())
				explanation = String.valueOf(lenght.getString("explanation"));

			answer1Math.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						lenghtMath++;
						if (answer1Math.getText().equals(vetor[0])) {
							JOptionPane.showMessageDialog(null, "You hit the correct answer!");
						} else {
							questionMath.setText("Explanation of this question: " + explanation);
							questionMath.setForeground(Color.RED);
						}

						answer1Math.setEnabled(false);
						answer2Math.setEnabled(false);
						answer3Math.setEnabled(false);
						answer4Math.setEnabled(false);
						continueQuestionsMath.setEnabled(true);
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});

			answer2Math.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						lenghtMath++;
						if (answer2Math.getText().equals(vetor[0])) {
							JOptionPane.showMessageDialog(null, "You hit the correct answer!");
						} else {
							questionMath.setText("Explanation of this question: " + explanation);
							questionMath.setForeground(Color.RED);

// objMath.explanationQuestion(i);
						}

						answer1Math.setEnabled(false);
						answer2Math.setEnabled(false);
						answer3Math.setEnabled(false);
						answer4Math.setEnabled(false);
						continueQuestionsMath.setEnabled(true);
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});

			answer3Math.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						lenghtMath++;
						if (answer3Math.getText().equals(vetor[0])) {
							JOptionPane.showMessageDialog(null, "You hit the correct answer!");
						} else {
							questionMath.setText("Explanation of this question: " + explanation);
							questionMath.setForeground(Color.RED);

// objMath.explanationQuestion(i);
						}
						answer1Math.setEnabled(false);
						answer2Math.setEnabled(false);
						answer3Math.setEnabled(false);
						answer4Math.setEnabled(false);
						continueQuestionsMath.setEnabled(true);
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});

			answer4Math.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						lenghtMath++;
						if (answer4Math.getText().equals(vetor[0])) {
							JOptionPane.showMessageDialog(null, "You hit the correct answer!");
						} else {
							JOptionPane.showMessageDialog(null, "You don't hit the correct answer!");
							questionMath.setText("Explanation of this question: " + explanation);
							questionMath.setForeground(Color.RED);

// objMath.explanationQuestion(i);
						}
						answer1Math.setEnabled(false);
						answer2Math.setEnabled(false);
						answer3Math.setEnabled(false);
						answer4Math.setEnabled(false);

						continueQuestionsMath.setEnabled(true);
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});

			continueQuestionsMath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					answer1Math.setEnabled(true);
					answer2Math.setEnabled(true);
					answer3Math.setEnabled(true);
					answer4Math.setEnabled(true);
					continueQuestionsMath.setEnabled(false);
					methodReceiverMath();
				}
			});

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

//==========================================================================

	public void methodReceiverEnglish() {
		if (db.getConnection()) {
			try {
				SQL = "SELECT question, answer0, answer1, answer2, answer3, explanation FROM englishExercises WHERE codQuestion="
						+ lenghtEnglish + ";";
				count = "SELECT COUNT(question) AS quantidade FROM englishExercises;";

				stmt = db.con.prepareStatement(count);
				lenght = stmt.executeQuery();

				while (lenght.next()) {
					if (lenghtEnglish > lenght.getInt("quantidade")) {
						JOptionPane.showMessageDialog(null,
								"You have finished all questions, please, try another course!");
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
					answer1English.setText(String.valueOf(vetor[aleatorio]));
					aux[0] = aleatorio;

					while (aux[0] == aleatorio)
						aleatorio = rand.nextInt(4);
					answer2English.setText(String.valueOf(vetor[aleatorio]));
					aux[1] = aleatorio;

					while (aux[0] == aleatorio || aux[1] == aleatorio)
						aleatorio = rand.nextInt(4);
					answer3English.setText(String.valueOf(vetor[aleatorio]));
					aux[2] = aleatorio;

					while (aux[0] == aleatorio || aux[1] == aleatorio || aux[2] == aleatorio)
						aleatorio = rand.nextInt(4);
					answer4English.setText(String.valueOf(vetor[aleatorio]));

					questionEnglish
							.setText("Question " + lenghtEnglish + " - " + String.valueOf(rs.getString("question")));

					az++;

				}
			} catch (Exception error) {
				System.err.println("Error:" + error.getMessage());
				System.err.println("Error:" + error.toString());

			}

		}
	}

	public void actionsEnglish() {
		try {
			SQL = "SELECT question, answer0, answer1, answer2, answer3, explanation FROM englishExercises WHERE codQuestion="
					+ lenghtEnglish + ";";

			stmt = db.con.prepareStatement(SQL);
			lenght = stmt.executeQuery();
			while (lenght.next())
				explanation = String.valueOf(lenght.getString("explanation"));

			answer1English.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						lenghtEnglish++;
						if (answer1English.getText().equals(vetor[0])) {
							JOptionPane.showMessageDialog(null, "You hit the correct answer!");
						} else {
							questionEnglish.setText("Explanation of this question: " + explanation);
							questionEnglish.setForeground(Color.RED);
						}

						answer1English.setEnabled(false);
						answer2English.setEnabled(false);
						answer3English.setEnabled(false);
						answer4English.setEnabled(false);
						continueQuestionsEnglish.setEnabled(true);
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});

			answer2English.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						lenghtEnglish++;
						if (answer2English.getText().equals(vetor[0])) {
							JOptionPane.showMessageDialog(null, "You hit the correct answer!");
						} else {
							questionEnglish.setText("Explanation of this question: " + explanation);
							questionEnglish.setForeground(Color.RED);

// objMath.explanationQuestion(i);
						}

						answer1English.setEnabled(false);
						answer2English.setEnabled(false);
						answer3English.setEnabled(false);
						answer4English.setEnabled(false);
						continueQuestionsEnglish.setEnabled(true);
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});

			answer3English.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						lenghtEnglish++;
						if (answer3English.getText().equals(vetor[0])) {
							JOptionPane.showMessageDialog(null, "You hit the correct answer!");
						} else {
							questionEnglish.setText("Explanation of this question: " + explanation);
							questionEnglish.setForeground(Color.RED);

// objMath.explanationQuestion(i);
						}
						answer1English.setEnabled(false);
						answer2English.setEnabled(false);
						answer3English.setEnabled(false);
						answer4English.setEnabled(false);
						continueQuestionsEnglish.setEnabled(true);
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});

			answer4Math.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						lenghtEnglish++;
						if (answer4Math.getText().equals(vetor[0])) {
							JOptionPane.showMessageDialog(null, "You hit the correct answer!");
						} else {
							JOptionPane.showMessageDialog(null, "You don't hit the correct answer!");
							questionMath.setText("Explanation of this question: " + explanation);
							questionMath.setForeground(Color.RED);

// objMath.explanationQuestion(i);
						}
						answer1English.setEnabled(false);
						answer2English.setEnabled(false);
						answer3English.setEnabled(false);
						answer4English.setEnabled(false);
						continueQuestionsEnglish.setEnabled(true);
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});

			continueQuestionsMath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					answer1English.setEnabled(true);
					answer2English.setEnabled(true);
					answer3English.setEnabled(true);
					answer4English.setEnabled(true);
					continueQuestionsEnglish.setEnabled(false);
					methodReceiverEnglish();
				}
			});

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

//========================================================

	public void methodReceiverProgramming() {
		if (db.getConnection()) {
			try {
				SQL = "SELECT question, answer0, answer1, answer2, answer3, explanation FROM programmingExercises WHERE codQuestion="
						+ lenghtProgramming + ";";
				count = "SELECT COUNT(question) AS quantidade FROM programmingExercises;";

				stmt = db.con.prepareStatement(count);
				lenght = stmt.executeQuery();

				while (lenght.next()) {
					if (lenghtProgramming > lenght.getInt("quantidade")) {
						JOptionPane.showMessageDialog(null,
								"You have finished all questions, please, try another course!");
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
					answer1Programming.setText(String.valueOf(vetor[aleatorio]));
					aux[0] = aleatorio;

					while (aux[0] == aleatorio)
						aleatorio = rand.nextInt(4);
					answer2Programming.setText(String.valueOf(vetor[aleatorio]));
					aux[1] = aleatorio;

					while (aux[0] == aleatorio || aux[1] == aleatorio)
						aleatorio = rand.nextInt(4);
					answer3Programming.setText(String.valueOf(vetor[aleatorio]));
					aux[2] = aleatorio;

					while (aux[0] == aleatorio || aux[1] == aleatorio || aux[2] == aleatorio)
						aleatorio = rand.nextInt(4);
					answer4Programming.setText(String.valueOf(vetor[aleatorio]));

					questionProgramming.setText(
							"Question " + lenghtProgramming + " - " + String.valueOf(rs.getString("question")));

					az++;

				}
			} catch (Exception error) {
				System.err.println("Error:" + error.getMessage());
				System.err.println("Error:" + error.toString());

			}

		}
	}

	public void actionsProgramming() {
		try {
			SQL = "SELECT question, answer0, answer1, answer2, answer3, explanation FROM programmingExercises WHERE codQuestion="
					+ lenghtProgramming + ";";

			stmt = db.con.prepareStatement(SQL);
			lenght = stmt.executeQuery();
			while (lenght.next())
				explanation = String.valueOf(lenght.getString("explanation"));

			answer1Programming.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						lenghtProgramming++;
						if (answer1Programming.getText().equals(vetor[0])) {
							JOptionPane.showMessageDialog(null, "You hit the correct answer!");
						} else {
							questionProgramming.setText("Explanation of this question: " + explanation);
							questionProgramming.setForeground(Color.RED);
						}

						answer1Programming.setEnabled(false);
						answer2Programming.setEnabled(false);
						answer3Programming.setEnabled(false);
						answer4Programming.setEnabled(false);
						continueQuestionsProgramming.setEnabled(true);
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});

			answer2Programming.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						lenghtProgramming++;
						if (answer2Programming.getText().equals(vetor[0])) {
							JOptionPane.showMessageDialog(null, "You hit the correct answer!");
						} else {
							questionProgramming.setText("Explanation of this question: " + explanation);
							questionProgramming.setForeground(Color.RED);

// objMath.explanationQuestion(i);
						}

						answer1Programming.setEnabled(false);
						answer2Programming.setEnabled(false);
						answer3Programming.setEnabled(false);
						answer4Programming.setEnabled(false);
						continueQuestionsProgramming.setEnabled(true);
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});

			answer3Programming.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						lenghtProgramming++;
						if (answer3Programming.getText().equals(vetor[0])) {
							JOptionPane.showMessageDialog(null, "You hit the correct answer!");
						} else {
							questionProgramming.setText("Explanation of this question: " + explanation);
							questionProgramming.setForeground(Color.RED);

// objMath.explanationQuestion(i);
						}
						answer1Programming.setEnabled(false);
						answer2Programming.setEnabled(false);
						answer3Programming.setEnabled(false);
						answer4Programming.setEnabled(false);
						continueQuestionsProgramming.setEnabled(true);
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});

			answer4Programming.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						lenghtProgramming++;
						if (answer4Programming.getText().equals(vetor[0])) {
							JOptionPane.showMessageDialog(null, "You hit the correct answer!");
						} else {
							JOptionPane.showMessageDialog(null, "You don't hit the correct answer!");
							questionProgramming.setText("Explanation of this question: " + explanation);
							questionProgramming.setForeground(Color.RED);

// objMath.explanationQuestion(i);
						}
						answer1Programming.setEnabled(false);
						answer2Programming.setEnabled(false);
						answer3Programming.setEnabled(false);
						answer4Programming.setEnabled(false);
						continueQuestionsProgramming.setEnabled(true);
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});

			continueQuestionsProgramming.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					answer1Programming.setEnabled(true);
					answer2Programming.setEnabled(true);
					answer3Programming.setEnabled(true);
					answer4Programming.setEnabled(true);
					continueQuestionsProgramming.setEnabled(false);
					methodReceiverProgramming();
				}
			});

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

}