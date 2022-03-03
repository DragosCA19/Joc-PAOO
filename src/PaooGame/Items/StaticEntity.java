package PaooGame.Items;

import PaooGame.RefLinks;

public abstract class StaticEntity extends Item{

    public StaticEntity(RefLinks refLink, float x, float y, int width, int height) {
        super(refLink, x, y, width, height);
    }
}
