package optional;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class RotateText extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// Create a pane to hold the circle
		final int DIM = 200;
		Pane pane = new Pane();

		// Create a circle and set its properties
		Circle circle = new Circle();
		// getWidth() og getHeight() doesn't work before myStage.show() is ran
		circle.setCenterX(DIM / 2);
		circle.setCenterY(DIM / 2);
		circle.setRadius(DIM / 4);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.YELLOWGREEN);
		pane.getChildren().add(circle);

		// Create individual text elements that can be rotated
		String s = "Learning Java FX...";
		Text txt;
		for (int i = 0; i < s.length(); i++) {
			txt = new Text(s.substring(i, i + 1));
			txt.setX(DIM / 2);
			txt.setY(DIM / 4);

			Rotate r = new Rotate();

			// Rotate round z-axis
			r.setPivotX(100);
			r.setPivotY(100);

			// Rotate each character by 15 degrees more than the one before it.
			r.setAngle(15 * i); // Should be calculated using some formula, but meh.

			// Set text properties
			txt.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));

			// Get a collection of object transforms and add rotate transform to it.
			txt.getTransforms().add(r);

			pane.getChildren().add(txt);
		}

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Rotate text");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
