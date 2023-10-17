package fr.ufrsciencestech.mavenproject1;

/**
 *
 * @author roudet
 */
public class PanierVideException extends Exception {
    public PanierVideException()
    {
	super("Suppression impossible car le panier est vide !");
    }
}
