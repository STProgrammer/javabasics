package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;

public class CirclesAndSquares extends Application {
	
	boolean isCircleAlive = false; 
	// IsCircleAlive is a control variable to track which is "current", which
	// is clicked last time or which figure is on the focus.
	int numberOfClicks = 0;
	Rectangle square;
	Circle circle;
	Pane center;
	/* Text fields and their labes that'll be shown on the top */
	TextField squareField = new TextField();
    TextField circleField = new TextField();
    Label squareLabel = new Label("Square coordinates:  ");
    Label circleLabel = new Label("Circle coordinates:  ");
    
    /* coordinate values */
    double circleX;
    double circleY;
    double squareX;
    double squareY;
    
	
	/** Start */
	@Override
	public void start(Stage primaryStage) {
		
		/** set up the pane and boxes*/
		BorderPane pane = new BorderPane();
		HBox top = new HBox();
		top.setAlignment(Pos.CENTER);
		HBox bottom = new HBox();
		bottom.autosize();
		bottom.setAlignment(Pos.CENTER);
		VBox left = new VBox();
		left.autosize();
		left.setAlignment(Pos.CENTER);
		VBox right = new VBox();
		right.autosize();
		right.setAlignment(Pos.CENTER);
		center = new Pane();
		center.autosize();
		center.setStyle("-fx-border-color: black");
	    pane.setLeft(left);
	    pane.setRight(right);
	    pane.setTop(top);
	    pane.setBottom(bottom);
	    pane.setCenter(center);
	    
	
		/** set and place the buttons */
		Button btnRed = new Button("Red");
		Button btnGrn = new Button("Green");
		left.getChildren().addAll(btnRed, btnGrn);
		Button btnRot = new Button("Rotate");
		right.getChildren().add(btnRot);
		Button btnSqr = new Button("Square");
		Button btnCrcl = new Button("Circle");
		bottom.getChildren().addAll(btnSqr, btnCrcl);

	    /**TextBox on top*/
	    squareField.setEditable(false);
	    circleField.setEditable(false);
	    squareLabel.setVisible(false);
	    circleLabel.setVisible(false);
	    top.getChildren().addAll(squareLabel, squareField, circleLabel, circleField);
	    
	    
	    /** Draw circle and square */
	    square = new Rectangle();
	    circle = new Circle();
	    
	    /** Button to draw circle */
	    btnCrcl.setOnAction(e -> {
	    	if (center.getChildren().contains(circle))
	    		center.getChildren().remove(circle);
		    center.getChildren().add(circle); 
		    circle.setRadius(50);
		    circle.setStroke(Color.BLACK);
		    circle.setFill(Color.WHITE);
		    circle.setRotate(0);
		    circle.setCenterX(circle.getRadius()+1 + Math.random()*(center.getWidth() - 2*circle.getRadius()-2));
		    circle.setCenterY(circle.getRadius()+1 + Math.random()*(center.getHeight() - 2*circle.getRadius()-2));
		    isCircleAlive = true;
		    circleLabel.setVisible(true); // control variable to track which is "current"
		    circleX = circle.getCenterX(); 
		    circleY = circle.getCenterY();
		    circleField.setText(String.format("(%.0f, %.0f)", circleX, circleY));
	    } );
	    
	    /** Button to draw square */
	    btnSqr.setOnAction(e -> {
	    	if (center.getChildren().contains(square))
	    		center.getChildren().remove(square);
		    center.getChildren().add(square); 
	    	square.setHeight(100);
		    square.setWidth(100);
		    square.setStroke(Color.BLACK);
		    square.setFill(Color.WHITE);
		    square.setRotate(0);
		    square.setX(1+Math.random()*(center.getWidth() - square.getWidth()-2));
		    square.setY(1+Math.random()*(center.getHeight() - square.getHeight()-2));
		    isCircleAlive = false; // control variable to track which is "current"
		    squareLabel.setVisible(true);
		    squareX = square.getX(); squareY = square.getY();
		    squareField.setText(String.format("(%.0f, %.0f)", squareX, squareY));
	    } );
		
		/** Clicking on the shapes with mouse */
	    circle.setOnMouseClicked(e -> {
	    	isCircleAlive = true;
            });
	    
	    square.setOnMouseClicked(e -> {
	    	isCircleAlive = false;
            });
		
	    /** Actions when clicking the buttons "Red" and "Green" */
	    btnRed.setOnAction(e -> {
	    	if (isCircleAlive) {
	    		circle.setFill(Color.RED);
	    	} else square.setFill(Color.RED);
	    } );
	    
	    btnGrn.setOnAction(e -> {
	    	if (isCircleAlive) {
	    		circle.setFill(Color.GREEN);
	    	} else square.setFill(Color.GREEN);
	    } );
	    
	    /** Rotation */
	    btnRot.setOnAction(e -> {
	    	square.setRotate(45.0 * ++numberOfClicks);
	    } );
	    
	    /** Scene start */	    
		Scene scene = new Scene(pane,600,600);
		primaryStage.setTitle("Draw square and circle");
		primaryStage.setScene(scene);
		primaryStage.show();
	    

	}
	
	public static void main(String[] args) {
      launch(args);
	}
}