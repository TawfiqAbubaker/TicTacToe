

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.*;
/**
 * TicTacToe Game with a GUI in which the game either ends in a tie or the computer winning.
 * @author Tawfiq Abubaker // AbubakerTawfiq@gmail.com
 *
 */
public class Unbeatable_TicTacToe implements ActionListener{
	//interface items
	private JFrame frmTictactoe;
	private JTextField txtScoreboard;
	private JTextField textField;
	private JButton btnNewGame = new JButton("New Game");
	private JButton btn1 = new JButton("");
	private JButton btn2 = new JButton("");
	private JButton btn3 = new JButton("");
	private JButton btn4 = new JButton("");
	private JButton btn5 = new JButton("");
	private JButton btn6 = new JButton("");
	private JButton btn7 = new JButton("");
	private JButton btn8 = new JButton("");
	private JButton btn9 = new JButton("");
	private JButton[] btnList = {btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9};
	//Other variables
	private Random random_object = new Random();
	private boolean pc_first = true;
	private int draw_counter,random = 0;
	private int[] score = {0,0};
	private boolean case1,case2,case2_2,case3;
	private boolean finished = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Unbeatable_TicTacToe window = new Unbeatable_TicTacToe();
					window.frmTictactoe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Unbeatable_TicTacToe() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTictactoe = new JFrame();
		frmTictactoe.setResizable(false);
		frmTictactoe.setType(Type.UTILITY);
		frmTictactoe.setTitle("TicTacToe");
		frmTictactoe.setBounds(100, 100, 532, 497);
		frmTictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		frmTictactoe.getContentPane().add(splitPane, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnNewGame);
		btnNewGame.addActionListener(this);
		
		
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		txtScoreboard = new JTextField();
		txtScoreboard.setHorizontalAlignment(SwingConstants.CENTER);
		txtScoreboard.setEditable(false);
		txtScoreboard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtScoreboard.setText("ScoreBoard :");
		panel_1.add(txtScoreboard);
		txtScoreboard.setColumns(10);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setText("0   :    0");
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		frmTictactoe.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(3, 3, 1, 1));
		
		btn1.setFont(new Font("Heebo Medium", Font.PLAIN, 84));
		panel_2.add(btn1);
		btn1.addActionListener(this);
		
		btn2.setFont(new Font("Heebo Medium", Font.PLAIN, 84));
		panel_2.add(btn2);
		btn2.addActionListener(this);

		
		btn3.setFont(new Font("Heebo Medium", Font.PLAIN, 84));
		panel_2.add(btn3);
		btn3.addActionListener(this);

		btn4.setFont(new Font("Heebo Medium", Font.PLAIN, 84));
		panel_2.add(btn4);
		btn4.addActionListener(this);

		btn5.setFont(new Font("Heebo Medium", Font.PLAIN, 84));
		panel_2.add(btn5);
		btn5.addActionListener(this);

		btn6.setFont(new Font("Heebo Medium", Font.PLAIN, 84));
		panel_2.add(btn6);
		btn6.addActionListener(this);

		btn7.setFont(new Font("Heebo Medium", Font.PLAIN, 84));
		panel_2.add(btn7);
		btn7.addActionListener(this);

		btn8.setFont(new Font("Heebo Medium", Font.PLAIN, 84));
		panel_2.add(btn8);
		btn8.addActionListener(this);

		btn9.setFont(new Font("Heebo Medium", Font.PLAIN, 84));
		panel_2.add(btn9);
		btn9.addActionListener(this);
		new_game();

	}
	/**
	 * Calls other functions based on the chosen button
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == btnNewGame) new_game();
		for(JButton btn : btnList) {
			if(btn == source) player_turn(btn);
			
		}
		
	}
	 /**
	  * Draws a "O" on the button which the player clicked on,
	  * Calls the function which tests if the player won,
	  * Calls the function which lets the computer play.
	  * @param btn JButton object which represents where the player clicked
	  */
	public void player_turn(JButton btn) {
		if (btn.getText()=="" && finished == false) {
			btn.setText("O");
			draw_counter += 1;
			winChecker();
			pc_turn();
			victory_test();
		}
	}
	/**
	 * Writes an "X" on a button to ensure either a victory or a draw.
	 */
	public void pc_turn() {
		if (pc_first) {
			if (draw_counter == 0) {
				btnList[random].setText("X");
				draw_counter += 1;
			}
			if(draw_counter == 2) {
				if(btn5.getText()=="O") {
					if (random ==0) btn9.setText("X");
					if (random ==2) btn7.setText("X");
					if (random ==6) btn3.setText("X");
					if (random ==8) btn1.setText("X");
					case1 = true;
					draw_counter += 1;
				}
				if(btn2.getText()=="O" || btn4.getText()=="O"||btn6.getText()=="O"||btn8.getText()=="O") {
					case2 =true;
					if (random ==0 ) {
						if(btn2.getText()=="O")btn4.setText("X");
						if(btn4.getText()=="O")btn2.setText("X");
						if(btn6.getText()=="O"||btn8.getText()=="O") {btn5.setText("X");case2_2=true;}
					}
					if (random ==2 ) {
						if(btn6.getText()=="O")btn2.setText("X");
						if(btn2.getText()=="O")btn6.setText("X");
						if(btn4.getText()=="O"||btn8.getText()=="O") {btn5.setText("X");case2_2=true;}
					}
					if (random ==6 ) {
						if(btn4.getText()=="O")btn8.setText("X");
						if(btn8.getText()=="O")btn4.setText("X");
						if(btn2.getText()=="O"||btn6.getText()=="O") {btn5.setText("X");case2_2=true;}
					}
					if (random ==8 ) {
						if(btn8.getText()=="O")btn6.setText("X");
						if(btn6.getText()=="O")btn8.setText("X");
						if(btn2.getText()=="O"||btn4.getText()=="O") {btn5.setText("X");case2_2=true;}
					}
					
					draw_counter +=1;
				}
				if(btn1.getText()=="O" || btn3.getText()=="O"||btn7.getText()=="O"||btn9.getText()=="O") {
					JButton[] temp = {btn1,btn3,btn7,btn9};
					for (JButton r : temp) {
						if(r.getText()=="") {
							r.setText("X");
							break;
						}
					}
					case3=true;
					draw_counter +=1;
				}
				
			}
			if(draw_counter == 4) {
				if (case1 == true) {
					if((btn1.getText()=="O" ||btn3.getText()=="O" ||btn7.getText()=="O" ||btn9.getText()=="O" ) && case1==true) {
						if(random == 0 || random == 8) {
							if(btn3.getText()=="O") {
								btn7.setText("X");
								draw_counter += 1;
							}
							else {
								btn3.setText("X");
								draw_counter += 1;
							}
						}
						if(random == 2 || random == 6) {
							if(btn1.getText()=="O") {
								btn9.setText("X");
								draw_counter += 1;
							}
							else {
								btn1.setText("X");
								draw_counter += 1;
							}
						}
						
					}
					else {
						if(btn2.getText()=="O")btn8.setText("X");
						if(btn8.getText()=="O")btn2.setText("X");
						if(btn4.getText()=="O")btn6.setText("X");
						if(btn6.getText()=="O")btn4.setText("X");
						draw_counter +=1;
					}
				}
				if(case2==true) {
					if(case2_2==true){
						int index = victoryBoutton("X");
						if(index != 100) {
							btnList[index].setText("X");
						}
						else {
							index = victoryBoutton("O");
							btnList[index].setText("X");
						}
					}
					else {
						int index = victoryBoutton("X");
						if(index != 100) {
							btnList[index].setText("X");
						}
						else {
							btn5.setText("X");
						}
					}
					draw_counter += 1;
				}
				if(case3==true) {
					int index = victoryBoutton("X");
					if(index != 100) {
						btnList[index].setText("X");
					}
					else {
					JButton[] temp = {btn1,btn3,btn7,btn9};
					for (JButton r : temp) {
						if(r.getText()=="") {
							r.setText("X");
							break;
						}
					}
					}
					draw_counter +=1;
				}
			}
			if (draw_counter == 6) {
				if(case1 == true||case2==true||case3==true) {												/*case 1 draw*/ 
						int index = victoryBoutton("X");
						if(index != 100) {
						btnList[index].setText("X");
						}
						else {
							index = victoryBoutton("O");
							btnList[index].setText("X");
						}
						draw_counter += 1;
				}
				
			}
			if(draw_counter == 8) {
				for(JButton btn: btnList) {
					if(btn.getText()=="") btn.setText("X");
				}
				if(winChecker()==false)draw_setter();
			}
		}
	}
	/**
	 * Tests if the player or the computer won, Calls the function victory_changer if it's the case.
	 */
	public void victory_test() {
		if (btn1.getText() == btn2.getText() && btn2.getText() == btn3.getText() &&btn2.getText() != "") victory_changer(btn1,btn2,btn3);
		if (btn4.getText() == btn5.getText() && btn5.getText() == btn6.getText() &&btn5.getText() != "") victory_changer(btn4,btn5,btn6);
		if (btn7.getText() == btn8.getText() && btn8.getText() == btn9.getText() &&btn9.getText() != "") victory_changer(btn7,btn8,btn9);
		if (btn1.getText() == btn4.getText() && btn4.getText() == btn7.getText() &&btn1.getText() != "") victory_changer(btn1,btn4,btn7);
		if (btn2.getText() == btn5.getText() && btn5.getText() == btn8.getText() &&btn2.getText() != "") victory_changer(btn2,btn5,btn8);
		if (btn3.getText() == btn6.getText() && btn6.getText() == btn9.getText() &&btn3.getText() != "") victory_changer(btn3,btn6,btn9);
		if (btn1.getText() == btn5.getText() && btn5.getText() == btn9.getText() &&btn1.getText() != "") victory_changer(btn1,btn5,btn9);
		if (btn3.getText() == btn5.getText() && btn5.getText() == btn7.getText() &&btn3.getText() != "") victory_changer(btn3,btn5,btn7);
		
		
	}
	/**
	 * Shows which combination won the game, disables the buttons, changes the Scoreboard
	 * @param a One of the 3 buttons which won the game
	 * @param b One of the 3 buttons which won the game
	 * @param c One of the 3 buttons which won the game
	 */
	public void victory_changer(JButton a, JButton b, JButton c) {
		finished = true;
		a.setBackground(Color.GREEN);
		b.setBackground(Color.GREEN);
		c.setBackground(Color.GREEN);
		for(JButton btn : btnList) {
			btn.removeActionListener(this);
		}
		if(c.getText() == "O") score[0] +=1;
		if(c.getText() == "X") score[1] +=1;
		textField.setText(score[0]+"   :    "+score[1]);
	}
	
	/**
	 * Changes the button's colour to yellow
	 * and sets the scoreboard's text to "DRAW!"
	 */
	public void draw_setter() {
		for (JButton btn : btnList) {
			btn.setBackground(Color.yellow);
		}
		textField.setText("DRAW!");
		
	}
	
	/**
	 * Resets everything except for the Scoreboard.
	 */
	public void new_game() {
		finished = false;
		for(JButton btn : btnList) {
			btn.addActionListener(this);
			btn.setBackground(null);
			btn.setText("");
		}
		
		draw_counter = 0;
		case1 = false;
		case2= false;
		case2_2 = false;
		case3=false;
		int rando_ = random_object.nextInt(5);
		if (rando_ ==0) random = 0;
		if (rando_ ==1) random = 2;
		if (rando_ ==3) random = 6;
		if (rando_ ==4) random = 8;
		if (pc_first == true) {
			pc_turn();
		}
		textField.setText(score[0]+"   :    "+score[1]);
	}
	/**
	 * Checks if there is a possible positioning of "X" or "O" which will win the computer or the player the game.
	 * @param player_sign Should be either "X" or "O" depending on if it's the computer or the player.
	 * @return
	 */
	public int victoryBoutton(String player_sign) {
		boolean k = false;
		int L = 0;
		for (JButton r : btnList) {
			if(r.getText()=="") {
				r.setText(player_sign);
				if(winChecker()==true) {
					k = true;
					break;
				}
				else {
					
					r.setText("");
				}
			}
			L+=1;
		}
		if(k == true) return L;
		else return 100;

	}
	/**
	 * Tests if the player or the computer won
	 * @return True if the player or the computer won
	 */
	public boolean winChecker() {
		if (btn1.getText() == btn2.getText() && btn2.getText() == btn3.getText() &&btn2.getText() != "") return true;
		if (btn4.getText() == btn5.getText() && btn5.getText() == btn6.getText() &&btn5.getText() != "") return true;
		if (btn7.getText() == btn8.getText() && btn8.getText() == btn9.getText() &&btn9.getText() != "") return true;
		if (btn1.getText() == btn4.getText() && btn4.getText() == btn7.getText() &&btn1.getText() != "") return true;
		if (btn2.getText() == btn5.getText() && btn5.getText() == btn8.getText() &&btn2.getText() != "") return true;
		if (btn3.getText() == btn6.getText() && btn6.getText() == btn9.getText() &&btn3.getText() != "") return true;
		if (btn1.getText() == btn5.getText() && btn5.getText() == btn9.getText() &&btn1.getText() != "") return true;
		if (btn3.getText() == btn5.getText() && btn5.getText() == btn7.getText() &&btn3.getText() != "") return true;
		else return false;
	}
	
}
