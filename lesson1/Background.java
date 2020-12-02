package lesson1;

import java.awt.*;
import java.util.Random;

public class Background extends Thread {

    public  GameCanvas canvas;
    public  int deltaTime = 5000;

    @Override
    public void run() {
        while (true) {
            Random rnd = new Random();
            try {
                Thread.sleep(deltaTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            canvas.setBackground(new Color(rnd.nextInt()));
        }
    }

//
    Background(GameCanvas canvas) {
         this.canvas = canvas;
    }


}
