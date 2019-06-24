package Depths_O_Darkwell;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Arrow{
    //
private double X, Y, RadAngle;
private double Speed = 20;
Timeline ArrowMove;
ImageView Arrow;

public Arrow(double Rot, double X, double Y, GameStart game){
 Image a = new Image("Archer_Images/Arrow.png");
 Arrow = new ImageView(a); 
 Arrow.setRotate(Rot);
 RadAngle = Math.toRadians(Rot);
 Arrow.setX(X + 50*Math.cos(RadAngle));
 Arrow.setY(Y + 50*Math.sin(RadAngle));
 
 /*uses a trig equation for the timeline to offset 
 the arrow forward a little
 so it looks like its from the bow*/
  ArrowMove = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
  @Override
  public void handle(ActionEvent event){
   //will check if the arrow is in contact with enemies before it moves   
   CheckHit(game);
   //movement
   Arrow.setY(Arrow.getY() + Speed*Math.sin(RadAngle));
   Arrow.setX(Arrow.getX() + Speed*Math.cos(RadAngle));
  }}));
  ArrowMove.setCycleCount(Timeline.INDEFINITE);
  ArrowMove.play();
 }  
//get image so we can add it to root
public ImageView getImgView(){
return Arrow;
}



//"collision detection"
public void CheckHit(GameStart game){
//the arrow has to check if its hitting an enemy, an array could work for this...
 if (!game.ZombieArray.isEmpty()) {
  for (Zombie z : game.ZombieArray) {
   if(z.dead == false){    
   double DX1 = z.getImgView().getX() - Arrow.getX();
   double DY1 = z.getImgView().getY() - Arrow.getY();
   double D1 = Math.sqrt(Math.pow(DY1, 2) + Math.pow(DX1, 2));
    if(D1 < 50){
    z.TakeDamage(1);
    ArrowMove.stop();
    game.root.getChildren().remove(Arrow);
    }
   }
  }
 }
 
 if (!game.BugArray.isEmpty()) {
  for (Bug z : game.BugArray) {
   if(z.dead == false){    
   double DX1 = z.getImgView().getX() - Arrow.getX();
   double DY1 = z.getImgView().getY() - Arrow.getY();
   double D1 = Math.sqrt(Math.pow(DY1, 2) + Math.pow(DX1, 2));
    if(D1 < 50){
    z.TakeDamage(1);
    ArrowMove.stop();
    game.root.getChildren().remove(Arrow);
    }
   }
  }
 }
} //Check hit ends here

}
