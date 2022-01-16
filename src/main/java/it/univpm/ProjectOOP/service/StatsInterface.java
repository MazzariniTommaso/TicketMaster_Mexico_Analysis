package it.univpm.ProjectOOP.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.json.simple.parser.ParseException;
import it.univpm.ProjectOOP.model.stats.StatePerStats;

/**
 * Interfaccia che gestisce le statistiche
 * 
 * @author Marrazini Tommaso
 */
public interface StatsInterface 
{
	/**
	 * Metodo che restituisce una lista di oggetti di tipo StatePerStats, 
	 * ovvero lo stato con le varie statistiche sugli eventi, divise per genere e per mese
	 * 
	 * @return stateStatsList : Lista di ogetti di tipo StatePerStats
	 * @throws MalformedURLException
	 * @throws ParseException
	 * @throws IOException
	 */
	public List<StatePerStats> getStats() throws MalformedURLException, ParseException, IOException;
	
	
}
