package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TowerOfHanoi extends Application {

	public static TextArea output;
	public static int nrOfMoves, nrOfCalls = 0;
	
	@Override
	public void start(Stage primaryStage) {
		/**Set up the panes, text fields and buttons*/
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10, 10, 10 ,10));
		Button btn = new Button("Find moves");
		btn.setPadding(new Insets(5, 5, 5, 5));
		TextField inField = new TextField();
		inField.setPadding(new Insets(5, 5, 5, 5));
		inField.setMinWidth(300); inField.setPromptText("Number of Disks");
		
		output = new TextArea();
		output.setPadding(new Insets(5, 5, 5, 5)); output.setEditable(false);
		
		/** Put everything together */
		HBox top = new HBox(20);
		top.setPadding(new Insets(5, 5, 20, 5));
		top.setAlignment(Pos.CENTER);
		top.getChildren().addAll(inField, btn);
		pane.setTop(top); pane.setCenter(output);
		
		/** Get started */
		Scene scene = new Scene(pane, 700, 500);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Tower of Hanoi");
		primaryStage.show();
		
		
		btn.setOnAction(a -> {
			try {
				output.clear();
				output.appendText("The moves are: \n");
				moveDisks(Integer.parseInt(inField.getText()),
						'A', 'B', 'C');
				output.appendText("\nNumber of calls to method are " + nrOfCalls);
				nrOfMoves = nrOfCalls = 0;
				inField.clear();
			}
			catch (Exception e) {
				output.setText("Invalid input, type in integer!");
			}
		});
			
	}

	  /** The method for finding the solution to move n disks
	      from fromTower to toTower with auxTower */
	
	  public static void moveDisks(int n, char fromTower,
	      char toTower, char auxTower) {
		  nrOfCalls++;
	    if (n == 1) {
	    	nrOfMoves++;
		    output.appendText("Move number: " + nrOfMoves + 
		    		  " move disk " + n + " from " + 
		    		  fromTower + " to " + toTower + "\n");
	    }
	    else {
	      moveDisks(n - 1, fromTower, auxTower, toTower);
	      nrOfMoves++;
	      output.appendText("Move number: " + nrOfMoves +
	    		  " move disk " + n + " from " +
	    		  fromTower + " to " + toTower + "\n");
	      moveDisks(n - 1, auxTower, toTower, fromTower);
	    }
	  }	

	public static void main(String[] args) {
		launch(args);
	}
}
