package it.univpm.ProjectOOP.parsing;

import java.util.List;
import java.util.Vector;
import it.univpm.ProjectOOP.model.Date;
import it.univpm.ProjectOOP.model.Event;

/**
 * Classe che effettua il parsing delle date
 * 
 * @author Merelli Leonardo
 */
public class DateParsing 
{
	/** 
	 * Metodo che restituisce una lista delle date degli eventi
	 * 
	 * @param eventList : lista di tutti gli eventi (oggetto Event)
	 * @return La lista di oggetti di tipo Date
	 */
	public List<Date> dateParsing(List<Event> eventList) 
	{
		List<Date> dateList = new Vector<>();

		for (Event e : eventList)
		{
			if (dateList.size()<1 || !dateList.contains(e.getLocalDate())) 
				dateList.add(e.getLocalDate());
		}
		return dateList;	
	}

}
