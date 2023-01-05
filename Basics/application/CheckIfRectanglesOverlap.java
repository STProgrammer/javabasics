package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import java.util.*;

public class CheckIfRectanglesOverlap extends Application {
	
	static Rectangle r1, r2;
	double x, y, height, width;
	Scanner input = new Scanner(System.in);

	@Override
	public void start(Stage primaryStage) {
		r1 = constructRectangle(1);
		r2 = constructRectangle(2);
		Pane pane = new Pane();
		pane.getChildren().addAll(r1, r2);
		
		if (contains(r1, r2)) {
			pane.getChildren().add(new Text(200, 500, "One rectangle is contained in another"));
		} else if (overlaps(r1, r2)) {
			pane.getChildren().add(new Text(200, 500, "The rectangles do overlap "));
		} else pane.getChildren().add(
				new Text(200, 500, "The rectangles are separate from each other"));
		
		Scene scene = new Scene(pane, 600, 600);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Check if rectangles overlap or not");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**Set values of the Rectangles */
	private Rectangle constructRectangle(int nr) {
		try {
			System.out.println("Sett høyde til rektangel " + nr + ":");
			height = input.nextDouble();
			System.out.println("Sett bredde til rektangel " + nr + ":");
			width = input.nextDouble();
			System.out.println("Sett koordinater (x og y) til rektangel " + nr + ":");
			y = input.nextDouble() - height/2; x = input.nextDouble() - width/2;
		} catch (InputMismatchException e) {System.out.println("Type in a double");}
		Rectangle rec = new Rectangle(x, y, width, height);
		rec.setStyle("-fx-stroke: black; -fx-fill: null");
		return rec;
	}
	
	/** Returns true if r1 contains r2 */
	private static boolean contains(Rectangle r1, Rectangle r2) {
	// Four corner points in r2
	double x1 = r2.getX();
	double y1 = r2.getY();
	double x2 = x1 + r2.getWidth();
	double y2 = y1;
	double x3 = x1;
	double y3 = y1 + r2.getHeight();
	double x4 = x1 + r2.getWidth();
	double y4 = y1 + r2.getHeight();

	return r1.contains(x1, y1) && r1.contains(x2, y2) && r1.contains(x3, y3) && r1.contains(x4, y4);
	}

	/** Returns true if r1 overlaps r2 */
	private static boolean overlaps(Rectangle r1, Rectangle r2) {
	// Four corner points in r2
	double r1xCenter = r1.getX() + r1.getWidth() / 2;
	double r2xCenter = r2.getX() + r2.getWidth() / 2;
	double r1yCenter = r1.getY() + r1.getHeight() / 2;
	double r2yCenter = r2.getY() + r2.getHeight() / 2;

	return Math.abs(r1xCenter - r2xCenter) <= (r1.getWidth() + r2.getWidth()) / 2 &&
	Math.abs(r1yCenter - r2yCenter) <= (r1.getHeight() + r2.getHeight()) / 2;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
