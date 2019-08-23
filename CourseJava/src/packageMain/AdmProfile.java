package packageMain;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class AdmProfile {

	static CreateQuestions objQuestions = new CreateQuestions();
	static StudyQuestion objStudyQuestions = new StudyQuestion();
	static MainInterface objMain = new MainInterface();
	static LoginClientes objLogin = new LoginClientes();
	static AdmProfile objAdmProfile = new AdmProfile();
	static ClassAdm objAdm = new ClassAdm();
	static JFrame mainFrame = new JFrame();
	static JPanel mainPanel = new JPanel();

	JLabel nameText = new JLabel("Name: ");
	JLabel phoneText = new JLabel("Phone: ");
	JLabel cpfText = new JLabel("CPF: ");
	JLabel birthText = new JLabel("Date of Birth: ");
	JLabel admText = new JLabel("Student/Adm: ");
	JLabel recordText = new JLabel("Sequence of correct answers: ");
	JLabel changePassword = new JLabel("Change Password");
	JLabel newPassword = new JLabel("New Password");
	JLabel newPasswordConfirmation = new JLabel("Confirm Password");
	JLabel recordMath = new JLabel("Math");
	JLabel recordEnglish = new JLabel("English");
	JLabel recordProgramming = new JLabel("Programming");

	JLabel image2 = new JLabel();

	JTextField nameField = new JTextField("");
	JTextField phoneField = new JTextField("");
	JTextField cpfField = new JTextField("");
	JTextField birthField = new JFormattedTextField();
	JTextField admField = new JTextField("");
	JTextField mathField = new JTextField("");
	JTextField englishField = new JTextField("");
	JTextField programmingField = new JTextField("");

	JPasswordField changePasswordField = new JPasswordField();
	JPasswordField changePasswordFieldConfirmation = new JPasswordField();

	JTextArea profilePicture = new JTextArea();

	JButton setNewPassword = new JButton("Define new password");
	JButton setNewPicture = new JButton("Define new profile Pic");
	JButton setInformation = new JButton("Define Informations");

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
		mainFrame.setBounds(700, 200, 600, 700);
		mainPanel.setBounds(700, 200, 500, 700);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(null);
		mainFrame.setTitle("Adm Profile");
		mainFrame.add(mainPanel);
// mainPanel.add(imageIcon);
		mainPanel.add(nameText);
		mainPanel.add(phoneText);
		mainPanel.add(cpfText);
		mainPanel.add(birthText);
		mainPanel.add(admText);
		mainPanel.add(recordText);
		mainPanel.add(setNewPassword);
		mainPanel.add(newPassword);
		mainPanel.add(newPasswordConfirmation);
		mainPanel.add(changePasswordField);
		mainPanel.add(changePasswordFieldConfirmation);
		mainPanel.add(changePassword);
		mainPanel.add(mathField);
		mainPanel.add(recordMath);
		mainPanel.add(recordEnglish);
		mainPanel.add(programmingField);
		mainPanel.add(recordProgramming);
		mainPanel.add(englishField);
		mainPanel.add(nameField);
		mainPanel.add(setNewPicture);
		mainPanel.add(setInformation);
		mainPanel.add(phoneField);
		mainPanel.add(cpfField);
		mainPanel.add(birthField);
		mainPanel.add(admField);
		mainPanel.add(profilePicture);

// profilePicture.setEnabled(false);
// profilePicture.setBackground(new Color(107, 35, 142));
// profilePicture.setBounds(20, 90, 200, 170);
		profilePicture.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

		mainFrame.setResizable(false);
		mainPanel.setBackground(new Color(35, 35, 142));
		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png")));

		nameText.setForeground(Color.WHITE);
		phoneText.setForeground(Color.WHITE);
		cpfText.setForeground(Color.WHITE);
		birthText.setForeground(Color.WHITE);
		admText.setForeground(Color.WHITE);
		recordText.setForeground(Color.WHITE);
		changePassword.setForeground(Color.WHITE);
		recordMath.setForeground(Color.WHITE);
		recordEnglish.setForeground(Color.WHITE);
		recordProgramming.setForeground(Color.WHITE);

// fc.setBounds(260, 250, 200, 200);

		nameText.setBounds(260, 0, 200, 200);
		phoneText.setBounds(260, 50, 200, 200);
		cpfText.setBounds(260, 100, 200, 200);
		birthText.setBounds(260, 150, 200, 200);
		admText.setBounds(260, 200, 200, 200);
		recordText.setBounds(330, 340, 300, 200);

		changePassword.setBounds(55, 340, 200, 200);
		changePassword.setForeground(Color.WHITE);
		setNewPassword.setBounds(20, 620, 200, 30);
		changePasswordField.setBounds(20, 480, 200, 30);
		changePasswordFieldConfirmation.setBounds(20, 550, 200, 30);
		mathField.setBounds(330, 480, 200, 30);
		recordMath.setBounds(400, 460, 200, 20);
		recordEnglish.setBounds(395, 530, 200, 20);
		recordProgramming.setBounds(380, 600, 200, 20);
		programmingField.setBounds(330, 620, 200, 30);
		englishField.setBounds(330, 550, 200, 30);
		newPasswordConfirmation.setBounds(55, 520, 200, 30);
		newPassword.setBounds(65, 450, 200, 30);
		newPassword.setForeground(Color.white);
		newPasswordConfirmation.setForeground(Color.white);

		setNewPicture.setBounds(20, 300, 200, 30);
		setInformation.setBounds(330, 330, 200, 30);

		image2.setIcon(new ImageIcon(getClass().getResource("download2.jpeg")));
		mainPanel.add(image2);
		image2.setBounds(20, 90, 200, 200);
		nameField.setBounds(373, 85, 200, 30);
		phoneField.setBounds(373, 135, 200, 30);
		cpfField.setBounds(373, 185, 200, 30);
		birthField.setBounds(373, 235, 200, 30);

		birthField.setDocument(new limitBirth());
		phoneField.setDocument(new limitPhone());
		nameField.setDocument(new limitName());
		cpfField.setDocument(new limitCPF());

		mathField.setEnabled(false);
		programmingField.setEnabled(false);
		englishField.setEnabled(false);

		birthField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		phoneField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		nameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		cpfField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		mathField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		programmingField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		englishField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		changePasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		changePasswordFieldConfirmation
				.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));

		setNewPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adcImage();
			}
		});

		birthField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String birth1;
				String birth2;
				for (int i = birthField.getText().length(); i <= 12;) {
					if (birthField.getText().length() == 2) {
						birth1 = birthField.getText();
						birth1.concat("/");
						birthField.setText(birth1);
					}

					if (birthField.getText().length() == 5) {
						birth2 = birthField.getText();
						birth2.concat("/");
						birthField.setText(birth2);
					}
				}
			}
		});
	}

	class limitPhone extends PlainDocument {
		private static final long serialVersionUID = 323;

		@Override
		public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
			tamanho = (this.getLength());

			if (tamanho > 14)
				super.insertString(arg0, arg1.replaceAll("[0123456789]", ""), arg2);

			else
				super.insertString(arg0, arg1.replaceAll("[aA-zZ @#!$%&*_=?:;^)(\\\\\\\\p{ASCII}]", ""), arg2);
		}
	}

	class limitBirth extends PlainDocument {
		private static final long serialVersionUID = 324;

		@Override
		public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
			tamanho = (this.getLength());
			if (tamanho == 1)
				super.insertString(arg0,
						arg1.replaceAll("[0123456789aA-zZ @#!$%&*_+=?:;^)(\\\\\\\\\\\\\\\\p{ASCII}]", "/"), arg2);

			if (tamanho == 4)
				super.insertString(arg0,
						arg1.replaceAll("[0123456789aA-zZ @#!$%&*_+=?:;^)(\\\\\\\\\\\\\\\\p{ASCII}]", "/"), arg2);

			if (tamanho > 9)
				super.insertString(arg0,
						arg1.replaceAll("[0123456789aA-zZ @#!$%&*_+=?:;^)(\\\\\\\\\\\\\\\\p{ASCII}]", ""), arg2);

			else
				super.insertString(arg0, arg1.replaceAll("[aA-zZ @#!$%&*_+=?:;^)(\\\\\\\\p{ASCII}]", ""), arg2);
		}
	}

	class limitCPF extends PlainDocument {
		private static final long serialVersionUID = 325;

		@Override
		public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
			tamanho = (this.getLength());
			if(tamanho==2) {
				super.insertString(arg0, arg1.replaceAll(
						"[0123456789aA-zZ @#!$%&*_+=?:;^)(\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\p{ASCII}.]", "."), arg2);
			}
			
			if(tamanho==6) {
				super.insertString(arg0, arg1.replaceAll(
						"[0123456789aA-zZ @#!$%&*_+=?:;^)(\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\p{ASCII}.]", "."), arg2);
			}
			
			if(tamanho==10) {
				super.insertString(arg0, arg1.replaceAll(
						"[0123456789aA-zZ @#!$%&*_+=?:;^)(\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\p{ASCII}.]", "-"), arg2);
			}
			
			if (tamanho > 13)
				super.insertString(arg0, arg1.replaceAll(
						"[0123456789aA-zZ @#!$%&*_+=?:;^)(\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\p{ASCII}.]", ""), arg2);

			else
				super.insertString(arg0, arg1.replaceAll("[aA-zZ @#!$%&*_+.=?:;^)(\\\\\\\\p{ASCII}]", ""), arg2);
		}
	}

	class limitName extends PlainDocument {
		private static final long serialVersionUID = 326;

		@Override
		public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
			tamanho = (this.getLength());
			super.insertString(arg0, arg1.replaceAll("[1234567890@#!$%&*_+=-?/:;^)(\\\\p{ASCII}]", ""), arg2);
		}

	}

	public void adcImage() {
		FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("jpg", "png", "jpeg");
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setFileFilter(fileNameExtensionFilter);
		fc.setDialogTitle("Insert picture (Preferred Size: 200x200px)");

		int response = fc.showOpenDialog(fc);

		if (response == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();

			try {
				image2.setIcon(new ImageIcon(file.getPath()));

			} catch (Exception error) {
				error.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		objAdmProfile.mainMethod();
	}
}