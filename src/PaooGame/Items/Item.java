package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;

//Implementeaza notiunea de entitate activa din joc (element cu care eroul poate interactiona)

public abstract class Item {
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected Rectangle bounds;
    protected Rectangle normalBounds;

    protected RefLinks refLink;

    public Item(RefLinks refLink,float x,float y,int width,int height)
    {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.refLink=refLink;

        normalBounds=new Rectangle(0,0,width,height);

        bounds=normalBounds;
    }

    public boolean checkEntityCollisions(float xOffset,float yOffset){
        for(Item e: refLink.GetMap().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisonBounds(0f,0f).intersects(getCollisonBounds(xOffset,yOffset))){
                return true;
            }
        }
        return false;
    }
    public Rectangle getCollisonBounds(float xOffset,float yOffset){
        return new Rectangle ((int)(x+bounds.x+xOffset),(int)(y+bounds.y+yOffset),bounds.width,bounds.height);
    }
    public abstract void Update() throws InterruptedException;
    public abstract void Draw(Graphics g) throws InterruptedException;


    public void setX(float x){
        this.x=x;
    }
    public void setY(float y){
        this.y=y;
    }
    public void setWidth(int width)
    {
        this.width=width;
    }
    public void setHeight(int height)
    {
        this.height=height;
    }

}
