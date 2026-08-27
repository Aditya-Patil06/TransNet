import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import myUtility.*;
import roundcomponents.*;

public class LoginFrame extends JFrame implements ActionListener
{
    JTextField usernameField;
    JPasswordField passwordField;

    JLabel lblRight;
    JLabel usernameLabel;
    JLabel passwordLabel;

    JPanel pnlLeft;
    JPanel pnlRight;
    JButton loginButton;

    IndexFrame previousFrame;

    public LoginFrame(IndexFrame previousFrame)
    {
        this.previousFrame = previousFrame;

        setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        pnlLeft = new JPanel();
        pnlLeft.setBounds(0, 0, 960, 1080);
        pnlLeft.setBackground(Color.BLACK);
        add(pnlLeft);

        String[] imagePaths =
                {
                        "Images/index_image_1.jpg",
                        "Images/index_image_2.jpg",
                        "Images/index_image_3.jpg",
                        "Images/index_image_4.jpg",
                        "Images/index_image_5.jpg",
                        "Images/index_image_6.png",
                        "Images/index_image_7.png",
                        "Images/index_image_8.png",
                        "Images/index_image_9.png",
                        "Images/index_image_10.png",
                        "Images/index_image_11.png",
                        "Images/index_image_12.jpg",
                        "Images/index_image_13.jpg",
                        "Images/index_image_14.jpg",
                };

        JPanel bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.setPreferredSize(new Dimension(960, 1080));

        ImageBanner imageBanner = new ImageBanner(imagePaths, bannerPanel);
        bannerPanel.add(imageBanner, BorderLayout.CENTER);

        pnlLeft.add(bannerPanel);

        pnlRight = new JPanel();
        pnlRight.setBounds(960, 0, 960, 1080);
        pnlRight.setBackground(Color.WHITE);
        pnlRight.setLayout(null);
        add(pnlRight);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(300, 300, 100, 30);
        usernameLabel.setForeground(Color.WHITE);
        pnlRight.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(400, 300, 200, 30);
        pnlRight.add(usernameField);
        RoundedPanel.createRoundedTextField(usernameField, 15);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(300, 350, 100, 30);
        passwordLabel.setForeground(Color.WHITE);
        pnlRight.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(400, 350, 200, 30);
        pnlRight.add(passwordField);
        RoundedPanel.createRoundedPasswordField(passwordField, 15);

        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0, 120, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 12));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        loginButton.setBounds(400, 400, 100, 30);
        loginButton.addActionListener(this);
        pnlRight.add(loginButton);
        RoundedPanel.createRoundedButton(loginButton, 20);

        lblRight = new JLabel(new ImageIcon("Images/Login1.jpg"));
        lblRight.setBounds(0, 0, 960, 1080);
        pnlRight.add(lblRight);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == loginButton)
        {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") || password.equals("123"))
            {
                new MenuFrame();

                if (previousFrame != null)
                {
                    previousFrame.dispose();
                }

                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect Login ID or Password");
            }
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new LoginFrame(null));
    }
}