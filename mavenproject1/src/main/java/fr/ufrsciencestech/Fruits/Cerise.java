/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

/**
 *
 * @author aa800033
 */

public class Cerise  extends FruitSimple{
    
    public Cerise(double prix, String origine) {
        super(prix, origine);
    }
    
    public Cerise()
    {
        super(1.0,"Espagne");
        
    }
    
      @Override
    public String toString(){
        return "Cerise de " + this.getOrigine() + " a " + this.getPrix() + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 cerises sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Cerise ba = (Cerise) o;
            return (ba.getPrix() == getPrix() && getOrigine().equals(ba.getOrigine()));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une cerise a des pepins
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
