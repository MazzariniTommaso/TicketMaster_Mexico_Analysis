package it.univpm.ProjectOOP.projectTool;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import it.univpm.ProjectOOP.Exception.EmptyList;
import it.univpm.ProjectOOP.model.Date;
import it.univpm.ProjectOOP.model.Event;
import it.univpm.ProjectOOP.model.filtres.GenrePerFiltres;
import it.univpm.ProjectOOP.model.filtres.PeriodPerFiltres;
import it.univpm.ProjectOOP.model.filtres.StatePerFiltres;
import it.univpm.ProjectOOP.parsing.DateParsing;

/**
 * Questa classe si occupa di gestire 
 * dei metodi utili per i filtri
 * 
 * @author Merelli Leonardo
 */
public class FiltresTool 
{
	private DateParsing dateP = new DateParsing();
	private List<Date> dateList = new Vector<>(); 

	Tool tool = new Tool();

	/**
	 * Metodo che si occupa di inizializzare gli 
	 * 	attributi dell'oggetto StatePerFiltres (attributo dell'oggetto Filtres):
	 *   - numero minimo/massimo di eventi presenti in un singolo stato 
	 *   - numero medio di eventi tra tutti gli stati  
	 * @param state : L'oggetto di tipo StatePerFiltres
	 * @param stateListF : La lista degli stati filtrati
	 * @param genreListF : La lista dei generi filtrati
	 * @param startD : Il primo giorno dell'intervallo di tempo
	 * @param endD : L'ultimo giorno dell'intervallo di tempo
	 * @param eventList : La lista di tutti gli eventi (oggetto Event)
	 * @throws EmptyList : lista vuota	 
	 */
	public void setNumEventPerState (StatePerFiltres  state, List<String> stateListF, 
			List<String> genreListF, Date startD, Date endD,List<Event> eventList) throws EmptyList
	{
		List<Date> dateListF = new Vector<>();
		List<Integer> numberList = new Vector<>();

		dateListF  = setDateListFiltred(startD, endD,eventList);

		eventList = sortPerState(genreListF,dateListF,eventList);

		numberList = new Vector<>();
		for(String s: stateListF)
		{
			int count = 0;
			for(Event e: eventList)
			{
				if (e.getState().equals(s)) count++;
			}
			numberList.add(count);
		}

		Collections.sort(numberList);
		state.setNumMinPerState(numberList.get(0));
		state.setNumMaxPerState(numberList.get(numberList.size()-1));
		state.setNumMedPerState((float) tool.total(numberList)/numberList.size());
	}

	/**
	 * Metodo che si occupa di inizializzare gli 
	 * 	attributi dell'oggetto GenrePerFiltres (attributo dell'oggetto Filtres):
	 *   - numero minimo/massimo di eventi di un singolo genere 
	 *   - numero medio di eventi tra tutti i generi  
	 * @param genre : L'oggetto di tipo GenrePerFiltres
	 * @param stateListF : La lista degli stati filtrati
	 * @param genreListF : La lista dei generi filtrati
	 * @param startD : Il primo giorno dell'intervallo di tempo
	 * @param endD : L'ultimo giorno dell'intervallo di tempo
	 * @param eventList : La lista di tutti gli eventi (oggetto Event)
	 * @throws EmptyList : lista vuota
	 */
	public void setNumEventPerGenre (GenrePerFiltres  genre, List<String> stateListF, 
			List<String> genreListF, Date startD, Date endD, List<Event> eventList) throws EmptyList
	{
		List<Date> dateListF = new Vector<>();
		List<Integer> numberList = new Vector<>();



		dateListF  = setDateListFiltred(startD, endD,eventList);
		eventList = sortPerGenre(stateListF,dateListF,eventList);

		numberList = new Vector<>();
		for(String s: genreListF)
		{
			int count = 0;
			for(Event e: eventList)
			{
				if (e.getGenre().equals(s)) count++;
			}
			numberList.add(count);
		}

		Collections.sort(numberList);
		genre.setNumMinPerGenre(numberList.get(0));
		genre.setNumMaxPerGenre(numberList.get(numberList.size()-1));
		genre.setNumMedPerGenre((float) tool.total(numberList)/numberList.size());

	}

	/**
	 * Metodo che si occupa di inizializzare gli 
	 * 	attributi dell'oggetto PeriodPerFiltres (attributo dell'oggetto Filtres):
	 *   - numero minimo/massimo di eventi in un singolo giorno in un periodo 
	 *   	di tempo dichiarato dall'utente  
	 *   - numero medio di eventi tra tutti i generi 
	 * @param period : L'oggetto di tipo PeriodPerFiltres
	 * @param stateListF : La lista degli stati filtrati
	 * @param genreListF : La lista dei generi filtrati
	 * @param startD : Il primo giorno dell'intervallo di tempo
	 * @param endD : L'ultimo giorno dell'intervallo di tempo
	 * @param eventList : La lista di tutti gli eventi (oggetto Event)
	 * @throws EmptyList : lista vuota 
	 */
	public void setNumEventPerPeriod (PeriodPerFiltres  period, List<String> stateListF, 
			List<String> genreListF, Date startD, Date endD, List<Event> eventList) throws EmptyList
	{
		List<Date> dateListF = new Vector<>();
		List<Integer> numberList = new Vector<>();


		dateListF  = setDateListFiltred(startD, endD,eventList);

		eventList = sortPerPeriod(genreListF,stateListF,eventList);

		numberList = new Vector<>();
		for(Date s: dateListF)
		{
			int count = 0;
			for(Event e: eventList)
			{
				if (e.getLocalDate().equals(s)) count++;
			}
			numberList.add(count);
		}

		Collections.sort(numberList);
		period.setNumMinPerDate(numberList.get(0));
		period.setNumMaxPerDate(numberList.get(numberList.size()-1));
		period.setNumMedPerDate((float) tool.total(numberList)/numberList.size());
	}

