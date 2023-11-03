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
/*
Les tests d'IHM ne concernent uniquement que des tests d'affichage au bon bon endroit etle bon texte demandé 
*/
public class VueGraphSwingTest {
    private static VueGraphSwing vueg;
    private Controleur c;
    private Modele m;

    @Before
    public void setUp() {
        vueg = new VueGraphSwing();
        String ListeFruit[] = {};
        m = new Modele(ListeFruit);
        c = new Controleur();
        
        c.setModele(m);
        c.setVue(vueg);
        m.addObserver(vueg);
        vueg.addControleur(c);
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of update method, of class VueGraphique.
     */
    @Test
    public void testUpdate() throws PanierPleinException {
        System.out.println("update");
        
        //si on oublie d'ajouter la vue comme observateur du modele, elle ne se met pas à jour correctement
        assertEquals(vueg.getAffiche().getText(), "0");
        m.p.ajout(new Orange()); 
        int cpt = m.p.getNbFruits();
        vueg.getAffiche().setText(((Integer)cpt).toString());
        assertEquals(vueg.getAffiche().getText(), "1");
        
        vueg.setAffiche(new JLabel("0", JLabel.CENTER));
        assertEquals(vueg.getAffiche().getText(), "0");       
    }
    

    @Test
    public void testIncr() {
        System.out.println("incr");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        
        //tests d'acceptation (de l'interface) : 
        plus.doClick();
        assertEquals(res.getText(), "1");
        plus.doClick();
        assertEquals(res.getText(), "2");
    }
    
    
    @Test
    public void testDecrOk() {
        System.out.println("decr");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        plus.doClick();
        assertEquals(res.getText(), "1");
        minus.doClick();
        assertEquals(res.getText(), "0");
    }
    
    @Test
    public void testDecrZero() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        minus.doClick();
        assertEquals(res.getText(), "0");
    }

    
}
