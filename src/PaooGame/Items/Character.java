package PaooGame.Items;

import PaooGame.RefLinks;

import PaooGame.Tiles.Tile;

import PaooGame.Maps.Map;


// Defineste notiunea de caracter din joc

public abstract class Character extends Item{
    public static final float DEFAULT_SPEED=3.0f;
    public static final int DEFAULT_CREATURE_WIDTH=32;
    public static final int DEFAULT_CREATURE_HEIGHT=32;

    private Chest chest_1;
    private Chest chest_2;
    private Chest chest_3;

    public static int score;

    private static boolean chest1;
    private static boolean chest2;
    private static boolean chest3;
    private static boolean final_nivel2;

    protected float speed;
    protected float xMove;
    protected float yMove;



    public Character(RefLinks refLink, float x, float y, int width, int height)
    {
        super(refLink,x,y,width,height);
        speed   = DEFAULT_SPEED;
        xMove   = 0;
        yMove   = 0;
        score=0;

        chest1=false;
        chest2=false;
        chest3=false;
        final_nivel2=false;

        chest_1=new Chest(refLink,33,32);
        chest_2=new Chest(refLink,481,224);
        chest_3=new Chest(refLink,193,672);




    }

    public Chest getChest_1() {
        return chest_1;
    }

    public void Move() throws InterruptedException {


        if((int)x/Tile.TILE_WIDTH == 12 && (int)y/Tile.TILE_HEIGHT==24){
            refLink.GetMap().LoadWorld2();
            x=416;
            y=5;
            Map.getEntityManager().addEntity(chest_1);
            setChest1(true);
        }

        else
        {
            if(!checkEntityCollisions(xMove,0f))
                MoveX();
            if(!checkEntityCollisions(0f,yMove))
                MoveY();

        }

        if(checkEntityCollisions(xMove,0f) || checkEntityCollisions(0f,yMove ) ){
            if(isFinal_nivel2()){
                Map.getEntityManager().removeEntity(getChest_3());

            }
            if(getChest3()){
                Map.getEntityManager().removeEntity(getChest_2());
                score=score+Chest.getPunctaj();
                setChest3(false);
                setFinal_nivel2(true);
            }
            if(getChest2()){
                Map.getEntityManager().removeEntity(getChest_2());
                Map.getEntityManager().addEntity(getChest_3());
                score=score+Chest.getPunctaj();
                setChest3(true);
                setChest2(false);
            }
            if(getChest1()) {
                Map.getEntityManager().removeEntity(getChest_1());
                Map.getEntityManager().addEntity(getChest_2());
                setChest1(false);
                setChest2(true);
                score=score+Chest.getPunctaj();
            }
        }
    }
    public void MoveX()
    {
        // Daca caracterul se misca spre dreapta, verifica coliziunile dintre ColisionBox-ul caracterului si dala urmatoare. Verifica colturile din dreapta sus si dreapta jos
        if(xMove > 0){
            int tx=(int)(x+xMove+bounds.x+bounds.width)/Tile.TILE_WIDTH;
            if(!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TILE_HEIGHT) && !collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILE_HEIGHT)){
                x=x+xMove;
            }

        } // Daca caracterul se misca spre stanga, verifica coliziunile dintre ColisionBox si dala. Verifica colturile din stanga
        else if(xMove<0){
            int tx=(int)(x+xMove+bounds.x)/Tile.TILE_WIDTH;
            if(!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TILE_HEIGHT) && !collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILE_HEIGHT)){
                x=x+xMove;
            }
        }

    }
    public void MoveY()
    {
        // In cazul in care caracterul se misca in jos, verifica coliziunile colturilor stanga jos si dreapta jos.
        if(yMove<0){
            int ty=(int)(y+yMove+bounds.y)/Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TILE_WIDTH,ty) && !collisionWithTile((int)(x+bounds.x+ bounds.width)/Tile.TILE_WIDTH,ty)){
                y=y+yMove;
            }
        }// In cazul in care se misca in sus, verifica coliziunile colturilor stanga sus si dreapta sus.
        else if(yMove>0){
            int ty=(int)(y+yMove+bounds.y+ bounds.height)/Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TILE_WIDTH,ty) && !collisionWithTile((int)(x+bounds.x+ bounds.width)/Tile.TILE_WIDTH,ty)){
                y=y+yMove;
            }
        }
    }

    public static boolean isFinal_nivel2() {
        return final_nivel2;
    }

    public static void setFinal_nivel2(boolean final_nivel2) {
        Character.final_nivel2 = final_nivel2;
    }

    public Chest getChest_3() {
        return chest_3;
    }

    public static boolean getChest3() {
        return chest3;
    }

    public static void setChest3(boolean chest3) {
        Character.chest3 = chest3;
    }

    public static boolean getChest2() {
        return chest2;
    }

    public static void setChest2(boolean chest2) {
        Character.chest2 = chest2;
    }

    public static boolean getChest1() {
        return chest1;
    }

    public static void setChest1(boolean chest1) {
        Character.chest1 = chest1;
    }

    public Chest getChest_2() {
        return chest_2;
    }

    // Verifica daca eroul va avea o coliziune cu dala urmatoare.
    protected boolean collisionWithTile(int x, int y){
        return refLink.GetMap().GetTile(x,y).IsSolid();
    }

}
