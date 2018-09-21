package graphicaldemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * This program draws a beautiful smiley face. 
 * 
 * @author Mr. Smithe
 */
public class GraphicalDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //create a circle object for the face. 
        Circle face = new Circle();
        face.setRadius(250); 
        face.setFill(Color.YELLOW); //fills the shape this color.
        face.setStroke(Color.BLACK); //outlines the shape this color. 
        face.setCenterX(300); //defaults depend on parent structure. 
        face.setCenterY(300);
        
        //create circles for the eyes. 
        //we can set basic values straight in the constructor. 
        //new Circle(centreX, centreY, radius, fillColor);
        Circle leftEye = new Circle(200, 200, 25, Color.BLACK);
        Circle rightEye = new Circle(400, 200, 25, Color.BLACK);
        
        //draw an acr for the mouth. 
        //new Arc(centreX, centreY, xRadius, yRadius, startAngle, deltaAngle);
        Arc smile = new Arc(300, 400, 150, 50, 180, 180);
        smile.setFill(Color.RED);
        smile.setStroke(Color.BLACK);
        
        //for trianlges we have to use a polygon. 
        //new Polygon(x1, y1, x2, y2... xn, yn);
        Polygon nose = new Polygon(300, 300, 325, 325, 275, 325);
        
        //Group is a control structure that lets us handle the layout. 
        Group root = new Group();
        
        //add all of our shapes to the root. 
        root.getChildren().add(face);
        root.getChildren().add(leftEye);
        root.getChildren().add(rightEye);
        root.getChildren().add(smile);
        root.getChildren().add(nose);
        
        //set the scene with a 600x600 window. 
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Smiley Face!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
