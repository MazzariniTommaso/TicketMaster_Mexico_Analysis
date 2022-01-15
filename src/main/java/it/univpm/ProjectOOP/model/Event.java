package it.univpm.ProjectOOP.model;

/**
 * Questa classe si occupa di descrivere 
 * i vari eventi che vengono acquisiti 
 * tramite il parsing dei dati forniti dall' API 
 *  
 * @author Mazzarini Tommaso
 */
public class Event 
{
	private String name;
	private String genre;
	private Date localDate;
	private String localTime;
	private String state;
	
	/**
	 * Costruttore di default
	 */
	public Event() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getLocalDate() {
		return localDate;
	}
	public void setLocalDate(Date localDate) {
		this.localDate = localDate;
	}
	public String getLocalTime() {
		return localTime;
	}
	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
