package edu.northeastern.cs5004.tictactoe;

/**
 * Class that implements the TicTacToeController interface and plays the game by communicating with the Model and View Classes.
 * @author Riya Nadkarni
 * @version 08-04-2018
 */
public class ControllerClass implements TicTacToeController {

	@Override
	public void play() {
		
		ModelClass model = new ModelClass();
		ViewClass view = new ViewClass();
		
		while (!model.isGameOver()) {
			
			view.displayBoard(model.getGrid());
			model.takeTurn();
		}
		
		Piece winner = model.getGameResult();
		view.displayBoard(model.getGrid());
		view.displayWinner(winner);
	}

	
}
