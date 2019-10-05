package packageMain.packageUniffied;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import packageMain.StudyQuestion;

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
	private int c=0;
	public int tamanho;
	static MainInterface main = new MainInterface();

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void mainMethod() {
		if(c==0){
		settingInterface();
		c++;
		}
		else{
			mainFrame.setVisible(true);
		}
	}

	public void settingInterface() {
		mainFrame.setVisible(true);
		mainFrame.setBounds(700, 200, 500, 700);
		mainFrame.setSize(500, 700);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(null);
		mainFrame.add(mainPanel);
		mainPanel.add(imageIcon);
		mainPanel.add(mainText);
		mainFrame.setResizable(false);
		mainPanel.add(adc);
		mainPanel.add(study);
		mainPanel.setBackground(new Color(107, 35, 142));
		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png")));

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

	}

	public static void main(String[] args) {
		objMain.mainMethod();
	}

}