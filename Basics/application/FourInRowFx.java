package application;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;

public class FourInRowFx extends Application {
	private BorderPane mainPane;
	private GridPane board;
	private int nrOfRows, nrOfColumns;
	private int plyrOneScore, plyrTwoScore;
	private int[][] numericBoard;
	private int playerNr = 1;
	private Text infoTxt, scoreTable;
	boolean gameStopped = false;
	

	@Override
	public void start(Stage primaryStage) {
		Button startBtn = new Button("Quick start game");
		Text startTxt = new Text("Welcome to Four In Row");
		startTxt.setStyle("-fx-font-size: 3em;");
		VBox startPane = new VBox(); startPane.setPadding(new Insets(10));
		startPane.setSpacing(15); startPane.setAlignment(Pos.CENTER);
		startPane.getChildren().addAll(startTxt, startBtn);
		
		startBtn.setOnAction(e-> {
			nrOfColumns = 7; nrOfRows = 6;
			getBoard(nrOfRows, nrOfColumns);
			primaryStage.setScene(new Scene(mainPane, nrOfColumns*75+100, 
					nrOfRows*75+70));
		});


		infoTxt = new Text(String.format("It's player %s turn. "
				+ "Click a cell to make your move", 
				playerNr == 1 ? "one": "two")); 
		infoTxt.setStyle("-fx-font-size: 1.5em;");
		
		scoreTable = new Text(String.format("Player one  %d - %d  Player two", plyrOneScore, plyrTwoScore));
		scoreTable.setStyle("-fx-font-size: 1.5em;");
		
		VBox text = new VBox(); text.setAlignment(Pos.CENTER);
		text.setSpacing(1); text.getChildren().addAll(infoTxt, scoreTable);
		
		Button newBoardBtn = new Button("New board");
		Button resetScoresBtn = new Button("Reset scores");

		VBox buttons = new VBox(); buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(10);
		buttons.getChildren().addAll(newBoardBtn, resetScoresBtn);
		
		mainPane = new BorderPane();
		mainPane.setTop(text);
		mainPane.setRight(buttons);
		

		
		newBoardBtn.setOnAction(e-> {
			newBoard(nrOfRows, nrOfColumns);
		});
		
		resetScoresBtn.setOnAction(e-> {
			resetScores();
		});

		
		Scene scene1 = new Scene(startPane, 450, 450);
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Four In Row Game");
		primaryStage.setResizable(false);
		primaryStage.show();
	} //End start()
	
	
	
	public void newBoard(int r, int c) {
		gameStopped = false;
		getBoard(r, c);
		infoTxt.setText(String.format("It's player %s turn. "
				+ "Click a cell to make your move", 
				playerNr == 1 ? "one": "two"));
		
	}
	
	public void getBoard(int r, int c) {
		if (board != null) {
			BorderPane.clearConstraints(board);
		}
		board = new GridPane();
		mainPane.setCenter(board);
		board.setStyle("-fx-background-color: blue;");
		board.setHgap(15); board.setVgap(15); board.setPadding(new Insets(10));
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				Circle crcl = new Circle(); crcl.setRadius(30);
				int h = j;
				crcl.setOnMouseClicked(e -> move(h));
				board.add(crcl, j, i);
			}
		}
		numericBoard = new int[c][r];
		
	}
	
	public void move(int column) {
		if (gameStopped)
			return;
		int row = numericBoard[column].length - 1;
		
		while (numericBoard[column][row] != 0) {
			row--;
			if (row < 0) return;
		}
		numericBoard[column][row] = playerNr;
		Circle circle = (Circle) getNodeByRowColumnIndex(row, column);
		if (playerNr == 1)
			circle.setFill(Color.RED);
		else circle.setFill(Color.YELLOW);
		playerNr = playerNr % 2 + 1;
		updateText();
	}
	
	public void updateText() {
		int winner = checkWinner();
		if (winner == 0) {
			infoTxt.setText((String.format("It's player %s turn. "
					+ "Click a cell to make your move", 
					playerNr == 1 ? "one": "two"))); 
		} else {
			gameStopped = true;
			updateScore(winner);
			infoTxt.setText((String.format("Player %s wins!!"
					+ " Click \"New board\" to start a new game!", 
					winner == 1 ? "one": "two")));
			scoreTable.setText(String.format("Player one  %d - %d  Player two", plyrOneScore, plyrTwoScore));
		}
	}
	
	public void updateScore(int winner) {
		if (winner == 1) {
			plyrOneScore++;
		} else plyrTwoScore++;
	}
	
	public void resetScores() {
		plyrOneScore = 0; plyrTwoScore = 0;
		scoreTable.setText(String.format("Player one  %d - %d  "
				+ "Player two", plyrOneScore, plyrTwoScore));
	}
	
	public int checkWinner() {
		int c = 0; int r = 0;
		for (c = 0; c < nrOfColumns - 3; c++) { //Diagonal "\" check
			for (r = 0; r < nrOfRows - 3; r++) {				
				if (numericBoard[c][r] == numericBoard[c+1][r+1] 
						&& numericBoard[c+2][r+2] == numericBoard[c+3][r+3]
						&& numericBoard[c][r] == numericBoard[c+3][r+3] 
								&& (numericBoard[c][r] != 0)) {
					return numericBoard[c][r];
				}
			}
		}
		
		for (c = 0; c < nrOfColumns - 3; c++) { // Diagonal "/" check
			for (r = 3; r < nrOfRows; r++) {				
				if (numericBoard[c][r] == numericBoard[c+1][r-1] 
						&& numericBoard[c+2][r-2] == numericBoard[c+3][r-3]
						&& numericBoard[c][r] == numericBoard[c+3][r-3] 
								&& (numericBoard[c][r] != 0)) {
					return numericBoard[c][r];
				}
			}
		}
		
		for (c = 0; c < nrOfColumns - 3; c++) { // vertical check
			for (r = 0; r < nrOfRows; r++) {
				if (numericBoard[c][r] == numericBoard[c+1][r]
						&& numericBoard[c+2][r] == numericBoard[c+3][r]
						&& numericBoard[c][r] == numericBoard[c+3][r] 
					&& numericBoard[c][r] != 0) {	
					return numericBoard[c][r];
				}
			}
		}
		
		for (c = 0; c < nrOfColumns; c++) {  //Horizontal check
			for (r = 0; r < nrOfRows - 3; r++) {
				if (numericBoard[c][r] == numericBoard[c][r+1] 
					&& numericBoard[c][r+2] == numericBoard[c][r+3]
					&& numericBoard[c][r] == numericBoard[c][r+3]
					&& numericBoard[c][r] != 0) {
					return numericBoard[c][r];
				}
			}
		}
		return 0;
	}
	
	private javafx.scene.Node getNodeByRowColumnIndex(final int row, final int column) {
	    javafx.scene.Node result = null;
	    ObservableList<javafx.scene.Node> children = board.getChildren();

	    for (javafx.scene.Node node : children) {
	        if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
	            result = node;
	            break;
	        }
	    }
	    return result;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
