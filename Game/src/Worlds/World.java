package Worlds;

import GUI.Display;
import Launch.game;
import States.State;
import loaders.ImageLoader;
import managers.Worlds;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Uses a Worlds layout to build an image with the world, and update worlds
 */
// debido a un error ebn esta funcion solo hay un mundo
public class World {
    private BufferedImage bufferedImage;
    private int x,y;
    private Graphics2D graphics;
    private game Game;
    public World(game Game){
        this.Game=Game;
    }
    //para un futuro algoritmo heuristico para crear mapas
    /**
     * Modifies the image based on a layout given, this can create any map even random generated ones
     * @param layout uses layouts of Worlds
     * @see Worlds
     */

    // no funciona la segunda vez probablemente por el createGraphics ya que utiliza la imagen una vez
    public void setWorld(int[][] layout){
        bufferedImage= ImageLoader.loadim("/textures/cuadricula_blanca.png");
        graphics=bufferedImage.createGraphics();
        graphics.setColor(Color.black);
        x=280;
        for(int i=0;i< layout.length;i++) {
            for (int j = 0; j < layout[i].length; j++) {
                if (layout[i][j] == 1) {
                    graphics.fillRect(x,y,60,60);
                }
                x += 60;
            }
            y += 60;
            x = 280;
        }
        graphics.dispose();
    }
    /**
     * Checks the current state and position to change worlds and transitions
     * @param state uses various elements to check everything
     * @see State
     */

    //los mundos estan cambiados para no causar problemas
    public void update_world(State state){
        int x= ((state.getPer().getX() - 283) * 12) / 720;
        int y = ((state.getPer().getY() - 3) * 12) / 720;
        if(current_worlds==Worlds.WORLD_02){
            if((y==5||y==6)&&x==11){
                Game.sleep(10);
                setWorld(Worlds.WORLD_02.getLayout());
                current_worlds=Worlds.WORLD_02;
                state.getPer().move(283,state.getPer().getY());
            }
        }else if(current_worlds==Worlds.WORLD_01) {
            if((y==5||y==6)&&x==11){
                State.setCurrentstate(Game.fight);
            }
        }
    }
    public static Worlds current_worlds;
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
}
