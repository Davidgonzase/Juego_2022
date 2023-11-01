package Entities;

import loaders.ImageLoader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
/**
 * Stores all data and images of the character that appears in screen
 */
public class Mchain {
    /**
     * Constructor that initializes all variables
     * @param imch stores images of the main character
     * @param name name of the character
     */
    public Mchain(int x,int y,ArrayList<BufferedImage> imch){
        this.x=x;
        this.y=y;
        visible=false;
        tangible=false;
        this.imch=imch;
        face('s');
        ply.add(new Hero(ImageLoader.loadim("/textures/mpersonajese.png")));
    }

    public ArrayList<Entity> getPly() {
        return ply;
    }

    private  ArrayList<Entity> ply=new ArrayList<>();
    private static ArrayList<BufferedImage> imch;
    private BufferedImage act;
    private char cface;
    public char getCface() {return cface;}
    public BufferedImage getAct() {return act;}
    private int x,y;
    public int getX(){return x;}
    public int getY() {return y;}
    /**
     * Determines if character can be moved
     */
    private boolean tangible;
    /**
     * Determines if character can be seen
     */
    private boolean visible;
    public boolean isVisible(){return visible;}
    public void setVisible(boolean visible){this.visible=visible;}
    public boolean isTangible(){return tangible;}
    public void setTangible(boolean tangible){this.tangible=tangible;}
    public void move(int x,int y){
        this.x=x;
        this.y=y;
    }
    /**
     * Where the image is facing
     * @param position where is facing
     */
    public void face(char position){
        if(position==('a')){
            cface=position;
            act=imch.get(0);
        }
        if(position==('d')){
            cface=position;
            act=imch.get(1);
        }
        if(position==('w')){
            cface=position;
            act=imch.get(2);
        }
        if(position==('s')){
            cface=position;
            act=imch.get(3);
        }
    }
}
