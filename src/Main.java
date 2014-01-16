import control.ActionListenerFactory;
import control.ApplicationFrame;
import control.Command;
import control.CommandMap;
import ui.ImageViewer;
import model.Image;
import java.awt.event.ActionListener;
import java.util.List;
import persistence.FileImageListLoader;
import persistence.ImageListLoader;
import ui.ImagePanel;

public class Main {
 
    private static final String PATH = "C:\\Users\\Public\\Pictures\\Sample Pictures";
    private static CommandMap commandMap;
    private ApplicationFrame frame;
    private Image[] images;
    
    public static void main(String[] args) {
        new Main().execute();
    }

    private void execute() {
        ImageListLoader loader = createImageListLoader(PATH);
        List<Image> list = loader.load();
        ceateCommandMap();
        frame = new ApplicationFrame(new ActionListenerFactory(commandMap));
        frame.getImagePanel().setImage(list.get(0));
        //ApplicationFrame aplicaApplicationFrame = new ApplicationFrame();
        //Image[] images = linkImages(createImages());
        //ImageViewer viewer = createImageViewer(images[0]);
        //createApplicationFrame(createCommands(viewer));
    }
        
    /*private Image[] createImages() {
        Image[] images = new Image[5];
        for (int i = 0; i < images.length; i++) {
            //images[i] = createImage(i);
            
        }
        return images;
    }*/

    /*private Image createImage(final int index) {
        final int[] sizes = new int[] {200, 400, 140, 456, 444};
        return new ProxyImage(new ImageLoader() {

            @Override
            public Image load() {
                return new RealImage(new Dimension(sizes[index], sizes[index]));
            }
        });
    }*/

    /*private Image[] linkImages(Image[] images) {
        for (int i = 0; i < images.length; i++) {
            Image image = images[i];
            Image next = images[(i+1) % images.length];
            Image prev = images[(i + images.length - 1) % images.length];
            image.setNext(next);
            image.setPrev(prev);
        }
        return images;
    }

    private ImageViewer createImageViewer(Image image) {
        ImageViewer viewer = new ConsoleImageViewer();
        viewer.setImage(image);
        return viewer;
    }*/
    
    //private ApplicationFrame createApplicationFrame(ActionListener[] listeners) {
        //return new ApplicationFrame(listeners);
    //}

    /*private ActionListener[] createCommands(ImageViewer viewer) {
        return new ActionListener[] {
            new PrevImageCommand(viewer),
            new NextImageCommand(viewer)
        };
    }*/

    private ImageListLoader createImageListLoader(String PATH) {
        return new FileImageListLoader(PATH);
    }

    private void ceateCommandMap() {
        commandMap = new CommandMap();
        
        commandMap.add("next", new Command() {

            @Override
            public void execute() {
                ImagePanel panel = frame.getImagePanel();
                panel.setImage(panel.getImage().getNext());
            }
        });
        
        commandMap.add("prev", new Command() {

            @Override
            public void execute() {
                ImagePanel panel = frame.getImagePanel();
                panel.setImage(panel.getImage().getPrev());
            }
        });
    }

}
