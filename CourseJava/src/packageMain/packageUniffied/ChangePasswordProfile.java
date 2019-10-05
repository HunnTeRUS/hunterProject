package packageMain.packageUniffied;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import packageMain.controller.ConectionDB;

public class ChangePasswordProfile extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	boolean valueSimbol;

	String senhaCadastrada;
	String confirmacaoSenha;
	String SQL;
	ResultSet rs;
	PreparedStatement stmt;

	ConectionDB db = new ConectionDB();

	public String getSenhaCadastrada() {
		return senhaCadastrada;
	}



	public void setSenhaCadastrada(String senhaCadastrada) {
		this.senhaCadastrada = senhaCadastrada;
	}



	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}



	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}



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

		btnSetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSenhaCadastrada(String.valueOf(passwordField.getPassword()));
				setConfirmacaoSenha(String.valueOf(confirmPasswordField.getPassword()));

				if ((getSenhaCadastrada().equals("")) || (getConfirmacaoSenha().equals(""))) {
					JOptionPane.showMessageDialog(null, "Insert your new password!");
					setSenhaCadastrada("");
					setConfirmacaoSenha("");
				}

				else if ((getSenhaCadastrada().length() <= 6) || (getConfirmacaoSenha().length() <= 6)){
					JOptionPane.showMessageDialog(null, "Put a password more strong. Use a password higher than 6 characters!");
					setSenhaCadastrada("");
					setConfirmacaoSenha("");
				}

				else if (!(getSenhaCadastrada().equals(getConfirmacaoSenha()))) {
					JOptionPane.showMessageDialog(null, "Password field and password confirmation isn't equals!");
					setSenhaCadastrada("");
					setConfirmacaoSenha("");
				}

				else {
					try {
						if (db.getConnection()) {
							LoginClientes login = new LoginClientes();
							SQL = "UPDATE users SET senha = '" + String.valueOf(getConfirmacaoSenha())
									+ "' WHERE email = '" + LoginClientes.getUsuario() + "' OR userr = '" + LoginClientes.getUsuario() + "';";

							stmt = db.con.prepareStatement(SQL);
							stmt.executeUpdate();

							stmt.close();
							db.close();

							dispose();

							JOptionPane.showMessageDialog(null, "Your password was sucessfully updated!");
						}
					} catch (SQLException error) {
						error.getStackTrace();

					}
				}
			}
		});

	}

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
