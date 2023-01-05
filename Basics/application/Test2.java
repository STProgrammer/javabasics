package application;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.*;
import javafx.stage.Stage;
 
public class Test2 extends Application {
 
  @Override
  public void start(Stage primaryStage) throws Exception {
      BorderPane root = new BorderPane();
      Point2D point1 = new Point2D(0.0, 10.0);
      Point2D point2 = point1.midpoint(5.0, 5.0);
      
      System.out.println(point1.getX());
      System.out.println(point1.getY());
      System.out.println(point2.getX());
      System.out.println(point2.getY());
      
 
     
  }
 
  public static void main(String[] args) {
      launch(args);
  }
 
}