package _01_random._6_lottery_numbers;

import java.util.Random;

import javax.swing.JOptionPane;

public class LotteryNumbers {
	public static void main (String[] args) {
		String lottery = "";
	Random randy = new Random();
	for(int i = 0; i < 6; i++) {
	int number = randy.nextInt(100);
	lottery+=" "+String.valueOf(number);
	}
	JOptionPane.showMessageDialog(null, lottery);		
	}
}
