package model;


import java.awt.image.BufferedImage;


public interface Image {

    public BufferedImage getImage();
   
    public Image getNext();
    public Image getPrev();
    
    public void setNext(Image image);
    public void setPrev(Image image);
    
    public Dimension getDimension();
}
