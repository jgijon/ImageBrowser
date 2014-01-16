
import control.Command;
import ui.ImageViewer;
import java.awt.event.ActionEvent;


public class PrevImageCommand implements Command {

    private final ImageViewer viewer;
    
    public PrevImageCommand(ImageViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        execute();
    }

    @Override
    public void execute() {
        this.viewer.setImage(this.viewer.getImage().getPrev());
    }
}
