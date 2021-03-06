package sk.stuba.fiit.daniel.novak;

import javafx.application.Application;
import javafx.stage.Stage;
import sk.stuba.fiit.daniel.novak.controller.MainScreenController;
import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.model.audio.Music;
import sk.stuba.fiit.daniel.novak.view.screens.MainScreen;

/**
 * Created by Daniel on 8.8.2015.
 */
public class JavaFX extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Music music = new Music();
        Context context = new Context(primaryStage);
        MainScreen mainScreen = new MainScreen(context);
        context.switchScene(mainScreen);
        MainScreenController.initAndStart(context, mainScreen, music);
    }
}
