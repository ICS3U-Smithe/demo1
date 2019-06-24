package Depths_O_Darkwell;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Zombie {

    //original zombie image
    Image z1 = new Image("Zombie/z0.png");
    public ImageView Zombie = new ImageView(z1);
    //this the the integer to count the aniamtion frames
    private int zframe = 0;
    //access to pain class and sets coords
    private GameStart EM;
    private double X, Y, tempROT;
//necessary
    public boolean dead = false;
    private int health = 3;

    Timeline trackingTimeline;
    Timeline ZattackTimeline;

    public Zombie(double X, double Y, GameStart EM) {

        this.X = X;
        this.Y = Y;
        this.EM = EM;
        Zombie.setX(X);
        Zombie.setY(Y);
        //tracks the player and forces to move towards only by up, down, left right( no diagonal tracking(makes animation easier))
        //selection beween 1 and 2player mode. looks bad i know
        trackingTimeline = new Timeline(new KeyFrame(Duration.millis(30), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Main.TwoPlayer == true) {
                    if (Selection(EM.ArcherImgView, Zombie) > Selection(EM.KnightImgView, Zombie)) {
                        if (EM.KnightImgView.getX() > Zombie.getX()) {
                            Zombie.setX(Zombie.getX() + 1);
                            Zombie.setRotate(0);
                        } else if (EM.KnightImgView.getX() < Zombie.getX()) {
                            Zombie.setRotate(180);
                            Zombie.setX(Zombie.getX() - 1);
                        } else if (EM.KnightImgView.getY() > Zombie.getY()) {
                            Zombie.setY(Zombie.getY() + 1);
                            Zombie.setRotate(90);
                        } else if (EM.KnightImgView.getY() < Zombie.getY()) {
                            Zombie.setY(Zombie.getY() - 1);
                            Zombie.setRotate(270);
                        }
                    } else {
                        if (EM.ArcherImgView.getX() > Zombie.getX()) {
                            Zombie.setX(Zombie.getX() + 1);
                            Zombie.setRotate(0);
                        } else if (EM.ArcherImgView.getX() < Zombie.getX()) {
                            Zombie.setRotate(180);
                            Zombie.setX(Zombie.getX() - 1);
                        } else if (EM.ArcherImgView.getY() > Zombie.getY()) {
                            Zombie.setY(Zombie.getY() + 1);
                            Zombie.setRotate(90);
                        } else if (EM.ArcherImgView.getY() < Zombie.getY()) {
                            Zombie.setY(Zombie.getY() - 1);
                            Zombie.setRotate(270);
                        }
                    }
                } else {
                    if (EM.KnightImgView.getX() > Zombie.getX()) {
                        Zombie.setX(Zombie.getX() + 1);
                        Zombie.setRotate(0);
                    } else if (EM.KnightImgView.getX() < Zombie.getX()) {
                        Zombie.setRotate(180);
                        Zombie.setX(Zombie.getX() - 1);
                    } else if (EM.KnightImgView.getY() > Zombie.getY()) {
                        Zombie.setY(Zombie.getY() + 1);
                        Zombie.setRotate(90);
                    } else if (EM.KnightImgView.getY() < Zombie.getY()) {
                        Zombie.setY(Zombie.getY() - 1);
                        Zombie.setRotate(270);
                    }

                }
            }
        }));

        //make the code run indefinately. 
        trackingTimeline.setCycleCount(Timeline.INDEFINITE);
        trackingTimeline.play();
        //if comes into contact with player attack using fancy switch cases

        ZattackTimeline = new Timeline(new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //clever way to get image files without having to declar at top of class #BetterThanThomas 
                if (Main.TwoPlayer == true) {
                if (attackRange(EM.KnightImgView, Zombie) || attackRange(EM.ArcherImgView, Zombie)) {
                   AttackAnimation();   }
                }
                else if (attackRange(EM.KnightImgView, Zombie)){ AttackAnimation(); }        
                } 
            }
        
        ));

        //make the code run indefinately. 
        ZattackTimeline.setCycleCount(Timeline.INDEFINITE);
        ZattackTimeline.play();
    }//if intersects used for attack animattion and dmg stuff

    public boolean attackRange(ImageView a, ImageView b) {

        return a.getBoundsInParent().intersects(b.getBoundsInParent());
    }

    //if within certain range tells zomvie to move towards plater
    public boolean InAggroRange(ImageView a, ImageView b) {
        
        double dist = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
       
        return dist < 500;

    }
    //selected btween player and archer
    public double Selection(ImageView a, ImageView b) {
       
        double dist = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        return dist;
    }

