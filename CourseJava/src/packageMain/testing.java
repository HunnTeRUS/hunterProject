package packageMain;

import javax.swing.*;

public class testing extends CreateQuestions {
	
	public static CreateQuestions questions = new CreateQuestions();
	public static MainInterface maininterface = new MainInterface();
	
	static JFrame mainFrame = new JFrame();
	static JPanel mainPanel = new JPanel();
	ImageIcon image = new ImageIcon(getClass().getResource("icons8-cor-48.png"));
	JLabel imageIcon = new JLabel(image);
	
	int i;
	
	JLabel question   = new JLabel("");
	JButton correct    = new JButton();
	JButton incorrect  = new JButton();
	
	public static void main(String[] args) {
		testing test = new testing();
		test.settingInterfaceStudy();
	}
	
	public void settingInterfaceStudy() {
		String testt = JOptionPane.showInputDialog("Says your name");
		System.out.println(testt);
	}

}


