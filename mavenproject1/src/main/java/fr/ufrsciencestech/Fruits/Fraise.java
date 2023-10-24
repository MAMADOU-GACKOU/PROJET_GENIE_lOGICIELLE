package fr.ufrsciencestech.Fruits;
/**
 *
 * @author Wissam
 */

public class Fraise extends FruitSimple{
    public Fraise(double prix, String origine)
    {
        super(prix, origine);
    }
    public Fraise()
    {
        super(0.5,"Espagne");
    }    
    @Override
    public String toString(){
        return "Fraise de " + getOrigine() + " a " + getPrix() + " euros";
    }
    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 oranges sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Fraise fraise = (Fraise) o;
            return (fraise.getPrix()==getPrix())  && fraise.getOrigine().equals(getOrigine());
        }
        return false;
    }
    
    @Override
    public boolean isSeedless()
    {
        return true;
    }
}