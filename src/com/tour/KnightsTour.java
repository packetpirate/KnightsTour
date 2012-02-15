package com.tour;

import java.util.Scanner;

import com.tour.board.Board;

/*
 * TODO: After text-based version works, create a GUI version. This version should draw each space as a square and allow you
 * to click the spaces to move the knight to that square.
 */

public class KnightsTour {
	
	private static Board gameBoard;
	
	public static void main(String[] args) {
		gameBoard = new Board();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome to the Knight\'s Tour! Enter the coordinates of the position you want to jump to.");
		System.out.println("Enter coordinates in the format: x y");
		System.out.println("Each value should be between 0 and 7. Valid moves are marked with a V.");
		System.out.println();
		
		boolean play = true;
		
		while(play) {
			gameBoard.printBoard();
			if((!gameBoard.gameWon())&&(gameBoard.movesLeft() > 0)) {
				System.out.print("Enter coordinates: ");
				int x = in.nextInt();
				int y = in.nextInt();
				System.out.println();
				gameBoard.move(x, y);
			} else if((!gameBoard.gameWon())&&(gameBoard.movesLeft() == 0)) {
				System.out.println("You lose! Better luck next time.");
				play = false;
			} else {
				System.out.println("You win! Congratulations!");
				play = false;
			}
		}
	}
	
}
