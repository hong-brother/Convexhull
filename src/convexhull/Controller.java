package convexhull;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    //http://boxfoxs.tistory.com/307
    @FXML private Canvas canvas;
    @FXML private Button createPointBtn;
    @FXML private TextField text;
    private GraphicsContext gc;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createPointBtn.setOnMouseClicked(event -> {
            int count = Integer.parseInt(text.getText().toString());
            draw(count);
        });


    }

    void draw(int count){
        gc= canvas.getGraphicsContext2D();
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLUE);
        for(int a=0; a<count; a++){

            double x = (Math.random() * 100000) % canvas.getWidth();
            double y = (Math.random() * 100000) % canvas.getHeight();
            gc.strokeOval(x,y,10,10);

        }

    }




}
