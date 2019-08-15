package packageMain;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

public class AdmProfile {

	static CreateQuestions objQuestions = new CreateQuestions();
	static StudyQuestion objStudyQuestions = new StudyQuestion();
	static MainInterface objMain = new MainInterface();
	static AdmProfile objAdmProfile = new AdmProfile();
	static ClassAdm objAdm = new ClassAdm();
	static JFrame mainFrame = new JFrame();
	static JPanel mainPanel = new JPanel();
	// ImageIcon image = new
	// ImageIcon(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png"));
	// JLabel imageIcon = new JLabel(image);
	JLabel nameText = new JLabel("Name: ");
	JLabel phoneText = new JLabel("Phone: ");
	JLabel cpfText = new JLabel("CPF: ");
	JLabel birthText = new JLabel("Date of Birth: ");
	JLabel admText = new JLabel("Student/Adm: ");

	JTextField nameField = new JTextField("");
	JTextField phoneField = new JTextField("");
	JTextField cpfField = new JTextField("");
	JTextField birthField = new JFormattedTextField();
	JTextField admField = new JTextField("");

	JButton profilePicture = new JButton();

	private int c = 0;
	public int tamanho;
	private MaskFormatter formatonome;

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
		mainFrame.setBounds(700, 200, 600, 700);
		mainPanel.setBounds(700, 200, 500, 700);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(null);
		mainFrame.setTitle("Adm Page");
		mainFrame.add(mainPanel);
		// mainPanel.add(imageIcon);
		mainPanel.add(nameText);
		mainPanel.add(phoneText);
		mainPanel.add(cpfText);
		mainPanel.add(birthText);
		mainPanel.add(admText);

		mainPanel.add(nameField);
		mainPanel.add(phoneField);
		mainPanel.add(cpfField);
		mainPanel.add(birthField);
		mainPanel.add(admField);
		mainPanel.add(profilePicture);

		profilePicture.setEnabled(false);
		profilePicture.setBackground(new Color(107, 35, 142));
		profilePicture.setBounds(20, 90, 200, 170);
		profilePicture.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

		mainFrame.setResizable(false);
		mainPanel.setBackground(new Color(107, 35, 142));
		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png")));

		nameText.setForeground(Color.WHITE);
		phoneText.setForeground(Color.WHITE);
		cpfText.setForeground(Color.WHITE);
		birthText.setForeground(Color.WHITE);
		admText.setForeground(Color.WHITE);

		nameText.setBounds(260, 0, 200, 200);
		phoneText.setBounds(260, 50, 200, 200);
		cpfText.setBounds(260, 100, 200, 200);
		birthText.setBounds(260, 150, 200, 200);
		admText.setBounds(260, 200, 200, 200);

		nameField.setBounds(373, 85, 200, 30);
		phoneField.setBounds(373, 135, 200, 30);
		cpfField.setBounds(373, 185, 200, 30);
		birthField.setBounds(373, 235, 200, 30);

		birthField.setDocument(new text());
		phoneField.setDocument(new text());
		nameField.setDocument(new text2());
		
		birthField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		phoneField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		nameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		cpfField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));

	}


	class text extends PlainDocument {
		private static final long serialVersionUID = 323;
		@Override
		public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
			super.insertString(arg0, arg1.replaceAll("[aA-zZ @#!$%&*_+=?:;^)(\\\\\\\\p{ASCII}]", ""), arg2);
		}
	}
	
	class text2 extends PlainDocument {
		private static final long serialVersionUID = 324;
		@Override
		public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
			super.insertString(arg0, arg1.replaceAll("[1234567890@#!$%&*_+=-?/:;^)(\\\\p{ASCII}]", ""), arg2);
		}
	}
	
	
	public static void main(String[] args) {
		objAdmProfile.mainMethod();
	}
}
