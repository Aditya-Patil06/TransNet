package screensetting;
import myUtility.*;
import java.awt.*;
import javax.swing.*;
import appsetting.*;
import animation.*;

public class MenuDesign extends JPanel
{
    private JPanel pnlMain;
    private JPanel pnlTop;
    private JPanel pnlBottom;
    private JPanel pnlSlider;
    private JButton btnScroll;

    public MenuDesign()
    {
        setVisible(true);
        setSize(1920, 1080);
        setLayout(null);

        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setSize(1920, 1080);
        pnlMain.setBackground(Color.RED);
        add(pnlMain);

        String topImagePath = "D:/Aditya_Project_TransNet/Truck/menu_image_2.jpg";
        pnlTop = ImagePanel.getPanel(topImagePath);
        // Alternative: pnlTop = createPanel(0, 0, 1920, 930, new Color(40, 40, 40));
        pnlTop.setBounds(0, 0, 1920, 930);
        pnlTop.setLayout(null);
        pnlMain.add(pnlTop);

        pnlBottom = createPanel(0, 931, 1920, 60, Color.BLACK);
        pnlMain.add(pnlBottom);

        pnlSlider = createPanel(550, 920, 820, 10, new Color(50, 50, 50).darker());
        pnlTop.add(pnlSlider);

        btnScroll = new JButton("Scroll");
        btnScroll.setBounds(50, 5, 40, 30);
        pnlBottom.add(btnScroll);

        setColors();
        setDefaultSetting();
    }

    private JPanel createPanel(int x, int y, int width, int height, Color color)
    {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setBackground(color);
        panel.setLayout(null);
        return panel;
    }

    private void setColors()
    {
        pnlMain.setBackground(ColorSetting.getBackColorMainPnl());
        pnlTop.setBackground(new Color(40, 40, 40));
        pnlBottom.setBackground(ColorSetting.getBackColorBottomPnl());
        pnlSlider.setBackground(new Color(50, 50, 50).darker());
        btnScroll.setBackground(ColorSetting.getBackColorButton());
    }

    private void setDefaultSetting()
    {
        PanelState.enabledComponents(pnlBottom);
    }

    public JPanel getMainPanel() {
        return pnlMain;
    }

    public JPanel getTopPanel() {
        return pnlTop;
    }

    public JPanel getBottomPanel() {
        return pnlBottom;
    }

    public JPanel getSliderPanel() {
        return pnlSlider;
    }

    public JButton getScrollButton() {
        return btnScroll;
    }

}