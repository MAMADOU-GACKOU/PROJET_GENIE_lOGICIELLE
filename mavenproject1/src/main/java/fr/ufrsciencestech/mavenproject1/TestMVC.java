/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.TestMVC to edit this template
 */
package fr.ufrsciencestech.mavenproject1;


import fr.ufrsciencestech.controler.Controleur;
import fr.ufrsciencestech.view.*;
import fr.ufrsciencestech.model.Modele;


/**
 * C'est la classe principale de test du projet
 *
 * @author aa800033
 */
public class TestMVC {

    private VueG vueg;      //pour pouvoir changer de vue si on le souhaite
    private Controleur controleur;  //pour pouvoir changer de controleur si on le souhaite
    private VueG vueP;
   // private VueGraphAjoutRetire vuetestcombo;
    private String ListeFruit[]={"Orange","Banane","Ananas","Cerise",
        "Macedoine de Banane","Macedoine de Banane,Ananas","Orange(Jus)",
    "Macedoine de Cerise,Fraise(jus)","Macedoine de Banane,Ananas(Jus)"};
    

    /**
     * @return the vueg
     */
    public VueG getVueg() {
        return vueg;
    }

    /**
     * @param vueg the vueg to set
     */
    public void setVueg(VueG vueg) {
        this.vueg = vueg;
    }

    /**
     * @return the vueg
     */
    public VueG getVueP() {
        return vueP;
    }

    /**
     * @param vueg the vueg to set
     */
    public void setVueP(VueG vueg) {
        this.vueP = vueg;
    }

    /**
     * @return the controleur
     */
    public Controleur getControleur() {
        return controleur;
    }

    /**
     * @param controleur the controleur to set
     */
    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    public TestMVC() {
        //sans utiliser SpringIoC :
        //abdel

        vueg = new VueGraphSwing();
        //vuetestcombo = new VueGraphAjoutRetire();
        controleur = new Controleur();
        Modele modele = new Modele(ListeFruit);

        controleur.setModele(modele);
        modele.addObserver(vueg);
        vueg.addControleur(controleur);
      
        

        //next window
        vueP = new VueGraphAjoutRetire(ListeFruit);

      
        
        modele.addObserver(vueP);
       
        vueP.addControleur(controleur);
        
        
       System.out.println( modele.getPanier().toString());
        

    }  

    public static void main(String[] args) {

            TestMVC mvc = new TestMVC();
    }
}
