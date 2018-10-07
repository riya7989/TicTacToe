package edu.northeastern.cs5004.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Scanner;

import org.junit.Test;

/**
 * Tests that verify whether the TicTacToe MVC model works as expected.
 * @author Riya Nadkarni
 * @version 08-05-2018
 */
public class TicTacToeTest {

	/**
	 * Tests whether the Grid default constructor works as expected.
	 */
	@Test
	public void testTicTacToeGridDefaultConstructor() {
		
		TicTacToeGrid testGrid = new TicTacToeGrid();
		assertEquals("Incorrect cell (0,0) value.", Piece.EMPTY, testGrid.getPosition(new Position(0,0)));
		assertEquals("Incorrect cell (0,1) value.", Piece.EMPTY, testGrid.getPosition(new Position(0,1)));
		assertEquals("Incorrect cell (0,2) value.", Piece.EMPTY, testGrid.getPosition(new Position(0,2)));
		assertEquals("Incorrect cell (1,0) value.", Piece.EMPTY, testGrid.getPosition(new Position(1,0)));
		assertEquals("Incorrect cell (1,1) value.", Piece.EMPTY, testGrid.getPosition(new Position(1,1)));
		assertEquals("Incorrect cell (1,2) value.", Piece.EMPTY, testGrid.getPosition(new Position(1,2)));
		assertEquals("Incorrect cell (2,0) value.", Piece.EMPTY, testGrid.getPosition(new Position(2,0)));
		assertEquals("Incorrect cell (2,1) value.", Piece.EMPTY, testGrid.getPosition(new Position(2,1)));
		assertEquals("Incorrect cell (2,2) value.", Piece.EMPTY, testGrid.getPosition(new Position(2,2)));
		assertEquals("Incorrect size of the grid.", 3, TicTacToeGrid.SIZE);
	}
	
	
	/**
	 * Tests whether the TicTacToeGrid constructor with parameters works as expected.
	 */
	@Test
	public void testTicTacToeGridConstructor() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.EMPTY;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.EMPTY;
		testBoard[1][0] = Piece.O;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.EMPTY;
		testBoard[2][1] = Piece.X;
		testBoard[2][2] = Piece.O;
		TicTacToeGrid testGrid = new TicTacToeGrid(testBoard);
		assertEquals("Incorrect cell (0,0) value.", Piece.EMPTY, testGrid.getPosition(new Position(0,0)));
		assertEquals("Incorrect cell (0,1) value.", Piece.X, testGrid.getPosition(new Position(0,1)));
		assertEquals("Incorrect cell (0,2) value.", Piece.EMPTY, testGrid.getPosition(new Position(0,2)));
		assertEquals("Incorrect cell (1,0) value.", Piece.O, testGrid.getPosition(new Position(1,0)));
		assertEquals("Incorrect cell (1,1) value.", Piece.O, testGrid.getPosition(new Position(1,1)));
		assertEquals("Incorrect cell (1,2) value.", Piece.X, testGrid.getPosition(new Position(1,2)));
		assertEquals("Incorrect cell (2,0) value.", Piece.EMPTY, testGrid.getPosition(new Position(2,0)));
		assertEquals("Incorrect cell (2,1) value.", Piece.X, testGrid.getPosition(new Position(2,1)));
		assertEquals("Incorrect cell (2,2) value.", Piece.O, testGrid.getPosition(new Position(2,2)));
		assertEquals("Incorrect size of the grid.", 3, TicTacToeGrid.SIZE);
	}
	
	
	/**
	 * Tests the toString method in TicTacToeGrid.
	 */
	@Test
	public void testGridToString() {
		
		String nl = System.getProperty("line.separator");
		
		TicTacToeGrid testGrid = new TicTacToeGrid();
		String testString = "-------------------------" + nl;
				
		for (int i = 0; i < 3; i++) {
			testString += "| ";
			for (int j = 0; j < 3; j++) {
				testString += "EMPTY";
				testString += " | ";
			}
			testString += nl;
			testString += "-------------------------" + nl;
		}
		
		String actual = testGrid.toString();
		assertEquals("toString output mismatch.", testString, actual);
		assertEquals("Incorrect size of the grid.", 3, TicTacToeGrid.SIZE);
	}
	
	
	/**
	 * Tests the toString method in TicTacToeGrid.
	 */
	@Test
	public void testGridToStringAgain() {
		
		String nl = System.getProperty("line.separator");
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.EMPTY;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.EMPTY;
		testBoard[1][0] = Piece.O;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.EMPTY;
		testBoard[2][1] = Piece.X;
		testBoard[2][2] = Piece.O;
		TicTacToeGrid testGrid = new TicTacToeGrid(testBoard);
		String testString = "-------------------------" + nl;
				
		for (int i = 0; i < 3; i++) {
			testString += "| ";
			for (int j = 0; j < 3; j++) {
				Position current = new Position (i, j);
				if (testGrid.getPosition(current) == Piece.EMPTY) {
					testString += "EMPTY";
					testString += " | ";
				}
				else {
					testString += "  " + testGrid.getPosition(current);
					testString += "   | ";
				}
			}
			testString += nl;
			testString += "-------------------------" + nl;
		}
		String actual = testGrid.toString();
		assertEquals("toString output mismatch.", testString, actual);
		assertEquals("Incorrect size of the grid.", 3, TicTacToeGrid.SIZE);
	}
	
	
	/**
	 * Tests whether the Model constructor works as expected.
	 */
	@Test
	public void testModelConstructor() {
		
		TicTacToeGrid testGrid = new TicTacToeGrid();
		ModelClass testModel = new ModelClass();
		assertEquals("Incorrect grid value.", testGrid.toString(), testModel.getGrid().toString());
		assertEquals("Incorrect current player.", Piece.X, testModel.getCurrentPlayer());
		assertEquals("Incorrect turn counter value.", 0, testModel.getTurnCounter());
	}
	
	
	/**
	 * Tests whether the getGrid method in ModelClass works as expected.
	 */
	@Test
	public void testGetGridInModel() {
		
		TicTacToeGrid testGrid = new TicTacToeGrid();
		ModelClass testModel = new ModelClass();
		assertEquals("Incorrect grid value.", testGrid.toString(), testModel.getGrid().toString());
		assertEquals("Incorrect current player.", Piece.X, testModel.getCurrentPlayer());
		assertEquals("Incorrect turn counter value.", 0, testModel.getTurnCounter());
	}
	
	
	/**
	 * Tests the isGameOver method with empty cell values.
	 */
	@Test
	public void testIsGameOverWithIncompleteBoard() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.EMPTY;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.EMPTY;
		testBoard[1][0] = Piece.O;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.EMPTY;
		testBoard[2][1] = Piece.X;
		testBoard[2][2] = Piece.O;
		ModelClass testModel = new ModelClass();
		testModel.mockGame(testBoard);
		boolean isOver = testModel.isGameOver();
		assertEquals("Incorrect evaluation of the game.", false, isOver);
		assertEquals("Incorrect current player.", Piece.X, testModel.getCurrentPlayer());
		assertEquals("Incorrect turn counter value.", 6, testModel.getTurnCounter());
	}
	
	
	/**
	 * Tests the isGameOver method with a draw scenario.
	 */
	@Test
	public void testIsGameOverWithDrawCase() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.X;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.O;
		testBoard[1][0] = Piece.O;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.X;
		testBoard[2][1] = Piece.X;
		testBoard[2][2] = Piece.O;
		ModelClass testModel = new ModelClass();
		testModel.mockGame(testBoard);
		boolean isOver = testModel.isGameOver();
		assertEquals("Incorrect evaluation of the game.", true, isOver);
		assertEquals("Incorrect current player.", Piece.O, testModel.getCurrentPlayer());
		assertEquals("Incorrect turn counter value.", 9, testModel.getTurnCounter());
	}
	
	
	/**
	 * Tests the isGameOver method with a row win scenario.
	 */
	@Test
	public void testIsGameOverWithRowWinCase() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.X;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.X;
		testBoard[1][0] = Piece.O;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.EMPTY;
		testBoard[2][1] = Piece.EMPTY;
		testBoard[2][2] = Piece.O;
		ModelClass testModel = new ModelClass();
		testModel.mockGame(testBoard);
		boolean isOver = testModel.isGameOver();
		assertEquals("Incorrect evaluation of the game.", true, isOver);
		assertEquals("Incorrect current player.", Piece.O, testModel.getCurrentPlayer());
		assertEquals("Incorrect turn counter value.", 7, testModel.getTurnCounter());
	}
	
	
	/**
	 * Tests the isGameOver method with a column win scenario.
	 */
	@Test
	public void testIsGameOverWithColumnWinCase() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.O;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.X;
		testBoard[1][0] = Piece.X;
		testBoard[1][1] = Piece.X;
		testBoard[1][2] = Piece.O;
		testBoard[2][0] = Piece.O;
		testBoard[2][1] = Piece.X;
		testBoard[2][2] = Piece.O;
		ModelClass testModel = new ModelClass();
		testModel.mockGame(testBoard);
		boolean isOver = testModel.isGameOver();
		assertEquals("Incorrect evaluation of the game.", true, isOver);
		assertEquals("Incorrect current player.", Piece.O, testModel.getCurrentPlayer());
		assertEquals("Incorrect turn counter value.", 9, testModel.getTurnCounter());
	}
	
	
	/**
	 * Tests the isGameOver method with a diagonal win scenario.
	 */
	@Test
	public void testIsGameOverWithDiagonalWinCase() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.O;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.X;
		testBoard[1][0] = Piece.EMPTY;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.EMPTY;
		testBoard[2][0] = Piece.X;
		testBoard[2][1] = Piece.EMPTY;
		testBoard[2][2] = Piece.O;
		ModelClass testModel = new ModelClass();
		testModel.mockGame(testBoard);
		boolean isOver = testModel.isGameOver();
		assertEquals("Incorrect evaluation of the game.", true, isOver);
		assertEquals("Incorrect current player.", Piece.X, testModel.getCurrentPlayer());
		assertEquals("Incorrect turn counter value.", 6, testModel.getTurnCounter());
	}
	
	
	/**
	 * Tests the isGameOver method with a diagonal win scenario again.
	 */
	@Test
	public void testIsGameOverWithDiagonalWinCaseAgain() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.O;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.O;
		testBoard[1][0] = Piece.X;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.O;
		testBoard[2][1] = Piece.EMPTY;
		testBoard[2][2] = Piece.X;
		ModelClass testModel = new ModelClass();
		testModel.mockGame(testBoard);
		boolean isOver = testModel.isGameOver();
		assertEquals("Incorrect evaluation of the game.", true, isOver);
		assertEquals("Incorrect current player.", Piece.X, testModel.getCurrentPlayer());
		assertEquals("Incorrect turn counter value.", 8, testModel.getTurnCounter());
	}
	
	
	/**
	 * Tests the getGameResult method with piece O as winner.
	 */
	@Test
	public void testGetGameResultWithOWinner() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.O;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.O;
		testBoard[1][0] = Piece.X;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.O;
		testBoard[2][1] = Piece.EMPTY;
		testBoard[2][2] = Piece.X;
		ModelClass testModel = new ModelClass();
		testModel.mockGame(testBoard);
		Piece winner = testModel.getGameResult();
		assertEquals("Incorrect winner.", Piece.O, winner);
		assertEquals("Incorrect current player.", Piece.X, testModel.getCurrentPlayer());
		assertEquals("Incorrect turn counter value.", 8, testModel.getTurnCounter());
	}
	
	
	/**
	 * Tests the getGameResult method with piece X as winner.
	 */
	@Test
	public void testGetGameResultWithXWinner() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.X;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.X;
		testBoard[1][0] = Piece.O;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.EMPTY;
		testBoard[2][1] = Piece.EMPTY;
		testBoard[2][2] = Piece.O;
		ModelClass testModel = new ModelClass();
		testModel.mockGame(testBoard);
		Piece winner = testModel.getGameResult();
		assertEquals("Incorrect winner.", Piece.X, winner);
		assertEquals("Incorrect current player.", Piece.O, testModel.getCurrentPlayer());
		assertEquals("Incorrect turn counter value.", 7, testModel.getTurnCounter());
	}
	
	
	/**
	 * Tests the getGameResult method with piece EMPTY as winner.
	 */
	@Test
	public void testGetGameResultWithEMPTYWinner() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.X;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.O;
		testBoard[1][0] = Piece.O;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.X;
		testBoard[2][1] = Piece.X;
		testBoard[2][2] = Piece.O;
		ModelClass testModel = new ModelClass();
		testModel.mockGame(testBoard);
		Piece winner = testModel.getGameResult();
		assertEquals("Incorrect winner.", Piece.EMPTY, winner);
		assertEquals("Incorrect current player.", Piece.O, testModel.getCurrentPlayer());
		assertEquals("Incorrect turn counter value.", 9, testModel.getTurnCounter());
	}
	
	
	/**
	 * Tests whether the display board method works as expected.
	 */
	@Test
	public void testDisplayBoard() {
		
		String nl = System.getProperty("line.separator");
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.EMPTY;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.EMPTY;
		testBoard[1][0] = Piece.O;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.EMPTY;
		testBoard[2][1] = Piece.X;
		testBoard[2][2] = Piece.O;
		TicTacToeGrid testGrid = new TicTacToeGrid(testBoard);
		ViewClass testView = new ViewClass();
		String testString = "-------------------------" + nl;
				
		for (int i = 0; i < 3; i++) {
			testString += "| ";
			for (int j = 0; j < 3; j++) {
				Position current = new Position(i, j);
				if (testGrid.getPosition(current) == Piece.EMPTY) {
					testString += "EMPTY";
					testString += " | ";
				}
				else {
					testString += "  " + testGrid.getPosition(current);
					testString += "   | ";
				}
			}
			testString += nl;
			testString += "-------------------------" + nl;
		}
		
		testView.displayBoard(testGrid);
		assertEquals("toString output mismatch.", testString, testGrid.toString());
	}
	
	
	/**
	 * Tests whether the displayWinner method works as expected (X as winner).
	 */
	@Test
	public void testDisplayWinnerwithX() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.X;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.X;
		testBoard[1][0] = Piece.O;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.EMPTY;
		testBoard[2][1] = Piece.EMPTY;
		testBoard[2][2] = Piece.O;
		ModelClass testModel = new ModelClass();
		testModel.mockGame(testBoard);
		Piece winner = testModel.getGameResult();
		ViewClass testView = new ViewClass();
		testView.displayWinner(winner);
		assertEquals("Incorrect winner displayed.", Piece.X, winner);
	}
	
	
	/**
	 * Tests whether the displayWinner method works as expected (O as winner).
	 */
	@Test
	public void testDisplayWinnerwithO() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.O;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.O;
		testBoard[1][0] = Piece.X;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.O;
		testBoard[2][1] = Piece.EMPTY;
		testBoard[2][2] = Piece.X;
		ModelClass testModel = new ModelClass();
		testModel.mockGame(testBoard);
		Piece winner = testModel.getGameResult();
		ViewClass testView = new ViewClass();
		testView.displayWinner(winner);
		assertEquals("Incorrect winner displayed.", Piece.O, winner);
	}
	
	
	/**
	 * Tests whether the displayWinner method works as expected (Draw Match).
	 */
	@Test
	public void testDisplayWinnerwithEMPTY() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.X;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.O;
		testBoard[1][0] = Piece.O;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.X;
		testBoard[2][1] = Piece.X;
		testBoard[2][2] = Piece.O;
		ModelClass testModel = new ModelClass();
		testModel.mockGame(testBoard);
		Piece winner = testModel.getGameResult();
		ViewClass testView = new ViewClass();
		testView.displayWinner(winner);
		assertEquals("Incorrect message displayed.", Piece.EMPTY, winner);
	}
	
	
	/**
	 * Tests whether the Position constructor works as expected.
	 */
	@Test
	public void testPositionConstructor() {
		
		Position gridCell = new Position(0, 1);
		assertEquals("Incorrect X value.", 0, gridCell.getX());
		assertEquals("Incorrect Y value.", 1, gridCell.getY());
	}
	
	
	/**
	 * Tests the Position constructor with illegal X value.
	 */
	@Test
	public void testPositionConstructorWithIncorrectXValue() {
		
		String expected = "X should be in the range 0 to 2.";
		
		try {
			new Position(3, 1);
			fail("Position constructor did not throw IllegalArgumentException when it should.");
		}
		catch (IllegalArgumentException ex) {
			assertEquals ("Position Constructor not working properly.", expected, ex.getMessage());
		}
	}
	
	
	/**
	 * Tests the Position constructor with illegal X value again.
	 */
	@Test
	public void testPositionConstructorWithIncorrectXValueAgain() {
		
		String expected = "X should be in the range 0 to 2.";
		
		try {
			new Position(-5, 1);
			fail("Position constructor did not throw IllegalArgumentException when it should.");
		}
		catch (IllegalArgumentException ex) {
			assertEquals ("Position Constructor not working properly.", expected, ex.getMessage());
		}
	}
	
	
	/**
	 * Tests the Position constructor with illegal Y value.
	 */
	@Test
	public void testPositionConstructorWithIncorrectYValue() {
		
		String expected = "Y should be in the range 0 to 2.";
		
		try {
			new Position(2, 6);
			fail("Position constructor did not throw IllegalArgumentException when it should.");
		}
		catch (IllegalArgumentException ex) {
			assertEquals ("Position Constructor not working properly.", expected, ex.getMessage());
		}
	}
	
	
	/**
	 * Tests the Position constructor with illegal Y value again.
	 */
	@Test
	public void testPositionConstructorWithIncorrectYValueAgain() {
		
		String expected = "Y should be in the range 0 to 2.";
		
		try {
			new Position(2, -2);
			fail("Position constructor did not throw IllegalArgumentException when it should.");
		}
		catch (IllegalArgumentException ex) {
			assertEquals ("Position Constructor not working properly.", expected, ex.getMessage());
		}
	}
	
	
	/**
	 * Tests whether getPosition method in TicTacToeGrid works as expected.
	 */
	@Test
	public void testGetPosition() {
		
		Position gridCell = new Position(0, 1);
		TicTacToeGrid testGrid = new TicTacToeGrid();
		Piece testPiece = testGrid.getPosition(gridCell);
		assertEquals("Incorrect value of piece.", Piece.EMPTY, testPiece);
		assertEquals("Incorrect size of the grid.", 3, TicTacToeGrid.SIZE);
	}
	
	
	/**
	 * Tests whether getPosition method in TicTacToeGrid works as expected again.
	 */
	@Test
	public void testGetPositionAgain() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.X;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.O;
		testBoard[1][0] = Piece.O;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.X;
		testBoard[2][1] = Piece.X;
		testBoard[2][2] = Piece.O;
		Position gridCell = new Position(0, 2);
		TicTacToeGrid testGrid = new TicTacToeGrid(testBoard);
		Piece testPiece = testGrid.getPosition(gridCell);
		assertEquals("Incorrect value of piece.", Piece.O, testPiece);
		assertEquals("Incorrect size of the grid.", 3, TicTacToeGrid.SIZE);
	}
	
	
	/**
	 * Tests whether setPosition method in TicTacToeGrid works as expected.
	 */
	@Test
	public void testSetPosition() {
		
		Position gridCell = new Position(0, 1);
		TicTacToeGrid testGrid = new TicTacToeGrid();
		Piece testPiece = Piece.X;
		testGrid.setPosition(gridCell, testPiece);
		assertEquals("Incorrect value of piece.", Piece.X, testGrid.getPosition(gridCell));
		assertEquals("Incorrect size of the grid.", 3, TicTacToeGrid.SIZE);
	}
	
	
	/**
	 * Tests whether setPosition method in TicTacToeGrid works as expected again.
	 */
	@Test
	public void testSetPositionAgain() {
		
		Piece[][] testBoard = new Piece[3][3];
		testBoard[0][0] = Piece.X;
		testBoard[0][1] = Piece.X;
		testBoard[0][2] = Piece.O;
		testBoard[1][0] = Piece.O;
		testBoard[1][1] = Piece.O;
		testBoard[1][2] = Piece.X;
		testBoard[2][0] = Piece.X;
		testBoard[2][1] = Piece.X;
		testBoard[2][2] = Piece.O;
		Position gridCell = new Position(0, 2);
		TicTacToeGrid testGrid = new TicTacToeGrid(testBoard);
		Piece testPiece = Piece.EMPTY;
		testGrid.setPosition(gridCell, testPiece);
		assertEquals("Incorrect value of piece.", Piece.EMPTY, testGrid.getPosition(gridCell));
		assertEquals("Incorrect size of the grid.", 3, TicTacToeGrid.SIZE);
	}
	
	
	/** Tests whether the readPosition method in Position works as expected. */
	@Test
	public void testReadPosition() {
		
		String inputValue = "1\n2\n";
		Scanner testScanner = new Scanner(inputValue);
		Position.setScanner(testScanner);
		
		Position gridCell = Position.readPosition();
		assertEquals("Incorrect X value.", 1, gridCell.getX());
		assertEquals("Incorrect Y value.", 2, gridCell.getY());
	}
	
	
	/** Tests the readPosition method in Position with incorrect X value. */
	@Test
	public void testReadPositionWithIncorrectX() {
		
		String inputValue = "3\n2\n1\n";
		Scanner testScanner = new Scanner(inputValue);
		Position.setScanner(testScanner);
		
		Position gridCell = Position.readPosition();
		assertEquals("Incorrect X value.", 2, gridCell.getX());
		assertEquals("Incorrect Y value.", 1, gridCell.getY());
	}
	
	
	/** Tests the readPosition method in Position with incorrect X value again. */
	@Test
	public void testReadPositionWithIncorrectXAgain() {
		
		String inputValue = "-2\n2\n1\n";
		Scanner testScanner = new Scanner(inputValue);
		Position.setScanner(testScanner);
		
		Position gridCell = Position.readPosition();
		assertEquals("Incorrect X value.", 2, gridCell.getX());
		assertEquals("Incorrect Y value.", 1, gridCell.getY());
	}
	
	
	/** Tests the readPosition method in Position with incorrect Y value. */
	@Test
	public void testReadPositionWithIncorrectY() {
		
		String inputValue = "0\n-5\n1\n";
		Scanner testScanner = new Scanner(inputValue);
		Position.setScanner(testScanner);
		
		Position gridCell = Position.readPosition();
		assertEquals("Incorrect X value.", 0, gridCell.getX());
		assertEquals("Incorrect Y value.", 1, gridCell.getY());
	}
	
	
	/** Tests the readPosition method in Position with incorrect Y value again. */
	@Test
	public void testReadPositionWithIncorrectYAgain() {
		
		String inputValue = "0\n10\n1\n";
		Scanner testScanner = new Scanner(inputValue);
		Position.setScanner(testScanner);
		
		Position gridCell = Position.readPosition();
		assertEquals("Incorrect X value.", 0, gridCell.getX());
		assertEquals("Incorrect Y value.", 1, gridCell.getY());
	}
	
	
	/** Tests the readPosition method in Position with non-integer value for X. */
	@Test
	public void testReadPositionWithNonIntegerX() {
		
		String inputValue = "zero\n2\n1\n";
		Scanner testScanner = new Scanner(inputValue);
		Position.setScanner(testScanner);
		
		Position gridCell = Position.readPosition();
		assertEquals("Incorrect X value.", 2, gridCell.getX());
		assertEquals("Incorrect Y value.", 1, gridCell.getY());
	}
	
	
	/** Tests the readPosition method in Position with non-integer value for Y. */
	@Test
	public void testReadPositionWithNonIntegerY() {
		
		String inputValue = "0\ntwo\n1\n";
		Scanner testScanner = new Scanner(inputValue);
		Position.setScanner(testScanner);
		
		Position gridCell = Position.readPosition();
		assertEquals("Incorrect X value.", 0, gridCell.getX());
		assertEquals("Incorrect Y value.", 1, gridCell.getY());
	}
	
	
	/** Test whether the takeTurn method in ModelClass works as expected. */
	@Test
	public void testTakeTurn() {
		
		ModelClass testModel = new ModelClass();
		String inputValue = "1\n2\n";
		Scanner testScanner = new Scanner(inputValue);
		Position.setScanner(testScanner);
		Position gridCell = new Position (1, 2);
		testModel.takeTurn();
		assertEquals("Incorrect value updated.", Piece.X, testModel.getGrid().getPosition(gridCell));
		assertEquals("Incorrect current player value.", Piece.O, testModel.getCurrentPlayer());
		assertEquals("Incorrect turn counter value.", 1, testModel.getTurnCounter());
	}
	
	
	/** Test whether the takeTurn method in ModelClass works as expected again. */
	@Test
	public void testTakeTurnAgain() {
		
		ModelClass testModel = new ModelClass();
		Position gridCell = new Position (1, 2);
		testModel.getGrid().setPosition(gridCell, Piece.O);
		String inputValue = "1\n2\n0\n2\n";
		Scanner testScanner = new Scanner(inputValue);
		Position.setScanner(testScanner);
		Position newGridCell = new Position (0, 2);
		testModel.takeTurn();
		assertEquals("Incorrect value updated.", Piece.O, testModel.getGrid().getPosition(gridCell));
		assertEquals("Incorrect value updated.", Piece.X, testModel.getGrid().getPosition(newGridCell));
		assertEquals("Incorrect current player value.", Piece.O, testModel.getCurrentPlayer());
		assertEquals("Incorrect turn counter value.", 1, testModel.getTurnCounter());
	}
	
}
