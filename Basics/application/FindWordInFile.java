package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import java.io.*;
import java.util.*;

public class FindWordInFile extends Application {
	
	String word;
	String dir; // Directory
	String printOut; //Text area where everything prints out
	int nrOfWords, nrOfDirs, nrOfFiles;
	Scanner input;
	Scanner lineReader;
	TextArea output = new TextArea();
	File file;

	@Override
	public void start(Stage primaryStage) throws Exception {
		/**Set up the panes, text fields and buttons*/
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10, 10, 10 ,10));
		Button searchBtn = new Button("Search");
		searchBtn.setPadding(new Insets(5, 5, 5, 5));
		TextField wordInput = new TextField();
		wordInput.setPadding(new Insets(5, 5, 5, 5));
		wordInput.setMinWidth(230); wordInput.setPromptText("word");
		TextField dirInput = new TextField();
		dirInput.setPadding(new Insets(5, 5, 5, 5));
		dirInput.setMinWidth(280); dirInput.setPromptText("Directory or filename");
		
		/**Set up the TextAre named output */
		output.setPadding(new Insets(5, 5, 5, 5)); output.setEditable(false);
		output.setText("A simple software to find words in different files under a directory. \n"
				+ "Write the directory in this format: "
				+ "\"C:\\\\Users\\\\Username\\\\workspace\\\\Document.txt \n \n");
		
		/** Put everything together */
		HBox top = new HBox(20);
		top.setPadding(new Insets(5, 5, 20, 5));
		top.setAlignment(Pos.CENTER);
		top.getChildren().addAll(dirInput, wordInput, searchBtn);
		pane.setTop(top); pane.setCenter(output);
		
		/** Get started */
		Scene scene = new Scene(pane, 700, 500);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Find Word In File");
		primaryStage.show();
		
		
		/** When you click the search button */
		searchBtn.setOnAction(e -> {
			try {
				file = new File(dirInput.getText());
				if (!file.exists()) {
					output.setText("Invalid directory path, try again!");
					return;
				} 
				word = wordInput.getText();
				output.appendText("Search Start \n");
				output.appendText("------------------------------------------------------\n");
				findFile(word, file);
				output.appendText("Search end.\n");
				if (nrOfWords < 1) {
					output.appendText(word + " does not exist. ");
				} else {
					output.appendText(String.format("Searched: %d directories and "
							+ "%d files, found %d occurrences of \"%s\"", nrOfDirs, nrOfFiles, 
							nrOfWords, word));
				}
				nrOfWords = nrOfDirs = nrOfFiles = 0;
				
			} catch (Exception f) {
				output.setText("ERROR");
				}
	    } );
		
	} /**end Start*/
	
	/** The recursive File finder function. It does only look at directories
	 * if the path is a directory.
	 */
	public void findFile(String word, File f1) throws Exception {
		try {
			if (f1.isFile()) {
				nrOfFiles++;
				findWord(word, f1);
				return;
			}
			else if (f1.isDirectory()) {
				nrOfDirs++;
				File[] files = f1.listFiles();
				for (File f: files) {
					findFile(word, f);
				}		
			}
		} catch (Exception e) {
			System.out.close();
		}		
	} /** End findFile */
	
	/** findWord method, you can search compounding words too like "aa bb" */
	public void findWord(String wrd, File f1) throws Exception {
		try {
			input = new Scanner(f1);
			String line = new String();
			String tmpLine = new String();
			
			//Read the whole line and put it in a line
			while (input.hasNextLine()) {
				line = input.nextLine();
				tmpLine = line;  //We keep line, but we will cut off tmpLine
				lineReader = new Scanner(line);
				//Then check if the line contains the word, if so do some actions
				    while (tmpLine.contains(wrd)) {
				    	nrOfWords++;
				    	//Cut off the word found in the line so we are not stuck
				    	//finding the same word again and again
				    	tmpLine = tmpLine.substring(tmpLine.indexOf(wrd) 
				    			+ wrd.length(), tmpLine.length()); 
				    	output.appendText(f1.getAbsolutePath() + ": ");
				    	output.appendText("      " + line);
				    	output.appendText("\n");
				    } // while word found in the line
			} // end outer while getting whole lines
		} catch (FileNotFoundException e) {
			System.out.close();
		}
		System.out.println(nrOfWords);
	}  /** end findWord*/
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}