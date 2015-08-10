package sk.stuba.fiit.daniel.novak.view.screens;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.view.BasicView;

/**
 * Created by Daniel on 8.8.2015.
 */
public class PlayScreen extends BasicView {

    private Canvas canvas;
    private GraphicsContext gc;
    private Label label;

    public PlayScreen(Context context) {
        super(context);

        canvas = new Canvas(500, 440);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 500, 440);

        setCenter(null);
        setTop(grid2);
        setBottom(canvas);

        init();
        add();

    }

    private void init() {
        label = new Label("Score:");
    }

    private void add() {
        grid2.add(label, 0, 0);
    }
}
