package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.Scene;
import javafx.scene.text.*;

public class DistanceBetween2Circles extends Application {
	
	Circle cr1;
	Circle cr2;
	Line line;
	double paneWidth = 300;
	double paneHeight = 250;

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		double x1 = 5+Math.random()*(paneWidth-10);
		double x2 = 5+Math.random()*(paneWidth-10);
		double y1 = 5+Math.random()*(paneHeight-10);
		double y2 = 5+Math.random()*(paneHeight-10);
		
		cr1 = new Circle(x1, y1, 5);
		cr2 = new Circle(x2, y2, 5);
		line = new Line(x1, y1, x2, y2);
		cr1.setStyle("-fx-stroke: black; -fx-fill: blue");
		cr2.setStyle("-fx-stroke: black; -fx-fill: blue");
		line.setStyle("-fx-color: black;");
		Text text = new Text(String.format("Distance is %.0f", 
				getDistance(x1, y1, x2, y2)));
		text.setX((x1 + x2)/2);
		text.setY((y1 + y2)/2);
		pane.getChildren().addAll(cr1, cr2, line, text);
		
		
		Scene scene = new Scene(pane, paneWidth, paneHeight);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Distance Between Two Circles");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static double getDistance(double x1, double y1, double x2, double y2) {
	    return Math.sqrt((x1 - x2) * (x1 -x2) + (y1 - y2) * (y1 - y2));
	}
}
