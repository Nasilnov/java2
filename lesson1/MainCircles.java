package lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {

    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final int START_BALL = 3;

    Sprite[] sprites = new Sprite[100];


//    public static void main(String[] args) {
//        new MainCircles();
//    }

    MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        GameCanvas canvas = new GameCanvas(this);
        Background background = new Background(canvas);
        Thread back = new Thread(background);
        back.start();
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
//                int x = e.getX();
//                int y = e.getY();
                if ( e.getButton() == MouseEvent.BUTTON3 ) {
                    addApplication();
                }
                if ( e.getButton() == MouseEvent.BUTTON1 ) {
                    delApplication();
                }

            }
        });

        initApplication();
        add(canvas);
        setVisible(true);
    }

    private void addApplication() {
        for (int i = sprites.length - 1; i >= 0; i--) {
            if (sprites[i] != null) {
                sprites[i] = null;
                break;
            }
        }
    }

    private void delApplication() {
        for (int i = 0; i < sprites.length; i++) {
            if (sprites[i] == null) {
                sprites[i] = new Ball();
                break;
            }
        }
    }

    private void initApplication() {
        for (int i = 0; i < START_BALL; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            if (sprites[i] != null)  {
                sprites[i].update(canvas, deltaTime);
            }
            else {
                break;
            }
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            if (sprites[i] != null)  {
                sprites[i].render(canvas, g);
            }
            else {
                break;
            }
        }
    }
}