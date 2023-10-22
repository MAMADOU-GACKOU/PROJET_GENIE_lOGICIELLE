/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author aa800033
 */
public class Macedoine implements Fruit{
    
    private  ArrayList<Fruit> Fruit_macedoine;
    

    public Macedoine() {
        this.Fruit_macedoine = new ArrayList<>();
    }
    
    
    
    public void ajoutFruitMacedoine(Fruit f){
        Fruit_macedoine.add(f);
    }

    public ArrayList<Fruit> getFruit_macedoine() {
        return Fruit_macedoine;
    }
    /**
     *@return le nombre de fruit contenue dans la macedoine
     **/
    public int getTailleMacedoine(){
        return this.Fruit_macedoine.size();
    }
    public Fruit getFruit(int i) {  //accesseur retournant le fruit contenu dans la macedoine a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
        return this.Fruit_macedoine.get(i);
    }
    @Override
    public boolean isSeedless() {
        
        int i=0;boolean vrai=true;
        while(i<this.getTailleMacedoine() && vrai==true){
            vrai =this.getFruit(i).isSeedless();
            i++;
        }
        return vrai;
    }

    @Override
    public double getPrix() {
        double prixttle =0;int i =0;
        while(i<this.getTailleMacedoine()){
            prixttle+= this.getFruit(i).getPrix();
            i++;
        }
        return prixttle;
    }

    //cette methode ne sera peut être pas implementer aprèsl'introduction de la classe abstrait FruitSimple 
    @Override
    public String getOrigine() {
        return "Je ne sais pas pour le moment ";
    }
    /**
     **@return une répresentation textuelle des fruits qui composent le macedoine
     **/
    @Override
    public String toString()
    {
        String texte ="Macedoine de ";
        int i =0;
        while(i<this.getTailleMacedoine()){
            texte += this.getFruit(i).getClass().getSimpleName()+",";
             i++;
        }
        texte += " a "+this.getPrix();
        return texte;
    }
    public static void main(String[] args) {
        Macedoine test;
        test = new Macedoine();
        test.ajoutFruitMacedoine(new Orange(10, "France"));
        test.ajoutFruitMacedoine(new Fraise());
        System.out.println(""+test.isSeedless());
        System.out.println(test.toString());
        
        

    }
    
}
