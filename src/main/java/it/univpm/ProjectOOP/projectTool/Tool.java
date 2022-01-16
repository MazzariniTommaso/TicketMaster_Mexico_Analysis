package it.univpm.ProjectOOP.projectTool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import it.univpm.ProjectOOP.model.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Questa classe si occupa di gestire 
 * dei metodi utili per le conversioni
 * 
 * @author Merelli Leonardo
 */
public class Tool 
{
	/**
	 * Metodo che prende in ingresso la stringa della data e la divide
	 * @param stringDate : La data con il seguente formato: "YYYY-MM-DD"
	 * @return dateConverted : L' oggetto che descrive una data
	 */
	public Date converterDate(String stringDate) 
	{
		Date dateConverted = new Date();
		String[] date = stringDate.split("-");
		dateConverted.setYear(date[0]);
		dateConverted.setMonth(numberToMonthConverter(date[1]));
		dateConverted.setDay(date[2]);

		return dateConverted;
	}
	
	/**
	 * Metodo che converte la stringa di una data in un intero 
	 * con il seguente formato : "YYYYMMDD"
	 * @param stringDate : la string adi una data in formato "AAAA-MM-dd"
	 * @return Integer.valueOf(dateF) : 
	 */
	public int dateToInteger(String stringDate)
	{
		String[] date = stringDate.split("-");
		String dateF  = date[0]+ date[1] + date[2];
		return Integer.valueOf(dateF);
	}

	/**
	 * Metodo che converte il numero del mese nella 
	 * stringa del nome del mese corrispondente
	 * 
	 * @param month : Il numero del mese
	 * @return Il nome del mese corrispondente 
	 * al numero preso in ingresso
	 */
	public String numberToMonthConverter(String month)
	{
		switch(month)
		{
		case "01": return "January";
		case "02": return "February";
		case "03": return "March";
		case "04": return "April";
		case "05": return "May";
		case "06": return "June";
		case "07": return "July";
		case "08": return "August";
		case "09": return "September";
		case "10": return "October";
		case "11": return "November";
		case "12": return "December";
		default:return "Error with month id";
		}
	}
	
	/**
	 * Metodo che converte il nome del mese nel numero 
	 * del mese corrispondente
	 * 
	 * @param month : Il numero del mese
	 * @return Il nome del mese corrispondente 
	 * al numero preso in ingresso
	 */
	public String monthToNumberConverter(String month)
	{
		switch(month)
		{
		case "January": return "01";
		case "February": return "02";
		case "March": return "03";
		case "April": return "04";
		case "May": return "05";
		case "June": return "06";
		case "July": return "07";
		case "August": return "08";
		case "September": return "09";
		case "October": return "10";
		case "November": return "11";
		case "December": return "12";
		default:return "Error with month id";
		}
	}

	/**
	 * @param month : Il nome del mese
	 * @return dayList : Una lista che elenca i giorni di un dato 
	 * 	mese passato come parametro
	 */
	public List<String> setDayPerMonth(String month) 
	{
		List<String> dayList = new ArrayList<>();
		int numOfDay= 0;
		switch(month)
		{
		case "January": numOfDay = 31;
		case "February": numOfDay = 29;
		case "March": numOfDay = 31;
		case "April": numOfDay = 30;
		case "May": numOfDay = 31;
		case "June": numOfDay = 30;
		case "July": numOfDay = 31;
		case "August": numOfDay = 31;
		case "September": numOfDay = 30;
		case "October": numOfDay = 31;
		case "November": numOfDay = 30;
		case "December": numOfDay = 31;
		}

		for (int i = 1; i<numOfDay+1;i++)
		{
			if (i<10) dayList.add("0"+i);
			else dayList.add(""+i);
		}
		return dayList;
	}

	/**
	 * Metodo che inizializza una lista di mesi
	 * @return monthList : La lista che elenca i mesi dell'anno
	 */
	public List<String> setMonth() 
	{
		List<String> monthList = new Vector<>();
		monthList.add("January");
		monthList.add("February");
		monthList.add("March");
		monthList.add("April");
		monthList.add("May");
		monthList.add("June");
		monthList.add("July");
		monthList.add("August");
		monthList.add("September");
		monthList.add("October");
		monthList.add("November");
		monthList.add("December");
		return monthList;
	}
	
	/** 
	 * @param numberList : La lista contenete i conteggi
	 * @return total : La somma dei numeri presenti nella lista
	 */
	public int total(List<Integer> numberList) 
	{
		int total = 0;
		Iterator<Integer> i = numberList.iterator();
		while(i.hasNext())
		{
			total += i.next();
		}
		return total;
	}

	/**
	 * 
	 * @param date : data appartenente alla lista delle date ottenute dal parsing degli eventi
	 * @param startD : data iniziale dell'intervallo di tempo filtrato
	 * @param endD : datat finale dell'intervallo di tempo filtrato
	 * @return true se date appartiene all'intervallo di tempo
	 */
	public boolean compareDate(Date date, Date startD, Date endD) 
	{
        try 
        {
        	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date d = sdformat.parse(date.getYear() + "-" + monthToNumberConverter(date.getMonth()) + "-" + date.getDay());
            java.util.Date sd = sdformat.parse(startD.getYear() + "-" + monthToNumberConverter(startD.getMonth()) + "-" + startD.getDay());
            java.util.Date ed = sdformat.parse(endD.getYear() + "-" + monthToNumberConverter(endD.getMonth()) + "-" + endD.getDay());
            if (d.after(sd) && d.before(ed)) {
                return true;
            }
        } catch (ParseException e) {
        	e.printStackTrace();
        }
		return false;
	}
}
