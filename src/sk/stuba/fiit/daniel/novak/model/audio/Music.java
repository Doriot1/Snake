package sk.stuba.fiit.daniel.novak.model.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;


public class Music {
    private URL thing = getClass().getResource("/Chopin.mp3");
    private URL thing2 = getClass().getResource("/Chopin.mp3");
    private Media media = new Media(thing.toString());
    private Media media2 = new Media(thing.toString());
private MediaPlayer player;

    public void play() {
        player = new MediaPlayer(media);
        player.play();
    }

    public void loss(){
        player.stop();
        MediaPlayer player2 = new MediaPlayer(media2);
    }
}
