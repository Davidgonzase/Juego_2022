package managers;

import Entities.Mchain;

import static managers.world_manager.can_move;

/**
 * It moves if a key is pressed and character can move there
 * due to being required to move slower a thread is used
 * @see java.lang.Runnable
 */
public class Movemanager implements Runnable{
    private boolean running;
    private Keymanager keymanager;
    private Thread thread;
    private Mchain per;


    /**
     * Constructor
     * @param keymanager to check for keys being pressed
     * @param per to move the character
     */

    public Movemanager(Keymanager keymanager,Mchain per){
        running=false;
        this.keymanager=keymanager;
        this.per=per;
    }

    /**
     * if character can move it will check if can move to that position based on Worlds
     * @see Worlds
     * it uses keymanager
     */

    public void run() {
        while(running){
            if(per.isTangible()&& per.isVisible()) {
                if (keymanager.down) {
                    if (per.getCface() == 's'&& can_move(per.getX(), per.getY()+60)) {
                        per.move(per.getX(), per.getY() + 60);
                    } else {
                        per.face('s');
                    }
                }
                if (keymanager.up) {
                    if (per.getCface() == 'w'&& can_move(per.getX(), per.getY()-60)) {
                        per.move(per.getX(), per.getY() - 60);
                    } else {
                        per.face('w');
                    }
                }
                if (keymanager.left) {
                    if (per.getCface() == 'a'&& can_move(per.getX()-60, per.getY())) {
                        per.move(per.getX() - 60, per.getY());
                    } else {
                        per.face('a');
                    }
                }
                if (keymanager.right){
                    if (per.getCface() == 'd'&& can_move(per.getX()+60, per.getY())) {
                        if(per.getX()<943)per.move(per.getX() + 60, per.getY());
                    } else {
                        per.face('d');
                    }
                }
            }
            try {
                thread.sleep(80);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        end();
    }
    public synchronized void start(){
        if(!running) {
            thread = new Thread(this,"Move");
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