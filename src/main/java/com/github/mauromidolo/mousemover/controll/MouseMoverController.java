package com.github.mauromidolo.mousemover.controll;

public class MouseMoverController {
    private static MouseMoverController mouseMoverController;
    private MouseMoverManager thread;

    public static MouseMoverController getInstance() {
        if (mouseMoverController == null) {
            mouseMoverController = new MouseMoverController();
        }
        return mouseMoverController;
    }

    private MouseMoverController() {
    }

    public void switchOn(int value) {
        if (thread != null) {
            thread.stop();
        }
        thread = new MouseMoverManager(value);
        thread.start();
    }

    public void switchOff() {
        if (thread != null) {
            thread.stop();
        }
        thread = null;
    }
}
