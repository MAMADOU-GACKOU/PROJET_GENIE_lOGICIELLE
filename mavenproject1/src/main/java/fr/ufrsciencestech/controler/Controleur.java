/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.controler;

import fr.ufrsciencestech.view.VueG;
import fr.ufrsciencestech.model.Modele;
import fr.ufrsciencestech.Fruits.PanierPleinException;
import fr.ufrsciencestech.Fruits.PanierVideException;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aa800033
 */
public class Controleur implements ActionListener{
     private Modele m;
    private VueG vg;

    @Override
    public void actionPerformed(ActionEvent e) {   //Invoked when an action occurs

        String petName ="";
        if (((Component) e.getSource()).getName().equals("Combobox")) 
        {
            JComboBox cb;
            
                cb = (JComboBox) e.getSource(); 
                petName = (String) cb.getSelectedItem();
                m.p.setMessage(petName);
         }
        else if (((Component) e.getSource()).getName().equals("Plus")) 
        {
                try {

                m.update(m.p.getMessage());
            } catch (PanierPleinException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
            try {
            m.updateR();
        } catch (PanierVideException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setModele(Modele m) {
        this.m = m;
    }

    public void setVue(VueG vg) {
        this.vg = vg;
    }

}