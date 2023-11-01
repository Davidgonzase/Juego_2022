package States.States_All;

import managers.Keymanager;
import Entities.Mchain;
import States.State;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * Shows the tittle of the game with 2 images
 */
public class Tittle extends State {
    private int cont;
    private Keymanager keymanager;
    private  State state;
    private BufferedImage fi,si;
    public Tittle(Mchain per, State state, Keymanager keymanager, BufferedImage fi, BufferedImage si){
        setPer(per);
        getPer().setTangible(false);
        getPer().setVisible(false);
        this.fi=fi;
        this.si=si;
        this.keymanager=keymanager;
        this.state=state;
        cont=0;
    }
    @Override
    public void update() {
        if(keymanager.first_time){
            State.setCurrentstate(state);
        }
    }

    @Override
    public void render(Graphics graphics) {
        if(cont<=60){
            graphics.drawImage(fi,0,0,null);
            cont++;
        }
        else {graphics.drawImage(si,0,0,null);cont++;if(cont>=120)cont=0;}
    }
}
