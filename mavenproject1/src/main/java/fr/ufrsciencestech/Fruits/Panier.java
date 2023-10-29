package fr.ufrsciencestech.Fruits;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author aa800033
 */
public class Panier {
    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private int contenanceMax;        //nb maximum d'oranges que peut contenir le panier
    private String message;
    //groupe 1
    public Panier(int contenanceMax) {  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
        this.fruits = new ArrayList<Fruit>();
        if (contenanceMax < 1) {
            throw new IllegalArgumentException("La contenance maximale doit être supérieure à 0");
        } else {
            this.contenanceMax = contenanceMax;
        }
        this.message = "pas en core";
    }

    @Override
    public String toString() {  //affichage de ce qui est contenu dans le panier : liste des fruits presents
        String result = "";
        for (Fruit f : fruits) {
            result += f.toString() + "\n";
        }
        return result;
    }

    //groupe 2
    public ArrayList<Fruit> getFruits() {  //accesseur du premier attribut
        return null;
    }

    public void setFruits(ArrayList<Fruit> fruits) { //modificateur du premier attribut

    }

    public int getTaillePanier() {  //accesseur retournant la taille allouee pour l'attibut fruits
        return 0;
    }
    public int getNbFruits(){
       return  fruits.size();
    }
    public int getContenanceMax() {  //accesseur du second attribut
        return 0;
    }

    //groupe 3
    public Fruit getFruit(int i) {  //accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
        return this.fruits.get(i);
    }

    public void setFruit(int i, Fruit f) {  //modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
        if (this.fruits.contains(this.fruits.get(i))) {
            this.fruits.set(i, f);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public boolean estVide() {  //predicat indiquant que le panier est vide
        return this.fruits.isEmpty();
    }

    public boolean estPlein() {  //predicat indiquant que le panier est plein
        return !this.fruits.isEmpty();
    }

    //groupe 4
    public void ajout(Fruit o) throws PanierPleinException {  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
          if (fruits.size() < contenanceMax)
            fruits.add(o);
        else
            throw new PanierPleinException();

    }

    //groupe 5
    public void retrait() throws PanierVideException { //retire le dernier fruit du panier si celui-ci n'est pas vide
        if(!this.fruits.isEmpty()){
            int indexOfLastElement = fruits.size() - 1;
            fruits.remove(indexOfLastElement);
        }else{
            throw new PanierVideException();
        }
    }

    //groupe 6
    public double getPrix(){  //calcule le prix du panier par addition des prix de tous les fruits contenus dedans
	    double prix = 0.0;
        for (int i=0; i<fruits.size(); i++) {
            prix += fruits.get(i).getPrix();
        }
        return prix;
    }

    //groupe 7
    public void boycotteOrigine(String origine) {  //supprime du panier tous les fruits provenant du pays origine
        for (int i=0 ;i<this.fruits.size(); i++) {
            if(this.getFruit(i).getOrigine().equals(origine)){
                this.fruits.remove(i);
            }
        }
    }

    //groupe 8
    @Override
    public boolean equals(Object o) {  ///predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
        if (o != null && getClass() == o.getClass()) {
            Panier p = (Panier) o;
            int compt = 0;
            if (p.fruits.size() == this.fruits.size()) {
                for (Fruit f : p.fruits) {
                    if (this.fruits.contains(f)) {
                        System.out.println(f);
                        compt++;
                    }
                }
                return compt == p.fruits.size();
            }
        }
        return false;
    }

    /**
     *
     * @return le contenu du panier avec les differents type de fruits,le nombre de chacun d'eux dans le panier ainsi que leur prix respectif et le prix total dans le panier
     */
    public String afficheContenuPanier()
    {
        String messages = "Panier de "+this.getNbFruits()+ " fruits :"+this.getPrix()+"euros\n";
        for (int i = 0; i < this.getNbFruits(); i++) {
             messages += this.getFruit(i).toString()+ "\n";
        }
       
        return messages;
    }

   
    
    
    /**
     * 
     * @param nameFruit le nom de fruit choisit dans la combobox
     * @return Permet de créer un fruit grâce au nom de fruit choisit dans la combobox
     */
    public Fruit createFruit(String nameFruit) 
    {   
                    
       // setMessage(nameFruit);
       
        
       switch(nameFruit){//j'aimerai que les cases soient pas sensible
        case "Orange": 
            return new Orange();
        case "Fraise":
            return new Fraise();
        case "Macedoine de Banane,Ananas":
          Macedoine test = new Macedoine();
          Banane b = new Banane(4, "Japan");
          Ananas a = new Ananas(8, "canada");
          test.ajoutFruitMacedoine(b);
          test.ajoutFruitMacedoine(a);
        return test;
        case "Jus(banane)":
          Fruit swift = new Banane(3,"usa");
          swift = new Jusbanane(swift);
            return swift;
         case "Macedoine,jus(orange),jus(cerise)":
            Fruit first = new Banane(9,"usa");
                first = new Jusbanane(first);
                //deuxième jus
                Fruit second = new Orange(2,"guinea");
                second = new JusCerise(second);
                //macedoine
            Macedoine t = new Macedoine();
             t.ajoutFruitMacedoine(first);
             t.ajoutFruitMacedoine(second);
               return t;
        default:
            return  new Orange();
           
         }
     
    }

/*
    //tests
    public static void main(String[] args) throws PanierPleinException {
        //Ecrire ici vos tests
        Panier p1 = new Panier(5);
        Panier p2 = new Panier(5);
        Panier p3 = new Panier(1);

        Orange o1 = new Orange(0.5, "Espagne");
        Orange o2 = new Orange(1.0, "Espagne");
        Orange o3 = new Orange(0.8, "France");
        Orange o4 = new Orange(0.2, "Italy");
        Orange o5 = new Orange(0.1, "France");

    try{p1.ajout(o1);
        p1.ajout(o2);
        p1.ajout(o3);
        p1.ajout(o4);
        p1.ajout(o5);

        p2.ajout(o5);
        p2.ajout(o3);
        p2.ajout(o2);
        p2.ajout(o1);
        p2.ajout(o4);

        p3.ajout(o5);
        //avant le boycotte
        for (Fruit fruit : p1.fruits) {
            System.out.println(fruit.toString());
        }
        //après le boycotte
        p1.boycotteOrigine("France"); 
        for (Fruit fruit : p1.fruits) {
            System.out.println(fruit.toString());
        }
    } catch (Exception e) {
        // TODO: handle exception
        System.err.println(e);
    }
    System.out.println("premier test Panier");



    }*/
}
