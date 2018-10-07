package edu.northeastern.cs5004.tictactoe;

/**
 * Class that implements the TicTacToeView interface and displays the board to the console as well as the winner.
 * @author Riya Nadkarni
 * @version 08-03-2018
 */
public class ViewClass implements TicTacToeView {

	@Override
	public void displayBoard(TicTacToeGrid board) {
		System.out.println(board.toString());
		
	}

	@Override
	public void displayWinner(Piece winner) {
		
		String nl = System.getProperty("line.separator");
		
		if (winner == Piece.EMPTY) {
			System.out.println("The match is a DRAW." + nl);
		} else {
			System.out.println("CONGRATULATIONS!! The winnner of the game is " + winner + nl);
		}
	}

}
