package Hability;

import Entities.Entity;

/**
 * Abstract class that defines the habilities that use the entities
 */

public abstract class Habilities { // borrar
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    /**
     * The main function that modifies one entity for damage or boost
     * @param entity the entity that will change
     * @param entity2 if damage it will be calculated with the entity2 damage stats
     */
    public abstract void ejecutar(Entity entity,Entity entity2);
}

