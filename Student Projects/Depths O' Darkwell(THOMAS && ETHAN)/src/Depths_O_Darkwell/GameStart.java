package Depths_O_Darkwell;

import static Depths_O_Darkwell.Knight.Knight;
import static Depths_O_Darkwell.Knight.startI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GameStart extends Application {

    //static image view for hearts b/c zombie needs to access to count dmg
    //Images for diffrent backgrounds and their imgView's
    Image background1 = new Image("woodfloor.png");
    Image background2 = new Image("sewer.png");
    ImageView wood = new ImageView(background1);
    ImageView sewer = new ImageView(background2);
    Image gameOver = new Image("GameOver.png");
    ImageView GameOverScreen = new ImageView(gameOver);
    //static variables for the thigns that we only need 1 of. such as a the player/hero and health bar

    static Image Hearts = new Image("Red Hearts/3.0heart.png");
    public ImageView FullHearts = new ImageView(Hearts);
    static Image GHearts = new Image("Green Hearts/3.0heart.png");
    public ImageView GFullHearts = new ImageView(GHearts);

    public static double health = 3;
    public static double Ghealth = 3;
    ArrayList<Zombie> ZombieArray = new ArrayList<>();
    ArrayList<Bug> BugArray = new ArrayList<>();
    public static HBox layout = new HBox(10);
    public int Score = 0;
    private Text label;

    public MediaPlayer gameTheme = new MediaPlayer(new Media(new File("src/Music/Baldurs Gate OST - Sword Against Darkness.mp3").toURI().toString()));
    public Group root = new Group();
    public Scene scene = new Scene(root, 1000, 1000);
    public GameStart game = this;
    public ImageView ArcherImgView, KnightImgView;
    public Random randGen = new Random();
    public int SpawnSpeed, SpawnLimit;
    public Archer A1;
    public Knight P1;
    int EnemySpawnX;
    int EnemySpawnY;
    int EnemyCount;
    int TimeBonus;
    boolean GameOver = false;

    public static boolean FaceUp, FaceDown, FaceLeft, FaceRight;
    public static boolean attack = true;
    //these are interpolating variables
    private static final int COLUMNS = 3;
    private static final int COUNT = 9;
    private static final int OFFSET_X = 18;
    private static final int OFFSET_Y = 25;
    private static final int WIDTH = 160;
    private static final int HEIGHT = 160;

    private static double AdjustX = 0;
    private static double AdjustY = 0;

    public boolean animating = false;

    public boolean Up, Down, Left, Right;

    public Image attackI = new Image("Knight 1.0 clone.png");

    public double deltaX = 0; //keep track of what direction we're
    public double deltaY = 0;

    public static boolean N, E, S, W, Shooting;
    
    public int highScore;
//sets up the scene according to the mode
    @Override
    public void start(Stage primaryStage) {
        scene.setFill(BLACK);

        wood.setTranslateX(20);
        wood.setTranslateY(20);
        wood.toBack();
        root.getChildren().add(wood);

        FullHearts.setTranslateX(20);
        FullHearts.setTranslateY(20);
        root.getChildren().add(FullHearts);

        if (Main.TwoPlayer == true) {
            GFullHearts.setTranslateX(670);
            GFullHearts.setTranslateY(20);
            root.getChildren().add(GFullHearts);
        }

        label = new Text();
        label.setFont(Font.font(50));
        label.setStroke(BLACK);
        label.setFill(WHITE);

        layout.getChildren().add(label);
        layout.setTranslateX(380);
        layout.setTranslateY(20);
        root.getChildren().add(layout);

        //this is where we add the things that are modular to allow for multiple's of enemies
        Knight P1 = new Knight(450, 450, this);
        KnightImgView = P1.getImgView();
        root.getChildren().add(KnightImgView);

        if (Main.TwoPlayer == true) {
            Archer A1 = new Archer(500.0, 500.0, game);
            ArcherImgView = A1.getImgView();
            root.getChildren().add(ArcherImgView);
        }
        //this is spawn speed pretty neat as game will get exponentially harder
        SpawnSpeed = 1000;
        SpawnLimit = 100;
        if (Main.HardMode == true) {
            System.out.println("HardMode Detected, Difficulty Increased");
            SpawnSpeed = SpawnSpeed - 500;
            SpawnLimit = SpawnLimit - 50;
        }
        if (Main.TwoPlayer == true) {
            System.out.println("2Player Detected, Difficulty Increased");
            SpawnSpeed = SpawnSpeed - 100;
            SpawnLimit = SpawnLimit - 20;
        }
//timline for such spawner
        Timeline EnemySpawner = new Timeline(new KeyFrame(Duration.millis(SpawnSpeed), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Main.TwoPlayer== true){
                if (health == 0 && Ghealth == 0) {
                    gameOver();
                }
            }else{
                    if (health == 0) {
                    gameOver();
                }
                }            
                    
                int EnemySpawn = randGen.nextInt(100);
                //ESQ == Enemy Spawn Quadrant
                int ESQ = randGen.nextInt(4);
                //top wall
                if (ESQ == 0) {
                    EnemySpawnX = randGen.nextInt(1100) - 100;
                    EnemySpawnY = -100;
                } //Bottom wall
                else if (ESQ == 1) {
                    EnemySpawnX = randGen.nextInt(1100) - 100;
                    EnemySpawnY = 1000;
                } //Right wall
                else if (ESQ == 2) {
                    EnemySpawnX = 1000;
                    EnemySpawnY = randGen.nextInt(1000) - 100;
                } //Left wall
                else if (ESQ == 3) {
                    EnemySpawnX = -100;
                    EnemySpawnY = randGen.nextInt(1000) - 100;
                }

                if (EnemySpawn < 5) {
                    //spawn a bug, needs to send the GameStart 
                    System.out.println("Spawning a bug");
                    //use an arraylist to make infinite spawns??????
                    Bug E1 = new Bug(EnemySpawnX, EnemySpawnY, game);
                    game.root.getChildren().add(E1.getImgView());
                    BugArray.add(E1);
                } else if (EnemySpawn > 5 && EnemySpawn < 20) {
                    Zombie Z1 = new Zombie(EnemySpawnX, EnemySpawnY, game);
                    game.root.getChildren().add(Z1.getImgView());
                    ZombieArray.add(Z1);
                }
                //speed up the spawning cycle, 10 times/second is the speed limit
                if (SpawnSpeed > SpawnLimit) {
                    SpawnSpeed--;
                    TimeBonus++;
                    label.setText("Score: " + (Score + TimeBonus));
                }
            }
        }));
        EnemySpawner.setCycleCount(Timeline.INDEFINITE);
        EnemySpawner.play();

        gameTheme.setCycleCount(MediaPlayer.INDEFINITE);
        gameTheme.setVolume(Main.volume / 100);
        gameTheme.play();

        primaryStage.setTitle("Depths_O_Darkwell");
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            //this is on key pressed code which works for all directions. includes attack on space bar
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.NUMPAD0 && Shooting == false) {
                    System.out.println("Shooting");
                    Shooting = true;
                }
                //compass direction movement
                if (event.getCode() == KeyCode.UP) {
                    N = true;
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    E = true;
                }
                if (event.getCode() == KeyCode.DOWN) {
                    S = true;
                }
                if (event.getCode() == KeyCode.LEFT) {
                    W = true;
                }
                //if the user pressed the up arrow or w, move up 
                if (event.getCode() == KeyCode.W) {
                    Up = true;
                } //if the user pressed the down arrow or s, move down 
                else if (event.getCode() == KeyCode.S) {
                    Down = true;
                } //if the user pressed the left arrow or a, move left 
                else if (event.getCode() == KeyCode.A) {
                    Left = true;
                } //if the user pressed the right arrow or d, move right 
                else if (event.getCode() == KeyCode.D) {
                    Right = true;
                }
                //this is the entire adjustment and animation code for attacking. i dont know if i need both attack and 
                //animating as variables but this works so.  Adjustments are a pain but realistic(ish) hitboxes are nice
                if (event.getCode() == KeyCode.Q) {
                    if (attack == true) {

                        if (!animating) {

                            //add a hitbpoint to the specific zombie. if its zero removes
                            animating = true;
                            Knight.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
                            Knight.setImage(attackI);

                            if (FaceRight == true) {

                                Knight.setX(Knight.getX() - 32);
                                Knight.setY(Knight.getY() - 5);
                                AdjustX = -32;
                                AdjustY = -5;
                            }
                            if (FaceLeft == true) {
                                Knight.setX(Knight.getX() - 53);
                                Knight.setY(Knight.getY() - 75);
                                AdjustX = -53;
                                AdjustY = -75;
                            }
                            if (FaceUp == true) {
                                Knight.setX(Knight.getX() - 7.5);
                                Knight.setY(Knight.getY() - 50.5);
                                AdjustX = -7.5;
                                AdjustY = -50.5;

                            }
                            if (FaceDown == true) {
                                Knight.setX(Knight.getX() - 77.5);
                                Knight.setY(Knight.getY() - 29.5);
                                AdjustX = -77.5;
                                AdjustY = -29.5;
                            }
                            //this is the interpolating part.  No clue what else to comment here
                            final Animation animation = new SpriteAnimation(
                                    Knight,
                                    Duration.millis(450),
                                    COUNT, COLUMNS,
                                    OFFSET_X, OFFSET_Y,
                                    WIDTH, HEIGHT
                            );
                            animation.setCycleCount(1);

                            animation.play();

                            animation.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                //this on finished allows for the bounce back to the original image at the end of animation and to 
                                //reset viewport so its normal hitbox
                                public void handle(ActionEvent event) {
                                    if (!ZombieArray.isEmpty()) {
                                        for (Zombie z : ZombieArray) {
                                            if (AttackRange(Knight, z.Zombie)) {
                                                z.destroy();
                                            }
                                        }
                                    }
                                    if (!BugArray.isEmpty()) {
                                        for (Bug b : BugArray) {
                                            if (AttackRange(Knight, b.bug)) {
                                                b.TakeDamage(3);
                                            }
                                        }
                                    }
                                    Knight.setImage(startI);
                                    Knight.setViewport(new Rectangle2D(0, 0, startI.getWidth(), startI.getHeight()));
                                    Knight.setX(Knight.getX() + (-1 * AdjustX));
                                    Knight.setY(Knight.getY() + (-1 * AdjustY));
                                    AdjustX = 0;
                                    AdjustY = 0;
                                    animating = false;

                                }
                            });
                            //so u dont spam
                            attack = false;

                        }
                    }
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            //on released to make move only 2 direction
            @Override
            public void handle(KeyEvent event) {

                if (event.getCode() == KeyCode.UP) {
                    N = false;
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    E = false;
                }
                if (event.getCode() == KeyCode.DOWN) {
                    S = false;
                }
                if (event.getCode() == KeyCode.LEFT) {
                    W = false;
                }
                //if the user pressed the up arrow or w, move up 
                if (event.getCode() == KeyCode.W) {
                    Up = false;
                    deltaY = 0;

                } //if the user pressed the down arrow or s, move down 
                else if (event.getCode() == KeyCode.S) {
                    Down = false;
                    deltaY = 0;

                } //if the user pressed the left arrow or a, move left 
                else if (event.getCode() == KeyCode.A) {
                    Left = false;
                    deltaX = 0;

                } //if the user pressed the right arrow or d, move right 
                else if (event.getCode() == KeyCode.D) {
                    Right = false;
                    deltaX = 0;

                }
                if (event.getCode() == KeyCode.Q) {
                    attack = true;

                }
            }
        });
    }
