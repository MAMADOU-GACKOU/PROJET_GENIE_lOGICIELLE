/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author aa800033
 */
public class JusDeFruitDecorateurTest {
    
    /**
     * Test of getTYPE method, of class JusDeFruitDecorateur.
     */
    @Test
    public void testGetTYPE() {
        System.out.println("getTYPE");
        Fruit fruit = new Fraise(); 
        
        JusDeFruitDecorateur jus = new Jus(fruit, "Fraise");
        String expected = "Fraise";
        String actual = jus.getTYPE();
        assertEquals(expected, actual); 
        
        
       
    }

    /**
     * Test of getPrix method, of class JusDeFruitDecorateur.
     */
    @Test
    public void testGetPrix() {
        System.out.println("getPrix");
        Fruit fruit = new Fraise(); 
        
        JusDeFruitDecorateur jus = new Jus(fruit, "Fraise");
        double expected = 3.0;
        double actual = jus.getPrix();
        assertEquals(expected, actual, 0.001); 
        
       
    }
    
}
