package packageMain;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ChangePasswordProfile extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	boolean valueSimbol;

	public void changePassword() {
	
	//public ChangePasswordProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 579, 423);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.shadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Your new password");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblNewLabel.setBounds(195, 30, 178, 26);
		contentPane.add(lblNewLabel);

		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(UIManager.getColor("Button.select")));
		passwordField.setBackground(UIManager.getColor("Button.select"));
		passwordField.setBounds(131, 68, 305, 26);
		contentPane.add(passwordField);
		passwordField.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(131, 94, 305, 10);
		contentPane.add(separator);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBackground(UIManager.getColor("Button.select"));
		confirmPasswordField.setColumns(10);
		confirmPasswordField.setBounds(131, 157, 305, 26);
		contentPane.add(confirmPasswordField);
		confirmPasswordField.setBorder(new LineBorder(UIManager.getColor("Button.select"), 1, true));

		JLabel lblConfirmYourNew = new JLabel("Confirm your new password");
		lblConfirmYourNew.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblConfirmYourNew.setBounds(166, 124, 250, 26);
		contentPane.add(lblConfirmYourNew);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(131, 183, 305, 10);
		contentPane.add(separator_1);

		JButton btnSetPassword = new JButton("Set Password");
		btnSetPassword.setIcon(new ImageIcon(ChangePasswordProfile.class.getResource("/packageMain/icons8_show_password_25px_1.png")));
		btnSetPassword.setBackground(Color.WHITE);
		btnSetPassword.setBorder(new LineBorder(Color.WHITE, 5, true));
		btnSetPassword.setBounds(166, 258, 238, 33);
		contentPane.add(btnSetPassword);

		JButton btnReturn = new JButton("Return");
		btnReturn.setHorizontalTextPosition(SwingConstants.LEADING);
		btnReturn.setIcon(new ImageIcon(ChangePasswordProfile.class.getResource("/packageMain/icons8_exit_sign_25px.png")));
		btnReturn.setBackground(Color.WHITE);
		btnReturn.setBorder(new LineBorder(UIManager.getColor("Button.select")));
		btnReturn.setBounds(216, 330, 131, 36);
		contentPane.add(btnReturn);

		/*JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.GRAY);
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(195, 223, 241, 26);
		contentPane.add(progressBar);
		progressBar.setBorder(new LineBorder(new Color(255, 255, 255), 5, true));

		class limit extends PlainDocument {
			private static final long serialVersionUID = 324;

			@Override
			public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
				super.insertString(arg0, arg1, arg2);

				if (arg1.matches("[A-Z]")) {
					progressBar.setValue(progressBar.getValue() + 30);
					progressBar.setForeground(Color.YELLOW);
				}

				if (arg1.matches("[!@#$%&*()_+=-[]]{}´`~^/?:>.<,]")) {
					progressBar.setValue(progressBar.getValue() + 40);
					progressBar.setForeground(Color.ORANGE);
				}
			}
		}

		passwordField.setDocument(new limit());

		JLabel lblNewLabel_1 = new JLabel("Difficulty");
		lblNewLabel_1.setBounds(111, 226, 66, 15);
		contentPane.add(lblNewLabel_1);*/
	}
}
