package it.univpm.ProjectOOP.model.stats;

/**
 * Questa classe si occupa di descrivere 
 * il numero minimo/massimo/medio/totale 
 * di eventi di un mese specifico
 * 
 * @author Mazzarini Tommaso
 */
public class MonthPerStats
{
	private String name;
	private int eventMin;
	private int eventMax;
	private float eventMed;
	private int eventTot;
	
	/**
	 * Costruttore di default
	 */
	public MonthPerStats() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getEventMin() {
		return eventMin;
	}
	public void setEventMin(int eventMin) {
		this.eventMin = eventMin;
	}
	public int getEventMax() {
		return eventMax;
	}
	public void setEventMax(int eventMax) {
		this.eventMax = eventMax;
	}
	public float getEventMed() {
		return eventMed;
	}
	public void setEventMed(float numMed) {
		this.eventMed = numMed;
	}
	public int getEventTot() {
		return eventTot;
	}
	public void setEventTot(int eventTot) {
		this.eventTot = eventTot;
	}
	
	

}
