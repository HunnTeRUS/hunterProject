package view;

import model.ConectionDB;
import model.RequisitionsADM;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequisitionsVisualADM {

	//ProfileStudent student = new ProfileStudent();
	ConectionDB db = new ConectionDB();

	private JPanel contentPane;
	public static JFrame mainFrame = new JFrame();
	private JTextField userField;
	private JTextField emailField;
	JTextArea explanationField = new JTextArea();
	RequisitionsADM adm = new RequisitionsADM();
	JButton btnRecuse = new JButton("Recuse");
	JButton btnAccept = new JButton("Accept");

	public void requisitionsMainMethod() {
		RequisitionsVisual();
		settingValues();
	}

	public void RequisitionsVisual() {
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setBounds(100, 100, 677, 420);
		mainFrame.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(-11, -20, 703, 430);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(UIManager.getColor("Button.shadow"));

		JLabel lblOpenRequisitions = new JLabel("Open Requisitions");
		lblOpenRequisitions.setBorder(null);
		lblOpenRequisitions.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblOpenRequisitions.setForeground(Color.BLACK);
		lblOpenRequisitions.setBounds(262, 66, 170, 15);
		panel.add(lblOpenRequisitions);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(126, 114, 66, 15);
		panel.add(lblName);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(126, 166, 66, 15);
		panel.add(lblEmail);

		JLabel lblExplanationOfRequest = new JLabel("Explanation:");
		lblExplanationOfRequest.setBounds(126, 223, 96, 15);
		panel.add(lblExplanationOfRequest);

		userField = new JTextField();
		userField.setEditable(false);
		userField.setBorder(null);
		userField.setBounds(207, 106, 278, 31);
		panel.add(userField);
		userField.setColumns(10);

		emailField = new JTextField();
		emailField.setEditable(false);
		emailField.setBorder(null);
		emailField.setColumns(10);
		emailField.setBounds(207, 158, 278, 31);
		panel.add(emailField);

		explanationField.setEditable(false);
		explanationField.setWrapStyleWord(true);
		explanationField.setLineWrap(true);
		explanationField.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		explanationField.setText("aaa");
		explanationField.setBounds(226, 223, 259, 105);
		panel.add(explanationField);

		btnRecuse.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		btnRecuse.setBackground(Color.WHITE);
		btnRecuse.setBounds(112, 363, 183, 31);
		panel.add(btnRecuse);

		btnAccept.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		btnAccept.setBackground(Color.WHITE);
		btnAccept.setBounds(373, 363, 183, 31);
		panel.add(btnAccept);
	}

	public void settingValues() {
		adm.receiveRequisitionsDB();
		userField.setText(adm.getUser());
		emailField.setText(adm.getEmail());
		explanationField.setText(adm.getExplanation());

		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(db.getConnection()){
					PreparedStatement stmt;
					String SQL, deleteRequisition;

					SQL = "UPDATE users SET adm=1, student=0 WHERE userr='" + userField.getText() + "';";
					deleteRequisition = "DELETE FROM requisitions WHERE idUser=" + adm.getCode() + ";";
					try {
						stmt = db.con.prepareStatement(SQL);
						stmt.executeUpdate();

						stmt = db.con.prepareStatement(deleteRequisition);
						stmt.execute();

						settingValues();

					} catch (SQLException ex) {
						ex.printStackTrace();
					}

					db.close();
				}
			}
		});

		btnRecuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//student.btnIWannaBe.setEnabled(true);
				settingValues();
			}
		});
	}
}
