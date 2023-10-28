/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;
import java.lang.String;
/**
 *
 * @author aa800033
 */
public abstract class JusDeFruitDecorateur implements Fruit{
   protected Fruit fruit;
   protected String TYPE;
    public JusDeFruitDecorateur(Fruit fruit,String TYPE) {
        this.fruit = fruit;
        this.TYPE = TYPE;
    }

    /**
     *
     * @return le type du fruit qui est son 
     */
    public String getTYPE() {
        return TYPE;
    }
   
    /**
     *
     * @return le prix d'un jus en fonction du type de son constituant ,c'est à dire orang ou banane etc..
     */
    @Override
    public double getPrix() {
       double prixJusFruit =0;
       double prixBaseFruit = fruit.getPrix();
       String nomFruit = TYPE;
       switch(nomFruit){//j'aimerai que les cases soient pas sensible
        case "Orange": 
            prixJusFruit =1;
            break;
        case "Fraise":
            prixJusFruit =2.5;break;
        default:
            prixJusFruit =0.5;break;
           
         }

       return (prixJusFruit+prixBaseFruit);
       
    }

    
    
}
