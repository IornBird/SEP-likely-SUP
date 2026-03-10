package encoder;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.*;

public class coder_main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new VBox(500);
        pane.getChildren().add(Keyin());
        pane.setPadding(new Insets(20));

        Scene scene = new Scene(pane,400,150);
        primaryStage.setTitle("編密碼小工具"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    private static Font font= Font.font("consolas", FontWeight.BOLD,16);
    static TextField inp = feld(new TextField()),
                            out = feld(new TextField());
    static Label message=new Label();
    static TextField feld(TextField f){
        f.setFont(font);
        f.setMinSize(300,30);
        return f;
    }
    static Label feld(Label l){
        l.setFont(font);
        return l;
    }
    static VBox Keyin() {
        VBox v = new VBox(5);
        HBox h[] = {
                new HBox(feld(new Label("輸入：")),inp),
                new HBox(feld(new Label("輸出：")),out),
                new HBox(5),
                new HBox(message)
        };
        Button b[] = new Button[5];
        for(int i=0;i<5;i++){
            final int I=i;
            b[i] = new Button(ACTS[i]);
            b[i].setMinSize(60,40);
            b[i].setFont(font);
            b[i].setOnAction(e->{
                try{Deal.d(I);}
                catch (IOException E){}
            });
            h[2].getChildren().add(b[i]);
        }

        v.getChildren().addAll(h[0],h[1],h[2],h[3]);
        return v;
    }
    final static String[] ACTS={
            "新建","存檔","編碼","複製","清空"
    };

    public static void main(String[] args) {
        launch(args);
    }
}
