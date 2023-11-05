/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;

/**
 *
 * @author aa800033
 */
public class JusTest {
    /*on généralise en créant un attribut de type fruit et de cette façon
    on peut tester avec tous les fruit(Orange,fraise ,banane etc..)
    */
    private Fruit fruit1;
    //private Jus jusMock;

    @Before
    public void setUp(){
        //on peut faire les tests avec tous les fruits simple mais on prend par exemple Fraise
        fruit1 = mock(Orange.class);
        
    }
    @After
    public void tear(){
        
    }
   
    
    @Test
    public void testGetPrix(){
        when(fruit1.getPrix()).thenReturn(0.5);
       Jus jusMock = new Jus(fruit1 ,"Orange");
        double res = jusMock.getPrix();
        //tests d’interaction :
        verify(fruit1, times(1)).getPrix(); //getPrix() doit avoir été appelé
        //exactement 1 fois sur mocko1
        assertFalse(res == 3.5); 
        assertEquals(res,1.5,0.01);
    }
    
    

   
    
    //Les tests d'intégration
    @Test
    public void testToString() {
        System.out.println("toString");
        Fruit fraise = new Fraise(4,"Espagne");
        Jus jus = new Jus(fraise,"Fraise");
        String expected = "Espagne";
        String actual = jus.getOrigine();
        assertEquals(expected,actual);
    }

    /**
     * Test of getOrigine method, of class Jus.
     */
    @Test
    public void testGetOrigine() {
        System.out.println("getOrigine");
        Fruit fruit = new Orange(4, "Espagne");
        Jus jus = new Jus(fruit, "Orange");  
        String expected = "Espagne";
        String actual = jus.getOrigine();
        assertEquals(expected, actual);
    }

    /**
     * Test of isSeedless method, of class Jus.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        Fruit fruit = new Orange(4, "Espagne");        
        Jus jus = new Jus(fruit, "Orange");
        boolean expected = false;
        boolean actual = jus.isSeedless();
        assertEquals(expected, actual);
    }

   
}
