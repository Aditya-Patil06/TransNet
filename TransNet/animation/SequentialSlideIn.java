package animation;

import javax.swing.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SequentialSlideIn
{
    public static void slideInPanels(JPanel[] panels, int targetX, int speed, int delay)
    {
        new Thread(() -> {
            for (int i = 0; i < panels.length; i++) {
                JPanel panel = panels[i];
                Point p = panel.getLocation();
                int startX = (int) p.getX();
                int y = (int) p.getY();
                int w = panel.getWidth();
                int h = panel.getHeight();

                Timer timer = new Timer(speed, new ActionListener()
                {
                    int XValue = startX;
                    int step = (startX < targetX) ? 50 : -50; // Positive step for sliding in, negative for sliding out

                    public void actionPerformed(ActionEvent e)
                    {
                        if (startX < targetX ? XValue < targetX : XValue > targetX) // Check direction
                        {
                            XValue += step;
                            if (startX < targetX && XValue > targetX) XValue = targetX; // Prevent overshooting in
                            if (startX > targetX && XValue < targetX) XValue = targetX; // Prevent overshooting out
                            panel.setLocation(XValue, y);
                        }
                        else
                        {
                            panel.setLocation(targetX, y);
                            ((Timer) e.getSource()).stop();
                        }
                    }
                });

                timer.start();
                try {
                    Thread.sleep(delay); // Delay between each panel's animation
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}