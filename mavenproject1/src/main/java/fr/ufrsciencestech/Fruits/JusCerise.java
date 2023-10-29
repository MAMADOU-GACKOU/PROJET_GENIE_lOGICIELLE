/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

/**
 *
 * @author mamadougackou
 */
public class JusCerise extends DecoratorFruit {
    
     public JusCerise(Fruit fruit){
        this.fruit = fruit;
    }
    
    public  double getPrix(){
        return   fruit.getPrix();
    }
    
  public String getOrigine(){
       return fruit.getOrigine();
  }
  
  
  public String toString(){
  return  "Jus(Cerise)" +" "+ fruit.getPrix() ;
  }

    @Override
    public boolean isSeedless() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
