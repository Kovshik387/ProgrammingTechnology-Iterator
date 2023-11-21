package com.example.programmingtechnology_iterator;

import items.Meme;
import items.MemeBuilder;
import items.MemeDirector;
import iterator.ConcreteAggregate;
import iterator.infastructure.Iterator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Iterator iterator;
    private MemeDirector memeDirector;

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
        //Получение
        memeDirector.setImage((Image)iterator.preview());
        //Конкретная реализация builder'а
        MemeBuilder builder = new MemeBuilder();
        //Объект, который должен быть создан
        Meme meme = memeDirector.Construct(builder);
        //Отображение полученного объекта
        borderPane.setCenter(meme.getPanel());
    }
    @FXML
    public void forward_Button() {
        //Получение
        memeDirector.setImage((Image)iterator.next());
        //Конкретная реализация builder'а
        MemeBuilder builder = new MemeBuilder();
        //Объект, который должен быть создан
        Meme meme = memeDirector.Construct(builder);
        //Отображение полученного объекта
        borderPane.setCenter(meme.getPanel());
    }

}
