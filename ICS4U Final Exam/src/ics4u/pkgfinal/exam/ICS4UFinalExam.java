package ics4u.pkgfinal.exam;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ICS4UFinalExam extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Rectangle r1 = new Rectangle(100, 100, 300, 100);
        r1.setFill(Color.RED);
        
        Rectangle r2 = new Rectangle(150, 50, 200, 100);
        r2.setFill(Color.RED);
        
        Rectangle r3 = new Rectangle(150, 55, 25, 30);
        r3.setFill(Color.AQUAMARINE);
        
        Rectangle r4 = new Rectangle(325, 55, 25, 30);
        r4.setFill(Color.AQUAMARINE);
        
        Circle c1 = new Circle(150, 200, 25);
        c1.setFill(Color.BLACK);
        
        Circle c2 = new Circle(350, 200, 25);
        c2.setFill(Color.BLACK);
        
        Group root = new Group();
        root.getChildren().add(r1);
        root.getChildren().add(r2);
        root.getChildren().add(r3);
        root.getChildren().add(r4);
        root.getChildren().add(c1);
        root.getChildren().add(c2);
        
        Scene scene = new Scene(root, 500, 300);
        
        primaryStage.setTitle("Mystery Drawing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
