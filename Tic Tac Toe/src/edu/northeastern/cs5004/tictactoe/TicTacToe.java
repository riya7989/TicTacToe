package edu.northeastern.cs5004.tictactoe;

import java.util.Scanner;

/**
 * Class that holds the main and runs the whole program.
 * @author Riya Nadkarni
 * @version 08-04-2018
 */
public class TicTacToe {

	/**
	 * Main driver of the program. Simulates the TicTacToe game.
	 * @param args
	 * 			None used
	 */
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Tic-Tac-Toe Game.\n ");
		Scanner input = new Scanner(System.in);
		System.out.println("Play now? Enter Y for yes and N to exit.");
		String reply = input.next();
		while (reply.equalsIgnoreCase("Y")) {
			ControllerClass controller = new ControllerClass();
			controller.play();
			System.out.println("Play another game? Enter Y for yes and N to exit.");
			reply = input.next();
		}
		
		System.out.println("Thank you for playing Tic-Tac-Toe.");
		input.close();
		
	}
}
