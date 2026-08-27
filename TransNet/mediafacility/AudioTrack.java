package audiofacility ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class AudioTrack{

    public static void playAudioTrack(String sound) {
        try {
            File soundFile = new File(sound);

            new Thread(() -> {
                try {
                    FileInputStream fis = new FileInputStream(soundFile);
                    Player player = new Player(fis);
                    player.play();
                    fis.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }).start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[])
    {
		AudioTrack.playAudioTrack("D:\\Aditya_Project_TransNet\\audiofacility\\AaryaVoice.mp3");
		AudioTrack.playAudioTrack("D:\\Aditya_Project_TransNet\\audiofacility\\nayanVoice.mp3");
	}
}