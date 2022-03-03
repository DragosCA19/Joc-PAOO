package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Hero extends Character{
    private BufferedImage image;
    private static int contor;
    public Hero(RefLinks refLink,float x,float y)
    {
        super(refLink,x,y,Character.DEFAULT_CREATURE_WIDTH,Character.DEFAULT_CREATURE_HEIGHT);
        image=Assets.hero1Right;

        normalBounds.x=8;
        normalBounds.y=10;
        normalBounds.width = 16;
        normalBounds.height = 20;

        contor=0;
    }

    @Override
    public void Update() throws InterruptedException {
        ///Verifica daca a fost apasata o tasta
        GetInput();
        //in cazul in care nu a fost apasata nicio tasta, eroul sta pe loc
        if(xMove == 0 && yMove ==0){
            return;
        }
        else // in caz contrar, miscam eroul
        {
            Move();
        }

        ///Actualizeaza imaginea
        if(refLink.GetKeyManager().left)
        {
            image = Assets.hero1Left;
        }
        if(refLink.GetKeyManager().right) {
            image = Assets.hero1Right;
        }
        if(refLink.GetKeyManager().up) {
            image = Assets.hero1Up;
        }
        if(refLink.GetKeyManager().down) {
            image = Assets.hero1Down;
        }
    }
    private void GetInput()
    {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
        ///Verificare apasare tasta "W"
        if(refLink.GetKeyManager().up && y>=0)
        {
            yMove = -speed;
        }
        ///Verificare apasare tasta "S"
        if(refLink.GetKeyManager().down && y/Tile.TILE_HEIGHT<24)
        {
            yMove = speed;
        }
        ///Verificare apasare tasta "A"
        if(refLink.GetKeyManager().left && x>=0)
        {
            xMove = -speed;
        }
        ///Verificare apasare tasta "D"
        if(refLink.GetKeyManager().right && x/Tile.TILE_WIDTH<24)
        {
            xMove = speed;
        }
    }
    //Deseneaza grafic eroul
    @Override
    public void Draw(Graphics g) throws InterruptedException {
        g.drawImage(image, (int)x, (int)y, width, height, null);
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,30));
        g.drawString("Score: "+score,640,30);
        if((int)x/Tile.TILE_WIDTH == 8 && (int)y/Tile.TILE_HEIGHT==24 && isFinal_nivel2()){
            contor++;
            g.drawString("Felicitari! Ati terminat jocul.",200,200);
            TimeUnit.SECONDS.sleep(1);
            if(contor==3)
                System.exit(0);
        }
    }

}
