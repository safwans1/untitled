import javax.swing.*;
import java.util.*;
public class Main {
    public static void main(String [] args) {
        Mechanism ges = new Mechanism();
        ges.polymorphize();
        ges.intro();
        System.out.println("Before we carry on...");
        ges.guessMachine();
        ges.Test();
    }
}
