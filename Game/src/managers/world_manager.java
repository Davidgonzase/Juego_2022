package managers;

import Worlds.World;
public class world_manager {
    /**
     * Checks if player can move tho the next tile of the layout of the current World
     * @param x next x position of the character
     * @param y next y position of the character
     * @see Worlds
     */
    public static boolean can_move(int x,int y) {
        if(x>943||x<283||y<3||y>643)return false;
        if (World.current_worlds.getLayout()[((y - 3) * 12) / 720][((x - 283) * 12) / 720] == 0) {
            return true;
        } else
            return false;
    }
}
