package it.univpm.ProjectOOP.model.stats;

/**
 * Questa classe si occupa di descrivere 
 * il numero di eventi divisi per genere 
 * 
 * @author Mazzarini Tommaso
 */
public class GenrePerStats 
{
	private String name;
	private int eventNumber;
	
	/**
	 * Costruttore di default
	 */
	public GenrePerStats () {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEventNumber() {
		return eventNumber;
	}
	public void setEventNumber(int eventNumber) {
		this.eventNumber = eventNumber;
	}

}
