/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duck.hunt;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Random;
import javafx.scene.control.Label;

/**
 *
 * @author s800225766
 */
public class DuckHunt extends Application {
    
    
    Group root = new Group();

    static Label scoreLabel;
    static int score;
    
    static ImageView fore;
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        
        //background
    Image backdrop = new Image("background.png");
    Image foreground = new Image("foreground.png");
    fore = new ImageView(foreground); 
    ImageView backView = new ImageView(backdrop);
    root.getChildren().add(backView);
    
    scoreLabel = new Label("Score: 0");
    root.getChildren().add(scoreLabel);
    
        Scene scene = new Scene(root, 1038, 768);
        primaryStage.setTitle("Duck Hunt");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        //create duck
        Ducks duck = new Ducks(500, 515, root); 
        
        Dog dog = new Dog(500,400, root);
        
        //add foreground
        root.getChildren().add(fore);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
