package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Buttons {
    public static Button record(String title, TextField tf, List lines, Stage window) {
        Button record = new Button(title);
        record.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileUtils.writeAll(tf.getText(), lines);
                window.close();
            }
        });
        return record;
    }

    public static Button open(String title, TextField tf, TextArea ta, Stage window) {
        Button record = new Button(title);
        record.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                List<String> lines = FileUtils.readAll(tf.getText());
                ta.setText(lines.get(0) + '\n');
                int index = lines.get(0).length() + 1;
                for (int i = 1; i < lines.size(); ++i) {
                    ta.insertText(index, lines.get(i) + '\n');
                    index += lines.get(i).length() + 1;
                }
                window.close();
            }
        });
        return record;
    }

    public static Button cancel(String title, Stage window) {
        Button cancel = new Button(title);
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                window.close();
            }
        });
        return cancel;
    }
}
