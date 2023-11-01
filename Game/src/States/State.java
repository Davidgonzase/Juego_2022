package States;

import Entities.Mchain;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
/**
 * The game will have multitude of states to change the events and maps
 * this is the mother abstract class with update and render
 */
public abstract class State {
    public Mchain getPer() {
        return per;
    }
    public void setPer(Mchain per) {
        this.per = per;
    }
    private Mchain per;
    /**
     * Used to check positions of characters or events
     */
    public abstract void update();
    /**
     * if canvas is used it will draw images
     * @param graphics used to draw in Game
     */
    public abstract void render(Graphics graphics);

    public static State getCurrentstate() {
        return currentstate;
    }

    public static void setCurrentstate(State currentstate) {
        State.currentstate = currentstate;
    }
    /**
     * The current state is stored in a static so everyone can use the functions
     */
    private static State currentstate=null;
    private ArrayList<BufferedImage> im;
    public ArrayList<BufferedImage> getIm() {return im;}
    public void setIm(ArrayList<BufferedImage> im){this.im=im;}
}
