package packageMain;

import java.awt.Color;
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
	JButton returnMain = new JButton("Return");
	
	int i = 0;
	
	int finalValue;
	
	public int getFinalValue() {
		return finalValue;
	}

	public void setFinalValue(int finalValue) {
		this.finalValue = finalValue;
	}

	JTextArea question   = new JTextArea("asasasasasa");
	JButton correct    = new JButton();
	JButton incorrect  = new JButton();    
	JTextField textReceive = new JTextField();
	
	public void questionsUser() {
		settingInterfaceStudy();
		receiveQuestions();
	}
	
	public void settingInterfaceStudy() {
		mainFrame.setVisible(true);
		mainFrame.setBounds(500, 300, 300, 500);
		mainPanel.setBounds(500, 300, 300, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(null);
		mainFrame.add(mainPanel);
		mainPanel.add(continueQuestions);
		mainPanel.setBackground(new Color(107,35,142));
		mainPanel.add(imageIcon);
		imageIcon.setBounds(-10, 220, 300, 450);
		
		mainPanel.add(question);
		mainPanel.add(correct);
		mainPanel.add(incorrect);
		mainPanel.add(returnMain);
		
		question.setBounds(0, 0, 300, 200);
		question.setBackground(Color.BLACK);
		question.setLineWrap(true);
		question.setEnabled(false);
		
		correct.setBounds  (45, 250, 200, 30);
		returnMain.setBounds  (45, 370, 200, 30);
		incorrect.setBounds(45, 290, 200, 30);
		correct.setForeground(Color.BLACK);
		correct.setForeground(Color.BLACK);
		continueQuestions.setBounds(45, 330, 200, 30);
	}
	
	public void receiveQuestions() {		
		if(i>CreateQuestions.queueQuestions.size()) {
			JOptionPane.showMessageDialog(null, "Fimzao");}
		else{
			continueQuestions.setEnabled(false);
			question.setText(String.valueOf((CreateQuestions.queueQuestions.get(i))));
			correct.setText (String.valueOf((CreateQuestions.correctAnswer.get (i))));
			incorrect.setText(String.valueOf((CreateQuestions.incorrectAnswer.get(i))));
			
			correct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "You hit squarely!", "Yeah!", 1);
					incorrect.setEnabled(false);
					correct.setEnabled(false); 
					continueQuestions.setEnabled(true);
					
				}	
			});
			
			incorrect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "You don't hit the answer!", "=(", 3);
					incorrect.setEnabled(false);
					correct.setEnabled(false);
					continueQuestions.setEnabled(true);
					
				}	
			});
			continueQuestions.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					i++;
					continueQuestions.setEnabled(false);
					incorrect.setEnabled(true);
					correct.setEnabled(true);
					question.setText(String.valueOf((CreateQuestions.queueQuestions.get(i))));
					correct.setText (String.valueOf((CreateQuestions.correctAnswer.get (i))));
					incorrect.setText(String.valueOf((CreateQuestions.incorrectAnswer.get(i))));}
					catch(Exception error) {
						JOptionPane.showMessageDialog(null, "Insert new questions to continue");
					}
					
					}	
			});
		
			returnMain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					maininterface.settingInterface();
					StudyQuestion.mainFrame.dispose();
					
				}	
			});
			
			setFinalValue(getFinalValue() + 1);
			}
		
	
}
}


