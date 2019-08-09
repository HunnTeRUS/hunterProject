package packageMain;

import java.awt.Color;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.*;

public class ForgotPassword {

	public static CreateQuestions questions = new CreateQuestions();
	public static MainInterface maininterface = new MainInterface();
	public static StudyQuestion objStudy = new StudyQuestion();
	private ConectionDB db = new ConectionDB();
	

	static JFrame mainFrame = new JFrame();
	static JPanel mainPanel = new JPanel();
	ImageIcon image = new ImageIcon(getClass().getResource("icons8-cor-48.png"));
	JLabel emailRequest = new JLabel("Insert your E-mail!");
	JLabel imageIcon = new JLabel(image);
	JButton returnMain = new JButton("Return to Menu");
	JTextField receiveEmail= new JTextField("");
	JButton sendEmail = new JButton("Send");
	JTextField textReceive = new JTextField();
	private int c = 0;
	Font font1 = new Font("TimesRoman", Font.BOLD, 14);

	PreparedStatement stmt;
	ResultSet rs;
	ResultSet lenght;
	String explanation = null;
	
	public int finalValue, i = 1, az = 1;
	String SQL, count;

	public void questionsUser() {
		if (c == 0) {
			settingInterface();
			c++;
		} else {
			mainFrame.setVisible(true);
		}
	}

	public void settingInterface() {
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setBounds(700, 200, 500, 700);
		mainPanel.setBounds(700, 200, 500, 700);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(null);
		mainFrame.add(mainPanel);
		mainFrame.setTitle("English Questions");
		mainPanel.setBackground(new Color(107, 35, 142));
		mainPanel.add(imageIcon);
		mainPanel.add(emailRequest);
		imageIcon.setBounds(92, 360, 300, 450);

		mainPanel.add(receiveEmail);
		mainPanel.add(sendEmail);
		mainPanel.add(returnMain);

		
		emailRequest.setBounds(175, 120, 500, 50);
		emailRequest.setFont(font1);
		emailRequest.setForeground(Color.white);
		receiveEmail.setForeground(Color.white);
		receiveEmail.setBounds(0, 170, 500, 50);
		receiveEmail.setBackground(Color.BLACK);
		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png")));

		sendEmail.setBounds(135, 290, 240, 50);
		sendEmail.setForeground(Color.BLACK);
		sendEmail.setForeground(Color.BLACK);
		returnMain.setBounds(170, 630, 150, 35);
		returnMain.setBackground(Color.BLACK);
		returnMain.setForeground(Color.WHITE);
		returnMain.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));

		returnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
				maininterface.mainMethod();
			}
		});
		
		sendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean correctEmail;
				InternetAddress emailAddr;
				try {
					emailAddr = new InternetAddress(receiveEmail.getText());
			        emailAddr.validate();
			        correctEmail = true;
				} catch (AddressException e1) {
					JOptionPane.showMessageDialog(null, "Insert a one correct email");
					correctEmail = false;
				}
			}
		});
	}

	
}
