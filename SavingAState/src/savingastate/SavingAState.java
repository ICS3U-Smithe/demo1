package savingastate;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * This class allows the user to toggle a grid between selected and not. 
 * It saves the state of the grid between sessions. 
 * 
 * @author Mr. Smithe
 */
public class SavingAState extends Application {

    Group root = new Group();
    Boolean[][] map = new Boolean[5][5];
    Rectangle[][] grid = new Rectangle[5][5];

    @Override
    public void start(Stage primaryStage) {

        drawGrid();

        loadState();

        updateGrid();

        Scene scene = new Scene(root, 500, 500);

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //get the square the user clicked on. 
                int x = (int) Math.round(event.getX()) / 100;
                int y = (int) Math.round(event.getY()) / 100;

                //toggle it
                map[x][y] = !map[x][y];

                //update the visual
                if (map[x][y]) {
                    grid[x][y].setFill(Color.GREEN);
                } else {
                    grid[x][y].setFill(Color.WHITE);
                }
            }
        });

        primaryStage.setTitle("State Saver");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //this saves the state when the user closes the window. 
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                saveState();
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method draws the grid of rectangles. 
     */
    private void drawGrid() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                grid[i][j] = new Rectangle(i * 100, j * 100, 100, 100);
                grid[i][j].setFill(Color.WHITE);
                grid[i][j].setStroke(Color.BLACK);
                
                root.getChildren().add(grid[i][j]);
            }
        }
    }
    
    /**
     * This method makes the rectangles match the boolean variables. 
     */
    private void updateGrid() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j]){
                    grid[i][j].setFill(Color.GREEN);
                }else{
                    grid[i][j].setFill(Color.WHITE);
                }
            }
        }
    }
    
    /**
     * this method reads the previous state from an external file. 
     * If no file is found it initializes everything empty.
     */
    private void loadState() {
        try {
            Scanner s = new Scanner(new FileReader(new File("map.txt")));
            for (int j = 0; j < map[0].length; j++) {
                for (int i = 0; i < map.length; i++) {
                    map[i][j] = s.nextBoolean();
                }
            }
            s.close();

        } catch (Exception e) {
            System.out.println("No previous state found, initializing empty. ");
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = false;
                }
            }
        }
    }

    /**
     * This method saves the current state to a file. 
     */
    private void saveState() {
        try {
            FileWriter w = new FileWriter(new File("map.txt"));

            for (int j = 0; j < map[0].length; j++) {
                for (int i = 0; i < map.length; i++) {
                    w.append(map[i][j] + " ");
                }
            }
            
            w.close();

        } catch (IOException ex) {
            System.err.println("Error writing to file");
        }
    }

}
