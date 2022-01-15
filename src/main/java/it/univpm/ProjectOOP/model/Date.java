package it.univpm.ProjectOOP.model;
/**
 * Questa classe si occupa di descrivere le date
 * 
 * @author Mazzarini Tommaso
 */
public class Date 
{

	private String day;
	private String month;
	private String year;
	
	/**
	 * Costruttore di default
	 */
	public Date () {}

	/**
	 * Costruttore 
	 * @param year : anno
	 * @param month : mese
	 * @param day : giorno
	 */
	public Date (String year,String month,String day) 
	{
		this.year=year;
		this.month= month;
		this.day=day;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String date) {
		this.year = date;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	public boolean equals(Object o)
	{
		if (o != null && o instanceof Date)
		{
			Date date = (Date) o;
			return date.getYear().equals(this.getYear()) &&
					date.getMonth().equals(this.getMonth()) &&
					date.getDay().equals(this.getDay());
		}
		return false;
	}

}
