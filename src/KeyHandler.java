import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean leftP;
    public boolean rightP;
    public boolean xP;

    @Override
    public void keyTyped(KeyEvent e){
    }

    @Override
    public void keyPressed(KeyEvent e){
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT){
            leftP = true;
        }
        if (c == KeyEvent.VK_RIGHT){
            rightP = true;
        }
        if (c == KeyEvent.VK_X){
            xP = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT){
            leftP = false;
        }
        if (c == KeyEvent.VK_RIGHT){
            rightP = false;
        }
        if (c == KeyEvent.VK_X){
            xP = false;
        }
    }
}
