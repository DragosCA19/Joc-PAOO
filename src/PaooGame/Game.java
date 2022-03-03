package PaooGame;

import PaooGame.GameWindow.GameWindow;
import PaooGame.Graphics.Assets;
import PaooGame.Input.KeyManager;
import PaooGame.Input.MouseManager;
import PaooGame.States.*;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Game implements Runnable
{
    private GameWindow      wnd;
    private boolean         runState;
    private Thread          gameThread;
    private BufferStrategy  bs;


    private Graphics        g;

    public State playState;
    public State menuState;
    private KeyManager keyManager;
    private MouseManager mouseManager;
    private RefLinks refLink;

    public Game(String title, int width, int height)
    {
        wnd = GameWindow.getInstance(refLink,title,width,height);
        runState = false;
        keyManager = new KeyManager();
        mouseManager=new MouseManager();
    }


    private void InitGame() throws IOException {
        wnd.BuildGameWindow();
        wnd.GetWndFrame().addKeyListener(keyManager);
        wnd.GetWndFrame().addMouseListener(mouseManager);
        wnd.GetWndFrame().addMouseMotionListener(mouseManager);
        wnd.GetCanvas().addMouseListener(mouseManager);
        wnd.GetCanvas().addMouseMotionListener(mouseManager);
        Assets.Init();
        refLink = new RefLinks(this);
        playState       = new PlayState(refLink);
        menuState       = new MenuState(refLink);

        State.SetState(menuState);
    }


    public void run()
    {

        try {
            InitGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long oldTime = System.nanoTime();
        long curentTime;


        final int framesPerSecond   = 60;
        final double timeFrame      = 1000000000 / framesPerSecond;

        while (runState)
        {
            curentTime = System.nanoTime();
            if((curentTime - oldTime) > timeFrame)
            {
                try {
                    Update();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Draw();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                oldTime = curentTime;
            }
        }

    }


    public synchronized void StartGame()
    {
        if(!runState)
        {
            runState = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
        else
        {
            return;
        }
    }


    private void Update() throws InterruptedException {
        keyManager.Update();
        if(State.GetState() != null)
        {
            State.GetState().Update();
        }
    }


    private void Draw() throws InterruptedException {
        bs = wnd.GetCanvas().getBufferStrategy();
        if(bs == null)
        {
            try
            {
                wnd.GetCanvas().createBufferStrategy(3);
                return;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        g = bs.getDrawGraphics();

        g.clearRect(0, 0, wnd.GetWndWidth(), wnd.GetWndHeight());


        if(State.GetState() != null)
        {
            State.GetState().Draw(g);
        }

        bs.show();


        g.dispose();
    }

    public int GetWidth()
    {
        return wnd.GetWndWidth();
    }


    public int GetHeight()
    {
        return wnd.GetWndHeight();
    }


    public KeyManager GetKeyManager()
    {
        return keyManager;
    }
    public MouseManager GetMouseManager(){return mouseManager; }
}

