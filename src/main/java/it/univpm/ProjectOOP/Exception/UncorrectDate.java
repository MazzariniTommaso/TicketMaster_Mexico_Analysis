package it.univpm.ProjectOOP.Exception;

/**
 * Inserimento della data errato
 * 
 * @author Merelli Leonardo
 */
@SuppressWarnings("serial")
public class UncorrectDate extends Exception
{
	/**
	 * Costruttore di default
	 */
	public UncorrectDate() {}
	
	/**
	 * Costruttore
	 * @param msg : messaggio di errore
	 */
	public UncorrectDate(String msg)
	{
		super(msg);
	}

}
