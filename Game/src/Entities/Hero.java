package Entities;


import Hability.Habilities;
import Hability.espadazo;
import Hability.escudo;

import java.awt.image.BufferedImage;

/**
 * One of the allies of Entity
 */
public class Hero extends Entity {
    /**
     * Constructor that initializes all variables
     * @param bufferedImage Image of the character
     */
    public Hero(BufferedImage bufferedImage) {
        setname("");
        setBufferedImage(bufferedImage);
        setHealth(20);
        setType("Hero");
        setHealths(1.05F);
        setFisdam(1.10F);
        setFisres(1.20F);
        setMagdam(0.90F);
        setMagres(0.90F);
        setVelocity(0.80F);
        Habilities espadazo=new espadazo();
        Habilities escudo=new escudo();
        addHabilities(espadazo);
        addHabilities(escudo);
    }
    /**
     * Constructor that initializes all variables and name
     * @param bufferedImage Image of the character
     * @param name name of the character
     */
    public Hero(BufferedImage bufferedImage, String name) {
        setname(name);
        setBufferedImage(bufferedImage);
        setHealth(20);
        setType("Hero");
        setHealths(1.05F);
        setFisdam(1.10F);
        setFisres(1.20F);
        setMagdam(0.90F);
        setMagres(0.90F);
        setVelocity(0.80F);
    }

}
