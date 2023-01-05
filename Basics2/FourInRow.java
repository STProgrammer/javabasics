import java.util.*;

public class FourInRow {
	private static String[][] board;
	private int nrOfColumns;
	private int nrOfRows;
	private int playerOneScore;
	private int playerTwoScore;
	private String playerOneName;
	private String playerTwoName;
	private int turn;
	
	// Constructor
	public FourInRow() {
		this(6, 7, "Player one", "Player two");
	}
	
	// Constructor with chosen names and values
	public FourInRow(int nrOfRows, int nrOfColumns, String name1, String name2) {
		this.nrOfRows = nrOfRows; this.nrOfColumns = nrOfColumns;
		playerOneName = name1; playerTwoName = name2;
		playerOneScore = playerTwoScore = 0;
		turn = 0; //turn 0 is player one, turn 1 is player two.
	} //end constructors
	
	// Building a new board
	public void newBoard(int nrOfRows, int nrOfColumns) {
	board = new String[nrOfRows][nrOfColumns+1];
		for (int i = 0; i < nrOfRows; i++) {
			for (int j = 0; j < nrOfColumns; j++) {
				board[i][j] = "|_";
			}
		}
		for (int k = 0; k < nrOfRows; k++) {
			board[k][nrOfColumns] = "|";
		}
	this.nrOfColumns = nrOfColumns;
	this.nrOfRows = nrOfRows;
	}
	
	// Print the board on screen
	public void showBoard() {
		for (int i = nrOfRows-1; i >= 0; i--) {
			System.out.println();
			for (int j = 0; j < nrOfColumns + 1; j++) {
				System.out.print(board[i][j]);
			}
		}
		System.out.println();
	} //End board methods
	
	// Playing the game
	public void game() {
		int move = 0;
		int spotsLeft = nrOfColumns * nrOfRows;
		int winner = 0;
		/*winner 1 means player 1 wins, winner 2 
		 * means player 2 wins, 0 means no one wins*/
		newBoard(nrOfRows, nrOfColumns);
		showBoard();
		while (spotsLeft > 0) {
			try {
				Scanner input = new Scanner(System.in);
				do { // Making the move
					System.out.println("\n" + 
							(turn == 0 ?  playerOneName + " (X)": playerTwoName + " (O)") + ": ");
					System.out.printf("Type in a number between %d %n"
							+ "and %d to choose a column:%n", 1, nrOfColumns);
					move = input.nextInt();
					if (!isValidMove(move)) {
						System.out.println("Invalid input, try again");			
					} 
					else if (!isSpotLeftOnColumn(move)) {
						System.out.printf("Column %d is full, try another column%n", move);
						showBoard();
					}
				} while (!move(move));
			} catch (Exception e) {
				System.out.println("Invalid input, try again");
				continue;
			}
			showBoard();
			spotsLeft--;
			winner = checkWinner();
			if (winner != 0) {
				submitScore(winner);
				showResults(winner);
				turn = ++turn % 2;
				return;
			}
			turn = ++turn % 2;
		}	
		showResults(winner);
		return;
	} // End game
	
	// Making a move in game
	public boolean move(int move) {
		if (!isValidMove(move)) {return false;}
		else if(!isSpotLeftOnColumn(move)) {return false;}
		int i = 0;
			while(board[i][move-1] != "|_") {
				i++;
			}
		board[i][move-1] = (turn == 0 ?  "|X" : "|O");
		return true;
	}
	
	// Is Valid move?
	public boolean isValidMove(int move) {
		return (move <= nrOfColumns  && move >= 1);
	}
	
	// Is Spot Left on column?
	public  boolean isSpotLeftOnColumn(int move) {
		return(board[nrOfRows-1][move-1] == "|_");
	} // End move methods

