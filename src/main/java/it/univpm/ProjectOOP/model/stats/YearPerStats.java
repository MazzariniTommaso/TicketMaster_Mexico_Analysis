package it.univpm.ProjectOOP.model.stats;

import java.util.List;

/**
 * Questa classe si occupa di descrivere 
 * una lista dell'oggetto MonthPerStats 
 * che si differenzia di anno in anno
 * 
 * @author Mazzarini Tommaso
 */
public class YearPerStats 
{	
	private String number;
	private List<MonthPerStats> month;
	
	/**
	 * Costruttore di default
	 */
	public YearPerStats() {}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public List<MonthPerStats> getMonth() {
		return month;
	}
	public void setMonth(List<MonthPerStats> month) {
		this.month = month;
	}
	

}