	/**
	 * Metodo che si occupa di creare una lista di date filtrate dall'utente
	 * @param startD : Il primo giorno dell'intervallo di tempo
	 * @param endD : L'ultimo giorno dell'intervallo di tempo
	 * @param eventList : La lista di tutti gli eventi (oggetto Event)
	 * @return dateListF : La lista delle date di eventi presenti 
	 * nell'intervallo di tempo dichiarato dall'utente
	 * @throws EmptyList 
	 */
	private List<Date> setDateListFiltred(Date startD, Date endD, List<Event> eventList) throws EmptyList 
	{
		dateP = new DateParsing();
		dateList = dateP.dateParsing(eventList);
		List<Date> dateListF = new Vector<>();
		for (Date d : dateList) 
		{
			if (tool.compareDate(d, startD , endD))
				if (!dateListF.contains(d)) dateListF.add(d);
		}
		if (dateListF.isEmpty()) throw new EmptyList();
		else return dateListF;
	}

	/**
	 * Metodo che filtra gli eventi a seconda dei generi e dell'intervallo di tempo inseriti dall'utente
	 * @param genreListF : La lista dei generi filtrati
	 * @param dateListF : La lista delle date filtrate
	 * @param eventList : La lista di tutti gli eventi (oggetto Event)
	 * @return events : La lista dell'oggetto di tipo Event
	 */
	private List<Event> sortPerState(List<String> genreListF, List<Date> dateListF,List<Event> eventList) 
	{
		List<Event> events = new Vector<>();

		for (Event e: eventList)
		{
			for (String g: genreListF)
			{
				for (Date d: dateListF)
				{
					if (e.getGenre().equals(g) && e.getLocalDate().equals(d)) events.add(e);
				}
			}
		}

		return events;
	}

	/**
	 * Metodo che filtra gli eventi a seconda degli stati e dell'intervallo di tempo inseriti dall'utente
	 * @param stateListF : La lista degli stati filtrati
	 * @param dateListF : La lista delle date filtrate
	 * @param eventList : La lista di tutti gli eventi (oggetto Event)
	 * @return events : La lista dell'oggetto di tipo Event
	 */
	private List<Event> sortPerGenre(List<String> stateListF, List<Date> dateListF,List<Event> eventList) 
	{
		List<Event> events = new Vector<>();

		for (Event e: eventList)
		{
			for (String s: stateListF)
			{
				for (Date d: dateListF)
				{

					if (e.getState().equals(s) && e.getLocalDate().equals(d)) events.add(e);

				}
			}
		}

		return events;
	}

	/**
	 * Metodo che filtra gli eventi a seconda dei generi e degli stati inseriti dall'utente
	 * @param genreListF : La lista dei generi filtrati
	 * @param stateListF : La lista degli stati filtrati
	 * @param eventList : La lista di tutti gli eventi (oggetto Event)
	 * @return events : La lista dell'oggetto di tipo Event
	 */
	private List<Event> sortPerPeriod(List<String> genreListF, List<String> stateListF,List<Event> eventList) 
	{
		List<Event> events = new Vector<>();

		for (Event e: eventList)
		{

			for (String g: genreListF)
			{
				for (String s: stateListF)
				{
					if (e.getGenre().equals(g) && e.getState().equals(s)) events.add(e);

				}
			}
		}

		return events;
	}
	
	/**
	 * Metodo che divide la stringa inserita in formato cvs (comma separeted value)
	 * @param genres : La lista degli eventi inserita dall'utente
	 * @param genreList : La lista di tutti i generi
	 * @return dinamicGenreNameList : La lista di generi filtrati
	 */
	public List<String> setGenreListFiltres(String genres, List<String> genreList) 
	{
		List<String> dinamicGenreNameList = new Vector<>();
		String[] genreNameList = genres.split(",");

		if (!genres.equals("")) 
			for (String s:genreNameList)
			{
				dinamicGenreNameList.add(s);
			}
		else dinamicGenreNameList = genreList;
		return dinamicGenreNameList;
	}

	/**
	 * Metodo che divide la stringa inserita in formato cvs (comma separeted value)
	 * @param states : La lista delgli stati inserita dall'utente
	 * @param stateList : La lista di tutti gli stati
	 * @return dinamicStateNameList : La lista degli stati filtarti
	 */
	public List<String> setStateListFiltres(String states, List<String> stateList) 
	{
		List<String> dinamicStateNameList = new Vector<>();
		String[] stateNameList = states.split(",");

		if (!states.equals("")) 
			for (String s:stateNameList)
			{
				dinamicStateNameList.add(s);
			}
		else dinamicStateNameList = stateList;
		return dinamicStateNameList;
	}
}
