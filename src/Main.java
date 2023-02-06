
/*
CS-255 Getting started code for the assignment
I do not give you permission to post this code online
Do not post your solution online
Do not copy code
Do not use JavaFX functions or other libraries to do the main parts of the
assignment (i.e. ray tracing steps 1-7)
All of those functions must be written by yourself
You may use libraries to achieve a better GUI
*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Toggle;
import javafx.scene.control.Slider;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.io.*;
import java.lang.Math.*;
import javafx.geometry.HPos;

import static java.lang.Math.sqrt;

public class Main extends Application {

    private static final int SCREEN_WIDTH = 500;
    private static final int SCREEN_HEIGHT = 500;
     //just for the test example
    @Override
    public void start(Stage stage) throws FileNotFoundException, IOException {

        stage.setTitle("Sphere viewer");
        //We need 3 things to see an image
        //1. We create an image we can write to
        WritableImage image = new WritableImage(SCREEN_WIDTH, SCREEN_HEIGHT);
        //2. We create a view of that image
        ImageView view = new ImageView(image);
        //3. Add to the pane (below)
        //Create the simple GUI

        RayTracer rayTracer = new RayTracer();

        Button render_button = new Button("render");

        Slider zoom_slider = new Slider(0, 100, 0);
        render_button.setOnAction(actionEvent -> rayTracer.render(image));
        //Add all the event handlers
        zoom_slider.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    //lighty[0] = newValue.doubleValue();
                    rayTracer.render(image);
                });
        //The following is in case you want to interact with the image in any way
        //e.g., for user interaction, or you can find out the pixel position for debugging
        // view.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED, event -> {
        //   System.out.println(event.getX() + " " + event.getY());
        // event.consume();
        rayTracer.addSphere();
        rayTracer.render(image);
        FlowPane root = new FlowPane();
        root.setVgap(8);
        root.setHgap(4);
        //3. (referring to the 3 things we need to display an image)
        //we need to add it to the pane
        //root.add(view, 0, 0);
        //root.add(zoom_slider, 0, 1);
        ////Display to user



        root.getChildren().addAll(view,render_button,zoom_slider);
        Scene scene = new Scene(root, 640, 640);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {

        // Call the render method on the tracer instance

        launch();
    }
}
