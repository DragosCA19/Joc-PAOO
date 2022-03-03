package PaooGame.States;

import PaooGame.Items.Hero;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;

import java.awt.*;

public class PlayState extends State{
    private Map map;
    public PlayState(RefLinks refLink)
    {
        super(refLink);
        map = new Map(refLink);
        refLink.SetMap(map);
    }
    @Override
    public void Update() throws InterruptedException {
        map.Update();
    }
    @Override
    public void Draw(Graphics g) throws InterruptedException {
        map.Draw(g);
    }
}
