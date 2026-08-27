import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mediafacility.*;
import roundcomponents.*;

public class IndexFrame extends JFrame
{
    private JButton loginButton;
    private Timer vibrationTimer;
    private int vibrationDirection = 1;
    private int vibrationOffset = 0;

    public IndexFrame()
    {
        setTitle("Index Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);


        String mVideoFilePath="C:\\Users\\HP\\Downloads\\videoplayback.mp4";

        JPanel bannerPanel = new JPanel();
        bannerPanel.setLayout(null);
        bannerPanel.setBounds(0,0,1920,1080);
        add(bannerPanel);
        MediaPlayerFacility.playMediaPlayerFile(bannerPanel,mVideoFilePath);

        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0, 120, 255 , 180));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        loginButton.setPreferredSize(new Dimension(250, 150));
        RoundedPanel.createRoundedButton(loginButton, 40);


        int buttonX = 1700;
        int buttonY = 20;
        loginButton.setBounds(buttonX, buttonY, 150, 50);

        JLayeredPane layeredPane = getLayeredPane();
        layeredPane.add(bannerPanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(loginButton, JLayeredPane.PALETTE_LAYER);

        vibrationTimer = new Timer(50, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
				 if (!loginButton.getModel().isPressed())
                {

                    vibrationOffset += 2 * vibrationDirection;
                    if (Math.abs(vibrationOffset) >= 10)
                    {
						vibrationDirection *= -1;
                    }
                    loginButton.setLocation(buttonX + vibrationOffset, buttonY);
                }
                else
                {

                    vibrationOffset = 0;
                    loginButton.setLocation(buttonX, buttonY);
                }
                loginButton.repaint();
            }
        });
        vibrationTimer.start();

        loginButton.addActionListener(new ActionListener()
        {
		    public void actionPerformed(ActionEvent e)
		    {
		        vibrationTimer.stop();
		        vibrationOffset = 0;
		        loginButton.setLocation(buttonX, buttonY);
				new LoginFrame(IndexFrame.this);
			}
		});
        add(bannerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new IndexFrame());
    }
}