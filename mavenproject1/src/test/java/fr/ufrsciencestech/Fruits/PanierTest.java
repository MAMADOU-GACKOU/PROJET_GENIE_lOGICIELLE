/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

package fr.ufrsciencestech.Fruits;

import fr.ufrsciencestech.Fruits.PanierPleinException;

import java.util.ArrayList;
import java.util.Iterator;
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
public class PanierTest {
    
    Fruit O1 ;
    Fruit O2 ;
    Fruit O3 ; 
    Panier PTest;
    Panier pTest1;
    ArrayList<Fruit> fruitsTest ;
    
    
    
    
    public PanierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        // initialisation 
       O1 = new Orange();
       O2 = new Orange(0.4,"France");
       O3= new Orange(0.2,"Italie");
       fruitsTest = new ArrayList<Fruit>(); 
       
       
       
       PTest = new Panier(5);
       pTest1= new Panier(5);
             
    }
    
    @After
    public void tearDown() {
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
     * Test of afficheContenuPanier method, of class Panier.
     */
    @Test
    public void testAfficheContenuPanier()  throws PanierPleinException{
        System.out.println("afficheContenuPanier");
       
    String liste[]= {"Orange"};
    PTest.setStringList(liste);
    String msgAttendu="Panier de 0 Fruits: 0.0"+"\n"+"0 Orange de 0.5 euros\n";
    String msgContenu= PTest.afficheContenuPanier();
    
    System.out.println(msgContenu);
    assertEquals(msgAttendu,msgContenu);
        
                
                 
    }

    /**
     * Test of createFruitmethod, of class Panier.
     */
    @Test
    public void testCreateFruit() {
        System.out.println("createFruit");
        // ce teste doit etre implementé une fois que la 
        // methode createFruitprend en compte la liste de fruit.
    }

    /**
     * Test of setStringList method, of class Panier.
     */
    @Test
    public void testSetStringList() {
        System.out.println("setStringList");
        
        String Liste[]= {"Fraise","Orange"};
        PTest.setStringList(Liste);
        
        String messageAttendu="Panier de 0 Fruits: 0.0"+"\n"+"0 Fraise de 0.5 euros"+"\n"+"0 Orange de 0.5 euros"+"\n";
        
 
        assertEquals(messageAttendu,PTest.afficheContenuPanier());
       
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
