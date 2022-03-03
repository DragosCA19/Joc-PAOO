package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class WallTile extends Tile{
    public WallTile(int id)
    {
        super(Assets.wall,id);
    }
    @Override
    public boolean IsSolid(){
        return true;
    }
}
