package it.univpm.ProjectOOP.model.exceptions;

import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;

/**
 * Questa classe si occupa di gestire la struttura del messaggio delle eccezioni
 * 
 * @author Mazzarini Tommaso
 */
public class ExceptionModel 
{
	private  String message;
	private  HttpStatus status;
	private  ZonedDateTime time;
	
	/**
	 * Costruttore 
	 * @param message : messaggio di errore
	 * @param status : status dell'errore
	 * @param time : istante di tempo in cui è stato commesso l'errore
	 */
	public ExceptionModel (String message, HttpStatus status, ZonedDateTime time) {
		this.message=message;
		this.status=status;
		this.time=time;
	}

	public String getMsg() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public ZonedDateTime getTime() {
		return time;
	}

}
