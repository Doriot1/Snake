package sk.stuba.fiit.daniel.novak.view.screens;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.view.BasicView;

/**
 * nope
 * Created by Daniel on 8.8.2015.
 */
public class PlayScreen extends BasicView {

    private Button restart;
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

        restart.setOnAction(e -> playScreenListener.onMainMenuPressed());
    }

    private void init() {
        label = new Label("Score:   ");
        label.setId("fancy");
        score = new Label("0");
        score.setId("fancy");

        restart = new Button("Main Menu");



    }

    private void add() {
        grid2.getColumnConstraints().add(new ColumnConstraints(100));
        grid2.getColumnConstraints().add(new ColumnConstraints(100));
        grid2.getColumnConstraints().add(new ColumnConstraints(250));
        grid2.add(label, 0, 0);
        grid2.add(score, 1, 0);
        grid2.add(restart, 2, 0, 1, 3);
        grid2.setHalignment(restart, HPos.RIGHT);
    }


    public GraphicsContext getGc() {
        return gc;
    }

    public void setPlayScreenListener(PlayScreenListener playScreenListener) {
        this.playScreenListener = playScreenListener;
    }

    public interface PlayScreenListener {
        void onKeyPressed(KeyCode keyCode);

        void onMainMenuPressed();
    }
}
