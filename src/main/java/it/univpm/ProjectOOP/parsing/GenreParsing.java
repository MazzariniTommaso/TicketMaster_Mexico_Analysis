package it.univpm.ProjectOOP.parsing;

import java.util.List;
import java.util.Vector;
import org.springframework.stereotype.Service;
import it.univpm.ProjectOOP.model.Event;

/**
 * Classe che effettua il parsing dei generi
 * 
 * @author Merelli Leonardo
 */

@Service
public class GenreParsing extends Connection {

	/** 
	 * Metodo che restituisce una lista dei nomi dei generi degli eventi
	 * 
	 * @param eventList : lista di tutti gli eventi (oggetto Event)
	 * @return La lista di tutti i nomi dei generi 
	 */
	public List<String> genreParsing(List<Event> eventList) 
	{
		List<String> genreList = new Vector<>();
		
		for (Event e : eventList)
		{
			if (genreList.size()<1 || !genreList.contains(e.getGenre())) 
				genreList.add(e.getGenre());
		}
		return genreList;	
	}
}
