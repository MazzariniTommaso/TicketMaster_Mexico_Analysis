package it.univpm.ProjectOOP.projectTool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import it.univpm.ProjectOOP.model.Event;
import it.univpm.ProjectOOP.model.stats.GenrePerStats;
import it.univpm.ProjectOOP.model.stats.MonthPerStats;
import it.univpm.ProjectOOP.model.stats.YearPerStats;

/**
 * Questa classe si occupa di gestire 
 * dei metodi utili per le statistiche
 * 
 * @author Mazzarini Tommaso
 */
public class StatsTool 
{
	Tool tool = new Tool();
	
	/**
	 * @param state : Il nome di uno stato
	 * @param eventList : La lista di tutti gli eventi (oggetto Event)
	 * @return numTot : Il numero di eventi per stato
	 */
	public int getEventPerState(String state, List<Event> eventList) 
	{
		int numTot = 0;
		Iterator<Event> e = eventList.iterator();
		while (e.hasNext())
		{
			if(state.equals(e.next().getState())) 
			numTot++;
			
		}
		return numTot;
	}

	/**
	 * @param state : Il nome di uno stato
	 * @param genreList : La lista di tutti i generi
	 * @param eventList : La lista di tutti gli eventi (oggetto Event)
	 * @return gList : La Lista di un oggetto di tipo GenrePerStats
	 */
	public List<GenrePerStats> getGenrePerState(String state,List<String> genreList, List<Event> eventList) 
	{
		GenrePerStats genre;
		List<GenrePerStats> gList = new Vector<>();
		for (String g: genreList)
		{
			int count = 0;
			genre = new GenrePerStats();
			for (Event e:eventList)
			{
				if (e.getState().equals(state) && e.getGenre().equals(g)) count++;
			}
			genre.setName(g);
			genre.setEventNumber(count);
			if (genre.getEventNumber() != 0) gList.add(genre);
		}
		return gList;
	}

	/**
	 * @param state : Il nome di uno stato
	 * @param eventList : La lista di tutti gli eventi (oggetto Event)
	 * @return yList : La Lista di un oggetto di tipo YearPerStats
	 */
	public List<YearPerStats> getYearPerState(String state,List<Event> eventList) 
	{
		YearPerStats year;
		MonthPerStats month;
		List<Integer> numberList;
		
		final int firstDate = Integer.valueOf(eventList.get(0).getLocalDate().getYear());
		final int lastDate = Integer.valueOf(eventList.get(eventList.size()-1).getLocalDate().getYear());

		List<YearPerStats> yList = new Vector<>();
		List<MonthPerStats> mList;

		List<String> monthList = new Vector<>();
		monthList = tool.setMonth();

		List<String> dayList;

		int numMin, numMax, numTot;
		float numMed;


		for (int y = firstDate; y < lastDate+1 ; y++)
		{
			year = new YearPerStats();
			mList = new Vector<>();
			
			for(String m: monthList)
			{
				month = new MonthPerStats();
				month.setName(m);
				numberList = new ArrayList<>();
				dayList = new Vector<>();
				dayList = tool.setDayPerMonth(m);
				for(String d: dayList)
				{
					int count = 0;
					for (Event e:eventList)
					{
						if (e.getState().equals(state) && e.getLocalDate().getYear().equals(""+y)  
								&& e.getLocalDate().getMonth().equals(m) && e.getLocalDate().getDay().equals(d)) count++;
					}
					numberList.add(count);
				}
				
				Collections.sort(numberList);
				numMin = numberList.get(0);
				numMax = numberList.get(numberList.size()-1);
				numMed = (float)tool.total(numberList) / numberList.size();
				numTot = tool.total(numberList);

				month.setEventMin(numMin);
				month.setEventMax(numMax);
				month.setEventMed(numMed);
				month.setEventTot(numTot);
				if(month.getEventMax() != 0) mList.add(month);
			}
			year.setNumber(y+"");
			year.setMonth(mList);
			if (!year.getMonth().isEmpty())yList.add(year);
		}
		return yList;
	}

}
