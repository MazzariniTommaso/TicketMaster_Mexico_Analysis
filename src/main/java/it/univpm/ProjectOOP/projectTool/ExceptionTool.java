package it.univpm.ProjectOOP.projectTool;

import java.util.List;
import java.util.Vector;
import it.univpm.ProjectOOP.Exception.EmptyList;
import it.univpm.ProjectOOP.Exception.UncorrectDate;
import it.univpm.ProjectOOP.Exception.UncorrectGenre;
import it.univpm.ProjectOOP.Exception.UncorrectState;
import it.univpm.ProjectOOP.Exception.UnlogicalDate;
import it.univpm.ProjectOOP.model.Date;
import it.univpm.ProjectOOP.model.Event;
import it.univpm.ProjectOOP.model.filtres.Filtres;

/**
 * Questa classe si occupa di gestire 
 * dei metodi utili per le eccezioni
 * 
 * @author Mazzarini Tommaso
 */
public class ExceptionTool 
{
	Tool tool = new Tool();
	FiltresTool filtresTool = new FiltresTool();
	/**
	 * Metodo che controlla gli stati inseriti dall'utente
	 * @param states : lista degli stati inserita dall'utente
	 * @param stateList : elenco degli stati del messico
	 * @throws UncorrectState : errore nell'inserimento degli stati
	 */
	public void statesControl(String states,List<String> stateList) throws UncorrectState 
	{
		List<String> statesL = filtresTool.setStateListFiltres(states, stateList);
		boolean flag = true;
		for(String s:statesL)
		{
			flag = true;
			for (String l:stateList)
			{
				if (s.equals(l)) flag = false;
			}

		}
		if (flag) throw new UncorrectState();
	}

	/**
	 * Metodo che controlla i generi inseriti dall'utente
	 * @param genres : lista dei generi inserita dall'utente
	 * @param genreList : elenco dei generi
	 * @throws UncorrectGenre : errore nell'inserimento dei generi
	 */
	public void genresControl(String genres,List<String> genreList) throws UncorrectGenre 
	{
		List<String> genresL = filtresTool.setGenreListFiltres(genres, genreList);
		boolean flag = true;
		for(String g:genresL)
		{
			flag = true;
			for (String l:genreList)
			{
				if (g.equals(l)) flag = false;
			}

		}
		if (flag) throw new UncorrectGenre();	
	}

	/**
	 * Metodo che controlla se l'utente ha inserito le date in ordine logico temporale
	 * @param eventList : lista di tutti gli eventi (oggetto Event)
	 * @param startD : data iniziale dell'intervallo di tempo
	 * @param endD : data finale dell'intervallo di tempo
	 * @throws UncorrectDate : errore nel formato delle date
	 */
	public void datesControl(Date startD, Date endD, List<Event> eventList) throws UncorrectDate 
	{
		tool = new Tool();
		List <String> months = new Vector<>();
		months = tool.setMonth();
		
		if (Integer.valueOf(startD.getYear()) < 2020 || 
				Integer.valueOf(endD.getYear()) < 2020 || 
				!months.contains(startD.getMonth()) || 
				!months.contains(endD.getMonth())) throw new UncorrectDate();
	}

	/**
	 * Metodo che controlla se l'utente ha inserito le date in ordine logico temporale
	 * @param eventList : lista di tutti gli eventi (oggetto Event)
	 * @param startD : data iniziale dell'intervallo di tempo
	 * @param endD : data finale dell'intervallo di tempo
	 * @throws UnlogicalDate : errore nell'inserimento delle date 
	 */
	public void logicalControl(Date startD, Date endD, List<Event> eventList) throws UnlogicalDate   
	{
		tool = new Tool();
		String startDate =  startD.getYear() + "-" + tool.monthToNumberConverter(startD.getMonth()) + "-" + startD.getDay();
		String endDate =  endD.getYear() + "-" + tool.monthToNumberConverter(endD.getMonth()) + "-" + endD.getDay();
		
		if (!(tool.dateToInteger(endDate) > tool.dateToInteger(startDate))) throw new UnlogicalDate(); 
	}
	
	/**
	 * 
	 * @param filtres : filtri selezionati dall'utente
	 * @throws EmptyList : lista vuota
	 */
	public void emptyControl(Filtres filtres) throws EmptyList 
	{
		if (filtres.getState().getNumMaxPerState() == 0) throw new EmptyList();
	}
}
