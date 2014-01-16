package persistence;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import model.Image;
import model.ProxyImage;

public class FileImageListLoader extends ImageListLoader {
    
    private String path;

    public FileImageListLoader(String path) {
        this.path = path;
    }

    @Override
    public List<Image> load() {
        return linkImages(loadImages());
    }
    
    private List<Image> loadImages() {
        List<Image> list = new ArrayList<>();
        for (String file : new File(path).list()) {
            list.add(new ProxyImage(new FileImageLoader(path + "/" + file)));
        }
        return list;
    }

    private List<Image> linkImages(List<Image> loadImages) {
        for (int i = 0; i < loadImages.size(); i++) {
            Image image = loadImages.get(i);
            image.setNext(loadImages.get(getNextIndex(i, loadImages.size())));
            image.setPrev(loadImages.get(getPrevIndex(i, loadImages.size())));
            
        }
        return loadImages;
    }

    private int getNextIndex(int i, int size) {
        return (i + 1) % size;
    }

    private int getPrevIndex(int i, int size) {
        return (i + size -1) % size;
    }
    
    

}
