package application;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.geometry.Insets;

public class Converter extends Application {
	
	Button btDec2Bin = new Button("Decimal to Binary");
	Button btDec2Hex = new Button("Decimal to Hex");
	Button btBin2Dec = new Button("Binary to Decimal");
	Button btHex2Dec = new Button("Hex to Decimal");
	TextField input = new TextField();
	TextField output = new TextField();
	BorderPane pane = new BorderPane();
	HBox buttons = new HBox(10);
	VBox fields = new VBox(10);

	@Override
	public void start(Stage primaryStage) {
		
		/** setup the pane */
		output.setEditable(false);
		buttons.setAlignment(Pos.CENTER);
		fields.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(btDec2Bin, btDec2Hex, btBin2Dec, btHex2Dec);
		fields.getChildren().addAll(input, output);
		pane.setTop(buttons);
		pane.setCenter(fields);
		pane.setPadding(new Insets(10, 10, 10, 10));
		
		Scene scene = new Scene(pane, 500, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Number converter");
		primaryStage.setResizable(false);
		primaryStage.show();
		
		
		
		btDec2Bin.setOnAction(e -> {
			try {
		    	output.setText(dec2Bin(Integer.parseInt(input.getText())));
			}
	    	catch (Exception f) {
	    		output.setText("0");
	    	}
	    } );
		
		btDec2Hex.setOnAction(e -> {
			try {
		    	output.setText(dec2Hex(Integer.parseInt(input.getText())));
			}
	    	catch (Exception f) {
	    		output.setText("0");
	    	}
	    } );
		
		btBin2Dec.setOnAction(e -> {
			try {
		    	output.setText(Integer.toString(bin2Dec(input.getText())));
			}
	    	catch (Exception f) {
	    		output.setText("0");
	    	}
	    } );
		
		btHex2Dec.setOnAction(e -> {
			try {
		    	output.setText(Integer.toString(hex2Dec(input.getText())));
			}
	    	catch (Exception f) {
	    		output.setText("0");
	    	}
	    } );
		
	
	}
	
	private String dec2Bin(int value) {
		if (value < 2)
			return "" + value;
		else return dec2Bin(value/2) + (value % 2);
	}
	
	private String dec2Hex(int value) {
		if (value < 10)
			return "" + value;
		else if (value >= 10 && value < 16)
			return "" + (char) ('A'-10 + value);
		else return dec2Hex(value/16) + ((value % 16) < 10 ? 
				(value % 16) : (char)('A' -10 + (value%16))+"" );
	}
	
	private int bin2Dec(String string) {
		if (!validBin(string)) // check if binary is valid
			return 0;
		else 
			return bin2Dec(string, 0, string.length()-1);
	}
	
	private int bin2Dec(String string, int low, int high) {
		if (high <= low) {
			return (string.charAt(low) - '0');
		}
		else 
			return bin2Dec(string, low, high-1)*2 + (string.charAt(high) - '0');
	}
	
	

	
	private int hex2Dec(String string) {
		if (!validHex(string)) // check if hexadecimal is valid
			return 0;
		else
			return hex2Dec(string, 0, string.length()-1);
	}
	
	private int hex2Dec(String string, int low, int high) {
		if (high <= low) {
			if (string.charAt(high) >= '0' && string.charAt(high) <= '9')
				return (string.charAt(high) - '0');
			else if (string.charAt(high) >= 'A' && string.charAt(high) <= 'F')
				return (string.charAt(high)+10 - 'A');	
		}
		return hex2Dec(string, low, high-1)*16 + 
				((string.charAt(high) <= '9') ? 
						(string.charAt(high)-'0'): (string.charAt(high)+10 - 'A'));
	}
	
	
	/** checking if the binary or hex is valid or not */
	private boolean validBin(String string) {
		char ch = '0';
		if (string.length() > 31) return false;
		for (int i = 0; i < string.length(); i++) {
			ch = string.charAt(i);
			if ((ch < '0' || ch > '1'))
				return false;
		}
		return true;
	}
	
	private boolean validHex(String string) {
		if (string.length() > 8) return false;
		char ch = '0';
		for (int i = 0; i < string.length(); i++) {
			ch = string.charAt(i);
			if (!(ch >= '0' && ch <= '9') && !(ch >= 'A' && ch <= 'F'))
				return false;
		}
		return true;
	}
	



	public static void main(String[] args) {
		launch(args);
	}
}
