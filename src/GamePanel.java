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
        double drawInterval = nsInOneSec / shutterSpeed;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null){
            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;

                if (remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
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
