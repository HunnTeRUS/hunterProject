package packageMain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;


public class LoginClientes {

	// Instanciando os objetos
	static LoginClientes objLogin = new LoginClientes();
	static MainInterface objClient = new MainInterface();
	public static CadastrarClientes objCadastrorCliente = new CadastrarClientes();
	static ForgotPassword objPassword = new ForgotPassword();

	// Criando os objetos visuais
	ImageIcon imagem = new ImageIcon(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png"));
	ImageIcon imagem2 = new ImageIcon(getClass().getResource("logo-branco-transparente.png"));
	public JLabel image = new JLabel(imagem);
	public JLabel image2 = new JLabel(imagem2);

	static JFrame framePrincipalLogin = new JFrame();
	static JPanel painelPrincipalLogin = new JPanel();
	// JLabel labelemail = new JLabel("Email: ");
	JLabel labelusuario = new JLabel("User/Email: ");
	JLabel labelsenha = new JLabel("Password: ");
	// private JTextField campoEmail = new JTextField();
	JTextField campoUsuario = new JTextField();
	private JPasswordField campoSenha = new JPasswordField();
	private JButton enviarDados = new JButton("Login");
	private JButton botaoCadastro = new JButton("No registration? click here!");
	private JButton RecSenha = new JButton("I forgot my password!");

	// Toolkit.getDefaultToolkit().getScreenSize();
	// Criando as variaveis com get e set
	public String senha;
	public String email;
	public static String usuario;
	private String senhaDecriptada;
	private byte[] senhaCriptografada;
	private int c = 0;
	// Dimensionar o frame de acordo com o tamanho da tela
	/*
	 * private void Screen(){
	 * 
	 * 
	 * framePrincipalLogin.setLocation(((tela.width -
	 * framePrincipalLogin.getSize().width)/2),((tela.height -
	 * framePrincipalLogin.getSize().height)/2));
	 * framePrincipalLogin.setVisible(true); }
	 */

	public void metodoPrincipalLogin() {
		if (c == 0) {
			metodoCriacao();
			manipulandoDados();
			// Screen();
			c++;
		} else {
			framePrincipalLogin.setVisible(true);
		}
	}

	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://127.0.0.1/courseJava";

	public byte[] getSenhaCriptografada() {
		return senhaCriptografada;
	}

	public void setSenhaCriptografada(byte[] senhaCriptografada) {
		this.senhaCriptografada = senhaCriptografada;
	}

	static public String getUsuario() {
		return usuario;
	}

	static public void setUsuario(String usuario) {
		LoginClientes.usuario = usuario;
	}

	public String getSenhaDecriptada() {
		return senhaDecriptada;
	}

	public void setSenhaDecriptada(String senhaDecriptada) {
		this.senhaDecriptada = senhaDecriptada;
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

	private void metodoCriacao() {
		framePrincipalLogin.setVisible(true);
		framePrincipalLogin.setBounds(600, 200, 600, 700);
		framePrincipalLogin.add(painelPrincipalLogin);
		framePrincipalLogin.setResizable(false);
		framePrincipalLogin.setTitle("Login");
		painelPrincipalLogin.setBackground(new Color(35, 35, 142));
		framePrincipalLogin.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png")));
		// painelPrincipalLogin.add(labelemail);
		painelPrincipalLogin.add(labelsenha);
		painelPrincipalLogin.add(labelusuario);
		painelPrincipalLogin.add(campoUsuario);
		// painelPrincipalLogin.add(campoEmail);
		painelPrincipalLogin.add(campoSenha);
		painelPrincipalLogin.add(image);
		painelPrincipalLogin.add(image2);
		painelPrincipalLogin.add(RecSenha);
		painelPrincipalLogin.add(enviarDados);
		painelPrincipalLogin.add(botaoCadastro);
		Dimension tela = framePrincipalLogin.getSize();

		painelPrincipalLogin.setLayout(null);
		enviarDados.setBounds(((tela.width / 2) - 180), ((tela.height / 2) + 150), 350, 30);
		RecSenha.setBounds(((tela.width / 2) - 180), ((tela.height / 2) + 200), 350, 30);
		botaoCadastro.setBounds(((tela.width / 2) - 180), ((tela.height / 2) + 250), 350, 30);

		image.setBounds(((tela.width / 2) - 350), -70, 400, 400);
		image2.setBounds((tela.width / 2) - 50, -50, 400, 400);

		// labelemail.setBounds(((tela.width / 2) - 180), ((tela.height / 2) - 80), 200,
		// 100);
		labelusuario.setBounds(((tela.width / 2) - 200), ((tela.height / 2) - 30), 200, 100);
		labelsenha.setBounds(((tela.width / 2) - 190), ((tela.height / 2) + 20), 250, 100);

		// campoEmail.setBounds(((tela.width / 2) - 80), ((tela.height / 2) - 40), 250,
		// 30);
		campoSenha.setBounds(((tela.width / 2) - 80), ((tela.height / 2) + 60), 250, 30);
		campoUsuario.setBounds(((tela.width / 2) - 80), ((tela.height / 2) + 10), 250, 30);

		// labelemail.setForeground(Color.WHITE);
		labelsenha.setForeground(Color.WHITE);
		labelusuario.setForeground(Color.WHITE);
		labelsenha.setFont(new java.awt.Font("ink free", 1, 16));
		// labelemail.setFont(new java.awt.Font("ink free", 1, 16));
		labelusuario.setFont(new java.awt.Font("ink free", 1, 16));
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
					Connection conecta = DriverManager.getConnection(URL, "root", "hunter");

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
										} catch (InterruptedException e) {

											e.printStackTrace();
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

		botaoCadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				objCadastrorCliente.metodoPrincipalCadastro();
				framePrincipalLogin.setVisible(false);
			}
		});

	}

	public static void main(String[] args) {
		objLogin.metodoPrincipalLogin();
	}
}
