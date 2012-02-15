package com.tour.board;

import com.tour.tile.Tile;

public class Board {
	
	private static final int gB_size = 8;
	private Tile [][] gBoard;
	
	private int knightX;
	private int knightY;
	
	private int numOfMoves; // The current number of valid moves. Used to determine if the game has ended.
	
	public Board() {
		gBoard = new Tile[8][8];
		
		// Initialize the Knight's starting coordinates.
		knightX = 4;
		knightY = 3;
		
		numOfMoves = 0;
		
		for(int i = 0;i < gB_size;i++) {
			for(int j = 0;j < gB_size;j++) {
				gBoard[i][j] = new Tile();
			}
		}
		
		gBoard[knightX][knightY].setType(2);
		
		markValidMoves();
	}
	
	public Tile getPos(int x,int y) {
		return this.gBoard[x][y];
	}
	
	public void setPos(int x,int y,Tile newTile) {
		this.gBoard[x][y] = newTile;
	}
	
	public void move(int x,int y) {
		if(isValidMove(x,y)) {
			this.clearValid();
			this.gBoard[knightX][knightY].visit();
			this.gBoard[x][y].setType(2);
			this.knightX = x;
			this.knightY = y;
		} else {
			System.out.println("Invalid move specified.");
			System.out.println();
		}
		
		this.markValidMoves();
	}
	
	private void markValidMoves() { // Marks all the valid spaces the Knight can move to.
		numOfMoves = 0; // Reset the valid move counter.
		
		// Check Top-Left (-1,-2)
		if(((knightY - 2) >= 0)&&((knightX - 1) >= 0)&&(!(gBoard[knightX - 1][knightY - 2].hasBeenVisited()))) { 
			gBoard[knightX - 1][knightY - 2].setType(3);
			numOfMoves++;
		}
		// Check Top-Right (+1,-2)
		if(((knightY - 2) >= 0)&&((knightX + 1) < gB_size)&&(!(gBoard[knightX + 1][knightY - 2].hasBeenVisited()))) {
			gBoard[knightX + 1][knightY - 2].setType(3); 
			numOfMoves++;
		}
		// Check Right-Top (+2,-1)
		if(((knightX + 2) < gB_size)&&((knightY - 1) >= 0)&&(!(gBoard[knightX + 2][knightY - 1].hasBeenVisited()))) { 
			gBoard[knightX + 2][knightY - 1].setType(3); 
			numOfMoves++;
		}
		// Check Right-Bottom (+2,+1)
		if(((knightX + 2) < gB_size)&&((knightY + 1) < gB_size)&&(!(gBoard[knightX + 2][knightY + 1].hasBeenVisited()))) { 
			gBoard[knightX + 2][knightY + 1].setType(3); 
			numOfMoves++;
		}
		// Check Bottom-Right (+1,+2)
		if(((knightY + 2) < gB_size)&&((knightX + 1) < gB_size)&&(!(gBoard[knightX + 1][knightY + 2].hasBeenVisited()))) { 
			gBoard[knightX + 1][knightY + 2].setType(3); 
			numOfMoves++;
		}
		// Check Bottom-Left (-1,+2)
		if(((knightY + 2) < gB_size)&&((knightX - 1) >= 0)&&(!(gBoard[knightX - 1][knightY + 2].hasBeenVisited()))) { 
			gBoard[knightX - 1][knightY + 2].setType(3); 
			numOfMoves++;
		}
		// Check Left-Bottom (-2,+1)
		if(((knightX - 2) >= 0)&&((knightY + 1) < gB_size)&&(!(gBoard[knightX - 2][knightY + 1].hasBeenVisited()))) { 
			gBoard[knightX - 2][knightY + 1].setType(3); 
			numOfMoves++;
		}
		// Check Left-Top (-2,-1)
		if(((knightX - 2) >= 0)&&((knightY - 1) >= 0)&&(!(gBoard[knightX - 2][knightY - 1].hasBeenVisited()))) { 
			gBoard[knightX - 2][knightY - 1].setType(3); 
			numOfMoves++;
		}
	}
	
	private void clearValid() { // Sets previously valid move spaces to empty spaces.
		// Check Top-Left (-1,-2)
		if(((knightY - 2) >= 0)&&((knightX - 1) >= 0)&&(gBoard[knightX - 1][knightY - 2].getType() == 3)) gBoard[knightX - 1][knightY - 2].setType(0);
		// Check Top-Right (+1,-2)
		if(((knightY - 2) >= 0)&&((knightX + 1) < gB_size)&&(gBoard[knightX + 1][knightY - 2].getType() == 3)) gBoard[knightX + 1][knightY - 2].setType(0);
		// Check Right-Top (+2,-1)
		if(((knightX + 2) < gB_size)&&((knightY - 1) >= 0)&&(gBoard[knightX + 2][knightY - 1].getType() == 3)) gBoard[knightX + 2][knightY - 1].setType(0);
		// Check Right-Bottom (+2,+1)
		if(((knightX + 2) < gB_size)&&((knightY + 1) < gB_size)&&(gBoard[knightX + 2][knightY + 1].getType() == 3)) gBoard[knightX + 2][knightY + 1].setType(0);
		// Check Bottom-Right (+1,+2)
		if(((knightY + 2) < gB_size)&&((knightX + 1) < gB_size)&&(gBoard[knightX + 1][knightY + 2].getType() == 3)) gBoard[knightX + 1][knightY + 2].setType(0);
		// Check Bottom-Left (-1,+2)
		if(((knightY + 2) < gB_size)&&((knightX - 1) >= 0)&&(gBoard[knightX - 1][knightY + 2].getType() == 3)) gBoard[knightX - 1][knightY + 2].setType(0);
		// Check Left-Bottom (-2,+1)
		if(((knightX - 2) >= 0)&&((knightY + 1) < gB_size)&&(gBoard[knightX - 2][knightY + 1].getType() == 3)) gBoard[knightX - 2][knightY + 1].setType(0);
		// Check Left-Top (-2,-1)
		if(((knightX - 2) >= 0)&&((knightY - 1) >= 0)&&(gBoard[knightX - 2][knightY - 1].getType() == 3)) gBoard[knightX - 2][knightY - 1].setType(0);
	}
	
	private boolean isValidMove(int x,int y) {
		if(((x < 0)||(x >= gB_size))||((y < 0)||(y >= gB_size))) return false;
		return (gBoard[x][y].getType() == 3) ? true : false;
	}
	
	public int movesLeft() {
		return this.numOfMoves;
	}
	
	public boolean gameWon() {
		boolean won = true;
		for(int i = 0;i < gB_size;i++) {
			for(int j = 0;j < gB_size;j++) {
				if(this.gBoard[i][j].getType() != 1) {
					won = false;
					break;
				}
			}
		}
		return won;
	}
	
	public Tile [][] getBoard() {
		return this.gBoard;
	}
	
	public void printBoard() {
		for(int i = 0;i < gB_size;i++) {
			for(int j = 0;j < gB_size;j++) {
				System.out.print(Character.toString(gBoard[i][j].getMark()));
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Valid Moves: " + numOfMoves);
		System.out.println();
	}
	
}
