package iterator;

import iterator.infastructure.IAggregate;
import iterator.infastructure.Iterator;
import javafx.scene.image.Image;

import java.nio.file.Paths;

public class ConcreteAggregate implements IAggregate {
    private String fileTopic;
    private Image image;

    public ConcreteAggregate(String fileTopic){
        this.fileTopic = fileTopic;
    }

    @Override
    public Iterator createIterator() {
        return new ImageIterator();
    }

    private class ImageIterator implements Iterator {
        private int current = 0;
        private Image getImage(int iterator){
            return new Image(Paths.get(fileTopic + iterator + ".png").toUri().toString());
        }

        @Override
        public boolean hasNext(int x) {
            return !getImage(current+x).isError();
        }

        @Override
        public Object next() {
            if (this.hasNext(1)){
                return getImage(++current);
            }
            current = 1;
            return getImage(1);
        }

        @Override
        public Object preview() {
            return null;
        }
    }
}
