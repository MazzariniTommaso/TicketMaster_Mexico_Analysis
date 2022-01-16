package it.univpm.ProjectOOP.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Vector;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import it.univpm.ProjectOOP.model.Event;
import it.univpm.ProjectOOP.model.stats.StatePerStats;
import it.univpm.ProjectOOP.parsing.EventParsing;
import it.univpm.ProjectOOP.parsing.GenreParsing;
import it.univpm.ProjectOOP.parsing.StateParsing;
import it.univpm.ProjectOOP.projectTool.StatsTool;

/**
 * Classe service che implementa le chiamate del controller 
 * per gestire le statistiche
 * 
 * @author Mazzarini Tommaso
 */

@Service
public class StatsService implements StatsInterface
{
	private EventParsing eventP = new EventParsing();
	private GenreParsing genreP = new GenreParsing();
	private StateParsing stateP = new StateParsing();
	
	private List<Event> eventList = new Vector<>();
	private List<String> genreList = new Vector<>();
	List<String> stateList = new Vector<>();
	
	
	@Override
	public List<StatePerStats> getStats() 
	{
		List<StatePerStats> stateStatsList = new Vector<>();

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
		
		StatePerStats state;
		StatsTool statsTool = new StatsTool();
		
		stateList = stateP.stateParsing(eventList);
		
		for (String s: stateList)
		{
			state = new StatePerStats();
			state.setState(s);
			stateStatsList.add(state);
		}

		for (StatePerStats s: stateStatsList)
		{
			s.setTotal(statsTool.getEventPerState(s.getState(), eventList));
			s.setGenre(statsTool.getGenrePerState(s.getState(),genreList,eventList));
			s.setYear(statsTool.getYearPerState(s.getState(),eventList));
		}
		return stateStatsList;
	}

}
