package it.univpm.ProjectOOP.model.stats;

import java.util.List;

/**
 * Questa classe si occupa di descrivere il numero totale degli 
 * eventi per stato,una lista dell'oggetto GenrePerStats
 * e una lista dell'oggetto YearPerStats
 * 
 * @author Mazzarini Tommaso
 */
public class StatePerStats
{
	private String state;
	private int total;
	private List<GenrePerStats> genre;
	private List<YearPerStats> year;
	
	/**
	 * Costruttore di default
	 */
	public StatePerStats() {}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public List<GenrePerStats> getGenre() {
		return genre;
	}
	public void setGenre(List<GenrePerStats> genre) {
		this.genre = genre;
	}
	public List<YearPerStats> getYear() {
		return year;
	}
	public void setYear(List<YearPerStats> year) {
		this.year = year;
	}
	
}
