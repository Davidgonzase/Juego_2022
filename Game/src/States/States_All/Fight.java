package States.States_All;

import Entities.Entity;
import Entities.Mchain;
import States.GUI;
import GUI.Display;
import loaders.ImageLoader;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Fight uses a panel to show the fight state
 */
public class Fight extends GUI {
    int turn=0;
    private Entity friend,enemy;
    private JButton action1,action2,action3,action4;
    private Display display;
    private boolean ft;
    public Fight(Mchain per, Entity friend, Entity enemy,Display display){
        setPer(per);
        this.friend=friend;
        this.enemy=enemy;
        this.display=display;
        ft=false;
        turn=0;
    }
    @Override
    public void update() {
        if(!ft){
            ft=true;
            initialize();
        }
        if((friend.getHealth()<=0||enemy.getHealth()<=0)&&turn<3){
            change_panel(display,getPanel());
            turn=3;
        }
        if(turn==1&&enemy.getHealth()>0){
            enemy.getHabilities().get(0).ejecutar(enemy,friend);
            turn=0;
        }
    }

    @Override
    public void render(Graphics graphics) {
        if(friend.getHealth()<=0) {
            graphics.drawImage(ImageLoader.loadim("/textures/go.png"), 0, 0, null);
        }
        if(enemy.getHealth()<=0){
            graphics.drawImage(ImageLoader.loadim("/textures/win.png"),0,0,null);
        }
    }

    public void initialize() {
        change_canvas(display);
        my_panel();
        display.getFrame().setContentPane(getPanel());
        display.getFrame().setVisible(true);

    }
    // No carga las imagenes por lo que no se ve nada excepto los botones
    @Override
    public void my_panel() {
        getPanel().setBounds(0,0,1280,720);
        getPanel().setBounds(0,0,display.getFrame().getWidth(),display.getFrame().getHeight());
        getPanel().setBackground(Color.BLACK);
        getPanel().setLayout(null);
        getPanel().setVisible(true);

        BufferedImage bufferedImage=ImageLoader.loadim("/textures/mpersonajese.png");
        JLabel img1=new JLabel(new ImageIcon(bufferedImage));
        img1.setLocation(360,360);
        getPanel().add(img1);


        if(friend.getHabilities().size()>=1){
            action1= new JButton(friend.getHabilities().get(0).getName());
            action1.setBounds(280,360,360,180);
            action1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(turn==0){
                        friend.getHabilities().get(0).ejecutar(friend,enemy);
                        turn=1;
                    }
                }
            });
            action1.setFocusable(false);
            getPanel().add(action1);
        }
        if(friend.getHabilities().size()>=2){
            action2= new JButton(friend.getHabilities().get(1).getName());
            action2.setBounds(280,540,360,180);
            action2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(turn==0){
                        friend.getHabilities().get(1).ejecutar(friend,enemy);
                        turn=1;
                    }
                }
            });
            action2.setFocusable(false);
            getPanel().add(action2);
        }
        if(friend.getHabilities().size()>=3){
            action3= new JButton(friend.getHabilities().get(2).getName());
            action3.setBounds(640,360,360,180);
            action3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(turn==0){
                        friend.getHabilities().get(2).ejecutar(friend,enemy);
                        turn=1;
                    }
                }
            });
            action3.setFocusable(false);
            getPanel().add(action3);
        }
        if(friend.getHabilities().size()==4){
            action4= new JButton(friend.getHabilities().get(3).getName());
            action4.setBounds(640,540,360,180);
            action4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(turn==0){
                        friend.getHabilities().get(3).ejecutar(friend,enemy);
                        turn=1;
                    }
                }
            });
            action4.setFocusable(false);
            getPanel().add(action4);

        }
    }
}
