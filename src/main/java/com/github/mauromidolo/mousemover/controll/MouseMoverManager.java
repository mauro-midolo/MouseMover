package com.github.mauromidolo.mousemover.controll;

import java.awt.*;
import java.util.Random;

/**
 * MouseMoverManager: Runnable to move mouse automatically
 */
public class MouseMoverManager implements Runnable {
    private final int seconds;
    private boolean run;
    /**
     * Construct
     *
     * @param seconds number of seconds to move mouse
     */
    protected MouseMoverManager(int seconds) {
        this.seconds = seconds;
        run = true;
    }

    /**
     * start the Runnable
     */
    protected void start() {
        Thread worker = new Thread(this);
        worker.start();
    }

    /**
     * stop the Runnable
     */
    protected void stop() {
        run = false;
    }

    @Override
    public void run() {
        while (run) {
            try {
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                double width = screenSize.getWidth();
                double height = screenSize.getHeight();
                Robot robot = new Robot();
                Random random = new Random();
                robot.mouseMove(random.nextInt((int) width), random.nextInt((int) height));
                Thread.sleep(seconds * 1000L);
            } catch (Exception ignored) {
            }
        }
    }

}
