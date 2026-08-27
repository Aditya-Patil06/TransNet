import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sun.speech.freetts.*;  // FreeTTS library - ensure JARs are in your classpath

public class TextToSpeechApp extends JFrame {
    private JTextField textField;
    private JButton speakButton;
    private static final String VOICE_NAME = "kevin16"; // FreeTTS voice
    private Voice voice;

    public TextToSpeechApp() {
        // Set up the frame
        setTitle("Text to Speech Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Initialize components
        textField = new JTextField(20);
        speakButton = new JButton("Speak");

        // Set up the voice
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICE_NAME);
        if (voice != null) {
            voice.allocate();
        } else {
            System.out.println("Voice not found. Check FreeTTS installation.");
        }

        // Create panel and layout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Add components to panel
        panel.add(new JLabel("Enter text: "));
        panel.add(textField);
        panel.add(speakButton);

        // Add panel to frame
        add(panel);

        // Add action listener to button
        speakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText().trim();
                if (!text.isEmpty() && voice != null) {
                    voice.speak(text);
                } else if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                        "Please enter some text first!",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextToSpeechApp().setVisible(true);
            }
        });
    }

    // Clean up resources when closing
    @Override
    public void dispose() {
        super.dispose();
        if (voice != null) {
            voice.deallocate();
        }
    }
}