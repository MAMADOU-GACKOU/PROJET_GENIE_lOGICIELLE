package fr.urfsciencestech.Fruits;

/**
 *
 * @author aa800033
 */
public class PanierPleinException extends Exception {
    
    public PanierPleinException()
    {
	super("Ajout impossible car le panier est plein !");
    }

}
