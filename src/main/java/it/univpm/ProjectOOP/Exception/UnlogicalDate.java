package it.univpm.ProjectOOP.Exception;

/**
 * Inserimento illogico delle date:
 * data finale precedente alla data iniziale 
 * 
 * @author Merelli Leonardo
 */
@SuppressWarnings("serial")
public class UnlogicalDate extends Exception
{
	/**
	 * Costruttore di default
	 */
	public UnlogicalDate() {}

	/**
	 * Costruttore
	 * @param msg : messaggio di errore
	 */
	public UnlogicalDate(String msg)
	{
		super(msg);
	}
}
