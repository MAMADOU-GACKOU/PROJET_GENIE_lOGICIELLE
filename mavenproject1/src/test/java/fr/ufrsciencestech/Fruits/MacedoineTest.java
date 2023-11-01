/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

import fr.ufrsciencestech.Fruits.Orange;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;
/**
 *
 * @author aa800033
 */
public class MacedoineTest {
    private Fruit fruit1;
    private Fruit fruit2;
    private Macedoine macedoine ;
    private ArrayList<Fruit> listeFruit;//une liste de fruits
    
    @Before
    public void setUp(){
        fruit1 = mock(Orange.class); //doublures
        fruit2 = mock(Orange.class);
        macedoine = new Macedoine();
        listeFruit = new ArrayList<Fruit>();
        listeFruit.add(fruit1);
        listeFruit.add(fruit2);
    }
    
    @After
    public void tear(){
        
    }
     @Test
     public void testGetPrix(){
        when(fruit1.getPrix()).thenReturn(1.5); //comportements des doublures
        when(fruit2.getPrix()).thenReturn(2.0);
        macedoine.AjoutFruitMacedoine(fruit1);
        macedoine.AjoutFruitMacedoine(fruit2);
        double res = macedoine.getPrix(); 
        verify(fruit1, times(1)).getPrix(); //getPrix() doit avoir été appelé
        //exactement 1 fois sur mocko1
        verify(fruit1, times(1)).getPrix();
        assertTrue(res == 3.5); 
     }
     
    /**
     *Permet vérifier si un fruit est belle et bien ajouter à une macedoine
     */
    @Test 
     public void testAjoutFruitMacedoine(){//Macedoine vide 
        macedoine.AjoutFruitMacedoine(fruit1);
        macedoine.AjoutFruitMacedoine(fruit2);
         assertTrue(macedoine.getNbreElement()==2);
     }

    /**
     *Test si on peut ajouter à une macedoine directement une liste des fruits (pas à l'unité)
     */
    @Test
     public void testAjoutListeFruitMacedoine(){
         
         macedoine.AjoutListeFruitMacedoine(listeFruit);
         assertTrue(macedoine.getNbreElement()==2);
         assertFalse(macedoine.getNbreElement()!=2);
     }
     
     
     /* Ce commentaire est dedié à l'équipe de développement
     actuelement ce test ne fonctionne pas à cause de mauvaise choix d'affichage de la 
     fonction origine de macedoine */
     
    /**
     *Tester pour voir si on a le même affichage de l'origine de la macedoine
     */
    @Test
     public void testGetOrigine(){
         macedoine.AjoutFruitMacedoine(fruit1);
         when(fruit1.getOrigine()).thenReturn("France");
         String resultat = macedoine.getOrigine();
         System.out.println(resultat);
         assertEquals("Macedoine  de fruits d'origine :France", resultat);
     }
     
    
}
