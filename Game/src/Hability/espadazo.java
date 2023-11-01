package Hability;

import Entities.Entity;

import java.util.ArrayList;
import java.util.Arrays;

public class espadazo extends Habilities {
    public espadazo(){
        setName("Espadazo");
    }
    @Override
    public void ejecutar(Entity entity,Entity entity2) {
        float valor = (float) ((entity.getFisdam())*hab.ESPADAZO.getValor());
        if(valor>0)entity2.change_health(-(valor));
    }

}
