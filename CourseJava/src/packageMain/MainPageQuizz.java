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
	int i, az;
	String SQL, count;
	int lenghtMath, lenghtEnglish, lenghtProgramming;
	String explanation = null;
	private ConectionDB db = new ConectionDB();
	private JPanel contentPane;
	ProfileAdm studentAdm = new ProfileAdm();

	JTextArea questionMath = new JTextArea();
	JButton answer1Math = new JButton();
	JButton answer2Math = new JButton();
	JButton answer3Math = new JButton();
	JButton answer4Math = new JButton();
	JButton continueQuestionsMath = new JButton("Next");

	JTextArea questionEnglish = new JTextArea();
	JButton answer1English = new JButton();
	JButton answer2English = new JButton();
	JButton answer3English = new JButton();
	JButton answer4English = new JButton();
	JButton continueQuestionsEnglish = new JButton("Next");

	JTextArea questionProgramming = new JTextArea();
	JButton answer1Programming = new JButton();
	JButton answer2Programming = new JButton();
	JButton answer3Programming = new JButton();
	JButton answer4Programming = new JButton();
	JButton continueQuestionsProgramming = new JButton("Next");

	JPanel panelEnglish = new JPanel();
	JPanel panelProgramming = new JPanel();
	JPanel panelMath = new JPanel();

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1137, 656);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(54, 33, 89));
		panel1.setBounds(0, 0, 360, 627);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel labelSwitch = new JLabel("Switch the quizz ");
		labelSwitch.setForeground(Color.WHITE);
		labelSwitch.setBackground(Color.WHITE);
		labelSwitch.setFont(new Font("Monospaced", Font.PLAIN, 16));
		labelSwitch.setHorizontalAlignment(SwingConstants.CENTER);
		labelSwitch.setBounds(29, 77, 293, 56);
		panel1.add(labelSwitch);

		JButton mathButton = new JButton("Math");

		mathButton.setBackground(SystemColor.scrollbar);
		mathButton.setIcon(new ImageIcon(MainPageQuizz.class.getResource("/packageMain/icons8_math_25px.png")));
		mathButton.setFont(UIManager.getFont("TextArea.font"));
		mathButton.setBounds(10, 156, 339, 51);
		panel1.add(mathButton);

		JButton programmingButton = new JButton("Programming");
		programmingButton.setBackground(SystemColor.scrollbar);
		programmingButton.setIcon(new ImageIcon(MainPageQuizz.class.getResource("/packageMain/icons8_code_25px.png")));
		programmingButton
				.setSelectedIcon(new ImageIcon(MainPageQuizz.class.getResource("/packageMain/icons8_code_25px.png")));
		programmingButton.setFont(UIManager.getFont("TextArea.font"));
		programmingButton.setBounds(10, 218, 339, 50);
		panel1.add(programmingButton);

		JButton englishButton = new JButton("English");
		englishButton.setBackground(SystemColor.scrollbar);
		englishButton.setIcon(
				new ImageIcon(MainPageQuizz.class.getResource("/packageMain/icons8_language_filled_25px.png")));
		englishButton.setFont(UIManager.getFont("TextArea.font"));
		englishButton.setBounds(10, 279, 339, 51);
		panel1.add(englishButton);

		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(MainPageQuizz.class.getResource("/packageMain/icons8_exit_sign_25px.png")));
		btnExit.setBackground(SystemColor.scrollbar);
		btnExit.setBounds(70, 567, 215, 37);
		panel1.add(btnExit);
		btnExit.setFont(UIManager.getFont("TextArea.font"));

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(176, 196, 222));
		panel2.setBounds(359, 0, 772, 627);
		contentPane.add(panel2);
		panel2.setLayout(null);

		JPanel panel3 = new JPanel();
		panel3.setBounds(-13, 0, 785, 70);
		panel3.setBackground(new Color(54, 33, 89));
		panel2.add(panel3);
		panel3.setLayout(null);

		JLabel chosenQuizz = new JLabel("Test");
		chosenQuizz.setHorizontalAlignment(SwingConstants.CENTER);
		chosenQuizz.setForeground(Color.WHITE);
		chosenQuizz.setFont(new Font("Monospaced", Font.PLAIN, 16));
		chosenQuizz.setBackground(Color.WHITE);
		chosenQuizz.setBounds(247, 11, 293, 56);
		panel3.add(chosenQuizz);

		JPanel panelMath = new JPanel();
		panelMath.setBounds(-3, 70, 775, 557);
		panelMath.setBackground(new Color(176, 196, 222));
		panel2.add(panelMath);
		panelMath.setLayout(null);

		JButton continueQuestionsMath = new JButton("Next");
		continueQuestionsMath.setIcon(
				new ImageIcon(MainPageQuizz.class.getResource("/packageMain/icons8_chevron_right_filled_25px.png")));
		continueQuestionsMath.setFont(UIManager.getFont("TextArea.font"));
		continueQuestionsMath.setBackground(SystemColor.scrollbar);
		continueQuestionsMath.setBounds(286, 509, 215, 37);
		panelMath.add(continueQuestionsMath);

		JTextArea questionMath = new JTextArea();
		questionMath.setForeground(Color.BLACK);
		questionMath.setRows(20);
		questionMath.setLineWrap(true);
		questionMath.setEnabled(false);
		questionMath.setBounds(10, 11, 755, 266);
		panelMath.add(questionMath);

		JButton answer1Math = new JButton("");
		answer1Math.setFont(UIManager.getFont("TextArea.font"));
		answer1Math.setBackground(SystemColor.scrollbar);
		answer1Math.setBounds(10, 296, 339, 51);
		panelMath.add(answer1Math);

		JButton answer2Math = new JButton("");
		answer2Math.setFont(UIManager.getFont("TextArea.font"));
		answer2Math.setBackground(SystemColor.scrollbar);
		answer2Math.setBounds(10, 368, 339, 51);
		panelMath.add(answer2Math);

		JButton answer3Math = new JButton("");
		answer3Math.setFont(UIManager.getFont("TextArea.font"));
		answer3Math.setBackground(SystemColor.scrollbar);
		answer3Math.setBounds(426, 296, 339, 51);
		panelMath.add(answer3Math);

		JButton answer4Math = new JButton("");
		answer4Math.setFont(UIManager.getFont("TextArea.font"));
		answer4Math.setBackground(SystemColor.scrollbar);
		answer4Math.setBounds(426, 368, 339, 51);
		panelMath.add(answer4Math);

		JPanel panelEnglish = new JPanel();
		panelEnglish.setLayout(null);
		panelEnglish.setBackground(new Color(176, 196, 222));
		panelEnglish.setBounds(0, 0, 775, 557);
		panel2.add(panelEnglish);

		JButton continueQuestionsEnglish = new JButton("Next");
		continueQuestionsEnglish.setFont(UIManager.getFont("TextArea.font"));
		continueQuestionsEnglish.setBackground(SystemColor.scrollbar);
		continueQuestionsEnglish.setBounds(286, 509, 215, 37);
		panelEnglish.add(continueQuestionsEnglish);

		JTextArea questionEnglish = new JTextArea();
		questionEnglish.setRows(20);
		questionEnglish.setLineWrap(true);
		questionEnglish.setForeground(Color.BLACK);
		questionEnglish.setEnabled(false);
		questionEnglish.setBounds(10, 11, 755, 266);
		panelEnglish.add(questionEnglish);

		JButton answer1English = new JButton("");
		answer1English.setFont(UIManager.getFont("TextArea.font"));
		answer1English.setBackground(SystemColor.scrollbar);
		answer1English.setBounds(10, 296, 339, 51);
		panelEnglish.add(answer1English);

		JButton answer2English = new JButton("");
		answer2English.setFont(UIManager.getFont("TextArea.font"));
		answer2English.setBackground(SystemColor.scrollbar);
		answer2English.setBounds(10, 368, 339, 51);
		panelEnglish.add(answer2English);

		JButton answer3English = new JButton("");
		answer3English.setFont(UIManager.getFont("TextArea.font"));
		answer3English.setBackground(SystemColor.scrollbar);
		answer3English.setBounds(426, 296, 339, 51);
		panelEnglish.add(answer3English);

		JButton answer4English = new JButton("");
		answer4English.setFont(UIManager.getFont("TextArea.font"));
		answer4English.setBackground(SystemColor.scrollbar);
		answer4English.setBounds(426, 368, 339, 51);
		panelEnglish.add(answer4English);

		JPanel panelProgramming = new JPanel();
		panelProgramming.setLayout(null);
		panelProgramming.setBackground(new Color(176, 196, 222));
		panelProgramming.setBounds(0, 0, 775, 557);
		panel2.add(panelProgramming);

		JButton continueQuestionsProgramming = new JButton("Next");
		continueQuestionsProgramming.setFont(UIManager.getFont("TextArea.font"));
		continueQuestionsProgramming.setBackground(SystemColor.scrollbar);
		continueQuestionsProgramming.setBounds(286, 509, 215, 37);
		panelProgramming.add(continueQuestionsProgramming);

		JTextArea questionProgramming = new JTextArea();
		questionProgramming.setRows(20);
		questionProgramming.setLineWrap(true);
		questionProgramming.setForeground(Color.BLACK);
		questionProgramming.setEnabled(false);
		questionProgramming.setBounds(10, 11, 755, 266);
		panelProgramming.add(questionProgramming);

		JButton answer1Programming = new JButton("");
		answer1Programming.setFont(UIManager.getFont("TextArea.font"));
		answer1Programming.setBackground(SystemColor.scrollbar);
		answer1Programming.setBounds(10, 296, 339, 51);
		panelProgramming.add(answer1Programming);

		JButton answer2Programming = new JButton("");
		answer2Programming.setFont(UIManager.getFont("TextArea.font"));
		answer2Programming.setBackground(SystemColor.scrollbar);
		answer2Programming.setBounds(10, 368, 339, 51);
		panelProgramming.add(answer2Programming);

		JButton answer3Programming = new JButton("");
		answer3Programming.setFont(UIManager.getFont("TextArea.font"));
		answer3Programming.setBackground(SystemColor.scrollbar);
		answer3Programming.setBounds(426, 296, 339, 51);
		panelProgramming.add(answer3Programming);

		JButton answer4Programming = new JButton("");
		answer4Programming.setFont(UIManager.getFont("TextArea.font"));
		answer4Programming.setBackground(SystemColor.scrollbar);
		answer4Programming.setBounds(426, 368, 339, 51);
		panelProgramming.add(answer4Programming);

		mathButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodReceiverMath();
				panelEnglish.setVisible(false);
				panelProgramming.setVisible(false);
			}
		});
	}

	public void methodReceiverMath() {
		if (db.getConnection()) {
			if (i == az) {
				try {
					continueQuestionsMath.setEnabled(false);
					continueQuestionsMath.setBackground(Color.gray);
					continueQuestionsMath.setForeground(Color.black);
					SQL = "SELECT question, answer0, answer1, answer2, answer3, explanation FROM mathExercises WHERE codQuestion=" + i + ";";
					count = "SELECT COUNT(question) AS quantidade FROM mathExercises;";

					stmt = db.con.prepareStatement(count);
					lenght = stmt.executeQuery();

					while (lenght.next()) {
						if (i > lenght.getInt("quantidade")) {
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

						questionMath.setText("Question " + i + " - " + String.valueOf(rs.getString("question")));

						az++;

					}
				} catch (Exception error) {
					System.err.println("Error:" + error.getMessage());
					System.err.println("Error:" + error.toString());

				}
			}

			else {
				i--;
				// System.out.println("Merda!!!!!!!");
			}

		}

	}
}
