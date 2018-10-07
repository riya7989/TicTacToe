package edu.northeastern.cs5004.tictactoe;


/**
 * The class that implements the TicTacToeModel interface and stores the grid, takes turns to play and determines who the winner is or if there is one.
 * @author Riya Nadkarni
 * @version 08-03-2018
 */
public class ModelClass implements TicTacToeModel{
	
	/** The board for TicTacToe. */
	private TicTacToeGrid grid;
	
	/** The piece played by the current player. */
	private Piece currentPlayer;
	
	/** Counter keeping track of number of turns taken in the entire game. */
	private int turnCounter;
	
	/**
	 * Default constructor for the model class.
	 */
	public ModelClass() {
		
		grid = new TicTacToeGrid();
		currentPlayer = Piece.X;
		turnCounter = 0;
		
	}

	@Override
	public boolean isGameOver() {
		
		boolean isOver = false;
		
		if (isWinner(Piece.X) || isWinner(Piece.O) || turnCounter == 9) {
			isOver = true;
		}		
		
		return isOver;
	}

	@Override
	public TicTacToeGrid getGrid() {
		
		return grid;  // can return the object since it's implementation has been abstracted inside the TicTacToeGrid Class
	}
	
	
	/**
	 * Mocks/Mimics a game in order to test certain methods.
	 * @param board	new value for the grid
	 */
	protected void mockGame(Piece[][] board) {
		
		grid = new TicTacToeGrid(board);
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != Piece.EMPTY) {
					turnCounter += 1;
					nextPlayer();
				}
			}
		}
	}

	
	@Override
	public void takeTurn() {
		
		Position nextPlay = Position.readPosition();
		boolean isFree = isAvailable(nextPlay);
		
		while (!isFree) {
			System.out.println("ERROR: The position you selected is already taken. Please select an empty position.\n");
			nextPlay = Position.readPosition();
			isFree = isAvailable(nextPlay);
		}
		
		update (nextPlay);
		nextPlayer();
		turnCounter += 1;
	}
	

	@Override
	public Piece getGameResult() {
		
		Piece winner = Piece.EMPTY;
		
		if (isWinner (Piece.X)) {
			winner = Piece.X;
		}
		else if (isWinner(Piece.O)) {
			winner = Piece.O;
		}
		return winner;
	}
	
	
	/**
	 * Helper method that checks whether a particular position is available for play.
	 * @param p	position to check
	 * @return	true if available, false otherwise
	 */
	private boolean isAvailable (Position p) {
		
		boolean isFree = false;
		
		if (grid.getPosition(p) == Piece.EMPTY) {
			isFree = true;
		}
		return isFree;
	}
	
	
	/**
	 * Helper method that updates a position with the current playing piece.
	 * @param p	the position to be updated
	 */
	private void update (Position p) {
		
		grid.setPosition(p, currentPlayer);
	}
	
	
	/**
	 * Helper method to change the current piece to the next one to be played.
	 */
	private void nextPlayer() {
		
		switch (currentPlayer) {
		
		case O:
			currentPlayer = Piece.X;
			break;
		
		default:
			currentPlayer = Piece.O;
			break;
			
		}
	}
	
	
	/**
	 * Helper method to determine whether there is a winner in the game.
	 * @param m	The piece to check for
	 * @return	true if the piece is winning, false otherwise
	 */
	private boolean isWinner (Piece m) {
		
		return (checkRow(m) || checkColumn(m) || checkDiagonal(m));
			
		}
		
	
	/**
	 * Helper method that checks whether three pieces in a row are the same as the piece m.
	 * @param m	the piece to check against
	 * @return	true if a sequence is found, false otherwise.
	 */
	private boolean checkRow (Piece m) {
		
		int i = 0;
		boolean rowCheck = false;
		
		while (i < TicTacToeGrid.SIZE) {
			int j = 0;
			int counter = 0;
			while (j < TicTacToeGrid.SIZE) {
				Position current = new Position (i, j);
				Piece currentPiece = grid.getPosition(current);
				if (currentPiece == m) {
					counter += 1;
				}
				j++;
			}
			if (counter == 3) {
				rowCheck = true;
			}
			i++;
		}
		
		return rowCheck;
	}
	
	
	/**
	 * Helper method that checks whether three pieces in a column are the same as the piece m.
	 * @param m	the piece to check against
	 * @return	true if a sequence is found, false otherwise.
	 */
	private boolean checkColumn (Piece m) {
		
		int i = 0;
		boolean columnCheck = false;
		
		while (i < TicTacToeGrid.SIZE) {
			int j = 0;
			int counter = 0;
			while (j < TicTacToeGrid.SIZE) {
				Position current = new Position (j, i);
				Piece currentPiece = grid.getPosition(current);
				if (currentPiece == m) {
					counter += 1;
				}
				j++;
			}
			if (counter == 3) {
				columnCheck = true;
			}
			i++;
		}
		
		return columnCheck;
	}
	
	
	/**
	 * Helper method that checks whether three pieces in a diagonal are the same as the piece m.
	 * @param m	the piece to check against
	 * @return	true if a sequence is found, false otherwise.
	 */
	private boolean checkDiagonal (Piece m) {
		
		int i = 0;
		int j = 0;
		int k = 2;
		int rightCounter = 0;
		int leftCounter = 0;
		
		while (i < TicTacToeGrid.SIZE) {

			Position current = new Position (i, i);
			Piece currentPiece = grid.getPosition(current);
			if (currentPiece == m) {
				rightCounter += 1;
			}
			i++;
		}
		
		while (j < TicTacToeGrid.SIZE) {
			Position current = new Position (j, k);
			Piece currentPiece = grid.getPosition(current);
			if (currentPiece == m) {
				leftCounter += 1;
			}
			j++;
			k--;
		}
		
		return (rightCounter == 3 || leftCounter == 3);
	}
	
	
	/**
	 * Accessor for the current playing piece.
	 * @return	the current playing piece
	 */
	protected Piece getCurrentPlayer() {
		return currentPlayer;
	}
	
	
	/**
	 * Accessor for the turn counter.
	 * @return	the turn counter
	 */
	protected int getTurnCounter() {
		return turnCounter;
	}

}
