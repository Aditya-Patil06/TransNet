package myUtility;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageBanner extends JPanel
{
    private String[] imagePaths;
    private BufferedImage[] images;
    private int currentIndex = 0;
    private int xPosition = 0;
    private int panelWidth = 960;
    private int panelHeight = 1080;
    private Timer timer;
    private boolean isTransitioning = false;
    private boolean imagesLoaded = false;
    private boolean slideFromLeft = true;

    public ImageBanner(String[] imagePaths, JPanel panel)
    {
        this.imagePaths = imagePaths;
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));

        panel.setLayout(new BorderLayout());
        panel.add(this, BorderLayout.CENTER);

        this.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                if (!imagesLoaded && getWidth() > 0 && getHeight() > 0)
                {
                    loadImages();
                    imagesLoaded = true;
                    startBanner();
                }
            }
        });
    }

    private void loadImages()
    {
        images = new BufferedImage[imagePaths.length];
        for (int i = 0; i < imagePaths.length; i++)
        {
            try
            {
                File imageFile = new File(imagePaths[i]);
                if (!imageFile.exists())
                {
                    images[i] = null;
                    continue;
                }
                BufferedImage original = ImageIO.read(imageFile);

                images[i] = new BufferedImage(panelWidth, panelHeight, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = images[i].createGraphics();
                g2d.drawImage(original, 0, 0, panelWidth, panelHeight, null);
                g2d.dispose();

            }
            catch (IOException e)
            {
                e.printStackTrace();
                images[i] = null; // Handle missing images gracefully
            }
        }
    }

    private void startBanner()
    {
        timer = new Timer(50, new ActionListener() // 50ms interval for smooth animation
        {
            private int frameCount = 0;
            private final int stayFrames = 60; // 3 seconds / 0.05 seconds = 60 frames
            private final int transitionFrames = 5; // 0.5 seconds / 0.05 seconds = 10 frames

            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (!isTransitioning) {
                    frameCount++;
                    if (frameCount >= stayFrames)
                    {
                        isTransitioning = true;
                        frameCount = 0;
                        xPosition = slideFromLeft ? -panelWidth : panelWidth;
                    }
                }
                else
                {
                    frameCount++;
                    int step = panelWidth / transitionFrames; // Pixels to move per frame
                    xPosition += slideFromLeft ? step : -step; // Move right if from left, left if from right

                    if (frameCount >= transitionFrames)
                    {
                        isTransitioning = false;
                        frameCount = 0;
                        xPosition = 0;
                        currentIndex = (currentIndex + 1) % images.length;
                        slideFromLeft = !slideFromLeft; // Toggle direction for next transition
                    }
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (images == null || images.length == 0 || !imagesLoaded) return;

        BufferedImage currentImage = images[currentIndex];
        if (currentImage != null)
        {
            g.drawImage(currentImage, xPosition, 0, this);
        }

        if (isTransitioning)
        {
            int nextIndex = (currentIndex + 1) % images.length;
            BufferedImage nextImage = images[nextIndex];
            if (nextImage != null)
            {
                g.drawImage(nextImage, slideFromLeft ? xPosition + panelWidth : xPosition - panelWidth, 0, this);
            }
        }
    }

    public void stopBanner()
    {
        if (timer != null && timer.isRunning())
        {
            timer.stop();
        }
    }
}