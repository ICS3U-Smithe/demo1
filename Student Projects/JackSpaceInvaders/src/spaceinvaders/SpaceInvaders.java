package spaceinvaders;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

/**
 * This program is a take on the clasic space Invaders game. It consits of
 * aliens, a spaceship trying to shoot the aliens as well as different menus.
 *
 *
 * @author Jack Bird
 */
public class SpaceInvaders extends Application {

    //Creates my varibles
    // makes my aliens an array of 14
    ImageView aliens[] = new ImageView[14];

    ImageView rocket = new ImageView();
    ImageView background = new ImageView();
    ImageView background1 = new ImageView();
    ImageView background2 = new ImageView();
    ImageView background3 = new ImageView();
    Image img1 = new Image("Images/Alien1.png");
    Image img2 = new Image("Images/Rocket.png");
    Image img3 = new Image("Images/start.jpg");
    Image img4 = new Image("Images/spaceMoon.jpg");
    Image img5 = new Image("Images/end.png");
    Image img6 = new Image("Images/Win.jpg");

    Rectangle laserBlocker;
    Rectangle laserBlocker2;
    //makes the shot an array of 5
    Rectangle shot[] = new Rectangle[5];
    Rectangle bullet;
    Button start;
    Button pause;
    Label resume;
    Label spaceInvadersTitle;
    Label scoreLabel;
    Timer timer1;
    TimerTask task1;
    Timeline bulletTimeline;
    int score = 0;
    int nextBullet = 0;
    int deltaX[] = new int[14];
    int deltaY[] = new int[14];

// makes the widths and heights of shot, rocket, and scene
    public static final int ROCKET_WIDTH = 30;
    public static final int ROCKET_HEIGHT = 110;

    public static final int SCENE_WIDTH = 800;
    public static final int SCENE_HEIGHT = 800;

    public static final int BLOCKER_WIDTH = 80;
    public static final int BLOCKER_HEIGHT = 10;

    public static final int SHOT_WIDTH = 5;
    public static final int SHOT_HEIGHT = 20;

    @Override
    public void start(Stage primaryStage) {

        //Creates the rocket
        rocket = new ImageView(img2);
        rocket.setLayoutX(400);
        rocket.setLayoutY(690);

        //Creates a blocker
        laserBlocker = new Rectangle(80, 10, Color.CYAN);
        laserBlocker.setLayoutX(175);
        laserBlocker.setLayoutY(635);

        //Creates The blockers
        laserBlocker2 = new Rectangle(80, 10, Color.CYAN);
        laserBlocker2.setLayoutX(675);
        laserBlocker2.setLayoutY(625);

        //Creates start button
        start = new Button("Start");
        start.setLayoutX(250);
        start.setLayoutY(600);
        start.setPrefWidth(300);
        start.setPrefHeight(150);

        //Creates my pause button
        pause = new Button("Pause");
        pause.setLayoutX(725);
        pause.setLayoutY(30);
        pause.setPrefWidth(50);
        pause.setPrefHeight(25);

        //Creates my resume button
        resume = new Label("To resume the game please close the window ");
        resume.setFont(new Font("Arial", 18));
        resume.setTextFill(Color.LIME);
        resume.setLayoutX(15);
        resume.setLayoutY(200);

        //Creates Title
        spaceInvadersTitle = new Label("Space Invaders");
        spaceInvadersTitle.setFont(new Font("Broadway", 90));
        spaceInvadersTitle.setTextFill(Color.LIME);
        spaceInvadersTitle.setLayoutX(35);
        spaceInvadersTitle.setLayoutY(25);

        //Creates the score label
        scoreLabel = new Label("Score: 0");
        scoreLabel.setFont(new Font("Broadway", 20));
        scoreLabel.setTextFill(Color.LIME);
        scoreLabel.setLayoutX(400);
        scoreLabel.setLayoutY(50);

        //makes my start background
        background.setImage(img3);
        background.setLayoutX(-250);
        background.setLayoutY(-100);

        //makes my scene background
        background1.setImage(img4);
        background1.setLayoutX(-200);
        background1.setLayoutY(-100);

        //Makes my you lose Background
        background2.setImage(img5);
        background2.setLayoutX(175);
        background2.setLayoutY(250);

        //makes my you win Background
        background3.setImage(img6);
        background3.setLayoutX(-100);
        background3.setLayoutY(100);

        //Creates my aliens
        for (int i = 0; i < aliens.length; i++) {
            deltaX[i] = 3;

            int x = i * 50;
            int y = 0;

            aliens[i] = new ImageView(img1);
            aliens[i].setX(x);
            aliens[i].setY(y);
            aliens[i].setLayoutX(75);
            aliens[i].setLayoutY(100);

        }
        //Creates my shot
        for (int i = 0; i < shot.length; i++) {
            shot[i] = new Rectangle(SHOT_WIDTH, SHOT_HEIGHT, Color.GREEN);
        }
        //my game window
        Group root = new Group();
        root.getChildren().add(background1);
        root.getChildren().add(rocket);
        root.getChildren().add(laserBlocker);
        root.getChildren().add(laserBlocker2);
        root.getChildren().add(pause);
        root.getChildren().add(scoreLabel);

        //add the aliens
        for (int i = 0; i < aliens.length; i++) {
            root.getChildren().add(aliens[i]);

        }
        //adds the shot
        for (int i = 0; i < shot.length; i++) {
            root.getChildren().add(shot[i]);
        }

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT, Color.BLACK);

