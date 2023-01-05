package application;

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.io.*;

public class DecryptFile extends Application {
	TextField fileToDecryptField =  new TextField();
	TextField fileToSaveField =  new TextField();
	TextField outputField = new TextField();
	
	public void handleButtonEvent() {
		outputField.clear();
		String inputFile = fileToDecryptField.getText();
		String outputFile = fileToSaveField.getText();
		if (!inputFile.isBlank() && !outputFile.isBlank()) {
			encrypt(inputFile, outputFile);
		}
		else {
			if (inputFile.isBlank()) 
				outputField.appendText("File to decrypt not chosen");
			else if (outputFile.isBlank()) 
				outputField.appendText("Path to save the decrypted file not chosen");
		}
	}
	
	public void encrypt(String inputFile, String outputFile) {
		try (BufferedInputStream input = 
				new BufferedInputStream(new FileInputStream(inputFile));
			BufferedOutputStream output = 
					new BufferedOutputStream(new FileOutputStream(outputFile));) {
			int dataByte = 0;
			while (input.available() != 0) {
				dataByte = input.read();
				dataByte = encryption(dataByte);
				output.write(dataByte);
			}
		outputField.appendText("File is decrypted and saved");
		} catch (FileNotFoundException e) {
			outputField.appendText("File not found");
		} catch (IOException ignore) {
			
		}
	}
	
	private int encryption(int dataByte) {
		return dataByte - 5;
	}
	
	@Override
	public void start(Stage primaryStage) {
	
		fileToDecryptField = new TextField();
		fileToDecryptField.setPrefWidth(300);
		fileToDecryptField.setPromptText("File to decrypt");
	
		fileToSaveField.setPrefWidth(300);
		fileToSaveField.setPromptText("Save decrypted file to");
		
		outputField.setPrefWidth(700);
		outputField.setEditable(false);
		Button btnDecrypt = new Button("Decrypt");

		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10));
		HBox top = new HBox(); top.setSpacing(10);
		HBox bottom = new HBox(); bottom.setSpacing(10);
		top.getChildren().addAll(fileToDecryptField, fileToSaveField, btnDecrypt);
		bottom.getChildren().add(outputField);
		pane.setTop(top); pane.setBottom(bottom);
		top.setAlignment(Pos.CENTER);
		bottom.setAlignment(Pos.CENTER);
		
		btnDecrypt.setOnAction(e -> {
			handleButtonEvent();
		});
		
		Scene scene = new Scene(pane, 750, 100);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Decrypt file");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public static void main(String args[]) {
		launch(args);
	}



}
