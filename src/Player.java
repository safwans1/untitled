import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Player extends This{
    public int x;
    public int y;
    public int speed;
    GamePanel gamePanel;
    KeyHandler keyHandler;
    public int width;
    public String action;
    public BufferedImage[] idle;
    public BufferedImage[] run;
    public BufferedImage[] punchA;
    public BufferedImage[][] all;
    public Mechanism hit;

    public Player(int x, int y, int speed, GamePanel gamePanel, KeyHandler keyHandler,int width){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        this.width = width - 160;
        this.action = super.action;
        idle = new BufferedImage[4];
        run = new BufferedImage[4];
        punchA = new BufferedImage[4];
        all = new BufferedImage[3][4];
        for (int i = 0; i < all.length - 1; i++) {
            if (i == 0){
                all[i] = idle;
            }
            else if (i == 1){
                all[i] = run;
            }
            else if (i == 2){
                all[i] = punchA;
            }
        }
        getPlayerImages();
        hit = new Mechanism();
    }

    public void getPlayerImages(){
        try{
            idle1 = ImageIO.read(getClass().getResourceAsStream("/guy0/guy/idles0001.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/guy0/guy/idles0002.png"));
            all[0][0] = idle1;
            all[0][1] = idle1;
            all[0][2] = idle2;
            all[0][3] = idle2;

            run1 = ImageIO.read(getClass().getResourceAsStream("/guy0/guy/runs0001.png"));
            run2 = ImageIO.read(getClass().getResourceAsStream("/guy0/guy/runs0002.png"));
            run3 = ImageIO.read(getClass().getResourceAsStream("/guy0/guy/runs0003.png"));
            run4 = ImageIO.read(getClass().getResourceAsStream("/guy0/guy/runs0004.png"));
            all[1][0] = run1;
            all[1][1] = run2;
            all[1][2] = run3;
            all[1][3] = run4;

            punchA1 = ImageIO.read(getClass().getResourceAsStream("/guy0/guy/punchAs0001.png"));
            punchA2 = ImageIO.read(getClass().getResourceAsStream("/guy0/guy/punchAs0002.png"));
            punchA3 = ImageIO.read(getClass().getResourceAsStream("/guy0/guy/punchAs0003.png"));
            punchA4 = ImageIO.read(getClass().getResourceAsStream("/guy0/guy/punchAs0004.png"));
            all[2][2] = punchA1;
            all[2][3] = punchA2;
            all[2][0] = punchA3;
            all[2][1] = punchA4;
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if (keyHandler.leftP || keyHandler.rightP || keyHandler.xP) {
            if (keyHandler.leftP) {
                if (x > -40) {
                    action = "run";
                    x -= speed;
                }
            } else if (keyHandler.rightP) {
                if (x < width) {
                    action = "run";
                    x += speed;
                }
            } else if (keyHandler.xP) {
                action = "punch";
            }

            spriteCounter++;
            if(spriteCounter > 0){
                if (spriteIdx == 1){
                    spriteIdx = 2;
                }
                else if (spriteIdx == 2){
                    spriteIdx = 3;
                }
                else if (spriteIdx == 3){
                    spriteIdx = 4;
                }
                else if (spriteIdx == 4){
                    spriteIdx = 1;
                }
                spriteCounter = 0;
            }
        } else {
            action = "idle";
            spriteCounter++;
            if(spriteCounter > 0){
                if (spriteIdx == 1){
                    spriteIdx = 2;
                }
                else if (spriteIdx == 2){
                    spriteIdx = 3;
                }
                else if (spriteIdx == 3){
                    spriteIdx = 4;
                }
                else if (spriteIdx == 4){
                    spriteIdx = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;

        switch (action){
            case "idle":
                for (int i = 1; i <= 4; i++) {
                    if (spriteIdx == i){
                        image = all[0][i - 1];
                    }
                }
                break;
            case "run":
                for (int i = 1; i <= 4; i++) {
                    if (spriteIdx == i){
                        image = all[1][i - 1];
                    }
                }
                break;
            case "punch":
                for (int i = 1; i <= 4; i++) {
                    if (spriteIdx == i){
                        image = all[2][i - 1];
                    }
                    if (spriteIdx == 1 && x >= width){
                        hit.add();
                    }
                }
                break;
        }

        g2.drawImage(image,x,y,160,160, null);
    }
}
