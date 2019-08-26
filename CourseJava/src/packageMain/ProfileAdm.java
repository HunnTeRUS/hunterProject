package packageMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class ProfileAdm extends JFrame {
	private JPanel contentPane;
	private JTextField facebookField;
	private JTextField phoneField;
	private JTextField instagramField;
	private JTextField githubField;
	private JTextField mathRecordField;
	private JTextField programmingRecordField;
	private JTextField englishRecordField;
	private JTextField nameField;
	private JTextField ageField;
	private JTextField admStudentField;
	private JLabel labelPhoto = new JLabel();
	
	public int tamanho;

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	//public ProfileAdm() {
	public void ProfileAdmMethod() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 570);
		setTitle("Adm Profile");
		contentPane = new JPanel();
		setVisible(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 924, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(54, 33, 89));
		panel1.setBounds(0, 0, 268, 531);
		panel.add(panel1);
		panel1.setLayout(null);
		
		JButton returnButton = new JButton("Return");
		returnButton.setBackground(SystemColor.scrollbar);
		returnButton.setIcon(new ImageIcon(ProfileStudent.class.getResource("/packageMain/icons8_exit_sign_25px.png")));
		returnButton.setFont(UIManager.getFont("TextArea.font"));
		returnButton.setBounds(10, 451, 248, 33);
		panel1.add(returnButton);
		
		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setForeground(Color.WHITE);
		lblMyProfile.setFont(new Font("Monospaced", Font.PLAIN, 19));
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setBounds(39, 23, 184, 83);
		panel1.add(lblMyProfile);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setIcon(new ImageIcon(ProfileStudent.class.getResource("/packageMain/icons8_show_password_25px_1.png")));
		btnChangePassword.setFont(UIManager.getFont("TextArea.font"));
		btnChangePassword.setBackground(SystemColor.scrollbar);
		btnChangePassword.setBounds(10, 180, 248, 33);
		panel1.add(btnChangePassword);
		
		JButton btnIWannaBe = new JButton("Set a new Adm");
		btnIWannaBe.setIcon(new ImageIcon(ProfileStudent.class.getResource("/packageMain/icons8_administrator_25px.png")));
		btnIWannaBe.setFont(UIManager.getFont("TextArea.font"));
		btnIWannaBe.setBackground(SystemColor.scrollbar);
		btnIWannaBe.setBounds(10, 224, 248, 33);
		panel1.add(btnIWannaBe);
		
		JButton btnUpdateMyProfile = new JButton("Update My Picture");
		btnUpdateMyProfile.setIcon(new ImageIcon(ProfileStudent.class.getResource("/packageMain/icons8_unspalsh_25px.png")));
		btnUpdateMyProfile.setFont(UIManager.getFont("TextArea.font"));
		btnUpdateMyProfile.setBackground(SystemColor.scrollbar);
		btnUpdateMyProfile.setBounds(10, 268, 248, 33);
		panel1.add(btnUpdateMyProfile);
		
		JButton btnAddNewQuestions = new JButton("Add new Questions");
		btnAddNewQuestions.setIcon(new ImageIcon(ProfileAdm.class.getResource("/packageMain/icons8_school_25px.png")));
		btnAddNewQuestions.setFont(UIManager.getFont("TextArea.font"));
		btnAddNewQuestions.setBackground(SystemColor.scrollbar);
		btnAddNewQuestions.setBounds(10, 312, 248, 33);
		panel1.add(btnAddNewQuestions);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(169, 197, 248));
		panel_1.setBounds(267, 0, 657, 531);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		labelPhoto.setIcon(new ImageIcon(ProfileStudent.class.getResource("/packageMain/download2.jpeg")));
		labelPhoto.setBackground(Color.GRAY);
		labelPhoto.setBounds(28, 26, 200, 193);
		panel_1.add(labelPhoto);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Monospaced", Font.PLAIN, 17));
		nameLabel.setBounds(270, 46, 67, 30);
		panel_1.add(nameLabel);
		
		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setFont(new Font("Monospaced", Font.PLAIN, 17));
		ageLabel.setBounds(270, 105, 101, 30);
		panel_1.add(ageLabel);
		
		JLabel admStudent = new JLabel("Student/Adm:");
		admStudent.setFont(new Font("Monospaced", Font.PLAIN, 17));
		admStudent.setBounds(270, 158, 120, 30);
		panel_1.add(admStudent);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(54, 33, 89));
		panel_2.setBounds(0, 230, 657, 169);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel socialLabel = new JLabel("Social");
		socialLabel.setBounds(306, 11, 66, 25);
		panel_2.add(socialLabel);
		socialLabel.setForeground(Color.WHITE);
		socialLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		
		JLabel lblFacebook = new JLabel("Facebook:");
		lblFacebook.setIcon(new ImageIcon(ProfileStudent.class.getResource("/packageMain/icons8_facebook_25px.png")));
		lblFacebook.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblFacebook.setForeground(Color.WHITE);
		lblFacebook.setBounds(56, 104, 133, 25);
		panel_2.add(lblFacebook);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setIcon(new ImageIcon(ProfileStudent.class.getResource("/packageMain/icons8_phone_25px.png")));
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblPhone.setBounds(375, 68, 92, 25);
		panel_2.add(lblPhone);
		
		JLabel lblWhatsapp = new JLabel("GitHub:");
		lblWhatsapp.setIcon(new ImageIcon(ProfileStudent.class.getResource("/packageMain/icons8_github_25px.png")));
		lblWhatsapp.setForeground(Color.WHITE);
		lblWhatsapp.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblWhatsapp.setBounds(56, 68, 108, 25);
		panel_2.add(lblWhatsapp);
		
		JLabel lblInstagram = new JLabel("Instagram:");
		lblInstagram.setIcon(new ImageIcon(ProfileStudent.class.getResource("/packageMain/icons8_instagram_new_25px.png")));
		lblInstagram.setForeground(Color.WHITE);
		lblInstagram.setFont(new Font("Monospaced", Font.PLAIN, 17));
		lblInstagram.setBounds(363, 104, 133, 25);
		panel_2.add(lblInstagram);
		
		facebookField = new JTextField();
		facebookField.setForeground(Color.WHITE);
		facebookField.setHorizontalAlignment(SwingConstants.LEFT);
		facebookField.setColumns(10);
		facebookField.setBounds(184, 108, 108, 20);
		panel_2.add(facebookField);
		
		phoneField = new JTextField();
		phoneField.setForeground(Color.WHITE);
		phoneField.setColumns(10);
		phoneField.setBounds(506, 72, 108, 20);
		panel_2.add(phoneField);
		
		instagramField = new JTextField();
		instagramField.setForeground(Color.WHITE);
		instagramField.setColumns(10);
		instagramField.setBounds(506, 108, 108, 20);
		panel_2.add(instagramField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(317, 42, 40, 2);
		panel_2.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(184, 127, 108, 2);
		panel_2.add(separator_1);
		
		githubField = new JTextField();
		githubField.setForeground(Color.WHITE);
		githubField.setColumns(10);
		githubField.setBounds(184, 72, 108, 20);
		panel_2.add(githubField);
		
		facebookField.setBackground(new Color(54, 33, 89));
		githubField.setBackground(new Color(54, 33, 89));
		phoneField.setBackground(new Color(54, 33, 89));
		instagramField.setBackground(new Color(54, 33, 89));

		githubField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
		phoneField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
		instagramField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
		facebookField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 33, 89), 1, true));
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(184, 91, 108, 2);
		panel_2.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(506, 91, 108, 2);
		panel_2.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(506, 127, 108, 2);
		panel_2.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.WHITE);
		separator_5.setBounds(184, 91, 108, 2);
		panel_2.add(separator_5);
		
		separator_5.setBackground(new Color(255,255,255));
		
		JLabel lblMathRecord = new JLabel("Math");
		lblMathRecord.setForeground(Color.BLACK);
		lblMathRecord.setFont(new Font("Monospaced", Font.PLAIN, 18));
		lblMathRecord.setBounds(88, 464, 58, 25);
		panel_1.add(lblMathRecord);
		
		JLabel lblProgramming = new JLabel("Programming ");
		lblProgramming.setForeground(Color.BLACK);
		lblProgramming.setFont(new Font("Monospaced", Font.PLAIN, 18));
		lblProgramming.setBounds(280, 464, 138, 25);
		panel_1.add(lblProgramming);
		
		JLabel lblEnglish = new JLabel("English");
		lblEnglish.setForeground(Color.BLACK);
		lblEnglish.setFont(new Font("Monospaced", Font.PLAIN, 18));
		lblEnglish.setBounds(521, 464, 88, 25);
		panel_1.add(lblEnglish);
		
		JLabel lblRecords = new JLabel("Records");
		lblRecords.setBackground(Color.BLACK);
		lblRecords.setForeground(Color.BLACK);
		lblRecords.setFont(new Font("Monospaced", Font.PLAIN, 18));
		lblRecords.setBounds(299, 417, 91, 25);
		panel_1.add(lblRecords);
		
		mathRecordField = new JTextField();
		mathRecordField.setBackground(SystemColor.activeCaption);
		mathRecordField.setText(" ");
		mathRecordField.setBounds(63, 497, 106, 20);
		panel_1.add(mathRecordField);
		mathRecordField.setColumns(10);
		
		programmingRecordField = new JTextField();
		programmingRecordField.setText(" ");
		programmingRecordField.setColumns(10);
		programmingRecordField.setBounds(290, 497, 106, 20);
		panel_1.add(programmingRecordField);
		
		englishRecordField = new JTextField();
		englishRecordField.setText(" ");
		englishRecordField.setColumns(10);
		englishRecordField.setBounds(510, 497, 106, 20);
		panel_1.add(englishRecordField);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBackground(Color.BLACK);
		separator_6.setBounds(315, 451, 40, 2);
		panel_1.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBackground(Color.BLACK);
		separator_7.setBounds(347, 74, 243, 2);
		panel_1.add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBackground(Color.BLACK);
		separator_8.setBounds(347, 133, 243, 2);
		panel_1.add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBackground(Color.BLACK);
		separator_9.setBounds(400, 186, 190, 2);
		panel_1.add(separator_9);
		
		nameField = new JTextField();
		nameField.setBounds(347, 46, 243, 27);
		panel_1.add(nameField);
		nameField.setColumns(10);
		
		ageField = new JTextField();
		ageField.setColumns(10);
		ageField.setBounds(347, 105, 243, 27);
		panel_1.add(ageField);
		
		admStudentField = new JTextField();
		admStudentField.setEnabled(false);
		admStudentField.setColumns(10);
		admStudentField.setBounds(400, 158, 190, 27);
		panel_1.add(admStudentField);
		
		nameField.setBackground(new Color(169, 197, 248));
		nameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 197, 248), 1, true));
		
		ageField.setBackground(new Color(169, 197, 248));
		ageField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 197, 248), 1, true));
		
		admStudentField.setBackground(new Color(169, 197, 248));
		admStudentField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 197, 248), 1, true));
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBackground(Color.BLACK);
		separator_10.setBounds(63, 518, 108, 2);
		panel_1.add(separator_10);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBackground(Color.BLACK);
		separator_11.setBounds(288, 518, 108, 2);
		panel_1.add(separator_11);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setBackground(Color.BLACK);
		separator_12.setBounds(510, 518, 108, 2);
		panel_1.add(separator_12);
		
		mathRecordField.setBackground(new Color(169, 197, 248));
		mathRecordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 197, 248), 1, true));
		
		programmingRecordField.setBackground(new Color(169, 197, 248));
		programmingRecordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 197, 248), 1, true));
		
		englishRecordField.setBackground(new Color(169, 197, 248));
		englishRecordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 197, 248), 1, true));
		

		ageField.setDocument(new limitBirth());
		phoneField.setDocument(new limitPhone());
		nameField.setDocument(new limitName());
		
		btnUpdateMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adcImage();
			}
		});
	}
	
	class limitPhone extends PlainDocument {
		private static final long serialVersionUID = 323;

		@Override
		public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
			tamanho = (this.getLength());

			if (tamanho > 12)
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
						arg1.replaceAll("[0123456789aA-zZ /@#!$%&*_+=?:;^)(\\\\\\\\\\\\\\\\p{ASCII}]", "/"), arg2);

			if (tamanho == 4)
				super.insertString(arg0,
						arg1.replaceAll("[0123456789aA-zZ /@#!$%&*_+=?:;^)(\\\\\\\\\\\\\\\\p{ASCII}]", "/"), arg2);

			if (tamanho > 9)
				super.insertString(arg0,
						arg1.replaceAll("[0123456789aA-zZ /@#!$%&*_+=?:;^)(\\\\\\\\\\\\\\\\p{ASCII}]", ""), arg2);

			else
				super.insertString(arg0, arg1.replaceAll("[aA-zZ /@#!$%&*_+=?:;^)(\\\\\\\\p{ASCII}]", ""), arg2);
		}
	}

	class limitName extends PlainDocument {
		private static final long serialVersionUID = 326;

		@Override
		public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
			tamanho = (this.getLength());
			super.insertString(arg0, arg1.replaceAll("[1234567890@#!$%&*_+=-?/:;]", ""), arg2);
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
				labelPhoto.setIcon(new ImageIcon(file.getPath()));

			} catch (Exception error) {
				error.printStackTrace();
			}
		}
	}
}
