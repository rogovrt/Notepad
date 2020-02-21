package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.ArrayList;

public class FileMenu {
    public static Menu createFileMenu(TextArea ta) {
        Menu m = new Menu("File");
        m.getItems( ).addAll(
                FileMenu.createCreate(ta),
                FileMenu.openCreate(ta),
                FileMenu.saveCreate(ta),
                FileMenu.exitCreate()
        );
        return m;
    }

    private static EventHandler<ActionEvent> acreate(TextArea ta) {
        EventHandler<ActionEvent> acreate = new EventHandler<ActionEvent>( ) {
            public void handle(ActionEvent actionEvent) {
                ArrayList<String> lines = new ArrayList<String>();
                lines.add(ta.getText());
                Stage nw = Windows.getRecordWindow("Create file", lines);
                nw.show();
            }
        };
        return acreate;
    }

    private static MenuItem createCreate(TextArea ta) {
        MenuItem create = new MenuItem("Create");
        create.setOnAction(FileMenu.acreate(ta));
        return create;
    }

    private static EventHandler<ActionEvent> aopen(TextArea ta) {
        EventHandler<ActionEvent> aopen = new EventHandler<ActionEvent>( ) {
            public void handle(ActionEvent actionEvent) {
                Stage nw = Windows.getOpenWindow("Create file", ta);
                nw.show();
            }
        };
        return aopen;
    }

    private static MenuItem openCreate(TextArea ta) {
        MenuItem create = new MenuItem("Open");
        create.setOnAction(FileMenu.aopen(ta));
        return create;
    }

    private static MenuItem saveCreate(TextArea ta) {
        MenuItem save = new MenuItem("Save");
        save.setOnAction(FileMenu.acreate(ta));
        return save;
    }

    private static MenuItem exitCreate() {
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
        return exit;
    }
}
