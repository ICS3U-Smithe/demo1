/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit2testquestion;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 *
 * @author smitandr7141
 */
public class Unit2TestQuestion extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Circle c1 = new Circle(150, 150, 100);
        Circle c2 = new Circle(450, 150, 100);
        Circle c3 = new Circle(300, 300, 200);
        Circle c4 = new Circle(250, 300, 15);
        Circle c5 = new Circle(350, 300, 15);
        
        Ellipse e1 = new Ellipse(250, 250, 50, 100);
        e1.setFill(Color.WHITE);
        
        Ellipse e2 = new Ellipse(350, 250, 50, 100);
        e2.setFill(Color.WHITE);
        
        Ellipse e3 = new Ellipse(300, 340, 20, 15);
        e3.setFill(Color.RED);
        
        Arc a1 = new Arc(300, 300, 195, 195, 190, 160);
        a1.setFill(Color.WHITE);
        a1.setType(ArcType.ROUND);
        
        Arc a2 = new Arc(300, 300, 180, 150, 220, 100);
        a2.setFill(Color.TRANSPARENT);
        a2.setStroke(Color.BLACK);
        
        Group root = new Group();
        root.getChildren().add(c1);
        root.getChildren().add(c2);
        root.getChildren().add(c3);
        root.getChildren().add(e1);
        root.getChildren().add(e2);
        root.getChildren().add(a1);
        root.getChildren().add(c4);
        root.getChildren().add(c5);
        root.getChildren().add(e3);
        root.getChildren().add(a2);
        
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Mystery Drawing!");
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
