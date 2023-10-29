package fr.ufrsciencestech.Fruits;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author aa800033
 */
public class Panier {
    
    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private int contenanceMax;        //nb maximum d'oranges que peut contenir le panier
    private String message;
    private  String Items[];// la liste des fruits prevu pour notre modele 
    
    //groupe 1
    public Panier(int contenanceMax) {  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
        //this.fruits = new ArrayList<Fruit>();
        this.fruits= new ArrayList<Fruit>();
        if (contenanceMax < 1) {
            throw new IllegalArgumentException("La contenance maximale doit être supérieure à 0");
        } else {
            this.contenanceMax = contenanceMax;
        }
        this.message = "Ce panier est vide";
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
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) { //modificateur du premier attribut
         
       this.fruits= fruits;
    }

    public int getTaillePanier() {  //accesseur retournant la taille allouee pour l'attibut fruits
        return fruits.size();
    }
    public int getNbFruits(){
       return  fruits.size();
    }
    public int getContenanceMax() {  //accesseur du second attribut
        return contenanceMax ;
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
    @SuppressWarnings("empty-statement")
    public String afficheContenuPanier()
    {
       
       int [] compteurs = new int[Items.length];
       double [] compteursPrixFruit= new double [Items.length];
       
        // j'initialise les  compteurs a zero 
        for (int i=0;i<compteurs.length;i++)
        {
            compteurs[i]=0;
            compteursPrixFruit[i]= 0.0;
            
        }

         
 for (int i=0;i<this.getNbFruits();i++)
 {  
     message = this.getFruit(i).toString();
     
     ArrayList<String> listeFruit = new ArrayList();
     String contenu ="";
     
     
     if (message.contains("Macedoine"))
     {
            
        for (int k= 0; k<Items.length;k++)
               {
                  if (message.contains(Items[k]) && !Items[k].contains("Macedoine"))
                       {
        
                           listeFruit.add(Items[k]);
                           System.out.println(Items[k]);
      
                        } 
               }  
   
        Iterator<String> iterator = listeFruit.iterator();
        System.out.println(iterator);
        while (iterator.hasNext()) {
         contenu=contenu +iterator.next()+",";  
         }  
         contenu ="Macedoine de "+contenu;

         int lastIndex = contenu.lastIndexOf(",");
         if (lastIndex >= 0) {
          contenu = contenu.substring(0, lastIndex) + contenu.substring(lastIndex + 1);
                             }
     }
     
     
     
     
     
     
     if (message.contains("Jus") )
     {
         
          for (int k= 0; k<Items.length;k++)
               {
                  if (message.contains(Items[k]) )
                       {
        
                           listeFruit.add(Items[k]);
                           System.out.println(Items[k]);
      
                        } 
               }  
          
          
        Iterator<String> iterator = listeFruit.iterator();
        System.out.println(iterator);
        while (iterator.hasNext()) {
         contenu=contenu +iterator.next();  
         }  
         contenu =contenu+"(Jus)";
         System.out.println(contenu);
     }
    
     
     
     
  

for (int j=0;j<Items.length;j++)
    {    
       
       if (message.contains("Macedoine")){
        
       if (Items[j].trim().equals(contenu) )                                                    
        {    
         compteurs[j]=compteurs[j]+1; 
        
        }
       
   
        System.out.println("items"+j+"cpt "+compteurs[j]); 
           // ici c le cas ou le message contient pas macedoine.
       }
       if( message.contains(Items[j]) && !message.contains("Macedoine")  && !Items[j].contains("Macedoine")  && !message.contains("Jus")  && !Items[j].contains("Jus"))
                 {
                       compteurs[j]=compteurs[j]+1;
                 }   
               
        if ( message.contains("Jus"))
        {
                        
        if (Items[j].trim().equals(contenu) )                                                    
        {    
         compteurs[j]=compteurs[j]+1; 
         System.out.println(contenu);
         System.out.println("items"+j+"cpt "+compteurs[j]); 
        }
    }
        
       
       
        }// for j
        

    
        
        }// for i
        
        
        // message quelque soit la liste de fruit 
        // ici il faut recuperer le prix de chaque fruits ici
         message="Panier de "+this.getNbFruits()+ " Fruits: "+ this.getPrix()+"\n";
        
         String ajout ="";
         
        for (int k=0;k<Items.length;k++)
        {
            if (Items[k].equals("Orange")|| Items[k].equals("Fraise") || Items[k].equals("Banane"))
            {    
            compteursPrixFruit[k]=0.5;
             
            }
            if (Items[k].equals("Macedoine de Banane"))             
            {
             compteursPrixFruit[k]=1.5;
            
            }
            if (Items[k].equals("Macedoine de Banane,Ananas"))
            {
            compteursPrixFruit[k]=3.5;       
           
            }  
            if (Items[k].equals("Cerise"))             
            {
             compteursPrixFruit[k]=1.0;
            
            }
            
            if (Items[k].equals("Ananas"))             
            {
             compteursPrixFruit[k]=3.0;
            
            }
            
            if (Items[k].equals("Orange(Jus)"))             
            {
             compteursPrixFruit[k]=1.0;
            
            }
            
            
             ajout =compteurs[k]+" "+Items[k]+" de "+ compteursPrixFruit[k]+"  euros"+"\n";
             message= message+ajout;
            }
       
         
        return message;
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
        case "Banane":
            return new Banane();
        case "Cerise":
             return new Cerise();
        case "Ananas":
             return new Ananas();
        case "Macedoine de Banane": // elle contient 3 bananes
        {
            
            Macedoine MB = new Macedoine();
            Fruit b1= new Banane();         
            MB.AjoutFruitMacedoine(b1);
            MB.AjoutFruitMacedoine(b1);
            MB.AjoutFruitMacedoine(b1);

            return MB;
        }
        case "Macedoine de Banane,Ananas": // elle contient  banane+ ananas
        {
            
            Macedoine MBA = new Macedoine();
            Fruit b1= new Banane();
            Fruit A1= new Ananas();
            MBA.AjoutFruitMacedoine(b1);
            MBA.AjoutFruitMacedoine(A1);
           
            return MBA;
        }
        case "Orange(Jus)":
        {
            Fruit o= new Orange();
            Jus jo= new Jus(o);
            return jo;
        }
                
        default:
            return  new Banane();
           
         }
       
     
    }
    
     public void setStringList(String items[])
    {
        this.Items=items;
    }
    
    public  String[] getStringList()
    {
        return Items;
    }

 
    
    
    public static void main(String[] args) throws PanierPleinException {
        //Ecrire ici vos tests
        Panier p = new Panier(5);
        
        Fruit b= new Banane();
        
        ArrayList<Fruit> fruitTest= new  ArrayList<Fruit>();
        Fruit o = new Orange();
        
        fruitTest.add(o);
        
        
        
        p.ajout(b);
        System.out.println(p.toString());
        System.out.println(fruitTest.get(0).toString()); 
        
    }
    
}
