package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Chest extends StaticEntity{

    public static int punctaj;

    public static int getPunctaj() {
        return punctaj;
    }

    public Chest(RefLinks refLink, float x, float y){
        super(refLink,x,y, Tile.TILE_WIDTH,Tile.TILE_HEIGHT);
        bounds.x=0;
        bounds.y=0;
        bounds.width=width;
        bounds.height=height;
        punctaj=100;

    }
    @Override
    public void Update() {

    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.chest,(int)x,(int)y,width,height,null);
    }
}
