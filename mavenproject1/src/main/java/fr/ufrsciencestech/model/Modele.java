/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.model;
import fr.ufrsciencestech.Fruits.PanierPleinException;
import fr.ufrsciencestech.Fruits.*;
import fr.ufrsciencestech.Fruits.PanierVideException;
import java.util.Observable;

import java.util.Observable;

/**
 *
 * @author aa800033
 */
public class Modele extends Observable{
    public Panier p;//à remmtre en private
    // ici c la liste prévu pour mon modele 
    private String Liste[]= {"Orange","Fraise","Pomme"};
    
    private int compteur;
    int nb = 50;    
    public Modele(String items[]){
        // initialisation 
       this.p = new Panier(nb);
       this.Liste=items;
       /* ici je donne la mm liste a mon panier pour que je puisse l'utiliser 
        dans la methode getMessage pour affiché selon c fruits dans l'ihm */
       p.setStringList(Liste);
       
       compteur = 0;
    }
    public void update(String FruitName) throws PanierPleinException{
        
        p.ajout(p.createFruit(FruitName));
        setChanged();
        compteur = p.getNbFruits();
         notifyObservers(p);
    }
    public void updateR() throws PanierVideException {
        p.retrait();
        setChanged();
        compteur = p.getNbFruits();
        notifyObservers(p);
   
    }

   // pour affecter une nouvelle liste de fruit
      public void setStringList(String items[])
    {
        this.Liste=items;
         p.setStringList(Liste); // Mettez à jour la liste de chaînes dans le panier
         setChanged();
         notifyObservers(p);
    }
    
      // retourne la liste actuel de fruit 
    public  String[] getStringList()
    {
        return Liste;
    }

   public Panier getPanier()
   {
       return p;
   }
    
   public void setPanier(Panier p)
   {
       this.p=p;
   }
   
    /**
     * @return the compteur
     */
    public int getCompteur() {
        return compteur;
    }

    /**
     * @param compteur the compteur to set
     */
    public void setCompteur(int compteur) {
        this.compteur = compteur;
        if(this.compteur < 0)
            this.compteur = 0;
        setChanged();                //marks this Observable object as having been changed; the hasChanged method will now return true
        notifyObservers(getCompteur());   //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed
    }
    
   
    
}