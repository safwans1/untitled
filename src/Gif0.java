import javax.swing.*;
import javax.net.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Gif0 extends JFrame{
    private ImageIcon image1;
    private JLabel label1;

    public Gif0(){
        image1 = new ImageIcon("C:\\Users\\safwa\\IdeaProjects\\NewProjects\\src\\introToEscapeLvl0.gif");
        label1 = new JLabel(image1);
        add(label1);
    }

}