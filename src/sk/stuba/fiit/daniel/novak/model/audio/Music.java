package sk.stuba.fiit.daniel.novak.model.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;


public class Music {

    // starting piece
    private URL thing = getClass().getResource("/Chopin.mp3");
    private Media media = new Media(thing.toString());
    private MediaPlayer player;

    // grenade sound
    private URL thing2 = getClass().getResource("/loss_sound.mp3");
    private Media media2 = new Media(thing2.toString());
    private MediaPlayer player2;

    public void play() {
        player = new MediaPlayer(media);
        player.play();
    }

    public void loss() {
        player.stop();
        player2 = new MediaPlayer(media2);
        player2.play();
    }
}
