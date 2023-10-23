/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

import fr.ufrsciencestech.Fruits.Orange;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 *
 * @author aa800033
 */
public class PanierTest {
    private Panier pVide,pPlein;
    private Panier o1,o2;
    private Orange mocko1;
    private Orange mocko2;
    
    @Before
    public void setUp() throws PanierPleinException
    {
        pVide = new Panier(3);
        pPlein = new Panier(1);
        pPlein.ajout(new Orange());
         mocko1 = mock(Orange.class); //doublures
         mocko2 = mock(Orange.class);
    }
    @After
    public void tear(){}
    
    /**
     * test unitaire simple ou encore d'acceptation
     * @throws PanierPleinException
     */
    @Test
    public void testAjoutePanier() throws PanierPleinException{
        pVide.ajout(new Orange());
        assertTrue(pVide.getNbFruits()==1);
        assertFalse(pVide.estVide());
        assertEquals(pVide.getFruit(0), new Orange());
    }
    
    //test d'isolation

    /**
     *
     * @throws PanierPleinException
     * Test d'isolation de la fonction getPrix
    **/
    @Test
    public void testGetPrixMock() throws PanierPleinException {
        Panier panier = new Panier(3); //panier vide de cont. max = 3
        
        when(mocko1.getPrix()).thenReturn(0.5); //comportements des doublures
        when(mocko2.getPrix()).thenReturn(1.0);
        panier.ajout(mocko1);
        panier.ajout(mocko2);
        double res = panier.getPrix(); //test avec la DT3 de getPrix()
        //tests d’interaction :
        verify(mocko1, times(1)).getPrix(); //getPrix() doit avoir été appelé
        //exactement 1 fois sur mocko1
        verify(mocko2, times(1)).getPrix();
        assertTrue(res == 1.5); //oracle
        }
    
    @Test
    public void testAjoutValideMock() throws PanierPleinException {
        Panier p3 = new Panier(3);
        assertTrue(p3.getNbFruits()== 0);
        p3.ajout(mocko1); //test avec la DT1 de ajout
        assertTrue(p3.getNbFruits()== 1); //oracle
        p3.ajout(mocko2); //test avec la DT2 de ajout
        assertTrue(p3.getNbFruits()== 2); //oracle
    }
}
