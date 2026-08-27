package myUtility;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScrollLabelLeft extends Thread
{
    JLabel currentLabel;
    JPanel pnlScrollPanel;
    int speed;
    int LabelX;
    int LabelY;
    int LabelWidth;
    int LabelHeight;
    int ResetValue;
    int StartValue;

    public ScrollLabelLeft(JLabel currentLabel, int speed, JPanel pnlScrollPanel)
    {
        this.currentLabel = currentLabel;
        this.pnlScrollPanel = pnlScrollPanel;
        this.speed = speed;
        Dimension parentPanel = pnlScrollPanel.getSize();
        Dimension currentLabelSize = currentLabel.getSize();
        Point currentLabelLocation = currentLabel.getLocation();
        LabelWidth = currentLabelSize.width;
        LabelHeight = currentLabelSize.height;
        LabelY = currentLabelLocation.y;
        StartValue = 0 - LabelWidth; // Start off-screen to the left
        ResetValue = parentPanel.width; // Reset when it goes beyond the right edge
        LabelX = StartValue;

        start();
    }

    public void run() {
        while (true) {
            startScrolling();
        }
    }

    public void startScrolling() {
        try {
            LabelX = LabelX + 1; // Move right by incrementing X

            if (LabelX > ResetValue) { // Check if label has moved beyond the right edge
                LabelX = StartValue; // Reset to off-screen left
            }

            currentLabel.setBounds(LabelX, LabelY, LabelWidth, LabelHeight);
            pnlScrollPanel.repaint(); // Ensure the panel repaints to reflect the new position

            Thread.sleep(speed);
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }
}