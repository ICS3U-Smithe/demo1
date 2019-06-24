/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author ukule
 */
public class FinalProject extends Application {
    /*
    
    
    WELCOME TO ASTEROIDS V1.0!
    BELOW, YOU WILL FIND AN EXPLANATION TO HOW THIS GAME WORKS!
    
    
    */
    //Width and height of the actual game
    public static final int Scene_Width = 700;
    public static final int Scene_Height = 450;
    //The many variables that will be used
    int deltaX = 0;
    int deltaY = 0;
    int shipAngle;
    int numAsteroids = 5;
    int asteroidradius = 25;
    int score = 0;
    int lives = 3;
    int currentbullet = 0;
    int invunerabletime = 0;
    int xpos = 250;
    int currentscore;
    int level = 1;
    int asteroidsinvis = 0;
    String previousscore;
    double ypos = 15;
    double[] deltaA = new double[numAsteroids];
    double[] deltaB = new double[numAsteroids];
    Circle[] asteroids = new Circle[numAsteroids];
    Rectangle[] bullet = new Rectangle[5];
    String highscores;
    Random rand = new Random();
    boolean invunerable = true;
    //The music that will be introduced
    MediaPlayer menumusic = new MediaPlayer(new Media(new File("src/menumusic.mp3").toURI().toString()));
    MediaPlayer gamemusic = new MediaPlayer(new Media(new File("src/gamemusic.mp3").toURI().toString()));
    MediaPlayer gun = new MediaPlayer(new Media(new File("src/gun.mp3").toURI().toString()));
    
    
    
