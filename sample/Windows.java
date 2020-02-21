package sample;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Windows {
    public static Stage getRecordWindow(String title, ArrayList<String>lines) {
        Stage nw = new Stage();
        BorderPane root = new BorderPane();
        Scene sc = new Scene(root, 300, 200);
        TextField tf = new TextField();

        ToolBar tb = new ToolBar(
                Buttons.record("Save", tf, lines, nw),
                new Separator(),
                Buttons.cancel("Cancel", nw)
        );

        Text t = new Text("Type full path to file:");
        t.setFont(new Font(20));

        root.setTop(t);
        root.setCenter(tf);
        root.setBottom(tb);

        nw.setTitle(title);
        nw.setScene(sc);
        return nw;
    }

    public static Stage getOpenWindow(String title, TextArea ta) {
        Stage nw = new Stage();
        BorderPane root = new BorderPane();
        Scene sc = new Scene(root, 300, 200);
        TextField tf = new TextField();

        ToolBar tb = new ToolBar(
                Buttons.open("Open", tf, ta, nw),
                new Separator(),
                Buttons.cancel("Cancel", nw)
        );

        Text t = new Text("Type full path to file:");
        t.setFont(new Font(20));

        root.setTop(t);
        root.setCenter(tf);
        root.setBottom(tb);

        nw.setTitle(title);
        nw.setScene(sc);
        return nw;
    }
}
