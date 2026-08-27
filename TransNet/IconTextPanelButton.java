import javax.swing.*;
import java.awt.*;
import roundcomponents.RoundedPanel;

public class IconTextPanelButton extends JButton {
    private JLabel iconLabel;
    private JLabel textLabel;
    private String text;

    public IconTextPanelButton(ImageIcon icon, String text) {
        this.text = text;
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        setBackground(new Color(60, 60, 60));
        setPreferredSize(new Dimension(280, 60));
        setContentAreaFilled(false);
        setBorderPainted(false);

        iconLabel = new JLabel(icon);
        add(iconLabel);

        textLabel = new JLabel(text);
        textLabel.setForeground(Color.WHITE);

        Font customFont = new Font("Arial", Font.BOLD, 16);
        textLabel.setFont(customFont);

        add(textLabel);

        RoundedPanel.createRoundedButton(this, 30);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Custom painting if needed
    }
}
