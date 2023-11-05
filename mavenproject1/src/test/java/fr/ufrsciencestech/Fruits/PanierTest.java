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
public class PanierTest {
    private Panier pVide,pPlein;
    private Panier o1,o2;
    private Fruit mocko1;
    private Fruit mocko2;
    
    //une autre partie
     Fruit O1 ;
    Fruit O2 ;
    Fruit O3 ; 
    Panier PTest;
    Panier pTest1;
    ArrayList<Fruit> fruitsTest ;
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    
    @Before
    public void setUp() throws PanierPleinException
    {
        pVide = new Panier(3);
        pPlein = new Panier(1);
        pPlein.ajout(new Orange());
         mocko1 = mock(Orange.class); //doublures
         mocko2 = mock(Orange.class);
         
         //
          // initialisation 
       O1 = new Orange();
       O2 = new Orange(0.4,"France");
       O3= new Orange(0.2,"Italie");
       fruitsTest = new ArrayList<Fruit>(); 
       
       
       
       PTest = new Panier(5);
       pTest1= new Panier(5);
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


    /**
     * Test of toString method, of class Panier.
     */
    @Test
    public void testToString() throws PanierPleinException{
        
        System.out.println("toString");
        
        PTest.ajout(O1);
        PTest.ajout(O2);
        PTest.ajout(O3);
        
        String resultatAttendu =O1.toString()+"\n"+O2.toString()+"\n"+O3.toString()+"\n";
        String resultatObtenu =PTest.toString() ; 
        // ini on compare le résultat obtenu avec le résultat attendu
        assertEquals(resultatAttendu, resultatObtenu);
    }
        
    

    /**
     * Test of getFruits method, of class Panier.
     */
    @Test
    public void testGetFruits() throws PanierPleinException  {
        System.out.println("getFruits");
       
       
       
        fruitsTest.add(O1);
        fruitsTest.add(O2);
        fruitsTest.add(O3);
        pTest1.ajout(O1);
        pTest1.ajout(O2);
        pTest1.ajout(O3);
        
        
        System.out.println("le panier " +pTest1.toString());
         // ici on compare la liste crée avec celle qui sera retourné par la methode getFruits
        assertEquals(fruitsTest,pTest1.getFruits());
        
        
    }

    /**
     * Test of setFruits method, of class Panier.
     */
    @Test
    public void testSetFruits() {
        System.out.println("setFruits");
       
        
        PTest.setFruits(fruitsTest);
        // ici on verifie si la methode setFruits affecte bien la liste de fruit au panier
        assertEquals(fruitsTest,PTest.getFruits());
    }

    /**
     * Test of getTaillePanier method, of class Panier.
     */
    @Test
    public void testGetTaillePanier() {
        System.out.println("getTaillePanier");
        
         int tailleListe=pTest1.getFruits().size();
       // ici on compare la liste crée avec celle qui sera retourné par la methode getFruits
        assertEquals(tailleListe,pTest1.getTaillePanier());
    }

    /**
     * Test of getNbFruits method, of class Panier.
     */
    @Test
    public void testGetNbFruits() {
        System.out.println("getNbFruits");
        
       
        assertEquals(0,pTest1.getNbFruits());
        
    }

    /**
     * Test of getContenanceMax method, of class Panier.
     */
    @Test
    public void testGetContenanceMax() {
        System.out.println("getContenanceMax");
        
        Panier p =new Panier(7);
        assertEquals(7,p.getContenanceMax());
    }

    /**
     * Test of getFruitmethod, of class Panier.
     */
    @Test
    public void testGetFruit() {
        System.out.println("getFruit");
        
    }

    /**
     * Test of setFruitmethod, of class Panier.
     */
    @Test
    public void testSetFruit() throws PanierPleinException{
        System.out.println("setFruit");
       
        fruitsTest.add(O1);
      
        pTest1.ajout(O2);
        pTest1.setFruit(0,O1);
        assertEquals(fruitsTest,pTest1.getFruits());
        
    }

    /**
     * Test of getMessage method, of class Panier.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
         String message="Panier en cours";
        PTest.setMessage(message);
        
        assertEquals(message,PTest.getMessage());
        
    }

    /**
     * Test of setMessage method, of class Panier.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        
        String message="Panier en cours";
        PTest.setMessage(message);
        
        assertEquals(message,PTest.getMessage());
        
    }

    /**
     * Test of estVide method, of class Panier.
     */
    @Test
    public void testEstVide() {
        System.out.println("estVide");
       
       
       
       assertTrue(PTest.estVide());
    }

    /**
     * Test of estPlein method, of class Panier.
     */
    @Test
    public void testEstPlein() throws Exception{
        System.out.println("estPlein");
        
        PTest.ajout(O1);
        PTest.ajout(O2);
        PTest.ajout(O3);
        
        assertTrue(PTest.estPlein());
        
    }

    /**
     * Test of ajout method, of class Panier.
     */
    @Test
    public void testAjout() throws Exception {
        System.out.println("ajout");
      
    }

    /**
     * Test of retrait method, of class Panier.
     */
    @Test
    public void testRetrait() throws Exception {
        System.out.println("retrait");
       
    }

    /**
     * Test of getPrix method, of class Panier.
     */
    @Test
    public void testGetPrix() throws PanierPleinException {
        System.out.println("getPrix");
           
        double resultat=0.0;
        double prixPanier=PTest.getPrix();
        assertEquals(resultat,prixPanier,0.0001);
     
    }

    /**
     * Test of boycotteOrigine method, of class Panier.
     */
    @Test
    public void testBoycotteOrigine() throws PanierPleinException {
        System.out.println("boycotteOrigine");
        String origine = "Italie";
        
        PTest.ajout(O1);
        PTest.ajout(O2);
        PTest.ajout(O3);
        
        Iterator<Fruit> iterator = fruitsTest.iterator();
        while (iterator.hasNext()) {
        Fruit f = iterator.next();
        if (f.getOrigine().equals(origine)) {
        iterator.remove(); // Supprime l'élément de la liste
         }
        
        PTest.boycotteOrigine("Italie");
        
        assertEquals(fruitsTest,PTest.getFruits());
    }
    }
    

    /**
     * Test of equals method, of class Panier.
     */
    @Test
    public void testEquals() throws PanierPleinException {
        System.out.println("equals");
       
        Panier PTestVide= new Panier(3);
        Panier PTestVide1= new Panier(5);
        
        // ici 2 panier vide
        assertTrue(PTestVide.equals(PTestVide1));
        
        // equivalent a lui mm  vide
        
        assertTrue(PTestVide.equals(PTestVide));
        
        // ici on test pour deux panier rempli
        Panier PTest= new Panier(5);
        Panier PTest1= new Panier(5);
        
        
            PTest1.ajout(O1);
            PTest1.ajout(O2);
            PTest1.ajout(O3);
            PTest.ajout(O1);
            PTest.ajout(O2);
            PTest.ajout(O3);
            PTest.ajout(O1);
        // on compare un panier avec un panier vide
         assertFalse(PTest1.equals(PTestVide));
        // on compare les deux panier remplis
        
        
        // on compare un panier remplis avec lui mm 
        
        assertTrue(PTest.equals(PTest));
        
        // on compare deux panier differents 
        assertFalse(PTest1.equals(PTest));
        
    }
    

    

   

    

    /**
     * Test of getStringList method, of class Panier.
     */
    @Test
    public void testGetStringList() {
        System.out.println("getStringList");
        
        String liste[]={"Fraise","Orange"};
       
       PTest.setStringList(liste);
        
        String retour []=PTest.getStringList();
        assertArrayEquals(liste, retour);
        
        
    }
    
}