        //Makes start menu popup
        Group root2 = new Group();
        root2.getChildren().add(background);
        root2.getChildren().add(start);
        root2.getChildren().add(spaceInvadersTitle);
        Scene scene2 = new Scene(root2, SCENE_HEIGHT, SCENE_WIDTH, Color.BLACK);
        Stage stage2 = new Stage();
        stage2.setScene(scene2);
        stage2.setTitle("Start");
        stage2.show();

        //Makes my pause menu
        Group root3 = new Group();
        root3.getChildren().add(resume);
        Scene scene3 = new Scene(root3, 400, 500, Color.BLACK);
        Stage stage3 = new Stage();
        stage3.setScene(scene3);
        stage3.setTitle("pause");

        //makes the you lose screen
        Group root4 = new Group();
        root4.getChildren().add(background2);
        Scene scene4 = new Scene(root4, SCENE_HEIGHT, SCENE_WIDTH, Color.BLACK);
        Stage stage4 = new Stage();
        stage4.setScene(scene4);
        stage4.setTitle("You Lose");

        //makes the you win screen
        Group root5 = new Group();
        root5.getChildren().add(background3);
        Scene scene5 = new Scene(root5, SCENE_HEIGHT, SCENE_WIDTH, Color.BLACK);
        Stage stage5 = new Stage();
        stage5.setScene(scene5);
        stage5.setTitle("You Win");

