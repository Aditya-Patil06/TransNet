package mediafacility;
import appsetting.*;
import myUtility.*;
import java.awt.*;
import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;

public class MediaPlayerFacility extends JPanel
{
	 JPanel   pnlCenter ;

	public MediaPlayerFacility()
	{
		setSize(1920,1080);
		setLocation(0,0);
		setLayout(null);



		pnlCenter = new JPanel();
		pnlCenter.setBounds(410,185,1100,620);
		pnlCenter.setLayout(null);
		pnlCenter.setBackground(Color.RED);
		//pnlCenter.setBackground(ColorSetting.getBackColorCenterPanel());


		JFXPanel jfxPanel = new JFXPanel();
		jfxPanel.setBounds(0,0,700,700);
		pnlCenter.add(jfxPanel, JLayeredPane.DEFAULT_LAYER);

		Platform.runLater(() -> {
			File videoFile = new File("\"D:/Aditya_Project_TransNet/Images/WhatsApp Video 2025-02-21 at 5.13.05 PM.mp4");
			Media media = new Media(videoFile.toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			MediaView mediaView = new MediaView(mediaPlayer);
			mediaView.setFitWidth(1100);
			mediaView.setFitHeight(620);

			Scene scene = new Scene(new javafx.scene.Group(mediaView));
			jfxPanel.setScene(scene);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			mediaPlayer.play();
		});


		add(pnlCenter);

	}


	public static void playMediaPlayerFile(JPanel pnlVideoPanel, String mVideoFilePath)
	{
		Dimension dimension = pnlVideoPanel.getSize();

		JFXPanel jfxPanel = new JFXPanel();
		jfxPanel.setBounds(0,0,dimension.width,dimension.height);
		pnlVideoPanel.add(jfxPanel, JLayeredPane.DEFAULT_LAYER);

		Platform.runLater(() -> {
			File videoFile = new File(mVideoFilePath);
			Media media = new Media(videoFile.toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			MediaView mediaView = new MediaView(mediaPlayer);
			mediaView.setFitWidth(dimension.width);
			mediaView.setFitHeight(dimension.height);

			Scene scene = new Scene(new javafx.scene.Group(mediaView));
			jfxPanel.setScene(scene);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			mediaPlayer.play();
		});


		//add(pnlCenter);

	}


}