package PaooGame.Tiles;

public class TileFactory {
    public static Tile createTile(int id){
        switch (id)
        {
            case 0:
                return new FloorTile(0);
            case 1:
                return new WallTile(1);
            default:
                return null;
        }
    }
}
