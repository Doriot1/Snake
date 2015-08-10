package sk.stuba.fiit.daniel.novak.view;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import sk.stuba.fiit.daniel.novak.model.Context;

/**
 * Created by Daniel on 8.8.2015.
 */
public abstract class BasicView extends BorderPane {
    private final Context context;
    protected GridPane grid = new GridPane();


    public BasicView(Context context) {
        this.context = context;
        init();
        add();
    }

    public final Context getContext() {
        return context;
    }

    private void init() {
        grid.setPadding(new Insets(20));
        grid.setGridLinesVisible(false);
        setCenter(grid);


        for (int i = 0; i < 9; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(50));
            grid.getRowConstraints().add(new RowConstraints(50));
        }
    }

    private void add() {

    }

}