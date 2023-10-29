/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

/**
 *
 * @author djera
 */
public class Banane  extends FruitSimple{
    
    public Banane(double prix, String origine) {
        super(prix, origine);
    }
    
    public Banane()
    {
        super(0.5,"Espagne");
        
    }
    
      @Override
    public String toString(){
        return "Banane de " + this.getOrigine() + " a " + this.getPrix() + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 bananes sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Banane ba = (Banane) o;
            return (ba.getPrix() == getPrix() && getOrigine().equals(ba.getOrigine()));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une banane a des pepins
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
