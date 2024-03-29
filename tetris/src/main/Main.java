package main;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

    JFrame window = new JFrame("Tetris");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    GamePanel gp = new GamePanel();
    window.add(gp);
    window.pack();

    window.setResizable(false);
    window.setLocationRelativeTo(null);
    window.setVisible((true));

    gp.launchGame();
    }
}
