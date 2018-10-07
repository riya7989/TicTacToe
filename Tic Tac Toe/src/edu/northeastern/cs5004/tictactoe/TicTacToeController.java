package edu.northeastern.cs5004.tictactoe;

/**
 * Controller for our TicTacToe implementation.
 * 
 * @author CS 5004 Class Full Summer 2018
 *
 */
public interface TicTacToeController {

	/**
	 * Plays the game of TicTacToe. It does this by first creating an instance of
	 * the Model. Then as long as the game is not over, it displays the board,
	 * invokes the takeTurn method of the model.  Once the game is over, it
	 * will get the result of the game and ask the view to display it.
	 */
	void play();
}
