package packageMain;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class ForgotPassword {
	// Objects
	public static CreateQuestions questions = new CreateQuestions();
	public static MainInterface maininterface = new MainInterface();
	public static StudyQuestion objStudy = new StudyQuestion();
	private ConectionDB db = new ConectionDB();
	static private SendEmails objEmails = new SendEmails();
	static private LoginClientes objLogin = new LoginClientes();

	// Variables
	int vetor[] = new int[5];
	Random rand = new Random();
	private String finalValueCode;
	String codeReceived;
	private int c = 0;
	PreparedStatement stmt;
	ResultSet rs;
	ResultSet lenght;
	String explanation = null;
	public int finalValue, i = 1, az = 1;
	private String SQL, email;
	private String senhaCadastrada;
	private String emailCadastrado;

	public String getEmailCadastrado() {
		return emailCadastrado;
	}

	public void setEmailCadastrado(String emailCadastrado) {
		this.emailCadastrado = emailCadastrado;
	}

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

	private String confirmacaoSenha;

	// Frames and Panels
	static JFrame mainFrame = new JFrame();
	static JPanel mainPanel = new JPanel();
	static JPanel mainPanel2 = new JPanel();

	// Images
	ImageIcon image = new ImageIcon(getClass().getResource("icons8-cor-48.png"));

	// Labels
	JLabel emailRequest = new JLabel("Insert your E-mail!");
	JLabel passwordRequest = new JLabel("Insert a new password");
	JLabel passwordRequestConfirm = new JLabel("Confirm your password");
	JLabel imageIcon = new JLabel(image);

	// Buttons
	JButton returnMain = new JButton("Return to Menu");
	JButton sendEmail = new JButton("Send");
	JButton confirmChange = new JButton("Change");

	// TextFields
	JTextField receiveEmail = new JTextField();
	JTextField textReceive = new JTextField();

	JPasswordField password = new JPasswordField();
	JPasswordField passwordConfirm = new JPasswordField();

	Font font1 = new Font("TimesRoman", Font.BOLD, 14);

	public void questionsUser() {
		if (c == 0) {
			settingInterface();
			c++;
		} else {
			mainFrame.setVisible(true);
		}
	}

	public void settingInterface2() {
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainPanel.setVisible(false);
		mainFrame.setSize(500,700);
		mainFrame.setLocationRelativeTo(null);
		mainPanel2.setBounds(700, 200, 500, 700);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel2.setLayout(null);
		mainFrame.add(mainPanel2);
		mainFrame.setTitle("Set new password");
		mainPanel2.setBackground(new Color(70, 130, 180));
		mainPanel2.add(imageIcon);
		mainPanel2.add(passwordRequest);
		mainPanel2.add(passwordRequestConfirm);
		mainPanel2.add(password);
		mainPanel2.add(passwordConfirm);
		mainPanel2.add(confirmChange);
		imageIcon.setBounds(87, 360, 300, 450);

		password.setBounds(90, 170, 300, 50);
		password.setForeground(Color.BLACK);
		password.setForeground(Color.BLACK);

		password.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(70, 130, 180), 1, true));
		passwordConfirm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(70, 130, 180), 1, true));

		passwordConfirm.setBounds(90, 300, 300, 50);
		passwordConfirm.setForeground(Color.BLACK);
		passwordConfirm.setForeground(Color.BLACK);

		passwordRequest.setBounds(155, 120, 500, 50);
		passwordRequest.setFont(font1);
		passwordRequest.setForeground(Color.white);

		passwordRequestConfirm.setBounds(155, 250, 500, 50);
		passwordRequestConfirm.setFont(font1);
		passwordRequestConfirm.setForeground(Color.white);

		confirmChange.setBounds(115, 460, 240, 30);
		confirmChange.setForeground(Color.WHITE);
		confirmChange.setBackground(Color.BLACK);
		confirmChange.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));

		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png")));

		confirmChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSenhaCadastrada(String.valueOf(password.getPassword()));
				setConfirmacaoSenha(String.valueOf(passwordConfirm.getPassword()));

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
							SQL = "UPDATE users SET senha = '" + String.valueOf(getConfirmacaoSenha())
									+ "' WHERE email = '" + email + "';";

							stmt = db.con.prepareStatement(SQL);
							stmt.executeUpdate();

							stmt.close();
							db.close();

							JOptionPane.showMessageDialog(null, "Your password was sucessfully updated!");
						//	objLogin.metodoPrincipalLogin();
							mainFrame.dispose();
							receiveEmail.setText("");
						}
					} catch (SQLException error) {
						error.getStackTrace();

					}
				}
			}
		});

	}

	public void settingInterface() {
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setBounds(700, 200, 500, 700);
		mainPanel.setBounds(700, 200, 500, 700);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(null);
		mainFrame.add(mainPanel);
		mainFrame.setTitle("Forgot Password");
		mainPanel.setBackground(new Color(70, 130, 180));
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

		sendEmail.setBounds(125, 290, 240, 50);
		sendEmail.setForeground(Color.BLACK);
		sendEmail.setBackground(Color.WHITE);
		returnMain.setBounds(170, 630, 150, 35);
		returnMain.setBackground(Color.BLACK);
		returnMain.setForeground(Color.WHITE);
		returnMain.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 255), 1, true));

		returnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
				//objLogin.metodoPrincipalLogin();
			}
		});

		sendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InternetAddress emailAddr;
					emailAddr = new InternetAddress(receiveEmail.getText());
					emailAddr.validate();

					if (db.getConnection()) {
						try {
							SQL = "SELECT email FROM users WHERE email= '" + receiveEmail.getText() + "';";
							stmt = db.con.prepareStatement(SQL);
							rs = stmt.executeQuery(SQL);

							if (rs.next()) {
								sendEmail();
							} else {
								JOptionPane.showMessageDialog(null,
										"We don't have any account registered with this email!");
							}
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Insert a one correct email");
						}

					}
				} catch (AddressException e1) {
					JOptionPane.showMessageDialog(null, "Insert a one correct email");
				}
			}
		});
	}

	public void sendEmail() {
		vetor[0] = rand.nextInt(9);

		vetor[1] = rand.nextInt(9);
		while (vetor[0] == vetor[1])
			vetor[1] = rand.nextInt(9);

		vetor[2] = rand.nextInt(9);
		while (vetor[1] == vetor[2] || vetor[2] == vetor[0])
			vetor[2] = rand.nextInt(9);

		vetor[3] = rand.nextInt(9);
		while (vetor[3] == vetor[0] || vetor[3] == vetor[1] || vetor[3] == vetor[2])
			vetor[3] = rand.nextInt(9);

		vetor[4] = rand.nextInt(9);
		while (vetor[4] == vetor[0] || vetor[4] == vetor[1] || vetor[4] == vetor[2] || vetor[4] == vetor[3])
			vetor[4] = rand.nextInt(9);

		finalValueCode = vetor[0] + "" + vetor[1] + "" + vetor[2] + "" + vetor[3] + "" + vetor[4];

		objEmails.enviandoEmail(receiveEmail.getText(), finalValueCode);

		email = receiveEmail.getText();
		receiveEmail.setText("Please, wait!");
		receiveEmail.setForeground(Color.RED);

		new Thread(new Runnable() {
			public void run() {

				try {
					setEmailCadastrado(receiveEmail.getText());
					Thread.sleep(2000);
					JOptionPane.showMessageDialog(null,
							"We have send a one code in your email, insert him here to continue with the password recuperation!",
							"Attention", 3);

					codeReceived = JOptionPane.showInputDialog("Digite o codigo que foi enviado!");

					if (finalValueCode.equals(codeReceived)) {
						settingInterface2();
					} else {
						JOptionPane.showMessageDialog(null, "Your code is incorrect!");
						codeReceived = "";
						receiveEmail.setText("");
						receiveEmail.setForeground(Color.white);
					}

					LoginClientes.framePrincipalLogin.dispose();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		}).start();
	}

}
