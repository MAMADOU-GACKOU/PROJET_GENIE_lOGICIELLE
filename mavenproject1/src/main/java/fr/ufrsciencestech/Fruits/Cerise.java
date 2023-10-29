/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

/**
 *
 * @author Wissam
 */
public class Cerise extends FruitSimple {
    public Cerise(double prix, String origine)
    {
        super(prix, origine);
    }
    public Cerise()
    {
        super(0.5,"Espagne");
    }
    @Override
    public boolean isSeedless()
    {
        return true;
    }
    @Override
    public String toString()
    {
        return "Cerise de " + this.getOrigine()+ " a " + this.getPrix() + " euros";
    }
    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Cerises sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Cerise cerise = (Cerise) o;
            return ((cerise.getPrix()==getPrix())  && cerise.getOrigine().equals(getOrigine()));
        }
        return false;
    }    
}
