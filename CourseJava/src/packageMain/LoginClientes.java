package packageMain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.*;


public class LoginClientes {

	static LoginClientes objLogin = new LoginClientes();
	static MainInterface objClient = new MainInterface();
	static ForgotPassword objPassword = new ForgotPassword();
	
	static  JFrame framePrincipalLogin = new JFrame();
	public String senha;
	public String email;
	public static String usuario;
	
	JPasswordField campoSenha = new JPasswordField();
	JButton RecSenha = new JButton("Forgot Password");
	JButton enviarDados = new JButton("Login");
	JPanel panel = new JPanel();
	JLabel lblSignIn = new JLabel("Sign Up");
	JLabel lblUser = new JLabel("User");
	JPasswordField campoConfirmarSenhaCadastrar = new JPasswordField();
	JLabel lblConfirmPassword = new JLabel("Confirm Password");
	JLabel lblPassword_1 = new JLabel("Password");
	JLabel lblEmail = new JLabel("Email");
	JSeparator separator_2 = new JSeparator();
	JLabel lblUseremail = new JLabel("User/Email");
	JSeparator separator_3 = new JSeparator();
	JSeparator separator_4 = new JSeparator();
	JSeparator separator_1 = new JSeparator();
	JSeparator separator = new JSeparator();
	JSeparator separator_5 = new JSeparator();
	JPanel panel_1 = new JPanel();
	JLabel lblLoginIn = new JLabel("Login In");
	JLabel lblPassword = new JLabel("Password");

	private JTextField campoUsuario = new JTextField();
	private JPasswordField campoSenhaCadastrar = new JPasswordField();
	private JTextField campoUsuarioCadastrar = new JTextField();
	private JTextField campoEmailCadastrar = new JTextField();
	private String senhaCadastrada;
	private String usuarioCadastrado;
	private String emailCadastrado;
	private String confirmacaoSenha;
	JButton cadastrar = new JButton("Register");
	String codeReceived;
	Random rand = new Random();
	String finalValueCode;
	ResultSet rs;

	
	public String getSenhaCadastrada() {
		return senhaCadastrada;
	}

	public void setSenhaCadastrada(String senhaCadastrada) {
		this.senhaCadastrada = senhaCadastrada;
	}

	public String getUsuarioCadastrado() {
		return usuarioCadastrado;
	}

	public void setUsuarioCadastrado(String usuarioCadastrado) {
		this.usuarioCadastrado = usuarioCadastrado;
	}

	public String getEmailCadastrado() {
		return emailCadastrado;
	}

	public void setEmailCadastrado(String emailCadastrado) {
		this.emailCadastrado = emailCadastrado;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}
	
	public void mainMethod() {
		LoginPage();
		manipulandoDadosRegister();
		manipulandoDados();
	}
	
