package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    final int FPS = 60;
    Thread gameThread;
    PlayManager pm;

    public GamePanel() {

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        //KeyListener
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);

        pm = new PlayManager();

    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        //Game Loop
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / FPS;
        double delta = 0;

        while (gameThread.isAlive()) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                update(); // Update the game logic
                repaint();
                delta--;
            }
        }
    }

    private void update() {
        pm.update();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the game here using the Graphics object
        Graphics2D g2 = (Graphics2D) g;
        pm.draw(g2);
    }
}
