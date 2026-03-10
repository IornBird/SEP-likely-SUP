package exchange_rate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Cal_main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a pane
        VBox pane = new VBox();

        pane.getChildren().add(contend());

        Scene scene = new Scene(pane,400,200);
        primaryStage.setTitle("匯率轉換器"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    final static TextField inp = new TextField();
    final static ComboBox from = new ComboBox<String>();
    final static ComboBox  to  = new ComboBox<String>();
    final static Label ans = new Label();
    final static Font font = Font.font("Cambria Math", FontWeight.BOLD,16);

    final static String[] dollars = {
            "美元","台幣","日圓","歐元","人民幣"
    };

    static VBox contend(){
        VBox v = new VBox(5);
        HBox select = new HBox(5);
        Button exchange = new Button("↔");
        Button convert = new Button("轉換");

        from.getItems().addAll(dollars);
        from.setValue(dollars[0]);
          to.getItems().addAll(dollars);
          to.setValue(dollars[0]);
         inp.setFont(font);
         ans.setFont(font);
        exchange.setFont(font);
        exchange.setOnAction(e->Action.exchange());
        convert.setFont(font);
        convert.setOnAction(e->Action.convert());

        select.getChildren().addAll(from,exchange,to);
        v.getChildren().addAll(inp,select,convert,ans);
        return v;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
