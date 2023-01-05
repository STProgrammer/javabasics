package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;


public class SjakkBrett2 extends Application {
	
	double sideOfSquare = 50;
	Rectangle rec;

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		int ctr = 0; // control variable
		for (double i = 0; i < 8; i++) {
			for (double j = 0; j < 8; j++) {
				ctr++;
				rec = new Rectangle();
				rec.heightProperty().bind(pane.heightProperty().divide(8));
				rec.widthProperty().bind(pane.widthProperty().divide(8));
				rec.xProperty().bind(rec.widthProperty().multiply(i));
				rec.yProperty().bind(rec.heightProperty().multiply(j));
				if (ctr % 2 == 0) {
					rec.setStroke(Color.BLACK);
					rec.setFill(Color.BLACK);
				} else {
					rec.setStroke(Color.WHITE);
					rec.setFill(Color.WHITE);
				}
				pane.getChildren().add(rec);	
			}
			ctr++;
		}
		
		Scene scene = new Scene(pane,8*sideOfSquare,8*sideOfSquare);
		primaryStage.setResizable(true);
		primaryStage.setTitle("Chessboard 2 (Resizable)");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

