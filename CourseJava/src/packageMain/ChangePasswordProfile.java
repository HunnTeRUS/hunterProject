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

public class ChangePasswordProfile extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	boolean valueSimbol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePasswordProfile frame = new ChangePasswordProfile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChangePasswordProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 579, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your new password");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblNewLabel.setBounds(195, 30, 178, 26);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(131, 68, 305, 26);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		passwordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,255), 1, true));
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(131, 94, 305, 10);
		contentPane.add(separator);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setColumns(10);
		confirmPasswordField.setBounds(131, 157, 305, 26);
		contentPane.add(confirmPasswordField);
		confirmPasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,255), 1, true));
		
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
		btnSetPassword.setBounds(195, 282, 170, 33);
		contentPane.add(btnSetPassword);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(131, 347, 114, 25);
		contentPane.add(btnReturn);
		
		JButton btnClean = new JButton("Clean");
		btnClean.setBounds(322, 347, 114, 25);
		contentPane.add(btnClean);
		
		JProgressBar progressBar = new JProgressBar();
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
			
			if (arg1.matches("[A-Z]")) progressBar.setValue(progressBar.getValue() + 30);
			
			if (arg1.matches("[!@#$%&*()_+=-[]]{}´`~^/?:>.<,]")) progressBar.setValue(progressBar.getValue() + 40);			
			}
		}
				
		passwordField.setDocument(new limit());
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Difficulty");
		lblNewLabel_1.setBounds(111, 226, 66, 15);
		contentPane.add(lblNewLabel_1);
	}
}
