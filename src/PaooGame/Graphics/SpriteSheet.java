package PaooGame.Graphics;

import java.awt.image.BufferedImage;
//SpritesSheet retine o referinta catre o imagine din Sprite Sheet-ul jocului iar functia crop returneaza o data de la pozitia specificata
public class SpriteSheet {
    private BufferedImage spriteSheet;
    private static final int tileWidth=34;
    private static final int tileHeight=34;


    public SpriteSheet(BufferedImage buffImg)
    {
        spriteSheet=buffImg;
    }

    public BufferedImage crop(int x,int y)
    {
        return spriteSheet.getSubimage(x*tileWidth+3,y*tileHeight,tileWidth,tileHeight);
    }
}
