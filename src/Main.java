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
    }

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
