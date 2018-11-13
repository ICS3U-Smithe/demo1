package diceroller;

import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * This class simulates rolling a single die. 
 * 
 * @author Mr. Smithe
 */
public class DiceRoller extends Application {
    
    //instance variables, any method in the class can access these. 
    Random r = new Random();
    Rectangle die;
    Circle pip1;
    Circle pip2;
    Circle pip3;
    Circle pip4;
    Circle pip5;
    Circle pip6;
    Circle pip7;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Roll the Die");
        btn.setLayoutX(115);
        btn.setLayoutY(220);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //pick a random number 0-5 (inclusive) then add 1. 
                int roll = r.nextInt(6) + 1;
                
                //hide all the pips
                hidePips();
                die.setVisible(true);
                
                //selectively show relevant pips, based on number rolled. 
                if(roll == 1){
                    pip7.setVisible(true);
                }else if(roll == 2){
                    pip3.setVisible(true);
                    pip4.setVisible(true);
                }else if(roll == 3){
                    pip3.setVisible(true);
                    pip4.setVisible(true);
                    pip7.setVisible(true);
                }else if(roll == 4){
                    pip1.setVisible(true);
                    pip3.setVisible(true);
                    pip4.setVisible(true);
                    pip6.setVisible(true);
                }else if(roll == 5){
                    pip1.setVisible(true);
                    pip3.setVisible(true);
                    pip4.setVisible(true);
                    pip6.setVisible(true);
                    pip7.setVisible(true);
                }else{
                    pip1.setVisible(true);
                    pip2.setVisible(true);
                    pip3.setVisible(true);
                    pip4.setVisible(true);
                    pip5.setVisible(true);
                    pip6.setVisible(true);
                }
                
                //use this to debug. 
                //System.out.println("Roll: " + roll);
            }
        });

        //create the die
        die = new Rectangle(180, 180);
        die.setLayoutX(60);
        die.setLayoutY(25);
        die.setStroke(Color.BLACK);
        die.setFill(Color.BISQUE);
        die.setVisible(false); //I chose not to show the die until rolled. 

        //draw all of the pips
        pip1 = new Circle(10, Color.BLACK);
        pip1.setLayoutX(60+45);
        pip1.setLayoutY(25+45);
        
        pip2 = new Circle(10, Color.BLACK);
        pip2.setLayoutX(60+45);
        pip2.setLayoutY(25+90);
        
        pip3 = new Circle(10, Color.BLACK);
        pip3.setLayoutX(60+45);
        pip3.setLayoutY(25+135);
        
        pip4 = new Circle(10, Color.BLACK);
        pip4.setLayoutX(60+135);
        pip4.setLayoutY(25+45);
        
        pip5 = new Circle(10, Color.BLACK);
        pip5.setLayoutX(60+135);
        pip5.setLayoutY(25+90);
        
        pip6 = new Circle(10, Color.BLACK);
        pip6.setLayoutX(60+135);
        pip6.setLayoutY(25+135);
        
        pip7 = new Circle(10, Color.BLACK);
        pip7.setLayoutX(60+90);
        pip7.setLayoutY(25+90);
        
        hidePips();
        
        //add all components to the group. 
        Group root = new Group();
        root.getChildren().add(btn);
        root.getChildren().add(die);
        root.getChildren().add(pip1);
        root.getChildren().add(pip2);
        root.getChildren().add(pip3);
        root.getChildren().add(pip4);
        root.getChildren().add(pip5);
        root.getChildren().add(pip6);
        root.getChildren().add(pip7);
        
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Dice Roller");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    /**
     * Hides all seven pips.
     */
    private void hidePips(){
        pip1.setVisible(false);
        pip2.setVisible(false);
        pip3.setVisible(false);
        pip4.setVisible(false);
        pip5.setVisible(false);
        pip6.setVisible(false);
        pip7.setVisible(false);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}