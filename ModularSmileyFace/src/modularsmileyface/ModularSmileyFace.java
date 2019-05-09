package modularsmileyface;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * This class demonstrates how to make code to draw a composite shape
 * modular (reusable)
 * 
 * @author Mr. Smithe
 */
public class ModularSmileyFace extends Application {
    
    //make the root an instance variable so our method has access to it. 
    Group root = new Group();
    
    @Override
    public void start(Stage primaryStage) {
        
        //draw Smiley Face
        drawSmiley(300, 300, 250);
        
        //we can alter the parameters to draw a different sized smiley face. 
        drawSmiley(100, 100, 50);
        drawSmiley(400, 400, 75);
        drawSmiley(400, 100, 100);
        drawSmiley(100, 400, 125);
        
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Smiley Face");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Draws a smiley face centered at (centerX, centerY) with 
     * a radius of radius. 
     * 
     * @param centerX the x-coordinate of the center of the face
     * @param centerY the y-coordinate of the center of the face 
     * @param radius the radius of the face 
     */
    private void drawSmiley(int centerX, int centerY, int radius){
        Circle face = new Circle(centerX, centerY, radius);
        face.setFill(Color.YELLOW);
        face.setStroke(Color.BLACK);
        
        //left eye - we made all of the math proportional to the parameters 
        Circle leftEye = new Circle(centerX - radius/3, centerY - radius/3, radius/10);
        
        //right Eye
        Circle rightEye = new Circle(centerX + radius/3, centerY - radius/3, radius/10);
        
        //mouth
        Arc mouth = new Arc(centerX, centerY + radius/3, radius*2/3, radius/5, 200, 140);
        mouth.setFill(Color.TRANSPARENT);
        mouth.setStroke(Color.BLACK);
        
        root.getChildren().add(face);
        root.getChildren().add(leftEye);
        root.getChildren().add(rightEye);
        root.getChildren().add(mouth);
    }
    
}
