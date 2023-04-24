package Bonus_Project;

/*
 * Name: Silas Yeak
 * ID: 202337225
 * Date: 11/17/22
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//this program extends a JFrame class and implements an ActionListener class
//to create a mini game that is a vending machine for coke & monster drinks
//this program uses class such as emptying out a stack using a while loop
//pushing and popping a stack, after which evaluating the stack by counting the strings of coke and monster

public class MyFrame extends JFrame implements ActionListener {
	
	JLabel label;
	JLabel label_2;
	JButton button;
	JButton button_2;
	JButton button_3;
	JButton button_4;
	JButton button_5;
	
	
	static Stack<String> drinkStack = new Stack<>();
	static Stack<Integer> moneyStack = new Stack<>();
	static int totalSum = 0;
	static int cokeOccurences = 0;
	static int monstOccurences = 0;
	
	
	MyFrame(){
		//this creates the coke vending machine label
		label = new JLabel();
		label_2 = new JLabel();
		label.setIcon(new ImageIcon("coke.png"));
		label.setBounds(90,50,1000,50);
		label_2.setBounds(10,0,1000,50);
		label_2.setText("Buy 5 cokes & 2 monsters w/only $10. Luck can be coke/monster.");
		label_2.setFont(new Font("Comic Sans", Font.BOLD, 14));
		
		//creates the coke button
		button = new JButton();
		button.setBounds(200,100,100,50);
		button.addActionListener(this);
		button.setText("Coke $1");
		
		//creates the monster button
		button_2 = new JButton();
		button_2.setBounds(100,100,100,50);
		button_2.addActionListener(this);
		button_2.setText("Monster $3");

		//creates the luck button
		button_3 = new JButton();
		button_3.setBounds(300,100,100,50);
		button_3.addActionListener(this);
		button_3.setText("Luck $2");
		
		//creates the stock check button
		button_4 = new JButton();
		button_4.setBounds(200,150,100,50);
		button_4.addActionListener(this);
		button_4.setText("Stock Check");
		

		button_5 = new JButton();
		button_5.setBounds(200,200,100,50);
		button_5.addActionListener(this);
		button_5.setText("Calculate");
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,300);
		this.setVisible(true);
		
		this.add(label);
		this.add(label_2);
		this.add(button);
		this.add(button_2);
		this.add(button_3);
		this.add(button_4);
		this.add(button_5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			//pushes a coke string into the drink stack and pushes an integer 1 to the money stack
			System.out.println("You spent $1");
			moneyStack.push(1);
			drinkStack.push("Coke");
		}
		else if(e.getSource()==button_2) {
			//pushes a monster string into the drink stack and pushes an integer 3 to the money stack
			System.out.println("You spent $3");
			moneyStack.push(3);
			drinkStack.push("Monster");
		}
		else if(e.getSource()==button_3) {
			//pushes a coke or monster string into the drink stack and pushes an integer 2 to the money stack
			System.out.println("You spent $2");
			moneyStack.push(2);
			Random rand = new Random();
			if(rand.nextBoolean() == true) {
				drinkStack.push("Coke");
			}
			else drinkStack.push("Monster");
			
		}
		else if(e.getSource() == button_4) {
			//allows you to check the stock by printing out an array 
			System.out.println("You bought: "+ drinkStack);
			//System.out.println(moneyStack);
			while(!moneyStack.isEmpty()) {
				totalSum += moneyStack.pop();
			}
			System.out.println("You have $" + (10 - totalSum) + " left");
			
		}
		else if(e.getSource() == button_5) {
			while(!moneyStack.isEmpty()) {
				totalSum += moneyStack.pop();
			}
			System.out.println("Total Cost: $" + totalSum);
			//this statement will check if you failed by going beyond $10
			if(totalSum > 10) {
				System.out.println("You failed!");
			}
			//this else if statement checks the number of cokes and monsters you have in the stack.
			else if(totalSum <= 10) {
				cokeOccurences = Collections.frequency(drinkStack, "Coke");
				monstOccurences = Collections.frequency(drinkStack, "Monster");
				//if the coke appears more than 5 times and the monster appears more than twice, you win the game. 
				if(cokeOccurences >= 5 && monstOccurences >= 2) {
					System.out.println("You win!!");
				}
				else {
					System.out.println("You failed, sorry ):");
				}
			}
		}
	}
	
}