//this is here for a reason . ah i remember it allows for zombie to change itself. i think??
    public ImageView getImgView() {
        return Zombie;
    }
//explains itself
    public void TakeDamage(int damage) {
        health = health - damage;
        if (health <= 0) {
            destroy();
        }
    }
//actually removes from game and tries to stop timeline attempts to remove "ghost" zombie hitboxes was made
    void destroy() {
        if(dead == false){
        trackingTimeline.stop();
        ZattackTimeline.stop();
        EM.Score = EM.Score + 100;
        dead = true;
        EM.ZombieArray.remove(Zombie);
        EM.root.getChildren().remove(Zombie);
        }
    }
//switch case to change image for zombie to make attack animation
    private void AttackAnimation(){
         Image Zframe = new Image("Zombie/z" + zframe + ".png");
    
                            zframe++;
                    switch (zframe) {
                        case 0:
                            tempROT = Zombie.getRotate();
                            Zombie.setImage(Zframe);
                            Zombie.setRotate(tempROT);
                            break;

                        case 1:
                            tempROT = Zombie.getRotate();
                            Zombie.setImage(Zframe);
                            Zombie.setRotate(tempROT);
                            break;

                        case 2:
                            tempROT = Zombie.getRotate();
                            Zombie.setImage(Zframe);
                            Zombie.setRotate(tempROT);
                            break;
                        case 3:
                            tempROT = Zombie.getRotate();
                            Zombie.setImage(Zframe);
                            Zombie.setRotate(tempROT);
                            break;

                        case 4:
                            tempROT = Zombie.getRotate();
                            Zombie.setImage(Zframe);
                            Zombie.setRotate(tempROT);
                            break;

                        case 5:
                            //this is the health deduction code that acts on the frame of animation that would techinally be the dmg
                            //detects 2 player to make sure u can kill archer and change their hearts
                            tempROT = Zombie.getRotate();
                            Zombie.setImage(Zframe);
                            Zombie.setRotate(tempROT);
                             if (Main.TwoPlayer == true) {
                                 if (attackRange(EM.KnightImgView, Zombie)) {
                                if (GameStart.health != 0) {
                                    GameStart.health = GameStart.health - 0.5;
                                    Image Hearts = new Image("Red Hearts/" + GameStart.health + "heart.png");
                                    EM.FullHearts.setImage(Hearts);
                                }
                                if (attackRange(EM.ArcherImgView, Zombie)) {
                                if (GameStart.Ghealth != 0) {
                                    GameStart.Ghealth = GameStart.Ghealth - 0.5;
                                    Image GHearts = new Image("Green Hearts/" + GameStart.Ghealth + "heart.png");
                                    EM.FullHearts.setImage(GHearts);
                                }
                             }
                                 }
                             }
                             else {
                                 if (attackRange(EM.KnightImgView, Zombie)) {
                                if (GameStart.health != 0) {
                                    GameStart.health = GameStart.health - 0.5;
                                    Image Hearts = new Image("Red Hearts/" + GameStart.health + "heart.png");
                                    EM.FullHearts.setImage(Hearts);
                                }
                            }
                             }
                             
                            break;

                        case 6:
                            tempROT = Zombie.getRotate();
                            Zombie.setImage(Zframe);
                            Zombie.setRotate(tempROT);
                            break;
                        case 7:
                            tempROT = Zombie.getRotate();
                            Zombie.setImage(Zframe);
                            Zombie.setRotate(tempROT);
                            zframe = 0;
                            break;

                    }
                    
                }
    
        }
    



