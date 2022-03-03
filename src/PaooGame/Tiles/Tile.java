package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

//Retine dalele si permite regasirea lor dupa un ID asignat fiecarei dale

public class Tile {
    private static TileFactory tileFactory=new TileFactory();
    private static final int NO_TILES = 32;
    public static Tile[]tiles=new Tile[NO_TILES];
    public static Tile floorTile=TileFactory.createTile(0);
    public static Tile wallTile= TileFactory.createTile(1);
    public static final int TILE_WIDTH  = 32;
    public static final int TILE_HEIGHT = 32;
    protected BufferedImage img;
    protected final int id;

    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this;
    }
    public void Update()
    {

    }
    public void Draw(Graphics g, int x, int y)
    {
        /// Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }
    public boolean IsSolid()
    {

        return false;
    }


}
