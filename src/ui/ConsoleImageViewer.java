package ui;

import model.Image;


public class ConsoleImageViewer implements ImageViewer {

    private Image image;
    
    @Override
    public void refresh() {
        System.out.print(getImage().getDimension().getWidth());
        System.out.print("x");
        System.out.print(getImage().getDimension().getHeight());
        System.out.println("");
    }

    @Override
    public Image getImage() {
        return image;
    }
    @Override
    public void setImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
