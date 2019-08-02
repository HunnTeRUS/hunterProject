package packageMain;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainInterface {

	static CreateQuestions objQuestions = new CreateQuestions();
	static StudyQuestion objStudyQuestions = new StudyQuestion();
	static MainInterface objMain = new MainInterface();
	
	static JFrame mainFrame = new JFrame();
	static JPanel mainPanel = new JPanel();
	ImageIcon image = new ImageIcon(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png"));
	JLabel imageIcon = new JLabel(image);
	JLabel mainText = new JLabel("What do you want to do?");
	JButton adc = new JButton("Add new questions");
	JButton study = new JButton("I want to study");

	public int tamanho;
	static MainInterface main = new MainInterface();


	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public void mainMethod() {
		main.settingInterface();
	}
	public void settingInterface() {
		mainFrame.setVisible(true);
		mainFrame.setBounds(700, 200, 500, 700);
		mainPanel.setBounds(700, 200, 500, 700);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(null);
		mainFrame.add(mainPanel);
		mainPanel.add(imageIcon);
		mainPanel.add(mainText);
		mainPanel.add(adc);
		mainPanel.add(study);
		mainPanel.setBackground(new Color(107,35,142));
		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png")));

		
		mainText.setForeground(Color.WHITE);
		study.setForeground(Color.WHITE);
		study.setBackground(Color.BLACK);
		adc.setForeground(Color.WHITE);
		adc.setBackground(Color.BLACK);

		study.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		adc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));

		mainText.setBounds(170, 10, 200, 200);
		study.setBounds(40, 180, 400, 30);
		adc.setBounds(40, 220, 400, 30);
		imageIcon.setBounds(140, 400, 200, 200);

		adc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				objQuestions.visual();
			}
		});

		study.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
					if(CreateQuestions.queueQuestions.size() == 0) {
						JOptionPane.showMessageDialog(null, "Add new questions to continue!", "=)", 3);
					}
					else {
						try {
						objStudyQuestions.questionsUser();
						mainFrame.dispose();
						setTamanho(CreateQuestions.queueQuestions.size());
						}catch(Exception error) {
							JOptionPane.showMessageDialog(null, "Add new questions to continue!", "=)", 3);
							CreateQuestions.mainFrame.setVisible(false);
						}
					}
			}


		});






	}

}
