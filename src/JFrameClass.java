import javax.swing.*;

public class JFrameClass {
    public static void activateJFrame() {
        JFrame w = new JFrame();
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setResizable(false);
        w.setTitle("Escape: Level Zero (Kind of Unfinished)");

        GamePanel gamePanel = new GamePanel();
        w.add(gamePanel);

        w.pack();

        w.setLocationRelativeTo(null);
        w.setVisible(true);

        gamePanel.startGameThread();
    }
}