	// Check if there's a winner
	public int checkWinner() {
		int i = 0; int j = 0;
		for (i = 0; i < nrOfRows - 3; i++) { //Diagonal "/" check
			for (j = 0; j < nrOfColumns - 3; j++) {				
				if (board[i][j] == board[i+1][j+1] 
						&& board[i+2][j+2] == board[i+3][j+3]
						&& board[i][j] == board[i+3][j+3] 
								&& (board[i][j] != "|_")) {
					return getWinner(board[i][j]);
				}
			}
		}
		
		for (i = 3; i < nrOfRows; i++) { // Diagonal "\" check
			for (j = 0; j < nrOfColumns - 3; j++) {				
				if (board[i][j] == board[i-1][j+1] 
						&& board[i-2][j+2] == board[i-3][j+3]
						&& board[i][j] == board[i-3][j+3] 
								&& (board[i][j] != "|_")) {
					return getWinner(board[i][j]);
				}
			}
		}
		
		for (i = 0; i < nrOfRows - 3; i++) { // vertical check
			for (j = 0; j < nrOfColumns; j++) {
				if (board[i][j] == board[i+1][j]
						&& board[i+2][j] == board[i+3][j]
						&& board[i][j] == board[i+3][j] 
					&& board[i][j] != "|_") {	
					return getWinner(board[i][j]);
				}
			}
		}
		
		for (i = 0; i < nrOfRows ; i++) {  //Horizontal check
			for (j = 0; j < nrOfColumns - 3; j++) {
				if (board[i][j] == board[i][j+1] 
					&& board[i][j+2] == board[i][j+3]
					&& board[i][j] == board[i][j+3]
					&& board[i][j] != "|_") {
					return getWinner(board[i][j]);
				}
			}
		}
		return 0;
	}	
	// Get who is the winner
	private int getWinner(String brick) {
		if (brick == "|X") {return 1;}
		if (brick == "|O") {return 2;}
		else {return 0;}
	}
	// Submit the scores
	public void submitScore(int winner) {
		if (winner == 1) {playerOneScore++;}
		if (winner == 2) {playerTwoScore++;}
	}
	
	// Printing the results
	public void showResults(int winner) {
		if (winner == 0) {
			System.out.println("No one wins! Play again.");
		}
		else {
		System.out.println("\n"
				+ (winner == 1 ? playerOneName: playerTwoName) + " wins!");
		}
		System.out.printf("The score table:%n %s: %d %n %s: %d %n", playerOneName, playerOneScore,
			playerTwoName, playerTwoScore);
	}
	
	// Get methods
	public int getNrOfColumns() {return nrOfColumns;}
	public int getNrOfRows() {return nrOfRows;}
	public int getPlayerOneScore() {return playerOneScore;}
	public int getPlayerTwoScore() {return playerTwoScore;}
	public String getPlayerOneName() {return playerOneName;}
	public String getPlayerTwoName() {return playerTwoName;}
	// Set methods
	public void setNrOfColumns(int num) {
		if (num < 1) {num = 1;}
		nrOfColumns = num;
	}
	public void setNrOfRows(int num) {
		if (num < 1) {num = 1;}
		nrOfRows = num;}
	public void setPlayerOneName(String name) {playerOneName = name;}
	public void setPlayerTwoName(String name) {playerTwoName = name;}
	
	// Main method
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int rows = 6; int columns = 7; int nrOfGames = 10;
		String player1 = "Player One"; String player2 = "Player Two";
		System.out.println("Welcome to Four In Row!");
		System.out.println("Do you want to choose the board size and \n"
				+ "type in player names yourself? (answer with \"y\" \n" 
				+ "for yes, and press any key to just get to the game \n"
				+ "right away).");
		String answer = input.nextLine();
		while (answer.equalsIgnoreCase("y")) {
			try {
				input = new Scanner(System.in);
				System.out.println("How many rows? ");
				rows = input.nextInt();
				System.out.println("How many columns? ");
				columns = input.nextInt();
				System.out.println("Name of player one: ");
				input.nextLine();
				player1 = input.nextLine();
				System.out.println("Name of player two: ");
				player2 = input.nextLine();
				System.out.println("Number of games: ");
				nrOfGames = input.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("invalid input. Try again!");
				continue;
				}
		}
		FourInRow game1 = new FourInRow(rows, columns, player1, player2);
		System.out.println("Let's start playing!");
		while (nrOfGames > 0) {
			System.out.println("New game!");
			game1.game();
			nrOfGames--;
			System.out.println("Games left: " + nrOfGames + "\n");
		}
		System.out.println("\nGame is finished!");
		if (game1.getPlayerOneScore() == game1.getPlayerTwoScore()) {
			System.out.println("No one wins!");
		} else { 
			System.out.print("Winner is: ");
			if (game1.getPlayerOneScore() > game1.getPlayerTwoScore()) {
				System.out.println(game1.getPlayerOneName());
			} else if (game1.getPlayerOneScore() < game1.getPlayerTwoScore()) {
				System.out.println(game1.getPlayerTwoName());
			}
		}
		System.exit(0);
	}
			
}	

	