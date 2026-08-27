package myUtility;

import javax.swing.*;
import java.awt.*;

public class ImagePanel
{
    public static JPanel getPanel(String imgPath)
    {
        Image backgroundImage = new ImageIcon(imgPath).getImage();

        JPanel myPanel = new JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        return myPanel;
    }
}