package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;


public class SjakkBrett extends Application {
	
	double sideOfSquare = 50;
	Rectangle rec;

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Scene scene = new Scene(pane,8*sideOfSquare,8*sideOfSquare);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Chessboard");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		int ctr = 0; // control variable
		for (double i = 0; i < 8*sideOfSquare; i += sideOfSquare) {
			for (double j = 0; j < 8*sideOfSquare; j += sideOfSquare) {
				ctr++;
				rec = new Rectangle();
				rec.setHeight(sideOfSquare);
				rec.setWidth(sideOfSquare);
				rec.setX(i);
				rec.setY(j);
				if (ctr % 2 == 0) {
					rec.setStroke(Color.BLACK);
					rec.setFill(Color.BLACK);
				} else {
					rec.setStroke(Color.WHITE);
					rec.setFill(Color.WHITE);
				}
				pane.getChildren().add(rec);	
			}
			ctr ++;
		}
		

	}

	public static void main(String[] args) {
		launch(args);
	}
}
