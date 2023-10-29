package fr.ufrsciencestech.Fruits;


public class Fraise  extends FruitSimple{
    
    public Fraise(double prix, String origine) {
        super(prix, origine);
    }
    
    public Fraise()
    {
        super(0.5,"Espagne");
        
    }
    
      @Override
    public String toString(){
        return "Fraise de " + this.getOrigine() + " a " + this.getPrix() + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Fraises sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Fraise ba = (Fraise) o;
            return (ba.getPrix() == getPrix() && getOrigine().equals(ba.getOrigine()));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une Fraises a des pepins
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