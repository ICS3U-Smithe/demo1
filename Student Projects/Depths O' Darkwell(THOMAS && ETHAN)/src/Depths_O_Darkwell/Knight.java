package Depths_O_Darkwell;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Knight {

    public static Image startI = new Image("p1right.png");
    public static ImageView Knight = new ImageView(startI);
    
    //private variables to allow spawn of player to be determined/changed
    private GameStart EM;
    private double X, Y;
    
    //ALL OF THESE COMMENTS WERE MOVED TO MAIN CLASS TO SUPPORT 2 KEY EVENTS
    //these are all interpolator variables. Kind of understand but honestly not really

    //delta's are for smoooth movement
     //moving in. 
    //adjustments are for the difference in sprite sizes to be not affecting the animaiton as we know it breaks cuz images are 
    //different sizes also this is only way for reliable hitboxes

    //makes it so u can't spam attack
 
    //now this is how bad i am at coding i garuntee there is a better way but i made this work so were going with it
    
 
    //so the animation doesn't get looped(allows animation to finish before we go again
    
    //this is the sprite sheet in it's entirety
    
    Timeline KnightTimeline;

    //determiens player coords
    public Knight(double X, double Y, GameStart EM) {
        this.X = X;
        this.Y = Y;

        this.EM = EM;
        Knight.setX(X);
        Knight.setY(Y);


        //this is the smoothe movement timeline that takles the on key presed and released code into action so 
        //it is accurate
        //also detects when player reaches coords to change scenes
        KnightTimeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Knight.setX(Knight.getX() + EM.deltaX);
                Knight.setY(Knight.getY() + EM.deltaY);
                //this is messy i know that. you know that. i know there is a better way but i...
                if (!EM.animating) {
                    if (EM.Left == true) {
                        EM.deltaX = -3;
                        Knight.setRotate(180);
                        GameStart.FaceRight = false;
                        GameStart.FaceUp = false;
                       GameStart. FaceDown = false;
                       GameStart. FaceLeft = true;
                    }
                    if (EM.Right == true) {
                        EM.deltaX = 3;
                        Knight.setRotate(0);
                       GameStart. FaceRight = true;
                       GameStart. FaceUp = false;
                       GameStart. FaceDown = false;
                       GameStart. FaceLeft = false;
                    }
                    if (EM.Up == true) {
                        EM.deltaY = -3;
                        Knight.setRotate(270);
                      GameStart.  FaceRight = false;
                       GameStart. FaceUp = true;
                      GameStart.  FaceDown = false;
                       GameStart. FaceLeft = false;
                    }
                    if (EM.Down == true) {
                        EM.deltaY = 3;
                        Knight.setRotate(90);
                     GameStart.   FaceRight = false;
                      GameStart.  FaceUp = false;
                      GameStart.  FaceDown = true;
                       GameStart. FaceLeft = false;
                    }
                }
            }
        }));

        KnightTimeline.setCycleCount(Timeline.INDEFINITE);
        KnightTimeline.play();
        //on key released so you can move diagonally with only facing one side

    }

    //this as to be here. same reason for the main class. idk it fixes the code
    public ImageView getImgView() {
        return Knight;
    }
//explains itself
     void Die() {
     KnightTimeline.stop();
     EM.root.getChildren().remove(Knight); 
     }
}
