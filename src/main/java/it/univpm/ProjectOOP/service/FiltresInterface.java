package it.univpm.ProjectOOP.service;

import java.io.IOException;
import java.net.MalformedURLException;
import org.json.simple.parser.ParseException;
import it.univpm.ProjectOOP.Exception.EmptyList;
import it.univpm.ProjectOOP.Exception.UncorrectDate;
import it.univpm.ProjectOOP.Exception.UncorrectGenre;
import it.univpm.ProjectOOP.Exception.UncorrectState;
import it.univpm.ProjectOOP.Exception.UnlogicalDate;
import it.univpm.ProjectOOP.model.filtres.Filtres;

/**
 * Classe service che implementa le chiamate del controller 
 * per gestire le statistiche
 * 
 * @author Mazzarini Tommaso
 */
public interface FiltresInterface 
{
	/**
	 * Metodo che restituisce un oggetto Filtres che elenca gli stati, i generi 
	 * e il lasso di tempo filtrati dall'utente con opportuni dati come 
	 * numero massimo/minimo/medio di eventi 
	 * 
	 * @param states : La lista degli stati fornita dall'utente
	 * @param genres : La lista dei generi fornita dall'utente
	 * @param startDate : La data iniziale dell'intervallo di tempo 
	 * @param endDate : La data finale dell'intervallo di tempo
	 * @return filtres : L'oggetto di tipo Filtres
	 * @throws MalformedURLException : URL errato
	 * @throws ParseException : errore nel parcing
	 * @throws IOException : errore nelle operazioni I/O
	 * @throws UncorrectState : errore nell'inserimento degli stati
	 * @throws UncorrectGenre : errore nell'inserimento dei generi
	 * @throws UncorrectDate : errore nel formato delle date
	 * @throws UnlogicalDate : errore nell'inserimento delle date
	 * @throws EmptyList : lista vuota
	 */
	public Filtres getFiltres(String states, String genres, 
								String startDate, String endDate)
										throws MalformedURLException, ParseException, 
										  IOException, UncorrectState, UncorrectGenre, 
										    UncorrectDate, UnlogicalDate, EmptyList ;
}
