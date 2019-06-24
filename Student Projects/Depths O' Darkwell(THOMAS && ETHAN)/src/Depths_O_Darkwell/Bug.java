package Depths_O_Darkwell;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Bug {
private int MoveFrame, AttackFrame;
private Image BugMoveImg = new Image("Bug_Images/BugMove_0.png");
private Image BugAttackImg = new Image("Bug_Images/Bug_0.png");
public ImageView bug = new ImageView(BugMoveImg);
private double angle;
private double DX1, DY1, D1, DX2, DY2, D2;
private int X, Y;
private boolean attacking;
public boolean dead = false;
private int health = 3;
private int Speed = 3;
private Timeline BugAct;
private GameStart game;

 public Bug(int X, int Y, GameStart game){
    this.X = X;
    this.Y = Y;
    this.game = game;
    bug.setY(Y);
    bug.setX(X);
     
    BugAct = new Timeline(new KeyFrame(Duration.millis(84), new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
    //trig range to both players, only looks far the archer if its in 2P mode 
    if(Main.TwoPlayer == true){
    DX1 = game.ArcherImgView.getX() - bug.getX();
    DY1 = game.ArcherImgView.getY() - bug.getY();
    D1 = Math.sqrt(Math.pow(DY1, 2) + Math.pow(DX1, 2));
    }
    
    DX2 = (game.KnightImgView.getX()-50) - bug.getX(); 
    DY2 = (game.KnightImgView.getY()-50) - bug.getY();      
    D2 = Math.sqrt(Math.pow(DY2, 2) + Math.pow(DX2, 2));
    
    
    //if statement that executes code relevant to the closer enemy
    
    //finds closest player.
    if(Main.TwoPlayer == true){
    if(D1 < D2){
    angle = Math.atan2(DY1,DX1);
    bug.setRotate(Math.toDegrees(angle));
    //closes in to 400, and only then shoots
    if(attacking == true || D1 < 400){
    attacking = true;    
    BugAttack(game);    
    }
    else{
    bug.setY(bug.getY() + Speed*Math.sin(angle));
    bug.setX(bug.getX() + Speed*Math.cos(angle));
    }
    }
    
    //move towards second target
    if (D2 < D1){        
    angle = Math.atan2(DY2,DX2);
    bug.setRotate(Math.toDegrees(angle));
    if(attacking == true || D2 < 400){
    attacking = true;    
    BugAttack(game);    
    }
    else{
    bug.setY(bug.getY() + Speed*Math.sin(angle));
    bug.setX(bug.getX() + Speed*Math.cos(angle));   
    }
    }
    }
    
    //One-Player mode Targetting code.
    if(Main.TwoPlayer == false){
    angle = Math.atan2(DY2,DX2);
    bug.setRotate(Math.toDegrees(angle)); 
    if(attacking == true || D2 < 400){
    attacking = true;    
    BugAttack(game);    
    }
    else{
    bug.setY(bug.getY() + Speed*Math.sin(angle));
    bug.setX(bug.getX() + Speed*Math.cos(angle));   
    }
    }
    
    if(!attacking){
    BugMove();    
    }
    
    }
    }));
    BugAct.setCycleCount(Timeline.INDEFINITE);
    BugAct.play();
 }
 public ImageView getImgView(){
 return bug;    
 }
 private void BugMove(){
    if(MoveFrame == 3){
    MoveFrame = 0;
    }
    else{    
    MoveFrame++;
    }
    BugMoveImg = new Image("Bug_Images/BugMove_" + MoveFrame + ".png");
    bug.setImage(BugMoveImg);
 }
 private void BugAttack(GameStart game){
    if(AttackFrame == 8){
    //create a plasma projectile
    PlasmaBall ball = new PlasmaBall(bug.getX(), bug.getY(), bug.getRotate(), game);
    game.root.getChildren().add(ball.getImgView());
    }
    if(AttackFrame == 11){
    AttackFrame = 0;
    attacking = false;
    }    
    BugAttackImg = new Image("Bug_Images/Bug_" + AttackFrame + ".png");
    bug.setImage(BugAttackImg);
 
    AttackFrame++;
 } 
 //takes dmg according to who hits it
 //ie archer takes 3 hits to kill knight takes 1
 public void TakeDamage( int damage){
 health = health - damage;
 if(health <= 0){
 BugAct.stop();
 dead = true;
 game.Score = game.Score + 100;
 game.root.getChildren().remove(bug);
 }
 }
 
}
