package fr.ufrsciencestech.Fruits;
/**
 *
 * @author Wissam

 */
public class Orange extends FruitSimple{
    public Orange(double prix, String origine)
    {
        super(prix,origine);
    }
	
    public Orange() 
    {
        super(0.5,"Espagne");
    }
    @Override
    public boolean isSeedless()
    {
        return false;
    }
    @Override
    public String toString(){
        return "Orange de " +getOrigine()+ " a " + getPrix() + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Cerises sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Orange orange = (Orange) o;
            return ((orange.getPrix()==getPrix())  && orange.getOrigine().equals(getOrigine()));
        }
        return false;
    }
}
