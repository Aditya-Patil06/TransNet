package animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScrollDown
{
    public static void scrollDownside(JPanel pnlScroll, int targetYPosition, int speed)
    {
        Dimension d = pnlScroll.getSize();
        Point p = pnlScroll.getLocation();

        Timer timer = new Timer(speed, new ActionListener()
        {
            int XValue = (int) p.getX();
            int YValue = (int) p.getY();
            int WValue = (int) d.getWidth();
            int HValue = (int) d.getHeight();
            int step = 120;

            public void actionPerformed(ActionEvent e)
            {
                if (YValue <= targetYPosition)
                {
                    YValue += step;
                    pnlScroll.setLocation(XValue, YValue);
                }
                else
                {
                    YValue = targetYPosition;
                    pnlScroll.setLocation(XValue, YValue);
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        timer.start();
    }
}
