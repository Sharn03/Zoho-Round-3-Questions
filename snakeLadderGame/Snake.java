package snakeLadderGame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Snake {
	
	//Initializing the board as null before, As we dont know the size of the board given by the user
	private char board[][] = null;
	
	//Queue for storing the tail position
	private Queue<Node>queue = new LinkedList<Node>();
	private Queue<Node>foodQueue = new LinkedList<Node>();
	
	//Constructor
	Snake(int row,int col)
	{
		
		//Declaring the board
		board = new char[row][col];
		
		// storing the initial position in queue
		queue.add(new Node(0,0));
		
		//Manually setting the food position in the board
		
		foodQueue.add(new Node(0,2));
		foodQueue.add(new Node(1,1));
		foodQueue.add(new Node(2,2));
		foodQueue.add(new Node(3,3));
		
		//We are setting the one food in the board for the start of the game
		displayFood(foodQueue.poll());
		
			
	}
	
	//Method to start the game
	public void startGame()
	{
		int row = 0;
		int col = 0;
		
		board[row][col] = '.';
		
		boolean condition = true;
		
		while(condition)
		{
			printBoard();
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the Move:U/D/R/L");
			
			char move = s.next().charAt(0);
			
			//condition for move Up
			if(move == 'U')
			{
				boolean result = snakeMove(--row,col);
				condition = result;
			}
			
			//condition for move Down
			if(move == 'D')
			{
				boolean result = snakeMove(++row,col);
				condition = result;
			}
			
			//condition for move Rigth
			if(move == 'R')
			{
				boolean result = snakeMove(row,++col);
				condition = result;
			}
			
			//condition for move Up
			if(move == 'L')
			{
				boolean result = snakeMove(row,--col);
				condition = result;
			}
		}
	}
	
	public boolean snakeMove(int row,int col)
	{
		//checking if the row and col are not out of the bound
		
		if(row>=0 && row<board.length && col>=0 && col<board[0].length)
		{
			
			//storing the position in the queue
			queue.add(new Node(row,col));
			
			// if the current cell doesnt has the food we have remove the tail
			if(board[row][col] != 'X' &&  board[row][col] != '.')
			{
				// queue store the postion which is the node objects
				Node node = queue.poll();
				
				int r = node.getRow();
				int c = node.getCol();
				
				board[r][c] = '\0'; // we are emptying the cell
			}
			
			//Displaying the another Food('X') position, When we reach food
			
			if(board[row][col] == 'X')
			{
				if(foodQueue.isEmpty())
				{	
					moveForwardAndPlace(board,row,col);
					System.out.println("Game over as there is no more Food");
					return false;
				}
				displayFood(foodQueue.poll());
			}
			
			
			//Snake bites itself
			if(board[row][col] == '.')
			{
				System.out.println("GAME OVER!! As Snake bites itself");
				System.out.println("0");
				return false;
			}
			
			//this method places '.' and 
			moveForwardAndPlace(board,row,col);
			
			
		}
		else
		{
			System.out.println("Invalid Move");
			return false;
		}
		
		return true;
		
	
	}
	
	//Method to setting the food in the board one by one
	private void displayFood(Node node) {
		
		int r = node.getRow();
		int c = node.getCol();
		
		board[r][c] = 'X';
	}
	
	//Method to place the snake
	private void moveForwardAndPlace(char[][] board, int row, int col) {
		board[row][col] = '.';
		
		
	}
	
	//Method to print the board
	private void printBoard() {
		for(int i = 0;i<board.length;i++)
		{
			for(int j = 0;j<board[0].length;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
