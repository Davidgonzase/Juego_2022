package Hability;

import Entities.Entity;

import java.util.ArrayList;
import java.util.Arrays;

public class escudo extends Habilities {
    public escudo(){
        setName("Escudo");
    }

    @Override
    public void ejecutar(Entity entity, Entity entity2) {
        entity.setFisres(entity.getFisres()+0.20F);
    }
}