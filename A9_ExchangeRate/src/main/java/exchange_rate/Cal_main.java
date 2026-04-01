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
    // Static reference to the current instance for accessing UI components
    private static Cal_main instance;

    // Instance fields (not static) - initialized in start()
    public TextField inp;
    public ComboBox<String> from;
    public ComboBox<String> to;
    public Label ans;
    public Font font;

    final static String[] dollars = {
            "美元","台幣","日圓","歐元","人民幣"
    };

    public static Cal_main getInstance() {
        return instance;
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize the static instance reference (only after toolkit is initialized)
        instance = this;

        // Initialize UI components here (after JavaFX toolkit is ready)
        inp = new TextField();
        from = new ComboBox<>();
        to = new ComboBox<>();
        ans = new Label();
        font = Font.font("Cambria Math", FontWeight.BOLD, 16);

        // Create a pane
        VBox pane = new VBox();
        pane.getChildren().add(contend());

        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setTitle("匯率轉換器"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private VBox contend() {
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
        exchange.setOnAction(e -> Action.exchange());
        convert.setFont(font);
        convert.setOnAction(e -> Action.convert());

        select.getChildren().addAll(from, exchange, to);
        v.getChildren().addAll(inp, select, convert, ans);
        return v;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
