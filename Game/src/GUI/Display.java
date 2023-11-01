package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Function Display is used in order to show the GUI of the game
 * this uses a Pane that changes when the java.awt canvas is wanted to be used or other pane with buttons
 */

public class Display{
    /**
     * Display constructor initiates Display settings
     */
    public Display(){
        frame=new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);

        is_canvas=true;
        frame.add(canvas);
        frame.pack();
    }
    public void resize(int width,int height){
        if(width<1920||width>0||height<1080||height>0){
            canvas.resize(width,height);
        }
    }


    public Canvas getCanvas() {return canvas;}
    public JFrame getFrame(){return frame;}
    public static boolean is_canvas;
    private Canvas canvas;

    private JFrame frame;
    private String title="Dungeons And Pixels";


    private int width=1280,height=720;
}
