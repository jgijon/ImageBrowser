package persistence;

import java.util.List;
import model.Image;

public abstract class ImageListLoader {

    public abstract List<Image> load();
}
