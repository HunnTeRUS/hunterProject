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

	//Instanciando os objetos
	static LoginClientes objLogin = new LoginClientes();
	static MainInterface objClient = new MainInterface();
	public static CadastrarClientes objCadastrorCliente = new CadastrarClientes();


	//Criando os objetos visuais

	ImageIcon imagem = new ImageIcon(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png"));
	public JLabel image = new JLabel(imagem);
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
	private JButton RecSenha = new JButton("Esqueci minha senha");

	//Criando as variaveis com get e set
	public String senha;
	public String email;
	public String usuario;
	private String senhaDecriptada;
	private byte[] senhaCriptografada;
	

	public static void main(String[] args) {
		objLogin.metodoPrincipalLogin();
	}


	public void metodoPrincipalLogin() {
		metodoCriacao();
		manipulandoDados();
	}
	
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String  URL   = "jdbc:mysql://127.0.0.1:3306/clientes";

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
		framePrincipalLogin.setExtendedState(JFrame.MAXIMIZED_BOTH);
		framePrincipalLogin.add(painelPrincipalLogin);
		framePrincipalLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipalLogin.setTitle("Login");
		painelPrincipalLogin.setBackground(new Color(35, 35, 142));
		painelPrincipalLogin.add(labelemail);
		painelPrincipalLogin.add(labelsenha);
		painelPrincipalLogin.add(labelusuario);
		painelPrincipalLogin.add(campoUsuario);
		painelPrincipalLogin.add(campoEmail);
		painelPrincipalLogin.add(campoSenha);
		painelPrincipalLogin.add(image);
		painelPrincipalLogin.add(RecSenha);
		painelPrincipalLogin.add(enviarDados);
		painelPrincipalLogin.add(botaoCadastro);
		enviarDados.setBounds(700, 650, 350, 30);
		RecSenha.setBounds(700, 750, 350, 30);
		botaoCadastro.setBounds(700, 700, 350, 30);
		image.setBounds(680, 120, 400, 400);
		painelPrincipalLogin.setLayout(null);
		labelemail.setForeground(Color.WHITE);
		labelsenha.setForeground(Color.WHITE);
		labelusuario.setForeground(Color.WHITE);
		labelsenha.setFont(new java.awt.Font("ink free", 1, 16));
		labelemail.setFont(new java.awt.Font("ink free", 1, 16));
		labelusuario.setFont(new java.awt.Font("ink free", 1, 16));
		labelemail.setBounds(700, 450, 200, 100);
		labelusuario.setBounds(700, 500, 200, 100);
		labelsenha.setBounds(700, 550, 200, 100); 
		campoEmail.setBounds(850, 485, 200, 30);
		campoSenha.setBounds(850, 585, 200, 30);
		campoUsuario.setBounds(850, 535, 200, 30);
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
					Connection conecta = DriverManager.getConnection(URL, "root", "");

					//getSenha()                = Senha recebida do usuario
					//getSenhaDecriptada()   	= Senha enviada pelo usuario decriptada (nao tem necessidade)
					//getSenhaCriptografada()   = sENHA recebida do usuario e enviada a outra classse para ser criptografada
					//getSenhaRecebidaDB()      = Pega a senha que esta no BG (criptografada) e é decriptada para a comparação ser feita	

					String sql;

					sql = "SELECT email, usuario, senha FROM dadosClientes WHERE usuario='" + getUsuario() + "' OR email='" + getEmail() +"';";

					PreparedStatement stmt = conecta.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();

					while(rs.next()) {
						if(((getUsuario().equals(rs.getString("usuario"))) && (getSenha().equals(rs.getString("senha")))))
						{
							JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
							System.out.println("oooo");
							objClient.mainMethod();
						}
							
						
						else {
							JOptionPane.showMessageDialog(null, "Usuário/Email e senha incorretos!");}
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



}
