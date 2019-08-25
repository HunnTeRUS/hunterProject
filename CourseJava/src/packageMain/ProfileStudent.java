package packageMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DropMode;

public class ProfileStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public void ProfileStudentMethod() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 570);
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
		returnButton.setSelectedIcon(new ImageIcon(MainPage.class.getResource("/packageMain/icons8_code_25px.png")));
		returnButton.setFont(UIManager.getFont("TextArea.font"));
		returnButton.setBounds(10, 451, 248, 33);
		panel1.add(returnButton);
		
		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setForeground(Color.WHITE);
		lblMyProfile.setFont(new Font("Monospaced", Font.PLAIN, 19));
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setBounds(31, 23, 184, 83);
		panel1.add(lblMyProfile);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(169, 197, 248));
		panel_1.setBounds(267, 0, 657, 531);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAsasa = new JLabel("asasa");
		lblAsasa.setBackground(Color.GRAY);
		lblAsasa.setBounds(28, 26, 208, 193);
		panel_1.add(lblAsasa);
		
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
		lblPhone.setBounds(370, 68, 92, 25);
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
		lblInstagram.setBounds(370, 104, 133, 25);
		panel_2.add(lblInstagram);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setToolTipText("Ola");
		textField.setBounds(184, 72, 108, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(184, 108, 108, 20);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(506, 72, 108, 20);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(506, 108, 108, 20);
		panel_2.add(textField_3);
	}
}
