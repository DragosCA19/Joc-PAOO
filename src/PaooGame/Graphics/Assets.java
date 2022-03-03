package PaooGame.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Assets contine elementele grafice necesare pentru joc

public class Assets {
    private static final int width = 32, height = 32;
    public static BufferedImage hero1Left;
    public static BufferedImage hero1Right;
    public static BufferedImage hero1Up;
    public static BufferedImage hero1Down;
    public static BufferedImage wall;
    public static BufferedImage floor;
    public static BufferedImage chest;
    public static BufferedImage[] btn_start;
    public static BufferedImage meniu_background;
    public static BufferedImage[] quit_button;
    public static BufferedImage[] help_button;




    //Init initializeaza o imagine din spritesheet unei variabile

    public static void Init() throws IOException {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/SpriteSheetBun.png"));

        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage("/textures/SpriteSheetMeniu.png"));
        SpriteSheet sheet4 =new SpriteSheet(ImageLoader.LoadImage("/textures/Chest.png"));
        SpriteSheet sheet5=new SpriteSheet(ImageLoader.LoadImage("/textures/QuitButton.png"));
        SpriteSheet sheet6=new SpriteSheet(ImageLoader.LoadImage("/textures/Help Button.png"));

        btn_start=new BufferedImage[1];
        btn_start[0]=sheet2.crop(0,0);
        quit_button=new BufferedImage[1];
        quit_button[0]=sheet5.crop(0,0);
        help_button=new BufferedImage[1];
        help_button[0]=sheet6.crop(0,0);

        hero1Down=sheet.crop(0,0);
        hero1Up=sheet.crop(1,0);
        hero1Left=sheet.crop(2,0);
        hero1Right=sheet.crop(3,0);
        wall=sheet.crop(9,0);
        floor=sheet.crop(8,0);

        chest=sheet4.crop(0,0);



        meniu_background= ImageIO.read(new File("C:\\Users\\Dragos\\Desktop\\Joc PAOO\\res\\textures\\meniu_back.jpeg"));

    }
}
