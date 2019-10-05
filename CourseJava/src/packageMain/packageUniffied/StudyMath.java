package packageMain;

public class StudyMath {

	public static CreateQuestions questions = new CreateQuestions();
	public static MainInterface maininterface = new MainInterface();
	public static StudyQuestion objStudy = new StudyQuestion();
	public static StudyMath objMath = new StudyMath();
	public static ClassStudent objMain = new ClassStudent();
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
	public int c = 0;
	Random rand = new Random();
	public String[] vetor = new String[4];
	PreparedStatement stmt;
	ResultSet rs;
	ResultSet lenght;
	String explanation = null;

	// EXPLANATION QUESTION
	static JPanel mainPanelExplanation = new JPanel();
	JTextArea explanationArea = new JTextArea();
	JButton returnQuestion = new JButton("Return");

	public int finalValue, i, az = 2;
	String SQL, count;
	int test;

	public int getFinalValue() {
		return finalValue;
	}

	public void setFinalValue(int finalValue) {
		this.finalValue = finalValue;
	}
 
	public void questionsUser() {
		try {
			if (db.getConnection()) {
				String rsLenght = "SELECT MIN(codQuestion) AS firstRow FROM mathExercises;";
				stmt = db.con.prepareStatement(rsLenght);
				ResultSet lenght2 = stmt.executeQuery();

				while (lenght2.next()) {
					i = lenght2.getInt("firstRow");
				}
				
				System.out.println(i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (c == 0) {
			settingInterfaceStudy();
			//methodReceiver();
			Acoes();
			c++;
		} else {
			mainFrame.setVisible(true);
		}
	}

	public void settingInterfaceStudy() {
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setSize(500,700);
		mainFrame.setLocationRelativeTo(null);
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
	}

	public void methodReceiver(String course) {
		if (db.getConnection()) {
			if (i == az) {
				try {
					continueQuestions.setEnabled(false);
					continueQuestions.setBackground(Color.gray);
					continueQuestions.setForeground(Color.black);
					SQL = "SELECT question, answer0, answer1, answer2, answer3, explanation FROM " + course + "WHERE codQuestion="
							+ i + ";";
					count = "SELECT COUNT(question) AS quantidade FROM " + course + ";";

					stmt = db.con.prepareStatement(count);
					lenght = stmt.executeQuery();

					while (lenght.next()) {
						if (i > lenght.getInt("quantidade")) {
							JOptionPane.showMessageDialog(null, "You have finished all questions, please, try another course!");
							objMain.mainMethod();
							mainFrame.dispose();
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

						returnMain.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								maininterface.settingInterface();
								mainFrame.dispose();

							}
						});
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

	public void Acoes() {
		try {
			System.out.println(i);
			SQL = "SELECT question, answer0, answer1, answer2, answer3, explanation FROM mathExercises WHERE codQuestion="
					+ i + ";";

			stmt = db.con.prepareStatement(SQL);
			lenght = stmt.executeQuery();
			while (lenght.next())
				explanation = String.valueOf(lenght.getString("explanation"));

			answer1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						i++;
						if (answer1.getText().equals(vetor[0])) {
							JOptionPane.showMessageDialog(null, "You hit the correct answer!");
						} else {
							question.setText("Explanation of this question: " + explanation);
							question.setForeground(Color.RED);
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
							question.setText("Explanation of this question: " + explanation);
							question.setForeground(Color.RED);

							// objMath.explanationQuestion(i);
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
							question.setText("Explanation of this question: " + explanation);
							question.setForeground(Color.RED);

							// objMath.explanationQuestion(i);
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
							question.setText("Explanation of this question: " + explanation);
							question.setForeground(Color.RED);

							// objMath.explanationQuestion(i);
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
					System.out.println(i);
					answer1.setEnabled(true);
					answer2.setEnabled(true);
					answer3.setEnabled(true);
					answer4.setEnabled(true);
					continueQuestions.setEnabled(false);
					//methodReceiver();
				}
			});

			returnMain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					maininterface.settingInterface();
					mainFrame.dispose();

				}
			});

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

}
