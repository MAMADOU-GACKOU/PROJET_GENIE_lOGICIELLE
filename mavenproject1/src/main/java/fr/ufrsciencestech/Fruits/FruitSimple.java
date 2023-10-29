/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

/**
 *
 * @author Wissam
 */
public abstract class FruitSimple implements Fruit {
    double prix;
    String origine;
    
    public FruitSimple(double prix, String origine)
    {
        if(prix<0)
            this.prix = -prix;
        else
            this.prix = prix;
        if(origine.isEmpty())
            this.origine ="origine inconnu";
        else 
            this.origine =origine;        
    }
    public double getPrix()
    {
        return prix;
    }
    
    public String getOrigine()
    {
        return origine;
    }
    public boolean isSeedless()
    {
        return false;
    }
}
