package Bonus_Project;

/*
 * Name: Silas Yeak
 * ID: 202337225
 * Date: 11/17/22
 */

import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.util.Random;

//this program calls the MyFrame class
//I will explain more in the button class.
public class Bonus_Stack_Project {

	public JFrame frame;
	public JButton button;
	public int width;
	public int height;
	
	//main code to print out the frame, and run the game. 
	public static void main(String[] args) {
		System.out.println("You must buy 5 cokes and 2 monsters, with only $10."
				+ "\nLuck can be either a Coke or a Monster");				
		MyFrame frame = new MyFrame();
				
	}

}
