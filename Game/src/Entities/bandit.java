package Entities;


import Hability.Habilities;
import Hability.espadazo;
import Hability.escudo;

import java.awt.image.BufferedImage;


 /**
 * One of the enemies of Entity
 */
 //tipo enenmigo (meter nuevas habilidades)
public class bandit extends Entity {
     /**
      * Constructor that initializes all variables
      * @param bufferedImage Image of the character
      */
    public bandit(BufferedImage bufferedImage) {
        setname("");
        setBufferedImage(bufferedImage);
        setHealth(20);
        setType("Bandit");
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
    public bandit(BufferedImage bufferedImage, String name) {
        setname(name);
        setBufferedImage(bufferedImage);
        setHealth(19);
        setType("Bandit");
        setHealths(1.0F);
        setFisdam(1.05F);
        setFisres(1.10F);
        setMagdam(0.90F);
        setMagres(0.90F);
        setVelocity(0.80F);
    }

}
