/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author aa800033
 */
public class OrangeTest {
     Orange o;
    
    @Before
    public void setUp(){
         o = new Orange();
    }
    
    @After
    public void tear(){
    }
    
    @Test
    public void  testGetPrix(){ 
       // Orange o = new Orange();
        assertTrue(o.getPrix()==0.5);
        assertFalse(o.getPrix() != 0.5);
    }
    
    @Test
    public void  testSetPrix(){ 
       // Orange o = new Orange();
       o.setPrix(80);
        assertTrue(o.getPrix()==80);
        assertFalse(o.getPrix() != 80);
    }
}
