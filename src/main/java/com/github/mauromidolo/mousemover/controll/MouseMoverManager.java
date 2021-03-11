package com.github.mauromidolo.mousemover.controll;

import java.awt.*;
import java.util.Random;

public class MouseMoverManager implements Runnable {
    private final int seconds;
    private boolean run;

    public MouseMoverManager(int seconds) {
        this.seconds = seconds;
        run = true;
    }
    public void start() {
        Thread worker = new Thread(this);
        worker.start();
    }

    public void stop() {
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
