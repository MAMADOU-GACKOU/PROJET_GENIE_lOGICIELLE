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
    private static String type;//permet d'indiquer si c'est orange,ou banane etc
    
    public Jus(Fruit fruit,String typeDefruit) {
        super(fruit);
        setType(typeDefruit);
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        Jus.type = type;
    }
    

    @Override
    public double getPrix() {
       double prixJusFruit =0;
       double prixBaseFruit = fruit.getPrix();
       String nomFruit = Jus.type;
       switch(nomFruit){//j'aimerai que les cases soient pas sensible
        case "Orange": 
            prixJusFruit =1;break;
        case "Fraise":
            prixJusFruit =2.5;break;
        default:
            prixJusFruit =0.5;break;
           
         }
               System.out.println(prixJusFruit);
               System.out.println(prixBaseFruit);

       return (prixJusFruit+prixBaseFruit);
       
    }

      @Override
    public String toString(){
        return this.getType()+"(jus) a "+fruit.getPrix();
    }

    

    @Override
    public String getOrigine() {
       return fruit.getOrigine();
    }

    @Override
    public boolean isSeedless() {
        return false;
    }
    public static void main(String[] args) {
        Fruit orange = new Orange(4,"Algerie");
        Fruit jusDOrange = new Jus(orange,"Orange");
        System.out.println(jusDOrange.toString());
            System.out.println(Jus.type);

        Fruit fraise = new Fraise();
        Fruit jusDeFraise = new Jus(fraise,"Fraise");
        System.out.println(jusDeFraise.toString());

    }
}
