package sk.stuba.fiit.daniel.novak.model.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

/**
 * short sounds
 * Created by Daniel on 2.9.2015.
 */
public class Sounds {
    private URL thing = getClass().getResource("/food.mp3");
    private Media media = new Media(thing.toString());

    public void play(){
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.3);
        player.play();
    }
}
