package it.univpm.ProjectOOP.parsingTest;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.ProjectOOP.parsing.EventParsing;

/**
 * Classe test che si occupa di testare il parsing dell'API
 * 
 * @author Merelli Leonardo
 */
@SpringBootTest
public class ParsingTest 
{
	EventParsing eventP;
	
	@BeforeEach
	void setUp()
	{
		eventP = new EventParsing();
		try 
		{
			eventP.setEventList();
		} catch (ParseException | IOException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Verifica del numero di eventi parsati (199)
	 */
	@Test
	@DisplayName("Test numero di eventi parsati (List<Event>)")
	void dimensionTest() 
	{
		assertEquals(199, eventP.getEventList().size());
	}

}
