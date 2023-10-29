package fr.ufrsciencestech.Fruits;
/**
 *
 * @author Wissam

 */
public class Orange  extends FruitSimple{
    
    public Orange(double prix, String origine) {
        super(prix, origine);
    }
    
    public Orange()
    {
        super(0.5,"Espagne");
        
    }
    
    @Override
    public String toString(){
        return "Orange de " + this.getOrigine() + " a " + this.getPrix() + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Cerises sont equivalentes
        if(o != null && getClass() == o.getClass()){

            Orange orange = (Orange) o;
            return ((orange.getPrix()==getPrix())  && orange.getOrigine().equals(getOrigine()));

        }
        return false;
    }

    public void setPrix(double prix)
    {
        this.prix = prix;
    }
    public void setOrigine(String origine) 
    {
    this.origine = origine;
    }
}


   






