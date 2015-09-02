package sk.stuba.fiit.daniel.novak.view.screens;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.view.BasicView;

/**
 * nope
 * Created by Daniel on 8.8.2015.
 */
public class PlayScreen extends BasicView {

    public Label score;
    private Canvas canvas;
    private GraphicsContext gc;
    private Label label;
    private PlayScreenListener playScreenListener;

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

        setFocusTraversable(true);

        setOnKeyPressed(e -> playScreenListener.onKeyPressed(e.getCode()));
    }

    private void init() {
        label = new Label("Score:   ");
        label.setId("fancy");
        score = new Label("0");
        score.setId("fancy");
    }

    private void add() {
        grid2.add(label, 0, 0);
        grid2.add(score, 1, 0);
    }


    public GraphicsContext getGc() {
        return gc;
    }

    public void setPlayScreenListener(PlayScreenListener playScreenListener) {
        this.playScreenListener = playScreenListener;
    }

    public interface PlayScreenListener {
        void onKeyPressed(KeyCode keyCode);
    }
}
