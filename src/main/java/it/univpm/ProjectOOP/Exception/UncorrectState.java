package it.univpm.ProjectOOP.Exception;

/**
 * Inserimento del nome dello stato errato
 * 
 * @author Merelli Leonardo
 */
@SuppressWarnings("serial")
public class UncorrectState extends Exception
{	
	/**
	 * Costruttore di default
	 */
	public UncorrectState() {}
	
	/**
	 * Costruttore
	 * @param msg : messaggio di errore
	 */
	public UncorrectState(String msg)
	{
		super(msg);
	}

}
