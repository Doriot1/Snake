package sk.stuba.fiit.daniel.novak;

import javafx.application.Application;
import javafx.stage.Stage;
import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.view.screens.MainScreen;

/**
 * Created by Daniel on 8.8.2015.
 */
public class JavaFX extends Application {
    private Context context;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        context = new Context(primaryStage);
        context.switchScene(new MainScreen(context));
    }
}
