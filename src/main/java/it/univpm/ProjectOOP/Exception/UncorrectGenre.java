package it.univpm.ProjectOOP.Exception;

/**
 * Inserimento del nome del genere errato
 * 
 * @author Merelli Leonardo
 */
@SuppressWarnings("serial")
public class UncorrectGenre extends Exception
{	
	/**
	 * Costruttore di default
	 */
	public UncorrectGenre() {}

	/**
	 * Costruttore
	 * @param msg : messaggio di errore
	 */
	public UncorrectGenre(String msg)
	{
		super(msg);
	}
}
