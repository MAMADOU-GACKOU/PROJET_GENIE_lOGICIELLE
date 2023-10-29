/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author djera
 */
public class OrangeTest {
    
    Orange Otest;
    
    public OrangeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Otest=new Orange();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPrix method, of class Orange.
     */
    @Test
    public void testGetPrix() {
        System.out.println("getPrix");
        
        double prix=0.5;
        assertTrue(Otest.getPrix()==prix);
        assertFalse(Otest.getPrix()!=prix);
      
    }

    /**
     * Test of setPrix method, of class Orange.
     */
    @Test
    public void testSetPrix() {
        System.out.println("setPrix");
        double prix =0.5;
        double prixNegatif= -0.5;
        Otest.setPrix(prix);
        // un prix +
        assertTrue(Otest.getPrix()==prix);
        Orange OtestNegatif= new Orange();
        //  un prix - devient 0
        Otest.setPrix(prixNegatif);
        assertTrue(OtestNegatif.getPrix()>=0);
        
        assertFalse(OtestNegatif.getPrix()==prixNegatif);
    }

    /**
     * Test of getOrigine method, of class Orange.
     */
    @Test
    public void testGetOrigine() {
        System.out.println("getOrigine");
        
        String origine="Espagne";
        String origineN ="France";
        assertTrue(Otest.getOrigine().equals(origine));
        assertFalse(Otest.getOrigine().equals(origineN));
     
    }

    /**
     * Test of setOrigine method, of class Orange.
     */
    @Test
    public void testSetOrigine() {
        System.out.println("setOrigine");
        String origine="Italie";
        Otest.setOrigine(origine);
        
        assertTrue(Otest.getOrigine().equals(origine));
        
        assertFalse(Otest.getOrigine().equals("Espagne"));
        
    }

    /**
     * Test of toString method, of class Orange.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String resultatAttendu = "Orange de Espagne a 0.5 euros";
        String resultatObtenu = Otest.toString();
        String resultatNonAttendu =" Orange de Espagne a 0.5 euros ";  
        
        assertEquals(resultatAttendu, resultatObtenu);
        assertNotEquals(resultatAttendu,resultatNonAttendu);
    }

    /**
     * Test of equals method, of class Orange.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Fraise fraise= new Fraise();
        Object o= null;
         Orange orange1 = new Orange(1.0, "France");
        Orange orange2 = new Orange(1.0, "France");

        // les deux oranges sont équivalentes
        assertTrue(orange1.equals(orange2));

        
        Orange orange3 = new Orange(2.0, "Italie");

        // l'orange 1 n'est pas équivalente à l'orange 3
        assertFalse(orange1.equals(orange3));

        //  l'orange 1 n'est pas équivalente à un objet null
        assertFalse(orange1.equals(o));

        //  l'orange 1 n'est pas équivalente à une autre classe (non Orange)
        assertFalse(orange1.equals(fraise));
    }

    /**
     * Test of isSeedless method, of class Orange.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        
         boolean resultatObtenu = Otest.isSeedless();

         
         assertFalse(resultatObtenu);
    }
    
}
