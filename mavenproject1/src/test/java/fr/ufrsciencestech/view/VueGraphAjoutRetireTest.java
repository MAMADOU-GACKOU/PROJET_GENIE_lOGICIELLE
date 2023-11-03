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
        m.p.ajout(new Orange()); 
        /*int cpt = m.p.getNbFruits();
        vueg.getAffiche().setText(((Integer)cpt).toString());
        assertEquals(vueg.getAffiche().getText(), "1");*/
        
        vueg.setAffiche(new JTextArea("Bonjour"));
        assertEquals(vueg.getAffiche().getText(), "Bonjour"); 
    }

    /**
     * Test of getInc method, of class VueGraphAjoutRetire.
     */
    @Test
    public void testGetInc() {
        System.out.println("getInc");
        VueGraphAjoutRetire instance = null;
        JButton expResult = null;
        JButton result = instance.getInc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInc method, of class VueGraphAjoutRetire.
     */
    @Test
    public void testSetInc() {
        System.out.println("incr boutoun");
        assertNotNull(vueg);  // Instantiated?
        JTextArea res = (JTextArea)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        
        //tests d'acceptation (de l'interface) : 
        plus.doClick();
        assertEquals(res.getText(), "1");
        plus.doClick();
        assertEquals(res.getText(), "2");
    }

    /**
     * Test of getCombo method, of class VueGraphAjoutRetire.
     */
    @Test
    public void testGetCombo() {
        System.out.println("getCombo");
        assertNotNull(vueg);  // Instantiated?
        JComboBox res = (JComboBox)TestUtils.getChildNamed(vueg, "combobox");
        assertNotNull(res); // Component found?
        
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

   

    /**
     * Test of getDec method, of class VueGraphAjoutRetire.
     */
    @Test
    public void testGetDec() {
        System.out.println("getDec");
        VueGraphAjoutRetire instance = null;
        JButton expResult = null;
        JButton result = instance.getDec();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDec method, of class VueGraphAjoutRetire.
     */
    @Test
    public void testSetDec() {
        System.out.println("setDec");
        JButton dec = null;
        VueGraphAjoutRetire instance = null;
        instance.setDec(dec);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAffiche method, of class VueGraphAjoutRetire.
     */
    @Test
    public void testGetAffiche() {
        System.out.println("getAffiche");
        VueGraphAjoutRetire instance = null;
        JTextArea expResult = null;
        JTextArea result = instance.getAffiche();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAffiche method, of class VueGraphAjoutRetire.
     */
    @Test
    public void testSetAffiche() {
        System.out.println("setAffiche");
        JTextArea affiche = null;
        VueGraphAjoutRetire instance = null;
        instance.setAffiche(affiche);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStringListVue method, of class VueGraphAjoutRetire.
     */
    @Test
    public void testSetStringListVue() {
        System.out.println("setStringListVue");
        String[] items = null;
        VueGraphAjoutRetire instance = null;
        instance.setStringListVue(items);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStringListVue method, of class VueGraphAjoutRetire.
     */
    @Test
    public void testGetStringListVue() {
        System.out.println("getStringListVue");
        VueGraphAjoutRetire instance = null;
        String[] expResult = null;
        String[] result = instance.getStringListVue();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
}
