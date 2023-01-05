package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.*;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;

public class Pendulum extends Application {
	
	@Override
	public void start(Stage primaryStage) { 
		 PendulumPane pane = new PendulumPane();  // du må lage klassen PendulumPane
		 
		 Scene scene = new Scene(pane, 300, 200);
		 primaryStage.setResizable(false);
		 primaryStage.setTitle("Pendulum"); // Set the stage title
		 primaryStage.setScene(scene); // Place the scene in the stage
		 primaryStage.show(); // Display the stage
		 
		 Timeline animation = new Timeline(new KeyFrame(Duration.millis(100), e -> {pane.next();}));
		 animation.setCycleCount(Timeline.INDEFINITE);
		 animation.setRate(10);
		 animation.play(); // Start animation
		 
		 
		 pane.setOnMouseClicked(e -> {
			 if (animation.getStatus() == Animation.Status.PAUSED) {
				 animation.play();
			 } else animation.pause();
		 });
		 
		 pane.requestFocus();
		 pane.setOnKeyPressed(e -> {
	      if (e.getCode() == KeyCode.UP) {
	    	  animation.setRate(animation.getRate() + 1);
	        } 
	        else if (e.getCode() == KeyCode.DOWN) {
	        animation.setRate(animation.getRate() - 1);
	        }
		 });
		 
	}
		 
	class PendulumPane extends Pane {
		double pendulumRadius = 130;
		double angle = 60;
		double xCeil = 150;
		double yCeil = 25;
		double xBall = xCeil + pendulumRadius * Math.cos(Math.toRadians(angle));
		double yBall = yCeil + pendulumRadius * Math.sin(Math.toRadians(angle));
		boolean swingToLeft = true; //control variable to track if the ball should swing to
		// left or right
		Circle ceil = new Circle(xCeil, yCeil, 3, Color.BLACK);
		Circle ball = new Circle(xBall, yBall, 20, Color.BLACK);
		Line line = new Line(xCeil, yCeil, xBall, yBall);
		
		public PendulumPane() {
			  getChildren().addAll(line, ceil, ball);
			  next();
			}
		
		/** first check where it's swining to, then change the angle */
		public void next() {
			if (angle <= 60) {
				swingToLeft = true;
			}
			if (angle >= 120) {
				swingToLeft = false;
			}
			if (swingToLeft) {
				angle++;
			} else angle--;
			xBall = xCeil + pendulumRadius * Math.cos(Math.toRadians(angle));
			yBall = yCeil + pendulumRadius * Math.sin(Math.toRadians(angle));
			
			ball.setCenterX(xBall); ball.setCenterY(yBall);
			line.setEndX(xBall); line.setEndY(yBall);	
		}
				 
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

		


