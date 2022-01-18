package it.univpm.ProjectOOP.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.univpm.ProjectOOP.Exception.EmptyList;
import it.univpm.ProjectOOP.Exception.UncorrectDate;
import it.univpm.ProjectOOP.Exception.UncorrectGenre;
import it.univpm.ProjectOOP.Exception.UncorrectState;
import it.univpm.ProjectOOP.Exception.UnlogicalDate;
import it.univpm.ProjectOOP.model.filtres.Filtres;
import it.univpm.ProjectOOP.model.stats.StatePerStats;
import it.univpm.ProjectOOP.service.FiltresService;
import it.univpm.ProjectOOP.service.StatsService;

/**
 * Questa classe è specializzata nel gestire 
 * le varie chamate dell'utente
 * 
 * @author Mazzarini Tommaso
 */
@RestController
public class EventController
{
	@Autowired
	private StatsService statsService;
	@Autowired
	private FiltresService filtresService;

	/**
	 * Rotta per i filtri
	 * @param states : stati da filtrare
	 * @param genres : generi da filtrare
	 * @param startDate : data iniziale dell'intervallo di tempo da filtrare
	 * @param endDate : data finale dell'intervallo di tempo da filtrare
	 * @return Filtres : oggetto della classe Filtres
	 * @throws MalformedURLException : URL errato
	 * @throws ParseException : errore nel parcing
	 * @throws IOException : errore nelle operazioni I/O
	 * @throws UncorrectState : errore nell'inserimento degli stati
	 * @throws UncorrectGenre : errore nell'inserimento dei generi
	 * @throws UncorrectDate : errore nel formato delle date
	 * @throws UnlogicalDate : errore nell'inserimento delle date
	 * @throws EmptyList : lista vuota
	 */
	@GetMapping("/filtres")
	public ResponseEntity<Filtres> getFiltres(@RequestParam (value = "states", defaultValue = "") String states,
											  @RequestParam (value = "genres", defaultValue = "") String genres,
											  @RequestParam (value = "startDate", defaultValue = "") String startDate,
											  @RequestParam (value = "endDate", defaultValue = "") String endDate) 
																throws MalformedURLException, ParseException, 
																IOException, UncorrectState, UncorrectGenre, 
																UncorrectDate, UnlogicalDate, EmptyList
	{

		return new ResponseEntity<>(filtresService.getFiltres(states,genres,startDate,endDate),HttpStatus.OK);
	}

	/**
	 * Rotta per le statistiche
	 * @return StatePerStats : oggetto della classe StatePerStats
	 * @throws MalformedURLException : URL errato
	 * @throws ParseException : errore nel parcing
	 * @throws IOException : errore nelle operazioni I/O

	 */
	@GetMapping("/stats")
	public ResponseEntity<List<StatePerStats>> getStats() throws MalformedURLException, ParseException, IOException
	{
		return new ResponseEntity<>(statsService.getStats(), HttpStatus.OK);
	}
	
}
