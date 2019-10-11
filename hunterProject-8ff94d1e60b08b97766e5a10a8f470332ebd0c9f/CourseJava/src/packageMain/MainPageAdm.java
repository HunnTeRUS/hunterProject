package packageMain;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageAdm extends JFrame {
	private JPanel contentPane;

	ProfileAdm studentAdm = new ProfileAdm();
	
	public void all() {
		//public MainPageAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1137,656);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(54, 33, 89));
		panel1.setBounds(0, 0, 360, 627);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel labelSwitch = new JLabel("Switch the course or quizz!");
		labelSwitch.setForeground(Color.WHITE);
		labelSwitch.setBackground(Color.WHITE);
		labelSwitch.setFont(new Font("Monospaced", Font.PLAIN, 16));
		labelSwitch.setHorizontalAlignment(SwingConstants.CENTER);
		labelSwitch.setBounds(29, 77, 293, 56);
		panel1.add(labelSwitch);
		
		JButton mathButton = new JButton("Math");
		mathButton.setBackground(SystemColor.scrollbar);
		mathButton.setIcon(new ImageIcon(MainPageAdm.class.getResource("/pictures/icons8_math_25px.png")));
		mathButton.setFont(UIManager.getFont("TextArea.font"));
		mathButton.setBounds(10, 156, 339, 51);
		panel1.add(mathButton);
		
		JButton programmingButton = new JButton("Programming");
		programmingButton.setBackground(SystemColor.scrollbar);
		programmingButton.setIcon(new ImageIcon(MainPageAdm.class.getResource("/pictures/icons8_code_25px.png")));
		programmingButton.setSelectedIcon(new ImageIcon(MainPageAdm.class.getResource("/pictures/icons8_code_25px.png")));
		programmingButton.setFont(UIManager.getFont("TextArea.font"));
		programmingButton.setBounds(10, 218, 339, 50);
		panel1.add(programmingButton);
		
		JButton englishButton = new JButton("English");
		englishButton.setBackground(SystemColor.scrollbar);
		englishButton.setIcon(new ImageIcon(MainPageAdm.class.getResource("/pictures/icons8_language_filled_25px.png")));
		englishButton.setFont(UIManager.getFont("TextArea.font"));
		englishButton.setBounds(10, 279, 339, 51);
		panel1.add(englishButton);
		
		JButton btnQuizz = new JButton("Quizz");
		btnQuizz.setBackground(SystemColor.scrollbar);
		btnQuizz.setIcon(new ImageIcon(MainPageAdm.class.getResource("/pictures/icons8_test_filled_25px.png")));
		btnQuizz.setFont(UIManager.getFont("TextArea.font"));
		btnQuizz.setBounds(10, 341, 339, 51);
		panel1.add(btnQuizz);
		
		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(MainPageAdm.class.getResource("/pictures/icons8_exit_sign_25px.png")));
		btnExit.setBackground(SystemColor.scrollbar);
		btnExit.setBounds(70, 567, 215, 37);
		panel1.add(btnExit);
		btnExit.setFont(UIManager.getFont("TextArea.font"));
		
		JButton btnMyProfile = new JButton("My Profile");
		btnMyProfile.setBackground(SystemColor.scrollbar);
		btnMyProfile.setIcon(new ImageIcon(MainPageAdm.class.getResource("/pictures/icons8_admin_settings_male_filled_25px.png")));
		btnMyProfile.setFont(UIManager.getFont("TextArea.font"));
		btnMyProfile.setBounds(10, 454, 339, 51);
		panel1.add(btnMyProfile);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(176,196,222));
		panel2.setBounds(359, 0, 772, 627);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(-13, 0, 785, 70);
		panel3.setBackground(new Color(54, 33, 89));
		panel2.add(panel3);
		panel3.setLayout(null);
		
		btnMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				studentAdm.ProfileAdmMethod();
			}
		});
	}
}
