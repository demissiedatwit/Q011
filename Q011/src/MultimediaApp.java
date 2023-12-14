import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MultimediaApp extends JFrame {

    public MultimediaApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wentworth Institute of Technology");
        
        // Adjust the window size as per the image provided
        setSize(800, 600); 
        setLayout(new BorderLayout());

        // Load and scale the local image
        ImageIcon localImageIcon = new ImageIcon("/Users/conceptualdanny/Desktop/Everything/MetaPrograms/WIT/Fall 2023/Computer Science II/Q011/Q011/res/witlogo.png");
        Image localImage = localImageIcon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH); // Scale image as needed
        JLabel imageLabel1 = new JLabel(new ImageIcon(localImage));
        add(imageLabel1, BorderLayout.NORTH);

        // Load and scale the remote image
        ImageIcon remoteImageIcon = null;
        try {
            URL imageUrl = new URL("https://wit.edu/sites/default/files/styles/780w_520h/public/2022-03/2021_Wentworth_Sep-5613.jpg");
            remoteImageIcon = new ImageIcon(imageUrl);
            Image remoteImage = remoteImageIcon.getImage().getScaledInstance(780, 520, Image.SCALE_SMOOTH); // Scale image as needed
            JLabel imageLabel2 = new JLabel(new ImageIcon(remoteImage));
            add(imageLabel2, BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception
        }

        // Style the play button
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Arial", Font.BOLD, 24)); // Set the font size and style
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Open an audio input stream
                    File soundFile = new File("/Users/conceptualdanny/Desktop/Everything/MetaPrograms/WIT/Fall 2023/Computer Science II/Q011/Q011/res/music_fx_funk.wav"); // Convert mp3 to wav or use a library that supports mp3
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    ex.printStackTrace();
                    // Handle exception
                }
            }
        });

        add(playButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MultimediaApp().setVisible(true);
            }
        });
    }
}
