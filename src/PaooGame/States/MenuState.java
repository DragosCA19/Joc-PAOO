package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import java.awt.*;

public class MenuState extends State{
    private UIManager uiManager;
    public MenuState(RefLinks refLink)
    {
        super(refLink);
        uiManager=new UIManager(refLink);
        refLink.GetMouseManager().SetUIManager(uiManager);
        uiManager.addObject(new UIImageButton(300, 400, 64, 64, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().SetUIManager(null);
                State.SetState(refLink.GetGame().playState);
            }
        }));

        uiManager.addObject(new UIImageButton(250, 500, 64, 64, Assets.quit_button, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().SetUIManager(null);
                System.exit(0);
            }
        }));
    }
    @Override
    public void Update()
    {
        uiManager.tick();
    }
    @Override
    public void Draw(Graphics g)
    {

        g.drawImage(Assets.meniu_background,0,0,800,800,null);

        uiManager.render(g);
    }
}
