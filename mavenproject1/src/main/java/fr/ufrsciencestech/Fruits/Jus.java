/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

/**
 *
 * @author djera
 */
public class Jus implements Fruit{
    
    private Fruit fruit;
    
    
    public Jus (Fruit fruit)
    {
        this.fruit=fruit;
    }

    
   
    @Override
    public boolean isSeedless() {
        return fruit.isSeedless();
    }

    @Override
    public double getPrix() {
        return fruit.getPrix()*2; // ici  le jus est 2 fois le prix de son composant fruit
    }

    @Override
    public String getOrigine() {
        
    return fruit.getOrigine();
    }
    
    public String toString ()
            
    {
        return "Jus de prix :"+this.getPrix()+" euros composé du fruit "+fruit.toString();
    }
    
    public static void main(String arg[])
    {
        // test du jus
        Fruit or = new Orange();
        // jus d'orange
        Jus orange =  new Jus (or);
        
        Fruit fr= new Fraise();
        
        Macedoine MJ= new Macedoine();
        
        MJ.AjoutFruitMacedoine(fr);
        MJ.AjoutFruitMacedoine(or);
        // jue composé d'une macedoine de fruit
        Jus Jmacedoine = new Jus(MJ);
        System.out.println(orange.toString());
        
        System.out.println(Jmacedoine.toString());
        
        Jus Jmacedoine1 = new Jus(orange);
         System.out.println(Jmacedoine1.toString());
        
    }
}
