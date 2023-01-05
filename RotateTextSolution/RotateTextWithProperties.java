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

public class RotateTextWithProperties extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// Create a pane to hold the circle
		Pane pane = new Pane();

		// Create a circle and set its properties
		Circle circle = new Circle();
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.centerYProperty().bind(pane.heightProperty().divide(2));
		circle.radiusProperty().bind(pane.heightProperty().divide(4));
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.YELLOWGREEN);
		pane.getChildren().add(circle);

		// Create indivual text elements that can be rotated
		String s = "Learning Java FX...";
		Text txt;
		for (int i = 0; i < s.length(); i++) {
			txt = new Text(s.substring(i, i + 1));

			txt.xProperty().bind(pane.widthProperty().divide(2));
			txt.yProperty().bind(pane.heightProperty().divide(4));

			Rotate r = new Rotate();

			// Rotate round z-axis
			r.pivotXProperty().bind(circle.centerXProperty());
			r.pivotYProperty().bind(circle.centerYProperty());

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
		primaryStage.setTitle("Rotate text with properties");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}