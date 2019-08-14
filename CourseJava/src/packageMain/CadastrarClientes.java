package packageMain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;
import javax.swing.*;

public class CadastrarClientes {

	static LoginClientes objLogin = new LoginClientes();
	static CadastrarClientes objSignUp = new CadastrarClientes();
	static SendEmails objEmails = new SendEmails();
	ImageIcon imagem = new ImageIcon(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png"));
	ImageIcon imagem2 = new ImageIcon(getClass().getResource("logo-branco-transparente.png"));
	public JLabel image2 = new JLabel(imagem2);
	public JLabel image = new JLabel(imagem);
	static JFrame framePrincipalCadastro = new JFrame();
	static JPanel painelPrincipalCadastro = new JPanel();
	JLabel labelEmail = new JLabel("Email: ");
	JLabel labelsenha = new JLabel("Senha: ");
	JLabel labelUsuario = new JLabel("Usuario: ");
	JLabel labelConfirmarSenha = new JLabel("Confirmar Senha: ");
	private JTextField campoEmail = new JTextField();
	private JTextField campoUsuario = new JTextField();
	private JPasswordField campoSenha = new JPasswordField();
	private JPasswordField campoConfirmarSenha = new JPasswordField();
	private JButton returnLogin = new JButton("Voltar para a p�gina de login");
	private JButton cadastrar = new JButton("Cadastrar");
	private JCheckBox adm = new JCheckBox("Administrator");
	private JCheckBox student = new JCheckBox("Student");
	private int c = 0;
	// Variaveis para armazenar os dados recebidos e/ou criptografados
	private String senhaCadastrada;
	private String usuarioCadastrado;
	private String emailCadastrado;
	private String confirmacaoSenha;
	public byte[] senhaCriptografadaDB;
	String codeReceived;
	private int[] vetor = new int[5];
	Random rand = new Random();
	String finalValueCode;
	ResultSet rs;

	// Dimensionar o frame de acordo com o tamanho da tela
	private void Screen() {
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();

		framePrincipalCadastro.setLocation(((tela.width - framePrincipalCadastro.getSize().width) / 2),
				((tela.height - framePrincipalCadastro.getSize().height) / 2));
		framePrincipalCadastro.setVisible(true);
	}

	public void metodoPrincipalCadastro() {
		if (c == 0) {
			metodoCriacao();
			manipulandoDados();
			Screen();
			c++;
		} else {
			framePrincipalCadastro.setVisible(true);
		}
	}

	public byte[] getSenhaCriptografadaDB() {
		return senhaCriptografadaDB;
	}

	public void setSenhaCriptografadaDB(byte[] senhaCriptografadaDB) {
		this.senhaCriptografadaDB = senhaCriptografadaDB;
	}

	// Variaveis para conex�o no DB
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://127.0.0.1:3306/courseJava";

	// Gerando gets e sets para as variaveis
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

	public void metodoCriacao() {
		framePrincipalCadastro.setVisible(true);
		framePrincipalCadastro.add(painelPrincipalCadastro);
		framePrincipalCadastro.setResizable(false);
		framePrincipalCadastro.setBounds(600, 200, 600, 700);
		framePrincipalCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipalCadastro.setTitle("Cadaster");
		painelPrincipalCadastro.setBackground(new Color(35, 35, 142));
		painelPrincipalCadastro.add(campoEmail);
		painelPrincipalCadastro.add(labelsenha);
		painelPrincipalCadastro.add(labelEmail);
		painelPrincipalCadastro.add(campoSenha);
		painelPrincipalCadastro.add(labelUsuario);
		painelPrincipalCadastro.add(campoConfirmarSenha);
		painelPrincipalCadastro.add(image2);
		painelPrincipalCadastro.add(labelConfirmarSenha);
		painelPrincipalCadastro.add(image);
		painelPrincipalCadastro.add(cadastrar);
		painelPrincipalCadastro.add(campoUsuario);
		painelPrincipalCadastro.add(returnLogin);
		painelPrincipalCadastro.add(student);
		painelPrincipalCadastro.add(adm);
		Dimension tela = framePrincipalCadastro.getSize();
		framePrincipalCadastro.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png")));

		painelPrincipalCadastro.setLayout(null);
		labelEmail.setForeground(Color.WHITE);
		labelsenha.setForeground(Color.WHITE);
		labelUsuario.setForeground(Color.WHITE);
		labelConfirmarSenha.setForeground(Color.WHITE);
		labelsenha.setFont(new java.awt.Font("ink free", 1, 16));
		labelEmail.setFont(new java.awt.Font("ink free", 1, 16));
		labelUsuario.setFont(new java.awt.Font("ink free", 1, 16));
		labelConfirmarSenha.setFont(new java.awt.Font("ink free", 1, 16));

		student.setBounds(((tela.width / 2) - 180), ((tela.height / 2) + 150), 350, 30);
		adm.setBounds(((tela.width / 2) - 180), ((tela.height / 2) + 100), 350, 30);
		image.setBounds(((tela.width / 2) - 350), (-90), 400, 400);
		image2.setBounds(((tela.width / 2) - 50), (-70), 400, 400);

		labelEmail.setBounds(((tela.width / 2) - 155), ((tela.height / 2) - 85), 200, 100);
		labelsenha.setBounds(((tela.width / 2) - 160), ((tela.height / 2) - 37), 200, 100);
		labelConfirmarSenha.setBounds(((tela.width / 2) - 255), ((tela.height / 2) + 50), 200, 30);
		labelUsuario.setBounds(((tela.width / 2) - 175), ((tela.height / 2) - 135), 200, 100);

		campoUsuario.setBounds(((tela.width / 2) - 80), ((tela.height / 2) - 100), 250, 30);
		campoEmail.setBounds(((tela.width / 2) - 80), ((tela.height / 2) - 50), 250, 30);
		campoSenha.setBounds(((tela.width / 2) - 80), ((tela.height / 2)), 250, 30);
		campoConfirmarSenha.setBounds(((tela.width / 2) - 80), ((tela.height / 2) + 50), 250, 30);
		cadastrar.setBounds(((tela.width / 2) - 180), ((tela.height / 2) + 200), 350, 30);
		returnLogin.setBounds(((tela.width / 2) - 180), ((tela.height / 2) + 250), 350, 30);
	}

	public void manipulandoDados() {
		adm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				student.setSelected(false);

			}
		});

		student.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adm.setSelected(false);
			}
		});

		cadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				setConfirmacaoSenha(String.valueOf(campoConfirmarSenha.getPassword()));
				setUsuarioCadastrado(campoUsuario.getText());
				setSenhaCadastrada(String.valueOf(campoSenha.getPassword()));
				setEmailCadastrado(campoEmail.getText());

				if (!(getEmailCadastrado().contains("@"))) {
					JOptionPane.showMessageDialog(null, "Insert a one correct email");
				}
				
				if ((getEmailCadastrado().equals("")) || (getSenhaCadastrada().equals(""))
						|| (getConfirmacaoSenha().equals("")) || (getUsuarioCadastrado().equals(""))) {
					JOptionPane.showMessageDialog(null, "Fill in all the fields");
					campoEmail.setText("");
					campoSenha.setText("");
					campoConfirmarSenha.setText("");
					campoUsuario.setText("");
				}

				if ((!(adm.isSelected())) && (!(student.isSelected()))) {
					JOptionPane.showMessageDialog(null, "Choice between 'Administrator' and 'Student'");
				}

				else if (!(getSenhaCadastrada().equals(getConfirmacaoSenha()))) {
					JOptionPane.showMessageDialog(null, "Password field is different from Confirm Password field");
				} else if ((getSenhaCadastrada().length()) <= 3) {
					JOptionPane.showMessageDialog(null, "Put a password more strong!");
				} else {
					try {
						Class.forName(DRIVER);
						Connection conecta = DriverManager.getConnection(URL, "root", "hunter");
						Statement stmt = conecta.createStatement();

						String sql;

						if (adm.isSelected()) {
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
											+ getSenhaCadastrada() + "', true, false);";
									stmt = conecta.prepareStatement(sql);
									stmt.execute(sql);
									JOptionPane.showMessageDialog(null, "You have been cadaster with success!");
									objLogin.metodoPrincipalLogin();
									framePrincipalCadastro.setVisible(false);
								}

								else if (rs.getInt("quantidade") != 0) {
									JOptionPane.showMessageDialog(null,
											"This email has been inserted on the app, please, input another email");
									campoEmail.setText("");
									campoUsuario.setText("");
								}

								else if (rs2.getInt("quantidade") != 0) {
									JOptionPane.showMessageDialog(null,
											"This user has been inserted on the app, please, input another user");
									campoEmail.setText("");
									campoUsuario.setText("");
								}

							}

						}

						else if (student.isSelected()) {
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
									objLogin.metodoPrincipalLogin();
									framePrincipalCadastro.setVisible(false);
								}

								else if (rs.getInt("quantidade") != 0) {
									JOptionPane.showMessageDialog(null,
											"This email has been inserted on the app, please, input another email");
									campoEmail.setText("");
									campoUsuario.setText("");
								}

								else if (rs2.getInt("quantidade") != 0) {
									JOptionPane.showMessageDialog(null,
											"This user has been inserted on the app, please, input another user");
									campoEmail.setText("");
									campoUsuario.setText("");
								}

							}
						}

						else {
							JOptionPane.showMessageDialog(null, "What do you wat to be, student or adm?");
						}

					} catch (SQLException error) {
						System.out.println(error.toString());
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();

					}
				}
			}
		});

		returnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				objLogin.metodoPrincipalLogin();
				CadastrarClientes.framePrincipalCadastro.dispose();
			}
		});

	}

	/*
	 * public boolean sendEmail() { vetor[0] = rand.nextInt(9);
	 * 
	 * vetor[1] = rand.nextInt(9); while (vetor[0] == vetor[1]) vetor[1] =
	 * rand.nextInt(9);
	 * 
	 * vetor[2] = rand.nextInt(9); while (vetor[1] == vetor[2] || vetor[2] ==
	 * vetor[0]) vetor[2] = rand.nextInt(9);
	 * 
	 * vetor[3] = rand.nextInt(9); while (vetor[3] == vetor[0] || vetor[3] ==
	 * vetor[1] || vetor[3] == vetor[2]) vetor[3] = rand.nextInt(9);
	 * 
	 * vetor[4] = rand.nextInt(9); while (vetor[4] == vetor[0] || vetor[4] ==
	 * vetor[1] || vetor[4] == vetor[2] || vetor[4] == vetor[3]) vetor[4] =
	 * rand.nextInt(9);
	 * 
	 * finalValueCode = vetor[0] + "" + vetor[1] + "" + vetor[2] + "" + vetor[3] +
	 * "" + vetor[4];
	 * 
	 * objEmails.enviandoEmail(getEmailCadastrado(), finalValueCode);
	 * cadastrar.setText("Please, wait!"); cadastrar.setForeground(Color.RED);
	 * 
	 * new Thread(new Runnable() { public void run() {
	 * 
	 * try { Thread.sleep(2000); JOptionPane.showMessageDialog(null,
	 * "Enviamos um código no seu email, reescreva ele aqui logo em seguida para continuar como adm!"
	 * , "Attention", 3);
	 * 
	 * codeReceived =
	 * JOptionPane.showInputDialog("Digite o codigo que foi enviado!");
	 * 
	 * LoginClientes.framePrincipalLogin.dispose(); } catch (InterruptedException e)
	 * {
	 * 
	 * e.printStackTrace(); } } }).start();
	 * 
	 * if (finalValueCode == codeReceived) return true;
	 * 
	 * return false; }
	 */

}
