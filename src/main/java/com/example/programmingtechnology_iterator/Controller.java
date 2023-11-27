package com.example.programmingtechnology_iterator;

import items.Meme;
import items.MemeBuilder;
import items.MemeDirector;
import iterator.ConcreteAggregate;
import iterator.infastructure.Iterator;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Iterator iterator;
    private MemeDirector memeDirector;
    private MemeBuilder builder;
    private Meme meme;
    private FadeTransition fade;
    private Timeline timeline;
    @FXML
    private BorderPane borderPane;
    @FXML
    ImageView imagePhoto;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline = new Timeline(new KeyFrame(new Duration(2000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                forward_Button(); setFadeStackOptions();
            }
        }));

        fade = new FadeTransition();
        ConcreteAggregate slides = new ConcreteAggregate();
        iterator = slides.createIterator();
        timeline.setCycleCount(Timeline.INDEFINITE);
        forward_Button();
    }
    @FXML
    public void back_Button() {
        builder = new MemeBuilder();

        var item = (Image)iterator.preview();
        memeDirector = new MemeDirector(item);

        meme = memeDirector.Construct(builder);

        borderPane.setCenter(meme.getPanel());
    }
    @FXML
    public void forward_Button() {
        builder = new MemeBuilder();

        var item = (Image)iterator.next();
        memeDirector = new MemeDirector(item);

        meme = memeDirector.Construct(builder);

        borderPane.setCenter(meme.getPanel());
    }

    public void startLoop_Button(ActionEvent actionEvent) {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        setFadeStackOptions();
    }

    private void setFadeStackOptions(){
        fade.setNode(this.meme.getPanel());
        fade.setCycleCount(1);
        fade.setDuration(new Duration(1950));
        fade.setFromValue(1.0);
        fade.setToValue(0.0); fade.play();
    }

    public void endLoop_Button(ActionEvent actionEvent) {
        timeline.stop(); fade.stop();
    }
}
