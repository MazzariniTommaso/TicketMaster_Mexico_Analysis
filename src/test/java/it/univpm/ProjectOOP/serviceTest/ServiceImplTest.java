package it.univpm.ProjectOOP.serviceTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.ProjectOOP.Exception.EmptyList;
import it.univpm.ProjectOOP.Exception.UncorrectDate;
import it.univpm.ProjectOOP.Exception.UncorrectGenre;
import it.univpm.ProjectOOP.Exception.UncorrectState;
import it.univpm.ProjectOOP.Exception.UnlogicalDate;
import it.univpm.ProjectOOP.parsing.EventParsing;
import it.univpm.ProjectOOP.parsing.GenreParsing;
import it.univpm.ProjectOOP.parsing.StateParsing;
import it.univpm.ProjectOOP.service.FiltresService;
import it.univpm.ProjectOOP.service.StatsService;
/**
 * Classe test la corretta esecuzione del metodo getStats
 * 
 * @author Merelli Leonardo
 */

@SpringBootTest
class ServiveImplTests {

	/**
	 * Componenti necessari per testare la corretta generazione delle statistiche
	 */
	StatsService serviceStats;
	EventParsing eventParsingStats;
	GenreParsing genreParsingStats;
	
	/**
	 * Componenti necessari per testare la corretta generazione dei filtri
	 */
	FiltresService serviceFiltres;
	EventParsing eventP;
	GenreParsing genreP;
	StateParsing stateP;
	String states;
	String genres;
	String startDate;
	String endDate;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		/**
		 * Componenti necessari per testare la corretta generazione delle statistiche
		 */
		serviceStats = new StatsService();
		eventParsingStats = new EventParsing();
		genreParsingStats = new GenreParsing();
		
		eventParsingStats.setUrl("https://app.ticketmaster.com/discovery/v2/events.json?countryCode=MX&sort=date,asc&size=1&apikey=");
		genreParsingStats.setUrl("https://app.ticketmaster.com/discovery/v2/events.json?countryCode=MX&sort=date,asc&size=1&apikey=");
		eventParsingStats.setPage(1);
		genreParsingStats.setPage(1);	
		
		try 
		{
			eventParsingStats.setEventList();
			genreParsingStats.genreParsing(eventParsingStats.getEventList());
		} catch (ParseException | IOException e) 
		{
			e.printStackTrace();
		}
		
		/**
		 * Componenti necessari per testare la corretta generazione dei filtri
		 */
		serviceFiltres = new FiltresService();
		stateP = new StateParsing();
		eventP = new EventParsing();
		genreP = new GenreParsing();
		states = "Distrito Federal";
		genres = "Theatre";
		startDate = "2022-01-01";
		endDate = "2022-01-31";
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	@DisplayName("Test generazione delle statistiche")
	void testStats() {
		assertTrue(serviceStats.getStats().get(0).getState().equals("Distrito Federal"));
		assertEquals(serviceStats.getStats().get(0).getGenre().get(0).getName(), "Theatre");
	}

	@DisplayName("Test generazione dei filtri")
	@Test
	void testFiltres() throws UncorrectDate, EmptyList, UncorrectState, UncorrectGenre, UnlogicalDate {
		assertEquals(serviceFiltres.getFiltres(states, genres, startDate, endDate).getState().getStateList().get(0),"Distrito Federal");
	}
}
