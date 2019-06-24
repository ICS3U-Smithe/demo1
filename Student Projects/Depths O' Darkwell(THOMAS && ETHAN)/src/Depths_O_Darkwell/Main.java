package Depths_O_Darkwell;

import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import Depths_O_Darkwell.GameStart;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
TO-DO LIST:
2.Bug where the bugs move to the bottom left when not aggrod, might be because of the code w/ Knight
3.spawn enemies w/ offset so theyre on the map
*/

public class Main extends Application {
public String Line1, Line2, Line3;
public static boolean TwoPlayer = false;
public static boolean HardMode = false;
//CHANGE THIS VARIABLE TO ZERO IF U DONT WANT VOLUME AT ALL
public static double volume = 20;
public Stage primaryStage;
public MediaPlayer menuTheme  = new MediaPlayer(new Media(new File("src/Music/Baldurs Gate OST -  Main Theme.mp3").toURI().toString()));       
        
    @Override
    public void start(Stage primaryStage) {
        Group menuGroup = new Group();
        //initial background
        Image Backdrop1 = new Image("Menu_Images/Backdrop01.jpg");
        ImageView Backdrop01 = new ImageView(Backdrop1);
        Backdrop01.setPreserveRatio(true);
        Backdrop01.setFitHeight(1000);
        menuGroup.getChildren().add(Backdrop01);
//media player
        menuTheme.setCycleCount(MediaPlayer.INDEFINITE);
        menuTheme.setVolume(volume/100);
        menuTheme.play();
        System.out.println("starting music!");
 //scroll
        Image Banner = new Image("Menu_Images/Banner.png");
        ImageView Banner01 = new ImageView(Banner);
        Banner01.setPreserveRatio(true);
        Banner01.setFitWidth(900);
        Banner01.setTranslateX(10);
        Banner01.setTranslateY(10);
        menuGroup.getChildren().add(Banner01);
        //title
        Text Title = new Text("Depths O' Darkwell");
        Title.setTranslateX(110);
        Title.setTranslateY(170);
        Title.setStroke(Color.BLACK);
        Title.setStrokeWidth(5);
        Title.setFill(Color.WHITE);
        Title.setFont(Font.font("Monospaced", FontWeight.BOLD, 65));
        menuGroup.getChildren().add(Title);
        
        Image PlayButtonImage = new Image("Menu_Images/Menu_00.png");
        ImageView B1 = new ImageView();
        B1.setImage(PlayButtonImage);
        B1.setTranslateX(10);
        B1.setTranslateY(180);
        B1.setPreserveRatio(true);
        B1.setFitWidth(200);
        //HANDLE FOR ALL BUTTONS TO DO WHAT U WANT THEM TO
        B1.setOnMouseClicked(new EventHandler<MouseEvent>(){
        @Override   
        public void handle (MouseEvent event){
        System.out.println("Play Button Pressed");
        GameIntro(primaryStage);
        }});
        menuGroup.getChildren().add(B1);
        
        Image MenuButtonImage = new Image("Menu_Images/Menu_01.png");
        ImageView B2 = new ImageView();
        B2.setImage(MenuButtonImage);
        B2.setTranslateX(10);
        B2.setTranslateY(300);
        B2.setPreserveRatio(true);
        B2.setFitWidth(200);
        B2.setOnMouseClicked(new EventHandler<MouseEvent>(){
        @Override   
        public void handle (MouseEvent event){
        System.out.println("Menu Button Pressed");
        OpenMenu(primaryStage);
        }});
        menuGroup.getChildren().add(B2);
        
        Image H2PButtonImage = new Image("Menu_Images/Menu_02.png");
        ImageView B3 = new ImageView();
        B3.setImage(H2PButtonImage);
        B3.setPreserveRatio(true);
        B3.setFitWidth(200);
        B3.setTranslateX(10);
        B3.setTranslateY(420);
        B3.setOnMouseClicked(new EventHandler<MouseEvent>(){
        @Override   
        public void handle (MouseEvent event){
        System.out.println("How To play Button Pressed");
        HowToPlay(primaryStage);
        }});
        menuGroup.getChildren().add(B3);
        
        Image HighScoreButtonImage = new Image("Menu_Images/Menu_13.png");
        ImageView B5 = new ImageView();
        B5.setImage(HighScoreButtonImage);
        B5.setTranslateX(10);
        B5.setTranslateY(540);
        B5.setPreserveRatio(true);
        B5.setFitWidth(200);
        B5.setOnMouseClicked(new EventHandler<MouseEvent>(){
        @Override   
        public void handle (MouseEvent event){
        System.out.println("High Score Button Pressed");
        HighScore(primaryStage);
        }});
        menuGroup.getChildren().add(B5);
        
        Image ExitButtonImage = new Image("Menu_Images/Menu_03.png");
        ImageView B4 = new ImageView();
        B4.setImage(ExitButtonImage);
        B4.setPreserveRatio(true);
        B4.setFitWidth(200);
        B4.setTranslateX(10);
        B4.setTranslateY(660);
        B4.setOnMouseClicked(new EventHandler<MouseEvent>(){
        @Override   
        public void handle (MouseEvent event){
        System.out.println("Exit Button Pressed");
        System.exit(0);
        }});
        menuGroup.getChildren().add(B4);
        

        Scene Start = new Scene(menuGroup, 1000, 1000);
        primaryStage.setTitle("Depths O' Darkwell");
        primaryStage.setScene(Start);
        primaryStage.show();
    }
    public void GameIntro (Stage primaryStage){
    Group Lore = new Group();
    
    Image Backdrop2 = new Image("Menu_Images/Backdrop02.jpg");
    ImageView Backdrop02 = new ImageView(Backdrop2);
    Backdrop02.setPreserveRatio(true);
    Backdrop02.setFitWidth(1000);
    Lore.getChildren().add(Backdrop02);
    //LORE DOES NOT FIT GAME BUT THOMAS DOES LIKE IT
    Text LoreText = new Text("Some Time Ago, \n A cruel Golden Dragon terrorized the \n countryside. One night, he attacked the king's \n castle and slaughtered everyone. Anybody \n who has dared to approach has been melted. \n The local villagers have pleaded for you, \n a renowned adventurer, to sneak into \n the dragon's new roost  in the bowels of the \n castle, and vanquish this monster in it's sleep.");
    if(TwoPlayer == true){
    LoreText.setText("Some Time Ago, \n A cruel Golden Dragon terrorized the \n countryside. One night, he attacked the king's \n castle and slaughtered everyone. Anybody \n who has dared to approach has been melted. \n The local villagers have pleaded for you, \n two praised adventurers, to sneak into \n the dragon's new roost  in the bowels of the \n castle, and vanquish this monster in it's sleep.");
    }
    LoreText.setStroke(Color.BLACK);
    LoreText.setStrokeWidth(1);
    LoreText.setFill(Color.WHITE);
    LoreText.setFont(Font.font("Arial", FontWeight.BOLD, 40));
    LoreText.setTextAlignment(TextAlignment.LEFT);
    LoreText.setX(30);
    LoreText.setY(50);
    Lore.getChildren().add(LoreText);
    
    Text TutText = new Text("But Beware, The Dragon \n has many evil creatures bound to his will!");
    TutText.setStroke(Color.BLACK);
    TutText.setStrokeWidth(1);
    TutText.setFill(Color.RED);
    TutText.setFont(Font.font("Arial", FontWeight.BOLD, 40));
    TutText.setTextAlignment(TextAlignment.LEFT);
    TutText.setX(30);
    TutText.setY(650);
    Lore.getChildren().add(TutText);
    
    
    Image OkayButtonImage = new Image("Menu_Images/Menu_04.png");
    ImageView OkayButton = new ImageView();
    OkayButton.setImage(OkayButtonImage);
    OkayButton.setPreserveRatio(true);
    OkayButton.setFitWidth(200);
    OkayButton.setTranslateX(400);
    OkayButton.setTranslateY(800);
    //ALLOWS OKAY TO BE USED TO GET U TO THE ACTUAL GAME
    OkayButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
    @Override   
    public void handle (MouseEvent event){
    System.out.println("Continue Button Pressed");
    menuTheme.stop();
    GameStart G = new GameStart();
    G.start(primaryStage); 
    }});
    Lore.getChildren().add(OkayButton);
    Scene LoreScene = new Scene(Lore, 1000, 1000);
    primaryStage.setScene(LoreScene);    
    }
    
    public void OpenMenu (Stage primaryStage){
    Group Options = new Group();
    
    Image Backdrop1 = new Image("Menu_Images/Backdrop01.jpg");
    ImageView Backdrop01 = new ImageView(Backdrop1);
    Backdrop01.setPreserveRatio(true);
    Backdrop01.setFitHeight(1000);
    Options.getChildren().add(Backdrop01);
    
    Text TitleOptions = new Text("Options!");
    TitleOptions.setStroke(Color.BLACK);
    TitleOptions.setStrokeWidth(5);
    TitleOptions.setFill(Color.WHITE);
    TitleOptions.setFont(Font.font("Arial", FontWeight.BOLD, 70));
    TitleOptions.setTextAlignment(TextAlignment.CENTER);
    //TitleOptions.setTranslateX(500);
    TitleOptions.setTranslateY(60);
    Options.getChildren().add(TitleOptions);
    
    Text TwoPlayerOptions = new Text("One Player or Two Player Mode?");
    TwoPlayerOptions.setStroke(Color.BLACK);
    TwoPlayerOptions.setStrokeWidth(2);
    TwoPlayerOptions.setFill(Color.WHITE);
    TwoPlayerOptions.setFont(Font.font("Arial", FontWeight.BOLD, 40));
    TwoPlayerOptions.setTextAlignment(TextAlignment.CENTER);
    TwoPlayerOptions.setTranslateX(200);
    TwoPlayerOptions.setTranslateY(100);
    Options.getChildren().add(TwoPlayerOptions);
    //CHECKS FOR 2 PLAYER AND SETS IT ACCORDINGLY FOR GAME
    Image OnePlayerButtonImage = new Image("Menu_Images/Menu_06.png");
    Image TwoPlayerButtonImage = new Image("Menu_Images/Menu_05.png");
    ImageView B1 = new ImageView();
    if(TwoPlayer == false){
    B1.setImage(OnePlayerButtonImage);
    }
    else{
    B1.setImage(TwoPlayerButtonImage);    
    }
    B1.setTranslateX(400);
    B1.setTranslateY(105);
    B1.setPreserveRatio(true);
    B1.setFitWidth(200);
    B1.setOnMouseClicked(new EventHandler<MouseEvent>(){
    @Override   
    public void handle (MouseEvent event){
    if(TwoPlayer == false){
    TwoPlayer = true;   
    B1.setImage(TwoPlayerButtonImage);
    System.out.println("Two Player Mode Selected");
    }
    else{
    TwoPlayer = false;   
    B1.setImage(OnePlayerButtonImage);
    System.out.println("Single Player Mode Selected");    
    }
    }});
    Options.getChildren().add(B1);
    //HARDMODE MAKES THE GAME REALLY HARD
    Text HardModeOptions = new Text("Enable Hardcore Mode?");
    HardModeOptions.setStroke(Color.BLACK);
    HardModeOptions.setStrokeWidth(2);
    HardModeOptions.setFill(Color.WHITE);
    HardModeOptions.setFont(Font.font("Arial", FontWeight.BOLD, 40));
    HardModeOptions.setTranslateX(300);
    HardModeOptions.setTranslateY(330);
    HardModeOptions.setTextAlignment(TextAlignment.CENTER);
    Options.getChildren().add(HardModeOptions);

    Image ONButtonImage = new Image("Menu_Images/Menu_07.png");
    Image OFFButtonImage = new Image("Menu_Images/Menu_08.png");
    ImageView B2 = new ImageView();
    if(HardMode == false){
    B2.setImage(OFFButtonImage);
    }
    else{
    B2.setImage(ONButtonImage);    
    }
    B2.setTranslateX(400);
    B2.setTranslateY(335);
    B2.setPreserveRatio(true);
    B2.setFitWidth(200);
    B2.setOnMouseClicked(new EventHandler<MouseEvent>(){
    @Override   
    public void handle (MouseEvent event){
    if(HardMode == false){
    HardMode = true;   
    B2.setImage(ONButtonImage);
    System.out.println("Hard Mode Selected");
    }
    else{
    HardMode = false;   
    B2.setImage(OFFButtonImage);
    System.out.println("EASY Mode Selected");    
    }
    }});
    Options.getChildren().add(B2);
    
    Image OkayButtonImage = new Image("Menu_Images/Menu_04.png");
    ImageView OkayButton = new ImageView();
    OkayButton.setImage(OkayButtonImage);
    OkayButton.setPreserveRatio(true);
    OkayButton.setFitWidth(200);
    OkayButton.setTranslateX(400);
    OkayButton.setTranslateY(800);
    OkayButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
    @Override   
    public void handle (MouseEvent event){
    System.out.println("Return Button Pressed");
    start(primaryStage);
    }});
    Options.getChildren().add(OkayButton);

    Text VolumeTitle = new Text();
    VolumeTitle.setText("Volume Level is Currently:");
    VolumeTitle.setStroke(Color.BLACK);
    VolumeTitle.setStrokeWidth(2);
    VolumeTitle.setFill(Color.WHITE);
    VolumeTitle.setFont(Font.font("Arial", FontWeight.BOLD, 40));
    VolumeTitle.setTranslateX(280);
    VolumeTitle.setTranslateY(560);
    VolumeTitle.setTextAlignment(TextAlignment.CENTER);
    Options.getChildren().add(VolumeTitle);
    
    Image VolumeBackImage = new Image("Menu_Images/Menu_09.png");
    ImageView VolumeBacker = new ImageView(VolumeBackImage);
    VolumeBacker.setPreserveRatio(false);
    VolumeBacker.setFitHeight(200);
    VolumeBacker.setFitWidth(200);
    VolumeBacker.setTranslateX(400);
    VolumeBacker.setTranslateY(540);
    Options.getChildren().add(VolumeBacker);
    
    //volume display text (writes as previous when opens)
    Text VDisplay = new Text();
    VDisplay.setText(String.valueOf(volume) + "%");
    VDisplay.setStroke(Color.BLACK);
    VDisplay.setStrokeWidth(2);
    VDisplay.setFill(Color.WHITE);
    VDisplay.setFont(Font.font("Arial", FontWeight.BOLD, 40));
    VDisplay.setTranslateX(455);
    VDisplay.setTranslateY(650);
    VDisplay.setTextAlignment(TextAlignment.CENTER);
    Options.getChildren().add(VDisplay);
    
    Image RightArrowButtonImage = new Image("Menu_Images/Menu_10.png");
    ImageView VolumeUp = new ImageView();
    VolumeUp.setImage(RightArrowButtonImage);
    VolumeUp.setPreserveRatio(true);
    VolumeUp.setFitHeight(200);
    VolumeUp.setTranslateX(540);
    VolumeUp.setTranslateY(530);
    //fancy volume controls
    Timeline VUP = new Timeline(new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
    if(volume < 100){
    volume = volume + 1;
    VDisplay.setText(String.valueOf(volume) + "%");
    menuTheme.setVolume(volume / 100);
    System.out.println("Setting volume to: " + volume);
    }
    }}));    
    VUP.setCycleCount(Timeline.INDEFINITE);
            
    VolumeUp.setOnMousePressed(new EventHandler<MouseEvent>(){
    @Override   
    public void handle (MouseEvent event){
    System.out.println("Volume Up Button Pressed");
    VUP.play();
    }});
   
    VolumeUp.setOnMouseReleased(new EventHandler<MouseEvent>(){
    @Override   
    public void handle (MouseEvent event){
    System.out.println("Volume Up Button Released");
    VUP.pause();
    }});
    Options.getChildren().add(VolumeUp);

    
    ImageView VolumeDown = new ImageView();
    VolumeDown.setImage(RightArrowButtonImage);
    VolumeDown.setRotate(180);
    VolumeDown.setPreserveRatio(true);
    VolumeDown.setFitHeight(200);
    VolumeDown.setTranslateX(260);
    VolumeDown.setTranslateY(530);
    
    Timeline VDOWN = new Timeline(new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
    if(volume > 0){        
    volume = volume - 1;
    VDisplay.setText(String.valueOf(volume) + "%");
    menuTheme.setVolume(volume / 100);
    System.out.println("Setting volume to: " + volume);
    }
    }}));    
    VDOWN.setCycleCount(Timeline.INDEFINITE);
            
    VolumeDown.setOnMousePressed(new EventHandler<MouseEvent>(){
    @Override   
    public void handle (MouseEvent event){
    System.out.println("Volume Down Button Pressed");
    VDOWN.play();
    }});
   
    VolumeDown.setOnMouseReleased(new EventHandler<MouseEvent>(){
    @Override   
    public void handle (MouseEvent event){
    System.out.println("Volume Down Button Released");
    VDOWN.pause();
    }});
    Options.getChildren().add(VolumeDown);
    
    
    Scene h2p = new Scene(Options, 1000, 1000);
    h2p.setFill(Color.WHITE);
    primaryStage.setScene(h2p);
    }
    
    
    public void HowToPlay (Stage primaryStage){    
    Group root = new Group();
            
    Image Backdrop1 = new Image("Menu_Images/Backdrop01.jpg");
    ImageView Backdrop01 = new ImageView(Backdrop1);
    Backdrop01.setPreserveRatio(true);
    Backdrop01.setFitHeight(1000);
    root.getChildren().add(Backdrop01);
    
    Text TitleInfo = new Text("How To Play!");
    TitleInfo.setStroke(Color.BLACK);
    TitleInfo.setStrokeWidth(5);
    TitleInfo.setFill(Color.WHITE);
    TitleInfo.setFont(Font.font("Arial", FontWeight.BOLD, 70));
    //TitleInfo.setTranslateX(500);
    TitleInfo.setTranslateY(60);
    root.getChildren().add(TitleInfo);
     
    Text KnightInfo = new Text("Player 1 Controls: \n W = Move Upwards \n A = Move Left \n S = Move Down \n D = Move Right \n Q = Attack");
    KnightInfo.setStroke(Color.BLACK);
    KnightInfo.setStrokeWidth(2);
    KnightInfo.setFill(Color.WHITE);
    KnightInfo.setFont(Font.font("Arial", 45));
    KnightInfo.setTranslateX(50);
    KnightInfo.setTranslateY(150);
    root.getChildren().add(KnightInfo);
            
    Text Player2Info = new Text("Player 2 Controls: \n Up_Arrow = Move Upwards \n Left_Arrow = Move Left \n Down_Arrow = Move Down \n Right_Arrow = Move Right \n Numpad_0 = Attack");
    Player2Info.setStroke(Color.BLACK);
    Player2Info.setStrokeWidth(2);
    Player2Info.setFill(Color.WHITE);
    Player2Info.setFont(Font.font("Arial", 45));
    Player2Info.setTranslateX(50);
    Player2Info.setTranslateY(470);
    root.getChildren().add(Player2Info);
    
    Image OkayButtonImage = new Image("Menu_Images/Menu_04.png");
    ImageView OkayButton = new ImageView();
    OkayButton.setImage(OkayButtonImage);
    OkayButton.setPreserveRatio(true);
    OkayButton.setFitWidth(200);
    OkayButton.setTranslateY(800);
    OkayButton.setTranslateX(400);
    OkayButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
    @Override   
    public void handle (MouseEvent event){
    System.out.println("Return Button Pressed");
    start(primaryStage);
    }});
    root.getChildren().add(OkayButton);
        
    Scene h2p = new Scene(root, 1000, 1000);
    h2p.setFill(Color.WHITE);
    primaryStage.setScene(h2p);
    }
    //this is highscore screen
    //currently did not have time to fully implement top 3 score so it displays the most recent high score
    //i.e. if u play the game and dont beat the current highscore it will not change
    public void HighScore(Stage primaryStage){
    Group root = new Group(); 
    
    Image Backdrop1 = new Image("Menu_Images/Backdrop01.jpg");
    ImageView Backdrop01 = new ImageView(Backdrop1);
    Backdrop01.setPreserveRatio(true);
    Backdrop01.setFitHeight(1000);
    root.getChildren().add(Backdrop01);
    
    try {
      BufferedReader r = new BufferedReader(new FileReader("HighScore.txt"));
      Line1 = r.readLine();
   //  Line2 = r.readLine();  
     // Line3 = r.readLine();
      r.close();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }  
    
    Text HighScoreTxt = new Text("The Current Highscore Is: \n " + Line1);
       //     + "\n 2nd Place: " + Line2 + " \n 3rd Place: " + Line3);
    HighScoreTxt.setStroke(Color.BLACK);
    HighScoreTxt.setStrokeWidth(2);
    HighScoreTxt.setFill(Color.WHITE);
    HighScoreTxt.setFont(Font.font("Arial", 45));
    HighScoreTxt.setTranslateX(50);
    HighScoreTxt.setTranslateY(150);
    root.getChildren().add(HighScoreTxt);
    
    Image OkayButtonImage = new Image("Menu_Images/Menu_04.png");
    ImageView OkayButton = new ImageView();
    OkayButton.setImage(OkayButtonImage);
    OkayButton.setPreserveRatio(true);
    OkayButton.setFitWidth(200);
    OkayButton.setTranslateY(800);
    OkayButton.setTranslateX(400);
    OkayButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
    @Override   
    public void handle (MouseEvent event){
    System.out.println("Return Button Pressed");
    start(primaryStage);
    }});
    root.getChildren().add(OkayButton);
    
    Scene h2p = new Scene(root, 1000, 1000);
    h2p.setFill(Color.WHITE);
    primaryStage.setScene(h2p);
    }
    
    public double getVolume(){
    return volume;    
    }
    
}
