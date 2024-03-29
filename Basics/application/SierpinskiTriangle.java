package application;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.Stage;

public class SierpinskiTriangle extends Application {
	
	Pane pane;
	Point2D point1, point2, point3;
	int nrOfOrder;

	@Override
	public void start(Stage primaryStage) {
		/**Set up the panes, text fields and buttons*/
		pane = new Pane();
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(10, 10, 10, 10));
		borderPane.setCenter(pane);
		
		pane.setPadding(new Insets(10, 10, 10, 10));
		TextField input = new TextField();
		input.setPadding(new Insets(5, 5, 5, 5));
		Label label = new Label("Enter order: ");
		label.setPadding(new Insets(10, 10, 10, 10));

		/** Put everything together */
		HBox bottom = new HBox(10);
		bottom.setPadding(new Insets(5, 5, 5, 5));
		bottom.setAlignment(Pos.CENTER);
		bottom.getChildren().addAll(label, input);
		borderPane.setBottom(bottom);
		
		/** Get started */
		Scene scene = new Scene(borderPane, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.setResizable(true);
		primaryStage.setTitle("Sierpinski Triangle");
		primaryStage.show();

		input.setOnAction(a -> {			
			nrOfOrder = Integer.parseInt(input.getText());
			paint(nrOfOrder);
		});
		
		scene.widthProperty().addListener(o -> {paint(nrOfOrder);});
		scene.heightProperty().addListener(o -> {paint(nrOfOrder);});
		
	}
	
	//Simple function to get started with painting triangles
	//calling the recursive function
	public void paint(int order) {
		pane.getChildren().clear();
		point1 = new Point2D(pane.getWidth() / 2, 20);
		point2 = new Point2D(pane.getWidth()-20, pane.getHeight()-100);
		point3 = new Point2D(20, pane.getHeight()-100);
		setTriangles(order, point1, point2, point3);
	}
	
	//Recursive function paintnigTriangles
	public void setTriangles(int order, Point2D point1, 
			Point2D point2, Point2D point3) {

		if (order == 0)
			drawTriangle(point1, point2, point3);
		
		else {
			//Triangle at the upper corner
			setTriangles(order-1, point1.midpoint(point1),
					point1.midpoint(point2),
					point1.midpoint(point3));
			//Triangle at the right corner
			setTriangles(order-1, point2.midpoint(point1),
					point2.midpoint(point2),
					point2.midpoint(point3));
			//Triangle at the left corner
			setTriangles(order-1, point3.midpoint(point1),
					point3.midpoint(point2),
					point3.midpoint(point3));
		}

	}
	
	
	public void drawTriangle(Point2D point1, Point2D point2, Point2D point3) {
		
		Polygon triangle = new Polygon(
	            point1.getX(), point1.getY(),
	            point2.getX(), point2.getY(),
	            point3.getX(), point3.getY()
	            );
		
		triangle.setFill(Color.RED);
		triangle.setStroke(Color.BLACK);
		pane.getChildren().add(triangle);
	} 
	
	public static void main(String[] args) {
		launch(args);
	}
}
