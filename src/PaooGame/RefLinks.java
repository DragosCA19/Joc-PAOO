package PaooGame;

import PaooGame.Input.MouseManager;
import PaooGame.Maps.Map;
import PaooGame.Input.KeyManager;

public class RefLinks
{
    private Game game;
    private Map map;

    public RefLinks(Game game)
    {
        this.game = game;
    }

    public KeyManager GetKeyManager()
    {
        return game.GetKeyManager();
    }
    public MouseManager GetMouseManager(){return game.GetMouseManager();}

    public Game GetGame()
    {
        return game;
    }

    public Map GetMap()
    {
        return map;
    }

    public void SetMap(Map map)
    {
        this.map = map;
    }
}
