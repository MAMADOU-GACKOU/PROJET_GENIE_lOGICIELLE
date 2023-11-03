/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.view;

import fr.ufrsciencestech.Fruits.Orange;
import fr.ufrsciencestech.Fruits.PanierPleinException;
import fr.ufrsciencestech.controler.Controleur;
import fr.ufrsciencestech.model.Modele;
import javax.swing.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
/**
 *
 * @author AAlmountassir
 */
public class VueGraphAjoutRetireTest {
    private static VueGraphAjoutRetire vueg;
    private Controleur c;
    private Modele m;
    private JComboBox<String> combobox;
     
    
    @Before
    public void setUp() {
        String ListeFruit[] = {};
        vueg = new VueGraphAjoutRetire(ListeFruit);
        m = new Modele(ListeFruit);
        c = new Controleur();
        
        c.setModele(m);
        c.setVue(vueg);
        m.addObserver(vueg);
        vueg.addControleur(c);
        combobox = new JComboBox<>();
        combobox.addItem("France");
        combobox.addItem("Bresil");
        combobox.addItem("Espagne");
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of update method, of class VueGraphAjoutRetire.
     */
    @Test
    public void testUpdate() throws PanierPleinException {
        assertEquals(vueg.getAffiche().getText(), "");
        /*m.p.ajout(new Orange()); 
        int cpt = m.p.getNbFruits();
        vueg.getAffiche().setText(((Integer)cpt).toString());
        assertEquals(vueg.getAffiche().getText(), "1");*/
        
        vueg.setAffiche(new JTextArea("Bonjour"));
        assertEquals(vueg.getAffiche().getText(), "Bonjour"); 
    }

  

    /**
     * Test des boutons plus ,moins et l'affichage (JTextArea)
     */
    @Test
    public void testInc() {
        System.out.println("incr, desc boutoun et affichage");
        assertNotNull(vueg);  // Instantiated?
        JTextArea res = (JTextArea)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        final JButton moins = (JButton)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(moins);
        //tests d'acceptation (de l'interface) : 
        plus.doClick();
        assertEquals(res.getText(), "Panier de 1 Fruits: 0.99\n");// par defaut une banane(à 0.99) est ajouté 
        plus.doClick();
        assertEquals(res.getText(), "Panier de 2 Fruits: 1.98\n");
        moins.doClick();
        assertEquals(res.getText(), "Panier de 1 Fruits: 0.99\n");// par defaut une banane(à 0.99) est ajouté 
        moins.doClick();
        assertEquals(res.getText(), "Panier de 0 Fruits: 0.0\n");

    }

    /**
     * Test de toutes des interactions sur une combobox
     */
    @Test
    public void testCombo() {
        System.out.println("getCombo");
       
        //on verifie que nos affichages correspondent bien aux élèments specifiés
       assertEquals(3, combobox.getItemCount());
        assertEquals("France", combobox.getItemAt(0));
        assertEquals("Bresil", combobox.getItemAt(1));
        assertEquals("Espagne", combobox.getItemAt(2));
        
        //on selectionne Espagne
        combobox.setSelectedIndex(2);
        //s'assurer que le pays selectionné est bien Espagne
        assertEquals(2, combobox.getSelectedIndex());
    }

   

   
    
}
