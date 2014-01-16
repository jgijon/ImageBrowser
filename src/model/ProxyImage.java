package model;


import java.awt.image.BufferedImage;
import persistence.ImageLoader;


public class ProxyImage implements Image {
    
    private ImageLoader loader;
    private Image next;
    private Image prev;
    private Image realImage;

    public ProxyImage(ImageLoader loader) {
        this.loader = loader;
    }

    @Override
    public Dimension getDimension() {
        checkLoaded();
        return realImage.getDimension();
    }

    @Override
    public Image getNext() {
        return next;
    }

    @Override
    public Image getPrev() {
        return prev;
    }

    @Override
    public void setNext(Image image) {
        this.next = image;
    }

    @Override
    public void setPrev(Image image) {
        this.prev = image;
    }

    private void checkLoaded() {
        if (realImage != null) return;
        realImage = new RealImage(loader.load());
    }

    @Override
    public BufferedImage getImage() {
        checkLoaded();
        return realImage.getImage();
    }

}
