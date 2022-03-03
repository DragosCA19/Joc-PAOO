package PaooGame.UI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;
import PaooGame.RefLinks;

public class UIManager {
    private RefLinks refLinks;
    private ArrayList<UIObject> objects;
    public UIManager (RefLinks reflinks){
        this.refLinks=reflinks;
        objects=new ArrayList<UIObject>();
    }

    public void tick(){
        for(UIObject o: objects)
            o.Update();
    }
    public void render(Graphics g){
        for(UIObject o: objects)
            o.Draw(g);
    }
    public void onMouseMove(MouseEvent e){
        for(UIObject o: objects)
            o.onMouseMove(e);
    }
    public void onMouseRelease(MouseEvent e){
        for(UIObject o: objects)
            o.onMouseRelease(e);
    }
    public void addObject(UIObject o){
        objects.add(o);
    }

    public RefLinks getRefLinks() {
        return refLinks;
    }

    public void setRefLinks(RefLinks refLinks) {
        this.refLinks = refLinks;
    }

}
