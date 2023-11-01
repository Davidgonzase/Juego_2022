package managers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Manage the KeyEvent of the system via KeyListener
 * @see java.awt.event.KeyListener
 * @see java.lang.Runnable
 */
public class Keymanager implements KeyListener , Runnable{
    private Thread thread;
    private boolean running = false;
    private boolean[] keys;
    public boolean up,down,left,right, first_time;
    public Keymanager(){
        start();
        keys=new boolean[256];
    }
    /**
     * Sets the boolean of each key
     */
    public void update() {
        up=keys[KeyEvent.VK_W];
        down=keys[KeyEvent.VK_S];
        left=keys[KeyEvent.VK_A];
        right=keys[KeyEvent.VK_D];
    }
    /**
     * To tittle change
     * @param e event of a key doing something
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if(first_time !=true) first_time =true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
    }
    /**
     * If released key is false
     * @param e event of a key doing something
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }

    public void setAll(boolean state) {
        for(int i=0;i< keys.length;i++){
            keys[i]=state;
        }
    }

    @Override
    public void run() {
        while(running){
            this.update();
            try {
                thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        end();
    }

    public synchronized void start(){
        if(!running) {
            thread = new Thread(this,"Keys");
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
        }
    }
    /**
     * Used to sleep thread
     * @param timer time that will sleep the thread
     */
    public void sleep(long timer){
        try {
            thread.sleep(timer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
