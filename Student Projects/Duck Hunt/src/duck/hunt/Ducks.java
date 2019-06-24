/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duck.hunt;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 *
 * @author s800225766
 */
public class Ducks {

    public static final int sceneWidth = 1038;
    public static final int sceneHeight = 590;
    public double deltaX, deltaY;
    
    public Random rand = new Random();
    private Group root;
    Timeline flyingTimeline;
    
    public Ducks(int x, int y, Group root) {
        Image DG1 = new Image("DG - 1.png");
        Image DG2 = new Image("DG - 2.png");
        Image DG3 = new Image("DG - 3.png");
        Image DG4 = new Image("DG - 4.png");
        Image DG5 = new Image("DG - 5.png");
        Image DG6 = new Image("DG - 6.png");
        Image DG7 = new Image("DG - 7.png");
        Image DG8 = new Image("DG - 8.png");
        ImageView D1 = new ImageView(DG1);
        D1.setX(x);
        D1.setY(y);

        this.root = root;
        //add duck
        root.getChildren().add(D1);
        
        //D1.toBack();
        //action on mouse click
        D1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //if click is within coordinates duck falls
                
                deltaX = 0;
                deltaY = 5;
                DuckHunt.score = DuckHunt.score + 500;
                DuckHunt.scoreLabel.setText("Score: " + DuckHunt.score);
            }
        });
        

        //randomize each duck direction
        deltaX = rand.nextDouble() * 5;
        deltaY = -rand.nextDouble() * 5;

        flyingTimeline = new Timeline(new KeyFrame(Duration.millis(12), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //move the duck in whatever direction it's heading. 

                D1.setX(D1.getX() + deltaX);
                D1.setY(D1.getY() + deltaY);

                //if the duck is on the left or right wall
                if (D1.getX() + D1.getImage().getWidth() >= sceneWidth || D1.getX() <= 0) {
                    deltaX = -deltaX; //bounce in the x direction
                }
                //if the duck is on the top or bottom wall
                if (D1.getY() + D1.getImage().getHeight() >= sceneHeight || D1.getY() <= 0) {
                    if (deltaX == 0) {
                        deltaY = 0;
                        flyingTimeline.stop();
                        Ducks duck = new Ducks(500, 515, root);
                        DuckHunt.fore.toFront();
                    } else {
                        deltaY = -deltaY;
                    }
                }
            }
        }));
        

        //make the code run indefinately. 
        flyingTimeline.setCycleCount(Timeline.INDEFINITE);
        flyingTimeline.play();

    }
}
