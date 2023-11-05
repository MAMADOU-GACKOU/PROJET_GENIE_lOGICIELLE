/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

/**
 *
 * @author aa800033
 */
public  class Jus extends JusDeFruitDecorateur {
    
    
    public Jus(Fruit fruit,String typeDefruit) {
        super(fruit,typeDefruit);
    }
    
    
    /**
     *
     * @return le détails concernant le jus 
     * qui n'est rien d'autre que son composant en fruit et son prix
     */
    @Override
    public String toString(){
        return fruit.getClass().getSimpleName() +"(Jus) a "+this.getPrix();//on peut utiliser l'attribut type
    }

    /**
     *
     * @return l'origine du jus qui n'est rien d'autre que l'origine du fruit 
     * qui a permet sa fabriquation
     */
    @Override
    public String getOrigine() {
       return fruit.getOrigine();
    }

    /**
     *
     * @return si le jus contient du grain ou pas 
     * et on a choisi que par defaut et nature qu'un jus ne contient jamais de grain de fruit
     */
    @Override
    public boolean isSeedless() {
        return false;
    }
    public static void main(String[] args) {
        /*test de création des jus à partir des fruits existants
        et l'affichage de ce qui nous indiquera le type ou contituant du jus 
        et son prix effectivement 
        */
        Fruit orange = new Orange(4,"Algerie");
        Fruit jusDOrange = new Jus(orange,"Orange");
        System.out.println(jusDOrange.toString());
        

        Fruit fraise = new Fraise();
        Fruit jusDeFraise = new Jus(fraise,"Fraise");
        System.out.println(jusDeFraise.toString());
        
        /*Comment peut-on interdir la création de jus d'un autre jus
        c'est ce qui est materialsé par les deux lignes en commentaire 
        si vous voulez voir 
        */
        /*Fruit jusDeFraiseO = new Jus(jusDeFraise,"Fraise");
        System.out.println(jusDeFraiseO.toString());*/

    }
}
