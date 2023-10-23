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
    private int compteur;
    int nb = 50;    
    public Modele(){
       this.p = new Panier(nb);
       compteur = 0;
    }
    public void update(String FruitName) throws PanierPleinException{
        
        this.p.ajout(this.p.createFruit(FruitName));
        setChanged();
        compteur = this.p.getNbFruits();
         notifyObservers(p);
    }
    public void updateR() throws PanierVideException {
        this.p.retrait();
        setChanged();
        compteur = this.p.getNbFruits();
        notifyObservers(p);
   
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