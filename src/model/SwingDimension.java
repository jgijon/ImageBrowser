package model;

import java.awt.image.BufferedImage;

public class SwingDimension implements Dimension {
    
    private BufferedImage bufferedImage;

    public SwingDimension(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    @Override
    public int getWidth() {
        return bufferedImage.getWidth();
    }

    @Override
    public int getHeight() {
        return bufferedImage.getHeight();
    }
    
    

}
