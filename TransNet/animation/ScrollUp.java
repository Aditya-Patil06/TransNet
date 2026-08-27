package animation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScrollUp
{
    public static void scrollUpside(JPanel pnlScroll, int LevelFromTop, int speed)
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
                if (YValue >= LevelFromTop)
                {
                    YValue -= step;
                    HValue += step;
                    pnlScroll.setLocation(XValue, YValue);
                    pnlScroll.setSize(WValue, HValue);
                }
                else
                {
					YValue = LevelFromTop;
                    pnlScroll.setLocation(XValue, YValue);
                    ((Timer) e.getSource()).stop();
                 }
            }
        });

        timer.start();
    }
}