	public void LoginPage() {
		framePrincipalLogin.getContentPane().setLayout(null);
		framePrincipalLogin.setVisible(true);
		framePrincipalLogin.setLocation(new Point(400, 300));
		framePrincipalLogin.setBounds(new Rectangle(400, 200, 1000, 700));
		framePrincipalLogin.setTitle("Login");
		framePrincipalLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipalLogin.setResizable(false);
		
		
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(-11, -15, 505, 702);
		framePrincipalLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblSignIn.setForeground(new Color(255, 255, 255));
		lblSignIn.setFont(new Font("Monospaced", Font.BOLD, 22));
		lblSignIn.setBounds(223, 101, 104, 27);
		panel.add(lblSignIn);
		cadastrar.setIcon(new ImageIcon(LoginClientes.class.getResource("/packageMain/icons8_add_user_25px_1.png")));
		
		cadastrar.setForeground(new Color(255, 255, 255));
		cadastrar.setBackground(new Color(0, 0, 0));
		cadastrar.setBounds(95, 513, 340, 43);
		panel.add(cadastrar);
		
		campoSenhaCadastrar = new JPasswordField();
		campoSenhaCadastrar.setForeground(Color.WHITE);
		campoSenhaCadastrar.setBackground(new Color(70, 130, 180));
		campoSenhaCadastrar.setEchoChar('*');
		campoSenhaCadastrar.setBounds(95, 353, 340, 32);
		panel.add(campoSenhaCadastrar);
		campoSenhaCadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(70, 130, 180), 1, true));

		
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblUser.setBounds(245, 165, 51, 27);
		panel.add(lblUser);
		
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblEmail.setBounds(240, 253, 61, 27);
		panel.add(lblEmail);
		
		lblPassword_1.setForeground(new Color(255, 255, 255));
		lblPassword_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblPassword_1.setBounds(223, 328, 104, 27);
		panel.add(lblPassword_1);
		
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblConfirmPassword.setBounds(189, 405, 177, 27);
		panel.add(lblConfirmPassword);
		campoConfirmarSenhaCadastrar.setForeground(Color.WHITE);
		
		campoConfirmarSenhaCadastrar.setBackground(new Color(70, 130, 180));
		campoConfirmarSenhaCadastrar.setEchoChar('*');
		campoConfirmarSenhaCadastrar.setBounds(95, 435, 340, 32);
		panel.add(campoConfirmarSenhaCadastrar);
		campoConfirmarSenhaCadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(70, 130, 180), 1, true));
		
		campoUsuarioCadastrar = new JTextField();
		campoUsuarioCadastrar.setForeground(Color.WHITE);
		campoUsuarioCadastrar.setBackground(new Color(70, 130, 180));
		campoUsuarioCadastrar.setColumns(10);
		campoUsuarioCadastrar.setBounds(95, 196, 340, 32);
		panel.add(campoUsuarioCadastrar);
		campoUsuarioCadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(70, 130, 180), 1, true));
		
		campoEmailCadastrar = new JTextField();
		campoEmailCadastrar.setForeground(Color.WHITE);
		campoEmailCadastrar.setBackground(new Color(70, 130, 180));
		campoEmailCadastrar.setColumns(10);
		campoEmailCadastrar.setBounds(95, 281, 340, 32);
		panel.add(campoEmailCadastrar);
		campoEmailCadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(70, 130, 180), 1, true));

		
		separator_2.setForeground(new Color(255, 255, 255));
		separator_2.setBackground(new Color(255, 255, 255));
		separator_2.setBounds(95, 230, 340, 10);
		panel.add(separator_2);
		
		separator_3.setForeground(Color.WHITE);
		separator_3.setBackground(Color.WHITE);
		separator_3.setBounds(95, 314, 340, 10);
		panel.add(separator_3);
		
		separator_4.setForeground(Color.WHITE);
		separator_4.setBackground(Color.WHITE);
		separator_4.setBounds(95, 386, 340, 10);
		panel.add(separator_4);
		
		separator_5.setForeground(Color.WHITE);
		separator_5.setBackground(Color.WHITE);
		separator_5.setBounds(95, 468, 340, 10);
		panel.add(separator_5);
		
		panel_1.setBounds(498, 0, 484, 687);
		framePrincipalLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblLoginIn.setBounds(195, 89, 104, 27);
		lblLoginIn.setFont(new Font("Monospaced", Font.BOLD, 22));
		panel_1.add(lblLoginIn);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(71, 223, 340, 32);
		campoUsuario.setBackground(new Color(240, 240, 240 ));
		panel_1.add(campoUsuario);
		campoUsuario.setColumns(10);
		campoUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240,240,240), 1, true));

		
		lblUseremail.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblUseremail.setBounds(195, 184, 104, 27);
		panel_1.add(lblUseremail);
		
		lblPassword.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblPassword.setBounds(203, 301, 104, 27);
		panel_1.add(lblPassword);
		
		campoSenha.setEchoChar('*');
		campoSenha.setBounds(71, 340, 340, 32);
		panel_1.add(campoSenha);
		campoSenha.setBackground(new Color(240,240,240));
		campoSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240,240,240), 1, true));
		enviarDados.setHorizontalTextPosition(SwingConstants.LEADING);
		enviarDados.setIcon(new ImageIcon(LoginClientes.class.getResource("/packageMain/icons8_login_rounded_right_25px_3.png")));
		enviarDados.setBackground(new Color(0, 0, 0));
		enviarDados.setForeground(new Color(255, 255, 255));
		enviarDados.setBounds(71, 424, 340, 43);
		panel_1.add(enviarDados);
		RecSenha.setIcon(new ImageIcon(LoginClientes.class.getResource("/packageMain/icons8_one_time_password_25px.png")));
		
		RecSenha.setForeground(Color.WHITE);
		RecSenha.setBackground(Color.BLACK);
		RecSenha.setBounds(71, 501, 340, 43);
		panel_1.add(RecSenha);
		
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(71, 255, 340, 10);
		panel_1.add(separator);
		
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(71, 372, 340, 10);
		panel_1.add(separator_1);
	}

	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://127.0.0.1/courseJava";

	static public String getUsuario() {
		return usuario;
	}

	static public void setUsuario(String usuario) {
		LoginClientes.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String string) {
		this.senha = string;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void manipulandoDadosRegister() {

		cadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				setConfirmacaoSenha(String.valueOf(campoConfirmarSenhaCadastrar.getPassword()));
				setUsuarioCadastrado(campoUsuarioCadastrar.getText());
				setSenhaCadastrada(String.valueOf(campoSenhaCadastrar.getPassword()));
				setEmailCadastrado(campoEmailCadastrar.getText());

				try {
				InternetAddress emailAddr;
				emailAddr = new InternetAddress(getEmailCadastrado());
				emailAddr.validate();
				}
				catch(AddressException e1) {
					JOptionPane.showMessageDialog(null, "Put a one valid email");
				}

				if ((getEmailCadastrado().equals("")) || (getSenhaCadastrada().equals(""))
						|| (getConfirmacaoSenha().equals("")) || (getUsuarioCadastrado().equals(""))) {
					JOptionPane.showMessageDialog(null, "Fill in all the fields");
				}

				else if (!(getSenhaCadastrada().equals(getConfirmacaoSenha()))) {
					JOptionPane.showMessageDialog(null, "Password field is different from Confirm Password field");
				} else if ((getSenhaCadastrada().length()) <= 3) {
					JOptionPane.showMessageDialog(null, "Put a password more strong!");
				} else {
					try {
						Class.forName(DRIVER);
						//Connection conecta = DriverManager.getConnection(URL, "root", "hunter");
						Connection conecta = DriverManager.getConnection(URL, "root", "");
						Statement stmt = conecta.createStatement();

						String sql;

						sql = "SELECT COUNT(email) AS quantidade FROM users where email='" + getEmailCadastrado()
								+ "';";
						stmt = conecta.prepareStatement(sql);
						rs = stmt.executeQuery(sql);

						String sqlUser = "SELECT COUNT(userr) AS quantidade FROM users where userr='"
								+ getUsuarioCadastrado() + "';";
						PreparedStatement stmt2 = conecta.prepareStatement(sqlUser);
						ResultSet rs2 = stmt2.executeQuery(sqlUser);

						while (rs.next() && rs2.next()) {
							if ((rs.getInt("quantidade") == 0) && (rs2.getInt("quantidade") == 0)) {
								sql = "INSERT INTO users (userr, email, senha, adm, student) values('"
										+ getUsuarioCadastrado() + "', '" + getEmailCadastrado() + "', '"
										+ getSenhaCadastrada() + "', false, true);";
								stmt = conecta.prepareStatement(sql);
								stmt.execute(sql);
								JOptionPane.showMessageDialog(null, "You have been cadaster with success!");

							}

							else if (rs.getInt("quantidade") != 0) {
								JOptionPane.showMessageDialog(null,
										"This email has been inserted on the app, please, input another email");
								campoEmailCadastrar.setText("");
								campoUsuarioCadastrar.setText("");
							}

							else if (rs2.getInt("quantidade") != 0) {
								JOptionPane.showMessageDialog(null,
										"This user has been inserted on the app, please, input another user");
								campoEmailCadastrar.setText("");
								campoUsuarioCadastrar.setText("");
							}

						}
					} catch (SQLException error) {
						System.out.println(error.toString());
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();

					}
				}
			}
		});
	}

	public void manipulandoDados() {
		RecSenha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				objPassword.settingInterface();
				framePrincipalLogin.dispose();
				
			}
		});

		enviarDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProfileStudent stud = new ProfileStudent();
				enviarDados.setText("Logging in...");
				enviarDados.setForeground(Color.RED);
				

				setSenha(String.valueOf(campoSenha.getPassword()));
				setUsuario(campoUsuario.getText());
				
				stud.setUser(String.valueOf(getUsuario()));

				try {
					Class.forName(DRIVER);
					//Connection conecta = DriverManager.getConnection(URL, "root", "hunter");
					Connection conecta = DriverManager.getConnection(URL, "root", "");

					String sql;

					sql = "SELECT userr, email, senha, adm, student FROM users WHERE userr='" + getUsuario()
							+ "' OR email='" + getUsuario() + "';";

					PreparedStatement stmt = conecta.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();

					if (rs.next()) {
						if (((getUsuario().equals(rs.getString("userr"))
								|| (getUsuario().equals(rs.getString("email"))))
								&& (getSenha().equals(rs.getString("senha"))))) {
							if (rs.getInt("adm") == 1) {
								new Thread(new Runnable() {
									public void run() {

										try {
											Thread.sleep(2000);
											JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
											MainPageAdm tstAdm = new MainPageAdm();
											tstAdm.all();
											LoginClientes.framePrincipalLogin.dispose();
										} catch (InterruptedException error) {

											error.printStackTrace();
										}
									}
								}).start();
							} else {
								JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
								LoginClientes.framePrincipalLogin.dispose();
								MainPageStudent tst = new MainPageStudent();
								tst.all();
							}
						} else {
							JOptionPane.showMessageDialog(null, "Usuario/Email e senha incorretos!");
							enviarDados.setText("Login");
							enviarDados.setForeground(Color.BLACK);
						}
					}

					conecta.close();
					rs.close();
					stmt.close();

				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "Our server is going through problems, try again later.");
					enviarDados.setText("Login");
					enviarDados.setForeground(Color.BLACK);
			}
			}
		});

	}
	
	public static void main(String[] args) {
		objLogin.mainMethod();
	}
}
