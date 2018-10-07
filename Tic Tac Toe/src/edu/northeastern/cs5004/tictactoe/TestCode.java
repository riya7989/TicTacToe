package edu.northeastern.cs5004.tictactoe;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

/**
 * Class that tests the Scanner output from methods.
 * @author Riya Nadkarni
 * @version 08-08-2018
 */
public class TestCode {
	
	/** The alternate output. */
	private OutputStream os;
	
	/** The new line character. */
	private String nl = System.getProperty("line.separator");
	
	/**
	 * Initiate output and set it to be the new value of system.out before each test is run.
	 */
	@Before
	public void setUp() {
		
		os = new ByteArrayOutputStream();
		System.setOut(new PrintStream(os));
	}

	
	/** Test the play method in ControllerClass. */
	@Test
	public void testPlay() {
		
		ControllerClass testController = new ControllerClass();
		
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
		testString += nl;
		testString += "Enter the x Coordinate of the position you want to play in." + nl;
		testString += "Enter the y Coordinate of the position you want to play in." + nl;
		
		testString += "-------------------------" + nl;
		testString += "|   X   | EMPTY | EMPTY | " + nl + "-------------------------" + nl;
		
		for (int i = 1; i < 3; i++) {
			testString += "| ";
			for (int j = 0; j < 3; j++) {
					testString += "EMPTY";
					testString += " | ";
				}
			testString += nl;
			testString += "-------------------------" + nl;
		}
		testString += nl;
		testString += "Enter the x Coordinate of the position you want to play in." + nl;
		testString += "Enter the y Coordinate of the position you want to play in." + nl;
		
		testString += "-------------------------" + nl;
		testString += "|   X   |   O   | EMPTY | " + nl + "-------------------------" + nl;
		
		for (int i = 1; i < 3; i++) {
			testString += "| ";
			for (int j = 0; j < 3; j++) {
					testString += "EMPTY";
					testString += " | ";
				}
			testString += nl;
			testString += "-------------------------" + nl;
		}
		testString += nl;
		testString += "Enter the x Coordinate of the position you want to play in." + nl;
		testString += "Enter the y Coordinate of the position you want to play in." + nl;
		
		testString += "-------------------------" + nl;
		testString += "|   X   |   O   |   X   | " + nl + "-------------------------" + nl;
		
		for (int i = 1; i < 3; i++) {
			testString += "| ";
			for (int j = 0; j < 3; j++) {
					testString += "EMPTY";
					testString += " | ";
				}
			testString += nl;
			testString += "-------------------------" + nl;
		}
		testString += nl;
		testString += "Enter the x Coordinate of the position you want to play in." + nl;
		testString += "Enter the y Coordinate of the position you want to play in." + nl;
		
		testString += "-------------------------" + nl;
		testString += "|   X   |   O   |   X   | " + nl + "-------------------------" + nl;
		testString += "|   O   | EMPTY | EMPTY | " + nl + "-------------------------" + nl;
		
		for (int i = 2; i < 3; i++) {
			testString += "| ";
			for (int j = 0; j < 3; j++) {
					testString += "EMPTY";
					testString += " | ";
				}
			testString += nl;
			testString += "-------------------------" + nl;
		}
		testString += nl;
		testString += "Enter the x Coordinate of the position you want to play in." + nl;
		testString += "Enter the y Coordinate of the position you want to play in." + nl;
		
		testString += "-------------------------" + nl;
		testString += "|   X   |   O   |   X   | " + nl + "-------------------------" + nl;
		testString += "|   O   |   X   | EMPTY | " + nl + "-------------------------" + nl;
		
		for (int i = 2; i < 3; i++) {
			testString += "| ";
			for (int j = 0; j < 3; j++) {
					testString += "EMPTY";
					testString += " | ";
				}
			testString += nl;
			testString += "-------------------------" + nl;
		}
		testString += nl;
		testString += "Enter the x Coordinate of the position you want to play in." + nl;
		testString += "Enter the y Coordinate of the position you want to play in." + nl;
		
		testString += "-------------------------" + nl;
		testString += "|   X   |   O   |   X   | " + nl + "-------------------------" + nl;
		testString += "|   O   |   X   |   O   | " + nl + "-------------------------" + nl;
		
		for (int i = 2; i < 3; i++) {
			testString += "| ";
			for (int j = 0; j < 3; j++) {
					testString += "EMPTY";
					testString += " | ";
				}
			testString += nl;
			testString += "-------------------------" + nl;
		}
		testString += nl;
		testString += "Enter the x Coordinate of the position you want to play in." + nl;
		testString += "Enter the y Coordinate of the position you want to play in." + nl;
		
		testString += "-------------------------" + nl;
		testString += "|   X   |   O   |   X   | " + nl + "-------------------------" + nl;
		testString += "|   O   |   X   |   O   | " + nl + "-------------------------" + nl;
		testString += "|   X   | EMPTY | EMPTY | " + nl + "-------------------------" + nl;
		
		testString += nl;
		testString += "CONGRATULATIONS!! The winnner of the game is X" + nl + nl;
		
		String inputValue = "0\n0\n0\n1\n0\n2\n1\n0\n1\n1\n1\n2\n2\n0\n2\n1\n2\n2\n";
		Scanner testScanner = new Scanner(inputValue);
		Position.setScanner(testScanner);
		
		testController.play();
		assertEquals("Incorrect output", testString, os.toString());
	}
}
