package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;

public class EditMenu {
    public static Menu createEditMenu(TextArea ta) {
        Menu m = new Menu("Edit");
        m.getItems().addAll(
                EditMenu.createUndo(ta),
                new SeparatorMenuItem(),
                EditMenu.createCut(ta),
                EditMenu.createPaste(ta),
                EditMenu.createClear(ta)
        );
        return m;
    }

    private static MenuItem createUndo(TextArea ta) {
        MenuItem undo = new MenuItem("Undo");
        undo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                ta.undo();
            }
        });
        return undo;
    }

    private static MenuItem createCut(TextArea ta) {
        MenuItem cut = new MenuItem("Cut");
        cut.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                ta.cut();
            }
        });
        return cut;
    }

    private static MenuItem createPaste(TextArea ta) {
        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                ta.paste();
            }
        });
        return paste;
    }

    private static MenuItem createClear(TextArea ta) {
        MenuItem clear = new MenuItem("Clear");
        clear.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                ta.clear();
            }
        });
        return clear;
    }
}
