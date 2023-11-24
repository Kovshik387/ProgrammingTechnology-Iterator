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
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Iterator iterator;
    private MemeDirector memeDirector;
    private MemeBuilder builder;
    private Timeline timeline;
    @FXML
    private BorderPane borderPane;
    @FXML
    ImageView imagePhoto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline = new Timeline(new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                forward_Button();
            }
        }));

        ConcreteAggregate slides = new ConcreteAggregate();
        iterator = slides.createIterator();

        //распорядитель
        memeDirector = new MemeDirector();
        //Получение
        memeDirector.setImage((Image)iterator.next());

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    @FXML
    public void back_Button() {
        builder = new MemeBuilder();
        memeDirector = new MemeDirector();
        var item = (Image)iterator.preview();
        //Получение
        memeDirector.setImage(item);
        //Конкретная реализация builder'а
        //Объект, который должен быть создан
        Meme meme = memeDirector.Construct(builder);
        //Отображение полученного объекта
        borderPane.setCenter(meme.getPanel());
    }
    @FXML
    public void forward_Button() {
        builder = new MemeBuilder();
        memeDirector = new MemeDirector();

        var item = (Image)iterator.next();
        //Получение
        memeDirector.setImage(item);
        FadeTransition ft = new FadeTransition();
        //Конкретная реализация builder'а
        //Объект, который должен быть создан
        Meme meme = memeDirector.Construct(builder);
        //Отображение полученного объекта
        borderPane.setCenter(meme.getPanel());

        ft.setNode(meme.getPanel());
        ft.setDuration(new Duration(2000));
        ft.setFromValue(1.0); ft.setToValue(0.0);
        ft.setCycleCount(6); ft.play();
    }

    public void startLoop_Button(ActionEvent actionEvent) {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void endLoop_Button(ActionEvent actionEvent) {
        timeline.stop();
    }
}
