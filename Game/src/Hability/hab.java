package Hability;

/**
 * Stores double "valor" that returns a number used in habilities
 */

public enum hab {
    ESPADAZO(7),ESCUDO(0.20),DAGA(5);

    public double getValor() {
        return valor;
    }

    private double valor;
    /**
     * Constructor of the enumeration
     * @param valor the double it will be stored
     */
    hab(double valor){
        this.valor=valor;
    }

}
