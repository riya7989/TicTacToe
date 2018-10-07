package edu.northeastern.cs5004.tictactoe;

/**
 * Representing the view of the MVC for our TicTacToe implementation.
 * 
 * @author CS5004 Class Full Summer 2018
 *
 */
public interface TicTacToeView {

	/**
	 * Display the board to the console by using the toString method.
	 * 
	 * @param board
	 *            The board to be displayed.
	 */
	void displayBoard(TicTacToeGrid board);
	
	/**
	 * Display the winner to the console.
	 * @param winner	
	 * 				the winning piece in the game
	 */
	void displayWinner(Piece winner);
}
