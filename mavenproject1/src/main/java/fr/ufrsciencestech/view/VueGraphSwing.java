/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.view;

import fr.ufrsciencestech.controler.Controleur;
import fr.ufrsciencestech.Fruits.Panier;
import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author aa800033
 */
public class VueGraphSwing extends JFrame implements VueG{
     private JButton inc;
    private JButton dec;
    private JLabel affiche;
    
   

    public VueGraphSwing() {
       super ("CompteurSwing");
        inc = new JButton("+");
        dec = new JButton("-");
        affiche = new JLabel("0", JLabel.CENTER);
        add(inc, BorderLayout.NORTH);
        add(dec, BorderLayout.SOUTH);
        add(affiche, BorderLayout.CENTER);
        
        inc.setName("Plus");
        dec.setName("Moins");
        affiche.setName("Affichage");
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    
    public void addControleur(Controleur c){
        getInc().addActionListener(c);
        getDec().addActionListener(c);
    }
    
    @Override
    public void update(Observable m, Object p){     //This method is called whenever the observed object is changed
        int compte = ((Panier) p).getNbFruits();
        try {
            getAffiche().setText(((Integer)compte).toString());
        } catch (Exception e) {
            System.out.print(compte);
        }
        
    }

    /**
     * @return the inc
     */
    public JButton getInc() {
        return inc;
    }

    /**
     * @param inc the inc to set
     */
    public void setInc(JButton inc) {
        this.inc = inc;
    }

    /**
     * @return the dec
     */
    public JButton getDec() {
        return dec;
    }

    /**
     * @param dec the dec to set
     */
    public void setDec(JButton dec) {
        this.dec = dec;
    }

    /**
     * @return the affiche
     */
    public JLabel getAffiche() {
        return affiche;
    }

    /**
     * @param affiche the affiche to set
     */
    public void setAffiche(JLabel affiche) {
        this.affiche = affiche;
    }
}
