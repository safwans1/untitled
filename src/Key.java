public class Key {
    private boolean guessd;

    public Key (boolean g){
        guessd = g;
    }

    public void outcome(){
        if (guessd){
            JFrameClass.activateJFrame();
            System.out.println("It was x. Use that keybind to punch your way out of a wall. (Hint: go to the rightmost area of the screen)");
        } else {
            System.out.println("It was x. But now the key won't work, you're stuck here until you end the program");
        }
    }
}
