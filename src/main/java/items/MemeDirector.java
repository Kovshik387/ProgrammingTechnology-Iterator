package items;

import javafx.scene.image.Image;

public class MemeDirector {
    private Image image;
    public void setImage(Image image){
        this.image = image;
    }

    public Meme Construct(MemeBuilder builder){
        builder.setImage(this.image);
        builder.setDesign();
        builder.setColor();
        builder.setText();
        return builder.build();
    }
}
