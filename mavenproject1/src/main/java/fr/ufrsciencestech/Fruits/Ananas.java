/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

/**
 *
 * @author djera
 */

public class Ananas  extends FruitSimple{
    
    public Ananas(double prix, String origine) {
        super(prix, origine);
    }
    
    public Ananas()
    {
        super(3.0,"Espagne");
        
    }
    
      @Override
    public String toString(){
        return "Ananas de " + this.getOrigine() + " a " + this.getPrix() + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 ananas sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Ananas ba = (Ananas) o;
            return (ba.getPrix() == getPrix() && getOrigine().equals(ba.getOrigine()));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une ananas a des pepins
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