//public arrays to call from other classes
    public ArrayList getZombieArray() {
        return ZombieArray;
    }

    public ArrayList getBugArray() {
        return BugArray;
    }
//overrides the current score file and writes the score just achieved
    public void writeScore() throws java.io.IOException {
        BufferedWriter input = new BufferedWriter(new FileWriter("HighScore.txt", false));
        input.append("" + (Score+TimeBonus));
        input.close();
    }
//reads the current file and if achieved score is higher overwrites the file
    public void readScore() throws java.io.IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader("HighScore.txt"));
        String line = reader.readLine();
        while (line != null) // read the score file line by line
        {
            try {
                int score = Integer.parseInt(line.trim());
                // parse each line as an int
                
                if (score < (Score+TimeBonus)) // and keep track of the largest
                {
                   writeScore();
                }
            } catch (NumberFormatException e1) {
                // ignore invalid scores
                //System.err.println("ignoring invalid score: " + line);
            }
            line = reader.readLine();
        }
        reader.close();
    }
//game over tries to remove stuff but it looks nice
    public void gameOver() {
        root.getChildren().remove(KnightImgView);
        root.getChildren().remove(wood);
        root.getChildren().remove(layout);
        root.getChildren().remove(ArcherImgView);

        GameOverScreen.setTranslateX(260);
        GameOverScreen.setTranslateY(160);
        root.getChildren().add(GameOverScreen);

        Label label2 = new Label("You Score Was: " + (Score + TimeBonus));
        label2.setFont(Font.font(50));
        label2.setTextFill(WHITE);
        //remove any remaining zombies and bugs
        if (!ZombieArray.isEmpty()) {
            for (Zombie z : ZombieArray) {
                root.getChildren().remove(z.getImgView());
            }
        }
        if (!BugArray.isEmpty()) {
            for (Bug b : BugArray) {
                root.getChildren().remove(b.getImgView());
            }
        }
        try {
            readScore();
        } catch (IOException ex) {
            Logger.getLogger(Zombie.class.getName()).log(Level.SEVERE, null, ex);
        }

        HBox finalscore = new HBox(10);
        finalscore.setTranslateX(260);
        finalscore.setTranslateY(700);
        finalscore.getChildren().add(label2);
        root.getChildren().add(finalscore);
        
    }
//attack range is to allow knight to hit back without getting hit
    public boolean AttackRange(ImageView a, ImageView b) {
        double dist = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        return dist < 90;
    }
}
