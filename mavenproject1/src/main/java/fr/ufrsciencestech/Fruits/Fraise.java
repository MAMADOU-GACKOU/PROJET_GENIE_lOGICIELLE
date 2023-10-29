package fr.ufrsciencestech.Fruits;

/**
 *
 * @author Wissam
 */

public class Fraise extends FruitSimple {

    public Fraise(double prix, String origine) {
        super(prix, origine);
    }

    public Fraise() {
        super(0.5, "Espagne");
    }


    @Override
    public String toString() {
        return "Fraise de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o) {  //predicat pour tester si 2 oranges sont equivalentes
        if (o != null && getClass() == o.getClass()) {
            Fraise or = (Fraise) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    /**
     *
     * @return le predicat indiquant qu'une orange a des pepins
     */
    @Override
    public boolean isSeedless() {
        return true;
    }

}
