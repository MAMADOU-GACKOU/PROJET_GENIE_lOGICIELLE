/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

/**
 *
 * @author mamadougackou
 */
public abstract class DecoratorFruit implements Fruit{
    protected Fruit fruit;

       public abstract double getPrix();
         public abstract String getOrigine();
 
    public static void main(String[] args) {
      
        Fruit swift = new Banane(3,"usa");
        swift = new Jusbanane(swift);
        
        System.out.println(swift.toString());
    }
}
