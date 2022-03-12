
package _04_spot_the_error;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class WordleGame implements KeyListener {

	public static void main(String[] args) {
		WordleGame game = new WordleGame();
	}

	JFrame frame = new JFrame("Wordle");
	JPanel panel;
	static final int ROWS = 6;
	static final int COLS = 5;
	JLabel[][] letters = new JLabel[6][5];
	int row = 0;
	int col = 0;
	String answer = loadWord();
	String[] words = { "", "", "", "", "" };

	WordleGame() {
		System.out.println("starting game");
		panel = new JPanel(new GridLayout(6, 5));
		frame.setVisible(true);
		frame.add(panel);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				JLabel label = new JLabel("", SwingConstants.CENTER);
				Border border = new LineBorder(Color.WHITE, 4, true);
				label.setBorder(border);
				label.setForeground(Color.WHITE);
				label.setFont(new Font("arial", Font.BOLD, 20));
				letters[i][j] = label;
				label.setBackground(new Color(230, 230, 230));
				label.setOpaque(true);
				panel.add(label);
			}
		}
		frame.addKeyListener((KeyListener) this);
		frame.setSize(500, 500);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
			if (col > 0) {
				letters[row][--col].setText("");
				letters[row][col].setBackground(Color.LIGHT_GRAY);
				letters[row][col].setOpaque(true);
			} else if (col == 0) {
				letters[row][col].setBackground(Color.LIGHT_GRAY);
				letters[row][col].setOpaque(true);
				letters[row][col].setText("");

			}
		} else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			System.out.println("enter pressed");
			if (answer.equals(words[row])) {
				JOptionPane.showMessageDialog(null, "you won!");
			}
			for (int i = 0; i < 5; i++) {
				if (answer.contains(letters[row][i].getText())) {
					letters[row][i].setBackground(Color.ORANGE);
					letters[row][i].setOpaque(true);
				}
				if (letters[row][i].getText().charAt(0) == answer.charAt(i)) {
					letters[row][i].setBackground(new Color(0, 200, 0));
					letters[row][i].setOpaque(true);
				}
			}
			if (realWord(words[row])) {

				row++;
				col = 0;
			}

		} else {

			if (col < 5) {
				letters[row][col].setBackground(Color.GRAY);
				letters[row][col].setOpaque(true);
				letters[row][col++].setText("" + Character.toUpperCase(e.getKeyChar()));
				words[row] += Character.toUpperCase(e.getKeyChar());
			}
		}
		col = col < 0 ? 0 : col;
		col = col >= 5 ? 5 : col;

	}

	String loadWord() {
		return "farts".toUpperCase();
	}

	boolean realWord(String word) {
		return true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}