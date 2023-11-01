package States.States_All;

import GUI.Display;
import Entities.Mchain;
import States.GUI;
import States.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.Display.is_canvas;

/**
 * Using a pane with buttons to the main options
 * Work in Progress
 */
public class Menu extends GUI {
    private Graphics graphics;
    private Display display;
    private JButton button_play =new JButton("Play");
    private JButton button_settings =new JButton("Settings");
    private JButton button_credits =new JButton("Credits");
    private boolean ft;
    private Mchain per;
    private State state;

    /**
     * @param per loads the user
     * @param state next state that will be used
     * @param display loads the display to change the canvas
     */
    public Menu(Mchain per,State state,Display display,Graphics graphics){
        this.display=display;
        this.state=state;
        ft=false;
        this.graphics=graphics;
        this.per=per;

    }
    @Override
    public void update() {
        if (!ft){
            initialize();
            ft=true;
        }


    }

    @Override
    public void render(Graphics graphics){
    }

    public void initialize() {
        change_canvas(display);
        my_panel();
        display.getFrame().setContentPane(getPanel());
        display.getFrame().setVisible(true);
    }

    @Override
    public void my_panel() {
        button_play.setBounds(540,150,100,50);
        button_settings.setBounds(540,300,100,50);
        button_credits.setBounds(540,450,100,50);
        button_play.setFocusable(false);
        button_play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change_panel(display,getPanel());
                State.setCurrentstate(state);
                per.setTangible(true);
                per.setVisible(true);
            }
        });
        //panel.add(button_credits);
        //panel.add(button_settings);
        getPanel().add(button_play);
        getPanel().setLayout(null);
    }
}
