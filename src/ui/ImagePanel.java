package ui;


import model.SwingDimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import model.Image;


public class ImagePanel extends JPanel implements ImageViewer{
    
    private Image image;
    
    private int initalX;
    private int offset;
    
    public ImagePanel(){
        this.offset = 0;
        this.hookEvents();
    }
    
    @Override
    public void setImage(Image image) {
        this.image = image;
        repaint();
    }
    
    @Override
    public Image getImage() {
        return image;
    }
    
    @Override
    public void paint(Graphics graphics) {
        if (image == null) {
            return;
        }
        graphics.clearRect(0,0,this.getWidth(), this.getHeight());
        graphics.drawImage(image.getImage(), offset, 0, null);
        if(offset == 0)
            return;
        if(offset > 0)
            graphics.drawImage(getBufferedImage(image.getNext()), image.getDimension().getWidth() + offset, 0, null);
        else
            graphics.drawImage(getBufferedImage(image.getPrev()), offset - image.getDimension().getWidth(), 0, null);
    }
    
    private BufferedImage getBufferedImage(Image image){
        SwingDimension dimension = (SwingDimension) image.getDimension();
        return dimension.getBufferedImage();
    }


    private void hookEvents() {
        this.hookMouseListener();
        this.hookMouseMotionListener();
    }

    private void hookMouseListener() {
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                System.out.println("clicked" + me.getX());
            }

            @Override
            public void mousePressed(MouseEvent me) {
                System.out.println("pressed" + me.getX());
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                System.out.println("released" + me.getX());
                if(offset > image.getDimension().getWidth() / 2)
                    image = image.getPrev();
                if(offset < -image.getDimension().getWidth() / 2)
                    image = image.getNext();
                offset = 0;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                System.out.println("entered" + me.getX());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("exited");
            }
        });
    }

    private void hookMouseMotionListener() {
        this.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent me) {
                System.out.println("dragging " + me.getX());
                offset = me.getX() - initalX;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                System.out.println("moving" + me.getX());
            }
        });
    }


    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
