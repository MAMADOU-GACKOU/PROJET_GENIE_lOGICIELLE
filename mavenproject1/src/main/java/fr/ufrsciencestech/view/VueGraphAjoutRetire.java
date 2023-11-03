/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.view;

import fr.ufrsciencestech.Fruits.Panier;
import fr.ufrsciencestech.controler.Controleur;
import java.awt.BorderLayout;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author aa800033
 */
public class VueGraphAjoutRetire extends JFrame implements VueG{

    private JButton inc;
    private JButton dec;
    private JTextArea affiche;
    private JComboBox combo;
    private JPanel panelNorth;
    private String ListeFruit[];
    
    

    public VueGraphAjoutRetire(String ListeFruit[])

    {
        super("Magasin");
        
        String items[]=ListeFruit;
        inc = new JButton("+");
        dec = new JButton("-");
        affiche = new JTextArea();
        combo = new JComboBox(items);
        
        //combo.setSelectedIndex(0);
        panelNorth = new JPanel();
        add(panelNorth, BorderLayout.NORTH);
        add(dec, BorderLayout.SOUTH);
        add(affiche, BorderLayout.CENTER);
        panelNorth.add(inc, BorderLayout.BEFORE_FIRST_LINE);
        panelNorth.add(combo, BorderLayout.BEFORE_LINE_BEGINS);

        inc.setName("Plus");
        dec.setName("Moins");
        affiche.setName("Affichage");
        combo.setName("Combobox");
        this.pack();
        this.setSize(300, 200);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public void addControleur(Controleur c) {
        getInc().addActionListener(c);
        getDec().addActionListener(c);
        getCombo().addActionListener(c);
    }

    /**
     *
     * @param m
     * @param p le panier
     */
    @Override
    public void update(Observable m, Object p) {     //This method is called whenever the observed object is changed
        /* int compte = ((Panier) p).getNbFruits();
        try {
            getAffiche().setText(((Integer)compte).toString());
        } catch (Exception e) {
            System.out.print(compte);
        }
         */
       
        
        getAffiche().setText((((Panier) p).afficheContenuPanier()));
        
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
     * @return the combo
     */
    public JComboBox getCombo() {
        return combo;
    }

    /**
     * @param combo the dec to set
     */
    public void setCombo(JComboBox combo) {
        this.combo = combo;
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
    public JTextArea getAffiche() {
        return affiche;
    }

    /**
     * @param affiche the affiche to set
     */
    public void setAffiche(JTextArea affiche) {
        this.affiche = affiche;
    }
    
    
     public void setStringListVue(String items[])
    {
        this.ListeFruit=items;
    }
    
    public  String[] getStringListVue()
    {
        return ListeFruit;
    }
    
    
}
