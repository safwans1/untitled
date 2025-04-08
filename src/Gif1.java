import javax.swing.*;
import javax.net.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;


public class Gif1 extends JFrame{
    private ImageIcon image2;
    private JLabel label2;

    public Gif1(){
        image2 = new ImageIcon("C:\\Users\\safwa\\IdeaProjects\\NewProjects\\src\\winLazy.gif");
        label2 = new JLabel(image2);
        add(label2);
    }


}