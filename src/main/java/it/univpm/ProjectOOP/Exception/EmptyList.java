package it.univpm.ProjectOOP.Exception;

/**
 * Non ci sono eventi che corrispondo ai 
 * filtri inseriti dall'utente
 * 
 * @author Merelli Leonardo
 */
@SuppressWarnings("serial")
public class EmptyList extends Exception
{
	/**
	 * Costruttore di default
	 */
	public EmptyList() {}

	/**
	 * Costruttore
	 * @param msg : messaggio di errore
	 */
	public EmptyList(String msg)
	{
		super(msg);
	}

}
