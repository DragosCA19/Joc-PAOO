package PaooGame.GameWindow;

import PaooGame.RefLinks;

import javax.swing.*;
import java.awt.*;

// GameWindow implementeaza fereastra jocului(+proprietati: width,height etc)

public class GameWindow
{
    private static GameWindow instance=null;
    private JFrame wndFrame;
    private String wndTitle;
    private int wndWidth;
    private int wndHeight;

    private Canvas canvas;

    public GameWindow(String title,int width,int height){
        wndTitle=title;
        wndWidth=width;
        wndHeight=height;
        wndFrame=null;
    }
    public static GameWindow getInstance(RefLinks refLink,String title,int width,int height){
        if(instance==null){
            return new GameWindow(title,width,height);
        }
        return instance;

    }
    public void BuildGameWindow(){
        if(wndFrame!=null){
            return;
        }

        //setarea proprietatilor ferestrei jocului

        wndFrame=new JFrame(wndTitle);
        wndFrame.setSize(wndWidth,wndHeight);
        wndFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wndFrame.setResizable(false);
        wndFrame.setLocationRelativeTo(null);
        wndFrame.setVisible(true);


        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(wndWidth,wndHeight));
        canvas.setMaximumSize(new Dimension(wndWidth,wndHeight));
        canvas.setMinimumSize(new Dimension(wndWidth,wndHeight));
        canvas.setFocusable(false);
        wndFrame.add(canvas);
        wndFrame.pack();
    }

    public int GetWndWidth(){
        return wndWidth;
    }
    public int GetWndHeight(){
        return wndHeight;
    }
    public Canvas GetCanvas(){
        return canvas;
    }
    public JFrame GetWndFrame(){
        return wndFrame;
    }

}