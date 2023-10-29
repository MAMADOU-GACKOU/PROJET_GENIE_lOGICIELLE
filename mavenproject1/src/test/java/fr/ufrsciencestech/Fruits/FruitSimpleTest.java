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
 * @author Wissam
 */
public abstract class FruitSimpleTest {
    
    public FruitSimpleTest() {
    }
    @Test
    public void testGetPrix() {
        System.out.println("getPrix");
        
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPrix method, of class FruitSimple.
     */


    /**
     * Test of getOrigine method, of class FruitSimple.
     */
    @Test
    public void testGetOrigine() {
        System.out.println("getOrigine");
        FruitSimpleImpl fruit= new FruitSimpleImpl();
        
        
        ;
    }

    public class FruitSimpleImpl extends FruitSimple {

        public FruitSimpleImpl() {
            super(0.0, "");
        }
        public FruitSimpleImpl(double prix, String origine)
        {
            super(prix, origine);
        }

    }
    
}
