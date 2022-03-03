package PaooGame.Items;


import PaooGame.RefLinks;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private RefLinks refLink;
    private Hero hero;
    private ArrayList<Item> entities;

    public EntityManager(RefLinks refLink,Hero hero){
        this.refLink=refLink;
        this.hero=hero;
        entities=new ArrayList<Item>();
        addEntity(hero);
    }
    public void Update() throws InterruptedException {
        for(int i=0;i<entities.size();i++) {
            Item e = entities.get(i);
            e.Update();
        }
    }
    public void Draw(Graphics g) throws InterruptedException {
        for(Item e: entities){
            e.Draw(g) ;
        }
    }

    public void addEntity( Item e){
        entities.add(e);
    }

    public void removeEntity(Item e){
        entities.remove(e);
    }

    public void setRefLink(RefLinks refLink) {
        this.refLink = refLink;
    }

    public RefLinks getRefLink() {
        return refLink;
    }

    public Hero getHero() {
        return hero;
    }

    public ArrayList<Item> getEntities() {
        return entities;
    }
}
