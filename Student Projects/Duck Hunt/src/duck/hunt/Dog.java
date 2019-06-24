/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duck.hunt;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author s800225766
 */
public class Dog {
    
    public double deltaX, deltaY;
    public double X, Y;
    Timeline riseTimeline;
    
    public Dog(double x, double y, Group root) {
        
        Image Dog1 = new Image("Dog - duck.png");
        ImageView Dog = new ImageView(Dog1);
        Dog.setX(x);
        Dog.setY(y);
        
        X = Dog.getX();
        Y = Dog.getY();
        riseTimeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            while (X > 300){
                
            }
            }
    }));
}
}
