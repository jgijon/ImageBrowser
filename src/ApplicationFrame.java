
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ApplicationFrame extends JFrame {
    
    private static final String PATH = "C:\\Users\\Public\\Pictures\\Sample Pictures";
    private String[] images = {"desert.jpg", "jellyfish.jpg", "koala.jpg", "penguin.jpg"};
    //private ActionListener[] listeners;
    private int imageIndex = -1;
    private ImagePanel imagePanel;

    public ApplicationFrame() {
        super("Image Browser");
        //this.listeners = listeners;
        this.setSize(1024, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setSize(300, 300);
        //this.setLayout(new FlowLayout());
        this.createComponents();
        drawNextImage();
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(createImagePanel());
        this.add(createToolbar(), BorderLayout.SOUTH);
        //this.add(createButton("Prev"));
        //this.add(createButton("Next"));
    }
    private Component createToolbar() {
        JPanel panel = new JPanel();
        panel.add(createPrevButton());
        panel.add(createNextButton());
        return panel;
    }
    private JButton createNextButton() {
        JButton button = new JButton("Next");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawNextImage();
            }
        });
        return button;
    }

    private JButton createPrevButton() {
        JButton button = new JButton("Prev");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                drawPrevImage();
            }
        });
        return button;
    }

    /*private JButton createButton(String title) {
        JButton button = new JButton(title);
        button.addActionListener(listeners[index++]);
        return button;
    }*/

    private void drawNextImage() {
        imageIndex = (imageIndex + 1) % images.length;
        setCurrentImage(imageIndex);
    }

    private void drawPrevImage() {
        imageIndex = (imageIndex - 1 + images.length) % images.length;
        setCurrentImage(imageIndex);
    }
    
    private void setCurrentImage(int index) {
        imagePanel.setImage(ImageLoader.load(PATH + "/" + images[index]));
    }

    private JPanel createImagePanel() {
        imagePanel = new ImagePanel();
        return imagePanel;
    }


    
}
