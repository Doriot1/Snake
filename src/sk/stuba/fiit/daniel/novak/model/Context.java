package sk.stuba.fiit.daniel.novak.model;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Daniel on 8.8.2015.
 */
public class Context {
    private Scene scene;
    private Stage stage;

    public Context(Stage stage){
        this.stage = stage;
    }

    public void switchScene(Parent root){
        scene = new Scene(root);
        stage.setScene(scene);
        //stage.setHeight(530);
        //stage.setWidth(505);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.setTitle("Snake");
        stage.show();
    }

    public Stage getStage(){
        return stage;
    }

}
