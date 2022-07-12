package io.github.riniwtz.electricfan;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FanController implements Initializable {
    @FXML
    private ToggleButton close;
    @FXML
    private ToggleButton toggleOneBtn;
    @FXML
    private ToggleButton toggleTwoBtn;
    @FXML
    private ToggleButton toggleThreeBtn;
    @FXML
    private ToggleButton toggleFourBtn;

    private Media fanSound;
    private MediaPlayer mediaPlayer;
    private DropShadow unpressed;
    private InnerShadow pressed;

    @FXML
    public void toggleOff(ActionEvent event) {
        close.setSelected(false);
        toggleOneBtn.setSelected(false);
        toggleTwoBtn.setSelected(false);
        toggleThreeBtn.setSelected(false);
        toggleFourBtn.setSelected(false);
        mediaPlayer.stop();

        close.setEffect(pressed);
        Timeline effectDelay = new Timeline(new KeyFrame(Duration.seconds(0.2D), actionEvent -> close.setEffect(unpressed)));
        effectDelay.play();
        toggleOneBtn.setEffect(unpressed);
        toggleTwoBtn.setEffect(unpressed);
        toggleThreeBtn.setEffect(unpressed);
        toggleFourBtn.setEffect(unpressed);
    }

    public void toggleOne(ActionEvent event) {
        toggleTwoBtn.setSelected(false);
        toggleThreeBtn.setSelected(false);
        toggleFourBtn.setSelected(false);
        if (!(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING))
            mediaPlayer.play();
        else
            toggleOneBtn.setSelected(true);
        mediaPlayer.setVolume(0.0625D);

        toggleOneBtn.setEffect(pressed);
        toggleTwoBtn.setEffect(unpressed);
        toggleThreeBtn.setEffect(unpressed);
        toggleFourBtn.setEffect(unpressed);
    }

    public void toggleTwo(ActionEvent event) {
        toggleOneBtn.setSelected(false);
        toggleThreeBtn.setSelected(false);
        toggleTwoBtn.setSelected(false);
        if (!(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING))
            mediaPlayer.play();
        else
            toggleFourBtn.setSelected(true);
        mediaPlayer.setVolume(0.125D);

        toggleOneBtn.setEffect(unpressed);
        toggleTwoBtn.setEffect(pressed);
        toggleThreeBtn.setEffect(unpressed);
        toggleFourBtn.setEffect(unpressed);
    }

    public void toggleThree(ActionEvent event) {
        toggleOneBtn.setSelected(false);
        toggleTwoBtn.setSelected(false);
        toggleFourBtn.setSelected(false);
        if (!(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING))
            mediaPlayer.play();
        else
            toggleThreeBtn.setSelected(true);
        mediaPlayer.setVolume(0.1875D);

        toggleOneBtn.setEffect(unpressed);
        toggleTwoBtn.setEffect(unpressed);
        toggleThreeBtn.setEffect(pressed);
        toggleFourBtn.setEffect(unpressed);
    }

    public void toggleFour(ActionEvent event) {

        toggleOneBtn.setSelected(false);
        toggleTwoBtn.setSelected(false);
        toggleThreeBtn.setSelected(false);
        if (!(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING))
            mediaPlayer.play();
        else
            toggleFourBtn.setSelected(true);
        mediaPlayer.setVolume(0.25D);

        toggleOneBtn.setEffect(unpressed);
        toggleTwoBtn.setEffect(unpressed);
        toggleThreeBtn.setEffect(unpressed);
        toggleFourBtn.setEffect(pressed);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        unpressed = new DropShadow(BlurType.GAUSSIAN, Color.rgb(217, 217, 217, 1.0D), 15.0D, 0.5D, 0.0D, 0.0D);
        pressed = new InnerShadow(BlurType.GAUSSIAN, Color.rgb(217, 217, 217, 1.0D), 15.0D, 0.5D, 0.0D, 0.0D);
        close.setStyle("-fx-background-radius:50;-fx-background-color:#FFF");
        toggleOneBtn.setStyle("-fx-background-radius:50;-fx-background-color:#FFF");
        toggleTwoBtn.setStyle("-fx-background-radius:50;-fx-background-color:#FFF");
        toggleThreeBtn.setStyle("-fx-background-radius:50;-fx-background-color:#FFF");
        toggleFourBtn.setStyle("-fx-background-radius:50;-fx-background-color:#FFF");
        close.setEffect(unpressed);
        toggleOneBtn.setEffect(unpressed);
        toggleTwoBtn.setEffect(unpressed);
        toggleThreeBtn.setEffect(unpressed);
        toggleFourBtn.setEffect(unpressed);


        try {
            fanSound = new Media(Objects.requireNonNull(getClass().getResource("sound/fan_noise.mp3")).toURI().toString());
            mediaPlayer = new MediaPlayer(fanSound);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}