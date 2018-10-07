package edu.northeastern.cs5004.tictactoe;

/**
 * Class that implements the TicTacToeView Interface and creates the grid for the game.
 * @author Riya Nadkarni
 * @version 08-03-2018
 */
public class TicTacToeGrid {

	/** size of the grid (number of rows/columns). */
	public static final int SIZE = 3;
	
	/** the board for the TicTacToe game. */
	private Piece[][] grid;
	
	
	/**
	 * Default constructor for the grid.
	 */
	public TicTacToeGrid() {
		grid = new Piece [3][3];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				grid[i][j] = Piece.EMPTY;
			}
		}
	}
	
	
	/**
	 * Constructor for the grid.
	 * @param board	the array values to be passed on to the new grid
	 */
	protected TicTacToeGrid(Piece[][] board) {
		
		grid = new Piece [3][3];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				grid[i][j] = board[i][j];
			}
		}
	}
	
	
	/**
	 * Method to determine the piece at a particular position.
	 * @param p	position in the grid
	 * @return	the piece at that position.
	 */
	public Piece getPosition (Position p) {
		
		int x = p.getX();
		int y = p.getY();
		return grid[x][y];
		
	}
	
	
	/**
	 * Method to mutate a piece at a particular position.
	 * @param p	the position in the grid
	 * @param m	the new value of the piece
	 */
	public void setPosition (Position p, Piece m) {
		
		int x = p.getX();
		int y = p.getY();
		
		grid[x][y] = m;
	}
	
	/**
	 * Converts the grid and returns it in the form of a string.
	 * @return	the grid in the form of a string
	 */
	public String toString() {
		
		String nl = System.getProperty("line.separator");
		
		String result = "-------------------------" + nl;
		
		for (int i = 0; i < 3; i++) {
			result += "| ";
			for (int j = 0; j < 3; j++) {
				if (grid[i][j] == Piece.EMPTY) {
					result += grid[i][j];
					result += " | ";
				}
				else {
					result += "  " + grid[i][j];
					result += "   | ";
				}
			}
			result += nl;
			result += "-------------------------" + nl;
	}
		return result;
	}
}
