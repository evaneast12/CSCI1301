/*
 * RockPaperScissors.java
 * Author:  Evan Eastabrooks 
 * Submission Date:  03/05/2021
 *
 * Purpose: RockPaperScissors.java is a program that is simply
 * a game of rock, paper, scissors. The user first inputs what
 * score they would like to play to (not rounds) and then the 
 * game will commence. The program prompts the user for their
 * selection of rock, paper, or scissors and then will get the
 * computer's input from the class ComputerOpponent.java at
 * random. Standard rock, paper, scissors rules apply. This 
 * program was mostly just practice for using loops.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */

import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		
		System.out.print("Points to Win: ");
		Scanner keyboard = new Scanner(System.in);
		int pointsToWin = keyboard.nextInt();
		
		int userScore = 0, computerScore = 0;
		
		//beginning of the loop for the game. I used a while loop.
		while(computerScore < pointsToWin && userScore < pointsToWin) {
			System.out.print("Rock, paper, or scissors? ");
			String userInput = keyboard.next();
			String computerInput = ComputerOpponent.getMove(); //calls the class ComputerOpponent.java for the computer's input
			
			//nested if statements that satisfy all possible outcomes of the game.
			if(userInput.equalsIgnoreCase("rock")) {
				if(computerInput.equalsIgnoreCase("rock")) {
					System.out.println("The computer chose rock, so it's a tie.  ("+userScore+"-"+computerScore+")");	
				}
				if(computerInput.equalsIgnoreCase("paper")) {
					computerScore++;
					System.out.println("The computer chose paper, so you lose.  ("+userScore+"-"+computerScore+")");
				}
				if(computerInput.equalsIgnoreCase("scissors")) {
					userScore++;
					System.out.println("The computer chose scissors, so you win!  ("+userScore+"-"+computerScore+")");
				}
			}
			else if(userInput.equalsIgnoreCase("paper")) {
				if(computerInput.equalsIgnoreCase("paper")) {
					System.out.println("The computer chose paper, so it's a tie.  ("+userScore+"-"+computerScore+")");
				}
				if(computerInput.equalsIgnoreCase("rock")) {
					userScore++;
					System.out.println("The computer chose rock, so you win!  ("+userScore+"-"+computerScore+")");
				}
				if(computerInput.equalsIgnoreCase("scissors")) {
					computerScore++;
					System.out.println("The computer chose scissors, so you lose.  ("+userScore+"-"+computerScore+")");
				}
			}
			else if(userInput.equalsIgnoreCase("scissors")) {
				if(computerInput.equalsIgnoreCase("scissors")) {
					System.out.println("The computer chose scissors, so it's a tie.  ("+userScore+"-"+computerScore+")");
				}
				if(computerInput.equalsIgnoreCase("rock")) {
					computerScore++;
					System.out.println("The computer chose rock, so you lose.  ("+userScore+"-"+computerScore+")");
				}
				if(computerInput.equalsIgnoreCase("paper")) {
					userScore++;
					System.out.println("The computer chose paper, so you win!  ("+userScore+"-"+computerScore+")");
				}
			}
			else {
				System.out.println("That isn't a valid input, try again."); //for invalid inputs: "spock" or "raygun", for example.
			}
		}
		
		keyboard.close(); //closes the scanner
		
		if(userScore == pointsToWin) {
			System.out.println("Congratulations! You won!");
		}
		else {
			System.out.println("Sorry, you lost. Better luck next time!");
		}
	}
}
