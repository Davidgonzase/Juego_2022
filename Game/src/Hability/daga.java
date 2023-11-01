package Hability;

import Entities.Entity;

//incorporar daga en bandido

public class daga extends Habilities {
    public daga(){
        setName("Daga");
    }
    //usa daño fisico
    @Override
    public void ejecutar(Entity entity,Entity entity2) {
        float valor = (float) (entity.getFisdam()*hab.DAGA.getValor()*entity2.getFisres());
        entity2.change_health(valor);
    }
}