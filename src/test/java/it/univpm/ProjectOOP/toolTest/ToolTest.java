package it.univpm.ProjectOOP.toolTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import it.univpm.ProjectOOP.model.Date;
import it.univpm.ProjectOOP.projectTool.Tool;
/**
 * Classe test che si occupa di testare metodi della classe Tool
 * 
 * @author Merelli Leonardo
 */
@SpringBootTest
public class ToolTest 
{
	Tool tool = new Tool();
	Date date;
	Date startDate;
	Date endDate;
	
	@BeforeEach
	void setUp()
	{
		startDate = new Date("2021","June","13");
		endDate = new Date("2022","June","13");
		date = new Date("2025","June","13");
	}

	@DisplayName("Test metodo che confronta le date")
	@Test
	void test1() 
	{
		assertFalse(tool.compareDate(date, startDate, endDate));
	}

	@DisplayName("Test metodo che imposta i giorni per il mese passato")
	@Test
	void test2()
	{
		assertTrue(tool.monthToNumberConverter("January").equals("01"));
	}


}