        //key movements left and right for ship
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if (event.getCode() == KeyCode.LEFT) {
                    if (rocket.getLayoutX() > 0) {
                        rocket.setLayoutX(rocket.getLayoutX() - 25);
                    }
                } else if (event.getCode() == KeyCode.RIGHT) {
                    if (rocket.getLayoutX() + rocket.getX() < scene.getWidth()) {
                        rocket.setLayoutX(rocket.getLayoutX() + 25);
                    }
                }
                //Shoots the bullet at the aliens when pressed up
                if (event.getCode() == KeyCode.UP) {

                    shot[nextBullet].setLayoutX(rocket.getLayoutX() + rocket.getX() / 2);
                    shot[nextBullet].setLayoutY(rocket.getLayoutY());

                    nextBullet++;
                    if (nextBullet == shot.length) {
                        nextBullet = 0;
                    }

                    bulletTimeline.play();

                }

            }
        });

        //Makes my widows closed when statrt button is pressed
        start.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage2.close();
                primaryStage.show();

            }
        });

        //Pauses my game when the pause button is pressed
        pause.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage3.show();
                timer1.cancel();

                stage3.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        timer1 = new Timer();
                        task1 = new TimerTask() {

                            @Override
                            public void run() {

                                Platform.runLater(new Runnable() {

                                    @Override
                                    public void run() {
                                        for (int i = 0; i < aliens.length; i++) {

                                            double aliensLeft = aliens[i].getX();
                                            double aliensRight = aliens[i].getX() + img1.getWidth();

                                            //check ball's location against the edges of the window
                                            if (aliensLeft <= -50 || aliensRight >= 700) {

                                                deltaX[i] = -deltaX[i];
                                                //aliens[i].setCenterY(+aliens[i].getCenterY() + 50);
                                                aliens[i].setY(+aliens[i].getY() + 50);
                                            }

                                            //move the ball
                                            //aliens[i].setCenterX(aliens[i].getCenterX() + deltaX[i]);
                                            aliens[i].setX(aliens[i].getX() + deltaX[i]);

                                        }
                                    }
                                });

                            }
                        };
                        timer1.scheduleAtFixedRate(task1, 500, 10);
                    }
                });

            }
        });
        primaryStage.setTitle("Space Invaders");
        primaryStage.setScene(scene);

        //closes the game window on request
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }

        });
        //Closes start menu on request
        stage2.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }

        });
        //Closes Win Screen on request 
        stage5.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }

        });
        //closes you lose menu on command
        stage4.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }

        });

        //Makes my aliens move across the screen
        timer1 = new Timer();

        task1 = new TimerTask() {

            @Override
            public void run() {

                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        for (int i = 0; i < aliens.length; i++) {

                            double aliensLeft = aliens[i].getX();
                            double aliensRight = aliens[i].getX() + img1.getWidth();

                            //checks aliens location against the edges of the window
                            if (aliensLeft <= -50 || aliensRight >= 700) {

                                deltaX[i] = -deltaX[i];

                                aliens[i].setY(+aliens[i].getY() + 50);

                            }

                            //move the alien
                            aliens[i].setX(aliens[i].getX() + deltaX[i]);

                        }
                    }

                });

            }
        };

        //wait for 100ms then execute the run method every 4ms
        //shoots the shots
        timer1.scheduleAtFixedRate(task1, 100, 10);

        bulletTimeline = new Timeline(new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                for (int i = 0; i < shot.length; i++) {
                    shot[i].setLayoutY(shot[i].getLayoutY() - 10);

                    double laserLeft = shot[i].getLayoutX();
                    double laserRight = shot[i].getLayoutX() + SHOT_WIDTH;
                    double laserTop = shot[i].getLayoutY();
                    double laserBottom = shot[i].getLayoutY() + SHOT_HEIGHT;

                    for (int j = 0; j < aliens.length; j++) {

                        double alienLeft = aliens[j].getX() + aliens[j].getLayoutX();
                        double alienRight = aliens[j].getX() + aliens[j].getLayoutX() + img1.getWidth();
                        double alientop = aliens[j].getY() + aliens[j].getLayoutY();
                        double alienBottom = aliens[j].getY() + aliens[j].getLayoutY() + img1.getWidth();

                        double rocketLeft = rocket.getLayoutX();
                        double rocketRight = rocket.getLayoutX() + ROCKET_WIDTH;
                        double rocketTop = rocket.getLayoutY();

                        //check for collision with the ailiens
                        if (alienRight >= laserLeft && alienLeft <= laserRight && alienBottom >= laserTop && alientop <= laserBottom) {

                            if (aliens[j].isVisible()) {
                                aliens[j].setVisible(false);
                                score++;
                                scoreLabel.setText("Score: " + score);
                            }
                        }
                        //Checks aliens for colision with rocket
                        if (alienRight >= rocketLeft && alienLeft <= rocketRight && alienBottom >= rocketTop) {

                            if (aliens[j].isVisible()) {
                                primaryStage.close();
                                stage4.show();

                            }

                        }
                    }
                    //if the score is equal to 14 it will pop up the you win menu
                    //and close the game window
                    if (score == 14) {
                        primaryStage.close();
                        stage5.show();
                    }

                }
            }
        ;

        }));

        //set the timeline to execute indefinitely. 
        bulletTimeline.setCycleCount(Timeline.INDEFINITE);

    }

    //this will stop the program when you exit the window
    @Override
    public void stop() {
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
