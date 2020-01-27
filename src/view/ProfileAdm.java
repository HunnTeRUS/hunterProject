package view;

import controller.ChangePasswordProfile;
import controller.LoginClientes;
import model.ConectionDB;
import model.InsertInfoProfile;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
//sas
	LoginClientes log = new LoginClientes();
	ConectionDB db = new ConectionDB();
	RequisitionsVisualADM adm = new RequisitionsVisualADM();

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	// public ProfileAdm() {
	public void ProfileAdmMethod() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(945, 638);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setVisible(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 945, 610);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(54, 33, 89));
		panel1.setBounds(0, 0, 268, 614);
		panel.add(panel1);
		panel1.setLayout(null);

		JButton returnButton = new JButton("Return");
		returnButton.setBackground(SystemColor.scrollbar);
		returnButton.setIcon(new ImageIcon(ProfileStudent.class.getResource("/pictures/icons8_exit_sign_25px.png")));
		returnButton.setFont(UIManager.getFont("TextArea.font"));
		returnButton.setBounds(12, 549, 248, 33);
		panel1.add(returnButton);

		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setForeground(Color.WHITE);
		lblMyProfile.setFont(new Font("Monospaced", Font.PLAIN, 19));
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setBounds(40, 78, 184, 83);
		panel1.add(lblMyProfile);

		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setIcon(
				new ImageIcon(ProfileStudent.class.getResource("/pictures/icons8_show_password_25px_1.png")));
		btnChangePassword.setFont(UIManager.getFont("TextArea.font"));
		btnChangePassword.setBackground(SystemColor.scrollbar);
		btnChangePassword.setBounds(12, 219, 248, 33);
		panel1.add(btnChangePassword);

		JButton buttonSetNewAdm = new JButton("Set a New Adm");
		buttonSetNewAdm
				.setIcon(new ImageIcon(ProfileStudent.class.getResource("/pictures/icons8_administrator_25px.png")));
		buttonSetNewAdm.setFont(UIManager.getFont("TextArea.font"));
		buttonSetNewAdm.setBackground(SystemColor.scrollbar);
		buttonSetNewAdm.setBounds(12, 276, 248, 33);
		panel1.add(buttonSetNewAdm);

		JButton btnUpdateMyProfile = new JButton("Update My Picture");
		btnUpdateMyProfile
				.setIcon(new ImageIcon(ProfileStudent.class.getResource("/pictures/icons8_unspalsh_25px.png")));
		btnUpdateMyProfile.setFont(UIManager.getFont("TextArea.font"));
		btnUpdateMyProfile.setBackground(SystemColor.scrollbar);
		btnUpdateMyProfile.setBounds(12, 332, 248, 33);
		panel1.add(btnUpdateMyProfile);

		JButton adcQuestions = new JButton("Add New Questions");
		adcQuestions.setIcon(new ImageIcon(ProfileAdm.class.getResource("/pictures/icons8_school_25px.png")));
		adcQuestions.setFont(UIManager.getFont("TextArea.font"));
		adcQuestions.setBackground(SystemColor.windowBorder);
		adcQuestions.setBounds(12, 387, 248, 33);
		panel1.add(adcQuestions);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(169, 197, 248));
		panel_1.setBounds(267, 0, 679, 614);
		panel.add(panel_1);
		panel_1.setLayout(null);

		labelPhoto.setIcon(new ImageIcon(ProfileStudent.class.getResource("/pictures/download2.jpeg")));
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
		panel_2.setBounds(0, 231, 679, 169);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel socialLabel = new JLabel("Social");
		socialLabel.setBounds(306, 11, 66, 25);
		panel_2.add(socialLabel);
		socialLabel.setForeground(Color.WHITE);
		socialLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));

		JLabel lblFacebook = new JLabel("Facebook:");
		lblFacebook.setIcon(new ImageIcon(ProfileStudent.class.getResource("/pictures/icons8_facebook_25px.png")));
		lblFacebook.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblFacebook.setForeground(Color.WHITE);
		lblFacebook.setBounds(56, 118, 133, 25);
		panel_2.add(lblFacebook);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setIcon(new ImageIcon(ProfileStudent.class.getResource("/pictures/icons8_phone_25px.png")));
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblPhone.setBounds(375, 68, 92, 25);
		panel_2.add(lblPhone);

		JLabel lblWhatsapp = new JLabel("GitHub:");
		lblWhatsapp.setIcon(new ImageIcon(ProfileStudent.class.getResource("/pictures/icons8_github_25px.png")));
		lblWhatsapp.setForeground(Color.WHITE);
		lblWhatsapp.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblWhatsapp.setBounds(56, 68, 108, 25);
		panel_2.add(lblWhatsapp);

		JLabel lblInstagram = new JLabel("Instagram:");
		lblInstagram
				.setIcon(new ImageIcon(ProfileStudent.class.getResource("/pictures/icons8_instagram_new_25px.png")));
		lblInstagram.setForeground(Color.WHITE);
		lblInstagram.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblInstagram.setBounds(375, 118, 133, 25);
		panel_2.add(lblInstagram);

		facebookField = new JTextField();
		facebookField.setForeground(Color.WHITE);
		facebookField.setHorizontalAlignment(SwingConstants.LEFT);
		facebookField.setColumns(10);
		facebookField.setBounds(184, 117, 108, 20);
		panel_2.add(facebookField);

		phoneField = new JTextField();
		phoneField.setForeground(Color.WHITE);
		phoneField.setColumns(10);
		phoneField.setBounds(510, 67, 108, 20);
		panel_2.add(phoneField);

		instagramField = new JTextField();
		instagramField.setForeground(Color.WHITE);
		instagramField.setColumns(10);
		instagramField.setBounds(510, 117, 108, 20);
		panel_2.add(instagramField);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(184, 141, 108, 2);
		panel_2.add(separator_1);

		githubField = new JTextField();
		githubField.setForeground(Color.WHITE);
		githubField.setColumns(10);
		githubField.setBounds(184, 67, 108, 20);
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
		separator_4.setBounds(506, 141, 108, 2);
		panel_2.add(separator_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.WHITE);
		separator_5.setBounds(184, 91, 108, 2);
		panel_2.add(separator_5);

		separator_5.setBackground(new Color(255, 255, 255));

		JLabel lblMathRecord = new JLabel("Math");
		lblMathRecord.setForeground(Color.BLACK);
		lblMathRecord.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblMathRecord.setBounds(94, 550, 58, 25);
		panel_1.add(lblMathRecord);

		JLabel lblProgramming = new JLabel("Programming ");
		lblProgramming.setForeground(Color.BLACK);
		lblProgramming.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblProgramming.setBounds(300, 550, 138, 25);
		panel_1.add(lblProgramming);

		JLabel lblEnglish = new JLabel("English");
		lblEnglish.setForeground(Color.BLACK);
		lblEnglish.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblEnglish.setBounds(537, 550, 88, 25);
		panel_1.add(lblEnglish);

		JLabel lblRecords = new JLabel("Records");
		lblRecords.setBackground(Color.BLACK);
		lblRecords.setForeground(Color.BLACK);
		lblRecords.setFont(new Font("Monospaced", Font.PLAIN, 18));
		lblRecords.setBounds(310, 510, 91, 25);
		panel_1.add(lblRecords);

		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.LIGHT_GRAY);
		separator_6.setBackground(Color.LIGHT_GRAY);
		separator_6.setBounds(0, 472, 679, 13);
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

		ageField.setDocument(new limitBirth());
		phoneField.setDocument(new limitPhone());
		nameField.setDocument(new limitName());

		englishRecordField = new JTextField();
		englishRecordField.setHorizontalAlignment(SwingConstants.CENTER);
		englishRecordField.setForeground(Color.BLACK);
		englishRecordField.setBounds(519, 575, 106, 20);
		panel_1.add(englishRecordField);
		englishRecordField.setText(" ");
		englishRecordField.setColumns(10);

		englishRecordField.setBackground(Color.LIGHT_GRAY);
		englishRecordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 197, 248), 1, true));

		programmingRecordField = new JTextField();
		programmingRecordField.setHorizontalAlignment(SwingConstants.CENTER);
		programmingRecordField.setForeground(Color.BLACK);
		programmingRecordField.setEnabled(false);
		programmingRecordField.setBounds(300, 575, 106, 20);
		panel_1.add(programmingRecordField);
		programmingRecordField.setText(" ");
		programmingRecordField.setColumns(10);

		programmingRecordField.setBackground(Color.LIGHT_GRAY);
		programmingRecordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 197, 248), 1, true));

		mathRecordField = new JTextField();
		mathRecordField.setHorizontalAlignment(SwingConstants.CENTER);
		mathRecordField.setForeground(Color.BLACK);
		mathRecordField.setBounds(66, 575, 106, 20);
		panel_1.add(mathRecordField);
		mathRecordField.setBackground(Color.LIGHT_GRAY);
		mathRecordField.setText(" ");
		mathRecordField.setColumns(10);
		mathRecordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 197, 248), 1, true));

		if (loadImage() != null)
			labelPhoto.setIcon(new ImageIcon(loadImage()));

		loadInf();
		JButton updateInfo = new JButton("Update My Informations");
		updateInfo.setFont(UIManager.getFont("TextArea.font"));
		updateInfo.setBackground(SystemColor.windowBorder);
		updateInfo.setBounds(224, 417, 248, 33);
		panel_1.add(updateInfo);

		btnUpdateMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					adcImage();
				} catch (SQLException | FileNotFoundException eror) {
					JOptionPane.showMessageDialog(null, "An error was ocorred, please, try again later");
				}
			}
		});

		buttonSetNewAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adm.requisitionsMainMethod();
			}
		});

		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPageAdm tstAdm = new MainPageAdm();
				tstAdm.all();
				dispose();
			}
		});

		updateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertInfoProfile info = new InsertInfoProfile();

				info.insertData(nameField.getText(), ageField.getText(), phoneField.getText(), githubField.getText(),
						facebookField.getText(), instagramField.getText(), LoginClientes.getUsuario());
			}
		});

		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePasswordProfile change = new ChangePasswordProfile();
				change.changePassword();
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
				super.insertString(arg0, arg1.replaceAll("[aA-zZ @#!$%&*_+=?:;^)(\\\\\\\\p{ASCII}]", ""), arg2);
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

	public void adcImage() throws SQLException, FileNotFoundException {
		try {
			JFileChooser fc = new JFileChooser();
			fc.setFileFilter(new FileNameExtensionFilter("Image files", "bmp", "png", "jpg"));
			fc.setAcceptAllFileFilterUsed(false);
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			// fc.setFileFilter(fileNameExtensionFilter);
			fc.setDialogTitle("Insert picture (Preferred Size: 200x200px)");

			int response = fc.showOpenDialog(fc);

			if (response == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				if (db.getConnection()) {
					FileInputStream input = new FileInputStream(file);
					labelPhoto.setIcon(new ImageIcon(file.getPath()));
					PreparedStatement stmt;

					stmt = db.con.prepareStatement("UPDATE users SET photo = ? where userr = '"
							+ LoginClientes.getUsuario() + "' OR email = '" + LoginClientes.getUsuario() + "';");
					stmt.setBinaryStream(1, input, (int) file.length());
					stmt.executeUpdate();

					db.close();
					stmt.close();
				}
			}
		}

		catch (Exception error) {
			JOptionPane.showMessageDialog(null, "An error was ocorred, please, choose another picture!");
			labelPhoto.setIcon(new ImageIcon(ProfileStudent.class.getResource("/pictures/download2.jpeg")));
		}
	}

	public byte[] loadImage() {
		if (db.getConnection()) {
			ResultSet rs;
			PreparedStatement stmt;
			byte[] imagem;

			String SQL = "SELECT photo FROM users WHERE userr= '" + LoginClientes.getUsuario() + "' or email= '"
					+ LoginClientes.getUsuario() + "' ";

			try {
				stmt = db.con.prepareStatement(SQL);
				rs = stmt.executeQuery();
				rs.next();

				imagem = rs.getBytes("photo");

				return imagem;

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return null;
	}

	public void loadInf() {
		if (db.getConnection()) {

			PreparedStatement stmt;

			String sql = "SELECT nameUser,age,phone,github,adm,student,facebook,instagram,mathRecord,englishRecord,programmingRecord FROM users WHERE userr = '"
					+ LoginClientes.getUsuario() + "' OR email = '" + LoginClientes.getUsuario() + "';";
			boolean auxAdm;
			boolean auxStdt;
			try {
				stmt = db.con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					nameField.setText(rs.getString("nameUser"));
					facebookField.setText(rs.getString("facebook"));
					instagramField.setText(rs.getString("instagram"));
					githubField.setText(rs.getString("github"));
					mathRecordField.setText(Integer.toString(rs.getInt("mathRecord")));
					programmingRecordField.setText(Integer.toString(rs.getInt("programmingRecord")));
					englishRecordField.setText(Integer.toString(rs.getInt("englishRecord")));
					phoneField.setText(rs.getString("phone"));
					ageField.setDocument(new limitBirth());
					auxAdm = rs.getBoolean("adm");
					auxStdt = rs.getBoolean("student");

					if (auxAdm == true) {
						admStudentField.setText("Administrator");
					} else if (auxStdt == true) {
						admStudentField.setText("Student");
					}

				}

				try {
					String sqlDay = "SELECT SUBSTRING(users.age,1,2) AS dayDate FROM users WHERE userr='"
							+ LoginClientes.getUsuario() + "' ;";
					stmt = db.con.prepareStatement(sqlDay);
					rs = stmt.executeQuery();
					rs.next();

					String day = rs.getString("dayDate");

					String sqlMonth = "SELECT SUBSTRING(users.age,3,4) AS dayDate FROM users WHERE userr='"
							+ LoginClientes.getUsuario() + "';";
					stmt = db.con.prepareStatement(sqlMonth);
					rs = stmt.executeQuery();
					rs.next();

					String month = rs.getString("dayDate");

					String sqlYear = "SELECT SUBSTRING(users.age,7,7) AS dayDate FROM users WHERE userr='"
							+ LoginClientes.getUsuario() + "';";
					stmt = db.con.prepareStatement(sqlYear);
					rs = stmt.executeQuery();
					rs.next();

					String year = rs.getString("dayDate");

					ageField.setText(day + month + year);

				} catch (SQLException e) {

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
