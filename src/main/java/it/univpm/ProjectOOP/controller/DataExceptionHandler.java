package it.univpm.ProjectOOP.controller;


import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import it.univpm.ProjectOOP.Exception.EmptyList;
import it.univpm.ProjectOOP.Exception.UncorrectDate;
import it.univpm.ProjectOOP.Exception.UncorrectGenre;
import it.univpm.ProjectOOP.Exception.UncorrectState;
import it.univpm.ProjectOOP.Exception.UnlogicalDate;
import it.univpm.ProjectOOP.model.exceptions.ExceptionModel;

/**
 * Questa classe si occupa di gestire le eccezioni e di 
 * mandare un messaggio di errore al Client
 * @author Mazzarini Tommaso 
 */
@ControllerAdvice
public class DataExceptionHandler 
{
	/**
	 * Questo metodo gestisce l'eccezione : EmptyList
	 * @param e : errore di tipo EmptyList
	 * @return er : oggetto di tipo ExceptionModel
	 */
	@ExceptionHandler(value = {EmptyList.class})
	public ResponseEntity<ExceptionModel> handleEmptyListException (EmptyList e)
	{
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
		ExceptionModel er=new ExceptionModel (e.getMessage(),badRequest,ZonedDateTime.now());
		return new ResponseEntity<>(er, badRequest);
	}
	
	/**
	 * Questo metodo gestisce l'eccezione : UncorrectState
	 * @param e : errore di tipo UncorrectState
	 * @return er : oggetto di tipo ExceptionModel
	 */
	@ExceptionHandler(value = {UncorrectState.class})
	public ResponseEntity<ExceptionModel> handleUncorrectStateException (UncorrectState e)
	{
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
		ExceptionModel er=new ExceptionModel (e.getMessage(),badRequest,ZonedDateTime.now());
		return new ResponseEntity<>(er, badRequest);
	}
	
	/**
	 * Questo metodo gestisce l'eccezione : UncorrectGenre
	 * @param e : errore di tipo UncorrectGenre
	 * @return er : oggetto di tipo ExceptionModel
	 */
	@ExceptionHandler(value = {UncorrectGenre.class})
	public ResponseEntity<ExceptionModel> handleUncorrectGenreException (UncorrectGenre e)
	{
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
		ExceptionModel er=new ExceptionModel (e.getMessage(),badRequest,ZonedDateTime.now());
		return new ResponseEntity<>(er, badRequest);
	}
	
	/**
	 * Questo metodo gestisce l'eccezione : UncorrectDate
	 * @param e : errore di tipo UncorrectDate
	 * @return er : oggetto di tipo ExceptionModel
	 */
	@ExceptionHandler(value = {UncorrectDate.class})
	public ResponseEntity<ExceptionModel> handleUncorrectDateException (UncorrectDate e)
	{
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
		ExceptionModel er=new ExceptionModel (e.getMessage(),badRequest,ZonedDateTime.now());
		return new ResponseEntity<>(er, badRequest);
	}
	
	/**
	 * Questo metodo gestisce l'eccezione : UnlogicalDate
	 * @param e : errore di tipo UnlogicalDate
	 * @return er : oggetto di tipo ExceptionModel
	 */
	@ExceptionHandler(value = {UnlogicalDate.class})
	public ResponseEntity<ExceptionModel> handleUnlogicalDateException (UnlogicalDate e)
	{
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
		ExceptionModel er=new ExceptionModel (e.getMessage(),badRequest,ZonedDateTime.now());
		return new ResponseEntity<>(er, badRequest);
	}

	
}
