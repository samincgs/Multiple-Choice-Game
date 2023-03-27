/*
 * 
 */
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Quiz implements ActionListener{

	//QUESTIONS
	String[] questions = {"Jeff Bezos is the founder of which famous company?",
						  "Which country held the 2016 Summer Olympics?",
						  "How many bones are there in the human body?",
						  "Which is the largest ocean?",
						  "Who painted the Mona Lisa?",
						  "What is the longest river in the world?",
						  "How many elements are there on the periodic table?",
						  "What country is Prague in?",
						  "The human body is made up of how much water?",
						  "What is the most visited tourist attraction in the world?"};
	
	
	//MULTIPLE CHOICES
	String[][] options = {{"Tesla", "Apple" ,"Facebook" , "Amazon"},
						  {"Brazil", "China", "Japan", "Germany"},
						  {"206", "182", "200", "216"},
						  {"Arctic", "Pacific", "Atlantic", "Indian"},
						  {"Vincent Van Gogh", "Leonardo Da Vinci", "Claude Monet", "Pablo Picasso"},
						  {"Congo", "Hudson", "Nile", "Amazon"},
						  {"120", "112", "116", "118"},
						  {"Czech Republic", "Hungary", "Netherlands", "Germany"},
						  {"50%", "60%", "72%", "65%"},
						  {"Great Wall of China", "Colosseum", "Statue of Liberty", "Eiffel Tower"}};
	
	//ANSWERS
	char[] answers = {'D',
					  'A',
					  'A',
					  'B',
					  'B',
					  'C',
					  'D',
					  'A',
					  'B',
					  'D'};
	
	//VARIABLES
	char answer;
	int index = 0;
	int numOfCorrectGuesses = 0;
	int totalQuestions = questions.length;
	int result = 0;
	int seconds = 15;
	
	//GUI COMPONENTS
	JFrame frame = new JFrame();
	
	JTextField textField = new JTextField();
	JTextField numbersRight = new JTextField();
	JTextField percentage = new JTextField();
	
	JTextArea textArea = new JTextArea();
	
	JButton A = new JButton();
	JButton B = new JButton();
	JButton C = new JButton();
	JButton D = new JButton();
	
	JLabel answerA = new JLabel();
	JLabel answerB = new JLabel();
	JLabel answerC = new JLabel();
	JLabel answerD = new JLabel();
	JLabel timeLabel = new JLabel();
	JLabel secondsLeft = new JLabel();
	
	//TIMER
	Timer timer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--; 
			secondsLeft.setText(String.valueOf(seconds));
			
			if(seconds<= 0 ) {
				updateAnswer();
			}
		}
		
	});
	
	public Quiz() {
		
		//FRAME
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.getContentPane().setBackground(Color.black);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);

		
		//TEXTFIELD FOR QUESTION NUMBER
		textField.setBounds(0,0,800,50);
		textField.setBackground(Color.black);
		textField.setForeground(Color.white);
		textField.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		textField.setBorder(BorderFactory.createBevelBorder(3)); // or 1
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setEditable(false);
		
		//TEXTAREA FOR QUESTION DISPLAYED
		textArea.setBounds(0,50,800,50);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(Color.black);
		textArea.setForeground(Color.white);
		textArea.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 26));
		textArea.setBorder(BorderFactory.createBevelBorder(3)); //or 1
		textArea.setEditable(false);
		
		//JBUTTON A
		A.setBounds(0,100,100,100);
		A.setFont(new Font("Rockwell", Font.BOLD, 35));
		A.setFocusable(false);
		A.addActionListener(this);
		A.setText("A");
		
		//JBUTTON B
		B.setBounds(0,200,100,100);
		B.setFont(new Font("Rockwell", Font.BOLD, 35));
		B.setFocusable(false);
		B.addActionListener(this);
		B.setText("B");
		
		//JBUTTON C
		C.setBounds(0,300,100,100);
		C.setFont(new Font("Rockwell", Font.BOLD, 35));
		C.setFocusable(false);
		C.addActionListener(this);
		C.setText("C");
				
		//JBUTTON D
		D.setBounds(0,400,100,100);
		D.setFont(new Font("Rockwell", Font.BOLD, 35));
		D.setFocusable(false);
		D.addActionListener(this);
		D.setText("D");
		
		//JLABEL TO DISPLAY ANSWER FOR BUTTON A
		answerA.setBounds(125,100,500,100);
		answerA.setBackground(new Color(50,50,50));
		answerA.setForeground(new Color(25,255,0));
		answerA.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
		
		//JLABEL TO DISPLAY ANSWER FOR BUTTON B
		answerB.setBounds(125,200,500,100);
		answerB.setBackground(new Color(50,50,50));
		answerB.setForeground(new Color(25,255,0));
		answerB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
				
		//JLABEL TO DISPLAY ANSWER FOR BUTTON C
		answerC.setBounds(125,300,500,100);
		answerC.setBackground(new Color(50,50,50));
		answerC.setForeground(new Color(25,255,0));
		answerC.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
				
		//JLABEL TO DISPLAY ANSWER FOR BUTTON D
		answerD.setBounds(125,400,500,100);
		answerD.setBackground(new Color(50,50,50));
		answerD.setForeground(new Color(25,255,0));
		answerD.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
		
		//JLABEL TO DISPLAY TIMER SECONDS
		secondsLeft.setBounds(640,420,150,150);
		secondsLeft.setBackground(new Color(25,25,25));
		secondsLeft.setForeground(new Color(255,0,0));
		secondsLeft.setFont(new Font("Drugsther", Font.BOLD, 60));
		secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
		secondsLeft.setOpaque(true);
		secondsLeft.setHorizontalAlignment(JTextField.CENTER);
		secondsLeft.setText(String.valueOf(seconds));
		
		//JLABEL TO DISPLAY TIMER LABEL
		 timeLabel.setBounds(535,295,350,215);
		 timeLabel.setBackground(new Color(25,25,25));
		 timeLabel.setForeground(new Color(255,0,0));
		 timeLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN,30));
		 timeLabel.setHorizontalAlignment(JTextField.CENTER);
		 timeLabel.setText("TIMER");
		
		//JTEXTFIELD TO DISPLAY NUMBER OF QUESTIONS USER GOT RIGHT
		 numbersRight.setBounds(200,100,400,200);
		 numbersRight.setBackground(new Color(25,25,25));
		 numbersRight.setForeground(new Color(25,255,0));
		 numbersRight.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 50));
		 numbersRight.setBorder(BorderFactory.createBevelBorder(1));
		 numbersRight.setHorizontalAlignment(JTextField.CENTER);
		 numbersRight.setEditable(false);
		 
		 //JTEXTFIELD TO DISPLAY FINAL PERCENTAGE OF USER		 
		 percentage.setBounds(200,300,400,200);
		 percentage.setBackground(new Color(25,25,25));
		 percentage.setForeground(new Color(25,255,0));
		 percentage.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 50));
		 percentage.setBorder(BorderFactory.createBevelBorder(1));
		 percentage.setHorizontalAlignment(JTextField.CENTER);
		 percentage.setEditable(true);
		 
		 
		//ADD ALL COMPONENTS TO FRAME
		frame.add(textField);
		frame.add(textArea);
		frame.add(A);
		frame.add(B);
		frame.add(C);
		frame.add(D);
		frame.add(answerA);
		frame.add(answerB);
		frame.add(answerC);
		frame.add(answerD);
		frame.add(secondsLeft);
		frame.add(timeLabel);
		//frame.add(numbersRight);
		//frame.add(percentage);
		frame.setVisible(true);
		
		updateQuestion();
	}
	
	
	/*
	 * This is a function that displays the answers for the next question
	 */
	public void updateQuestion() {
		if(index>= totalQuestions) {
			results();
		}
		else {
			textField.setText("QUESTION " + (index + 1));
			textArea.setText(" " + questions[index]);
			
			answerA.setText(options[index][0]);
			answerB.setText(options[index][1]);
			answerC.setText(options[index][2]);
			answerD.setText(options[index][3]);
			
			timer.start();
		}
	}

	/*
	 * shows the correct and incorrect answers
	 * waits 2 seconds before displaying the next question and answer labels
	 */
	public void updateAnswer() {
		
		timer.stop();
		A.setEnabled(false);
		B.setEnabled(false);
		C.setEnabled(false);
		D.setEnabled(false);
		
		if(answers[index] != 'A') {
			answerA.setForeground(new Color(255,0,0));
		}
		if(answers[index] != 'B') {
			answerB.setForeground(new Color(255,0,0));
		}
		if(answers[index] != 'C') {
			answerC.setForeground(new Color(255,0,0));
		}
		if(answers[index] != 'D') {
			answerD.setForeground(new Color(255,0,0));
		}
		
		Timer pause = new Timer(2000, new ActionListener() { //2 seconds

			
			//after a button is chosen
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answerA.setForeground(new Color(25,255,0));
				answerB.setForeground(new Color(25,255,0));
				answerC.setForeground(new Color(25,255,0));
				answerD.setForeground(new Color(25,255,0));
				
				answer = ' ';
				seconds = 15;
				secondsLeft.setText(String.valueOf(seconds));
				A.setEnabled(true);
				B.setEnabled(true);
				C.setEnabled(true);
				D.setEnabled(true);
				index++;
				updateQuestion();
			}
				
		});
		pause.setRepeats(false); //only executes actionPerformed once
		
		pause.start();  
	}
	
	/*
	 * After all multiple choices have been answered
	 * grays out all buttons
	 * displays total amount of answers user got compared to total questions (ex. 5/10)
	 * displays percentage of score (ex.50%)
	 */
	public void results() {
		
		A.setEnabled(false);
		B.setEnabled(false);
		C.setEnabled(false);
		D.setEnabled(false);
		
		result = (int) (((double) numOfCorrectGuesses /  totalQuestions) * 100);
		textField.setText("RESULTS");
		
		textArea.setText("");
		answerA.setText("");
		answerB.setText("");
		answerC.setText("");
		answerD.setText("");
		
		numbersRight.setText("(" + numOfCorrectGuesses + "/" + totalQuestions + ")");
		percentage.setText(result + "%");
		
		frame.add(numbersRight);
		frame.add(percentage);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		A.setEnabled(false);
		B.setEnabled(false);
		C.setEnabled(false);
		D.setEnabled(false);
		
		if(e.getSource() == A) {
			answer = 'A';
			if(answer == answers[index]) {
				numOfCorrectGuesses++;
			}
		}
		if(e.getSource() == B) {
			answer = 'B';
			if(answer == answers[index]) {
				numOfCorrectGuesses++;
			}
		}
		if(e.getSource() == C) {
			answer = 'C';
			if(answer == answers[index]) {
				numOfCorrectGuesses++;
			}
		}
		if(e.getSource() == D) {
			answer = 'D';
			if(answer == answers[index]) {
				numOfCorrectGuesses++;
			}
		}
		updateAnswer();
		
	}
	
}
