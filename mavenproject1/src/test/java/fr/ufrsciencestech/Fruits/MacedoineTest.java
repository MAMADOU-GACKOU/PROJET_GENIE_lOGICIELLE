
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
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
    
    //test d'intégration
    private Ananas ananas;
    private Banane banane;
    
    @Before
    public void setUp(){
        fruit1 = mock(Orange.class); //doublures
        fruit2 = mock(Orange.class);
        macedoine = new Macedoine();
        listeFruit = new ArrayList<Fruit>();
        listeFruit.add(fruit1);
        listeFruit.add(fruit2);
        
        
        ananas = new Ananas();
        banane = new Banane(1.5 ,"Inde");        
    }
    
    @After
    public void tear(){
        
    }
     @Test
     public void testGetPrixMock(){
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
     *Permet vérifier si un fruit est belle et bien ajouter à une macedoine en utilisant Mock
     */
    @Test 
     public void testAjoutFruitMacedoineMock(){//Macedoine vide 
        macedoine.AjoutFruitMacedoine(fruit1);
        macedoine.AjoutFruitMacedoine(fruit2);
         assertTrue(macedoine.getNbreElement()==2);
     }

    /**
     *Test si on peut ajouter à une macedoine directement une liste des fruits (pas à l'unité)
     */
    @Test
     public void testAjoutListeFruitMacedoineMock(){
         
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
    /*@Test
     public void testGetOrigine(){
         macedoine.AjoutFruitMacedoine(fruit1);
         when(fruit1.getOrigine()).thenReturn("France");
         String resultat = macedoine.getOrigine();
         System.out.println(resultat);
         assertEquals("Macedoine  de fruits d'origine :France", resultat);
     }*/
     
     //les différents methodes de tests d'intégration,ils terminent par Int pour dire intégration
     @Test
     public void testGetPrixInt(){
       
        macedoine.AjoutFruitMacedoine(ananas);
        macedoine.AjoutFruitMacedoine(banane);
        double res = macedoine.getPrix(); 
        assertTrue(res ==4.5); //le prix de l'ananas par défaut est à 3€
     }
     
     @Test 
     public void testAjoutFruitMacedoineInt(){
        //Macedoine vide 
        assertFalse(macedoine.getNbreElement()==2);//pour vérifier si vraiment la macedoine est vide au départ
        macedoine.AjoutFruitMacedoine(ananas);
        macedoine.AjoutFruitMacedoine(banane);
         assertTrue(macedoine.getNbreElement()==2);
     }
     
     @Test
     public void testAjoutListeFruitMacedoineInt(){
         ArrayList<Fruit> liste = new ArrayList<Fruit>();
         liste.add(ananas);liste.add(banane);
         assertTrue(macedoine.getNbreElement()==0);
         macedoine.AjoutFruitMacedoine(new Orange());
         assertTrue(macedoine.getNbreElement()==1);
         macedoine.AjoutListeFruitMacedoine(listeFruit);
         assertTrue(macedoine.getNbreElement()==3);
         assertFalse(macedoine.getNbreElement()!=3);
     }
     /*@Test
     public void testGetOrigine(){
         macedoine.AjoutFruitMacedoine(ananas);
         String resultat = macedoine.getOrigine();
         System.out.println(resultat);
         String output = "Macedoine  de fruits d'origine :\n";
         output+=ananas.toString()+"\n";
                  System.out.println(output);

         assertTrue(output.equalsIgnoreCase(resultat) );
     }
    */
}
