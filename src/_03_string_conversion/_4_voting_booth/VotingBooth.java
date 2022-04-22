package _03_string_conversion._4_voting_booth;

import javax.swing.JOptionPane;

public class VotingBooth {
public static void main(String[] args) {
	
	String age = JOptionPane.showInputDialog(null, "enter your age");	
	int numberAge = Integer.parseInt(age); 
	if(numberAge >= 18) {
		String ask = JOptionPane.showInputDialog(null, "who do you think the next president should be");	
	}else{
		 JOptionPane.showMessageDialog(null, "nobody cares what you think");
	}
}
}
