package edu.northeastern.cs5004.tictactoe;

/**
 * The model of Tic Tac Toe that implements all the functionality and stores all
 * the data.
 * 
 * @author CS 5004 Class Full Summer 2018
 *
 */
public interface TicTacToeModel {

	/**
	 * Determine if the current game is over. it does this by checking whether or
	 * not there is a winner.
	 * 
	 * @return true if the game is over, false otherwise
	 */
	boolean isGameOver();

	/**
	 * Returns the grid to the controller so it can ask the view to display it.
	 * 
	 * @return The grid.
	 */
	TicTacToeGrid getGrid();

	/**
	 * Represents one turn of Tic Tac Toe. A turn consists of reading a position,
	 * make sure it is available. Then only if the position is available it will
	 * update the position with the current player, change to the next player, and
	 * update the turn counter
	 */
	void takeTurn();

	/**
	 * Determines who the winner of this game is and returns the piece of the player
	 * or Piece.EMPTY if the game is a draw.
	 * 
	 * @return The winner of the game.
	 */
	Piece getGameResult();

}
