package items;

import items.infastructure.IBuilder;
import iterator.ConcreteAggregate;
import iterator.infastructure.Iterator;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemeBuilder implements IBuilder {
    Meme meme = new Meme();

    private final List<String> jokes = List.of("- Мама, можно я съем морковку?\n" +
            "- Не трожь! Это на Новый год!\n",
            "Дешевым хлебом проще затыкать\nнедовольные рты.\n",
            "Как тут у вас все странно...\n Пожалуй, я останусь!\n",
            "Бесплатное обучение поеданию \nбесплатного сыра!\n Бизнес-курс \"Мышеловка\"!\n",
            "- Колобок, колобок, я тебя съем!",
            "Раньше не верил людям только \nпервого апреля, а теперь всегда.",
            "Сегодня буду говорить людям правду\n а потом смеяться и говорить: \n«С 1 апреля!»"

    );

    @Override
    public void setImage(Image image) {
        this.meme.addImage(image);
    }

    @Override
    public void setText() {
        var text = new Text(jokes.get(new Random().nextInt(0, jokes.size())));
        text.fontProperty().setValue(Font.font("Verdana", FontWeight.BOLD, 12));
        this.meme.addText(text);
    }

    @Override
    public Meme build() {
        return this.meme;
    }
}
