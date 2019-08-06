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
	private static ClassAdm objAdm = new ClassAdm();
	private static ClassStudent objStudent = new ClassStudent();

	// Criando os objetos visuais
	ImageIcon imagem = new ImageIcon(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png"));
	ImageIcon imagem2 = new ImageIcon(getClass().getResource("logo-branco-transparente.png"));
	public JLabel image = new JLabel(imagem);
	public JLabel image2 = new JLabel(imagem2);

	static JFrame framePrincipalLogin = new JFrame();
	static JPanel painelPrincipalLogin = new JPanel();
	JLabel labelemail = new JLabel("Email: ");
	JLabel labelusuario = new JLabel("Usuario: ");
	JLabel labelsenha = new JLabel("Senha: ");
	private JTextField campoEmail = new JTextField();
	private JTextField campoUsuario = new JTextField();
	private JPasswordField campoSenha = new JPasswordField();
	private JButton enviarDados = new JButton("Login");
	private JButton botaoCadastro = new JButton("Não tem cadastro? Clique aqui!");
	private JButton RecSenha = new JButton("Esqueci minha senha - Em breve kkk");

	// Toolkit.getDefaultToolkit().getScreenSize();
	// Criando as variaveis com get e set
	public String senha;
	public String email;
	public String usuario;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
		painelPrincipalLogin.add(labelemail);
		painelPrincipalLogin.add(labelsenha);
		painelPrincipalLogin.add(labelusuario);
		painelPrincipalLogin.add(campoUsuario);
		painelPrincipalLogin.add(campoEmail);
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

		labelemail.setBounds(((tela.width / 2) - 180), ((tela.height / 2) - 80), 200, 100);
		labelusuario.setBounds(((tela.width / 2) - 180), ((tela.height / 2) - 30), 200, 100);
		labelsenha.setBounds(((tela.width / 2) - 180), ((tela.height / 2) + 20), 250, 100);

		campoEmail.setBounds(((tela.width / 2) - 80), ((tela.height / 2) - 40), 250, 30);
		campoSenha.setBounds(((tela.width / 2) - 80), ((tela.height / 2) + 60), 250, 30);
		campoUsuario.setBounds(((tela.width / 2) - 80), ((tela.height / 2) + 10), 250, 30);

		labelemail.setForeground(Color.WHITE);
		labelsenha.setForeground(Color.WHITE);
		labelusuario.setForeground(Color.WHITE);
		labelsenha.setFont(new java.awt.Font("ink free", 1, 16));
		labelemail.setFont(new java.awt.Font("ink free", 1, 16));
		labelusuario.setFont(new java.awt.Font("ink free", 1, 16));

		RecSenha.setEnabled(false);
	}

	private void manipulandoDados() {
		enviarDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSenha(String.valueOf(campoSenha.getPassword()));
				setEmail(campoEmail.getText());
				setUsuario(campoUsuario.getText());

				try {
					Class.forName(DRIVER);
					Connection conecta = DriverManager.getConnection(URL, "root", "hunter");

					// getSenha() = Senha recebida do usuario
					// getSenhaDecriptada() = Senha enviada pelo usuario
					// decriptada (nao tem
					// necessidade)
					// getSenhaCriptografada() = sENHA recebida do usuario e
					// enviada a outra classse
					// para ser criptografada
					// getSenhaRecebidaDB() = Pega a senha que esta no BG
					// (criptografada) e �
					// decriptada para a compara��o ser feita

					String sql;

					sql = "SELECT userr, email, senha, adm, student FROM users WHERE userr='" + getUsuario()
							+ "' OR email='" + getEmail() + "';";

					PreparedStatement stmt = conecta.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {
						if (((getUsuario().equals(rs.getString("userr"))) && (getSenha().equals(rs.getString("senha"))))
								|| ((getEmail().equals(rs.getString("email")))
										&& (getSenha().equals(rs.getString("senha"))))
								|| ((getEmail().equals(rs.getString("email")))
										&& (getSenha().equals(rs.getString("senha")))
										&& (getUsuario().equals(rs.getString("userr"))))) {

							if (rs.getInt("adm") == 1) {

								// JOptionPane.showMessageDialog(null, "Login
								// realizado com sucesso!");
								enviarDados.setText("Logging in...");
								enviarDados.setForeground(Color.RED);
								// objAdm.mainMethod();
								new Thread(new Runnable() {
									public void run() {

										try {
											Thread.sleep(2000);
											JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
											//objClient.mainMethod();
											objAdm.mainMethod();
											LoginClientes.framePrincipalLogin.dispose();
										} catch (InterruptedException e) {

											e.printStackTrace();
										}
									}
								}).start();
							} else {
								JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
								LoginClientes.framePrincipalLogin.dispose();
								objStudent.mainMethod();
							}
						} else {
							JOptionPane.showMessageDialog(null, "Usuario/Email e senha incorretos!");
						}
					}

					conecta.close();
					rs.close();
					stmt.close();

				} catch (SQLException error) {
					System.out.println(error.toString());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
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
