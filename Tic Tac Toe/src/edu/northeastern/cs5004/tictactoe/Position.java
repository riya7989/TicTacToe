package edu.northeastern.cs5004.tictactoe;

import java.util.Scanner;

/**
 * This class represents a position in the grid, denoted by x (row) and y (column).
 * @author Riya Nadkarni
 * @version 08-03-2018
 */
public class Position {

	/** Scanner for the class. */
	private static Scanner input;
	
	static {
		input = new Scanner(System.in);
	}
	
	/** Row value for the cell in the grid. */
	private int x;
	
	/** Column value for the cell in the grid. */
	private int y;
	
	
	/**
	 * Constructor for the Position class.
	 * @param x	user chosen value for the row
	 * @param y	user chosen value for the column
	 */
	public Position (int x, int y) {
		
		if (x < 0 || x > 2) {
			throw new IllegalArgumentException ("X should be in the range 0 to 2.");
		}
		
		if (y < 0 || y > 2) {
			throw new IllegalArgumentException ("Y should be in the range 0 to 2.");
		}
		
		this.x = x;
		this.y = y;
	}
	
	
	/**
	 * Takes in user input for the row and column of the grid they want to play in, validates in and creates the position if valid.
	 * @return the new position created
	 */
	public static Position readPosition() {
		
		boolean isXValid = false;
		boolean isYValid = false;
		int xCoord = -1;
		int yCoord = -1;
		Position current;
		
		while(!isXValid) {
			System.out.println("Enter the x Coordinate of the position you want to play in.");
			if (input.hasNextInt()) {
				xCoord = input.nextInt();
				if (xCoord < 0 || xCoord > 2) {
					System.out.println("ERROR: Valid choices for x are between 0 to 2\n");
				}
				else {
					while (!isYValid) {
					System.out.println("Enter the y Coordinate of the position you want to play in.");
					if (input.hasNextInt()) {
						yCoord = input.nextInt();
						if (yCoord < 0 || yCoord > 2) {
							System.out.println("ERROR: Valid choices for y are between 0 to 2\n");
						}
						else {
							isYValid = true;
						}
					}
					else {
						input.next();
						System.out.println("ERROR: Please input only integers\n");
					}
					isXValid = true;
				}
			}
		}
			else {
				input.next();
				System.out.println("ERROR: Please input only integers\n");
			}
		}
		
		current = new Position (xCoord, yCoord);
				
		return current;
	}
	
	
	/**
	 * Accessor for the row value of the position.
	 * @return	row value of the position.
	 */
	public int getX() {
		return x;
	}
	
	
	/**
	 * Accessor for the column value of the position.
	 * @return	column value of the position.
	 */
	public int getY() {
		return y;
	}
	
	
	/**
	 * Mutator for the Scanner.
	 * @param newInput	new value for the scanner
	 */
	protected static void setScanner(Scanner newInput) {
		
		input = newInput;
	}
	
}
