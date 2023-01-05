package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.geometry.Insets;

public class ReverseInteger extends Application {
	
	
//	Scanner inputs = new Scanner(System.in);
	int num, reverseNum;
	
	Button bt2Reverse = new Button("Reverse");
	TextField input = new TextField();
	TextField output = new TextField();
	BorderPane pane = new BorderPane();
	HBox hbox = new HBox(10);
	VBox vbox = new VBox(10);
	

	@Override
	public void start(Stage primaryStage) {
		//num = inputs.nextInt();
		
		/** Setup the pane and nodes */
		output.setEditable(false);
		output.setPadding(new Insets(3, 3, 3, 3));
		output.setMinWidth(358);
		input.setMinWidth(300);
		input.setPadding(new Insets(3, 3, 3, 3));
		bt2Reverse.setPadding(new Insets(3, 3, 3, 3));
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setCenter(vbox);
		pane.setTop(hbox);
		hbox.getChildren().addAll(input, bt2Reverse);
		vbox.getChildren().add(output);
		hbox.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		
		bt2Reverse.setOnAction(e -> {
			try {
				num = Integer.parseInt(input.getText());
				if (num  < 0) {
					input.clear();
					output.setText("Please type in positive integer");
				} else {
					output.setText(Integer.toString(reverseInteger(num)));
				}
		    	
			}
	    	catch (Exception f) {
	    		output.setText("Invalid input");
	    		input.clear();
	    	}
	    } );
		
		
		Scene scene = new Scene(pane, 400, 100);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Reverse Integer");
		primaryStage.show();
		
		
	//	reverseInteger(num);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public int reverseInteger(int value) {
		int tenth = 1;
		if (value < 10) {
			return value;
		}
		while ( value / tenth >= 10) {
			tenth *= 10;
		}
		return reverseInteger(value/10) + (value%10)*tenth;
	}
	
	/*	public int reverseInteger(int value) {
		int number = 0;
		while (value > 0) {
			number = number*10 + (value % 10);
			value = value/10;
		} return number;
		
	}*/
	
	/* Del 1
	public void reverseInteger(int value) {
	
		if (value/10 == 0) {
			System.out.print(value);
			return;
		}
		System.out.print(value % 10);
		reverseInteger(value / 10);
	}
	*/
	
/*	public int reverseInteger(int value) {
		
	}*/
}
