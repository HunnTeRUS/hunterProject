package packageMain;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class Teste extends JFrame {

	private JPanel contentPane;

	public Teste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(54, 33, 89));
		panel.setBounds(0, 0, 359, 615);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelSwitch = new JLabel("Switch the course!");
		labelSwitch.setFont(new Font("Noto Sans Mono", Font.BOLD, 14));
		labelSwitch.setHorizontalAlignment(SwingConstants.CENTER);
		labelSwitch.setBounds(71, 81, 157, 56);
		panel.add(labelSwitch);
		
		JButton btnNewButton = new JButton("Math");
		btnNewButton.setBounds(43, 200, 208, 25);
		panel.add(btnNewButton);
		
		JButton btnProgramming = new JButton("Programming");
		btnProgramming.setBounds(43, 249, 208, 25);
		panel.add(btnProgramming);
		
		JButton btnEnglish = new JButton("English");
		btnEnglish.setBounds(43, 299, 208, 25);
		panel.add(btnEnglish);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(359, 0, 607, 615);
		contentPane.add(panel_1);
	}
}
