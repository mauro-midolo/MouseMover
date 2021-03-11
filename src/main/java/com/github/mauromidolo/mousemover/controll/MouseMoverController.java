package com.github.mauromidolo.mousemover.controll;

/**
 * MouseMoverController: controller to manager MouseMoverManager thread
 */
public class MouseMoverController {

    private static MouseMoverController mouseMoverController;
    private MouseMoverManager thread;

    /**
     * Singleton instance
     *
     * @return MouseMoverController instance
     */
    public static MouseMoverController getInstance() {
        if (mouseMoverController == null) {
            mouseMoverController = new MouseMoverController();
        }
        return mouseMoverController;
    }

    private MouseMoverController() {
    }

    /**
     * start the background job, if the job is already in exertion stop and restart
     *
     * @param value seconds to move mouse
     */
    public void switchOn(int value) {
        if (thread != null) {
            thread.stop();
        }
        thread = new MouseMoverManager(value);
        thread.start();
    }

    /**
     * stop the background job
     *
     */
    public void switchOff() {
        if (thread != null) {
            thread.stop();
        }
        thread = null;
    }
}
