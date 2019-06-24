
package Depths_O_Darkwell;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Archer{
// initialize the images
Image Archer0 = new Image("Archer_Images/Archer_0.png");
Image Archer1 = new Image("Archer_Images/Archer_1.png");
Image Archer2 = new Image("Archer_Images/Archer_2.png");
Image Archer3 = new Image("Archer_Images/Archer_3.png");
Image Archer4 = new Image("Archer_Images/Archer_4.png");
Image Archer5 = new Image("Archer_Images/Archer_5.png");
Image Archer6 = new Image("Archer_Images/Archer_6.png");
//initialize all the variables for the archer's behaviour
public int shootFrame;
//make the archers physical imageview
public ImageView Archer = new ImageView(Archer0);
Timeline ArcherTurn,ArcherMove,ArcherAct;
GameStart game;

public Archer(double X, double Y, GameStart Game){
    Archer.setX(X);
    Archer.setY(Y);
    this.game = game;
   
        ArcherTurn = new Timeline(new KeyFrame(Duration.millis(120), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              //  Double Rot = Archer.getRotate();

                //basic cardinal direction rotations
                if (GameStart.S == true && GameStart.E == true) {Archer.setRotate(45);}
                else if (GameStart.S == true && GameStart.W == true) {Archer.setRotate(135);}
                else if (GameStart.N == true && GameStart.W == true) {Archer.setRotate(225);}
                else if (GameStart.N == true && GameStart.E == true) {Archer.setRotate(315);}
                
                //NE, SW, etc... 45 degree angles
                else if (GameStart.E == true) {Archer.setRotate(0);}
                else if (GameStart.S == true) {Archer.setRotate(90);}
                else if (GameStart.W == true) {Archer.setRotate(180);}
                else if (GameStart.N == true) {Archer.setRotate(270);}
            }
        }));
        ArcherTurn.setCycleCount(Timeline.INDEFINITE);
        
        ArcherMove = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             //get a temporary rotation again....   
             Double Rot = Archer.getRotate();
             //if any key is pressed down, use trig to move forwards
             if(GameStart.N == true || GameStart.E == true || GameStart.W == true || GameStart.S == true){
             double RadAngle = Math.toRadians(Rot);
             Archer.setY(Archer.getY() + Math.sin(RadAngle));
             Archer.setX(Archer.getX() + Math.cos(RadAngle));    
             }   
        }
        }));
         ArcherMove.setCycleCount(Timeline.INDEFINITE);
        
        
        
        ArcherAct = new Timeline(new KeyFrame(Duration.millis(84), new EventHandler<ActionEvent>() {
           @Override
            public void handle(ActionEvent event) {
            if(game.Ghealth == 0){
            Die();    
            }    
            //if the player pressed the button to shoot.....    
            if(GameStart.Shooting == true){
                double tempRot;
                //switch case to run through the animation frames
                switch (shootFrame){
                    case 0: 
                    tempRot = Archer.getRotate();
                    Archer.setImage(Archer1);
                    Archer.setRotate(tempRot);
                    break;
                    
                    case 1:
                    tempRot = Archer.getRotate();
                    Archer.setImage(Archer2);
                    Archer.setRotate(tempRot);    
                    break;
                    
                    case 2:
                    tempRot = Archer.getRotate();
                    Archer.setImage(Archer3);
                    Archer.setRotate(tempRot);    
                    break;
                     
                    case 3:
                    tempRot = Archer.getRotate();
                    Archer.setImage(Archer4);
                    Archer.setRotate(tempRot);    
                    break;
                          
                    case 4:
                    tempRot = Archer.getRotate();
                    Archer.setImage(Archer5);
                    //creates a new arrow when it dissapears from the animation
                    Arrow a = new Arrow(Archer.getRotate(), Archer.getX(), Archer.getY(), Game);
                    Game.root.getChildren().add(a.getImgView());
                    Archer.setRotate(tempRot);    
                    break;
                          
                    case 5:
                    tempRot = Archer.getRotate();
                    Archer.setImage(Archer6);
                    Archer.setRotate(tempRot);    
                    break;
                       
                    case 6:
                    tempRot = Archer.getRotate();
                    Archer.setImage(Archer0);
                    Archer.setRotate(tempRot);
                    //resets the cases
                    GameStart.Shooting = false;
                    shootFrame = 0;
                    break;
                }        
               shootFrame++;
               }     
             }
        }));
        ArcherAct.setCycleCount(Timeline.INDEFINITE);
        
      
        ArcherTurn.play();
        ArcherAct.play();
        ArcherMove.play();
}

//returns the image so we can add it in the Main Game class
public ImageView getImgView(){
return Archer;    
}
public double getArcherY(){
return Archer.getY();    
}
public double getArcherX(){
return Archer.getX();    
}

 void Die() {
 ArcherTurn.stop();
 ArcherAct.stop();
 ArcherMove.stop();
 game.root.getChildren().remove(Archer); 
 }

}

