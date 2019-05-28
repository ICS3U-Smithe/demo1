/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysortvisualizer;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author smitandr7141
 */
public class ArraySortVisualizer extends Application {

    private int[] data = new int[100];

    private int numShuffles = 100;

    Group root = new Group();
    Rectangle[] bars = new Rectangle[100];

    Timeline bubbleSortTimeline;
    int i = 0;
    int j = 1;
    boolean sorted  = false;

    @Override
    public void start(Stage primaryStage) {

        initializeData();
        initializeGraph();

        scrambleData();

        displayData();

        Scene scene = new Scene(root, 1000, 500);
        scene.setFill(Color.BLACK);

        primaryStage.setTitle("Array Sort Visualizer");
        primaryStage.setScene(scene);
        primaryStage.show();

        //bubbleSort();
        //bubbleSort2();
        //bubbleSort3();
        //bubbleSortNatural();
        
        mergeSort();
     
    }

    private void initializeData() {
        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }
    }

    private void initializeGraph() {
        for (int i = 0; i < data.length; i++) {
            bars[i] = new Rectangle(i * 10, 500 - data[i] / 100.0 * 500.0, 9, 500);
            bars[i].setFill(Color.WHITE);
            root.getChildren().add(bars[i]);
        }
    }

    private void scrambleData() {
        Random r = new Random();

        for (int i = 0; i < numShuffles; i++) {
            int a = r.nextInt(data.length);
            int b = r.nextInt(data.length);

            int temp = data[a];
            data[a] = data[b];
            data[b] = temp;
        }
    }

    private void displayData() {
        for (int x = 0; x < data.length; x++) {
            bars[x].setY(500 - data[x] / 100.0 * 500.0);
        }
    }

    private void bubbleSort() {

        bubbleSortTimeline = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int j = i + 1; j < data.length; j++) {
                    if (data[i] > data[j]) {
                        int temp = data[i];
                        data[i] = data[j];
                        data[j] = temp;

                        displayData();
                    }
                }

                i++;

            }
        }));

        bubbleSortTimeline.setCycleCount(data.length);
        bubbleSortTimeline.play();
    }

    private void bubbleSort2() {

        bubbleSortTimeline = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                
                if (data[i] > data[j]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;

                    displayData();
                }

                j++;
                
                if (j == data.length) {
                    j = i + 1;
                    i++;
                }
                if (i == data.length) {
                    bubbleSortTimeline.stop();
                }
                
            }
        }));

        bubbleSortTimeline.setCycleCount(Timeline.INDEFINITE);
        bubbleSortTimeline.play();
    }
    
    private void bubbleSort3() {

        bubbleSortTimeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                
                if (data[i] > data[i+1]) {
                    int temp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = temp;
                    sorted = false;
                    
                    displayData();
                }
                i++;
                
                //if(sorted)
                //    bubbleSortTimeline.stop();
                
                if (i == data.length - 1) {
                    sorted = true;
                    i = 0;
                }
                
            }
        }));

        bubbleSortTimeline.setCycleCount(Timeline.INDEFINITE);
        bubbleSortTimeline.play();
    }

    private void bubbleSortNatural(){
        while(!sorted){
            sorted = true;
            for(int i = 0; i < data.length - 1; i++){
                if (data[i] > data[i+1]) {
                    int temp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = temp;
                    sorted = false;
                    
                    displayData();
                    
                    
                }
            }
        }
    }
    
    private void selectionSort() {

    }
    
    private void insertionSort(){
        
    }
    
    private void mergeSort(){
        data = mergeSort(data);
        displayData();
    }
    
    private int[] mergeSort(int[] arr){
        int n = arr.length;
        if(n == 1 || n == 0)
            return arr;
        int[] arr1 = new int[n/2];
        int[] arr2 = new int[n-n/2];
        
        int i = 0;
        
        for(int i1 = 0; i < arr1.length; i1++){
            arr1[i1] = arr[i++];
        }
        
        for(int i2 = 0; i < arr2.length; i2++){
            arr1[i2] = arr[i++];
        }
        
        return merge(mergeSort(arr1), mergeSort(arr2));
    }
    
    private int[] merge(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        int i1 = 0;
        int i2 = 0;
        for(int i = 0; i < result.length; i++){
            if(i1 == arr1.length){
                result[i] = arr1[i2++];
            }else if(i2 == arr2.length){
                result[i] = arr1[i1++];
            }else if(arr1[i1] < arr2[i2]){
                result[i] = arr1[i1++];
            }else{
                result[i] = arr1[i2++];
            }
        }
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
