package graphicaldemo2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This program uses some more drawing tools to create some abstract art.
 *
 * @author Mr. Smithe
 */
public class GraphicalDemo2 extends Application {

    /** 
     * This Code allows us to read mouse coordinates 
     */
    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            System.out.println("(" + event.getX() + ", " + event.getY() + ")");
        }
    };

    @Override
    public void start(Stage primaryStage) {

        //create a rectangle
        //new Rectangle(topLeftX, topLeftY, width, height);
        Rectangle r1 = new Rectangle(200, 200, 300, 400);
        r1.setFill(Color.AQUAMARINE);
        r1.setStroke(Color.BLUEVIOLET);
        //make the outline thicker. 
        r1.setStrokeWidth(5);

        //to make a square - use a rectangle with the same length and width
        Rectangle square = new Rectangle(250, 250, 25, 25);
        square.setFill(Color.CHOCOLATE);
        square.setStroke(Color.DARKBLUE);

        //we can also rotate shapes. 
        Rectangle r2 = new Rectangle(600, 100, 50, 100);
        r2.setFill(Color.FUCHSIA);
        //rotate the shape 30 degrees clockwise
        r2.setRotate(30);

        //new Line(x1, y1, x2, y2);
        Line l1 = new Line(50, 45, 120, 315);
        l1.setStroke(Color.CHARTREUSE);

        //we can add text too
        //new Text(bottomLeftX, bottomLeftY, string_text);
        Text t1 = new Text(100, 100, "Check out my art!");
        //set the colour of the text
        t1.setFill(Color.WHITE);
        //change the font size. 
        t1.setFont(Font.font(30));

        //add the shapes to the root. 
        Group root = new Group();
        root.getChildren().add(r1);
        root.getChildren().add(square);
        root.getChildren().add(r2);
        root.getChildren().add(l1);
        root.getChildren().add(t1);

        //create an 800x600 window
        Scene scene = new Scene(root, 800, 600);
        //change the background colour
        scene.setFill(Color.BLACK);
        //this makes our event handler run on mouse clicks
        scene.setOnMouseClicked(mouseHandler);

        //create the frame and show the window. 
        primaryStage.setTitle("Graphical Demo (part 2)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
