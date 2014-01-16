package control;


import ui.ImagePanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ApplicationFrame extends JFrame {
    
    private ActionListenerFactory factory;
    private ImagePanel imagePanel;

    public ApplicationFrame(ActionListenerFactory factory) {
        super("Image Browser");
        this.setSize(1024, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.factory = factory;
        this.createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(createImagePanel());
        this.add(createToolbar(), BorderLayout.SOUTH);
    }
    
    private JPanel createImagePanel() {
        imagePanel = new ImagePanel();
        return imagePanel;
    }
    
    private Component createToolbar() {
        JPanel panel = new JPanel();
        panel.add(createPrevButton());
        panel.add(createNextButton());
        return panel;
    }
    private JButton createNextButton() {
        JButton button = new JButton("Next");
        button.addActionListener(factory.createActionListener("next"));
        return button;
    }

    private JButton createPrevButton() {
        JButton button = new JButton("Prev");
        button.addActionListener(factory.createActionListener("prev"));
        return button;
    }

    public ImagePanel getImagePanel() {
        return imagePanel;
    }

}
