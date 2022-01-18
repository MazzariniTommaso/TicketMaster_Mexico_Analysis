package it.univpm.ProjectOOP.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Vector;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import it.univpm.ProjectOOP.Exception.EmptyList;
import it.univpm.ProjectOOP.Exception.UncorrectDate;
import it.univpm.ProjectOOP.Exception.UncorrectGenre;
import it.univpm.ProjectOOP.Exception.UncorrectState;
import it.univpm.ProjectOOP.Exception.UnlogicalDate;
import it.univpm.ProjectOOP.model.Date;
import it.univpm.ProjectOOP.model.Event;
import it.univpm.ProjectOOP.model.filtres.Filtres;
import it.univpm.ProjectOOP.model.filtres.GenrePerFiltres;
import it.univpm.ProjectOOP.model.filtres.PeriodPerFiltres;
import it.univpm.ProjectOOP.model.filtres.StatePerFiltres;
import it.univpm.ProjectOOP.parsing.EventParsing;
import it.univpm.ProjectOOP.parsing.GenreParsing;
import it.univpm.ProjectOOP.parsing.StateParsing;
import it.univpm.ProjectOOP.projectTool.ExceptionTool;
import it.univpm.ProjectOOP.projectTool.FiltresTool;
import it.univpm.ProjectOOP.projectTool.Tool;

/**
 * Classe service che implementa le chiamate del controller 
 * per gestire i filtri
 * 
 * @author Mazzarini Tommaso
 */
@Service
public class FiltresService implements FiltresInterface
{
	private EventParsing eventP = new EventParsing();
	private GenreParsing genreP = new GenreParsing();
	private StateParsing stateP = new StateParsing();
	private ExceptionTool exTool = new ExceptionTool();

	
	private List<Event> eventList = new Vector<>();
	private List<String> genreList = new Vector<>();
	private List<String> stateList = new Vector<>();

	Tool tool = new Tool();

	public Filtres getFiltres(String states, String genres, String startDate, String endDate) throws UncorrectState, UncorrectGenre, 
																									UncorrectDate, UnlogicalDate, EmptyList  
	{
		Filtres filtres = new Filtres();
		FiltresTool filtresTool = new FiltresTool();

		
			try {
				eventP.setEventList();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		

		eventList = eventP.getEventList();
		genreList = genreP.genreParsing(eventList);
		stateList = stateP.stateParsing(eventList);

		try {
			exTool.statesControl(states,stateList);
			exTool.genresControl(genres,genreList);
		} catch (UncorrectState e) {
			throw new UncorrectState("I seguenti nomi di stato: ["+ states+ "] non sono corretti");
		} catch (UncorrectGenre e) {
			throw new UncorrectGenre("I seguenti nomi di genere: [" + genres+ "] non sono corretti");
		}
		
		StatePerFiltres  state = new StatePerFiltres();
		GenrePerFiltres  genre = new GenrePerFiltres();
		PeriodPerFiltres  period = new PeriodPerFiltres();

		List<String> stateListF = filtresTool.setStateListFiltres(states,stateList);
		List<String> genreListF = filtresTool.setGenreListFiltres(genres,genreList);
		Date startD = new Date();
		Date endD = new Date();

		state.setStateList(stateListF);
		genre.setGenreList(genreListF);

		if (startDate.equals("")) 
			startD = eventList.get(0).getLocalDate();
		else startD = tool.converterDate(startDate);
		if (endDate.equals("")) 
			endD = eventList.get(eventList.size()-1).getLocalDate();
		else endD = tool.converterDate(endDate);

		try {
			exTool.datesControl(startD, endD, eventList);
			exTool.logicalControl(startD, endD, eventList);
			
			period.setStartDate(startD);
			period.setEndDate(endD);

			filtresTool.setNumEventPerState(state, stateListF, genreListF, startD, endD, eventList);
			filtresTool.setNumEventPerGenre(genre, stateListF, genreListF, startD, endD, eventList);
			filtresTool.setNumEventPerPeriod(period, stateListF, genreListF, startD, endD, eventList);
			
		} catch (UncorrectDate e) {
			throw new UncorrectDate("Il formato delle date inserite non è corretto "
										+ "--> Formato corretto:[YYYY-MM-DD]");
		} catch (UnlogicalDate e) {
			throw new UnlogicalDate("Errore nell'ordine di inserimento delle date");
		} catch (EmptyList e) {
			throw new EmptyList("Non è stato trovato alcun evento");
		}

		filtres.setState(state);
		filtres.setGenre(genre);
		filtres.setPeriod(period);

		try {
			exTool.emptyControl(filtres);
		} catch (EmptyList e) {
			throw new EmptyList("Non è stato trovato alcun evento");
		}
		
		return filtres;
	}
}
