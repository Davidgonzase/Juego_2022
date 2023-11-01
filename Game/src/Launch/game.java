package Launch;

import Entities.Mchain;
import Entities.bandit;
import GUI.Display;
import States.States_All.Fight;
import States.States_All.Mainroom;
import States.States_All.Menu;
import States.State;
import States.States_All.Tittle;
import Worlds.World;
import loaders.ImageLoader;
import managers.Keymanager;
import managers.Movemanager;
import managers.Worlds;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static GUI.Display.is_canvas;
/**
 * Game has the basic structure that will run all the game
 * It uses a separate thread to launch the game so Runnable is used
 */
public class game implements Runnable{
    public game(){
        keymanager=new Keymanager();
    }
    private Display display;
    private Thread thread;
    private boolean running=false;
    private BufferStrategy bs;

    public Graphics getGraphics() {
        return graphics;
    }
    private Graphics graphics;
    private Mchain per;
    private Menu menu;
    private static ArrayList<BufferedImage> imch,pimch;
    private static Keymanager keymanager;
    private Movemanager movemanager;
    private State gameState;
    public Fight fight;
    private World world=new World(this);
    /**
     * Used to initiate all the means needed
     * @see ImageLoader the images will be loaded here
     */
    private void innit(){
        keymanager.start();
        display=new Display();
        display.getFrame().addKeyListener(keymanager);
        imch=new ArrayList<BufferedImage>();
        pimch=new ArrayList<BufferedImage>();
        imch.add(ImageLoader.loadim("/textures/Maintitle2.png"));
        imch.add(ImageLoader.loadim("/textures/Maintitle3.png"));
        imch.add(ImageLoader.loadim("/textures/cuadricula.png"));
        pimch.add(ImageLoader.loadim("/textures/mpersonajesw.png"));
        pimch.add(ImageLoader.loadim("/textures/mpersonajese.png"));
        pimch.add(ImageLoader.loadim("/textures/mpersonajesn.png"));
        pimch.add(ImageLoader.loadim("/textures/mpersonajess.png"));
        per=new Mchain(283,3,pimch);
        per.setTangible(false);
        world.setWorld(Worlds.WORLD_01.getLayout());
        World.current_worlds = Worlds.WORLD_01;
        Mainroom mr=new Mainroom(per,keymanager,world);
        menu=new Menu(per,mr,display,graphics);
        gameState= new Tittle(per,menu,keymanager,imch.get(0),imch.get(1));
        movemanager=new Movemanager(keymanager,per);
        fight=new Fight(per,per.getPly().get(0), new bandit(pimch.get(3)),display);
        movemanager.start();
        State.setCurrentstate(gameState);
    }
    /**
     * Calls the update of the current state
     * Update checks if events in and out the game occurs
     * @see Keymanager
     */
    private void update(){
        if(State.getCurrentstate()!=null)State.getCurrentstate().update();
    }
    /**
     *Uses a buffer to render the images of the current state
     */
    private void render(){
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        if(is_canvas)graphics=bs.getDrawGraphics();
        if(State.getCurrentstate()!=null)State.getCurrentstate().render(graphics);
        if(is_canvas) {
            bs.show();
            graphics.dispose();
        }
    }
    private int ticks;
    private long timer;
    /**
     * Used by the thread at the start
     * FPS limit established to 60 frames per second
     */
    public void run(){
        innit();
        int fps=60;
        double tpt=1000000000/fps;
        double delta=0;
        ticks=0;
        timer=0;
        long now;
        long lt=System.nanoTime();
        sleep(10);
        while(running){
            now=System.nanoTime();
            delta+=(now-lt)/tpt;
            timer+=now-lt;
            lt=now;
            if(delta>=1) {
                update();
                render();
                ticks++;
                delta--;
            }
            if (timer>=1000000000){
                timer=0;
                System.out.println("Fps: "+ticks);
                ticks=0;
            }
        }
        end();
    }
    /**
     * If thread is not running is started at the beginning
     */
    public synchronized void start(){
        if(!running) {
            thread = new Thread(this,"Game");
            thread.start();
            running = true;
        }
    }
    /**
     * If thread is running it stops at the end
     */
    public synchronized void end(){
        if(running) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            running=false;
        }
    }

    /**
     * Used to sleep all threads
     * @param timer time that will sleep all threads
     */
    public void sleep(long timer){
        try {
            thread.sleep(timer);
            movemanager.sleep(timer);
            keymanager.sleep(timer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
