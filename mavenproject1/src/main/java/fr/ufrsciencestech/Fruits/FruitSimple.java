/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

/**
 *
 * @author djera
 */
public class FruitSimple  implements Fruit {

    protected  double prix ;
    protected  String origine;
    
    
    public FruitSimple(double prix,String origine)
    {
       if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "Espagne";  //Espagne par défaut
	else
            this.origine = origine; 
        
    }
    
    
    
    @Override
    public boolean isSeedless() {
        return false;
    }

    @Override
    public double getPrix() {
        return prix;
    }

    @Override
    public String getOrigine() {
           return origine;
        }
    
    
     public String toString(){
        return "FruitSimple de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object f){  //predicat pour tester si 2 FruitSimple sont equivalents
        if(f != null && getClass() == f.getClass()){
            FruitSimple fr= (FruitSimple) f;
            return (prix == fr.prix && origine.equals(fr.origine));
        }
        return false;
    }
    
     // Setter spécifique à Orange pour modifier le nom
   
}

 