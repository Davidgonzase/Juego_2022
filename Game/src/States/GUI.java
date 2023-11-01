package States;

import GUI.Display;


import javax.swing.*;

import static GUI.Display.is_canvas;
/**
 * Used for states that will use panel
 */
public abstract class GUI extends State {
    /**
     * Changes the canvas, and a boolean so grapichs will not draw on a frame without canvas
     * @param display gets frame to remove canvas
     * @see Display
     */
    public void change_canvas(Display display){
        is_canvas=false;
        display.getFrame().remove(display.getCanvas());
        display.getFrame().add(getPanel());
        display.getFrame().setContentPane(getPanel());
    }
    /**
     * Changes the panel, and a boolean so grapichs will draw on a frame with canvas
     * @param display gets frame to remove panel
     * @param panel removes all components of panel
     * @see Display
     * @see javax.swing.JPanel
     */
    public void change_panel(Display display, JPanel panel){
        is_canvas=true;
        display.getFrame().remove(panel);
        panel.removeAll();
        display.getFrame().add(display.getCanvas());
    }
    /**
     * declares the panel that will be used
     */
    public abstract void my_panel();

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    private JPanel panel=new JPanel();

}
