package fr.ufrsciencestech.mavenproject1;

/**
 *
 * @author aa800033
 */
public class PanierVideException extends Exception {
    public PanierVideException()
    {
	super("Suppression impossible car le panier est vide !");
    }
}
