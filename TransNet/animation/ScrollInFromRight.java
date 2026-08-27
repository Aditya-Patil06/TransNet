package animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScrollInFromRight
{
    public static void scrollInFromRight(JPanel pnlScroll, int targetXPosition, int speed)
    {
        Dimension d = pnlScroll.getSize();
        Point p = pnlScroll.getLocation();

        Timer timer = new Timer(speed, new ActionListener()
        {
            int XValue = (int) p.getX();
            int YValue = (int) p.getY();
            int WValue = (int) d.getWidth();
            int HValue = (int) d.getHeight();
            int step = 50;

            public void actionPerformed(ActionEvent e)
            {
                if (XValue > targetXPosition)
                {
                    XValue -= step;
                    pnlScroll.setLocation(XValue, YValue);
                } else
                {
                    XValue = targetXPosition;
                    pnlScroll.setLocation(XValue, YValue);
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        timer.start();
    }
}
