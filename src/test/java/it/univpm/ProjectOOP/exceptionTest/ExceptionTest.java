package it.univpm.ProjectOOP.exceptionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import it.univpm.ProjectOOP.Exception.EmptyList;
import it.univpm.ProjectOOP.Exception.UncorrectDate;
import it.univpm.ProjectOOP.Exception.UncorrectState;
import it.univpm.ProjectOOP.model.Date;
import it.univpm.ProjectOOP.model.Event;
import it.univpm.ProjectOOP.model.filtres.Filtres;
import it.univpm.ProjectOOP.model.filtres.StatePerFiltres;
import it.univpm.ProjectOOP.parsing.EventParsing;
import it.univpm.ProjectOOP.parsing.StateParsing;
import it.univpm.ProjectOOP.projectTool.ExceptionTool;

/**
 * Classe Test per verificare la corretta generazione
 * dell'esecuzione del EmptyList exception
 * 
 * @author Merelli Leonardo
 *
 */
class ExceptionTest 
{
	
	Filtres f;
	StatePerFiltres s;
	ExceptionTool exceptionTool;
	EventParsing eventP = new EventParsing();
	StateParsing stateP = new StateParsing();
	List<String> stateList;
	List<Event> eventList;
	String state;
	Date startDate;
	Date endDate;

	@BeforeEach
	void setUp() throws Exception {
		
		//Dati relativi al primo test
		f = new Filtres();
		s = new StatePerFiltres();
		f.setState(s);
		f.getState().setNumMaxPerState(0);
		exceptionTool = new ExceptionTool();
		
		//Dati relativi al secondo test
		state = "aaa";
		stateList = new Vector<>();
		eventList = new Vector<>();
		eventP.setEventList();
		eventList = eventP.getEventList();
		stateList = stateP.stateParsing(eventList);
		
		//Dati relativi al secondo tes
		startDate = new Date("2022", "01", "01");
		endDate = new Date("2021", "01", "01");
	}

	@Test
    @DisplayName("Corretta generazione dell'eccezione EmptyList.")
    void testExceptionEmptyList() 
	{
		assertThrows(EmptyList.class, () -> {exceptionTool.emptyControl(f);});      
    }
	
	@Test
	@DisplayName("Corretta generazione dell'eccezione UncorrectState.")
	void testExceptionUncorrectState() 
	{
		assertThrows(UncorrectState.class, () -> {exceptionTool.statesControl(state,stateList);});
	}
	
	@Test
	@DisplayName("Corretta generazione dell'eccezione UncorrectDate.")
	void testExceptionUncorrectDate() {
		assertThrows(UncorrectDate.class, () -> {exceptionTool.datesControl(startDate, endDate, eventList);});
	}
	
}
