package packageMain;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ClassAdm {

	static CreateQuestions objQuestions = new CreateQuestions();
	static StudyQuestion objStudyQuestions = new StudyQuestion();
	static MainInterface objMain = new MainInterface();
	static ClassAdm objAdm = new ClassAdm();
	static JFrame mainFrame = new JFrame();
	static JPanel mainPanel = new JPanel();
	//ImageIcon image = new ImageIcon(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png"));
	//JLabel imageIcon = new JLabel(image);
	JLabel mainText = new JLabel("What do you want to do?");
	
	JButton adc = new JButton("Add new questions");
	JButton study = new JButton("I want to study");
	JButton profileButton = new JButton("My Profile");
	
	private int c = 0;
	public int tamanho;

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void mainMethod() {
		if (c == 0) {
			settingInterface();
			c++;
		} else {
			mainFrame.setVisible(true);
		}
	}

	public void settingInterface() {
		mainFrame.setVisible(true);
		mainFrame.setBounds(700, 200, 500, 700);
		mainPanel.setBounds(700, 200, 500, 700);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(null);
		mainFrame.setTitle("Adm Page");
		mainFrame.add(mainPanel);
		//mainPanel.add(imageIcon);
		mainPanel.add(mainText);
		mainFrame.setResizable(false);
		mainPanel.add(adc);
		mainPanel.add(study);
		mainPanel.add(profileButton);
		mainPanel.setBackground(new Color(107, 35, 142));
		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png")));

		mainText.setForeground(Color.WHITE);
		study.setForeground(Color.WHITE);
		study.setBackground(Color.BLACK);
		profileButton.setForeground(Color.WHITE);
		profileButton.setBackground(Color.BLACK);
		adc.setForeground(Color.WHITE);
		adc.setBackground(Color.BLACK);

		study.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		adc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		profileButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		
		mainText.setBounds(170, 10, 200, 200);
		study.setBounds(40, 180, 400, 50);
		adc.setBounds(40, 260, 400, 50);
		profileButton.setBounds(40, 340, 400, 50);
		//imageIcon.setBounds(140, 400, 200, 200);
		
		profileButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				profileButton.setBackground(Color.white);
				profileButton.setForeground(Color.BLACK);
				profileButton.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1, true));
				profileButton.setText("View my profile informations");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				profileButton.setBackground(Color.BLACK);
				profileButton.setForeground(Color.WHITE);
				profileButton.setText("My Profile");
			}
		});
		
		adc.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				adc.setBackground(Color.white);
				adc.setForeground(Color.BLACK);
				adc.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1, true));
				adc.setText("I want to add new questions");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				adc.setBackground(Color.BLACK);
				adc.setForeground(Color.WHITE);
				adc.setText("Add questions");
			}
		});
		
		study.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				study.setBackground(Color.white);
				study.setForeground(Color.BLACK);
				study.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1, true));
				study.setText("I want to study");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				study.setBackground(Color.BLACK);
				study.setForeground(Color.WHITE);
				study.setText("View Courses");
			}
		});

		

		adc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
				objQuestions.allMethods();
			}
		});

		study.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				objStudyQuestions.allMethods();
				mainFrame.dispose();
			}

		});

		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	}
}