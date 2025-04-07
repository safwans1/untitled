import javax.swing.*;
import java.awt.*;
public class GamePanel extends JPanel implements Runnable{
    final int screenWidth = 750;
    final int screenHeight = 250;

    int x = 100;
    int y = 110;
    int speed = 16;

    final int nsInOneSec = 1000000000;
    int shutterSpeed = 20;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    Player player = new Player(x,y,speed,this, keyHandler, screenWidth);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double DI = nsInOneSec / shutterSpeed;
        double NDT = System.nanoTime() + DI;

        while (gameThread != null){
            update();
            repaint();

            try {
                double remaining = NDT - System.nanoTime();
                remaining /= 1000000;

                if (remaining < 0){
                    remaining = 0;
                }

                Thread.sleep((long) remaining);
                NDT += DI;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        player.draw(g2);
        g2.dispose();
    }
}
