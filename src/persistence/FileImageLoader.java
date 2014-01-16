package persistence;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FileImageLoader implements ImageLoader {
    
    private File file;
    
    public FileImageLoader(String path) {
        this.file = new File(path);
    }

    @Override
    public BufferedImage load() {
        try {
            return ImageIO.read(file);
        } catch (IOException ex) {
            return null;
        }
    }

}
