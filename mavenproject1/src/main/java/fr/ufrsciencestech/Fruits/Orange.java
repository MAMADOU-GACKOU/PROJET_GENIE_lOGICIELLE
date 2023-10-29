package fr.ufrsciencestech.Fruits;



/**
 *
 * @author aa800033

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
    public boolean equals(Object o){  //predicat pour tester si 2 oranges sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Orange ba = (Orange) o;
            return (ba.getPrix() == getPrix() && getOrigine().equals(ba.getOrigine()));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une orange a des pepins
        return false;
    }
    
    
    
     public void setOrigine(String origine) {
        this.origine = origine;
    }
    
    public void setPrix(double prix)
    {
        this.prix=prix;
    }
}


   


