package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.transform.*;

public class RotateText extends Application {
	Text letter;
	Rotate rot;
	double fontSize = 20;

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Circle circle = new Circle();
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.centerYProperty().bind(pane.heightProperty().divide(2));
		circle.radiusProperty().bind(pane.heightProperty().divide(4));
		circle.setStyle("-fx-stroke: black; -fx-fill: green");
		pane.getChildren().add(circle);
		
		String text = new String("ABCDEFGHI");
	
		
		for (int i = 0; i < text.length(); i++) {
			letter = new Text(text.substring(i, i+1));
			letter.setFont( new Font(fontSize));
			letter.xProperty().bind(circle.centerXProperty());
			letter.yProperty().bind(circle.radiusProperty());
			rot = new Rotate();
			rot.pivotXProperty().bind(circle.centerXProperty()); 
			rot.pivotYProperty().bind(circle.centerYProperty());
			rot.setAngle(i*fontSize);
			letter.getTransforms().add(rot);
			pane.getChildren().add(letter);
		}
		
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Text that rotates");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
