package PaooGame;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Game paooGame = new Game("PaooGame", 800, 800);

        File audioFile=new File("C:\\Users\\Dragos\\Desktop\\Joc PAOO\\res\\Music\\[8-Bit] The Binding of Isaac Repentance - Juggernaut Chiptune Remix (mp3cut.net).wav");
        AudioInputStream audioStream=AudioSystem.getAudioInputStream(audioFile);
        AudioFormat format=audioStream.getFormat();
        DataLine.Info info=new DataLine.Info(Clip.class,format);
        Clip audioClip=(Clip) AudioSystem.getLine(info);
        audioClip.open(audioStream);
        audioClip.start();

        paooGame.StartGame();
    }

}
