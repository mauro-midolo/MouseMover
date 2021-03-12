package com.github.mauromidolo.mousemover.view;

import com.github.mauromidolo.mousemover.controll.MouseMoverController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/**
 * Entry class, it's necessary to create the user interface
 */
public class UI {
    /**
     * Main Class
     *
     * @param  args  not used
     */
    public static void main(String[] args)  {
        JFrame frame = new JFrame();
        frame.setTitle("Mouse Mover");
        try {
            frame.setIconImage(ImageIO.read(ClassLoader.getSystemResource( "cursor.png" )));
        } catch (IOException ignored) {}

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.WEST;


        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        JSlider timeoutSlider = new JSlider(JSlider.HORIZONTAL, 1, 50, 30);
        timeoutSlider.setMajorTickSpacing(10);
        timeoutSlider.setMinorTickSpacing(1);
        timeoutSlider.setPaintTicks(true);
        timeoutSlider.setPaintLabels(true);


        panel.add(timeoutSlider, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;


        JButton button = new JButton("Start");

        button.addActionListener(e -> {
            if (button.getText().equals("Start")) {
                MouseMoverController.getInstance().switchOn(timeoutSlider.getValue());
                button.setText("Stop");
            } else {
                button.setText("Start");
                MouseMoverController.getInstance().switchOff();
            }
        });
        timeoutSlider.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }

            @Override
            public void mouseReleased (MouseEvent arg0){
                if (button.getText().equals("Stop")) {
                    MouseMoverController.getInstance().switchOn(timeoutSlider.getValue());
                }
            }
        });
        panel.add(button, gridBagConstraints);

        mainPanel.add(panel);

        frame.add(mainPanel);
        frame.pack();
        frame.setSize(270, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

}