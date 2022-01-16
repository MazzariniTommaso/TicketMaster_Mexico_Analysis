package it.univpm.ProjectOOP.parsing;

import java.util.List;
import java.util.Vector;
import it.univpm.ProjectOOP.model.Event;

/**
 * Classe che effettua il parsing degli stati
 * 
 * @author Merelli Leonardo
 */
public class StateParsing 
{
	/** 
	 * Metodo che restituisce una lista dei nomi degli stati degli eventi
	 * 
	 * @param eventList : lista di tutti gli eventi (oggetto Event)
	 * @return La lista dei nomi degli stati 
	 */
	public List<String> stateParsing(List<Event> eventList) 
	{
		List<String> stateList = new Vector<>();
		
		for (Event e : eventList)
		{
			if (stateList.size()<1 || !stateList.contains(e.getState())) 
				stateList.add(e.getState());
		}
		return stateList;	
	}

}
