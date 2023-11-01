package States.States_All;

import managers.Keymanager;
import Entities.Mchain;
import States.State;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Shows the room that will have the canvas with all the worlds
 */
public class Mainroom extends State {
    private Worlds.World World;
    private BufferedImage bufferedImage;
    private Keymanager keymanager;
    public Mainroom(Mchain per, Keymanager keymanager, Worlds.World World){
        setPer(per);
        this.World=World;
        this.bufferedImage=bufferedImage;
        this.keymanager=keymanager;
    }
    @Override
    public void update() {
    }

    @Override
    public void render(Graphics graphics) {
        World.update_world(this);
        graphics.drawImage(World.getBufferedImage(),0,0,null);
        if(getPer().isVisible())graphics.drawImage(getPer().getAct(), getPer().getX(), getPer().getY(), null);
    }
}
