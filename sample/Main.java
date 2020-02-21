package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) throws Exception{
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 700);
        TextArea ta = new TextArea();
        ta.setPrefRowCount(10);
        ta.setWrapText(true);
        ta.setEditable(true);
        MenuBar mb = new MenuBar();
        mb.getMenus().addAll(FileMenu.createFileMenu(ta), EditMenu.createEditMenu(ta));
        root.setTop(mb);
        root.setCenter(ta);
        stage.setTitle("Notepad");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
