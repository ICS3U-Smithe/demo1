package Depths_O_Darkwell;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class PlasmaBall {
private double X, Y, Rot, RadAngle;
private double Speed = 5;
private Image ball = new Image("Bug_Images/Ball_0.png");
private ImageView pBall = new ImageView(ball);
private int frame;
Timeline pBallMove;
private double DX1, DY1, D1, DX2, DY2, D2;

public PlasmaBall(double X, double Y, double Rot, GameStart game){
this.X = X;
this.Y =Y;
this.Rot = Rot;
RadAngle = Math.toRadians(Rot);

pBall.setX(X);
pBall.setY(Y);
pBall.setRotate(Rot);
//offset
pBall.setY(pBall.getY() + 54*Math.sin(RadAngle));
pBall.setX(pBall.getX() + 54*Math.cos(RadAngle));

  pBallMove = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
  @Override
  public void handle(ActionEvent event){
   //will check if the arrow is in contact with enemies before it moves   
   CheckHit(game);
   //movement   
   pBall.setY(pBall.getY() + Speed*Math.sin(RadAngle));
   pBall.setX(pBall.getX() + Speed*Math.cos(RadAngle));
   if(pBall.getX() > 1000 || pBall.getX() < -100 || pBall.getY() < -100 || pBall.getY() > 1000){
   System.out.println("Removing a ball");
   game.root.getChildren().remove(pBall);
   pBallMove.stop();
   }
   Animate();
  }}));
  pBallMove.setCycleCount(Timeline.INDEFINITE);
  pBallMove.play();    
}

public ImageView getImgView(){
return pBall;
}
public void Animate(){
if(frame ==8){
frame = 0;    
}
ball = new Image("Bug_Images/Ball_" + frame + ".png");
pBall.setImage(ball);
frame++;    
}
//checks hits from either collision with arhcer or knight to remove itself and do dmg
public void CheckHit(GameStart game){
    if(Main.TwoPlayer == true){
    DX1 = game.ArcherImgView.getX() - pBall.getX();
    DY1 = game.ArcherImgView.getY() - pBall.getY();
    D1 = Math.sqrt(Math.pow(DY1, 2) + Math.pow(DX1, 2));
    if(D1 < 50){
    if(game.Ghealth > 0){ 
    game.Ghealth = game.Ghealth - 0.5;
    Image GHearts = new Image("Green Hearts/" + game.Ghealth + "heart.png");
    game.GFullHearts.setImage(GHearts);
    }
    pBallMove.stop();
    game.root.getChildren().remove(pBall);
    }
    }
    
    DX2 = (game.KnightImgView.getX() - 50)- pBall.getX(); 
    DY2 = (game.KnightImgView.getY() - 50) - pBall.getY();      
    D2 = Math.sqrt(Math.pow(DY2, 2) + Math.pow(DX2, 2)); 
    if(D2 < 50){
    if(game.health > 0){    
    game.health = game.health - 0.5;
    Image Hearts = new Image("Red Hearts/" + game.health + "heart.png");
    game.FullHearts.setImage(Hearts);
    }
    pBallMove.stop();
    game.root.getChildren().remove(pBall);
    }
    
}
    
}
