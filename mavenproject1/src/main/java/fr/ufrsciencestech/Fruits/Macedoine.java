/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author aa800033
 */
public class Macedoine implements Fruit{//elle peut implementer aussi une autre interface pour avoir d'autre caracterisque de certain macedoine
    
    private  ArrayList<Fruit> Fruit_macedoine;
    //private  ArrayList<Macedoine> macedoine;
    

    public Macedoine() {
        this.Fruit_macedoine = new ArrayList<>();
        //this.macedoine = new ArrayList<>();
    }
    
    /**
     *
     * @param f represente un fruit
     * cette fonction permet d'ajouter un fruit à la liste de fruits qui constitue la macedoine
     */
    public void ajoutFruitMacedoine(Fruit f){
        Fruit_macedoine.add(f);
    }
    /*public void ajoutMacedoineAmacedoine(Macedoine m){
        this.macedoine.add(m);
    }*/
    /* si on utilise un 2 attributs unquement pour ajouter des macedoines
    public String listMacedoines(){
        StringBuilder contenu = new StringBuilder();
        for(Macedoine macedoineM : macedoine)
        {
            contenu.append(macedoineM.listContenueMacedoine()).append(",");
        }
        
        return "Macedoine de ( "+contenu.toString()+")";
    }*/
    /**
     *
     * @return la liste des fruits que compose la macedoine
     */
    public ArrayList<Fruit> getFruit_macedoine() {
        return Fruit_macedoine;
    }
    /**
     *@return le nombre de fruit contenue dans la macedoine
     **/
    public int getTailleMacedoine(){
        return this.Fruit_macedoine.size();
    }
    public Fruit getFruit(int i) {  //accesseur retournant le fruit contenu dans la macedoine a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
        return this.Fruit_macedoine.get(i);
    }

    /**
     *
     * @return vrai si aucun des fruits contenus dans la macedoine ne 
     * contient de pepins
     */
    @Override
    public boolean isSeedless() {
        
        int i=0;boolean vrai=true;
        while(i<this.getTailleMacedoine() && vrai==true){
            vrai =this.getFruit(i).isSeedless();
            i++;
        }
        return vrai;
    }

    /**
     *
     * @return le prix totale de la macedoine
     * qui n'est rien d'autre que la somme des prix des fruits  qui la compose
     */
    @Override
    public double getPrix() {
        double prixttle =0;int i =0;
        while(i<this.getTailleMacedoine()){
            prixttle+= this.getFruit(i).getPrix();
            i++;
        }
        return prixttle;
    }

    /**
     *
     * @return l'origine de la macedoine
     * On fixe comme principe que si les fruits qui constitue la macedoine sont 
     * de la même origine alors la macedoine est de l'origine commun de ces constituants
     * sinon elle est d'origine mixe et on site quelques origines de ces constituants
     */
    @Override
    public String getOrigine() {
        String origineMacedoine = Fruit_macedoine.get(0).getOrigine();
        for(Fruit fruit : this.getFruit_macedoine())
        {
            if(fruit.getOrigine() != origineMacedoine)
                break;
        }
        return origineMacedoine;
    }
    
    public String listContenueMacedoine(){
        StringBuilder contenu = new StringBuilder();
        for(Fruit fruit : this.getFruit_macedoine())
        {
            contenu.append(fruit.toString()).append(",");
        }
        
        return "Macedoine de ( "+contenu.toString()+")";
    }
    /**
     **@return une répresentation textuelle des fruits qui composent le macedoine
     **/
    @Override
    public String toString()
    {
        //String affichage = "";
        /*if(macedoine.isEmpty()){
            affichage = this.listContenueMacedoine()+ " à "+this.getPrix();
        }else{
            affichage = this.listMacedoines()+ " à "+this.getPrix();
        }
        return affichage;*/
        return this.listContenueMacedoine()+ " à "+this.getPrix();
    }
    public static void main(String[] args) {
        //test de macedoine contenant de fruit simple
        Macedoine macedoine1;
        macedoine1 = new Macedoine();
        macedoine1.ajoutFruitMacedoine(new Orange(10, "France"));
        macedoine1.ajoutFruitMacedoine(new Fraise());
        System.out.println(""+macedoine1.isSeedless());
        System.out.println(macedoine1.toString());
        
        //test de macedoine contenant de fruit simple et de macedoine
        Macedoine macedoine2;
        macedoine2 = new Macedoine();
        macedoine2.ajoutFruitMacedoine(new Orange(1.00, "France"));
        //macedoine2.ajoutMacedoineAmacedoine(test);
        macedoine2.ajoutFruitMacedoine(macedoine1);
        System.out.println(macedoine2.toString());
        
        //test de macedoine contenant de jus de fruit simple
        Macedoine macedoine3;
        macedoine3 = new Macedoine();
        macedoine3.ajoutFruitMacedoine(new Orange(1.5, "Australie"));
        macedoine3.ajoutFruitMacedoine(new Fraise());
        //ajout de jus d'orange
        Fruit orange = new Orange(4,"Italie");
        Fruit jusDOrange = new Jus(orange,"Orange");
        macedoine3.ajoutFruitMacedoine(jusDOrange);
        
        System.out.println(macedoine3.toString());
        

    }
    
}
