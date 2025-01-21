package XO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Xo implements ActionListener {
	
	Random random= new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	
	
	public Xo() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//int x = toolkit.getDefaultToolkit().getScreenSize().width;
		frame.setSize(800,800);
		frame.getContentPane().setBackground(Color.pink);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(Color.green);
		textfield.setForeground(Color.BLACK);
		textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("XO");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i =0; i<9; i++) {
			buttons[i]= new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		premierTour();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i<9; i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,11,183));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						verifier();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(101,11,255));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");
						verifier();
				}
			}
			}
			}
			}
	
	
	public void premierTour() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)== 0) {
			player1_turn = true;
			textfield.setText("X turn");
		}
		else {
			player1_turn = false;
			textfield.setText("O turn");
		}
	}
	public void verifier() {
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X")&&
				(buttons[2].getText()=="X")
				) {
			xGagne(0, 1, 2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X")&&
				(buttons[5].getText()=="X")
				) {
			xGagne(3, 4, 5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X")&&
				(buttons[8].getText()=="X")
				) {
			xGagne(6, 7, 8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X")&&
				(buttons[6].getText()=="X")
				) {
			xGagne(0, 3, 6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X")&&
				(buttons[7].getText()=="X")
				) {
			xGagne(1, 4, 7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X")&&
				(buttons[8].getText()=="X")
				) {
			xGagne(2, 5, 8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X")&&
				(buttons[8].getText()=="X")
				) {
			xGagne(0, 4, 8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X")&&
				(buttons[6].getText()=="X")
				) {
			xGagne(2, 4, 6);
		}
		if (
			    (buttons[0].getText().equals("O")) &&
			    (buttons[1].getText().equals("O")) &&
			    (buttons[2].getText().equals("O"))
			) {
			    oGagne(0, 1, 2);
			}
			if (
			    (buttons[3].getText().equals("O")) &&
			    (buttons[4].getText().equals("O")) &&
			    (buttons[5].getText().equals("O"))
			) {
			    oGagne(3, 4, 5);
			}
			if (
			    (buttons[6].getText().equals("O")) &&
			    (buttons[7].getText().equals("O")) &&
			    (buttons[8].getText().equals("O"))
			) {
			    oGagne(6, 7, 8);
			}
			if (
			    (buttons[0].getText().equals("O")) &&
			    (buttons[3].getText().equals("O")) &&
			    (buttons[6].getText().equals("O"))
			) {
			    oGagne(0, 3, 6);
			}
			if (
			    (buttons[1].getText().equals("O")) &&
			    (buttons[4].getText().equals("O")) &&
			    (buttons[7].getText().equals("O"))
			) {
			    oGagne(1, 4, 7);
			}
			if (
			    (buttons[2].getText().equals("O")) &&
			    (buttons[5].getText().equals("O")) &&
			    (buttons[8].getText().equals("O"))
			) {
			    oGagne(2, 5, 8);
			}
			if (
			    (buttons[0].getText().equals("O")) &&
			    (buttons[4].getText().equals("O")) &&
			    (buttons[8].getText().equals("O"))
			) {
			    oGagne(0, 4, 8);
			}
			if (
			    (buttons[2].getText().equals("O")) &&
			    (buttons[4].getText().equals("O")) &&
			    (buttons[6].getText().equals("O"))
			) {
			    oGagne(2, 4, 6);
			}
	}
	
	public void xGagne(int a, int b, int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
	}
	public void oGagne(int a, int b, int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");
	}
}
