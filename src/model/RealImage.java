package model;


import model.Dimension;
import model.Image;
import java.awt.image.BufferedImage;


public class RealImage implements Image {
    
    private Dimension dimension;
    private BufferedImage image;

    
    public RealImage(BufferedImage image) {
        this.image = image;
    }


    @Override
    public Image getNext() {
        return null;
    }

    @Override
    public Image getPrev() {
        return null;
    }

    @Override
    public void setNext(Image image) {
    }

    @Override
    public void setPrev(Image image) {
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public Dimension getDimension() {
        return dimension;
    }
}
