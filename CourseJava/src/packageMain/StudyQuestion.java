package packageMain;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StudyQuestion extends CreateQuestions {

	public static CreateQuestions questions = new CreateQuestions();
	public static MainInterface maininterface = new MainInterface();
	public static StudyQuestion objStudy = new StudyQuestion();

	static JFrame mainFrame = new JFrame();
	static JPanel mainPanel = new JPanel();
	ImageIcon image = new ImageIcon(getClass().getResource("icons8-cor-48.png"));
	JLabel imageIcon = new JLabel(image);
	JButton continueQuestions = new JButton("Next");
	JButton returnMain = new JButton("Return to Menu");

	int i = 0;

	int finalValue;

	public int getFinalValue() {
		return finalValue;
	}

	public void setFinalValue(int finalValue) {
		this.finalValue = finalValue;
	}

	JTextArea question = new JTextArea("asasasasasaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	JButton answer1 = new JButton();
	JButton answer2 = new JButton();
	JButton answer3  = new JButton("sasasasasasasasasa");
	JButton answer4  = new JButton();
	JTextField textReceive = new JTextField();

	public void questionsUser() {
		settingInterfaceStudy();
	}

	public void settingInterfaceStudy() {
		mainFrame.setVisible(true);
		mainFrame.setBounds(700, 200, 500, 700);
		mainPanel.setBounds(700, 200, 500, 700);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(null);
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

}
