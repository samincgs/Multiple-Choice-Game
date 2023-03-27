import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartScreen implements ActionListener{

	JFrame window;
	JPanel textPanel, buttonPanel;
	JLabel textLabel;
	JButton startButton;
	
	public StartScreen() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800, 600);
		window.setLayout(null);
		window.setLocationRelativeTo(null);
		window.getContentPane().setBackground(Color.black);
		
		textPanel = new JPanel();
		textPanel.setBounds(0,100,800,200);
		textPanel.setBackground(Color.black);
		
		textLabel = new JLabel();
		textLabel.setText("GENERAL KNOWLEDGE QUIZ");
		textLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 45));
		
		textLabel.setForeground(Color.white);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(300,400,200,100);
		buttonPanel.setBackground(Color.black);
		
		
		startButton = new JButton("BEGIN");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(new Font("Arial Rounded MT Boldn", Font.PLAIN, 25));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		
		textPanel.add(textLabel);
		buttonPanel.add(startButton);
		
		window.add(textPanel);
		window.add(buttonPanel);
		
		
		window.setVisible(true);
		
		start();
	}
	
	public void start() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== startButton) {
			window.dispose();
			new Quiz();
		
		}
		
	}
	
}
