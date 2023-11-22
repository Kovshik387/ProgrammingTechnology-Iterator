package com.example.programmingtechnology_iterator;

import items.Meme;
import items.MemeBuilder;
import items.MemeDirector;
import iterator.ConcreteAggregate;
import iterator.infastructure.Iterator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Iterator iterator;
    private MemeDirector memeDirector;
    private MemeBuilder builder;
    @FXML
    private BorderPane borderPane;
    @FXML
    ImageView imagePhoto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ConcreteAggregate slides = new ConcreteAggregate();
        iterator = slides.createIterator();

        //распорядитель
        memeDirector = new MemeDirector();
        //Получение
        memeDirector.setImage((Image)iterator.next());
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
        //Конкретная реализация builder'а
        //Объект, который должен быть создан
        Meme meme = memeDirector.Construct(builder);
        //Отображение полученного объекта
        borderPane.setCenter(meme.getPanel());
    }

}
