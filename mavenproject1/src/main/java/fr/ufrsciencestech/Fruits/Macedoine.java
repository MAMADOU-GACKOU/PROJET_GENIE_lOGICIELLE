/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.Fruits;

import java.util.Iterator;
import java.util.ArrayList;

/**
 *
 * @author djera
 */
public  class Macedoine implements Fruit{
    
    private ArrayList<Fruit> ListeFruits;
    private boolean seedless;

    // macedoine vide
    public  Macedoine ()
    {
        this.ListeFruits=new ArrayList<Fruit>();
        this.seedless=false;
    }
    
    //methode qui ajoute un seul fruit 
     public void  AjoutFruitMacedoine(Fruit f)
     {
         this.ListeFruits.add(f);
         this.seedless=f.isSeedless();
     }
      
     // methode  qui crée une macedoine en passant en para la liste de fruit
     public void  AjoutListeFruitMacedoine(ArrayList<Fruit> fruits)
     {
        
        Iterator<Fruit> iterator = fruits.iterator();
        while (iterator.hasNext()) {
        Fruit f = iterator.next();
        
         this.ListeFruits.add(f);
         // si le fruit qu'on ajoute a des pepins ou que la macedoine a deja un fruit a pepin 
         if (f.isSeedless()||this.seedless)
         {
             this.seedless=true; 
         }
         
         }
        
     }
     
     // ajout d'une macedoine dans macedoine 
     public void AjoutMacedoineDansMacedoine(Macedoine m)  
             
     {
         ArrayList<Fruit> FruitAjout = m.getListeMacedoine();
         
       Iterator<Fruit> iterator = FruitAjout.iterator();
        while (iterator.hasNext()) {
        Fruit f = iterator.next();
        
         this.ListeFruits.add(f);
         // si le fruit qu'on ajoute a des pepins ou que la macedoine a deja un fruit a pepin 
         if (f.isSeedless()||this.seedless)
         {
             this.seedless=true; 
         }
         
         }
         
     }
      
     public ArrayList<Fruit> getListeMacedoine()
     {
         return ListeFruits;
     }
     
     public boolean getSeedlessMacedoine()
     {
         return seedless;
     }
    
    
    
    @Override
    public boolean isSeedless() {
        return seedless;
    }

    @Override
    public double getPrix() {
        double PrixMacedoine=0;
        Iterator<Fruit> iterator = ListeFruits.iterator();
        while (iterator.hasNext()) {
        Fruit f = iterator.next();
        {
            PrixMacedoine = PrixMacedoine +f.getPrix();
        }
     }
        return PrixMacedoine;
    }

   
    @Override
    public String toString()
    {
        String result = "";
        double prix = 0.0;
        for (Fruit f : ListeFruits) {
            prix=prix+f.getPrix();
            result += f.toString()+"\n";
           
        }
        result = "Macedoine de prix " +this.getPrix()+" euros composé de fruit : "+"\n"+result;
        return result ;
    }

    @Override
    public String getOrigine() {
        String result = "Macedoine  de fruits d'origine : \n";
        for (Fruit f : ListeFruits) {
            result += f.toString() + "\n";
        }
        return result;
    }
    
    
    public String toStringFruitMacedoine()
    {

        String result = "Macedoine  de fruits suivants : \n";
        for (Fruit f : ListeFruits) {
            
           result =result + f.toString();
        }
        result = "Macedoine de prix " +this.getPrix();
        return result ;
    }
    
    // ici prevoir une methode juste pour affiché les fruits qui sont dans la macedoine
    
     
    public static void main(String[] args)
    {
        // Tests de la macedoine
        
        // macedoine banane
        Macedoine Mbanane= new Macedoine();
        
        Banane b1= new Banane();
        Banane b2= new Banane();
        Banane b3= new Banane();
        // ajouter d'un seul
        Mbanane.AjoutFruitMacedoine(b1);
        Mbanane.AjoutFruitMacedoine(b2);
        Mbanane.AjoutFruitMacedoine(b3);

        
        System.out.println("Macedoine Banane \n");
        
        System.out.println(Mbanane.toString());
        
        // macedoine fruit rouge
        Macedoine MfruitRouge =new Macedoine();
        
        ArrayList<Fruit> fr= new  ArrayList<>();
        
        Fruit f = new Fraise();
        Fruit c = new Cerise();
        
        fr.add(f);
        fr.add(c);
        
        MfruitRouge.AjoutListeFruitMacedoine(fr);
        System.out.println("Macedoine Fruit Rouge \n");
        System.out.println(MfruitRouge.toString());
        
        
       System.out.println("Macedoine  melange Fruit \n");
        
       Mbanane.AjoutMacedoineDansMacedoine(MfruitRouge);
       
      // System.out.println(Mbanane.toString());
       
       // jus de fraise 
       Jus o= new Jus(f);
       
       // macedoine banane avec un jus de fraise
       Mbanane.AjoutFruitMacedoine(o);
       System.out.println(Mbanane.toString());
       
       Macedoine Mbanane1= new Macedoine();
       
       
        
        
        
        
        
        
        
        
        
        
        
    }
}
