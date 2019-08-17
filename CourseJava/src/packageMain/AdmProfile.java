package packageMain;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	// ImageIcon image = new
	// ImageIcon(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png"));
	// JLabel imageIcon = new JLabel(image);
	JLabel nameText = new JLabel("Name: ");
	JLabel phoneText = new JLabel("Phone: ");
	JLabel cpfText = new JLabel("CPF: ");
	JLabel birthText = new JLabel("Date of Birth: ");
	JLabel admText = new JLabel("Student/Adm: ");
	JLabel recordText = new JLabel("Sequence of correct answers: ");

	JTextField nameField = new JTextField("");
	JTextField phoneField = new JTextField("");
	JTextField cpfField = new JTextField("");
	JTextField birthField = new JFormattedTextField();
	JTextField admField = new JTextField("");
	JTextField changePasswordField = new JTextField();
	JTextField changePasswordFieldConfirmation = new JTextField();
	JTextField recordField = new JTextField("");

	JButton setNewPassword = new JButton("Define new password");
	JButton setNewPicture = new JButton("Define new profile Pic");

	JTextArea profilePicture = new JTextArea();

	JLabel changePassword = new JLabel("Change Password");
	JLabel newPassword = new JLabel("New Password");
	JLabel newPasswordConfirmation = new JLabel("Confirm Password");

	ImageIcon imagem2 = null;
	JLabel image2 = new JLabel(imagem2);

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
		mainPanel.add(recordField);
		mainPanel.add(nameField);
		mainPanel.add(setNewPicture);
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

		// fc.setBounds(260, 250, 200, 200);

		nameText.setBounds(260, 0, 200, 200);
		phoneText.setBounds(260, 50, 200, 200);
		cpfText.setBounds(260, 100, 200, 200);
		birthText.setBounds(260, 150, 200, 200);
		admText.setBounds(260, 200, 200, 200);
		recordText.setBounds(330, 340, 300, 200);

		changePassword.setBounds(45, 340, 200, 200);
		changePassword.setForeground(Color.WHITE);
		setNewPassword.setBounds(10, 610, 200, 30);
		changePasswordField.setBounds(10, 480, 200, 30);
		changePasswordFieldConfirmation.setBounds(10, 550, 200, 30);
		recordField.setBounds(330, 470, 200, 30);
		newPasswordConfirmation.setBounds(45, 520, 200, 30);
		newPassword.setBounds(55, 450, 200, 30);
		newPassword.setForeground(Color.white);
		newPasswordConfirmation.setForeground(Color.white);

		setNewPicture.setBounds(20, 300, 200, 30);

		nameField.setBounds(373, 85, 200, 30);
		phoneField.setBounds(373, 135, 200, 30);
		cpfField.setBounds(373, 185, 200, 30);
		birthField.setBounds(373, 235, 200, 30);

		birthField.setDocument(new limitBirth());
		phoneField.setDocument(new limitPhone());
		nameField.setDocument(new limitName());
		cpfField.setDocument(new limitCPF());

		recordField.setEnabled(false);

		birthField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		phoneField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		nameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		cpfField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));
		recordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));

		setNewPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adcImage();
			}
		});

		birthField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
			if (tamanho > 10)
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
			// super.insertString(arg0, arg1.replaceAll("[aA-zZ
			// @#!$%&*_+=?:;^)(\\\\\\\\p{ASCII}]", ""), arg2);
			super.insertString(arg0, arg1.replaceAll("[1234567890@#!$%&*_+=-?/:;^)(\\\\p{ASCII}]", ""), arg2);
		}

	}

	public void adcImage() {
		FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("jpg", "png", "jpeg");
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(fileNameExtensionFilter);
		fc.setDialogTitle("Insert picture");

		int response = fc.showOpenDialog(fc);

		if (response == JFileChooser.APPROVE_OPTION) {
			// File file = new File(fc.getSelectedFile(), fc.getSelectedFile().toString());

			try {
				// String icons = (getClass().(fc.getIcon(fc.getSelectedFile())));
				// imagem2 = new ImageIcon(icons);

				image2 = new JLabel(imagem2);
				mainPanel.add(image2);
				image2.setBounds(20, 90, 200, 170);

				/*
				 * file = fc.getSelectedFile().getAbsoluteFile();
				 * 
				 * imagem2 = new
				 * ImageIcon(getClass().getResource(file.getCanonicalPath().toString())); image2
				 * = new JLabel(imagem2); mainPanel.add(image2);
				 * 
				 * image2.setBounds(20, 90, 200, 170);
				 */
			} catch (Exception error) {
				error.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		objAdmProfile.mainMethod();
	}
}
