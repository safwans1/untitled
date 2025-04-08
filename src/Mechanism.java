import javax.swing.*;
import java.util.Scanner;
import java.util.*;

public class Mechanism {
    private boolean guessed = false;
    private int tries = 0;
    private int triesLeft = 3;
    private String lobobob = "x";
    private Key g;
    Scanner scan = new Scanner(System.in);
    public static int hits = 0;
    private boolean wallBreak = false;

    Gif0 gui0 = new Gif0();
    ArrayList<JFrame> gifs = new ArrayList<>();

    public void polymorphize(){
        gifs.add(0, gui0);
    }

    public void intro(){
        gifs.get(0).setVisible(true);
        gifs.get(0).pack();
    }

    public int guessMachine(){
        if (tries < 3) {
            String userInput = "";
            while (tries < 3 && !guessed) {
                System.out.println("Guess the mystery letter >:) (You have 3 tries)");
                userInput = scan.nextLine();
                tries++;
                triesLeft--;
                if (!(userInput.equals(lobobob))) {
                    System.out.println("WRONG! " + triesLeft + " tries left!");
                } else {
                    guessed = true;
                }
            }
        }
        return triesLeft;
    }

    public void Test(){
        Key g = new Key(guessed);
        g.outcome();
    }

    public void add(){
        hits++;
        if (hits == 20){
            check();
        }
    }

    public void check(){
        System.out.println("YOU WIN");
    }

}
