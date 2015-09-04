package sk.stuba.fiit.daniel.novak.model.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;


public class Music {

    private String song = "/Chopin.mp3";

    // starting piece
    private URL thing;
    private Media media;
    private MediaPlayer player;

    // grenade sound
    private URL thing2 = getClass().getResource("/loss_sound.mp3");
    private Media media2 = new Media(thing2.toString());
    private MediaPlayer player2;

    public void play(String song) {
        thing = getClass().getResource(song);
        media = new Media(thing.toString());
        player = new MediaPlayer(media);
        player.play();
    }

    public void loss() {
        player.stop();
        player2 = new MediaPlayer(media2);
        player2.play();
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSong() {
        return song;
    }
}
