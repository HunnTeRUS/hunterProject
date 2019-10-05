
package packageMain;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	PreparedStatement stmt;
	ResultSet rs;
	ResultSet lenght;
	String SQL, count;
	private int c=0;
	
	// THE NECESSARY OBJECTS
	MainInterface classeMain = new MainInterface();
	StudyMath quizzMath = new StudyMath();
	StudyProgramming quizzProgramming = new StudyProgramming();
	StudyEnglish quizzEnglish = new StudyEnglish();
	MathQuestions mathobj = new MathQuestions();
	ProgrammingQuestions programmingobj = new ProgrammingQuestions();
	EnglishQuestions englishobj = new EnglishQuestions();
	static CreateQuestions createobj = new CreateQuestions();
	private ConectionDB db = new ConectionDB();

	public void visual() {
		mainFrame.setSize(500,600);
		mainFrame.setLocationRelativeTo(null);
		mainPanel.setBounds(700, 200, 500, 700);
		mainFrame.setVisible(true);
		mainFrame.setTitle("Choice Page");
		mainPanel.setLayout(null);
		mainFrame.setResizable(false);
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

	public void actions() {
		if (db.getConnection()) {

			mathButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						count = "SELECT COUNT(question) AS quantidade FROM mathExercises;";

						stmt = db.con.prepareStatement(count);
						lenght = stmt.executeQuery();

						while (lenght.next()) {
							if (lenght.getInt("quantidade") == 0) {
								JOptionPane.showMessageDialog(null, "Wait for new questions, soon...");
							} else {
								mainFrame.dispose();
								quizzMath.questionsUser();
							}
						}
					} catch (Exception error) {
						System.out.println("Erro:" + error.getMessage());
					}

				}
			});

			programmingButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						count = "SELECT COUNT(question) AS quantidade FROM programmingExercises;";

						stmt = db.con.prepareStatement(count);
						lenght = stmt.executeQuery();

						while (lenght.next()) {
							if (lenght.getInt("quantidade") == 0) {
								JOptionPane.showMessageDialog(null, "Wait for new questions, soon...");
							} else {
								mainFrame.dispose();
								quizzProgramming.questionsUser();
							}
						}
					} catch (Exception error) {
						System.out.println("Erro:" + error.getMessage());
					}
				}
			});

			englishButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						count = "SELECT COUNT(question) AS quantidade FROM englishExercises;";

						stmt = db.con.prepareStatement(count);
						lenght = stmt.executeQuery();

						while (lenght.next()) {
							if (lenght.getInt("quantidade") == 0) {
								JOptionPane.showMessageDialog(null, "Wait for new questions, soon...");
							} else {
								mainFrame.dispose();
								quizzEnglish.questionsUser();
							}
						}
					} catch (Exception error) {
						System.out.println("Erro:" + error.getMessage());
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
	}

	public void allMethods() {
		if(c==0){
		actions();
		visual();
		c++;
		}
		else{
			mainFrame.setVisible(true);
		}
	}
}
