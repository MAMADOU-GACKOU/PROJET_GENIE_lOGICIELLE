/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

/**
 *
 * @author Wissam
 */
public class Banane extends FruitSimple {
    public Banane(double prix, String origine)
    {
        super(prix,origine);
    }
    public Banane()
    {
        super(0.99,"Espagne");
    }
    @Override
    public boolean isSeedless()
    {
        return false;
    }
    @Override
    public String toString()
    {
        return "Banane de " + this.getOrigine()+ " a " + this.getPrix() + " euros";
    }
    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Cerises sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Banane banane = (Banane) o;
            return ((banane.getPrix()==getPrix())  && banane.getOrigine().equals(getOrigine()));
        }
        return false;
    }  

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }
    
}