    @Override
    public void start(Stage primaryStage) {
        //Each music will play indefinitely, which means playing in a loop.
        menumusic.setCycleCount(MediaPlayer.INDEFINITE);
        menumusic.setVolume(0.8);
        gamemusic.setCycleCount(MediaPlayer.INDEFINITE);
        gamemusic.setVolume(0.3);
        //Create an image
        Image asteroidimg = new Image("img/asteroid.png");
        Image shipimg = new Image("img/ship.png");
        Image spaceimg = new Image("img/space.jpg");
        Image logoimg = new Image("img/logo.png");
        Image space2img = new Image("img/space2.jpg");
        Image space3img = new Image("img/space3.jpg");
        //Create an image pattern, which can be used to fill in shapes
        ImagePattern asteroid = new ImagePattern(asteroidimg);
        ImagePattern shipp = new ImagePattern(shipimg);
        ImageView space = new ImageView(spaceimg);
        ImageView logo = new ImageView(logoimg);
        ImageView space2 = new ImageView(space2img);
        ImageView space3 = new ImageView(space3img);
        //Creating the ship, using a rectangle hitbox
        Rectangle ship = new Rectangle(50,50);
        ship.setFill(shipp);
        //Creating a ship and an asteroid for demonstration purposes
        Rectangle ship2 = new Rectangle(50,50);
        ship2.setX(50);
        ship2.setY(90);
        ship2.setFill(shipp);
        Circle asteroid2 = new Circle(75,215,asteroidradius);
        asteroid2.setFill(asteroid);
        //Setting the ship's starting coordinates and rotation
        ship.setX(Scene_Width/2);
        ship.setY(Scene_Height/2);
        ship.setRotate(90);
        //Creating the score, lives, leve, gameover, final score, thanks, howto, and invunerable text gui
        Text scoretext = new Text("Score: " + score);
        scoretext.setX(285);
        scoretext.setY(490);
        scoretext.setFont(new Font(30));
        scoretext.setFill(Color.WHITE);
        
        Text leveltext = new Text("Level: " + level);
        leveltext.setX(100);
        leveltext.setY(490);
        leveltext.setFont(new Font(25));
        leveltext.setFill(Color.WHITE);
        
        Text livestext = new Text("Lives: " + lives);
        livestext.setX(0);
        livestext.setY(490);
        livestext.setFont(new Font(25));
        livestext.setFill(Color.WHITE);
        
        Text invunerablestext = new Text();
        invunerablestext.setX(500);
        invunerablestext.setY(490);
        invunerablestext.setFont(new Font(20));
        invunerablestext.setFill(Color.WHITE);
        
        Text gameover = new Text("GAME OVER");
        gameover.setX(150);
        gameover.setY(150);
        gameover.setFont(new Font(75));
        gameover.setFill(Color.WHITE);
        
        Text finalscore = new Text("FINAL SCORE: " + score);
        finalscore.setX(100);
        finalscore.setY(450);
        finalscore.setFont(new Font(75));
        finalscore.setFill(Color.WHITE);

        Text thanks = new Text("Thank you for playing. Please enter your name below.");
        thanks.setX(125);
        thanks.setY(200);
        thanks.setFont(new Font(20));
        thanks.setFill(Color.WHITE);
        
        Text shiphow = new Text("You are the captain of this ship! Use WASD or\nUP,DOWN,LEFT,RIGHT arrow keys to control the ship.\nPress K to use your gun to shoot!");
        shiphow.setX(125);
        shiphow.setY(100);
        shiphow.setFont(new Font(18));
        shiphow.setFill(Color.WHITE);
        
        Text asteroidhow = new Text("Careful! These asteroids can damage you! Thankfully, you \ngo invunerable after a collision between you and an asteroid occurs.\nUse your gun to destroy these asteroids!");
        asteroidhow.setX(125);
        asteroidhow.setY(200);
        asteroidhow.setFont(new Font(18));
        asteroidhow.setFill(Color.WHITE);
        
        TextField thanksfield = new TextField();
        thanksfield.setPrefWidth(170);
        thanksfield.setLayoutX(265);
        thanksfield.setLayoutY(250);
        
        space.setPreserveRatio(true);
        space.setFitHeight(Scene_Height);
        
        //Creating the several buttons that will be in use
        Button btn = new Button();
        btn.setText("Start");
        btn.setMinSize(50, 25);
        btn.setLayoutX(325);
        btn.setLayoutY(300);
        
        Button btn2 = new Button();
        btn2.setText("High Score");
        btn2.setMinSize(75, 25);
        btn2.setLayoutX(311);
        btn2.setLayoutY(340);
        
        Button btn3 = new Button();
        btn3.setText("Back");
        btn3.setMinSize(75, 25);
        btn3.setLayoutX(25);
        btn3.setLayoutY(450);
        
        Button btn3a = new Button();
        btn3a.setText("Back");
        btn3a.setMinSize(75, 25);
        btn3a.setLayoutX(25);
        btn3a.setLayoutY(450);
        
        Button btn4 = new Button();
        btn4.setText("Pause");
        btn4.setMinSize(75, 25);
        btn4.setLayoutX(412);
        btn4.setLayoutY(465);
        
        Button btn5 = new Button();
        btn5.setText("Submit");
        btn5.setMinSize(75, 25);
        btn5.setLayoutX(313);
        btn5.setLayoutY(340);
        
        Button btn6 = new Button();
        btn6.setText("How to Play");
        btn6.setMinSize(100, 25);
        btn6.setLayoutX(297);
        btn6.setLayoutY(385);
        
        space2.setFitWidth(700);
        space2.setFitHeight(500);
        
        space3.setFitWidth(1600);
        space3.setFitHeight(900);
        space3.setX(-450);
        space3.setY(-225);
        
        logo.setX(50);
        logo.setFitWidth(600);
        logo.setFitHeight(240);
        //Creating a new group for each scene
        Group root = new Group();
        root.getChildren().add(space);
        root.getChildren().add(ship);
        root.getChildren().add(scoretext);
        root.getChildren().add(leveltext);
        root.getChildren().add(livestext);
        root.getChildren().add(invunerablestext);
        root.getChildren().add(btn4);
        
        Group root1 = new Group();
        root1.getChildren().add(space2);
        root1.getChildren().add(btn);
        root1.getChildren().add(btn2);
        root1.getChildren().add(btn6);
        root1.getChildren().add(logo);
        
        Group root2 = new Group();
        root2.getChildren().add(space3);
        root2.getChildren().add(btn3);
        
        Group root3 = new Group();
        root3.getChildren().add(thanks);
        root3.getChildren().add(thanksfield);
        root3.getChildren().add(btn5);
        root3.getChildren().add(finalscore);
        root3.getChildren().add(gameover);
        
        Group root4 = new Group();
        root4.getChildren().add(asteroid2);
        root4.getChildren().add(ship2);
        root4.getChildren().add(btn3a);
        root4.getChildren().add(asteroidhow);
        root4.getChildren().add(shiphow);
        
        //Creating the new scene, adding an extra 50 pixels to the height, so the text gui does
        //not interfere with the gameplay
        Scene start = new Scene(root1, Scene_Width, Scene_Height + 50);
        Scene scene = new Scene(root, Scene_Width, Scene_Height + 50);
        Scene scores = new Scene(root2, Scene_Width, Scene_Height + 50);
        Scene end = new Scene(root3, Scene_Width, Scene_Height + 50);
        Scene howto = new Scene(root4, Scene_Width, Scene_Height + 50);
        
        scene.setFill(Color.BLACK);
        start.setFill(Color.BLACK);
        scores.setFill(Color.BLACK);
        end.setFill(Color.BLACK);
        howto.setFill(Color.BLACK);
        
        primaryStage.setTitle("Welcome, to Asteroids V 1.0!");
        primaryStage.setScene(start);
        
        menumusic.play();
        for(int i = 0; i < asteroids.length; i++){
            
            //Randomize the starting coordinates of each asteroid
            int x = rand.nextInt(Scene_Width - 2 * asteroidradius) + asteroidradius;
            int y = rand.nextInt(Scene_Height - 2 * asteroidradius) + asteroidradius;
            
            asteroids[i] = new Circle(x,y,asteroidradius);
            asteroids[i].setFill(asteroid);
            asteroids[i].setOpacity(1);
            //Randomize each balls direction
            deltaA[i] = rand.nextDouble()*5;
            deltaB[i] = rand.nextDouble()*5;
            
            root.getChildren().add(asteroids[i]);
        }
        //A new timeline for the asteroids
        Timeline bouncingTimeline = new Timeline (new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                
                //Move the ball in whatever direction it is heading towards
                for(int i = 0; i < asteroids.length; i++){
                    
                    asteroids[i].setCenterX(asteroids[i].getCenterX() + deltaA[i]);
                    asteroids[i].setCenterY(asteroids[i].getCenterY() + deltaB[i]);
                    
                    //If the asteroid is on the left or right wall
                    if(asteroids[i].getCenterX() + asteroids[i].getRadius() >= Scene_Width || asteroids[i].getCenterX() - asteroids[i].getRadius() <=0)
                    deltaA[i] = -deltaA[i];
                    //If asteroid is on top or bottom wall
                    if(asteroids[i].getCenterY() + asteroids[i].getRadius() >= Scene_Height || asteroids[i].getCenterY() - asteroids[i].getRadius() <=0)
                    deltaB[i] = -deltaB[i];
                    
                    //Check if this asteroid has collided with any other asteroid
                    
                        for(int j = i + 1;j < asteroids.length;j++)
                        {
                            
                        if(hasCollided(asteroids[i], asteroids[j]) && asteroids[i].getOpacity() == 1 && asteroids[j].getOpacity() == 1)
                        {
                            //If collided, will reverse the direction both ateroids were currently going
                            deltaA[i] = -deltaA[i];
                            deltaB[i] = -deltaB[i];
                            deltaA[j] = -deltaA[j];
                            deltaB[j] = -deltaB[j];
                        }
                        
                    }
                    //When all 5 asteroid are invisible, reset their positions, become invunerable, increase level by 1, and show the asteroids again
                    if(asteroidsinvis == 5){
                        asteroidsinvis = 0;
                        level = level + 1;
                        invunerable = true;
                        invunerabletime = 3;
                        for(int z = 0; z < asteroids.length; z++){
                            int x = rand.nextInt(Scene_Width - 2 * asteroidradius) + asteroidradius;
                            int y = rand.nextInt(Scene_Height - 2 * asteroidradius) + asteroidradius;
                            asteroids[z].setOpacity(1);
                            asteroids[z].setCenterX(x);
                            asteroids[z].setCenterY(y);
                        }
                    } 
                        
                    if(ShiphasCollided(ship, asteroids[i]) && invunerable == false && asteroids[i].getOpacity() == 1)
                    {
                    //When ship collides with asteroid, invunlerable will be true
                    invunerable = true;
                    invunerabletime = 3;
                    lives = lives - 1;
                        if(lives == 0)
                        {
                            finalscore.setText("FINAL SCORE: " + score);
                            
                            primaryStage.setTitle("Asteroids V 1.0: GAME OVER");
                            primaryStage.setScene(end);
                        }
                    }
                    //When the score is 50, that will mean level 10 has been beaten
                    if(score == 50)
                        { 
                            invunerabletime = 999;
                            finalscore.setText("FINAL SCORE: " + score);
                            gameover.setText("WINNER!");
                            gameover.setX(200);
                            gameover.setY(135);
                            
                            primaryStage.setTitle("Asteroids V 1.0: GAME OVER");
                            primaryStage.setScene(end);
                        }
                    
            }
            
        }
        
    }));
    //Playing the timeline for an indefinite amount of time
    bouncingTimeline.setCycleCount(Timeline.INDEFINITE);
    
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() 
        {
            
            @Override
            public void handle(KeyEvent event) 
            {
                //If the up,down,left, or right key is pressed, set the deltaX or Y to +-1
                if(btn4.getText().equals("Pause")){
                if(event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W)
                {
                    ship.setRotate(0);
                    deltaY = -1;
                }
                if(event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S)
                {
                    ship.setRotate(180);
                    deltaY = 1;
                }
                if(event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A)
                {
                    ship.setRotate(-90);
                    deltaX = -1;
                }
                if(event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D)
                {
                    ship.setRotate(90);
                    deltaX = 1;
                }
                
                if(event.getCode() == KeyCode.K)
                {
                    //When spacebar is hit, creates new bullet, that bullet will have the same rotation as the ship, and will spawn
                    //at the same location as the ship
                    bullet[currentbullet] = new Rectangle(2,6);    
                    
                    bullet[currentbullet].setFill(Color.YELLOW);
                    bullet[currentbullet].setRotate(ship.getRotate());
                    bullet[currentbullet].setX(ship.getX() + (ship.getWidth()/2));
                    bullet[currentbullet].setY(ship.getY() + (ship.getHeight()/2));
                    
                    root.getChildren().add(bullet[currentbullet]); 
                    //Currentbullet goes up by 1
                    currentbullet = currentbullet + 1;
                    //When the currentbullet reaches 4, subtract 4, as to reset the array counter
                    if (currentbullet == 4){
                    currentbullet = currentbullet - 4;
                    }
                }
                }
            }
        });
        
        Timeline shipTimeline = new Timeline(new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                //When the ship collides with any wall, set the ship's position back
                if(ship.getY() <= -1)
                {
                    ship.setY(0);
                }
                if(ship.getY() >= 401)
                {
                    ship.setY(400);
                }
                if(ship.getX() <= -1)
                {
                    ship.setX(0);
                }
                if(ship.getX() >= 651)
                {
                    ship.setX(650);
                }
                //Because this is in a timeline, depending on what the delta x or y values are, the ship will move
                //base on that
                ship.setX(ship.getX() + deltaX);
                ship.setY(ship.getY() + deltaY);
            }
            
        }));
        
        shipTimeline.setCycleCount(Timeline.INDEFINITE);
        
        
        Timeline bulletTimeline = new Timeline(new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>()
        {
            
            @Override
            public void handle(ActionEvent event)
            {
                //When the bullet exists and it has a set rotaion, it will move indefinitely based on that rotation
                for(int z = 0; z < bullet.length; z++)
                {
                    if(bullet[z] !=null && bullet[z].getRotate() == 180)
                    {
                       bullet[z].setX(bullet[z].getX());
                       bullet[z].setY(bullet[z].getY() + 1);
                    }
                    if(bullet[z] !=null && bullet[z].getRotate() == 0)
                    {
                       bullet[z].setX(bullet[z].getX());
                       bullet[z].setY(bullet[z].getY() - 1);
                    }
                    if(bullet[z] !=null && bullet[z].getRotate() == 90)
                    {
                       bullet[z].setX(bullet[z].getX() + 1);
                       bullet[z].setY(bullet[z].getY());
                    }
                    if(bullet[z] !=null && bullet[z].getRotate() == -90)
                    {
                       bullet[z].setX(bullet[z].getX() - 1);
                       bullet[z].setY(bullet[z].getY());
                    }
                    if(bullet[z] !=null && bullet[z].getY() >= Scene_Height)
                    {
                        bullet[z].setVisible(false);
                    }
                    //If bullet exists and the bullet collides with an asteroid, set the opacity of the bullet and asteroid to 0, and add 1 to the score
                    for(int i = 0; i < bullet.length; i++)
                    {
                        for(int x = 0; x < asteroids.length; x++)
                        {
                            if(bullet[i] != null && ShiphasCollided(bullet[i], asteroids[x]) && asteroids[x].getOpacity() == 1 && bullet[i].getOpacity() == 1)
                            {
                                bullet[i].setOpacity(0);
                                asteroids[x].setOpacity(0);
                                score = score + 1;
                                asteroidsinvis = asteroidsinvis + 1;
                            }
                        }
                    }
                }
                //Updates the text gui every 5 ms
                scoretext.setText("Score: " + score);
                livestext.setText("Lives: " + lives);
                leveltext.setText("Level: " + level);
                invunerablestext.setText("Invunerability Time: " + invunerabletime);
            }
            
        }));
        
        bulletTimeline.setCycleCount(Timeline.INDEFINITE);
        
     
        //When key is released, we stop moving
        scene.setOnKeyReleased(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent event) {
                //When the key is released, set the delta x or y values to 0
                if(event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W)
                {
                    deltaY = 0; 
                }
                if(event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S)
                {
                    deltaY = 0;
                }
                if(event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A)
                {
                    deltaX = 0;
                }
                if(event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D)
                {
                    deltaX = 0;
                }
            
        }
        
        });
        
        Timeline invunerableTimeline = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                //Because timeline is on a 1 second cooldown, it will run once every second. Therefore, when invunerable
                //time is greater than 0, the countdown will start
                if(invunerabletime > 0 )
                    invunerabletime--;
                //If the invunerable time is =, then invunerable is false
                else
                    invunerable = false;
                
            }
            
        }));
                
        invunerableTimeline.setCycleCount(Timeline.INDEFINITE);
        //Have each button do their supposed tasks
        btn3a.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //Switch the primaryStage
                primaryStage.setTitle("Asteroids V 1.0");
                primaryStage.setScene(start);  
            }
        });
        
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Asteroids V 1.0: How to Play");
                primaryStage.setScene(howto);  
            }
        });
        
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //When the player reaches the end screen, the will be promt to enter their name and afterwards, click this button.
                //Getting the data they wrote, and converting it into a string, while trimming all spaces
                 String name = new String(thanksfield.getText());
                 name.trim();
                  try {
                    //Creating a new reader and writer for the player file and score file
                    BufferedReader r = new BufferedReader(new FileReader("Scores.txt"));
                    BufferedReader pr = new BufferedReader(new FileReader("Players.txt"));
                    String ab = r.readLine();
                    String ac = pr.readLine();
                    currentscore = Integer.parseInt(ab);
                    BufferedWriter w = new BufferedWriter(new FileWriter("Scores.txt"));
                    BufferedWriter pw = new BufferedWriter(new FileWriter("Players.txt"));
                    
                    String numbertostring = Integer.toString(score);
                    //If the player beats the current high score
                    if(score > currentscore){
                    w.append(numbertostring);
                    pw.append(name);
                    w.close();
                    pw.close();
                    }
                    //If the player does not beat the current high score, rewrite the high score
                    //We rewrite the high score because the bufferedwriter will overwrite the file.
                    if(score < currentscore)
                    w.append(ab);
                    pw.append(ac);
                    w.close();
                    pw.close();
                    } catch (IOException ex) {
                        System.err.println("Error writing to file");
                    } catch (NumberFormatException er){
                        
                    }
                  primaryStage.close();
            }
        });
        
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(btn4.getText().equals("Pause"))
                {
                //When the player clicks this button and the label is 'paused', then stop all timelines
                btn4.setText("Resume");
                primaryStage.setTitle("Asteroids V 1.0: PAUSED");
                invunerableTimeline.stop();
                bulletTimeline.stop();
                shipTimeline.stop();
                bouncingTimeline.stop();
                gamemusic.pause();
                }
                
                else if(btn4.getText().equals("Resume"))
                {
                //When the player clicks this button and the label is 'Resume', then play all timelines
                btn4.setText("Pause");
                primaryStage.setTitle("Asteroids V 1.0");
                invunerableTimeline.play();
                bulletTimeline.play();
                shipTimeline.play();
                bouncingTimeline.play();
                gamemusic.play();
                }
                
            }
        });
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Asteroids V 1.0");
                primaryStage.setScene(start);  
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Asteroids V 1.0 High Score");
                primaryStage.setScene(scores);
                //When the player selects the 'High Score' button, it will show the user the highest score achieved
                try {
                    BufferedReader r = new BufferedReader(new FileReader("Scores.txt"));
                    BufferedReader pr = new BufferedReader(new FileReader("Players.txt"));
                        highscores = r.readLine();
                        
                        String currentname = pr.readLine();
                        
                        Label l = new Label();
                        if(r.readLine() == null){
                            l.setText("Name: " + "Score: " );
                        }
                        if(currentname != null)
                        l.setText("Name: " + currentname + "\n" + "Score: " + highscores);
                        l.setTextFill(Color.WHITE);
                        l.setFont(new Font(45));
                        l.setLayoutX(xpos - 50);
                        l.setLayoutY(ypos + 150);

                        root2.getChildren().add(l);
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
                } catch(IOException ex){
                    System.out.println("Error reading this file.");
                }
            }
        });
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Asteroids V 1.0");
                primaryStage.setScene(scene);
                menumusic.stop();
                gamemusic.play();
                invunerabletime = 3;
                invunerableTimeline.play();
                bulletTimeline.play();
                shipTimeline.play();
                bouncingTimeline.play();
                
            }
        });
        
        primaryStage.show();
    }
    
    boolean ShiphasCollided(Rectangle a, Circle b)
    {
        
        //Get the left, right, up, and down of both shapes
        double aLeft = a.getX();
        double aRight = a.getX() + a.getWidth();
        double aTop = a.getY();
        double aBottom = a.getY() + a.getHeight();
        
        double bLeft = b.getCenterX() - b.getRadius();
        double bRight = b.getCenterX() + b.getRadius();
        double bTop = b.getCenterY() - b.getRadius();
        double bBottom = b.getCenterY() + b.getRadius();
        
        //Check for overlap in all four directions
        if(aRight >= bLeft && aLeft <= bRight && aBottom >= bTop && aTop <= bBottom)
            return true;
        else
            return false;
        
    }
    
    boolean hasCollided(Circle a, Circle b)
    {
        
        //Calculate distance between the centers
        double dist = Math.sqrt(Math.pow(a.getCenterX() - b.getCenterX(), 2) + Math.pow(a.getCenterY() - b.getCenterY(), 2));
        double rads = a.getRadius() + b.getRadius();
        
        //If the distance between the centers is less than the 2 radii, they have collided
        return dist < rads;
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
