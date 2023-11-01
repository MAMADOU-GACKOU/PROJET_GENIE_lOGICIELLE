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
    private Fraise fruit1;
    //private Jus jusMock;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @After
    public void setUp(){
        //on peut faire les tests avec tous les fruits simple mais on prend par exemple Fraise
        fruit1 = mock(Fraise.class);
        
    }
    @Before
    public void tear(){
        
    }
    
    @Test
    public void testGetPrix(){
       Jus jusMock = new Jus(fruit1 ,"Fraise");
       
        when(fruit1.getPrix()).thenReturn(0.5);
        
        double res = jusMock.getPrix();
        //tests d’interaction :
        verify(fruit1, times(1)).getPrix(); //getPrix() doit avoir été appelé
        //exactement 1 fois sur mocko1
        assertTrue(res == 3.5); 
    }
    
    

    /**
     * Test of toString method, of class Jus.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
    }

    /**
     * Test of getOrigine method, of class Jus.
     */
    @Test
    public void testGetOrigine() {
        System.out.println("getOrigine");
        
    }

    /**
     * Test de la methode isSeedless de la class Jus.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        
    }

    
    
}
