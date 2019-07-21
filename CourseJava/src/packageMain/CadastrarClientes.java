package packageMain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class CadastrarClientes {

	static LoginClientes objLogin = new LoginClientes();
	static CadastrarClientes objSignUp = new CadastrarClientes();
	ImageIcon imagem = new ImageIcon(getClass().getResource("Sem-Logo-Branco-transparente-cortado.png"));
	public JLabel image = new JLabel(imagem);
	static JFrame framePrincipalCadastro = new JFrame();
	static JPanel painelPrincipalCadastro= new JPanel();
	JLabel labelEmail = new JLabel("Email: ");
	JLabel labelsenha = new JLabel("Senha: ");
	JLabel labelUsuario = new JLabel("Usuario: ");
	JLabel labelConfirmarSenha = new JLabel("Confirmar Senha: ");
	private JTextField campoEmail = new JTextField();
	private JTextField campoUsuario = new JTextField();
	private JPasswordField campoSenha = new JPasswordField();
	private JPasswordField campoConfirmarSenha = new JPasswordField();
	private JButton returnLogin = new JButton("Voltar para a página de login");
	private JButton cadastrar = new JButton("Cadastrar");
	private JCheckBox adm = new JCheckBox("Administrator");
	private JCheckBox student = new JCheckBox("Student");


	//Variaveis para armazenar os dados recebidos e/ou criptografados
	private String senhaCadastrada;
	private String usuarioCadastrado;
	private String emailCadastrado;
	private String confirmaçaoSenha;
	public byte[] senhaCriptografadaDB;
	
	public void metodoPrincipalCadastro() {
		metodoCriacao();
		manipulandoDados();
	}

	public byte[] getSenhaCriptografadaDB() {
		return senhaCriptografadaDB;
	}

	public void setSenhaCriptografadaDB(byte[] senhaCriptografadaDB) {
		this.senhaCriptografadaDB = senhaCriptografadaDB;
	}

	//Variaveis para conexão no DB
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String  URL   = "jdbc:mysql://127.0.0.1:3306/coursejava";

	//Gerando gets e sets para as variaveis
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
		return confirmaçaoSenha;
	}

	public void setConfirmacaoSenha(String confirmaçaoSenha) {
		this.confirmaçaoSenha = confirmaçaoSenha;
	}

	public void metodoCriacao() {
		framePrincipalCadastro.setVisible(true);
		framePrincipalCadastro.setExtendedState(JFrame.MAXIMIZED_BOTH);
		framePrincipalCadastro.add(painelPrincipalCadastro);
		framePrincipalCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipalCadastro.setTitle("Login");
		painelPrincipalCadastro.setBackground(new Color(35, 35, 142));
		painelPrincipalCadastro.add(campoEmail);
		painelPrincipalCadastro.add(labelsenha);
		painelPrincipalCadastro.add(labelEmail);
		painelPrincipalCadastro.add(campoSenha);
		painelPrincipalCadastro.add(labelUsuario);
		painelPrincipalCadastro.add(campoConfirmarSenha);
		painelPrincipalCadastro.add(labelConfirmarSenha);
		painelPrincipalCadastro.add(image);
		painelPrincipalCadastro.add(cadastrar);
		painelPrincipalCadastro.add(campoUsuario);
		painelPrincipalCadastro.add(returnLogin);
		painelPrincipalCadastro.add(student);
		painelPrincipalCadastro.add(adm);

		student.setBounds(800, 650, 350, 30);
		adm.setBounds(800, 700, 350, 30);
		image.setBounds(780, 120, 400, 400);
		painelPrincipalCadastro.setLayout(null);
		labelEmail.setForeground(Color.WHITE);
		labelsenha.setForeground(Color.WHITE);
		labelUsuario.setForeground(Color.WHITE);
		labelConfirmarSenha.setForeground(Color.WHITE);
		labelsenha.setFont(new java.awt.Font("ink free", 1, 16));
		labelEmail.setFont(new java.awt.Font("ink free", 1, 16));
		labelUsuario.setFont(new java.awt.Font("ink free", 1, 16));
		labelConfirmarSenha.setFont(new java.awt.Font("ink free", 1, 16));
		labelEmail.setBounds(800, 400, 200, 100);
		labelsenha.setBounds(800, 500, 200, 100); 
		campoUsuario.setBounds(900, 435, 250, 30);
		campoEmail.setBounds(900, 485, 250, 30);
		campoSenha.setBounds(900, 535, 250, 30);
		labelConfirmarSenha.setBounds(750, 585, 200, 30);
		labelUsuario.setBounds(800, 449, 200, 100);
		campoConfirmarSenha.setBounds(900, 585, 250, 30);
		cadastrar.setBounds(800, 750, 350, 30);
		returnLogin.setBounds(800, 800, 350, 30);
	}

	public void manipulandoDados() {
		adm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				student.setSelected(false);
			}});
		
		student.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adm.setSelected(false);
			}});
		
		cadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setConfirmacaoSenha(String.valueOf(campoConfirmarSenha.getPassword()));
				setUsuarioCadastrado(campoUsuario.getText());
				setSenhaCadastrada(String.valueOf(campoSenha.getPassword())); 
				setEmailCadastrado(campoEmail.getText());
				

				if((getEmailCadastrado().equals("")) || (getSenhaCadastrada().equals("")) || (getConfirmacaoSenha().equals("")) || (getUsuarioCadastrado().equals(""))) {
					JOptionPane.showMessageDialog(null, "Fill in all the fields");
					campoEmail.setText("");
					campoSenha.setText("");
					campoConfirmarSenha.setText("");
					campoUsuario.setText("");
				}
				
				if((!(adm.isSelected())) && (!(student.isSelected()))) {
					JOptionPane.showMessageDialog(null, "Choice between 'Administrator' and 'Student'");
				}
				
				else if(!(getSenhaCadastrada().equals(getConfirmacaoSenha()))) {
					JOptionPane.showMessageDialog(null, "Password field is different from Confirm Password field");
				}
				else if((getSenhaCadastrada().length()) <= 3) {
					JOptionPane.showMessageDialog(null, "Put a password more strong!");
				}
				else {	
					try {
						Class.forName(DRIVER);
						Connection conecta = DriverManager.getConnection(URL, "root", "");
						Statement stmt = conecta.createStatement();

						String sql; 
						
						if(adm.isSelected()) {
							sql = "INSERT INTO users (userr, email, senha, adm, student) values('" + getEmailCadastrado() + "', '" + getUsuarioCadastrado() + "', '" + getSenhaCadastrada()  + "', true, false);";
							stmt = conecta.prepareStatement(sql);	
							stmt.execute(sql);		
						}
						
						if (student.isSelected()) {
							sql = "INSERT INTO users (userr, email, senha, adm, student) values('" + getEmailCadastrado() + "', '" + getUsuarioCadastrado() + "', '" + getSenhaCadastrada()  + "', false, true);";
							stmt = conecta.prepareStatement(sql);	
							stmt.execute(sql);		
						}
																										
						conecta.close();
						stmt.close();
						
						JOptionPane.showMessageDialog(null, "You have been cadaster with success!");
						
						objLogin.metodoPrincipalLogin();
						framePrincipalCadastro.setVisible(false);
			
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Error, try again!");
					} 
				}
			}
		});
		
		returnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				objLogin.metodoPrincipalLogin();
				CadastrarClientes.framePrincipalCadastro.dispose();
			}});


	}

}
